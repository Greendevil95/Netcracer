package Person.Comparator;

import Person.Repository.Person;

import java.util.Comparator;

public class CompareByID implements Comparator<Person> {
    /**
     * @param o1 - first object to compare
     * @param o2 - second object to compare
     * @return - result of compare
     */
    @Override
    public int compare(Person o1, Person o2) {
        if(o1 != null && o2 != null){
            return o1.getId()
                    .compareTo(o2.getId());
        } else throw new NullPointerException("Unable to compare Person with null reference");
    }
}
