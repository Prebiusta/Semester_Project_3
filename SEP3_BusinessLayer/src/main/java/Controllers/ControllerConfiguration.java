package Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ControllerConfiguration {
    private final static String DATA_LAYER_IP = "192.168.87.103";
    private final static String DATA_LAYER_PORT = "8080";
    protected final String DATA_LAYER_URI = "http://" + DATA_LAYER_IP + ":" + DATA_LAYER_PORT;
    protected Client client = ClientBuilder.newClient();
    ObjectMapper mapper = new ObjectMapper();
    WebTarget target = client.target(DATA_LAYER_URI);
}
