package org.acmefireworks;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1058576983324511982L;

    private String firstname;
    private String surname;

    public Person()
    {

    }

    public Person(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!(firstname != null ? !firstname.equals(person.firstname) : person.firstname != null) && !(surname != null ? !surname.equals(person.surname) : person.surname != null))
            return true;
        else return false;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
