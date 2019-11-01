package com.example.service.discriminator;

import com.example.entity.City;
import com.example.repository.CityRepository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

//@Service
public class CityService {

    //@Autowired
    private CityRepository cityRepository;

    //@PersistenceContext
    public EntityManager entityManager;

    public void save(City city){
        cityRepository.save(city);
    }

    public List<City> getAll() throws SQLException {
        return cityRepository.findAll();
    }

    public City get(Long id){
        return cityRepository.findById(id);
    }

    public City getByName(String name){
        return cityRepository.findByName(name);
    }

    public void delete(String name){
        cityRepository.deleteByName(name);
    }
}
