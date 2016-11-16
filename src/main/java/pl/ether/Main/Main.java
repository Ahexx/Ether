package pl.ether.Main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.ether.forms.Controller;
import pl.ether.forms.MainForm;
import pl.ether.models.WebSite;

/**
 * Created by nikk on 09.11.16.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        MainForm mf = (MainForm) ctx.getBean("MainWindow");
        mf.run(args);

        Scheduler s = (Scheduler) ctx.getBean("Scheduler");
        
        // Przykład buildera
        WebSite w = new WebSite.WebSiteBuilder().setId(1l).setURL("http://").build();
        
    }
}