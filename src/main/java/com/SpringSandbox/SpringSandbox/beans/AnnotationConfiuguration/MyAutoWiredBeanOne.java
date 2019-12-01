package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;

import org.springframework.beans.factory.annotation.Autowired;

public class MyAutoWiredBeanOne {
    //https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm

    //The @AutoWired annotation has been created to get rid of some xml configuration. One can autowire on setter
    // methods, on properties, and on constructors

    //Objects can be autowired and any values (Integer, String) can be as well

    //Putting AutoWired on the property gets rid of the setter methods. The Spring Config will look for any existing objects of that
    //type
    @Autowired
    private MyAutoWiredBeanTwo myAutoWiredBeanTwo;
    private String MyVal;

    //@AutoWired
    //Putting AutoWired here does the same thing.
    public MyAutoWiredBeanOne(){
        System.out.println("In the constructor");
    }

    @Autowired(required = false)
    public void setMyVal(String myVal) {
        this.MyVal = myVal;
    }

    public String getMyVal()  {
        return this.MyVal;
    }


    //@Autowired
    //Putting AutoWired on the setter does the same thing
    public void setMyAutoWiredBeanTwo(MyAutoWiredBeanTwo bt){
        this.myAutoWiredBeanTwo = bt;
    }
}
