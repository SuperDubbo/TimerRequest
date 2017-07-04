package com.hz.task;

import com.hz.request.MyHttpRequest;

import java.util.TimerTask;

/**
 * Created by Tom on 2017/7/4.
 */
public class HttpTask extends TimerTask{
    private static int i=0;
    @Override
    public void run() {
        System.out.println(MyHttpRequest.get("http://woshiwangmo.com/wangmo/home/index.php?act=index&op=task",null));
    }
}
