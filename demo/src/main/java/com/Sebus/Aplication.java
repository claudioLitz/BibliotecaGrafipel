package com.Sebus;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Book> books = new ArrayList();

        Person p = new Person("Brayan", 17, "male");
        people.add(p);
        p = new Person("Claudio", 17, "male");
        people.add(p);
        p = new Person("Eliane", 41, "Female");
        people.add(p);


        Book b = new Book("J.K. Rowling I",people.get(0),"Harry Potter: pedra filosofal",300);
        books.add(b);
        b = new Book("J.K. Rowling II", people.get(1),"Harry Potter: camara secreta",400);
        books.add(b);
        b = new Book("J.K. Rowling III",people.get(2),"Harry Potter: calice de fogo",600);
        books.add(b);


        boolean loop = true;
        while (loop) { 
            System.out.println("\n--------------------------Aplication------------------------------");
            System.out.println("                       Wellcome to my system!                       ");
            System.out.println("What do you wanna do?");
            System.out.println("1 - Create a Person");
            System.out.println("2 - Create a Book");
            System.out.println("3 - Enter in your profile");
            System.out.println("4 - Close the system");
            System.out.println("------------------------------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            int Choose = scanner.nextInt();
        
            
            switch (Choose) {
                case 1:
                    System.out.print("Please type your name: ");
                    String name = scanner.next();
                    scanner.nextLine();

                    System.out.print("\nPlease type your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nPlease type your gender");
                    String gender = scanner.next();
                    scanner.nextLine();


                    p = new Person(name, age, gender);
                    people.add(p);
                    System.out.println("\nYou has been registered!");
                    break;

                case 2:
                    System.out.println("Please type the name of author");
                    String author = scanner.next();
                    scanner.nextLine();

            
                    System.out.print("Please type the title:");
                    String title = scanner.next();
                    scanner.nextLine();

                    System.out.println("Please type the total of pages");
                    int totalPage = scanner.nextInt();
                    scanner.nextLine();

                    b = new Book(author, null, title, totalPage);
                    books.add(b);
                    break;
                
                case 3:
                    System.out.print("Please type your name: ");
                    name = scanner.next();
                    
                    boolean loop2 = false;
                    for (int i = 0; i < people.size();i++){
                        if (name.equals(people.get(i).getName())){
                            loop2 = true;
                        }
                    while (loop2){


                                System.out.println("\nWellcome " + name);
                                System.out.println("What do you wanna do?");
                                System.out.println("1 - Buy a book");
                                System.out.println("2 - See your books");
                                System.out.println("3 - Leave of your profile");
                                
                                int choose = scanner.nextInt();
                                switch (choose) {
                                    case 1:
                                       for (int a = 0; a < books.size();a++){
                                            if ((books.get(a).getreader() == null)){
                                            System.out.println("\n" + a + " - " + books.get(a).details());
                                           }
                                        }

                                        System.out.println("Please type the number of the book you want buy: \nIf you dont is seeing any book, it mean that there's no book to buy");
                                        int c = scanner.nextInt();

                                        for (int a = 0; a < books.size();a++){
                                            if ((books.get(a).getreader() == null) && (books.get(a).getID() == c)){
                                                for (int l = 0; l < people.size(); l++){
                                                    if (people.get(l).getName().equals(name)){
                                                        books.get(a).setreader(people.get(l));
                                                    }
                                                }
                                            } else{
                                                System.out.println("This ID dont is available. Try again with another ID!");
                                                break;
                                            }

                                        }
                                        
                                        
                                    case 2:
                                        for (int a = 0; a < books.size();a++){
                                            if (name.equals(books.get(a).getreader())){
                                                System.out.println(books.get(a).details());
                                            }
                                        }
                                        break;

                                    case 3:
                                        loop2 = false;
                                        break;
                                }
                    } 
                        
                    }
                    break;
                case 4: 
                    loop = false;

                    break;
                
            }




        }
    
        
    }
}