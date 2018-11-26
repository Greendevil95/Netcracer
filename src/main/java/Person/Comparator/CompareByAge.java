package Person.Comparator;

import Person.Repository.Person;
import java.util.Comparator;

public class CompareByAge implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
        if(o1 != null && o2 != null){
            return o1.getAge()
                    .compareTo(o2.getAge());
        } else throw new NullPointerException("Unable to compare Person with null reference");
    }


}

