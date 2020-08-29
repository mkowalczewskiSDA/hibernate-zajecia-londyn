package com.sda.dao;

import com.sda.model.ModelClass;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class GenericDao<T extends ModelClass> {

  Session session;

  final Class<T> classParameter;

  public GenericDao(Class<T> classParameter) {
    this.classParameter = classParameter;
  }

  Session openSession() { return HibernateUtil.getSessionFactory().openSession();
  }

  public T findById(int id){
    Session session = openSession();
    T t = session.find(classParameter, id);
    session.close();
    return t;
  }

  public void insert(T t) {
    Session session = openSession();
    session.beginTransaction();
    session.persist(t);
    session.flush();
    session.close();
  }

  public void delete(T t) {
    Session session = openSession();
    session.beginTransaction();
    session.delete(t);
    session.flush();
    session.close();
  }

  public void update(T t) {
    Session session = openSession();
    session.beginTransaction();
    if (findById(t.getId()) != null) {
      session.merge(t);
    }
    session.flush();
    session.close();
  }

}
