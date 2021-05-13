package com.minsait.template.app.ui.config.navigation;

import android.app.Activity;
import android.content.Intent;

import com.minsait.template.app.data.model.Element;
import com.minsait.template.app.presentation.navigation.Navigator;
import com.minsait.template.app.ui.detail.DetailActivity;

import javax.inject.Inject;

/**
 * Created by Alejandro Sánchez
 **/
public class NavigatorImpl implements Navigator {

    private Activity activity;

    @Inject
    public NavigatorImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToElementDetail(Element element) {

        Intent intent = DetailActivity.getLaunchIntent(activity, element);

        activity.startActivity(intent);

    }

}
