
package Beans;

import java.sql.Date;

public class BookBean {
    private int bookID;
    private String author;
    private String publisher;
    private Date datePublished;
    private int book_productID;

    public String getAuthor() {
        return author;
    }
     
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the book_productID
     */
    public int getBook_productID() {
        return book_productID;
    }

    /**
     * @param book_productID the book_productID to set
     */
    public void setBook_productID(int book_productID) {
        this.book_productID = book_productID;
    }
    
}
