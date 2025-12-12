package com.Sebus;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {

        // ------------------------- 1. DATA INITIALIZATION -------------------------

        // Dynamic lists (ArrayLists) are created to store all Person and Book objects.
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Book> books = new ArrayList();
        
        // RECOMMENDATION: Declare the Scanner outside the main loop for resource optimization.
        Scanner scanner = new Scanner(System.in); 


        // Creating some predefined Person objects (initial data)
        Person p = new Person("Brayan", 17, "male");
        people.add(p);
        p = new Person("Claudio", 17, "male");
        people.add(p);
        p = new Person("Eliane", 41, "Female");
        people.add(p);

        // Creating some predefined Book objects (initial data)
        // The reader is explicitly defined by linking the book to an existing Person object.
        Book b = new Book("J.K. Rowling I", people.get(0), "Harry Potter: pedra filosofal", 300); // Reader: Brayan
        books.add(b);
        b = new Book("J.K. Rowling II", people.get(1), "Harry Potter: camara secreta", 400); // Reader: Claudio
        books.add(b);
        b = new Book("J.K. Rowling III", people.get(2), "Harry Potter: calice de fogo", 600); // Reader: Eliane
        books.add(b);


        // ------------------------- 2. MAIN LOOP (MENU) -------------------------

        // Control variable to keep the system running.
        boolean loop = true;
        while (loop) {

            // Main Menu displayed to the user.
            System.out.println("\n--------------------------Aplication------------------------------");
            System.out.println("                       Wellcome to my system!                       ");
            System.out.println("What do you wanna do?");
            System.out.println("1 - Create a Person");
            System.out.println("2 - Create a Book");
            System.out.println("3 - Enter in your profile");
            System.out.println("4 - Close the system");
            System.out.println("------------------------------------------------------------------");

            // Takes the user's choice.
            int Choose = scanner.nextInt();
            // Consumes the remaining newline character after nextInt().
            scanner.nextLine(); 
        
            
            switch (Choose) {


                // ------------------------- CASE 1: CREATE NEW PERSON -------------------------
                case 1:
                    System.out.print("\n\n\nPlease type your name: ");
                    String name = scanner.nextLine(); // Using nextLine() to capture full names

                    System.out.print("Please type your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please type your gender: ");
                    String gender = scanner.nextLine();

                    // Creates and adds the new Person object to the list.
                    p = new Person(name, age, gender);
                    people.add(p);
                    System.out.println("\nYou has been registered!");
                    break;


                // ------------------------- CASE 2: CREATE NEW BOOK -------------------------
                case 2:
                    System.out.print("\n\n\nPlease type the name of author: ");
                    String author = scanner.nextLine();

                    System.out.print("Please type the title: ");
                    String title = scanner.nextLine();

                    System.out.print("Please type the total of pages: ");
                    int totalPage = scanner.nextInt();
                    scanner.nextLine();

                    // Creates the Book object, setting the reader to null (book available for purchase).
                    b = new Book(author, null, title, totalPage);
                    books.add(b);
                    System.out.println("\nBook registered and available for purchase!");
                    break;
                

                // ------------------------- CASE 3: ACCESS PROFILE -------------------------
                case 3:
                    System.out.print("Please type your name: ");
                    name = scanner.nextLine();
                    
                    // Initialization for finding and storing the logged-in person
                    boolean loop2 = false; 
                    Person loggedPerson = null; // Variable to store the found Person object

                    // Searches for the person in the list
                    for (int i = 0; i < people.size(); i++){
                        // Comparison uses .equals() which is correct for Strings
                        if (name.equals(people.get(i).getName())){
                            loggedPerson = people.get(i); // Stores the found object
                            loop2 = true; // Allows entry into the profile loop
                            break; // **Improvement:** Exits the 'for' loop once the person is found.
                        }
                    }

                    // If the person was found, enter the profile menu
                    if (loggedPerson != null) {
                         while (loop2){
                            // Profile Menu
                            System.out.println("\nWellcome " + name + "!");
                            System.out.println("What do you wanna do?");
                            System.out.println("1 - Buy a book");
                            System.out.println("2 - See your books");
                            System.out.println("3 - Leave of your profile");
                            
                            int choose = scanner.nextInt();
                            scanner.nextLine();

                            switch (choose) {

                                // Buy a book
                                case 1:
                                    System.out.println("\n--- Books Available ---");
                                    // Iterates through the list to find books with a NULL reader
                                    for (int a = 0; a < books.size(); a++){
                                        if (books.get(a).getreader() == null){
                                        // The index 'a' is used as the selection ID/number
                                        System.out.println(a + " - " + books.get(a).details());
                                        }
                                    }

                                    // User chooses the ID (index 'a') of an available book
                                    System.out.println("\nPlease type the number of the book you want buy: ");
                                    System.out.println("If you dont is seeing any book, it mean that there's no book to buy");
                                    int c = scanner.nextInt();
                                    scanner.nextLine();


                                    // Searches for the chosen, available book
                                    for (int a = 0; a < books.size(); a++){
                                        // Checks if the book is available (reader == null) AND if the index matches the choice (c)
                                        if ((books.get(a).getreader() == null) && (a == c)){
                                            
                                            // **Improvement:** No need for a nested loop. Use the 'loggedPerson' object directly.
                                            // Sets the logged-in Person object (loggedPerson) as the reader of the book.
                                            books.get(a).setreader(loggedPerson);
                                            System.out.println("\nBook successfully purchased!");
                                            break; 
                                        } 
                                    }
                                    break;
                                    
                                    
                                // See all books that the persons have
                                case 2:
                                    System.out.println("\n--- Your Books ---");
                                    boolean foundBook = false;
                                    for (int a = 0; a < books.size(); a++){
                                        // Checks if the reader's name on the book matches the logged-in user's name
                                        // RECOMMENDATION: If the Book class stores the Person object, the ideal check is
                                        // if (books.get(a).getreader().equals(loggedPerson))
                                        if (books.get(a).getreader() != null && books.get(a).getreader().equals(name)){
                                            System.out.println(books.get(a).details());
                                            foundBook = true;
                                        }
                                    }
                                    if (!foundBook) {
                                        System.out.println("You don't have any books yet.");
                                    }
                                    break;


                                // Stop the person profile
                                case 3:
                                    loop2 = false;
                                    System.out.println("\nLogging out...");
                                    break;
                                    
                                default:
                                    System.out.println("Invalid option. Try again.");
                            }
                        }
                    } else {
                        System.out.println("\nUser not found.");
                    }
                    break;


                // ------------------------- CASE 4: CLOSE SYSTEM -------------------------
                case 4: 
                    loop = false; // Exits the main loop
                    System.out.println("\nSystem closed. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        } 
        
        // **IMPORTANT:** Close the Scanner when exiting the system
        scanner.close();
    }
}