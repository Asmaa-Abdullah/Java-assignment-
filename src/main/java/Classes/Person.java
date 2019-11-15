package Classes;

public class Person {
    private String firstName;
    private String surName;
    private String gender;


    public Person(String firstName, String surName, String gender) {
        this.firstName = firstName;
        this.surName = surName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                 firstName + " " + surName  + " , " + gender  ;
    }
}
