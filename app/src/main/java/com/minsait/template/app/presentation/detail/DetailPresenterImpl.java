package com.minsait.template.app.presentation.detail;

import com.minsait.template.app.data.model.Element;

import javax.inject.Inject;

/**
 * Created by Alejandro Sánchez
 **/
public class DetailPresenterImpl implements DetailPresenter {

    private DetailView view;

    private Element element;

    @Inject
    public DetailPresenterImpl() {

    }

    @Override
    public void setView(DetailView detailView) {
        this.view = detailView;
    }

    @Override
    public void setElement(Element element) {

        this.element = element;

        initData();

    }

    private void initData() {

        view.setDescription(element.description);

        view.setFoodPairing(element.foodPairing);

        view.setImageUrl(element.imageUrl);

        view.setTitle(element.name);

    }
}
