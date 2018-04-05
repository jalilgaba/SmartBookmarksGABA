package smartbookmarks.gaba.diiage.org.Models;

/**
 * Created by jalil on 05/04/2018.
 */

public class Book {
    private int id;
    private String title;
    private int nbComments;
    private String genre;

    private String author;


    public Book()
    {
        nbComments = 0;
    }

    public Book(String title, String author, String genre) {
        id = 0;
        title = title;
        author = author;
        genre = genre;
        nbComments = 0;
    }

    public Book(int id, String title, String author, String genre, int nbComments) {
        id = id;
        title = title;
        author = author;
        genre = genre;
        nbComments = nbComments;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNbComments() {
        return nbComments;
    }

    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }
}
