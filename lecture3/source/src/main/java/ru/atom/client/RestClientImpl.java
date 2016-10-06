package ru.atom.client;

import com.squareup.okhttp.*;
import ru.atom.model.Gender;
import ru.atom.model.Person;
import ru.atom.server.api.PersonBatchHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestClientImpl implements RestClient {
    private static final String PROTOCOL = "http";
    //private static final String HOST = "10.3.13.136";
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "8080";

    public boolean register(String user, String password) {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType,
                "login=" + user +
                "&" +
                "password=" + password
        );
        Request request = new Request.Builder()
                .url(PROTOCOL + "://" + HOST + ":" + PORT + "/auth/register")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try {
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            return response.isSuccessful();
        } catch (IOException e) {
            // log
            return false;
        }
    }

    public Long login(String user, String password) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType,
                "login=" + user +
                "&" +
                "password=" + password
        );
        Request request = new Request.Builder()
                .url(PROTOCOL + "://" + HOST + ":" + PORT + "/auth/login")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return Long.parseLong(response.body().string());
        } catch (IOException e) {
            // log
            return null;
        }

    }

    @Override
    public Collection<? extends Person> getBatch(Gender gender)
    {
        List<Person> res = new ArrayList<>();
        String user = "dravyman";
        String password = "123456";
        Long token = login(user,password);
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType,"");
        Request request = new Request.Builder()
                .url(PROTOCOL + "://" + HOST + ":" + PORT + "/api/personsbatch")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("Authorization:", "Bearer " + token.toString())
                .build();

        try {
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            res.add(Person.readJson(response.body().string()));
            return res;
        } catch (IOException e) {
            // log
            return res;
        }
    }
}
