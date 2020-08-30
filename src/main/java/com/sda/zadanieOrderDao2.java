package com.sda;

import com.sda.dao.GenericDao;
import com.sda.dao.OrderDao;
import com.sda.model.Order;

public class zadanieOrderDao2 {

  public static void main(String[] args) {
    OrderDao orderDao = new OrderDao();
    //GenericDao<Order> genericDao = new GenericDao<>(Order.class);
    //System.out.println(genericDao.findById(2));
    System.out.println(orderDao.findById(2));
  }

}
