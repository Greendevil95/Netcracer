package Person;

import org.joda.time.LocalDate;
import org.joda.time.Years;

class Person {
    private String name;
    private String gender;
    private int id;
    private int age;


    public Person(String name, String gender, int id, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        LocalDate now = new LocalDate();
        LocalDate birthDates = new LocalDate(birthDate);
        age = Years.yearsBetween(birthDates, now).getValue(0);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }


}

