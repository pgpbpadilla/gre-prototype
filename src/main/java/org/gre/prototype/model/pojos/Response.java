/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.pojos;

/**
 *
 * @author ppadilla
 */
public class Response {
    int code;
    String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
            
    
            
}

