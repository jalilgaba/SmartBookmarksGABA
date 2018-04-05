package smartbookmarks.gaba.diiage.org.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jalil on 05/04/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;

    private static final String DB_NAME = "SmartBooks.db";

    private static final String CREATE_TABLE_BOOKS =
            "CREATE TABLE IF NOT EXISTS Books (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL, author TEXT NOT NULL, genre TEXT NOT NULL);";

    private static final String CREATE_TABLE_COMMENTS =
            "CREATE TABLE Comments (id  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , bookId INTEGER, page INTEGER, comment TEXT NOT NULL , date DATETIME NOT NULL ); ";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_BOOKS);
        db.execSQL(CREATE_TABLE_COMMENTS);

        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(1,'Les fleurs du mal','Charles Baudelaire','Poèmes');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(2,'Germinal','Emile Zola','Roman');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(3,'Les misérables','Victor Hugo','Roman');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(4,'1984','George Orwell','Science-Fiction');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(5,'Le Meilleur des mondes','Aldous Huxley','Science-Fiction');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(6,'Vingt mille lieues sous les mers','Jules Verne','Aventure');");
        db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(7,'Les Trois Mousquetaires','Alexandre Dumas','Aventure');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // si la bdd a besion d'être maj, on drop les tables et on les recréé (pg pour les datas)
//        db.execSQL("DROP TABLE Books;");
//        db.execSQL("DROP TABLE Comments;");
//        onCreate(db);


        if (oldVersion == 1)
        {
            db.execSQL("CREATE TABLE Authors (" +
                    "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    "nom TEXT NOT NULL , " +
                    "DateNaissance DATETIME);");

            db.execSQL("ALTER TABLE Books ADD COLUMN authorId int;");
        }
    }
}
