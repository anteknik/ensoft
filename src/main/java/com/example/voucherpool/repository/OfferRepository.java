package com.example.voucherpool.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.voucherpool.entities.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {}
