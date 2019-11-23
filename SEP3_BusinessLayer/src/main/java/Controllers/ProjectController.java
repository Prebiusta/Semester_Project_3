package Controllers;

import Models.ClientModels.ClientProject;
import Models.DataLayerModels.DataLayerProject;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("api/project")
public class ProjectController extends ControllerConfiguration{

    /**
     * HTTP Method to get all projects.
     *
     * Endpoint URL: http://{Host IP}:{Port IP <default 8081>}/SEP3_BusinessLayer/api/project
     * @return list of all projects
     */

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {
        Response response = target.path("api").path("project").request(MediaType.APPLICATION_JSON).get();
        try {
            List<DataLayerProject> projects = mapper.readValue(response.readEntity(String.class), new TypeReference<List<DataLayerProject>>(){});
            return Response.ok(projects, MediaType.APPLICATION_JSON).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    /**
     * HTTP Method to get project by its ID. (Wrong implementation on data layer side therefore doesn't work)
     *
     * Endpoint URL: http://{Host IP}:{Port IP <default 8081>}/SEP3_BusinessLayer/api/project/{id}
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("id") String id) {
        Response response = target.path("api").path("project").path("id").request(MediaType.APPLICATION_JSON).get();
        try {
            DataLayerProject project = mapper.readValue(response.readEntity(String.class), DataLayerProject.class);
            return Response.ok(project, MediaType.APPLICATION_JSON).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }

    }
//Not implemented
    @Path("createProject")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(ClientProject project) {
        DataLayerProject dataLayerProject = new DataLayerProject(project.getProjectId(), project.getName(), project.getStatus(), project.getNumberOfIterations(), project.getLengthOfSprint());
        return target.path("api").path("project").path("createProject").request(MediaType.APPLICATION_JSON).post(Entity.entity(dataLayerProject, MediaType.APPLICATION_JSON));
    }
}
