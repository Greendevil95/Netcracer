package Person.Comparator;

import Person.Repository.Person;
import java.util.Comparator;

public class CompareByName implements Comparator<Person> {

    /**
     * @param o1 - first object to compare
     * @param o2 - second object to compare
     * @return - result of compare
     */
    @Override
    public int compare(Person o1, Person o2) {
        if(o1 != null && o2 != null){
            return o1.getName()
                    .compareTo(o2.getName());
        } else throw new NullPointerException("Unable to compare Person with null reference");
    }
}
