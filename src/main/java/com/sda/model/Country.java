package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Country {

  public Country(String name, String alias) {
    this.name = name;
    this.alias = alias;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CO_ID")
  private int id;
  @Column(name = "CO_NAME")
  private String name;
  @Column(name = "CO_ALIAS")
  private String alias;

}
