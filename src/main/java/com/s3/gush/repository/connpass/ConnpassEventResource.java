package com.s3.gush.repository.connpass;

import com.s3.gush.domain.Event;
import com.s3.gush.domain.Series;
import com.s3.gush.repository.EventResource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class ConnpassEventResource implements EventResource {


    private Map<String, Pair<Date, List<Event>>> cacheMap = new HashMap<>();

    @Override
    public List<Event> findByKeyword(String keyword) {
        Pair<Date, List<Event>> cache = (cacheMap != null) ? cacheMap.get(keyword) : null;
        if (cache != null) {
            long elapsed  = (new Date().getTime() - cache.getFirst().getTime());
            if (elapsed < 60000) {
                System.out.println("cache HIT!");
                System.out.println("cache created: " + cache.getFirst());
                System.out.println("cache duration: " + (new Date().getTime() - cache.getFirst().getTime()));
                return cache.getSecond();
            }
        }
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
                event.address = object.getString("address");
                event.place = object.getString("place");
                event.setStart(object.getString("started_at"));
                event.setEnd(object.getString("ended_at"));
                JSONObject seriesObject = object.getJSONObject("series");
                Series series = new Series();
                series.id = String.valueOf(seriesObject.getInt("id"));
                series.url = seriesObject.getString("url");
                series.title = seriesObject.getString("title");
                event.series = series;
                events.add(event);

            }
            cacheMap.put(keyword, Pair.of(new Date(), events));
            return events;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
