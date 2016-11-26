/**
 * Created by Scynet on 25.11.2016.
 */
public class Player {
    String usename;
    String email;
    int agent;
    String fname;
    String lname;
    String city;
    int country;
    int street;
    String adress;
    int phone;
    int gender;

    public String getEmail() {
        return email;
    }

    public String getUsename() {
        return usename;
    }

    public int getAgent() {
        return agent;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCity() {
        return city;
    }

    public int getCountry() {
        return country;
    }

    public int getStreet() {
        return street;
    }

    public String getAdress() {
        return adress;
    }

    public int getPhone() {
        return phone;
    }

    public int getGender() {
        return gender;
    }


    Player(int maxagent,int maxcountry){
        Randomizer rs = new Randomizer();
        usename=rs.generate();
        email=usename.concat("@mail.ru");
        fname=rs.generate();
        lname=rs.generate();
        city=rs.generate();
        agent=rs.randInt(1,maxagent);
        country=rs.randInt(1,maxcountry);
        street=rs.randInt(1,100);
        adress=rs.generate();
        phone=rs.randInt(11111111,99999999);
        gender=rs.randInt(1,2);


    }
}
