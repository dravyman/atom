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
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String SERVICE_URL = PROTOCOL + "://" + HOST + ":" + PORT;

    private static final OkHttpClient client = new OkHttpClient();

    public boolean register(String user, String password) {
        MediaType mediaType = MediaType.parse("raw");
        RequestBody body = RequestBody.create(
                mediaType,
                String.format("login=%s&password=%s", user, password)
        );

        String resuestUrl = SERVICE_URL + "/auth/register";
        Request request = new Request.Builder()
                .url(resuestUrl)
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            return response.isSuccessful();
        } catch (IOException e) {
            return false;
        }
    }

    public Long login(String user, String password) {


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
            return null;
        }

    }

    @Override
    public Collection<? extends Person> getBatch(Long token, Gender gender) {
        List<Person> res = new ArrayList<>();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "gender=FEMALE");
        Request request = new Request.Builder()
                .url(PROTOCOL + "://" + HOST + ":" + PORT + "/data/personsbatch")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("Authorization:", "Bearer " + token)
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
