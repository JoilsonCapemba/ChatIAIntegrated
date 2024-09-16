/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatiaintegrated;

import com.mycompany.chatiaintegrated.Controller.IntegrationWithAIController;
import com.mycompany.chatiaintegrated.View.ChatView;



/**
 *
 * @author joils
 */
public class ChatIAIntegrated {

    public static void main(String[] args) {
        IntegrationWithAIController chat = new IntegrationWithAIController();
        //System.out.println(chat.chatresponse("Qual o nome do presidente de Angola"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatView().setVisible(true);
            }
        });
    }
}
