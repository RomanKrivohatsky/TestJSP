package com.rom4.departments.utils;

import org.hibernate.SessionFactory;


/**
 * Created by rom4 on 16.07.14.
 * Creation time 11:59
 * Project name Departments
 */
public class HibernateUtil {
   private static final SessionFactory sessionFactory = null;

    /*
    private static  SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory(
                    new StandardServiceRegistryBuilder().build() );
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            System.err.println(ex.getCause());
            throw new ExceptionInInitializerError(ex);
        }
    }*/

  /*  static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
             configuration.configure();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();


            // A SessionFactory is set up once for an application// configures settings from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }*/

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
