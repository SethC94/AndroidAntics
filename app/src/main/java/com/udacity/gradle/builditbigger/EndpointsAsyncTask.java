package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbiggerbackend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by BootyCall2.0 on 2/16/2017.
 */


    public class EndpointsAsyncTask extends AsyncTask<OnJokeReceivedListener, Void, String> {
        private MyApi myApiService = null;
        private OnJokeReceivedListener listener;

        @Override
        protected String doInBackground(OnJokeReceivedListener... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://javajokes-159005.appspot.com/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });

                myApiService = builder.build();
            }

            listener = params[0];

            try {
                return myApiService.sayHi("joke").execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            listener.onReceived(result);
        }
    }
