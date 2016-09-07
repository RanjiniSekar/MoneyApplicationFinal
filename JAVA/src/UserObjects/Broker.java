package UserObjects;

public class Broker {
    
	long brokerId;
	String email;
    String name;
    
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

	public long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}

}
