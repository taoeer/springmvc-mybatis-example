package top.taoeer.simplecms.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "top.taoeer.simplecms")
@MapperScan("top.taoeer.simplecms.mapper")
@PropertySource("classpath:db.properties")
public class WebConfig {

    @Value("${jdbcUrl}")
    public String jdbcUrl;

    @Value("${user}")
    public String jdbcUser;

    @Value("${password}")
    public String password;

    @Value("${driverClass}")
    public String driverClass;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(jdbcUser);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
