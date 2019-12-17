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
        //Start Business Tier
        //Start the Data Tier
    }

    @org.junit.jupiter.api.Test
    void register() {
        String businessTierUrl = "http://" + "localhost" + ":8081/";
        //Models from client
        UserRegisterClient userRegisterClient1 = new UserRegisterClient("userTestJunit", "password", "TestName", "TestLastName", "2019-12-16", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient2 = new UserRegisterClient(null, "password", "TestName", "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient3 = new UserRegisterClient("userTestJunit2", null, "TestName", "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient4 = new UserRegisterClient("userTestJunit4", "password", null, "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient5 = new UserRegisterClient("userTestJunit5", "password", "TestName", null, "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient6 = new UserRegisterClient("userTestJunit6", "password", "TestName", "TestLastName", null, "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient7 = new UserRegisterClient("userTestJunit7", "password", "TestName", "TestLastName", "birthday", null, "profilePicture");
        UserRegisterClient userRegisterClient8 = new UserRegisterClient("userTestJunit8", "password", "TestName", "TestLastName", "birthday", "2019-12-16", null);
        UserRegisterClient userRegisterClient9 = new UserRegisterClient(null, null, "TestName", "TestLastName", "2019-12-16", "dateJoined", "profilePicture");
        //Models for data layer
        UserDataLayer userDataLayer1 = new UserDataLayer(userRegisterClient1.getUsername(), userRegisterClient1.getPassword(), userRegisterClient1.getFirstName(), userRegisterClient1.getLastName(), userRegisterClient1.getBirthday(), userRegisterClient1.getDateJoined(), userRegisterClient1.getProfilePicture());
        UserDataLayer userDataLayer2 = new UserDataLayer(userRegisterClient2.getUsername(), userRegisterClient2.getPassword(), userRegisterClient2.getFirstName(), userRegisterClient2.getLastName(), userRegisterClient2.getBirthday(), userRegisterClient2.getDateJoined(), userRegisterClient2.getProfilePicture());
        UserDataLayer userDataLayer3 = new UserDataLayer(userRegisterClient3.getUsername(), userRegisterClient3.getPassword(), userRegisterClient3.getFirstName(), userRegisterClient3.getLastName(), userRegisterClient3.getBirthday(), userRegisterClient3.getDateJoined(), userRegisterClient3.getProfilePicture());
        UserDataLayer userDataLayer4 = new UserDataLayer(userRegisterClient4.getUsername(), userRegisterClient4.getPassword(), userRegisterClient4.getFirstName(), userRegisterClient4.getLastName(), userRegisterClient4.getBirthday(), userRegisterClient4.getDateJoined(), userRegisterClient4.getProfilePicture());
        UserDataLayer userDataLayer5 = new UserDataLayer(userRegisterClient5.getUsername(), userRegisterClient5.getPassword(), userRegisterClient5.getFirstName(), userRegisterClient5.getLastName(), userRegisterClient5.getBirthday(), userRegisterClient5.getDateJoined(), userRegisterClient5.getProfilePicture());
        UserDataLayer userDataLayer6 = new UserDataLayer(userRegisterClient6.getUsername(), userRegisterClient6.getPassword(), userRegisterClient6.getFirstName(), userRegisterClient6.getLastName(), userRegisterClient6.getBirthday(), userRegisterClient6.getDateJoined(), userRegisterClient6.getProfilePicture());
        UserDataLayer userDataLayer7 = new UserDataLayer(userRegisterClient7.getUsername(), userRegisterClient7.getPassword(), userRegisterClient7.getFirstName(), userRegisterClient7.getLastName(), userRegisterClient7.getBirthday(), userRegisterClient7.getDateJoined(), userRegisterClient7.getProfilePicture());
        UserDataLayer userDataLayer8 = new UserDataLayer(userRegisterClient8.getUsername(), userRegisterClient8.getPassword(), userRegisterClient8.getFirstName(), userRegisterClient8.getLastName(), userRegisterClient8.getBirthday(), userRegisterClient8.getDateJoined(), userRegisterClient8.getProfilePicture());
        UserDataLayer userDataLayer9 = new UserDataLayer(userRegisterClient9.getUsername(), userRegisterClient9.getPassword(), userRegisterClient9.getFirstName(), userRegisterClient9.getLastName(), userRegisterClient9.getBirthday(), userRegisterClient9.getDateJoined(), userRegisterClient9.getProfilePicture());


        ResponseEntity result1 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer1, userDataLayer1.getClass());
        assertEquals(result1.getStatusCode(), HttpStatus.OK);

        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result2 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer1, userDataLayer1.getClass());
            assertEquals(result2.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result3 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer2, userDataLayer2.getClass());
            assertEquals(result3.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result4 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer3, userDataLayer3.getClass());
            assertEquals(result4.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result5 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer4, userDataLayer4.getClass());
            assertEquals(result5.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result6 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer5, userDataLayer5.getClass());
            assertEquals(result6.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result7 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer6, userDataLayer6.getClass());
            assertEquals(result7.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result8 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer7, userDataLayer7.getClass());
            assertEquals(result8.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result9 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer8, userDataLayer8.getClass());
            assertEquals(result9.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity result10 = restUtility.postForEntity(businessTierUrl + "/api/register", userDataLayer9, userDataLayer9.getClass());
            assertEquals(result10.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
    }

    @org.junit.jupiter.api.Test
    void login() {
        String businessTierUrl = "http://" + "localhost" + ":8081/";
        //Models from client
        UserRegisterClient userRegisterClient1 = new UserRegisterClient(null, "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", "TestName", "TestLastName", "birthday", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient2 = new UserRegisterClient("user", null, "TestName", "TestLastName", "birthday", "2019-12-16", "profilePicture");
        UserRegisterClient userRegisterClient3 = new UserRegisterClient(null, null, "TestName", "TestLastName", "2019-12-16", "dateJoined", "profilePicture");
        UserRegisterClient userRegisterClient4 = new UserRegisterClient("user", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", "TestName", "TestLastName", "2019-12-16", "2019-12-16", "profilePicture");
        //Models for data layer
        UserDataLayer userDataLayer1 = new UserDataLayer(userRegisterClient1.getUsername(), userRegisterClient1.getPassword(), userRegisterClient1.getFirstName(), userRegisterClient1.getLastName(), userRegisterClient1.getBirthday(), userRegisterClient1.getDateJoined(), userRegisterClient1.getProfilePicture());
        UserDataLayer userDataLayer2 = new UserDataLayer(userRegisterClient2.getUsername(), userRegisterClient2.getPassword(), userRegisterClient2.getFirstName(), userRegisterClient2.getLastName(), userRegisterClient2.getBirthday(), userRegisterClient2.getDateJoined(), userRegisterClient2.getProfilePicture());
        UserDataLayer userDataLayer3 = new UserDataLayer(userRegisterClient3.getUsername(), userRegisterClient3.getPassword(), userRegisterClient3.getFirstName(), userRegisterClient3.getLastName(), userRegisterClient3.getBirthday(), userRegisterClient3.getDateJoined(), userRegisterClient3.getProfilePicture());
        UserDataLayer userDataLayer4 = new UserDataLayer(userRegisterClient4.getUsername(), userRegisterClient4.getPassword(), userRegisterClient4.getFirstName(), userRegisterClient4.getLastName(), userRegisterClient4.getBirthday(), userRegisterClient4.getDateJoined(), userRegisterClient4.getProfilePicture());


        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test1 = restUtility.postForEntity(businessTierUrl + "/auth/login", userDataLayer1, userDataLayer1.getClass());
            assertEquals(test1.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test2 = restUtility.postForEntity(businessTierUrl + "/auth/login", userDataLayer2, userDataLayer2.getClass());
            assertEquals(test2.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> test3 = restUtility.postForEntity(businessTierUrl + "/auth/login", userDataLayer3, userDataLayer3.getClass());
            assertEquals(test3.getStatusCode(), HttpStatus.BAD_REQUEST);
        });

        //This doesn't work because I didn't register the user so actually it is expected
        ResponseEntity<?> test4 = restUtility.postForEntity(DataLayerURI + "/auth/login", userDataLayer4, userDataLayer4.getClass());
        assertEquals(test4.getStatusCode(), HttpStatus.OK);


    }
}