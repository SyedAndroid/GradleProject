import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.JokeListener;

/**
 * Created by shoiab on 2017-08-22.
 */

public class FuntionalTest extends AndroidTestCase implements JokeListener {

    String result="";

@UiThreadTest
public void testDownload() throws InterruptedException {
    new EndpointsAsyncTask(this).execute();
    assertTrue("Service completed, the result are here!", result != null);
}

    @Override
    public void getJokeResult(String result) {
        this.result= result;

    }
}
