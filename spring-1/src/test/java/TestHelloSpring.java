import com.pyw.HelloSpring;
import com.pyw.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloSpring {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) ac.getBean("helloSpring");
        helloSpring.show();
    }

    @Test
    public void testUser1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User u = (User) ac.getBean("user1");
        System.out.println(u);
    }

    @Test
    public void testUser2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User u = (User) ac.getBean("user2");
        System.out.println(u);
    }
}
