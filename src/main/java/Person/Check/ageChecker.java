package Person.Check;

import Person.Repository.Person;

public class ageChecker implements Checker {
    /**
     * @param p     - person for check
     * @param value - object for check
     * @return result of check
     */
    @Override
    public boolean check(Person p, Object value) {
        return value.equals(p.getAge());
    }
}
