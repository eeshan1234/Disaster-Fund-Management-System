package com.example.disastermanagement;



public class FireModel {
    public String title;

    public String link;


    FireModel()
    {

    }
    FireModel(String a, String c)
    {
        title=a;

        link=c;



    }



    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }


    }

