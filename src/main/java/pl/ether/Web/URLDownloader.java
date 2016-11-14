package pl.ether.Web;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import pl.ether.Web.interfaces.URLDownloaderI;

public class URLDownloader implements URLDownloaderI {

	private String url;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageSource() {
		StringBuilder sb = new StringBuilder();
		try {
			URL link = new URL(this.url);
			URLConnection uc = link.openConnection();
			BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
			
			int r = 0;
			while ((r = bis.read()) != -1) {
				sb.append((char)r);
			}
			//System.out.println(sb.toString());
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

	public String countHash() {
		// TODO Auto-generated method stub
		return getPageSource().hashCode() + "";
	}
}
