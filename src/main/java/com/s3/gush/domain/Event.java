package com.s3.gush.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Event {

    /**
     * connpass field : event_id
     */
    public String id;

    /**
     * connpass field : title
     */
    public String title;

    /**
     * connpass field : catch
     */
    public String catchphrase;

    /**
     * connpass field : event_url
     */
    public String providerUrl;

    /**
     * connpass field : started_at
     */
    private String start;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = toDate(start);
    }

    /**
     * connpass field : ended_at
     */
    private String end;

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = toDate(end);
    }

    /**
     * connpass field : limit
     */
    public int limitPeaple;

    /**
     * connpass field : address
     */
    public String address;

    /**
     * connpass field : place
     */
    public String place;

    /**
     * connpass fileld : series
     */
    public Series series;

    /**
     * yyyy/MM/dd HH:mm形式の{@link DateTimeFormatter}
     */
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    /**
     * iso8601形式の日時文字列を、「yyyy/MM/dd HH:mm」のフォーマットに変換します。
     *
     * @param iso8601 iso8601形式の日時文字列
     * @return yyyy/MM/dd HH:mm形式の日時文字列
     */
    private static String toDate(String iso8601) {
        return ZonedDateTime.parse(iso8601).format(dateTimeFormatter);
    }

}
