package com.Sebus;

public interface Interface {
    
    // ------------------------- INTERFACE DEFINITION (CONTRACT) -------------------------
    
    // All methods in an interface are implicitly public and abstract.
    // They define WHAT a class must do, not HOW.

    // Contract: Any implementing class must define how to open the item to a specific page.
    public void open(int especific_page);
    
    // Contract: Any implementing class must define how to close the item (e.g., reset page).
    public void close();
    
    // Contract: Defines the capability to jump to a specific page in the book.
    public void page(int page); 
    
    // Contract: Defines the capability to advance to the next page/unit.
    public void nextPage();
    
    // Contract: Defines the capability to go back to the previous page/unit.
    public void backPage();

}