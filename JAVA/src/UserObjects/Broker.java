package UserObjects;

public class Broker {

    long b_id;
    String email;
    String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
        return b_id;
    }

    public void setBrokerId(long brokerId) {
        this.b_id = brokerId;
    }

}
