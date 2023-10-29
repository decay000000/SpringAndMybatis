import com.pyw.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserController userController=(UserController)ac.getBean("userController");
        userController.save();
    }
}
