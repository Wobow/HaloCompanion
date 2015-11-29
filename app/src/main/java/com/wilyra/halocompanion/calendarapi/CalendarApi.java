package com.wilyra.halocompanion.calendarapi;


import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilyr on 11/20/2015.
 */
public class CalendarApi {


    private static final String SERVER_URL = "http://spouark.com:3000";

    public static String getUrl(DefaultHttpClient clients, String route) {
        String output = "";

        URIBuilder builder = null;
        URI uri = null;
        try {
            builder = new URIBuilder(String.format("%s%s", SERVER_URL, route));
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return (null);
        }

        HttpGet request = new HttpGet(uri);
        try {

            HttpResponse response = clients.execute(request);
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.e("CalendarApi", "Error" + statusCode + " from url " + uri.getPath());
                return (null);
            }
            HttpEntity responseEntity = response.getEntity();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                output += s;
            }
            responseEntity.consumeContent();
            return (output);

        } catch (ClientProtocolException e) {
            request.abort();
            e.printStackTrace();
        } catch (IOException e) {
            request.abort();
            e.printStackTrace();
        }
        return (null);
    }


    public static StatusLine post(DefaultHttpClient clients, String route, PostParam[] params) {
        String output = "";

        try {
            HttpPost httppost = new HttpPost(SERVER_URL + route);
            if (params != null) {
                List<NameValuePair> paramsPost = new ArrayList<NameValuePair>(params.length);
                for (PostParam p : params)
                    paramsPost.add(new BasicNameValuePair(p.getName(), p.getContent()));
                httppost.setEntity(new UrlEncodedFormEntity(paramsPost, "UTF-8"));
            }
            HttpResponse response = null;
            response = clients.execute(httppost);

            response.getEntity().consumeContent();
            return (response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
            return (new StatusLine() {
                @Override
                public ProtocolVersion getProtocolVersion() {
                    return null;
                }

                @Override
                public int getStatusCode() {
                    return 400;
                }

                @Override
                public String getReasonPhrase() {
                    return "Can't connect to network";
                }
            });
        }
    }
}
