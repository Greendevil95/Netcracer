package Person.Repository;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * @author Bondarev Denis
 */
public class Person {
    /** person's name*/
    private String name;
    /** person's gender*/
    private String gender;
    /** person's id*/
    private Integer id;
    /** person's age*/
    private Integer age;

    /** person's date of birth*/
    private String birthDate;


    /**
     * @param name - person's name
     * @param gender - person's gender
     * @param id - person's id
     * @param birthDate - person's date of birth, which is used to calculate age
     */
    public Person(String name, String gender, Integer id, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.birthDate = birthDate;
        age = getAge();
    }

    /**
     * @return person name
     */
    public String getName() {
        return name;
    }

    /**
     * @return person gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return person id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return person age
     */
    public Integer getAge() {
        LocalDate now = new LocalDate();
        LocalDate birthDates = new LocalDate(birthDate);
        age = Years.yearsBetween(birthDates, now).getValue(0);
        return age;
    }

    /**
     * @return String with person characteristics
     */
    @Override
    // переопределим метод toString() для печати
    // информации об объекте Employee в читабельном виде
    public String toString() {
        return "id=" + this.id + ", name=" + this.name +
                ", age=" + this.age + ", gender=" + this.gender + " ";
    }
}

