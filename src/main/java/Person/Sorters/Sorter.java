package Person.Sorters;

import Person.Repository.Person;
import Person.Repository.Repository;

import java.util.Comparator;

public interface Sorter {

    /**
     * @param R - array of persons
     * @param comp - comparator's type
     */
    void sort (Repository R, Comparator<Person> comp);
}
