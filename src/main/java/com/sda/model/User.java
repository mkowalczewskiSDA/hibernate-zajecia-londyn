package com.sda.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class User implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USR_ID")
  private int id;
  @Column(name = "USR_FIRST_NAME")
  private String firstName;
  @Column(name = "USR_LAST_NAME")
  private String lastName;
  @Column(name = "USR_PASSWORD")
  private String password;
  @Column(name = "USR_EMAIL")
  private String email;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
  private Address address;
  @Column(name = "USR_BIRTH_DATE")
  private LocalDate birthDate;
  @Transient
  private String fullName;

  public String getFullName(){
    return firstName+" "+lastName;
  }

}
