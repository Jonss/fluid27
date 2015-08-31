package com.jonss.fluid27;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.BidiFormatter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by neuromancer on 30/08/15.
 */
public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private View view;

    public ImageAsyncTask(View view) {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap image = null;
        String url = urls[0];
        try {
            InputStream inputStream = new URL(url).openStream();
            image = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        ImageView imageView = (ImageView) view.findViewById(R.id.post_image);
        imageView.setImageBitmap(bitmap);
        this.cancel(true);
    }

}