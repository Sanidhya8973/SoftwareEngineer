package _0__Hibernate._05__Hibernate_Caching._03__Query_Level_Cache;

import _0__Hibernate._05__Hibernate_Caching.User;
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
            Supplier<Properties> supplyProperties = () -> {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.USE_QUERY_CACHE, true);
                properties.put(Environment.USE_SECOND_LEVEL_CACHE, true);
                properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
                properties.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/hibernate_caching?useSSL=false");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, true);
                properties.put(Environment.FORMAT_SQL, true);
                return properties;
            };
            Configuration cfg = new Configuration();
            Properties properties = supplyProperties.get();

            cfg.setProperties(properties);
            cfg.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}

