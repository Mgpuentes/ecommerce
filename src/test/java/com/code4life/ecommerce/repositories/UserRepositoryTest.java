package com.code4life.ecommerce.repositories;

import com.code4life.ecommerce.EcommerceApplication;
import com.code4life.ecommerce.model.User;
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
public class UserRepositoryTest {

    //Spring will autowire to create bean from userRepository interface
    @Autowired
    private UserRepository userRepository;

    @Rule
    public TestName testName;

    //Check to see if userRepository and testName are null
    @Before
    public void setUp() throws Exception {
        testName = new TestName();
        assertNotNull(testName);
        assertNotNull(userRepository);
    }

    @Test
    public void testSaveToDatabase() throws Exception {
        //1. create an instance of User
        User user = new User();

        //2. set some name, password, username and email
        user.setEmail(testName.getMethodName() + "email");
        user.setPassword(testName.getMethodName() + "password");
        user.setFirstName(testName.getMethodName() + "firstname");
        user.setLastName(testName.getMethodName() + "lastname");
        user.setUsername(testName.getMethodName() + "username");

        //3. create user object and copy saved entity to new object then save to database
        User save = userRepository.save(user);

        //4. retrieve from database
        assertNotNull(save);
        assertNotNull(save.getId());

        User returned = userRepository.findOne(save.getId());

        assertEquals(returned, save);
    }
}