import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 此类用于演示Spring的新注解
 * @Configuration
 * @Bean()
 * @import()
 * @ComponentScan
 * @PropertySource()
 * */



@Configuration // 此注解标志该类是Spring的核心配置类 创建容器是从此类加载

@ComponentScan("com.kuang.service")  //相当于<context:component-scan base-package="com.kuang.service"/>

@Import({SpringConfiguration1.class}) //导入其他配置类，相当于<import resource="">
//@Import({SpringConfiguration1.class,XXX.class,YYY.class})  加载多个文件类
public class SpringConfiguration1 {



}
