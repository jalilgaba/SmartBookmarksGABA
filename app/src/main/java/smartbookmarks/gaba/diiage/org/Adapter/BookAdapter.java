package smartbookmarks.gaba.diiage.org.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import smartbookmarks.gaba.diiage.org.Models.Book;
import smartbookmarks.gaba.diiage.org.R;

/**
 * Created by jalil on 05/04/2018.
 */

public class BookAdapter extends ArrayAdapter/*BaseAdapter*/ {
        ArrayList<Book> books;
        Context context;
        public BookAdapter(Context context, ArrayList<Book> books) {
                super(context, 0, books);
                this.books = books;
                this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
                }

                BookViewHolder viewHolder = (BookViewHolder) convertView.getTag();
                if (viewHolder == null) {
                        viewHolder = new BookViewHolder();
                        viewHolder.title = (TextView) convertView.findViewById(R.id.txtBookTitleSpinner);
                        convertView.setTag(viewHolder);
                }

                Book book = books.get(position);
                viewHolder.title.setText(book.getTitle());

                return convertView;
        }

        private class BookViewHolder {
                public TextView title;
        }
}
