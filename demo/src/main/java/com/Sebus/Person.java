package com.Sebus;

public class Person {
    
    // ------------------------- 1. ATTRIBUTES (ENCAPSULATION) -------------------------
    
    // Attributes are declared private to ensure data hiding.
    // They can only be accessed or modified via public Getters and Setters.
    private String name;
    private int age;
    private String gender;

    // ------------------------- 2. CONSTRUCTOR METHOD ------------------------------------
    
    // Constructor initializes the state of a new Person object.
    public Person(String name, int age, String gender){
        // Calls the setter methods, which is good practice as it allows for validation checks.
        this.setAge(age); 
        this.setName(name);
        this.setGender(gender);
    }

    // ------------------------- 3. SETTERS AND GETTERS METHODS (CONTROLLED ACCESS) ------------------------------------
    
    // Setter (Mutator): Allows external code to write/change the name.
    public void setName(String name){
        this.name = name;
    }
    // Getter (Accessor): Allows external code to read the name.
    public String getName(){
        return this.name;
    }

    // Setter: Allows external code to write/change the age.
    // Validation logic (e.g., checking for positive age) would go here.
    public void setAge(int age){
        this.age = age;
    }
    // Getter: Allows external code to read the age.
    public int getAge(){
        return this.age;
    }

    // Setter: Allows external code to write/change the gender.
    public void setGender(String gender){
        this.gender = gender;
    }
    // Getter: Allows external code to read the gender.
    public String getGender(){
        return this.gender;
    }

    // ------------------------- 4. CUSTOM METHODS (BEHAVIOR) ------------------------------------
    
    // Custom method defining the "Birthday" behavior.
    public void Birthday(){
        // Accesses and modifies the age using the controlled Getter/Setter methods.
        this.setAge(this.getAge() + 1); 
    }

    // Custom method to display the person's current state (data).
    public void Show(){
        System.out.println("-------------Person--------------------");
        System.out.println("Name: " + this.getName());
        System.out.println("Age: "+ this.getAge());
        System.out.println("Gender: " + this.getGender());
        System.out.println("---------------------------------------");

    }
}