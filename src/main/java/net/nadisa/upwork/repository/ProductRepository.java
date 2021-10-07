/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nadisa.upwork.repository;

import net.nadisa.upwork.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mayanton
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
