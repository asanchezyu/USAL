package com.minsait.template.data.gateway;

import com.minsait.template.data.model.Element;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public interface ElementNetworkGateway {

    List<Element> requestNetworkElements();

}
