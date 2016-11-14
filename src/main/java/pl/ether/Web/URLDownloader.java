package pl.ether.Web;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import pl.ether.models.ValidationLevel;
import pl.ether.models.WebSite;

public class URLDownloader  {

	static Logger log = Logger.getLogger(URLDownloader.class.getName());
	private WebSite current;
	private String pageSource;
	public void setWebSite(WebSite tmp) {
		current = tmp;
	}
	public static String getPageSource(WebSite w) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(w.getURL());
			URLConnection uc = url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
			int r = 0;
			while ((r = bis.read()) != -1) {
				sb.append((char)r);
			}
			bis.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public boolean isPageChangedFastCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String countHash(String pagesrc) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			hash = new String(md.digest(pagesrc.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}

	public static boolean isTimeToRefresh(WebSite w) {
		
		LocalDateTime tmp = w.getModyficationDate().plusMinutes(w.getRefreshInterval());
		int res = tmp.compareTo(LocalDateTime.now());
		
		if (res == -1) {
			
			log.info("Check started at: " + LocalDateTime.now());
			log.info("\t"+w);
			log.info("\tCompare result : " + res);
			return true;
		}
		
		return false;
	}

	public static boolean checkWebSite(WebSite w) {
		String pageSrc = URLDownloader.getPageSource(w);
		boolean retn = false;
		if (w.getValidationLevel() == ValidationLevel.ALL) {
			retn = URLDownloader.check(w,pageSrc,() -> {
				String hash = URLDownloader.countHash(pageSrc);
				if (!hash.equals(w.getHash())) {
					log.info("Co� si� zmieni�o na: " + w.getName());
					w.setHash(hash);
					return true;
				}
				return false;
			});
		} else if (w.getValidationLevel() == ValidationLevel.BODY) {
			retn = URLDownloader.check(w, pageSrc, () -> {
				Document doc = Jsoup.parse(pageSrc);
				String hash = URLDownloader.countHash(doc.body().toString());
				if (!hash.equals(w.getHash())) {
					log.info("Co� si� zmieni�o na [body]: " + w.getName());
					w.setHash(hash);
					return true;
				}
				return false;
			});
		} else if (w.getValidationLevel() == ValidationLevel.BODY_TEXT) {
			retn = URLDownloader.check(w, pageSrc, () -> {
				String hash = URLDownloader.countHash(Jsoup.parse(pageSrc).body().text());
				if (!hash.equals(w.getHash())) {
					log.info("Co� si� zmieni�o na [body_text] : " + w.getName());
					w.setHash(hash);
					return true;
				}
				return false;
			});
		}
		
		return retn;
	}
	private static boolean check(WebSite w,String page , Supplier<Boolean> ck) {
		return ck.get();
	}

}
