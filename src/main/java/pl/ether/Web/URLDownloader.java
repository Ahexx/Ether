package pl.ether.Web;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import pl.ether.models.WebSite;

public class URLDownloader  {

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
		System.out.println("Check started at: " + LocalDateTime.now());
		System.out.println(w);
		LocalDateTime tmp = w.getModyficationDate().plusMinutes(w.getRefreshInterval());
		int res = tmp.compareTo(LocalDateTime.now());
		if (res == -1) 
			return true;
		
		return false;
	}

	public static boolean checkWebSite(WebSite w) {
		String pageSrc = URLDownloader.getPageSource(w);
		String hash  = URLDownloader.countHash(pageSrc);
		if (!hash.equals(w.getHash())) {
			w.setHash(hash);
			// Zmieniæ na tray
			System.out.println("COŒ siê zmieni³o na: " + w.getName());
		}
		return false;
	}

}
