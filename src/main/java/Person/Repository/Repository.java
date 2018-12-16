package Person.Repository;

import Person.Check.*;
import Person.Injector.Inject;
import Person.Injector.Injector;
import Person.Sorters.BubbleSorter;
import Person.Sorters.Sorter;

import java.util.Comparator;

/**
 * @author Bondarev Denis
 */
public class Repository {


    /** Initial size of array*/
    private int initialSize = 10;

    /** The number of elements in the array*/
    private int pointer = 0;

    /** Array of Persons */
    public Person[] PersonRepository = new Person[initialSize];

    public Repository() {
        new Injector().inject(this);
    }

    /** default sort type*/
    @Inject private Sorter sorter = new BubbleSorter();

    /**
     * @return the number of elements in the array
     */
    public int length() {
        return pointer;
    }

    /**
     * @param item - element added to the array
     */
    public void addPerson(Person item) {
        if(pointer == PersonRepository.length-1)
            resize(PersonRepository.length*2);
        PersonRepository[pointer++] = item  ;
    }

    /**
     * @param newLength - new array length
     */
    private void resize(int newLength) {
        Person[] newPersonRepository = new Person[newLength];
        System.arraycopy(PersonRepository, 0, newPersonRepository, 0, pointer);
        PersonRepository = newPersonRepository;
    }

    /**
     * @param index - deleted item index
     */
    public void removePerson(int index){
        if(index >= 0 && index < pointer) {
            for (int i = index; i < pointer; i++)
                PersonRepository[i] = PersonRepository[i + 1];
            PersonRepository[pointer] = null;
            pointer--;
            if (PersonRepository.length > initialSize && pointer < PersonRepository.length / 2)
                resize(PersonRepository.length/2);
        }
    }

    /**
     * @param index - index of the element to be replaced
     * @param item - item to replace
     */
    public void setPerson(int index, Person item){
        if (index < pointer)
            PersonRepository[index] = item;
        else throw new NullPointerException("No item with the specified index was found");
    }

    /**
     * @param checker - checker's type
     * @param value - value to search
     * @return search results
     */
    private Repository search(Checker checker, Object value){
        Repository searchRepository = new Repository();
        for (int i = 0; i < pointer;i++) {
            if (checker.check(PersonRepository[i], value)) {
                searchRepository.addPerson(PersonRepository[i]);
            }
        }

        return searchRepository;
}

    /**
     * @param index - person's index
     * @return person like a string
     */
    public String print(int index) {
        Person searchRepository = PersonRepository[index];
        return searchRepository.getName() + " "
                + searchRepository.getGender() + " " + searchRepository.getAge() + " " + searchRepository.getId();
    }

    /**
     * @param age - person's age
     * @return search results by age
     */
    public Repository searchByAge(int age) {
        return search(new ageChecker(), age);
    }

    /**
     * @param name - person's name
     * @return search results by name
     */
    public Repository searchByName(String name){
        return search(new nameChecker(), name);
    }

    /**
     * @param id -  person's id
     * @return search results by id
     */
    public Repository searchByID(int id) {
        return search(new idChecker(), id);
    }

    /**
     * @param gender - person's gender
     * @return search results by gender
     */
    public Repository searchByGender(String gender) {return search(new genderChecker(), gender);}

    /**
     * @param sorter - type of array sorting
     */
    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    /**
     * @param comp - comparator's type
     */
    public void sort(Comparator<Person> comp){
        sorter.sort(this,comp);
    }



    }





