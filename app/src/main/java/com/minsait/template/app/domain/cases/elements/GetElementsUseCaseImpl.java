package com.minsait.template.app.domain.cases.elements;

import com.minsait.template.app.data.gateway.ElementNetworkGateway;
import com.minsait.template.app.data.model.Element;
import com.minsait.template.app.domain.config.MainThread;
import com.minsait.template.app.domain.config.UseCaseExecutor;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alejandro Sánchez
 **/
public class GetElementsUseCaseImpl implements GetElementsUseCase {

    private MainThread mainThread;

    private UseCaseExecutor useCaseExecutor;

    private ElementNetworkGateway elementNetworkGateway;

    @Inject
    public GetElementsUseCaseImpl(MainThread mainThread, UseCaseExecutor useCaseExecutor, ElementNetworkGateway elementNetworkGateway) {

        this.mainThread = mainThread;

        this.useCaseExecutor = useCaseExecutor;

        this.elementNetworkGateway = elementNetworkGateway;

    }

    @Override
    public void execute(ElementsListener elementsListener) {

        useCaseExecutor.execute(new Runnable() {
            @Override
            public void run() {

                List<Element> elements = elementNetworkGateway.requestNetworkElements();

                if (elements != null) {

                    mainThread.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            elementsListener.onElementsReceived(elements);

                        }

                    });

                }

            }

        });

    }

}
