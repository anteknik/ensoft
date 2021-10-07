/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nadisa.upwork.repository;

import net.nadisa.upwork.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author mayanton
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {
    Category findByName(String name);
}
