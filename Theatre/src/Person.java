public class Person {
    public String name;
    public String surname;
    public String email;
    // Constructor with name, surname and email parameters
     public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    // Getters and setters for the attributes
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surename) {
        this.surname = surename;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


