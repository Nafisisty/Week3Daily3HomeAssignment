package com.example.week3daily3homeassignment.model.datasource.httpUrlConnection;

import com.example.week3daily3homeassignment.events.UserEvent;
import com.example.week3daily3homeassignment.model.user.User;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.week3daily3homeassignment.model.Constants.BASE_URL;

public class HttpUrlConnectionHelper {
    public static void makeAPICallWithHttpConnection() {
        HttpURLConnection httpURLConnection = null;
        URL apiURl;
        String jsonResponse = "";

        try {
            apiURl = new URL(BASE_URL);
            httpURLConnection = (HttpURLConnection)apiURl.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int currentReadCharAsciiValue = inputStreamReader.read();
            while (currentReadCharAsciiValue != -1) {
                char currentChar  = (char)currentReadCharAsciiValue;

                currentReadCharAsciiValue = inputStreamReader.read();
                jsonResponse = jsonResponse + currentChar;
            }
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(httpURLConnection != null) {
                httpURLConnection.disconnect();
                Gson gson = new Gson();
                User user = gson.fromJson(jsonResponse, User.class);
                EventBus.getDefault().post(new UserEvent(user));
            }
        }

    }
}
