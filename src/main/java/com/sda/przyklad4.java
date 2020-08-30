package com.sda;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class przyklad4 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    NativeQuery<Country> nativeQuery = session.createNativeQuery(
        "Select * from Country where co_id > :id",
        Country.class
    ).setParameter("id", 70);
    nativeQuery.getResultList().forEach(System.out::println);
    session.close();
  }

}
