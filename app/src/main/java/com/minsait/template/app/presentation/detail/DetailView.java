package com.minsait.template.app.presentation.detail;

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
