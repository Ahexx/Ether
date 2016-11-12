import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ether.Hello.Hello;
import pl.ether.forms.MainForm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by nikk on 09.11.16.
 */
public class main{

   

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        MainForm mf = (MainForm) ctx.getBean("MainWindow");
        mf.run(args);


        
    }

}