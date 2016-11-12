import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by nikk on 09.11.16.
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//    	ClassLoader cl = ClassLoader.getSystemClassLoader();
//    	URL[] url = ((URLClassLoader)cl).getURLs();
//    	for (URL u : url) {
//    		System.out.println(u);
//    	}
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");

//        Hello bean = (Hello) ctx.getBean("HelloBean2");

//        bean.sayHello();

        launch(args);
    }

}