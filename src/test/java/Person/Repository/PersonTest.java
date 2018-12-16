package Person.Repository;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {


    @Test
    public void getAge() {
        String actualData = "2010-05-20";
        Person p = new Person("XXX", "XXX", 1, actualData);
        Integer expectedAge = 8;
        Integer actualAge = p.getAge();
        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void toString_test(){
        Person actualString = new Person("XXX", "XXX", 1, "2010-05-20");
        String expectedString = "id=1, name=XXX, age=8, gender=XXX ";
        Assert.assertEquals(expectedString, actualString.toString() );
    }



}