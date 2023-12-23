package org.example.fakerData;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void fakerTest(){
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        String lastName=faker.name().lastName();
        String firstName=faker.name().firstName();

        System.out.println(fullName);
    }
}
