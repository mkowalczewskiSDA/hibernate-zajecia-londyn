package com.sda;

import com.sda.model.Address;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class przyklad1 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.close();
  }

}
