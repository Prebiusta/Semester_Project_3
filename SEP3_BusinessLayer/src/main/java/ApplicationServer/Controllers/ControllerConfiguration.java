package ApplicationServer.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ControllerConfiguration {
    private String DataLayerIP = "localhost";
    private String DataLayerPORT = "8080";
    protected final String DataLayerURI = "http://" + DataLayerIP + ":" + DataLayerPORT;
    protected final RestTemplate restUtility = new RestTemplate();
    protected final ObjectMapper jsonMapper = new ObjectMapper();
}
