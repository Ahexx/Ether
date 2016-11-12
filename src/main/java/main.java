import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.ether.Hello.Hello;

/**
 * Created by nikk on 09.11.16.
 */
public class main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	ClassLoader cl = ClassLoader.getSystemClassLoader();
    	URL[] url = ((URLClassLoader)cl).getURLs();
    	for (URL u : url) {
    		System.out.println(u);
    	}
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        Hello bean = (Hello) ctx.getBean("HelloBean2");

        bean.sayHello();
    }

}