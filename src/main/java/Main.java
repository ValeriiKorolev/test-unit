import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        PersonAnalise personAnalise = new PersonAnalise();

        // Количество несовершеннолетних
        long countM = personAnalise.countMinors(persons);
        System.out.println("Количество несовершеннолетних - " + countM);


        // список призывников (фамилии мужчин возраста от 18 до 27 лет
        List<String> conscriptFamilie = personAnalise.conscript(persons);
        System.out.println("Призывники");
        for (int i = 0; i < 10; i++) {
            System.out.println(conscriptFamilie.get(i));
        }

        // потенциально работоспособные (ж - 18-60 лет, м - 18-65 лет, высшее образование
        List<Person> wokers = personAnalise.workers(persons);
        System.out.println("Работоспособное население");
        for (int i = 0; i < 10; i++) {
            System.out.println(wokers.get(i).toString());
        }

    }


}