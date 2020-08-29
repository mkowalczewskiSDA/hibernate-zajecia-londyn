package com.sda;

import com.sda.dao.CountryDao;
import com.sda.model.Country;
import java.util.ArrayList;
import java.util.List;

public class zadanie1 {

  public static void main(String[] args) {
    CountryDao countryDao = new CountryDao();

    List<Country> list = new ArrayList<>();
    list.add(new Country("Niemcy", "DE"));
    list.add(new Country("Rosja", "RUS"));
    list.add(new Country("Ukraina", "UA"));
    list.forEach(countryDao::insert);

    //countryDao.delete(4);

    System.out.println(countryDao.findById(4));

  }

}
