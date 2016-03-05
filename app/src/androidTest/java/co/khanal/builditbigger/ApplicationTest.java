package co.khanal.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> implements JokeFetcher.JokeFetcherListener{
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        signal.countDown();
    }

    @Test
    public void testJokeFetcher() throws Exception{
        JokeFetcher jokeFetcher = new JokeFetcher(this);
        jokeFetcher.execute(getContext());
        signal.await(10, TimeUnit.SECONDS);

    }

    @Override
    public void onJokeFetched(String joke) {
        assertNotNull(joke);
        assertFalse(TextUtils.isEmpty(joke));
    }
}