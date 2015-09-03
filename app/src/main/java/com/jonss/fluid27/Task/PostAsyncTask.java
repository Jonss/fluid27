package com.jonss.fluid27.Task;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by neuromancer on 02/09/15.
 */
public class PostAsyncTask extends AsyncTask<Object, Object, String> {

    private static String URL_JSON = "http://fluid-challenge.herokuapp.com/posts/json";

    @Override
    protected String doInBackground(Object... params) {
        try {
            URL url = new URL(URL_JSON);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Response Code: " + connection.getResponseCode());
            InputStream in = new BufferedInputStream(connection.getInputStream());

            Scanner scanner = new Scanner(in);

            StringBuilder builder = new StringBuilder();
            while(scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }

            return  builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
