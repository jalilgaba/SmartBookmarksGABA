package smartbookmarks.gaba.diiage.org.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import smartbookmarks.gaba.diiage.org.Models.Book;
import smartbookmarks.gaba.diiage.org.Models.Comment;

/**
 * Created by jalil on 05/04/2018.
 */

public class CommentHelper {
    public static final String TABLE_COMMENTS = "Comments";
    private static final int NUM_COLUMN_ID = 0;
    private static final String COLUMN_BOOKID = "bookid";
    private static final int NUM_COLUMN_BOOKID = 1;
    private static final String COLUMN_PAGE = "page";
    private static final int NUM_COLUMN_PAGE = 2;
    private static final String COLUMN_COMMENT = "comment";
    private static final int NUM_COLUMN_COMMENT = 3;
    private static final String COLUMN_DATE = "date";
    private static final int NUM_COLUMN_DATE = 4;

    private SQLiteDatabase db;

    private DataBaseHelper dbHelper;

    public CommentHelper(Context context) {

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

    public long insertComment(Comment comment) { // comment  = le coment à insérer

        ContentValues values = new ContentValues();

        //COLUMN_... = nom de la colonne + la valeur que l'on veut insérer dans la colonne spécifiée
        values.put(COLUMN_BOOKID, comment.getBookId());
        values.put(COLUMN_PAGE, comment.getPageNumber());
        values.put(COLUMN_COMMENT, comment.getComment());
        values.put(COLUMN_DATE, comment.getDate().toString());
        //Ici on insère les valeurs contenues dans l'objet values dans la table comment
        return db.insert(TABLE_COMMENTS, null, values);
    }

    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> res = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_COMMENTS, null);



        while (cursor.moveToNext())
        {
            Comment comment = cursorToComment(cursor);
            res.add(comment);
        }

        cursor.close();
        return res;
    }
    private Comment cursorToComment(Cursor c){ // les infos sur le comment sont dans ce cursor
        //En tout premier on test si la requête nous renvoie qqch
        // si requete.getCount() == 0 on return null
        if (c.getCount() == 0)
        {

         return null;
        }

        Comment res = new Comment(); // le comment à retourner

        res.setId(c.getInt(NUM_COLUMN_ID));
        res.setBookId(c.getInt(NUM_COLUMN_BOOKID));
        res.setPageNumber(c.getInt(NUM_COLUMN_PAGE));
        res.setComment(c.getString(NUM_COLUMN_COMMENT));
        String dded = c.getString(NUM_COLUMN_DATE);
        String dsded = c.getString(NUM_COLUMN_COMMENT);
        String ddded = c.getString(NUM_COLUMN_PAGE);
        if (c.getString(NUM_COLUMN_DATE)!=null)
        {
            res.setDate(new Date(c.getString(NUM_COLUMN_DATE)));
        }
        else
        {
            res.setDate(Calendar.getInstance().getTime());
        }



        return res;
    }
}
