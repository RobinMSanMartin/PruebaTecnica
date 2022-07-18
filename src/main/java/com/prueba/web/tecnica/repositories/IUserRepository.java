package com.prueba.web.tecnica.repositories;

import com.prueba.web.tecnica.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "{call sp_findall()}", nativeQuery = true)
    public List<User> sp_findAll();

    @Query(value = "{call sp_findbyid(:id)}", nativeQuery = true)
    public Optional<User> sp_findById(@Param("id")int id);

    @Query(value = "{call sp_save(:username)}", nativeQuery = true)
    public User sp_save(@Param("username")String name);

    @Query(value = "{call sp_edit(:id, :username)}", nativeQuery = true)
    public User sp_edit(@Param("id")int id, @Param("username")String name);
}
