package com.jonss.fluid27.Web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by neuromancer on 08/09/15.
 */
public class JsonProducer {

    public StringBuilder getJsonFromAPI(String apiUrl) {
        StringBuilder builder = null;
        URL url;
        try {
            url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }
}
