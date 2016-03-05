package co.khanal.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.abhi.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import co.khanal.libjokedisplay.JokeDisplay;

/**
 * Created by abhi on 3/5/16.
 */
public class JokeFetcher extends AsyncTask<Context, Void, String> {

    private static MyApi myApi = null;
    private Context context;
    private JokeFetcherListener listener;

    public JokeFetcher(){

    }

    public JokeFetcher(JokeFetcherListener listener){
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Context... params) {
        if(myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            // Disable compression for local development
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();
        }
        context = params[0];
        try {
            return myApi.getJoke().execute().getJoke();
        } catch (IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {

        if(listener != null)
            listener.onJokeFetched(joke);
        Intent intent = new Intent(context, JokeDisplay.class);
        intent.putExtra(JokeDisplay.JOKE_KEY, joke);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public interface JokeFetcherListener{
        void onJokeFetched(String joke);
    }
}
