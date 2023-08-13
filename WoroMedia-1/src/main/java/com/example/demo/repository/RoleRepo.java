package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Roles;

@Repository
public interface RoleRepo extends CrudRepository<Roles,Long>
{

	Optional<Roles> findByname(String name);

}
