package com.edu.access.parent;

public class Parent2 {
    public String publicVar = "publicVar";
    protected String protectedVar = "protectedVar";
    String var = "var";
    private String privateVar = "priavateVar";

    public Parent2(){}

    public void access() {
        System.out.println("Access Modifier Test...");
    }
}
