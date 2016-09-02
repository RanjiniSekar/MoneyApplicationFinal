package UserObjects;

/**
*
* @author agiria
*/

public abstract class User {

    public User(String username, String tempPass) {
        this.username = username;
        this.tempPass = tempPass;
    }

    long id;
    String name;
    String username;
    String usertype;
    String tempPass;
    
    public User(String name, String username, String temppass, String usertype) {
        this.name = name;
        this.username = username;
        this.usertype = usertype;
        this.tempPass = temppass;
    }
	
}
