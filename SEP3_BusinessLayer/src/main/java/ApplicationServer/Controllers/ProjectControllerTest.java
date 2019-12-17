package ApplicationServer.Controllers;

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
        //Models for data tier
        ProjectDataLayer projectForDataLayer1 = new ProjectDataLayer(projectClient1.getName(), projectClient1.getStatus(), projectClient1.getNumberOfIterations(), projectClient1.getLengthOfSprint(), projectClient1.getAdmins());
        ProjectDataLayer projectForDataLayer2 = new ProjectDataLayer(projectClient2.getName(), projectClient2.getStatus(), projectClient2.getNumberOfIterations(), projectClient2.getLengthOfSprint(), projectClient2.getAdmins());
        ProjectDataLayer projectForDataLayer3 = new ProjectDataLayer(projectClient3.getName(), projectClient3.getStatus(), projectClient3.getNumberOfIterations(), projectClient3.getLengthOfSprint(), projectClient3.getAdmins());
        ProjectDataLayer projectForDataLayer4 = new ProjectDataLayer(projectClient4.getName(), projectClient4.getStatus(), projectClient4.getNumberOfIterations(), projectClient4.getLengthOfSprint(), projectClient4.getAdmins());
        ProjectDataLayer projectForDataLayer5 = new ProjectDataLayer(projectClient5.getName(), projectClient5.getStatus(), projectClient5.getNumberOfIterations(), projectClient5.getLengthOfSprint(), projectClient5.getAdmins());
        ProjectDataLayer projectForDataLayer6 = new ProjectDataLayer(projectClient6.getName(), projectClient6.getStatus(), projectClient6.getNumberOfIterations(), projectClient6.getLengthOfSprint(), projectClient6.getAdmins());
        ProjectDataLayer projectForDataLayer7 = new ProjectDataLayer(projectClient7.getName(), projectClient7.getStatus(), projectClient7.getNumberOfIterations(), projectClient7.getLengthOfSprint(), projectClient7.getAdmins());
        ProjectDataLayer projectForDataLayer8 = new ProjectDataLayer(projectClient8.getName(), projectClient8.getStatus(), projectClient8.getNumberOfIterations(), projectClient8.getLengthOfSprint(), projectClient8.getAdmins());
        ProjectDataLayer projectForDataLayer9 = new ProjectDataLayer(projectClient9.getName(), projectClient9.getStatus(), projectClient9.getNumberOfIterations(), projectClient9.getLengthOfSprint(), projectClient9.getAdmins());
        ProjectDataLayer projectForDataLayer10 = new ProjectDataLayer(projectClient10.getName(), projectClient10.getStatus(), projectClient10.getNumberOfIterations(), projectClient10.getLengthOfSprint(), projectClient10.getAdmins());
        ProjectDataLayer projectForDataLayer11 = new ProjectDataLayer(projectClient11.getName(), projectClient11.getStatus(), projectClient11.getNumberOfIterations(), projectClient11.getLengthOfSprint(), projectClient11.getAdmins());
        ProjectDataLayer projectForDataLayer12 = new ProjectDataLayer(projectClient12.getName(), projectClient12.getStatus(), projectClient12.getNumberOfIterations(), projectClient12.getLengthOfSprint(), projectClient12.getAdmins());

        
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