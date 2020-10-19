package com.bee.firsthomework.others;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
    private String varity;
    private String gender;
    private int age;

    public Animal(String varity, String gender, int age) {
        this.varity = varity;
        this.gender = gender;
        this.age = age;
    }

    // 实现Comparable接口，结合使用treeset集合，可以实现”按动物年龄排序“
    @Override
    public int compareTo(Animal o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }

    public String getVarity() {
        return varity;
    }

    public void setVarity(String varity) {
        this.varity = varity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return age == animal.age &&
                varity.equals(animal.varity) &&
                gender.equals(animal.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varity, gender, age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "varity='" + varity + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age + '\n' +
                '}';
    }
}
