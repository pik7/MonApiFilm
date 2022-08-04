package com.sergealbert.apifilm.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try{
            //ICI dans le constructeur, on créé la configuration en se servant automatiquement du ficher hibernate.hbm.xml
            //et la configuration est exploitable grace à l'objet SessionFactory qui est 
            Configuration conf = new Configuration();
            conf.configure();
            ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            
            sessionFactory = conf.buildSessionFactory(serviceReg);
        }catch(Throwable ex){
            System.err.println("Initial SessionFactory creation failed."+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
