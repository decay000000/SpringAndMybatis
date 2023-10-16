# Spring & Mybatis java
# 导航
* [介绍](#介绍)
* 项目所遇到的外在问题和解决方案
  * [工程在其他地方打开maven内容重新下载](#工程在其他地方打开maven内容重新下载)
  * [resources文件夹下配置文件识别不到问题](#resources文件夹下配置文件识别不到问题)
  * [插入汉字乱码](#插入汉字乱码)
* 思考发现与实验
  * [foreach标签下属性值的设置](#foreach标签下属性值的设置)
    * [关于item元素可用类型的思考](#关于item元素可用类型的思考)
  * [Spring中constructor-arg和property注入的区别](#Spring中constructor-arg和property注入的区别)

## 介绍
这是我在学校学习mybatis框架时所使用的项目工程，在此记录我遇到的问题和解决方法与新的发现  
ps:因为本人只用过idea，所以大部分的解决操作步骤都是针对idea的。

## 工程在其他地方打开maven内容重新下载
这个问题出现在我将项目移到机房电脑时出现，当我对pom.xml文件进行Reimport时，相关依赖包被重新下载。  
机房电脑本身应该是不需要下载的（因为我建一个新的项目时就不需要下载），出现这种情况原因可能是两台电脑的maven所在路径不同导致的，一般都是maven地址被人为修改了。
#### 解决方法：
Setting -> Build,Execution,Deployment -> Build Tools -> Maven，然后将Maven home directory、User setting file、Local repository改为与目标电脑一致，建议直接取消勾选Override，可能取消后还是找不到，建议把路径该回去再取消，如果不知道路径可以建一个新项目对照着改。
![setMaven](https://github.com/decay000000/mybatis_java/blob/main/picture/maven_set.png)
因为我先前在下载时出现过好多报错，然后去网上搜解决办法，就把这些改了，然后就懒得改回来了，就出现了这些问题。

## resources文件夹下配置文件识别不到问题
这个问题出现在我将项目移到机房电脑时出现，运行时出现报错，找不到config和mapper，后来发现是pom中没有指定resources，按道理来说哪怕不指定默认也会去target里面找，可事实是并没有，暂时认为原因是因为我的导出方法有问题。
#### 解决方法一：
在pom.xml文件中设置resources部分设置为
```xml
<resources>
  <resource>
    <directory>src/main/resources</directory>
    <includes>
      <include>**/*.properties</include>
      <include>**/*.xml</include>
    </includes>
    <filtering>true</filtering>
  </resource>
</resources>
```
#### 解决方法二：
右键resources文件夹，选择Mark Directory as进行设置，将其标记为资源文件。
![markResources](https://github.com/decay000000/mybatis_java/blob/main/picture/not_find_resources.png)

## 插入汉字乱码
这个问题也是出现在机房电脑上，在使用insert标签做插入时，可以成功插入数据，但是汉字是“？？？”，数据库编码也是utf-8，原因暂时不明，因为在我自己电脑上没有出现这个问题。  
问题呢出在数据库配置文件db.properties上
```
mysql.driver=com.mysql.cj.jdbc.Driver

mysql.url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&

characterEncoding=utf8&useUnicode=true&useSSL=false

mysql.username=root

mysql.password=root
```
#### 解决方法
~~说实话解决方法有点玄学~~
把characterEncoding那句话接在mysql.url后面就行了
```
mysql.driver=com.mysql.cj.jdbc.Driver

mysql.url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false

mysql.username=root

mysql.password=root
```

## Mybaits中foreach标签下属性值的设置
下面三个是我基于三种不同的序列方式，进行的动态SQL组装。
```xml
<!-- 基于数组 -->
<select id="findByArray" parameterType="java.util.Arrays" resultType="customer">
  select * from customer where id in
  <foreach collection="array" index="index" item="id" open="(" separator="," close=")">
    #{id}
  </foreach>
</select>

<!-- 基于列表 -->
<select id="findByList" parameterType="java.util.Arrays" resultType="customer">
  select * from customer where username in
  <foreach collection="list" index="index" item="name" open="(" separator="," close=")">
    #{name}
  </foreach>
</select>

<!-- 基于Map -->
<select id="findByMap" parameterType="java.util.Map" resultType="customer">
  select * from customer where jobs like concat('%',#{jobs},'%') and id in
  <foreach collection="id" index="index" item="roleMap" open="(" separator="," close=")">
    #{roleMap}
  </foreach>
</select>
```
可以看出内容大致时相同，不同的地方只有select标签中parameterType的值和foreach中的各属性的值。parameterType好说，可以简单理解为传入参数的类型，关于foreach部分我自己也不是很懂，就去搜了一下。
* item：集合中元素迭代时的别名
* index：在list、array中，index为元素的序号索引；在Map中，index为遍历元素的key值，该参数为可选项
* open：foreach代码的开始符号
* separator：元素之间的分隔符
* close: foreach代码的关闭符号
* collection: 执行foreach的对象，对象为数组或列表时值为array，对象为Map时属性值为键值  
通过观察上述代码中foreach的结果：
```
(1,2,3)
('jack','rose')
(1,2,3)
```
可以发现这些属性的对应作用，item为迭代时的零时变量，collection为迭代的对象，open为foreach全部输出内容的开头符号，close为foreach全部输出内容的结束符号，separator为循环过程中输出内容之间的间隔符。

### 关于item元素可用类型的思考
既然item可以接受基本数据类型，那是否也可以接受一个类对象呢，所以我将代码部分进行了更改
```xml
<select id="findByListOfObject" parameterType="java.util.Arrays" resultType="customer">
  select * from customer where username in
  <foreach collection="list" index="index" item="customer" open="(" separator="," close=")">
    #{customer.username}
  </foreach>
</select>
```
测试部分的传入参数变成了一个customer类的列表：
```java
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
```
运行测试类，查询成功说明是可行的，我又将customer类换为了user类，依旧可以进行查询。  
由此可以暂时得出foreach中也可以接受一个类序列，并且这个类型可以不与命名空间对象类型相同。

## Spring中constructor-arg和property注入的区别
在学习的过程中开始我用constructor-arg对User类进行构造注入，类里面只有一个全参构造器和一个toString方法，运行时并没有出现异常，而我按部就班继续进行实验时，对类又增加了get和set方法，然后通过property对User类进行设值注入出现了以下报错：
```
警告: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'user2' defined in class path resource [applicationContext.xml]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.pyw.User]: No default constructor found; nested exception is java.lang.NoSuchMethodException: com.pyw.User.<init>()  
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'user2' defined in class path resource [applicationContext.xml]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.pyw.User]: No default constructor found; nested exception is java.lang.NoSuchMethodException: com.pyw.User.<init>()
```
这个报错是因为缺少默认构造方法，当类中有自定义的构造器时，不会自动生成默认的构造方法。  
解决这个问题后我突然在想constructor-arg和property之间有什么区别，这两种注入方式的结果是完全相同的，那就只可能时执行的方式不同了，鉴于前面报错时因为构造器的原因，于是我在两个构造方法和部分set方法中加上一条输出语句，打算通过构造器和set方法入手，观察这两种注入方式区别。
```java
    public void setId(int id) {
        this.id = id;
        System.out.println("通过set设置id");
    }

    public User() { System.out.println("调用默认构造器"); }

    public User(int id, String name, String password) {
        System.out.println("调用全参构造器");
        this.id = id;
        this.name = name;
        this.password = password;
    }
```
在我调用constructor-arg主导的构造注入时，控制台输出了一句“调用全参构造器”，然后我又加了几个含参构造器（非全参），发现它每次都通过参数来精准调用对应的构造方法，当找不到对应构造器的时候会爆出以上错误警告。  
```java
    public User(int id, String name) {
        System.out.println("使用含参构造器");
        this.id = id;
        this.name = name;
    }

运行结果：
使用id，name构造器
User{id=1, name='某某', password='null'}
```
而当我使用property主导的设值注入时，控制台输出了“调用默认构造器”“通过set设置id”，然后我只保留了默认的无参构造方法，并删除了部分set方法，发现也出现了上述报错。  
```java
运行结果：
使用默认构造器
正在通过set设置id
User{id=2, name='谁谁谁', password='******'}
```
于是乎我猜想使用constructor-arg是通过构造器来注入，类似我们通过new+含参构造器的形式来创建并设置对象，对应构造器必须存在；而使用property时，会先调用默认构造方法，然后通过对应的set方法来设置对象的属性值，对应属性的set方法必须存在
