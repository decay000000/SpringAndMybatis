import com.pyw.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean bean1 = (Bean) applicationContext.getBean("bean");
        Bean bean2 = (Bean) applicationContext.getBean("bean");
        System.out.println(bean1 == bean2);
    }
}
