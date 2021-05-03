package com.minsait.template.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public class Element implements Serializable {

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

}
