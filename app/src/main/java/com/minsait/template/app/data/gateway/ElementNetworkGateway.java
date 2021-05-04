package com.minsait.template.app.data.gateway;

import com.minsait.template.app.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface ElementNetworkGateway {

    List<Element> requestNetworkElements();

}
