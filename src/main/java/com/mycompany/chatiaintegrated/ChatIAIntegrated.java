/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatiaintegrated;

import com.mycompany.chatiaintegrated.Controller.Chat;
import com.mycompany.chatiaintegrated.View.ChatView;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/**
 *
 * @author joils
 */
public class ChatIAIntegrated {

    public static void main(String[] args) {
        Chat chat = new Chat();
        //System.out.println(chat.chatresponse("Qual o nome do presidente de Angola"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatView().setVisible(true);
            }
        });
    }
}
