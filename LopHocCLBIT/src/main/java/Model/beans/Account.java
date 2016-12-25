/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.beans;

/**
 *
 * @author DatNguyen
 */
public class Account {
    private String id;
    private String userName;
    private String passWord;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Account(String username, String password) {
        this.userName = userName;
        this.passWord = passWord;
    }
    
    
}
