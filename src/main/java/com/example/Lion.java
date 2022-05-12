package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private Predator predator;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {

        return hasMane;
    }

    public Lion(Predator feline) {

        this.predator = feline;
    }

    public List<String> getFood() throws Exception {

        return predator.eatMeat();
    }

    public int getKittens() {

        return predator.getKittens();
    }

}
