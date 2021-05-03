package com.minsait.template.ui.config.navigation;

import android.app.Activity;
import android.content.Intent;

import com.minsait.template.data.model.Element;
import com.minsait.template.presentation.navigation.Navigator;
import com.minsait.template.ui.detail.DetailActivity;

/**
 * Created by Alejandro Sánchez
 **/
public class NavigatorImpl implements Navigator {

    private Activity activity;

    public NavigatorImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToElementDetail(Element element) {

        Intent intent = DetailActivity.getLaunchIntent(activity, element);

        activity.startActivity(intent);

    }
}
