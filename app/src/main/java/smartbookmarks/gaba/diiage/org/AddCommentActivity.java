package smartbookmarks.gaba.diiage.org;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import smartbookmarks.gaba.diiage.org.Adapter.BookAdapter;
import smartbookmarks.gaba.diiage.org.Adapter.CommentAdapter;
import smartbookmarks.gaba.diiage.org.Helper.BookHelper;
import smartbookmarks.gaba.diiage.org.Helper.CommentHelper;
import smartbookmarks.gaba.diiage.org.Models.Book;
import smartbookmarks.gaba.diiage.org.Models.Comment;

/**
 * Created by jalil on 05/04/2018.
 */

public class AddCommentActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        // on get le spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spnBooks);
        // on get le btn d'ajout
        Button btnAddComment = (Button) findViewById(R.id.btnValidComment);



        btnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // le book sélectionné
                Book book = (Book) spinner.getSelectedItem();
                // le nb de page
                EditText page = (EditText) findViewById(R.id.editText2);
                // le commentaire écrit
                EditText comment = (EditText) findViewById(R.id.editText);
                //Book book = new Book("Test", "Lol", "Thriller");

                // on construit notre objet comment
                final Comment commentToAdd = new Comment(book.getTitle(), Integer.parseInt(page.getText().toString()) ,comment.getText().toString(), Calendar.getInstance().getTime());

                final CommentHelper commentHelper = new CommentHelper(AddCommentActivity.this);
                // ouverture de la connexion
                commentHelper.open();
                // on appelle la méthode d'insertion de commentaire
                commentHelper.insertComment(commentToAdd);
                // on ferme la connexion
                commentHelper.close();
            }
        });

        BookHelper bookHelper = new BookHelper(this);

        bookHelper.open();


        BookAdapter adapter = new BookAdapter(this, bookHelper.getAllBooks());

        spinner.setAdapter(adapter);

        //bookHelper.close();

    }

}