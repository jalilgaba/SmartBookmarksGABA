package smartbookmarks.gaba.diiage.org.Models;

import java.util.Date;

/**
 * Created by jalil on 05/04/2018.
 */

public class Comment {
    private int Id;
    private int bookId;
    private String bookTitle;
    private int pageNumber;
    private String comment;
    private Date date;

    public Comment()
    {

    }


    public Comment( String bookTitle, int pageNumber, String comment, Date date) {
        this.pageNumber = pageNumber;
        this.comment = comment;
        this.bookTitle = bookTitle;
        this.date = date;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
