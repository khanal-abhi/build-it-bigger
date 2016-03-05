package co.khanal;

import junit.framework.TestCase;

/**
 * Created by abhi on 3/4/16.
 */
public class JokesProviderTest extends TestCase {

    JokesProvider jokesProvider;

    public void setUp() throws Exception {
        jokesProvider = new JokesProvider();
        jokesProvider.populateJokes();
    }

    public void tearDown() throws Exception {
        if(jokesProvider != null)
            jokesProvider = null;
    }


    public void testGetJokes() throws Exception {
        assertEquals(10, jokesProvider.getJokes().size());
    }
}