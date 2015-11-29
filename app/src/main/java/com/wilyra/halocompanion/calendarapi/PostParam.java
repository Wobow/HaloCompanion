package com.wilyra.halocompanion.calendarapi;

/**
 * Created by wilyr on 11/28/2015.
 */
public class PostParam {
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    String name;
    String content;

    public PostParam(String name, String content)
    {
        this.name = name;
        this.content = content;
    }
}
