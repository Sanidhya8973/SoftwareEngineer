package _0__Hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateJavaConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            Properties property = new Properties();
            property.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
            property.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://127.0.0.1:3306/school?useSSL=false");
            property.put(Environment.JAKARTA_JDBC_USER, "root");
            property.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
            property.put(Environment.HBM2DDL_AUTO, "update");
            property.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            property.put(Environment.SHOW_SQL, true);
            property.put(Environment.FORMAT_SQL, true);
            cfg.setProperties(property);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}
