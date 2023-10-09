package com.example.hibernatehw.repositories;

import com.example.hibernatehw.repositories.entity.Persons;
import com.example.hibernatehw.repositories.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomRepository extends JpaRepository<Persons, User> {

    //findCity
    @Query("select p from Persons p where p.cityOfLiving = :customCity")
    List<Persons> findByCityOfLivingContains(@Param("customCity") String city);

    //findAge
    @Query(value = "SELECT * FROM PERSONS WHERE AGE > ?1", nativeQuery = true)
    List<Persons> findPersonsByUser_AgeGreaterThanOrderByUserAsc(int userAge);

    //findNameSurname
    @Query("select p from Persons p where p.user.name = :customName and p.user.surname = :customSurname")
    Optional<Persons> findPersonsByUser_NameAndUser_Surname(@Param("customName") String userName, @Param("customSurname") String userSurname);

}
