package com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.eagerInitialization;

public class DBConnection {

    public static DBConnection conn = new DBConnection();

    private DBConnection(){

    }
    public static DBConnection getInstance(){
        return conn;
    }

}
