package com.example.hibernatehw.repositories;

import com.example.hibernatehw.repositories.entity.Persons;
import com.example.hibernatehw.repositories.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomRepository extends JpaRepository<Persons, User> {

    //CRUD
    @Override
    Persons save(Persons persons);

    @Override
    List<Persons> findAllById(Iterable<User> users);

    //Какой метод нужно переопределить для Update ?

    @Override
    void deleteById(User user);

    //findCity
    List<Persons> findByCityOfLivingContains(String cityOfLivingContains);

    //findAge
    List<Persons> findPersonsByUser_AgeGreaterThanOrderByUserAsc(int userAge);

    //findNameSurname
    Optional<Persons> findPersonsByUser_NameAndUser_Surname(String userNameIsIn, String userSurnameIsIn);

}
