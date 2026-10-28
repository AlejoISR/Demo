package com.example.demo;

public class Option <T> {
    private  final String text;

    private final T object;

    public Option (String text, T object ){
        this.text=text;
        this.object = object;
    }

    public T getObject(){
        return object;
    }

    @Override

    public String toString (){
        return text;
    }
}
