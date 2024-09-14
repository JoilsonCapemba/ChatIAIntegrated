package com.mycompany.chatiaintegrated.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author joils
*/

public class Chat {
       public String chatresponse(String question) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="+"AIzaSyBJ-qxWbGMLprXMiuK_yl0Yqf08-xccMn8";
        String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\""+question+"\"}]}]}";
       
        
        
        
        
        

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
 


            if (response.statusCode() == 200) {
                return bestResponse(response.body());
               
            } else {
                System.out.println("Request failed with status code: " + response.statusCode());
               
            }
        } catch (Exception e) {
            return e.getMessage();
            
        }
        
        return "****";
       
    }
    
       
     
       
    public String bestResponse(String resposta) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(resposta);
        String textValue = rootNode.path("candidates")
                                  .get(0) 
                                  .path("content")
                                  .path("parts")
                                  .get(0) 
                                  .path("text")
                                  .asText();

        return textValue;
    }
}
