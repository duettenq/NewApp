package com.example.newapp;

public class Contact {

    String Name;
    String Id;

    public Contact(String id, String name) {
        Id = id;
        Name = name;
    }




    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
