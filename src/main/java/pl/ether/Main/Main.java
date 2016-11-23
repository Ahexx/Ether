package pl.ether.Main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.collections.FXCollections;
import pl.ether.forms.Controller;
import pl.ether.forms.MainForm;
import pl.ether.models.ValidationLevel;
import pl.ether.models.WebSite;

/**
 * Created by nikk on 09.11.16.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

    	
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        StateService saveService = (StateService) ctx.getBean("StateService");
        //saveService.save(Main.test());
        //stop();
        Controller.webSiteData = FXCollections.observableList(saveService.read());//(ObservableList<WebSite>) saveService.read();
        MainForm mf = (MainForm) ctx.getBean("MainWindow");
        mf.run(args);

        Scheduler scheduler = (Scheduler) ctx.getBean("Scheduler");
        
        

        // Przykład buildera
        WebSite webSite = new WebSite.WebSiteBuilder().setId(1L).setURL("http://").build();
    }

    public static void stop() {
        System.exit(1);
    }
    public static List<WebSite> test() {
    	List<WebSite> lista = new ArrayList<>();
    	WebSite w = new WebSite.WebSiteBuilder().setId(1L).setCreationDate(LocalDateTime.now()).setModyficationDate(LocalDateTime.now())
    			.setRefreshInterval(2).setURL("http://www.money.pl").setValidationLevel(ValidationLevel.BODY).build();
    	
    	lista.add(w);
    	
    	w = new WebSite.WebSiteBuilder().setId(2L).setCreationDate(LocalDateTime.now()).setModyficationDate(LocalDateTime.now())
    			.setRefreshInterval(5).setURL("http://www.wp.pl").setValidationLevel(ValidationLevel.BODY).build();
    	
    	lista.add(w);
    	w = new WebSite.WebSiteBuilder().setId(3L).setCreationDate(LocalDateTime.now()).setModyficationDate(LocalDateTime.now())
    			.setRefreshInterval(8).setURL("http://www.bird.pl").setValidationLevel(ValidationLevel.BODY).build();
    	lista.add(w);
    	return lista;
    }
}