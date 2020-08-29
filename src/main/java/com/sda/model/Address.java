package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

  private int id;
  private String street;
  private String buildingNo;
  private String apartamentNo;
  private String city;
  private String postalCode;

}
