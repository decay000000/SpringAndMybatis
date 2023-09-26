import com.pyw.pojo.Orders;
import com.pyw.pojo.Ordersitem;
import com.pyw.pojo.Person;
import com.pyw.pojo.Users;
import com.pyw.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void findPersonByIdTest(){
        SqlSession session = MyBatisUtils.getSession();
        Person person = session.selectOne("findPersonById", 1);
        System.out.println(person.toString());
        session.close();
    }
    @Test
    public void findUserTest(){
        SqlSession session = MyBatisUtils.getSession();
        Users users = session.selectOne("findUserWithOrders", 1);
        System.out.println(users);
        session.close();
    }
    @Test
    public void findOrdersTest(){
        SqlSession session = MyBatisUtils.getSession();
        Ordersitem ordersitem = session.selectOne("findOrdersWithProduct1", 1);
        System.out.println(ordersitem);
        session.close();
    }
}
