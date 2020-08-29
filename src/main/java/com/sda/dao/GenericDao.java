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

  void openSession() { session = HibernateUtil.getSessionFactory().openSession();
  }

  public T findById(int id){
    openSession();
    T t = session.find(classParameter, id);
    session.close();
    return t;
  }

  public void insert(T t) {
    openSession();
    session.beginTransaction();
    session.persist(t);
    session.flush();
    session.close();
  }

  public void delete(T t) {
    openSession();
    session.beginTransaction();
    session.delete(t.getId());
    session.flush();
    session.close();
  }

}
