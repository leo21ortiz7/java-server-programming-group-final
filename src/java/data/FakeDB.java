/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashMap;

/**
 *
 * @author Fred Scott Southeast Community College INFO
 */

//Before you get your DB up and running you can use this to test login system.
//
public class FakeDB {
    public static String getPasswordForUsername(String username) {
        HashMap<String, String> users = new HashMap();
        users.put("billg", "$$$");
        users.put("stevej", "$$$");
        users.put("bezos", "notpassword");
        
        if(users.containsKey(username)) {
            return users.get(username);
        } else {
            return null;
        }
    }
}
