package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;

import org.springframework.beans.factory.annotation.Required;

public class MyAutoWiredBeanTwo {
    //https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm


    private String required;

    public void setRequired(String req){
        this.required = req;
    }

    public String getRequired(){
        return this.required;
    }

}
