
package Person.Sorters;

import Person.Repository.Person;
import Person.Repository.Repository;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ShakerSorter implements Sorter {
    /**
     * @param R    - array of persons
     * @param comp - comparator's type
     */

    private static final Logger log = Logger.getLogger(ShakerSorter.class);

    @Override
    public void sort(Repository R, Comparator<Person> comp) {

        if (log.isDebugEnabled())
            log.debug("sort Repository with BubbleSorter by " + comp.toString());

        int left = 0;
        int right = R.length() - 1;

        do {
            for (int i = left; i < right; i++) {
                if (comp.compare(R.PersonRepository[i], R.PersonRepository[i + 1]) > 0) {
                    Person p = R.PersonRepository[i];
                    R.PersonRepository[i] = R.PersonRepository[i + 1];
                    R.PersonRepository[i + 1] = p;

                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (comp.compare(R.PersonRepository[i], R.PersonRepository[i - 1]) < 0) {
                    Person p = R.PersonRepository[i];
                    R.PersonRepository[i] = R.PersonRepository[i - 1];
                    R.PersonRepository[i - 1] = p;
                }
            }
            left++; //
        } while (left < right);

    }
}




