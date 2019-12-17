package ApplicationServer.Tests;

import ApplicationServer.Controllers.ControllerConfiguration;
import ApplicationServer.Model.ClientModels.UserRegisterClient;
import ApplicationServer.Model.DataLayerModels.UserDataLayer;
import ApplicationServer.Model.RegisterSocketProtocol.RegisterClient;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationControllerTest extends ControllerConfiguration {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //Start the Data Tier
    }

    @org.junit.jupiter.api.Test
    void register() {
        //Models from client
        UserRegisterClient userRegisterClient1 = new UserRegisterClient("userTestJunit", "password", "TestName", "TestLastName", "birthday", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient2 = new UserRegisterClient("userTestJunit2", "password", "TestName", "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient3 = new UserRegisterClient("userTestJunit3", "password", "TestName", "TestLastName", "2019-12-16", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient4 = new UserRegisterClient("userTestJunit4", "password", "TestName", "TestLastName", "2019-12-16", "2019-12-16", "profilePicture");
        //Models for data layer
        UserDataLayer userDataLayer1 = new UserDataLayer(userRegisterClient1.getUsername(), userRegisterClient1.getPassword(), userRegisterClient1.getFirstName(), userRegisterClient1.getLastName(), userRegisterClient1.getBirthday(), userRegisterClient1.getDateJoined(), userRegisterClient1.getProfilePicture());
        UserDataLayer userDataLayer2 = new UserDataLayer(userRegisterClient2.getUsername(), userRegisterClient2.getPassword(), userRegisterClient2.getFirstName(), userRegisterClient2.getLastName(), userRegisterClient2.getBirthday(), userRegisterClient2.getDateJoined(), userRegisterClient2.getProfilePicture());
        UserDataLayer userDataLayer3 = new UserDataLayer(userRegisterClient3.getUsername(), userRegisterClient3.getPassword(), userRegisterClient3.getFirstName(), userRegisterClient3.getLastName(), userRegisterClient3.getBirthday(), userRegisterClient3.getDateJoined(), userRegisterClient3.getProfilePicture());
        UserDataLayer userDataLayer4 = new UserDataLayer(userRegisterClient4.getUsername(), userRegisterClient4.getPassword(), userRegisterClient4.getFirstName(), userRegisterClient4.getLastName(), userRegisterClient4.getBirthday(), userRegisterClient4.getDateJoined(), userRegisterClient4.getProfilePicture());
        try {
            ResponseEntity<?> result1 = new RegisterClient().registerUser(userDataLayer1);
            assertEquals(result1.getStatusCode(), HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ResponseEntity<?> result2 = new RegisterClient().registerUser(userDataLayer2);
            assertEquals(result2.getStatusCode(), HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ResponseEntity<?> result3 = new RegisterClient().registerUser(userDataLayer3);
            assertEquals(result3.getStatusCode(), HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ResponseEntity<?> result4 = new RegisterClient().registerUser(userDataLayer4);
            assertEquals(result4.getStatusCode(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void login() {
        //Models from client
        UserRegisterClient userRegisterClient1 = new UserRegisterClient("userTestJunit1", "password", "TestName", "TestLastName", "birthday", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient2 = new UserRegisterClient("userTestJunit2", "password", "TestName", "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient3 = new UserRegisterClient("userTestJunit3", "password", "TestName", "TestLastName", "2019-12-16", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient4 = new UserRegisterClient("userTestJunit4", "password", "TestName", "TestLastName", "2019-12-16", "2019-12-16", "profilePicture");
        //Models for data layer
        UserDataLayer userDataLayer1 = new UserDataLayer(userRegisterClient1.getUsername(), userRegisterClient1.getPassword(), userRegisterClient1.getFirstName(), userRegisterClient1.getLastName(), userRegisterClient1.getBirthday(), userRegisterClient1.getDateJoined(), userRegisterClient1.getProfilePicture());
        UserDataLayer userDataLayer2 = new UserDataLayer(userRegisterClient2.getUsername(), userRegisterClient2.getPassword(), userRegisterClient2.getFirstName(), userRegisterClient2.getLastName(), userRegisterClient2.getBirthday(), userRegisterClient2.getDateJoined(), userRegisterClient2.getProfilePicture());
        UserDataLayer userDataLayer3 = new UserDataLayer(userRegisterClient3.getUsername(), userRegisterClient3.getPassword(), userRegisterClient3.getFirstName(), userRegisterClient3.getLastName(), userRegisterClient3.getBirthday(), userRegisterClient3.getDateJoined(), userRegisterClient3.getProfilePicture());
        UserDataLayer userDataLayer4 = new UserDataLayer(userRegisterClient4.getUsername(), userRegisterClient4.getPassword(), userRegisterClient4.getFirstName(), userRegisterClient4.getLastName(), userRegisterClient4.getBirthday(), userRegisterClient4.getDateJoined(), userRegisterClient4.getProfilePicture());


        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test1 = restUtility.postForEntity(DataLayerURI + "/auth/login", userDataLayer1, userDataLayer1.getClass());
            assertEquals(test1.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test2 = restUtility.postForEntity(DataLayerURI + "/auth/login", userDataLayer2, userDataLayer2.getClass());
            assertEquals(test2.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test3 = restUtility.postForEntity(DataLayerURI + "/auth/login", userDataLayer3, userDataLayer3.getClass());
            assertEquals(test3.getStatusCode(), HttpStatus.BAD_REQUEST);
        });

        //This doesn't work because I didn't register the user so actually it is expected
        ResponseEntity<?> test4 = restUtility.postForEntity(DataLayerURI + "/auth/login", userDataLayer4, userDataLayer4.getClass());
        assertEquals(test4.getStatusCode(), HttpStatus.OK);


    }
}