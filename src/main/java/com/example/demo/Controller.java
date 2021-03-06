package com.example.demo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    User user1 = new User("1","test1@example.com","password");
    User user2 = new User("2","test2@example.com","password");
    
    //Create a user
    @CrossOrigin (origins = "*",maxAge = 3600)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createNewUser(@RequestParam(name = "id") String ID, HttpServletRequest request, HttpServletResponse response) {

        JsonObject user1Js= new JsonObject();
        user1Js.addProperty("id",user1.id);
        user1Js.addProperty("emailaddress",user1.emailaddress);

        JsonObject user2Js= new JsonObject();
        user2Js.addProperty("id",user2.id);
        user2Js.addProperty("eailaddress",user2.emailaddress);

        System.out.println(ID);
        System.out.println(user1Js.toString());

        if(ID.equals("1")){
            return user1Js.toString();
        }
        else
            return user2Js.toString();
    }   


    @CrossOrigin (origins = "*",maxAge = 3600)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, HttpServletResponse response) {

        JsonObject user1Js= new JsonObject();
        user1Js.addProperty("id",user1.id);
        user1Js.addProperty("emailaddress",user1.emailaddress);
        //user1Js.addProperty("password",user1.password);

        JsonObject user2Js= new JsonObject();
        user2Js.addProperty("id",user2.id);
        user2Js.addProperty("emailaddress",user2.emailaddress);
        //user1Js.addProperty("password",user1.password);

        JsonObject res = new JsonObject();
        res.add("1", user1Js);
        res.add("2", user2Js);

        return res.toString();
    }   

    @CrossOrigin (origins = "*",maxAge = 3600)
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = "application/json")
    public String auth(@RequestBody HashMap<String, String> user, HttpServletRequest request, HttpServletResponse response) {

        String email = user.get("emailaddress");
        String password = user.get("password");
        String failres = "Authentication failed!";

        JsonObject success= new JsonObject();
        success.addProperty("result","success!");

        JsonObject fail= new JsonObject();
        fail.addProperty("result","Authentication failed!");

        JsonObject user1Js= new JsonObject();
        //user1Js.addProperty("id",user1.id);
        user1Js.addProperty("emailaddress",user1.emailaddress);
        //user1Js.addProperty("password",user1.password);

        JsonObject user2Js= new JsonObject();
        //user2Js.addProperty("id",user2.id);
        user2Js.addProperty("emailaddress",user2.emailaddress);

        if(password.equals(""))
        response.setStatus(400);

        if(email.equals("test1@example.com"))
        {
            if(password.equals(user1.password)){
                response.setStatus(200);
                return user1Js.toString();
            }
            else{
                response.setStatus(401);
            return failres.toString();
          }
        }
        else{
            if(password.equals(user2.password)){
                response.setStatus(200);
                return "[\"test2@example.com\"]";
            }
            else{
                response.setStatus(401);
            return failres.toString();
          }
        }
    }   

}