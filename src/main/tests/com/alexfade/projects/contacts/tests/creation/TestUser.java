package com.alexfade.projects.contacts.tests.creation;

import com.alexfade.projects.contacts.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

/**
 * Created by Alexander Kovalevsky on 17.09.15.
 * Project name: ContactsProject
 */

@RunWith(MockitoJUnitRunner.class)
public class TestUser {

    @Mock
    private User user;

    @Test
    public void test() {
        user = new User();
        user.setUserId(10);
        user.setLogin("User");
        user.setFirst_name("UserFN");
        user.setSecond_name("UserSN");

        User user1 = new User();
        user1.setUserId(10);
        user1.setLogin("User");
        user1.setFirst_name("UserFN");
        user1.setSecond_name("UserSN");

        if(!user1.getUserId().equals(user.getUserId()) &&
           !user1.getLogin().equals(user.getLogin()) &&
           !user1.getFirst_name().equals(user.getFirst_name()) &&
           !user1.getSecond_name().equals(user.getSecond_name())) {
            fail("Not equals");
        }
    }

}
