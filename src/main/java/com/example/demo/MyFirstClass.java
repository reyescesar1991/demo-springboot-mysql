package com.example.demo;

public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar){
        this.myVar = myVar;
    }

    public MyFirstClass(){

    }

    public String sayHello(){
        return "Hello World! From the MyFirstClass bean == myVar: " + myVar;
    }
}
