package com.minsait.template.ui.config;

import android.os.Handler;
import android.os.Looper;

import com.minsait.template.domain.config.MainThread;
import com.minsait.template.domain.config.UseCaseExecutor;

/**
 * Created by Alejandro Sánchez
 **/
public class MainThreadImpl implements MainThread {

    private Handler handler;

    private static MainThread instance;

    private MainThreadImpl() {

        handler = new Handler(Looper.getMainLooper());

    }

    public static final MainThread getInstance() {

        if (instance == null) {

            instance = new MainThreadImpl();

        }

        return instance;

    }

    @Override
    public void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }

}
