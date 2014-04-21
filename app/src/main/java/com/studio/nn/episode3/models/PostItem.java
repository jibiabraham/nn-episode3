package com.studio.nn.episode3.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jibi on 21/4/14.
 */
public class PostItem implements Parcelable {
    private int icon;
    private String moniker;
    private String ts;
    private String content;

    public PostItem(){}
    public PostItem(int icon, String moniker, String ts, String content){
        this.icon = icon;
        this.moniker = moniker;
        this.ts = ts;
        this.content = content;
    }

    public PostItem(Parcel source) {
        icon = source.readInt();
        moniker = source.readString();
        ts = source.readString();
        content = source.readString();
    }

    public String getMoniker() {
        return moniker;
    }

    public void setMoniker(String moniker) {
        this.moniker = moniker;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(moniker);
        dest.writeString(ts);
        dest.writeString(content);
    }

    public static final Creator<PostItem> CREATOR = new Creator<PostItem>(){
        @Override
        public PostItem createFromParcel(Parcel source) {
            return new PostItem(source);
        }

        @Override
        public PostItem[] newArray(int size) {
            return new PostItem[size];
        }
    };
}
