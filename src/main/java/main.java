import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ether.Web.URLDownloader;
import pl.ether.Web.interfaces.URLDownloaderI;
import pl.ether.forms.MainForm;


/**
 * Created by nikk on 09.11.16.
 */
public class main{

   

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        MainForm mf = (MainForm) ctx.getBean("MainWindow");
        mf.run(args);
        
        URLDownloader ud = new URLDownloader();
        ud.setUrl("http://www.google.pl");
        System.out.println(ud.countHash());

        
    }

}