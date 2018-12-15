package Person.Check;
import Person.Repository.Person;

public interface Checker {

     /**
      * @param p - person for check
      * @param value - object for check
      * @return result of check
      */
     boolean check (Person p, Object value);

}
