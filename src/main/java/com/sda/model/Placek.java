package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Placek {


  @Id
  @Column
  private int id;
  @Column
  private String nazwaPlacka;

}
