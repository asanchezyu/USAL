package com.minsait.template.domain.cases.elements;

import com.minsait.template.data.gateway.ElementNetworkGateway;
import com.minsait.template.data.gateway.ElementNetworkGatewayImpl;
import com.minsait.template.data.model.Element;
import com.minsait.template.domain.config.MainThread;
import com.minsait.template.domain.config.UseCaseExecutor;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public class GetElementsUseCaseImpl implements GetElementsUseCase {

    private MainThread mainThread;

    private UseCaseExecutor useCaseExecutor;

    private ElementNetworkGateway elementNetworkGateway;

    public GetElementsUseCaseImpl(MainThread mainThread, UseCaseExecutor useCaseExecutor) {

        this.mainThread = mainThread;

        this.useCaseExecutor = useCaseExecutor;

        this.elementNetworkGateway = new ElementNetworkGatewayImpl();

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
