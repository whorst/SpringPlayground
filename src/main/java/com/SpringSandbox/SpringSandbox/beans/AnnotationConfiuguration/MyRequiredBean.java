package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;

import org.springframework.beans.factory.annotation.Required;

public class MyRequiredBean {
    //tutorialspoint.com/spring/spring_required_annotation.htm

    //The @Required annotation applies to bean property setter methods and it indicates that the affected bean property
    // must be populated in XML configuration file at configuration time. Otherwise, the container throws a
    // BeanInitializationException exception

    private String required;

    @Required
    public void setRequired(String req){
        this.required = req;
    }

    public String getRequired(){
        return this.required;
    }

}
