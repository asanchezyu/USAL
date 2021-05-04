package com.minsait.template.app.ui.config.threads;

import android.os.Handler;
import android.os.Looper;

import com.minsait.template.app.domain.config.MainThread;

import javax.inject.Inject;

/**
 * Created by Alejandro Sánchez
 **/
public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {

        handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }

}
