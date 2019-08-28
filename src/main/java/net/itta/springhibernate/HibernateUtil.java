/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springhibernate;


import net.itta.springhibernate.entities.Personne;
import net.itta.springhibernate.entities.Voiture;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORY;
    private static final ServiceRegistry SERVICEREGISTRY;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            SERVICEREGISTRY= 
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
            //configuration.addPackage("net.itta.springhibernate.entities");           
            configuration.addAnnotatedClass(Voiture.class);
            configuration.addAnnotatedClass(Personne.class);
            SESSIONFACTORY = configuration.buildSessionFactory(SERVICEREGISTRY);
           
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        finally{
            
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSIONFACTORY;
    }
   

    static void destroyServiceRegistry() {
       StandardServiceRegistryBuilder.destroy(SERVICEREGISTRY);
    }
}
