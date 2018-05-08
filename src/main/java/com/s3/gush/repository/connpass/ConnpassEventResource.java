package com.s3.gush.repository.connpass;

import com.s3.gush.domain.Event;
import com.s3.gush.repository.EventResource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class ConnpassEventResource implements EventResource {
    @Override
    public List<Event> findByKeyword(String keyword) {
        final int maxCount = 5;

        String url = "https://connpass.com/api/v1/event/?keyword=" + keyword + "&count=" + maxCount;
        System.out.println("url:" + url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = null;

        try {
            response = client.newCall(request).execute();

            String jsonData = response.body().string();
            System.out.println("res:" + jsonData);
            JSONObject Jobject = new JSONObject(jsonData);
            JSONArray Jarray = Jobject.getJSONArray("events");

            List<Event> events = new ArrayList<>();

            for (int i = 0; i < Jarray.length(); i++) {
                JSONObject object     = Jarray.getJSONObject(i);
                Event event = new Event();

                event.id = new Integer(object.getInt("event_id")).toString();
                event.title = object.getString("title");
                events.add(event);

            }
            return events;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
