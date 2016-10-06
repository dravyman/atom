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

    private RestClient client = new RestClientImpl();

    @Test
    public void register() throws Exception {
        String user = "dravyman";
        String password = "123456";
        assertTrue(client.register(user, password));
    }

    @Test
    public void login() throws Exception {
        assertEquals(Long.valueOf(1), client.login("dravyman", "123456"));
    }

    @Test
    public void getBatch() throws Exception
    {
        /*String user = "dravyman";
        String password = "123456";
        Long token = client.login(user,password);*/
        Collection<? extends Person> list =  client.getBatch(Gender.FEMALE);
        for (Person pr : list)
        {
            System.out.println(pr.getName());
        }

    }

}