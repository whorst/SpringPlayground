package com.SpringSandbox.SpringSandbox.TheSpringContext;

public class CEventHandlerClass {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
