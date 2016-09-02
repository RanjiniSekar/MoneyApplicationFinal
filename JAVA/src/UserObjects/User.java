package UserObjects;

/**
*
* @author agiria
*/

public abstract class User {

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
