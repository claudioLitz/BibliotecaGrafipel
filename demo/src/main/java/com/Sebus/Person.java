package com.Sebus;

public class Person {
    // Attributes 
    private String name;
    private int age;
    private String gender;

    // Constructor method
    public Person(String name, int age, String gender){
        this.setAge(age);
        this.setName(name);
        this.setGender(gender);
    }

    // Setters and Getters methods
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }

    // Custom methods
    public void Birthday(){
        this.setAge(this.getAge() + 1);
    }

    // Show person
    public void Show(){
        System.out.println("-------------Person--------------------");
        System.out.println("Name: " + this.getName());
        System.out.println("Age: "+ this.getAge());
        System.out.println("Gender: " + this.getGender());
        System.out.println("---------------------------------------");

    }
}
