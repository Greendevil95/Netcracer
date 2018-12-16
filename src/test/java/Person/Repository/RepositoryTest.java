package Person.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepositoryTest{

    Repository rep = new Repository();

    @Before
    public void setUp() throws Exception{
        rep.addPerson(new Person("Leo", "male", 1, "2010-10-10"));
        rep.addPerson(new Person("Tom", "female", 2, "2012-10-10"));
        rep.addPerson(new Person("Don", "male", 3, "2014-10-10"));
    }

    @Test
    public void addPerson() {
        new Person("Leo", "male", 1, "2010-10-10");
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
        Person p = new Person("Tom", "female", 2, "2012-10-10");
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
    public void print() {
        String expectedString = "Leo male 8 1";
        Assert.assertEquals(expectedString, rep.print(0) );
    }

    @Test
    public void searchByName() {
        rep.searchByName("Shrek");
        String s  = "Shrek";
        Assert.assertEquals(rep.searchByName("Shrek").toString(),s );

    }


    @Test
    public void setSorter() {
    }

    @Test
    public void sort() {
    }


}