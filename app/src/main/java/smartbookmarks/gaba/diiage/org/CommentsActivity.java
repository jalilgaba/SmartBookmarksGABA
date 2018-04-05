package smartbookmarks.gaba.diiage.org;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import smartbookmarks.gaba.diiage.org.Adapter.CommentAdapter;
import smartbookmarks.gaba.diiage.org.Helper.CommentHelper;
import smartbookmarks.gaba.diiage.org.Models.Comment;

/**
 * Created by jalil on 05/04/2018.
 */

public class CommentsActivity  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        CommentHelper db = new CommentHelper(this);

        db.open();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments = db.getAllComments();
        db.close();

        ListView lvComments = (ListView) findViewById(R.id.lvComments);
        CommentAdapter adapter = new CommentAdapter(CommentsActivity.this, comments);
        lvComments.setAdapter(adapter);
    }

}
