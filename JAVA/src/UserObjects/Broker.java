package UserObjects;

public class Broker {
    
    public Broker(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
	
	long brokerId;
	String email;
        String name;

}
