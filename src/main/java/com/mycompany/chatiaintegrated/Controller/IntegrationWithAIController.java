package com.mycompany.chatiaintegrated.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;




/**
 *
 * @author joils
*/

public class IntegrationWithAIController {
        
    //este é o metodo que faz a comunicação com a IA do Gemini retornando assim a resposta para a interface do usuario (View)
    
       public String chatresponse(String question) {
        HttpClient client = HttpClient.newHttpClient();
        String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\""+question+"\"}]}]}";
        
        
        try {
        
            PropetiesReader propertiesReader = new PropetiesReader();
           
            String apiUrl = propertiesReader.readUrlPropretie();
        

        
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
 


            if (response.statusCode() == 200) {
                return filterResponseInJson(response.body());
                
                
            } else {
                System.out.println("Request failed with status code: " + response.statusCode());
                
            }
        } catch (Exception e) {
            return e.getMessage();
            
        }
        
        return "****";
       
    }
    
       
    //Este metodo foi usado para filtrar a resposta vinda da IA Gemini pegando assim o valor do campo text que é onde esta a resposta que interessa ao utilizador 
       
    public String filterResponseInJson(String geminiResponse) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(geminiResponse);
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
