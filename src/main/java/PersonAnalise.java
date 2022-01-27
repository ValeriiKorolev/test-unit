import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonAnalise {

    public PersonAnalise(){

    }

    // Количество несовершеннолетних
    public long countMinors(Collection<Person> persons) {
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних - " + count);
        return count;
    }

    // список призывников (фамилии мужчин возраста от 18 до 27 лет
    public List<String> conscript(Collection<Person> persons) {
        List<String> conscriptFamilie = (List<String>) persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        return conscriptFamilie;
    }

    // потенциально работоспособные (ж - 18-60 лет, м - 18-65 лет, высшее образование
    public List<Person> workers(Collection<Person> persons) {
        List<Person> wokers = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> (person.getAge() <= 60 && person.getSex() == Sex.WOMAN) || (person.getAge() <= 65 && person.getSex() == Sex.MAN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        return wokers;
    }

}
