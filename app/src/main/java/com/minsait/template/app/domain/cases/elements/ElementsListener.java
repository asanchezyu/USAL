package com.minsait.template.app.domain.cases.elements;

import com.minsait.template.app.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface ElementsListener {

    void onElementsReceived(List<Element> elements);

}
