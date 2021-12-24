package com.geekbrains.backend.test.db;

import java.util.List;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

public class TestDb {

    public static void main(String[] args) {

        DbService dbService = new DbService();
        ProductsMapper productsMapper = dbService.getProductsMapper();
        Products product = productsMapper.selectByPrimaryKey(1L);
        System.out.println(product);

        Categories cat1 = new Categories();
        cat1.setTitle("cat1");
        cat1.setId(5L);
        CategoriesMapper cm = dbService.getCategoriesMapper();
        cm.insert(cat1);
        Categories cat2 = new Categories();
        cat2.setTitle("cat2");
        cat2.setId(6L);
        cm.insert(cat2);
        Categories cat3 = new Categories();
        cat3.setTitle("cat3");
        cat3.setId((7L));
        cm.insert(cat3);
        Categories cat4 = new Categories();
        cat4.setId(8L);
        cat4.setTitle("cat4");
        cm.insert(cat4);

        Products cola = new Products();
        cola.setTitle("Coca cola");
        cola.setPrice(50);
        cola.setCategoryId(5l);

        Products bread = new Products();
        bread.setTitle("Bread");
        bread.setPrice(60);
        bread.setCategoryId(5l);

        Products butter = new Products();
        butter.setTitle("Butter");
        butter.setPrice(70);
        butter.setCategoryId(5l);

        Products oil = new Products();
        oil.setTitle("Oil");
        oil.setPrice(50);
        oil.setCategoryId(6l);

        Products knife = new Products();
        knife.setTitle("Knife");
        knife.setPrice(70);
        knife.setCategoryId(6l);

        Products rubber = new Products();
        rubber.setTitle("Rubber");
        rubber.setPrice(80);
        rubber.setCategoryId(6l);






        // productsMapper.insert(forCreate);

        ProductsExample filter = new ProductsExample();

        List<Products> products = productsMapper.selectByExample(filter);
        System.out.println(products);

        filter.createCriteria()
                .andCategoryIdEqualTo(2L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();


        filter.createCriteria()
                .andCategoryIdEqualTo(5L);
        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andPriceBetween(51, 1000);

        System.out.println(productsMapper.selectByExample(filter));
        filter.clear();

        filter.setOrderByClause("PRICE DESC");
        List<Products> p = productsMapper.selectByExample(filter);
        System.out.println("1 " + p.get(0) + " 2 " + p.get(1) + " 3 " + p.get(2));

        product.setPrice(105);
        productsMapper.updateByPrimaryKey(product);

        System.out.println(productsMapper.selectByPrimaryKey(1L));
    }

}
