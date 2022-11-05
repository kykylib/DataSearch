import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator();
        List<Person> people = creator.generateListOfPeople();
        System.out.println(people);
        PersonFilter personFilter = new PersonFilter();
        System.out.println(personFilter.filterByOccupation(people,null,null,null,null,true));
    }
}
