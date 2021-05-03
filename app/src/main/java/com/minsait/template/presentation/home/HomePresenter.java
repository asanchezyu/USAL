package com.minsait.template.presentation.home;

import com.minsait.template.data.model.Element;

/**
 * Created by Alejandro Sánchez
 **/
public interface HomePresenter {

    void setView(HomeView homeView);

    void makeElementsRequest();

    void goToElementDetail(Element element);

}
