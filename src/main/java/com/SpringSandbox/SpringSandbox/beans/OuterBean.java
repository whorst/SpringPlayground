package com.SpringSandbox.SpringSandbox.beans;

public class OuterBean {
    private InnerBean innerBean;

    // a setter method to inject the dependency.
    public void setInnerBean(InnerBean innerBean) {
        System.out.println("Inside setSpellChecker." );
        this.innerBean = innerBean;
    }

    // a getter method to return innerBean
    public InnerBean getInnerBean() {
        return innerBean;
    }
    public void innerBean() {
        innerBean.checkSpelling();
    }
}
