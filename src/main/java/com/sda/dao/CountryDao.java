package com.sda.dao;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CountryDao {
  Session session;

  public Country findById(int id) {
    session = HibernateUtil.getSessionFactory().openSession();
    Country country = session.find(Country.class, id);
    session.close();
    return country;
  }

  public void insert (Country country) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.persist(country);
    session.flush();
    session.close();
  }

  public void delete (int id) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(new Country(id));
    session.flush();
    session.close();
  }

  public void update (Country country) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    if (findById(country.getId()) != null) {
      session.merge(country);
    }
    session.flush();
    session.close();
  }

  public List<Country> getAll(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Country> query = session.createQuery("Select c from Country c");
    List<Country> list = query.getResultList();
    session.close();
    return list;
  }

  public List<String> getAllNames(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<String> query = session.createQuery("Select c.name from Country c");
    List<String> list = query.getResultList();
    session.close();
    return list;
  }

  public List<Object[]> getGroupedBy(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Object[]> query = session.createQuery("Select max(c.id), c.name from Country c group by c.name");
    List<Object[]> list = query.getResultList();
    session.close();
    return list;
  }

  public List<Country> getAllPaginated(){
    return null;
  }
}
