import com.pyw.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
    public static void main(String[] args) {
        String xmlPath = "bean1.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Bean1 bean = (Bean1)applicationContext.getBean("bean1");
        System.out.println(bean);
    }
}
