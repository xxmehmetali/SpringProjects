package com.spring.l10springdetails.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @PostMapping("/test/{name}")
    public String test(@RequestHeader String a,
                       @RequestHeader String b,
                       @RequestHeader String c,
                       @PathVariable String name,
                       @RequestBody String body,
                       HttpServletResponse response
    ){
        response.addHeader("test", "good");
        return "a:" + a + " " + "b:" + b + " c:" + c + " name:" + name +
                " body:" + body;
    }

    /**
     * Getting all the headers
     * response body:
          {
              "a": "1",
              "b": "2",
              "c": "3",
              "content-type": "text/plain",
              "user-agent": "PostmanRuntime/7.32.3",
              "accept": "*\/*",
               "postman-token":"96660e7b-c4e9-4ee9-9486-1495b85d52c5",
               "host":"localhost:8080",
               "accept-encoding":"gzip, deflate, br",
               "connection":"keep-alive",
               "content-length":"12"
            }
     */
    @GetMapping("/getHeaders")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        return headers;
    }

    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPdf(){
        byte[] pdf = new byte[100];
        return pdf;
    }

}
