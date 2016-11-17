package pl.ether.Main;

import org.apache.log4j.Logger;
import pl.ether.Web.URLDownloaderImpl;
import pl.ether.forms.Controller;
import pl.ether.models.WebSite;

public class Scheduler {

    private static final Logger logger = Logger.getLogger(Main.class);

    public void run() {

        logger.info("[SCHEDULER] Start");

        // Przejdz po tabelce i sprawdz strony
        for (int i = 0; i < Controller.webSiteData.size(); i++) {
            WebSite webSite = Controller.webSiteData.get(i);
            if (URLDownloaderImpl.isTimeToRefresh(webSite)) {
                URLDownloaderImpl.checkWebSite(webSite);
                Controller.webSiteData.set(i, webSite);
            }
        }

    }
}