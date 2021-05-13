package com.minsait.template.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public class Element implements Parcelable{

    public Long id;

    public String name;

    public String tagLine;

    @SerializedName("first_brewed")
    public String firstBrewed;

    public String description;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("food_pairing")
    public List<String> foodPairing;

    @SerializedName("brewers_tips")
    public String tips;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(tagLine);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(tips);
        dest.writeStringList(foodPairing);
    }

    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() {

        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        public Element[] newArray(int size) {
            return new Element[size];
        }
    };

    private Element(Parcel in) {
        id = in.readLong();
        name = in.readString();
        tagLine= in.readString();
        description= in.readString();
        imageUrl= in.readString();
        tips= in.readString();
        foodPairing= in.createStringArrayList();
    }

}
