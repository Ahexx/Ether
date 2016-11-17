package pl.ether.Web;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.ether.models.ValidationLevel;
import pl.ether.models.WebSite;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class URLDownloaderImpl {

    private static final Logger log = Logger.getLogger(URLDownloaderImpl.class);

    private WebSite current;
    private String pageSource;

    public void setWebSite(WebSite tmp) {
        current = tmp;
    }

    public static String getPageSource(WebSite site) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(site.getURL());
            URLConnection uc = url.openConnection();
            BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
            int r = 0;
            while ((r = bis.read()) != -1) {
                sb.append((char) r);
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

    public static boolean isTimeToRefresh(WebSite site) {

        LocalDateTime tmp = site.getModificationDate().plusMinutes(site.getRefreshInterval());
        int res = tmp.compareTo(LocalDateTime.now());

        if (res == -1) {

            log.info("Check started at: " + LocalDateTime.now());
            log.info("\t" + site);
            log.info("\tCompare result : " + res);
            return true;
        }

        return false;
    }

    public static boolean checkWebSite(WebSite site) {
        String pageSrc = URLDownloaderImpl.getPageSource(site);
        boolean retn = false;
        if (site.getValidationLevel() == ValidationLevel.ALL) {
            retn = URLDownloaderImpl.check(site, pageSrc, () -> {
                String hash = URLDownloaderImpl.countHash(pageSrc);
                if (!hash.equals(site.getHash())) {
                    log.info("Coś się zmieniło na: " + site.getName());
                    site.setHash(hash);
                    return true;
                }
                return false;
            });
        } else if (site.getValidationLevel() == ValidationLevel.BODY) {
            retn = URLDownloaderImpl.check(site, pageSrc, () -> {
                Document doc = Jsoup.parse(pageSrc);
                String hash = URLDownloaderImpl.countHash(doc.body().toString());
                if (!hash.equals(site.getHash())) {
                    log.info("Coś się zmieniło na [body]: " + site.getName());
                    site.setHash(hash);
                    return true;
                }
                return false;
            });
        } else if (site.getValidationLevel() == ValidationLevel.BODY_TEXT) {
            retn = URLDownloaderImpl.check(site, pageSrc, () -> {
                String hash = URLDownloaderImpl.countHash(Jsoup.parse(pageSrc).body().text());
                if (!hash.equals(site.getHash())) {
                    log.info("Coś się zmieniło na [body_text] : " + site.getName());
                    site.setHash(hash);
                    return true;
                }
                return false;
            });
        }

        return retn;
    }

    private static boolean check(WebSite site, String page, Supplier<Boolean> ck) {
        return ck.get();
    }
}