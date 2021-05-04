package com.minsait.template.app.presentation.home;

import com.minsait.template.app.data.model.Element;
import com.minsait.template.app.domain.cases.elements.ElementsListener;
import com.minsait.template.app.domain.cases.elements.GetElementsUseCase;
import com.minsait.template.app.presentation.navigation.Navigator;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alejandro Sánchez
 **/
public class HomePresenterImpl implements HomePresenter {

    private HomeView view;

    private Navigator navigator;

    private GetElementsUseCase getElementsUseCase;

    @Inject
    public HomePresenterImpl(Navigator navigator, GetElementsUseCase getElementsUseCase) {

        this.navigator = navigator;

        this.getElementsUseCase = getElementsUseCase;

    }

    @Override
    public void setView(HomeView homeView) {

        this.view = homeView;

    }

    @Override
    public void makeElementsRequest() {

      getElementsUseCase.execute(new ElementsListener() {
          @Override
          public void onElementsReceived(List<Element> elements) {

              if( elements!= null){

                  view.setElements(elements);

              }

          }
      });

    }

    @Override
    public void goToElementDetail(Element element) {

        navigator.goToElementDetail(element);

    }

}
