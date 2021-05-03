package com.minsait.template.domain.cases.elements;

import com.minsait.template.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface ElementsListener {

    void onElementsReceived(List<Element> elements);

}
