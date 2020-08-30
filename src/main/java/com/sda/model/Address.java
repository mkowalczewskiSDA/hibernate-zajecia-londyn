package com.sda.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "country")
@ToString(exclude = "country")
public class Address implements ModelClass {

  public Address(String street, String buildingNo, String apartamentNo, String city,
      String postalCode, Country country) {
    this.street = street;
    this.buildingNo = buildingNo;
    this.apartamentNo = apartamentNo;
    this.city = city;
    this.postalCode = postalCode;
    this.country = country;
  }

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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
  private Country country;

}
