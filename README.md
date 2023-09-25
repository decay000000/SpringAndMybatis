# mybatis_java

## 介绍
这是我在学校学习mybatis框架时所使用的项目工程，在此记录我遇到的问题和解决方法与新的发现<br>
ps:因为本人只用过idea，所以大部分的解决操作步骤都是针对idea的。

## 关于

## 关于resources包下配置文件识别不到问题
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
将resources包标记为资源文件。<br>
右键resources文件夹，选择Mark Directory as进行设置
