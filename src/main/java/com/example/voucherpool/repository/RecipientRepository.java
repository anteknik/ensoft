package com.example.voucherpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.voucherpool.entities.User;

@Repository
public interface RecipientRepository extends CrudRepository<User, Long> {}
