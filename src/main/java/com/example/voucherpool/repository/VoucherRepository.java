package com.example.voucherpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.voucherpool.entities.Voucher;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long> {}



