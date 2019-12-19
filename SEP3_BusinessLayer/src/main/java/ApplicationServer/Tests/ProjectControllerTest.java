package ApplicationServer.Tests;

import ApplicationServer.Controllers.ControllerConfiguration;
import ApplicationServer.Model.ClientModels.ProjectClient;
import ApplicationServer.Model.DataLayerModels.ProjectDataLayer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectControllerTest extends ControllerConfiguration {

    @BeforeEach
    void setUp() {
        //Data tier has to be running
    }

    @Test
    void getProject() {
        String businessTierUrl = "http://" + "localhost" + ":8081/";
        String jsonProjects1 = restUtility.getForObject(businessTierUrl + "/api/project?username=", String.class);
        String jsonProjects2 = restUtility.getForObject(businessTierUrl + "/api/project?username=admin", String.class);
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            restUtility.getForObject(businessTierUrl + "/api/project", String.class);
        });
        try {
            List<ProjectDataLayer> projectsFromDataLayer1 = jsonMapper.readValue(jsonProjects1, new TypeReference<List<ProjectDataLayer>>(){});
            List<ProjectDataLayer> projectsFromDataLayer2 = jsonMapper.readValue(jsonProjects2, new TypeReference<List<ProjectDataLayer>>(){});
            assertEquals(0, projectsFromDataLayer1.size());
            assertNotEquals(0, projectsFromDataLayer2.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        List <String> admins = new ArrayList<>();
        admins.add("admin");
        admins.add("user");
        List<String> emptyAdmins = new ArrayList<>();
        List<String> nonExistantUsersAsAdmins = new ArrayList<>();
        nonExistantUsersAsAdmins.add("your mom");
        //Models from client
        ProjectClient projectClient1 = new ProjectClient(-1, "NameOfTheProject1", "ONGOING", 3, 3, admins);
        ProjectClient projectClient2 = new ProjectClient(1, "NameOfTheProject2", "ONGOING", 3, 3, admins);
        ProjectClient projectClient3 = new ProjectClient(0, "NameOfTheProject3", "ONGOING", 3, 3, admins);
        ProjectClient projectClient4 = new ProjectClient(-1, null, "ONGOING", 3, 3, admins);
        ProjectClient projectClient5 = new ProjectClient(-1, "NameOfTheProject4", null, 3, 3, admins);
        ProjectClient projectClient6 = new ProjectClient(-1, "NameOfTheProject5", "COMPLETED", 3, 3, admins);
        ProjectClient projectClient7 = new ProjectClient(-1, "NameOfTheProject6", "ONGOING", 0, 3, admins);
        ProjectClient projectClient8 = new ProjectClient(-1, "NameOfTheProject7", "ONGOING", 3, 0, admins);
        ProjectClient projectClient9 = new ProjectClient(-1, "NameOfTheProject8", "ONGOING", 0, 0, admins);
        ProjectClient projectClient10 = new ProjectClient(-1, "NameOfTheProject8", "random String", 0, 0, admins);
        ProjectClient projectClient11 = new ProjectClient(-1, "NameOfTheProject8", "ONGOING", 0, 0, emptyAdmins);
        ProjectClient projectClient12 = new ProjectClient(-1, "NameOfTheProject8", "ONGOING", 0, 0, nonExistantUsersAsAdmins);

    }

    @Test
    void getUsersInProjects() {
    }

    @Test
    void getUsersOutsideProjects() {
    }

    @Test
    void addUserToProject() {
    }

    @Test
    void removeUserFromProject() {
    }

    @Test
    void assignAdmin() {
    }

    @Test
    void removeAdmin() {
    }
}
