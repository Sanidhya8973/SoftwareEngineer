package _0__Hibernate._01__Ways_To_Configure_Hibernate.config;

import _0__Hibernate._02__Hibernate_Annotations.model.Address;
import _0__Hibernate._02__Hibernate_Annotations.model.Certificate;
import _0__Hibernate._02__Hibernate_Annotations.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            Properties property = new Properties();
            property.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
            property.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://127.0.0.1:3306/hibernate_db?useSSL=false");
            property.put(Environment.JAKARTA_JDBC_USER, "root");
            property.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
            property.put(Environment.HBM2DDL_AUTO, "create");
            //property.put(Environment.HBM2DDL_AUTO, "update");
            property.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            property.put(Environment.SHOW_SQL, true);
            property.put(Environment.FORMAT_SQL, true);
            cfg.setProperties(property);

            cfg.addAnnotatedClass(Employee.class);
            cfg.addAnnotatedClass(Certificate.class);
            cfg.addAnnotatedClass(Address.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}
