package pl.ether.Main;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ether.Web.URLDownloaderImpl;
import pl.ether.forms.Controller;
import pl.ether.models.WebSite;

import java.time.LocalDateTime;


public class Scheduler {
    public void run() {
        System.out.println("\n[SCHEDULER] Start at: " + LocalDateTime.now());
        // Przejdz po tabelce i sprawdz strony
//        for (int i = 0; i < Controller.WebSiteData.size(); i++) {
//            WebSite proccesing = Controller.WebSiteData.get(i);
//            if (URLDownloaderImpl.isTimeToRefresh(proccesing)) {
//                URLDownloaderImpl.checkWebSite(proccesing);
//                Controller.WebSiteData.set(i, proccesing);
//            }
//        }
    }
}