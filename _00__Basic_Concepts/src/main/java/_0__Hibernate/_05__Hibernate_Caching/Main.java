package _0__Hibernate._05__Hibernate_Caching;

import _0__Hibernate._05__Hibernate_Caching._02__Second_Level_Cache.HibernateConfig;
import org.hibernate.*;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

        Session session1 = sessionFactory.openSession();
        User u1 = session1.get(User.class, 1);
        session1.close();

        Session session2 = sessionFactory.openSession();
        User u2 = session2.get(User.class, 1);
        session2.close();

        sessionFactory.close();
    }

}
