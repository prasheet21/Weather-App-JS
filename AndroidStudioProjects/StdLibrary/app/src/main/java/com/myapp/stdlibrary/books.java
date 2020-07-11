package com.myapp.stdlibrary;

public class books {
    private String BookName ;

    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    private int bookId ;
    private String imageURL ;
    private String pages ;
    private String author ;
    private String BookPrice ;
    private String description ;
    private boolean isExpanded ;

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public books(int bookId , String bookName, String bookPrice , String author , String imageUrl , String pages , String description) {
        this.bookId = bookId ;
        BookName = bookName;
        BookPrice = bookPrice;
        this.imageURL = imageUrl ;
        this.author = author ;
        this.pages = pages ;
        this.description = description ;
        this.isExpanded = false ;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }


    public String getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(String bookPrice) {
        BookPrice = bookPrice;
    }
}
