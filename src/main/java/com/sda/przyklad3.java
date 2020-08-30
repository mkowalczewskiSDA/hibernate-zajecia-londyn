package com.sda;

import com.sda.model.Address;
import com.sda.util.HibernateUtil;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class przyklad3 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Address> query = session.createQuery("select a from Address a where a.city=:city"
        , Address.class).setParameter("city", "Londyn").;
    List<Address> list = query.getResultList();
    list.forEach(System.out::println);
    session.close();
    System.out.println(list.get(0).getCountry().getName());

    /*Query<Address> query1 = session.createQuery("select a from Address a join fetch a.country c where a.city=:city",
        Address.class).setParameter("city", "Londyn");
    List<Address> list2 = query.
        getResultList();

    System.out.println(list2.get(0).getCountry());*/
    //query1.getResultList().forEach(System.out::println);

  }

}
