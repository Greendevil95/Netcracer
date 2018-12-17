package Person.Repository;

import Person.Comparator.CompareByID;
import Person.Comparator.CompareByName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepositoryTest{

    private Repository rep = new Repository();

    @Before
    public void setUp() {
        rep.addPerson(new Person("Leo", "male", 3, "2010-10-10"));
        rep.addPerson(new Person("Tom", "female", 1, "2012-10-10"));
        rep.addPerson(new Person("Don", "male", 2, "2014-10-10"));
    }

    @Test
    public void addPerson() {
        rep.addPerson(new Person("Leo", "male", 1, "2010-10-10"));
        Person expected = new Person ("Leo", "male", 1, "2010-10-10");
        Assert.assertEquals(expected.toString(),rep.PersonRepository[3].toString());
    }

    @Test
    public void removePerson_t1() {
        rep.removePerson(2);
        rep.removePerson(1);
        rep.removePerson(0);
        for(int i = 0; i <= 3; i++)
        Assert.assertNull(rep.PersonRepository[i]);
    }

    @Test
    public void removePerson_t2(){
        Person p = new Person("Tom", "female", 1, "2012-10-10");
        rep.removePerson(0);
        Assert.assertEquals(p.toString(),rep.PersonRepository[0].toString());
    }


    @Test
    public void setPerson() {
        rep.setPerson(0,new Person("A","XXX",5,"2000-02-02"));
        Person expectedPerson = new Person("A","XXX",5,"2000-02-02");
        Assert.assertEquals(expectedPerson.toString(),rep.PersonRepository[0].toString());

    }

    @Test
    public void searchByName() {
        Repository expected = new Repository();
        expected.addPerson(rep.PersonRepository[0]);
        Repository actual = rep.searchByName("Leo");
        for (int i = 0 ; i < expected.length(); i++) {
            Assert.assertEquals(expected.PersonRepository[i].toString(), actual.PersonRepository[i].toString());
        }

    }


    @Test
    public void searchByGender() {
            Repository expected = new Repository();
            expected.addPerson(rep.PersonRepository[0]);
            expected.addPerson(rep.PersonRepository[2]);
            Repository actual = rep.searchByGender("male");
            for (int i = 0 ; i < expected.length(); i++) {
                Assert.assertEquals(expected.PersonRepository[i].toString(), actual.PersonRepository[i].toString());
            }
    }

    @Test
    public void searchByID() {
            Repository expected = new Repository();
            expected.addPerson(rep.PersonRepository[0]);
            Repository actual = rep.searchByID(3);
            for (int i = 0 ; i < expected.length(); i++) {
                Assert.assertEquals(expected.PersonRepository[i].toString(), actual.PersonRepository[i].toString());
            }
        }

    @Test
    public void searchByAge() {
        Repository expected = new Repository();
        expected.addPerson(rep.PersonRepository[1]);
        Repository actual = rep.searchByAge(6);
        for (int i = 0 ; i < expected.length(); i++) {
            Assert.assertEquals(expected.PersonRepository[i].toString(), actual.PersonRepository[i].toString());
        }
    }



    @Test
    public void BubbleSorter() {
        Repository expected = new Repository();
        expected.addPerson(rep.PersonRepository[2]);
        expected.addPerson(rep.PersonRepository[0]);
        expected.addPerson(rep.PersonRepository[1]);
        rep.sort(new CompareByName());
        for (int i = 0 ; i < expected.length(); i++) {
            Assert.assertEquals(expected.PersonRepository[i].toString(), rep.PersonRepository[i].toString());
        }
    }

    @Test
    public void ShakerSorter(){
        Repository expected = new Repository();
        expected.addPerson(rep.PersonRepository[1]);
        expected.addPerson(rep.PersonRepository[2]);
        expected.addPerson(rep.PersonRepository[0]);
        rep.sort(new CompareByID());
        for (int i = 0 ; i < expected.length(); i++) {
            Assert.assertEquals(expected.PersonRepository[i].toString(), rep.PersonRepository[i].toString());
        }
    }

}