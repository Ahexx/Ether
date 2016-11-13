import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.ether.forms.MainForm;


/**
 * Created by nikk on 09.11.16.
 */
public class main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");

        MainForm mf = (MainForm) ctx.getBean("MainWindow");
        mf.run(args);
    }
}