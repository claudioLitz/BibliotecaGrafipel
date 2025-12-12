package com.Sebus;

public class Book implements Interface{
    // Attributes
    private String title;
    private String author;
    private int totalPage;
    private int currentPage;
    private boolean open;
    private String reader;
    private int ID;
    private static int IDs = 0;

    // ------------------------------------Constructor method
    public Book(String author, Person reader, String title, int totalPage) {
        this.author = author;
        if (reader != null){
        this.reader = reader.getName();
        } else {
            this.reader = null;
        }
        this.currentPage = 0;
        this.setOpen();
        this.title = title;
        this.totalPage = totalPage;
        this.ID = IDs;
        IDs++;

    }

    // ----------------------------------Getters and Setters methods------------------------------------
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
        this.setOpen();
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen() {
        this.open = this.getcurrentPage() > 0;
    }

    public String getreader() {
        return reader;
    }

    public void setreader(Person reader) {
        this.reader = reader.getName();
    }

    public int getID(){
        return this.ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    

    // ----------------------------------Custom methods------------------------------------------
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

    // ----------------------------------Abstract methods-------------------------------------------
    @Override
    public void open(int especific_page){
        this.page(especific_page);
        this.setOpen();
        System.out.println("The book has opened ");
    }

    @Override
    public void close() {
        this.setcurrentPage(0);
        this.setOpen();
        System.out.println("The Book has closed");
    }

    @Override
    public void page(int page) {
        if (page < this.gettotalPage() && page >= 0){
            this.setcurrentPage(page);
            System.out.println("The book is in page n° " + this.getcurrentPage());
        } else {
            System.out.println("Unfound page, please input a valid value!");
        }
    }

    @Override
    public void nextPage() {
        this.setcurrentPage(this.getcurrentPage() + 1);
        System.out.println("Going to the next page...");
    }

    @Override
    public void backPage() {
        this.setcurrentPage(this.getcurrentPage() - 1);
        System.out.println("Going to the previus page...");
    }
    

}
