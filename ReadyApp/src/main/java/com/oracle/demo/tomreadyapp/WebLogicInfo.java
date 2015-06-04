/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.demo.tomreadyapp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbutton
 */
public class WebLogicInfo {
    private String version = null;
    private String name = null;
    
    private static WebLogicInfo instance = new WebLogicInfo();

    private WebLogicInfo() {
    }
    
    public static WebLogicInfo build()  {
        
        WebLogicInfo instance = new WebLogicInfo();
        
        // Get the version info
        try {
            Class versionClass = Class.forName("weblogic.version");
            Object versionObj = versionClass.newInstance();
            //Method getVersions = versionClass.getMethod("getVersions", null);
            Method getVersions = versionClass.getMethod("getReleaseBuildVersion", null);
            instance.version = getVersions.invoke(versionObj, null).toString();
            
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(WebLogicInfo.class.getName()).log(Level.SEVERE, null, ex);
            instance.version = "Not available";
        }
        
        // Get the server name
        instance.name = System.getProperty("weblogic.Name", "weblogic.Name");
        
        return instance;
    }

    public String getName() {
        return name;
    }
    public String name() {
        return this.name;
    }
    
    public  String getVersion() {
        return version;
    }
    
    public String version() {
        return this.version;
    }
    
    
    
    
    
    
    
    
    
}
