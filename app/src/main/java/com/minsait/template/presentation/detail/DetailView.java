package com.minsait.template.presentation.detail;

import com.minsait.template.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface DetailView {

    void setTitle(String title);

    void setImageUrl(String url);

    void setDescription(String description);

    void setFoodPairing(List<String> foodPairings);

}
