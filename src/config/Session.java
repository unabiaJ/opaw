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

    /** Returns the single Session instance (creates it if needed). */
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    /** Clears the session (call on logout). */
    public static void clearSession() {
        instance = null;
    }

    /**
     * Returns true if a user is currently logged in
     * (i.e., a session exists AND has a valid user ID).
     */
    public static boolean isLoggedIn() {
        return instance != null && instance.id > 0;
    }

    /**
     * REQUIRED LOGIN GUARD — call this at the top of every form constructor
     * (except LoginForm and RegisterForm).
     *
     * If no active session is found, shows a warning, disposes the caller,
     * and redirects to LoginForm automatically.
     *
     * Usage inside any form constructor:
     *   initComponents();
     *   if (!Session.requireLogin(this)) return;  // stop init if not logged in
     *   // ... rest of constructor safely runs only when logged in
     *
     * @return true  if the user IS logged in (safe to continue)
     *         false if the user is NOT logged in (form will be disposed)
     */
    public static boolean requireLogin(javax.swing.JFrame caller) {
        if (!isLoggedIn()) {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "You must be logged in to access this page.\nRedirecting to login...",
                "Access Denied",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            if (caller != null) caller.dispose();
            javax.swing.SwingUtilities.invokeLater(() -> new views.LoginForm().setVisible(true));
            return false;
        }
        return true;
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