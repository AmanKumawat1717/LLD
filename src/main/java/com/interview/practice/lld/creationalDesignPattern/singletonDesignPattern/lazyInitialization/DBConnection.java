package com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.lazyInitialization;

public class DBConnection {

    public static DBConnection conn;

    private DBConnection(){

    }
    public static DBConnection getInstance(){
       if(conn==null){
           conn = new DBConnection();
       }
       return conn;
    }

}