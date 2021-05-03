package com.minsait.template.presentation.home;

import com.minsait.template.data.model.Element;
import com.minsait.template.domain.cases.elements.ElementsListener;
import com.minsait.template.domain.cases.elements.GetElementsUseCase;
import com.minsait.template.domain.cases.elements.GetElementsUseCaseImpl;
import com.minsait.template.presentation.navigation.Navigator;
import com.minsait.template.ui.config.MainThreadImpl;
import com.minsait.template.ui.config.UseCaseExecutorImpl;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public class HomePresenterImpl implements HomePresenter {

    private HomeView view;

    private Navigator navigator;

    private GetElementsUseCase getElementsUseCase;

    public HomePresenterImpl(Navigator navigator) {

        this.navigator = navigator;

        getElementsUseCase = new GetElementsUseCaseImpl(MainThreadImpl.getInstance(), UseCaseExecutorImpl.getInstance());

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
