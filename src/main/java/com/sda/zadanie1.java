package com.sda;

import com.sda.dao.CountryDao;
import com.sda.dao.GenericDao;
import com.sda.model.Address;
import com.sda.model.Country;
import java.util.ArrayList;
import java.util.List;

public class zadanie1 {

  public static void main(String[] args) {
    CountryDao countryDao = new CountryDao();
    GenericDao<Country> countryGenericDao = new GenericDao<>(Country.class);
    GenericDao<Address> addressGenericDao = new GenericDao<>(Address.class);

    List<Country> list = new ArrayList<>();
    list.add(new Country("Niemcy", "DE"));
    list.add(new Country("Rosja", "RUS"));
    list.add(new Country("Ukraina", "UA"));
    list.forEach(countryDao::insert);

    //countryDao.delete(4);

    System.out.println(countryDao.findById(4));
    System.out.println(countryGenericDao.findById(10));
    System.out.println(addressGenericDao.findById(2));

    countryGenericDao.insert(new Country("Irlandia", "IR"));
    //countryGenericDao.delete(new Country(20));
    countryGenericDao.update(new Country(19, "FI", "Finlandia" ));

    countryDao.getAll().forEach(System.out::println);
    countryDao.getAllNames().forEach(System.out::println);
    countryDao.getGroupedBy().forEach(objects -> System.out.println(objects[0] + " "+ objects[1]));


  }

}
