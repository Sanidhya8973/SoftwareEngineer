package _0__Hibernate._02__main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import _0__Hibernate._01__config.HibernateConfig;

public class Main {

    public static void main(String[] args) {

        // Method - 1: xml based configurations
        Configuration cfg = new Configuration();
        cfg.configure("/com/company/project/config/hibernate.cfg.xml");
        SessionFactory sessionFactory1 = cfg.buildSessionFactory();
        System.out.println(sessionFactory1);

        // Method - 2: xml based configurations
        var sessionFactory2 = new Configuration().configure("/com/company/project/config/hibernate.cfg.xml").buildSessionFactory();
        System.out.println(sessionFactory2);

        // Method - 3: java based configurations
        SessionFactory sessionFactory3 = HibernateConfig.getSessionFactory();
        System.out.println(sessionFactory3);

    }

}
