package Person.Repository;

import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(Person.class);


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
        log.info("get Person's name");
        return name;
    }

    /**
     * @return person gender
     */
    public String getGender() {
        log.info("get Person's gender");
        return gender;
    }

    /**
     * @return person id
     */
    public Integer getId() {
        log.info("get Person's id");
        return id;
    }

    /**
     * @return person age
     */
    public Integer getAge() {
        log.info("get Person's age");
        LocalDate now = new LocalDate();
        LocalDate birthDates = new LocalDate(birthDate);
        age = Years.yearsBetween(birthDates, now).getValue(0);
        return age;
    }

    /**
     * @return String with person characteristics
     */
    @Override
    public String toString() {
        log.info("convert Person to string");
        return "id=" + this.id + ", name=" + this.name +
                ", age=" + this.age + ", gender=" + this.gender + " ";
    }
}

