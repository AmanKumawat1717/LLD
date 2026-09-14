package com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.synchronizedInitialization;

import com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.eagerInitialization.DBConnection;

public class DBConnectionSync {
    private static DBConnectionSync dbConnectionSync;
    private DBConnectionSync(){

    }
    public synchronized static DBConnectionSync getInstance(){
        if (dbConnectionSync==null){
            dbConnectionSync = new DBConnectionSync();
        }
        return dbConnectionSync;
    }
}
