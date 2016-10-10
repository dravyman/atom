package ru.atom.client;

import org.junit.Test;
import ru.atom.model.Gender;
import ru.atom.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by s.rybalkin on 04.10.2016.
 */
public class RestClientImplTest {

    private String user = "dravyman";
    private String password = "123456";
    private RestClient client = new RestClientImpl();

    @Test
    public void register() throws Exception {
        assertTrue(client.register(user, password));
    }

    @Test
    public void login() throws Exception {
        assertEquals(Long.valueOf(1), client.login(user, password));
    }

    @Test
    public void getBatch() throws Exception {

        long temp = client.login(user,password);
        Collection<? extends Person> peoples = client.getBatch(temp, Gender.FEMALE);
        for (Person p : peoples) {
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println("");
        }
    }
}