import com.pyw.pojo.Person;
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
}
