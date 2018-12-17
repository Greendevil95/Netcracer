package Person.Comparator;

import Person.Repository.Person;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class CompareByGender implements Comparator<Person> {
    /**
     * @param o1 - first object to compare
     * @param o2 - second object to compare
     * @return - result of compare
     */
    private static final Logger log = Logger.getLogger(CompareByGender.class);

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 != null && o2 != null) {
            if (log.isDebugEnabled())
                log.debug("compare Person1: " + o1.getName() + " with Person2:" + o2.getName() + " by gender");
            return o1.getGender()
                    .compareTo(o2.getGender());
        } else {
            log.fatal("Unable to compare Person with null reference for age");
            throw new NullPointerException("Unable to compare Person with null reference");
        }
    }
}

