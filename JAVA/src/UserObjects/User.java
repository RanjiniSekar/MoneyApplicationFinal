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
    
    public User(String name, String username, String usertype) {
        this.name = name;
        this.username = username;
        this.usertype = usertype;
    }
	
}
