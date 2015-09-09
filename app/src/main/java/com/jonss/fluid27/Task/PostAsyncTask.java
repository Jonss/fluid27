package com.jonss.fluid27.Task;

import android.os.AsyncTask;

import com.jonss.fluid27.Web.JsonProducer;
import com.jonss.fluid27.Web.PostProducer;
import com.jonss.fluid27.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neuromancer on 02/09/15.
 */
public class PostAsyncTask extends AsyncTask<Object, Object, List<Post>> {

    private static String URL_JSON = "http://fluid-challenge.herokuapp.com/posts/json";
    private static List<Post> posts = new ArrayList<>();
    private PostProducer producer = new PostProducer();

    @Override
    protected List<Post> doInBackground(Object... params) {
        cleanList();
        JSONArray jsonArray;
        try {
            StringBuilder builder = new JsonProducer().getJsonFromAPI(URL_JSON);
            jsonArray = new JSONArray(builder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Post post = producer.create(jsonObject);
                posts.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return posts;
    }


    private void cleanList(){
        posts.clear();
    }
}