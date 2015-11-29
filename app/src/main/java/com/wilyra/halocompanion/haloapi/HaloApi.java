package com.wilyra.halocompanion.haloapi;


import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by wilyr on 11/20/2015.
 */
public class HaloApi {

    private static String Ori = "907d6aefaabf42848c1e900229d592a7";


    public static String getUrl(String url) {
        String output = "";
        CloseableHttpClient clients = HttpClients.createDefault();

        URIBuilder builder = null;
        URI uri = null;
        try {
            builder = new URIBuilder(url);
            builder.setParameter("Ocp-Apim-Subscription-Key", Ori);
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return (null);
        }

        HttpGet request = new HttpGet(uri);
        request.setHeader("Ocp-Apim-Subscription-Key", Ori);
        try {

            HttpResponse response = clients.execute(request);
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.e("HaloApi", "Error" + statusCode + " from url " + uri.getPath());
                return (null);
            }
            HttpEntity responseEntity = response.getEntity();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                output += s;
            }
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


    public static InputStream getImage(String url) {
        String output = "";
        CloseableHttpClient clients = HttpClients.createDefault();

        URIBuilder builder = null;
        URI uri = null;
        try {
            builder = new URIBuilder(url);
            builder.setParameter("Ocp-Apim-Subscription-Key", Ori);
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return (null);
        }

        HttpGet request = new HttpGet(uri);
        request.setHeader("Ocp-Apim-Subscription-Key", Ori);
        try {

            HttpResponse response = clients.execute(request);
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.e("HaloApi", "Error" + statusCode + " from url " + uri.getPath());
                return (null);
            }
            HttpEntity responseEntity = response.getEntity();

            return (responseEntity.getContent());
        } catch (ClientProtocolException e) {
            request.abort();
            e.printStackTrace();
        } catch (IOException e) {
            request.abort();
            e.printStackTrace();
        }
        return (null);
    }

}
