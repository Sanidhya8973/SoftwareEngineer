package _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.bidirectional_flow.config;

import _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.bidirectional_flow.model.Answer;
import _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.bidirectional_flow.model.Question;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
import java.util.function.Supplier;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            Supplier<Properties> properties = () -> {
                Properties property = new Properties();
                property.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
                property.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://127.0.0.1:3306/hibernate_many2one_relationship?useSSL=false");
                property.put(Environment.JAKARTA_JDBC_USER, "root");
                property.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
                property.put(Environment.HBM2DDL_AUTO, "create");
                // property.put(Environment.HBM2DDL_AUTO, "update");
                property.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                property.put(Environment.SHOW_SQL, "true");
                property.put(Environment.FORMAT_SQL, "false");
                return property;
            };

            Configuration cfg = new Configuration();

            cfg.setProperties(properties.get());
            cfg.addAnnotatedClass(Question.class);
            cfg.addAnnotatedClass(Answer.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;

    }

}
