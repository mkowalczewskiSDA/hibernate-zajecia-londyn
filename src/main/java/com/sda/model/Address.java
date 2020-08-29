package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ADD_ID")
  private int id;
  @Column(name = "ADD_STREET")
  private String street;
  @Column(name = "ADD_BUILDING_NO")
  private String buildingNo;
  @Column(name = "ADD_APARTAMENT_NO")
  private String apartamentNo;
  @Column(name = "ADD_CITY")
  private String city;
  @Column(name = "ADD_POSTAL_CODE")
  private String postalCode;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
  private Country country;

}
