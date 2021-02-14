package com.enigma.library;

import com.enigma.library.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            configuration.addAnnotatedClass(BukuKita.class);
            configuration.addAnnotatedClass(Borrow.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(SendBack.class);
            configuration.addAnnotatedClass(User.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }


}
