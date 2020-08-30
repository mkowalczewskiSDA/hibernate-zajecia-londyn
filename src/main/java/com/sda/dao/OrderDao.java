package com.sda.dao;

import com.sda.model.Order;

public class OrderDao extends GenericDao<Order> {

  public OrderDao() {
    super(Order.class);
  }

}
