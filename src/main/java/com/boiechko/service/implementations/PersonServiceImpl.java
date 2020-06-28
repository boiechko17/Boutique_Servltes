package com.boiechko.service.implementations;

import com.boiechko.dao.implementations.PersonDaoImpl;
import com.boiechko.dao.interfaces.PersonDao;
import com.boiechko.entity.Person;
import com.boiechko.service.interfaces.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao = new PersonDaoImpl();

    @Override
    public Person getPersonByCredentials(String column, String credentials) { return personDao.getPersonByCredentials(column, credentials); }

    @Override
    public boolean add(Person person) {
        return personDao.add(person);
    }

    @Override
    public Person getById(int id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public boolean update(Person person) { return personDao.update(person); }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
