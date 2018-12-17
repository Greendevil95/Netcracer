package Person.Sorters;

import Person.Repository.Person;
import Person.Repository.Repository;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    /**
     * @param R    - array of persons
     * @param comp - comparator's type
     */
    private static final Logger log = Logger.getLogger(BubbleSorter.class);
    @Override
    public void sort(Repository R, Comparator<Person> comp) {
        if(log.isDebugEnabled())
        log.debug("sort Repository with BubbleSorter by " + comp.toString());
        for (int i = R.length() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comp.compare(R.PersonRepository[j], R.PersonRepository[j + 1]) > 0) {
                    Person p = R.PersonRepository[j];
                    R.PersonRepository[j] = R.PersonRepository[j + 1];
                    R.PersonRepository[j + 1] = p;
                }
            }
        }
    }
}




