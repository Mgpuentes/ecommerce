package com.code4life.ecommerce.repositories;

import com.code4life.ecommerce.EcommerceApplication;
import com.code4life.ecommerce.model.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcommerceApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Rule
    public TestName testName;

    @Before
    public void setUp() throws Exception {
        testName = new TestName();
        assertNotNull(productRepository);
        assertNotNull(testName);
    }

    @Test
    public void testSaveToDatabase() throws Exception {

        // 1 . Create an instance of product
        Product product = new Product();

        // 2. set some name, description, category
        product.setName(testName.getMethodName() + "name");
        product.setDescription(testName.getMethodName() + "description");
        product.setCategory(testName.getMethodName() + "category");
        // 3. save to database

        Product save = productRepository.save(product);
        // 4. retrieve from database
        assertNotNull(save);
        assertNotNull(save.getId());

        Product returned = productRepository.findOne(save.getId());

        assertEquals(save, returned);
        // 5. check if its equal what we saved and what we retrieved

    }

    @Test
    public void testDeleteFromDatabase() throws Exception {
        //1. Create an instance of product
        Product product = new Product();

        //2. set some name, description, category
        product.setName(testName.getMethodName() + "name");
        product.setDescription(testName.getMethodName() + "description");
        product.setCategory(testName.getMethodName() + "category");

        //3. save to database
        Product save = productRepository.save(product);

        //4. retrieve from database
        assertNotNull(save);
        assertNotNull(save.getId());

        //5. delete from database
        productRepository.delete(save.getId());

        //6. check if deleted
        assertNull(productRepository.findOne(save.getId()));
    }
}