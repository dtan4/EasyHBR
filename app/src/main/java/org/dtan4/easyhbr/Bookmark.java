package org.dtan4.easyhbr;

import android.os.Parcel;
import android.os.Parcelable;

public class Bookmark implements Parcelable {
    private static final String TAG = "Bookmark";

    private String title;
    private String url;
    private String description;
    private int bookmarkCount;

    public Bookmark(String title, String url, String description, int bookmarkCount) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.bookmarkCount = bookmarkCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeString(description);
        parcel.writeInt(bookmarkCount);
    }

    public static final Creator<Bookmark> CREATOR = new Creator<Bookmark>() {
        public Bookmark createFromParcel(Parcel parcel) {
            return new Bookmark(parcel);
        }

        public Bookmark[] newArray(int size) {
            return new Bookmark[size];
        }
    };

    private Bookmark(final Parcel parcel) {
        title = parcel.readString();
        url = parcel.readString();
        description = parcel.readString();
        bookmarkCount = parcel.readInt();
    }
}
