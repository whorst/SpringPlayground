package com.SpringSandbox.SpringSandbox.beans.JavaConfiguration;

public class JavaConfigTwo {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
