package Person.Repository;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person {
    private String name;
    private String gender;
    private Integer id;
    private Integer age;


    public Person(String name, String gender, Integer id, String birthDate) {
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

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }


}

