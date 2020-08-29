package com.sda;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class przyklad2 {

  public static void main(String[] args) {
    usePersist();
    //useMerge();
  }

  public static void usePersist() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Country newCountry = new Country();
    newCountry.setName("Wielka Brytania");
    newCountry.setAlias("UK");
    session.persist(newCountry);
    session.flush();
    session.getTransaction().commit();
    session.close();
  }

  public static void useMerge() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Country newCountry = new Country();
    //newCountry.setId(3); można dodawać i aktualizować za pomocą merge
    newCountry.setName("Francja");
    newCountry.setAlias("FR");
    session.merge(newCountry);
    session.flush();
    session.getTransaction().commit();
    session.close();
  }
}
