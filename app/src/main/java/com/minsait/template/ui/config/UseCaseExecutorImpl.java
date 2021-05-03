package com.minsait.template.ui.config;

import com.minsait.template.domain.config.UseCaseExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro Sánchez
 **/
public final class UseCaseExecutorImpl implements UseCaseExecutor {

    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 300;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor threadPoolExecutor;

    private static UseCaseExecutor instance;

    private UseCaseExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    public static final UseCaseExecutor getInstance() {

        if (instance == null) {

            instance = new UseCaseExecutorImpl();

        }

        return instance;

    }

    @Override
    public void execute(final Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("UseCase must not be null");
        }
        threadPoolExecutor.submit(runnable);
    }

}
