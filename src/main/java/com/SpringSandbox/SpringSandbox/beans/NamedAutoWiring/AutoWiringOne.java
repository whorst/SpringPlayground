package com.SpringSandbox.SpringSandbox.beans.NamedAutoWiring;

public class AutoWiringOne {
    private AutoWiringTwo autoWiringTwo;

    public void setAutoWiringTwo( AutoWiringTwo autoWiringTwo) {
        //The Spring Container Understands that this is the link which allows for named autowiring
        this.autoWiringTwo = autoWiringTwo;
    }
    public void autoWireTwoSpeak() {
        autoWiringTwo.autoWiringTwoSpeak();
    }
}
