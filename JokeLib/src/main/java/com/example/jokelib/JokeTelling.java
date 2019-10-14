package com.example.jokelib;

import java.util.Random;

public class JokeTelling {
    String[] jokes = {
            "One shop owner asks another, “So, have you had any reactions yet to your ad that you’re looking for a night guard?\n" +
                    "Yeah, we got robbed tonight.", "The guy who gives out food at the prison canteen asks: “Eat here or take away?"
            ,"The prisoner frowns: “Not funny, Marlon! Not funny at all!!"
            , "Have you been sleeping by an open window, like I told you? asks a doctor his patient.\n" +
            "Yes, just like you said, doc.\n" +
            "And is the bronchitis gone now?\n" +
            "Not yet, so far the only things gone are my laptop and cellphone."};


    public String tellAJoke() {
        int rondom = new Random().nextInt(2);
        return jokes[rondom];
    }
}
