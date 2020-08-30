package com.sda;

import com.sda.model.Address;
import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class przyklad0 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Country country1 = new Country();
    country1.setName("Polska");
    country1.setAlias("PL");
    Country country2 = new Country();
    country2.setName("Wielka Brytania");
    country2.setAlias("UK");

    Address address1 = new Address("Marszalkowska", "1", "2", "Warszawa", "00-000", country1);
    Address address2 = new Address("Downing St", "1", null, "Londyn", "xxxxx", country2);

    session.beginTransaction();
    session.persist(country1);
    session.persist(country2);
    session.persist(address1);
    session.persist(address2);
    session.flush();
    session.getTransaction().commit();
    session.close();

  }

}
