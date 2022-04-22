package com.demowebshop.utilities;

import java.util.Random;

public class RandomDataUtility {
    public String random() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email="testmail"+ randomInt +"@gmail.com";
        return email;

    }
}
