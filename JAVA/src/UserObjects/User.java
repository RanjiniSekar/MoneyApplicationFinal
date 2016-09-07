package UserObjects;

/**
*
* @author agiria
*/

public abstract class User {

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public long getU_id() {
        return u_id;
    }

    public User(String username, String tempPass) {
        this.username = username;
        this.password = tempPass;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", name=" + name + ", password=" + password + ", user_type=" + user_type + ", id=" + u_id + '}';
    }

    public String getPassword() {
        return password;
    }

    int firstTime;
    String username;
    String name;
    String password;
    String user_type;
    long u_id;
    
    public User(String name, String username, String temppass, String usertype) {
        this.username = username;
        this.name = name;
        this.password = temppass;
        this.user_type = usertype;
    }

    public String getUserType() {
        return this.user_type; //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return this.username;
    }
	
}
