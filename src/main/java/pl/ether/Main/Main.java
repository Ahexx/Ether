package pl.ether.Main;
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

    public static void main(String[] args) {
    	 Controller ctrl = new Controller();
         ctrl.initialize();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");

        //MainForm mf = (MainForm) ctx.getBean("MainWindow");
        //mf.run(args);
       
        Scheduler s = (Scheduler) ctx.getBean("Scheduler");
        
//        URLDownloader ud = new URLDownloader();
//        ud.setUrl("http://www.google.pl");
//        System.out.println(ud.countHash());

        

    }
}