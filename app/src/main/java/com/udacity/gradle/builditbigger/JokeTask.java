package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import com.mohamed14riad.androidlibrary.AppConstants;
import com.mohamed14riad.androidlibrary.DisplayJokeActivity;

public class JokeTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApi = null;
    private Context context;

    public JokeTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8888/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }
        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);

        try {
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            intent.putExtra(AppConstants.JOKE_KEY, joke);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.d(":: No Activity ::", e.getMessage());
        }
    }
}
