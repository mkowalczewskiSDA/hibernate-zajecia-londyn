package com.sda.dao;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

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
   return null;
  }

  public List<Country> getAllPaginated(){
    return null;
  }
}
