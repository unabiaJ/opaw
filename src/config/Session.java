/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 * Singleton class to hold the currently logged-in user's session data.
 * Call Session.getInstance() anywhere to get or set session values.
 *
 * @author Administrator
 */
public class Session {

    private static Session instance;

    private int    id;
    private String fname;
    private String lname;
    private String email;
    private String username;
    private String status;
    private String type;

    // Private constructor — use getInstance()
    private Session() { }

    /**
     * Returns the single Session instance (creates it if needed).
     */
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    /**
     * Clears the session (call on logout).
     */
    public static void clearSession() {
        instance = null;
    }

    // ── Getters ──────────────────────────────────────────────────────────
    public int    getId()       { return id; }
    public String getFname()    { return fname; }
    public String getLname()    { return lname; }
    public String getEmail()    { return email; }
    public String getUsername() { return username; }
    public String getStatus()   { return status; }
    public String getType()     { return type; }

    // ── Setters ──────────────────────────────────────────────────────────
    public void setId(int id)           { this.id = id; }
    public void setFname(String fname)  { this.fname = fname; }
    public void setLname(String lname)  { this.lname = lname; }
    public void setEmail(String email)  { this.email = email; }
    public void setUsername(String u)   { this.username = u; }
    public void setStatus(String s)     { this.status = s; }
    public void setType(String type)    { this.type = type; }
}