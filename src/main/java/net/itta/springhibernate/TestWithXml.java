package net.itta.springhibernate;

import java.util.Date;
import java.util.List;

import net.itta.springhibernate.entities.Personne;
import net.itta.springhibernate.entities.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author Administrator
 */
public class TestWithXml {
    public static void main(String[] args) {
      SessionFactory sessionFactory=  HibernateUtil.getSessionFactory();
        //Transaction tx=session.beginTransaction();
        try (Session session = sessionFactory.openSession()) {
           
            NativeQuery<Personne> query =session.createNativeQuery("select * FROM Personnes",Personne.class);
            List<Personne>sp= query.getResultList();
            if (sp.size()>0) {
                Personne p = sp.get(0);
                System.out.println(p); 
                
               // System.out.println(sp.get(0).getVoitures());
            }
          Voiture vv= session.createQuery("from Voiture v where v.proprietaire.id=1", Voiture.class).setMaxResults(1).getSingleResult();
            System.out.println(vv);
            Transaction tx=session.beginTransaction();
            Personne p = new Personne(3, "rono", "sechan",new Date());
            session.save(p);
            vv.setProprietaire(p);
            session.save(vv);
            tx.commit();
            
            tx=session.beginTransaction();
            Personne pp=session.find(Personne.class, 1);
            Voiture po=session.find(Voiture.class, 1);
            System.out.println("*******************************************");
            System.out.println(pp);
            pp.getVoitures().add(po);
            session.save(pp);
            tx.commit();
            
        }
      //System.exit(0);
     //   HibernateUtil.destroyServiceRegistry(); 

      
    }

    static void SelectHQL(Session session) {
        Query query = session.createQuery("FROM Personne p");
        
        List<Personne> sp = query.list();
        
        if(sp.size()>0)
        {
            System.out.println(sp.get(0));
        }
    }
}
