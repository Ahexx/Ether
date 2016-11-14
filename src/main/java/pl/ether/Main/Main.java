package pl.ether.Main;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ether.forms.Controller;
import pl.ether.forms.MainForm;

import pl.ether.Web.URLDownloader;
import pl.ether.Web.interfaces.URLDownloaderI;
import pl.ether.forms.MainForm;


/**
 * Created by nikk on 09.11.16.
 */
public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

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
//        URLDownloader ud = new URLDownloader();
//        ud.setUrl("http://www.google.pl");
//        System.out.println(ud.countHash());

        

    }
}