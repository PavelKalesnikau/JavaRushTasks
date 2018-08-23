package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isMale != user.isMale) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return country == user.country;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
    public void save(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(firstName);
        printWriter.println(lastName);
        // date saving
        SimpleDateFormat sdf = new SimpleDateFormat();
        printWriter.println(sdf.format(birthDate));

        printWriter.println(isMale);
        printWriter.println(country.getDisplayedName());
        printWriter.flush();
    }
    public void load(BufferedReader reader) throws IOException, ParseException {
        firstName = reader.readLine();
        lastName = reader.readLine();

        // date reading
        SimpleDateFormat sdf = new SimpleDateFormat();
        birthDate = sdf.parse(reader.readLine());

        isMale = Boolean.parseBoolean(reader.readLine());

        // country reading
        String cntr = reader.readLine();
        if(cntr.equals(Country.RUSSIA.getDisplayedName())) country = Country.RUSSIA;
        else if (cntr.equals(Country.UKRAINE.getDisplayedName())) country = Country.UKRAINE;
        else country = Country.OTHER;
    }
}
