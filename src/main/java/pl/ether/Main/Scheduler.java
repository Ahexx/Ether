package pl.ether.Main;

import java.time.LocalDateTime;

import pl.ether.Web.URLDownloader;
import pl.ether.forms.Controller;
import pl.ether.models.WebSite;

public class Scheduler {
	public void run() {
		System.out.println("[SCHEDULER] Start at: " + LocalDateTime.now());
		// Przejd� po tabelce i sprawd� strony
		for (int i = 0; i < Controller.WebSiteData.size(); i++) {
			WebSite proccesing = Controller.WebSiteData.get(i);
			if (URLDownloader.isTimeToRefresh(proccesing)) {
				URLDownloader.checkWebSite(proccesing);
				Controller.WebSiteData.set(i, proccesing);
			}
		}
	}
}
