import com.pyw.pojo.Customer;
import com.pyw.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerTest {
    @Test
    public void findCustomerByNameAndJobTest(){
        SqlSession session = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("j");
        customer.setJobs("doctor");
        List<Customer> customers = session.selectList("findCustomerByNameAndJobs", customer);
        for(Customer customer1:customers){
            System.out.println(customer1.toString());
        }
        session.close();
    }
    @Test
    public void findCustomerByNameOrJobTest(){
        SqlSession session = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("rose");
        customer.setJobs("teacher");
        List<Customer> customers = session.selectList("findCustomerByNameOrJobs", customer);
        for(Customer customer1:customers){
            System.out.println(customer1.toString());
        }
        session.close();
    }
    @Test
    public void findCustomerByNameAndJobsTagByWhereTest(){
        SqlSession session = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("r");
        customer.setJobs("driver");
        List<Customer> customers = session.selectList("findCustomerByNameAndJobsTagByWhere", customer);
        for(Customer customer1:customers){
            System.out.println(customer1.toString());
        }
        session.close();
    }
    @Test
    public void updateCustomerBySetTest(){
        SqlSession session = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("13888888888");
        int rows = session.update("updateCustomerBySet",customer);
        if (rows>0) {
            System.out.println("成功修改" + rows + "条数据");
        }else{
            System.out.println("修改失败");
        }
        session.commit();
        session.close();
    }
    @Test
    public void findByArrayTest(){
        SqlSession session = MyBatisUtils.getSession();
        Integer[] roleIds = {2,3};
        List<Customer> customers = session.selectList("findByArray",roleIds);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    @Test
    public void findByListTest(){
        SqlSession session = MyBatisUtils.getSession();
        ArrayList<String> names = new ArrayList<String>();
        names.add("jake");
        names.add("rose");
        List<Customer> customers = session.selectList("findByList",names);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    @Test
    public void findByListTestObject(){
        SqlSession session = MyBatisUtils.getSession();
        ArrayList<Customer> names = new ArrayList<Customer>();
        Customer customer1 = new Customer();
        customer1.setUsername("joy");
        Customer customer2 = new Customer();
        customer2.setUsername("rose");
        names.add(customer1);
        names.add(customer2);
        List<Customer> customers = session.selectList("findByListOfObject",names);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    @Test
    public void findByMapTest(){
        SqlSession session = MyBatisUtils.getSession();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("id", ids);
        conditionMap.put("jobs", "r");
        List<Customer> customers = session.selectList("findByMap",conditionMap);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
