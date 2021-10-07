/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nadisa.upwork.service;

/**
 *
 * @author mayanton
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nadisa.upwork.domain.Category;
import net.nadisa.upwork.repository.CategoryRepository;
import net.nadisa.upwork.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class CategoryService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Page<Category> findCategoryAll(Pageable page) {
        return categoryRepository.findAll(page);
    }

}
