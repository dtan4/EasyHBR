package org.dtan4.easyhbr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookmarkAdapter extends ArrayAdapter<Bookmark> {
    private static final String TAG = "BookmarkAdapter";

    private final Context context;
    private final ArrayList<Bookmark> bookmarkList;

    public BookmarkAdapter(Context context, ArrayList<Bookmark> bookmarkList) {
        super(context, R.layout.row_bookmark, bookmarkList);
        this.context = context;
        this.bookmarkList = bookmarkList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.row_bookmark, parent, false);
        Bookmark bookmark = bookmarkList.get(position);

        TextView titleView = (TextView)rowView.findViewById(R.id.bookmark_title_view);
        titleView.setText(bookmark.getTitle());

        TextView descriptionView = (TextView)rowView.findViewById(R.id.bookmark_descriotion_view);
        descriptionView.setText(bookmark.getDescription());

        TextView countView = (TextView)rowView.findViewById(R.id.bookmark_count_view);
        countView.setText(Integer.toString(bookmark.getBookmarkCount()));

        return rowView;
    }
}
