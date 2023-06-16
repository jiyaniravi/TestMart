/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.User;
import com.testmart.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class UserServiceImplShould {

    @Test
    public void returnAllUsers(){
    // Given
        UserService userService = getUserServiceInstance();
    // When
        List<User> users = userService.getAllUsers();
    // Then
        Assertions.assertNotNull(users);
        Assertions.assertTrue(users.size()>0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void returnCorrectUser_forGivenUserId(int userId){
    // Given
        UserService userService = getUserServiceInstance();
    // When
        User user = (User) userService.getUser(userId);
    // Then
        Assertions.assertNotNull(user);
        Assertions.assertEquals(userId, user.getId());
    }

    private static Stream<Object[]> userDataProvider() {
        return Stream.of(
                new Object[]{"Terry",1, 2}, // firstName
                new Object[]{"Quigley",2, 1}, // lastName
                new Object[]{"acharlota",11,1} // emailAddress
        );
    }

    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void returnCorrectUser_asPerQueryParam(String queryParam, int userId, int count){
    // Given
        UserService userService = getUserServiceInstance();
    // When
        List<User> users = userService.searchUsers(queryParam);
    // Then
        Assertions.assertNotNull(users);
        Assertions.assertEquals(userId, users.get(0).getId());
        Assertions.assertEquals(count, users.size());
    }

    private static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
}
