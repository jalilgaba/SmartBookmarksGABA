package smartbookmarks.gaba.diiage.org.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import smartbookmarks.gaba.diiage.org.Models.Book;

/**
 * Created by jalil on 05/04/2018.
 */

//Classe de gestion du fichier de bdd sqlite pour Book


public class BookHelper {

    public static final String TABLE_BOOKS = "Books";
    private static final int NUM_COLUMN_ID = 0;
    private static final String COLUMN_TITLE = "title";
    private static final int NUM_COLUMN_TITLE = 1;
    private static final String COLUMN_AUTHOR = "author";
    private static final int NUM_COLUMN_AUTHOR = 2;
    private static final String COLUMN_GENRE = "genre";
    private static final int NUM_COLUMN_GENRE = 3;

    private SQLiteDatabase db;

    private DataBaseHelper dbHelper;

    public BookHelper(Context context) {

        dbHelper = new DataBaseHelper(context); // Création de la BDD
    }

    public void open() {

        db = dbHelper.getWritableDatabase();// On ouvre la connexion (?)
    }

    public void close() {

        db.close();//on ferme la connexion
    }

    public SQLiteDatabase getBDD() {
        return db;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> res = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BOOKS, null);
        int nbItems = cursor.getCount();
        while (cursor.moveToNext())
        {
            Book book = cursorToBook(cursor);
            res.add(book);
        }

        cursor.close();
        return res;
    }
    private Book cursorToBook(Cursor c){ // les infos sur le book sont dans ce cursor
        //En tout premier on test si la requête nous renvoie qqch
        // si requete.getCount() == 0 on return null
        if (c.getCount() == 0)
        {

            return null;
        }

        Book res = new Book(); // le book à retourner

        res.setId(c.getInt(NUM_COLUMN_ID));
        res.setAuthor(c.getString(NUM_COLUMN_AUTHOR));
        res.setGenre(c.getString(NUM_COLUMN_GENRE));
        res.setTitle(c.getString(NUM_COLUMN_TITLE));



        return res;
    }
}
