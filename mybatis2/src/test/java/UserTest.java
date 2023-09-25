import com.mysql.cj.Session;
import com.pyw.pojo.User;
import com.pyw.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void userFindByIdTest(){
        SqlSession session = MyBatisUtils.getSession();
        User user = session.selectOne("findById", 4);
        System.out.println(user.toString());
        session.close();
    }
    @Test
    public void userAddTest(){
        SqlSession session = MyBatisUtils.getSession();
        User user = new User(6, "王八", 25, "副经理");
        int n = session.insert("addUser",user);
        if(n>0){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
        session.commit();
        session.close();
    }
    @Test
    public void userUpdateTest(){
        SqlSession session = MyBatisUtils.getSession();
        User user = new User(5, "孙七", 23, "副经理");
        int n = session.update("updateUser",user);
        if(n>0){
            System.out.println("更改成功");
        }else{
            System.out.println("更改失败");
        }
        session.commit();
        session.close();
    }
    @Test
    public void userDeleteTest(){
        SqlSession session = MyBatisUtils.getSession();
        int n = session.delete("deleteUser",6);
        if(n>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        session.commit();
        session.close();
    }
}
