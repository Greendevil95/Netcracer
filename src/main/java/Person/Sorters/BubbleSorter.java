package Person.Sorters;

import Person.Repository.Person;
import Person.Repository.Repository;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    /**
     * @param R    - array of persons
     * @param comp - comparator's type
     */
    @Override
    public void sort(Repository R, Comparator<Person> comp) {
        for (int i = R.length() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comp.compare(R.PersonRepository[i], R.PersonRepository[i + 1]) > 0) {
                    Person p = R.PersonRepository[i];
                    R.PersonRepository[i] = R.PersonRepository[j];
                    R.PersonRepository[j] = p;
                }
            }
        }
    }
}




