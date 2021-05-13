package com.minsait.template.app.presentation.home;

import com.minsait.template.app.data.model.Element;

/**
 * Created by Alejandro Sánchez
 **/
public interface HomePresenter {

    void setView(HomeView homeView);

    void makeElementsRequest();

    void goToElementDetail(Element element);

}
