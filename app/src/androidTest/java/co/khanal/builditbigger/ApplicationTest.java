package co.khanal.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeFetcher() throws Exception{
        JokeFetcher jokeFetcher = new JokeFetcher();
        jokeFetcher.setListener(new JokeFetcher.JokeFetcherListener() {
            @Override
            public void onJokeFetched(String joke) {
                assertNotNull(joke);
                assertFalse(TextUtils.isEmpty(joke));
            }
        });
        jokeFetcher.execute(getContext());
        signal.await(10, TimeUnit.SECONDS);
    }
}