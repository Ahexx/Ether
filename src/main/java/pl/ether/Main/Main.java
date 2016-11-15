package pl.ether.Main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.ether.forms.Controller;

/**
 * Created by nikk on 09.11.16.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Controller ctrl = new Controller();
        ctrl.initialize();
        // log.info("Controller createrd");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        //  log.info("Context done!");
        //MainForm mf = (MainForm) ctx.getBean("MainWindow");
        //mf.run(args);

        Scheduler s = (Scheduler) ctx.getBean("Scheduler");
        //log.info("Scheduler started!");
//        URLDownloaderImpl ud = new URLDownloaderImpl();
//        ud.setUrl("http://www.google.pl");
//        System.out.println(ud.countHash());
    }
}