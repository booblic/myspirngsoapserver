package system;

import file.GetFileRequest;
import file.GetFileResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;


@Endpoint
@ComponentScan("repository")
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(localPart = "getFileRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetFileResponse getFile(@RequestPayload GetFileRequest request, MessageContext context) {

        SaajSoapMessageFactory factory = null;
        try {
            factory = new SaajSoapMessageFactory(MessageFactory.newInstance());
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        SaajSoapMessage message = factory.createWebServiceMessage();

        System.out.println("---------------------------------------");
        System.out.println(request.getName());
        System.out.println("---------------------------------------");

        GetFileResponse response = new GetFileResponse();

        response.setName(request.getName());

/*        byte[] bytesFile = null;

        try {
            bytesFile = Files.readAllBytes(Paths.get("test.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        DataHandler dataHandler = new DataHandler(new FileDataSource("test.xml"));

        message.addAttachment("xml", dataHandler);

        context.setResponse(message);

        //StreamSource streamSource1 = new StreamSource(new File("test.xml"));

        return response;
    }
}