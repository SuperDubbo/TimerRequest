package com.hz.main;

import com.hz.task.HttpTask;

import java.util.Timer;

/**
 * Created by Tom on 2017/7/4.
 */
public class Runner {
    public static void main(String[] args) {
        HttpTask httpTask=new HttpTask();
        Timer timer=new Timer();
        timer.schedule(httpTask,0,1000);
    }
}
