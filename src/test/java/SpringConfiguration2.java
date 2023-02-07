import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@PropertySource("classpath:database.properties")  //相当于<context:property-placeholder location="classpath:database.properties"/>

public class SpringConfiguration2 {

    /* @Value("${jdbc.driver}")
    private String driver; */

    @Bean("dataSource")  //此注解会将当前方法的返回值以指定名称存储到Spring中
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("${jdbc.Driver}");//mysql8.0以前的版本使用com.mysql.jdbc.Driver,且需要加时区
        //dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("${jdbc.url}");
        dataSource.setUser("${jdbc.username}");
        dataSource.setPassword("${jdbc.password}");
        return dataSource;

    }
}
