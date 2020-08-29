package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements ModelClass {

  public Country(String name, String alias) {
    this.name = name;
    this.alias = alias;
  }

  public Country(int id) {
    this.id = id;
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
