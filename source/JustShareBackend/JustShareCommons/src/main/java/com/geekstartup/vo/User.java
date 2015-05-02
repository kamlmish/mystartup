/**
 * 
 */
package com.geekstartup.vo;

import java.util.Date;



/**
 * @author tanmoy.banerjee
 *
 */
public class User extends BaseObject {

    private String userID;
    private String userEmail;
    private String password;
    private Date loginTime;
    private String ipAdderss;

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginTime
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime the loginTime to set
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return the ipAdderss
     */
    public String getIpAdderss() {
        return ipAdderss;
    }

    /**
     * @param ipAdderss the ipAdderss to set
     */
    public void setIpAdderss(String ipAdderss) {
        this.ipAdderss = ipAdderss;
    }

    public void getLoginTime(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
