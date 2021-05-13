package com.minsait.template.app.presentation.home;

import com.minsait.template.app.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface HomeView {

    void setElements(List<Element> elements);

    void showSpinner();

    void hideSpinner();

    boolean isSpinnerShowing();
}
