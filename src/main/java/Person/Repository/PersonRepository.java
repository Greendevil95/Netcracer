package Person.Repository;

import java.util.ArrayList;

public class PersonRepository {
    private ArrayList<Person> PersonRepository = new ArrayList<Person>();

    public PersonRepository() {
        PersonRepository.add(new Person("Petrov Dmitry", "male", 1, "2001-02-12"));
        PersonRepository.add(new Person("Sviridov Artem", "male", 2, "2003-09-11"));
        PersonRepository.add(new Person("Petrov Petr", "male", 3, "2002-02-12"));
        PersonRepository.add(new Person("Fructov Orange", "male", 4, "1976-04-25"));
        PersonRepository.add(new Person("Dimitrova Svetlana", "female", 5, "2002-11-09"));
    }

    public void setPersonInRepository(int index, String name, String gender, int id, String birthDate) {
        PersonRepository.set(index, new Person(name, gender, id, birthDate));
    }

    public void addPersonInRepository(String name, String gender, int id, String birthDate) {
        PersonRepository.add(new Person(name, gender, id, birthDate));
    }

    public void removePersonFromRepository(int index) {
        PersonRepository.remove(index);
    }

    public void showPersonRepository() {
        for (int i = 0; i < PersonRepository.size(); i++) {
            System.out.println("Person name: " + PersonRepository.get(i).getName() + "\nGender: " + PersonRepository.get(i).getGender() + "\nID: "
                    + PersonRepository.get(i).getId() + "\nAge: " + PersonRepository.get(i).getAge() + "\n");
        }
    }
}



