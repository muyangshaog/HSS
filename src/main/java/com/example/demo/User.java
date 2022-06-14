package com.example.demo;

public class User {
    String id;
    String emailaddress;
    String password;

    public User(String id, String email, String password){
        this.id = id;
        this.emailaddress = email;
        this.password = password;
    }

    private void setid(String id){
        this.id = id;
    }

    private void setemail(String email){
        this.emailaddress = email;
    }

    private void setpassword(String password){
        this.password = password;
    }

    private String getid(){
        return id;
    }

    private String getmail(){
        return emailaddress;
    }

    private String getpassword(){
        return password;
    }
} 
