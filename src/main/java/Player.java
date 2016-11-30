/**
 * Created by Scynet on 25.11.2016.
 */
public class Player {
    String usename;
    String pass;
    String email;
    int agent;
    String fname;
    String lname;
    String city;
    int country;
    String adress;
    int phone;
    int gender;


    public String getPass() {
        return pass;
    }


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



    public String getAdress() {
        return adress;
    }

    public int getPhone() {
        return phone;
    }

    public int getGender() {
        return gender;
    }

    Player(int maxagent,int maxcountry,boolean reg,String prevname){
        Randomizer rs = new Randomizer();
        if(!reg)usename=rs.generate();
        else usename=prevname;
        pass=rs.generate();
        email=rs.generate().concat("@mail.ru");
        fname=rs.generate();
        lname=rs.generate();
        city=rs.generate();
        agent=rs.randInt(1,maxagent);
        country=rs.randInt(1,maxcountry);
        adress=rs.generate();
        phone=rs.randInt(11111111,99999999);
        gender=rs.randInt(1,2);


    }
}
