/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.demo.tomreadyapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbutton
 */
public class ServerInfo {

    private String host = null;
    private String version = null;
    private String container = null;
    private List<String> errors = new ArrayList<>();

    private static ServerInfo instance = new ServerInfo();

    private ServerInfo() {
    }

    public static ServerInfo build() {

        ServerInfo instance = new ServerInfo();

        //
        // Get the host name
        //
        try {
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/uname", "-n");
            Process process = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            instance.host = br.readLine();
        } catch (Throwable ex) {
            instance.errors.add(ex.getMessage());
            ex.printStackTrace();
            instance.host = "Not available";
        }
        
        //
        // Get the host name
        //
        try {
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/uname", "-rs");
            Process process = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            instance.version = br.readLine();
        } catch (Throwable ex) {
            instance.errors.add(ex.getMessage());
            ex.printStackTrace();
            instance.version = "Not available";
        }
        
        //
        // Get the host name
        //
        try {
            instance.container = "Not available";
            ProcessBuilder pb = new ProcessBuilder("/usr/sbin/virtinfo");
            Process process = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            
            while ((line = br.readLine()) != null) {
                if(line.contains("current")) {
                    instance.container = line.substring(0,line.indexOf("current")).trim();
                }
            }
        } catch (Throwable ex) {
            instance.errors.add(ex.getMessage());
            ex.printStackTrace();
        }

        return instance;
    }

    public String getHost() {
        return this.host;
    }
    
    public String host() {
        return this.host;
    }

    public String getVersion() {
        return this.version;
    }

    public String version() {
        return this.version;
    }

    public String getContainer() {
        return container;
    }
    
    public String container() {
        return container;
    }

    public List<String> getErrors() {
        return errors;
    }
    
    public List<String> errors() {
        return errors;
    }

    public boolean hasErrors() {
        return errors.isEmpty() ? false : true;
    }

}
