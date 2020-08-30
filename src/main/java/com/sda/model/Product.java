package com.sda.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRO_ID")
  private int id;
  @Column(name = "PRO_NAME")
  private String name;
  @Column(name = "PRO_PRICE")
  private BigDecimal price;
  @Column(name = "PRO_DESCRIPTION")
  private String description;
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
  private Set<Order> orders = new HashSet<>();

  public Product(String name, BigDecimal price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }
}
