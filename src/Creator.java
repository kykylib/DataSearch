import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creator {

    private List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> generateListOfPeople(){
        List<String> names = List.of("Nikita","Bogdan","Nastya","Kirill","Vlad");
        List<String> lastNames = List.of("Liberman","Nazarenko","Popinako","Guerra","Samson");
        List<String> occupations = List.of("it","policeman","driver","doctor","teacher");
        Random random = new Random();

        for(int i=0;i<10;i++){
            int name = random.nextInt(0,names.size());
            int lastName = random.nextInt(0,lastNames.size());
            int occupation = random.nextInt(0,occupations.size());
            int yearOfBirth = random.nextInt(1980,2022);
            int monthOfBirth = random.nextInt(1,13);
            LocalDate birthDay = LocalDate.of(yearOfBirth,monthOfBirth,1);
            int dayOfBirth = random.nextInt(1,birthDay.lengthOfMonth());
            birthDay = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
            boolean male = random.nextBoolean();

            Person person = new Person(names.get(name),lastNames.get(lastName),birthDay,occupations.get(occupation),male);
            people.add(person);
        }
        return people;
    }
}
