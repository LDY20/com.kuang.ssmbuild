import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;

public class DataSourceTest {





    @Test
    //测试手动创建 c3p0数据源
    public void test() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");//mysql8.0以前的版本使用com.mysql.jdbc.Driver,且需要加时区
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/davidtest?serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection connection = dataSource.getConnection();//使用数据源获取连接资源
        System.out.println(connection);
        connection.close();



    }


    @Test
    //测试手动创建 Druid数据源
    public void test2() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/davidtest?serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();




    }
}
