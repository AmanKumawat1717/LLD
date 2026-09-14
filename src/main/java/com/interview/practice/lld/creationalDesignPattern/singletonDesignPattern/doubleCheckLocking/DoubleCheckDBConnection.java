package com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.doubleCheckLocking;

public class DoubleCheckDBConnection {
    public volatile static DoubleCheckDBConnection doubleCheckDBConnection;
    private DoubleCheckDBConnection(){

    }
    public static DoubleCheckDBConnection getInstance(){
        if(doubleCheckDBConnection == null){
            synchronized (DoubleCheckDBConnection.class){
                if(doubleCheckDBConnection==null) {
                    doubleCheckDBConnection = new DoubleCheckDBConnection();
                    return doubleCheckDBConnection;
                }
            }
        }
        return doubleCheckDBConnection;
    }

}
