package com.data;

public class Dept {
    public String name;
    public float money;

    public float getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
