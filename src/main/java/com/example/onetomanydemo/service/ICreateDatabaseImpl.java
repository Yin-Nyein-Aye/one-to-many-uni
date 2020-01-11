package com.example.onetomanydemo.service;

import com.example.onetomanydemo.domain.Category;
import com.example.onetomanydemo.domain.Product;
import com.example.onetomanydemo.repository.CategoryRepository;
import com.example.onetomanydemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ICreateDatabaseImpl implements ICreateDatabase {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    @Transactional
    public void createDatabase(){

        Product p1 = new Product("Apple",2,3000);
        Product p2 = new Product("Avocado",3,2000);

        Product p3 = new Product("Pork",1,2000);
        Product p4 = new Product("Chicken",3,2500);

        Category c1 = new Category("Fruit");
        Category c2 = new Category("Meet");


        c1.getProducts().add(p1);
        c1.getProducts().add(p2);
        c2.getProducts().add(p3);
        c2.getProducts().add(p4);

        categoryRepository.save(c1);
        categoryRepository.save(c2);



    }

}
