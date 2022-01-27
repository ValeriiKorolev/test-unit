import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class PersonAnaliseTest {

    PersonAnalise sut = new PersonAnalise();
    private Collection<Person> persons = new ArrayList<>();

    @BeforeEach
    public void initData() {
        //Collection<Person> persons = new ArrayList<>();
        persons.add(new Person("Harry", "Adamson", 15, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Samuel", "Evans", 62, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("George", "Young", 17, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Samuel", "Harris", 26, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Harry", "Wilson", 39, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Samuel", "Davies", 42, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Connor", "Adamson", 23, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Samuel", "Brown", 16, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("George", "Brown", 68, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Samuel", "Adamson", 29, Sex.WOMAN, Education.HIGHER));
    }

    @Test
    void countMinorsTest() {

        long result = sut.countMinors(persons);
        long expected = 3;
        Assertions.assertEquals(result, expected);
    }

    @Test
    void conscriptTest() {

        List<String> result = sut.conscript(persons);
        List<String> expected = new ArrayList<>();
        expected.add("Harris");
        expected.add("Adamson");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void workerTest() {

        List<Person> result = sut.workers(persons);

        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Samuel", "Harris", 26, Sex.MAN, Education.HIGHER));
        expected.add(new Person("Harry", "Wilson", 39, Sex.WOMAN, Education.HIGHER));
        expected.add(new Person("Samuel", "Davies", 42, Sex.MAN, Education.HIGHER));
        expected.add(new Person("Connor", "Adamson", 23, Sex.MAN, Education.HIGHER));
        expected.add(new Person("Samuel", "Adamson", 29, Sex.WOMAN, Education.HIGHER));
        expected.sort(Comparator.comparing(Person::getFamily));

        Assertions.assertEquals(expected, result);

    }


}