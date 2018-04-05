package smartbookmarks.gaba.diiage.org;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import smartbookmarks.gaba.diiage.org.Helper.BookHelper;
import smartbookmarks.gaba.diiage.org.Helper.CommentHelper;
import smartbookmarks.gaba.diiage.org.Helper.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button buttonShowComments;
    private Button buttonAddComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonShowComments = (Button) findViewById(R.id.btnComments);
        buttonAddComment = (Button) findViewById(R.id.btnAddComment);
        TextView tvStats = (TextView) findViewById(R.id.txtStats) ;
        buttonShowComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
                //

                Intent intent = new Intent(MainActivity.this, CommentsActivity.class);
                startActivity(intent);
            }
        });

        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCommentActivity.class);
                startActivity(intent);
            }
        });

        DataBaseHelper helper = new DataBaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        double count = DatabaseUtils.queryNumEntries(db, CommentHelper.TABLE_COMMENTS);
        double countBooks = DatabaseUtils.queryNumEntries(db, BookHelper.TABLE_BOOKS);
        db.close();


        if (countBooks > 0)
        {
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            double avgComments = count / countBooks;
            String avg = df.format(avgComments);

            String stats = "Il y a " + String.valueOf(countBooks) +" livre(s), " + String.valueOf(count) +"  commentaire(s), et une moyenne de " + avg + " commentaire(s) par livre";

            tvStats.setText(stats);
        }
    }
}
