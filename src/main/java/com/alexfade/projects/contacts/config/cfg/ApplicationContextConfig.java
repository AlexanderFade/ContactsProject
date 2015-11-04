package com.alexfade.projects.contacts.config.cfg;

import com.alexfade.projects.contacts.dao.*;
import com.alexfade.projects.contacts.domain.Email;
import com.alexfade.projects.contacts.domain.Phone;
import com.alexfade.projects.contacts.domain.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.portlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Alexander Kovalevsky on 29.08.15.
 * Project name: ContactsProject
 */

@Configuration
@ComponentScan("com.alexfade.projects.contacts")
@EnableTransactionManagement
public class ApplicationContextConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("UTF-8");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contacts?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("RswbN6uVnA");

        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addProperties(getHibernateProperties());

        sessionBuilder.addAnnotatedClasses(User.class);
        sessionBuilder.addAnnotatedClasses(Phone.class);
        sessionBuilder.addAnnotatedClasses(Email.class);


        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Autowired
    @Bean(name = "userDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory) {
        return new UserDAOImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "phoneDAO")
    public PhoneDAO getPhoneDao(SessionFactory sessionFactory) {
        return new PhoneDAOImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "phoneDAO")
    public EmailDAO getEmailDao(SessionFactory sessionFactory) {
        return new EmailDAOImpl(sessionFactory);
    }
}
