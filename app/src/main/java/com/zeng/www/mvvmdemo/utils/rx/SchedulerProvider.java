package com.zeng.www.mvvmdemo.utils.rx;

import io.reactivex.Scheduler;

/**
 * description:Data：2018/1/12-11:42
 *
 * @author admin
 */

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
