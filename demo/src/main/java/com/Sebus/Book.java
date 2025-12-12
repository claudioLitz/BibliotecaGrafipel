package com.Sebus;

public class Book implements Interface{
    
    // ------------------------- 1. ATTRIBUTES (ENCAPSULATION) -------------------------
    
    // Attributes are private to protect the internal state of the object.
    private String title;
    private String author;
    private int totalPage;
    private int currentPage;
    private boolean open;
    private String reader; 
    
    // ID tracks the unique number of this specific book instance.
    private int ID; 
    // IDs is static: it belongs to the class and is used to generate unique IDs sequentially.
    private static int IDs = 0;

    // ------------------------------------ 2. CONSTRUCTOR METHOD ------------------------------------
    
    // Constructor initializes a new Book object upon creation.
    public Book(String author, Person reader, String title, int totalPage) {
        this.author = author;
        
        // Checks if a Person object was passed to assign the reader.
        if (reader != null){
            // Stores only the reader's name (String).
            this.reader = reader.getName();
        } else {
            // If null, the book is available.
            this.reader = null; 
        }
        
        this.currentPage = 0; // Book starts at page 0.
        this.setOpen(); // Sets the initial 'open' status based on currentPage.
        this.title = title;
        this.totalPage = totalPage;
        
        // Assigns the current unique ID and increments the static counter.
        this.ID = IDs;
        IDs++; 
    }

    // ---------------------------------- 3. GETTERS AND SETTERS METHODS (CONTROLLED ACCESS) ------------------------------------
    
    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public int gettotalPage() {
        return totalPage;
    }

    public void settotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getcurrentPage() {
        return currentPage;
    }

    public void setcurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.setOpen(); // Updates the open status whenever the current page changes.
    }

    public boolean getOpen() {
        return open;
    }

    // Method to enforce the rule: book is open only if currentPage > 0.
    public void setOpen() {
        this.open = this.getcurrentPage() > 0;
    }

    public String getreader() {
        return reader;
    }

    // Setter for the reader: takes a Person object but stores only the name (String).
    public void setreader(Person reader) {
        this.reader = reader.getName(); 
    }

    public int getID(){
        return this.ID;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }

    
    // ---------------------------------- 4. CUSTOM METHOD ------------------------------------------
    
    // Method to return all book details in a readable format.
    public String details() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------------Book Details---------------------------");
        sb.append("\ntitle: ").append(title);
        sb.append("\nauthor: ").append(author);
        sb.append("\ntotalPage: ").append(totalPage);
        sb.append("\ncurrentPage: ").append(currentPage);
        sb.append("\nopen: ").append(open);
        sb.append("\nreader: ").append(reader);
        sb.append("\nID: ").append(ID);
        sb.append("\n----------------------------------------------------------------");
        return sb.toString();
    }

    // ---------------------------------- 5. ABSTRACT METHODS (INTERFACE IMPLEMENTATION) -------------------------------------------
    
    // Fulfills the 'open' method contract from the Interface.
    @Override
    public void open(int especific_page){
        this.page(especific_page); // Jumps to a specific page.
        this.setOpen(); // Updates status to open.
        System.out.println("The book has opened ");
    }

    // Fulfills the 'close' method contract from the Interface.
    @Override
    public void close() {
        this.setcurrentPage(0); // Resets current page to 0.
        this.setOpen(); // Updates status to closed.
        System.out.println("The Book has closed");
    }

    // Fulfills the 'page' method contract from the Interface.
    @Override
    public void page(int page) {
        // Validation: Ensures the page number is valid (within bounds).
        if (page < this.gettotalPage() && page >= 0){
            this.setcurrentPage(page);
            System.out.println("The book is in page n° " + this.getcurrentPage());
        } else {
            System.out.println("Unfound page, please input a valid value!");
        }
    }

    // Fulfills the 'nextPage' method contract from the Interface.
    @Override
    public void nextPage() {
        this.setcurrentPage(this.getcurrentPage() + 1);
        System.out.println("Going to the next page...");
    }

    // Fulfills the 'backPage' method contract from the Interface.
    @Override
    public void backPage() {
        this.setcurrentPage(this.getcurrentPage() - 1);
        System.out.println("Going to the previus page...");
    }
    

}