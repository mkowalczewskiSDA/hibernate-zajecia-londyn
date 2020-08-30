package com.sda;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class przyklad5 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Country> list = session.createNamedQuery("country.select",
        Country.class)
        .setParameter("name", "Ukraina")
        .getResultList();
    list.forEach(System.out::println);

    list = session.createNamedQuery("country.selectByAlias", Country.class)
        .setParameter("alias", "FR")
        .getResultList();
    list.forEach(System.out::println);
  }

}
