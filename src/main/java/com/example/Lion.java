package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Predator predator;

    public Lion(Feline feline, String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
            this.predator = feline;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
            this.predator = feline;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }

    }

    public boolean doesHaveMane() {

        return hasMane;
    }

    public List<String> getFood() throws Exception {

        return predator.eatMeat();
    }

    public int getKittens() {

        return predator.getKittens();
    }

}
