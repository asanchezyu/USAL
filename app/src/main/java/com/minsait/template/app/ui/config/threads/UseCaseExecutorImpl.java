package com.minsait.template.app.ui.config.threads;

import com.minsait.template.app.domain.config.UseCaseExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

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

    @Inject
    public UseCaseExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    @Override
    public void execute(final Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("UseCase must not be null");
        }
        threadPoolExecutor.submit(runnable);
    }

}
