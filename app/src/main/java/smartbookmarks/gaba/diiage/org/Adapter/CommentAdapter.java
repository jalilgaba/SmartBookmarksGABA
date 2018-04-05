package smartbookmarks.gaba.diiage.org.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import smartbookmarks.gaba.diiage.org.Models.Comment;
import smartbookmarks.gaba.diiage.org.R;

/**
 * Created by jalil on 05/04/2018.
 */

public class CommentAdapter  extends ArrayAdapter<Comment> {
    public CommentAdapter(Context context, List<Comment> comments) {
        super(context, 0, comments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_comment, parent, false);
        }
//
        CommentViewHolder vH = (CommentViewHolder) convertView.getTag();
        if (vH == null) {
            vH = new CommentViewHolder();
            vH.bookTitle = (TextView) convertView.findViewById(R.id.txtBookTitle);
            vH.pageNumber = (TextView) convertView.findViewById(R.id.txtPageNumber);
            vH.comment = (TextView) convertView.findViewById(R.id.txtComment);
            vH.date = (TextView) convertView.findViewById(R.id.txtDateComment);
            convertView.setTag(vH);
        }

        Comment c = getItem(position);

        vH.bookTitle.setText(c.getBookTitle());
        vH.pageNumber.setText(String.valueOf(c.getPageNumber()));
        vH.comment.setText(c.getComment());
        //vH.date.setText(c.getDate().toString());

        return convertView;
    }

    private class CommentViewHolder {


        public TextView bookId;
        public TextView bookTitle;
        public TextView pageNumber;
        public TextView comment;
        public TextView date;
    }
}
