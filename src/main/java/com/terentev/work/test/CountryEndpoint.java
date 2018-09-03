package com.terentev.work.test;

import com.terentev.work.file.GetCommerceMLRequest;
import com.terentev.work.file.GetCommerceMLResponse;
import com.terentev.work.file.GetFileRequest;
import com.terentev.work.file.GetFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.mime.Attachment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Endpoint
@ComponentScan("repository")
public class CountryEndpoint {

    @Autowired
    SaajSoapMessageFactory saajSoapMessageFactory;

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(localPart = "getFileRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetFileResponse getFile(@RequestPayload GetFileRequest request, MessageContext context) {

/*        SaajSoapMessageFactory factory = null;
        try {
            factory = new SaajSoapMessageFactory(MessageFactory.newInstance());
        } catch (SOAPException e) {
            e.printStackTrace();
        }*/
        SaajSoapMessage message = saajSoapMessageFactory.createWebServiceMessage();

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


    @PayloadRoot(localPart = "getCommerceMLRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetCommerceMLResponse getCommerceMLResponse(@RequestPayload GetCommerceMLRequest request, MessageContext context) {

        System.out.println("---------------------------------------");
        System.out.println(request.getName());
        System.out.println("---------------------------------------");

        SaajSoapMessage message = (SaajSoapMessage) context.getRequest();



        Iterator attachmentIterator = message.getAttachments();
        Set<Attachment> attachmentSet = new HashSet<>();
        if (attachmentIterator != null) {

            while (attachmentIterator.hasNext()) {

                attachmentSet.add((Attachment) attachmentIterator.next());
            }
        }

        File file = new File("import.xml");

        System.out.println("---------------------------------------");
        System.out.println(attachmentSet.size());
        System.out.println("---------------------------------------");

        for (Attachment attachment : attachmentSet) {

            try (OutputStream outputStream = new FileOutputStream(file)) {

                InputStream inputStream = attachment.getInputStream();

                byte bytes[] = new byte[1024];
                int length;

                while ((length = inputStream.read(bytes)) != -1) {

                    outputStream.write(bytes, 0, length);
                }
                inputStream.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }

        GetCommerceMLResponse commerceMLResponse = new GetCommerceMLResponse();
        commerceMLResponse.setName(request.getName());

        return commerceMLResponse;
    }
}
