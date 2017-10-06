package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.JokeListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by shoiab on 2017-10-03.
 */

public class JokeTest extends AndroidTestCase implements JokeListener {
    CountDownLatch signal;
    String joke = "";

    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException, ExecutionException {
        new EndpointsAsyncTask(this).execute();
        signal.await(30, TimeUnit.SECONDS);
        assertTrue("Service completed, the result are here!", !joke.equals(""));
        assertEquals(this.joke, "Knock, knock Joke!!");

    }

    @Override
    public void getJokeResult(String result) {

        this.joke = result;
        signal.countDown();
    }


}
