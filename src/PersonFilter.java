import java.time.LocalDate;
import java.util.*;

public class PersonFilter {

    public List<Person> filter(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation,boolean male){
        List<Person> filteredGroup = new ArrayList<>();
        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
                boolean notMatch = !(stringFilter(person.getFirstName(), firstName));
                if(notMatch){
                    continue;
                }
                notMatch = !(stringFilter(person.getLastName(),lastName));
                if(notMatch){
                    continue;
                }
               notMatch = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
               if(notMatch){
                   continue;
               }
               notMatch = !(stringFilter(person.getOccupation(),occupation));
               if(notMatch){
                   continue;
               }
           notMatch = !(booleanFilter(person.isMale(),male));
           if(notMatch){
               continue;
           }
           filteredGroup.add(person);
        }
        return filteredGroup;
    }

    private boolean stringFilter(String currentComparable,String filterOfString){
        if(filterOfString==null || filterOfString.isEmpty()){
            return true;
        }
        boolean contains = currentComparable.toLowerCase(Locale.ROOT).contains(filterOfString.toLowerCase(Locale.ROOT));
        return contains;
    }

    private boolean dateFilter(LocalDate currentComparable, LocalDate filterOfDate){
        if(filterOfDate==null){
            return true;
        }
        boolean isSame = currentComparable.equals(filterOfDate);
        return isSame;
    }

    private boolean booleanFilter(boolean currentComparable, boolean filterOfBoolean){
        boolean isSame = currentComparable == filterOfBoolean;
        return isSame;
    }

    public Map<String,List> filterByOccupation(List<Person> group, String firstName, String lastName, LocalDate dateOfBirth, String occupation, boolean male){
        Map<String,List> filteredGroupByOccupation = new HashMap<>();
        List<Person> filteredGroup = filter(group, firstName, lastName, dateOfBirth, occupation, male);
        for(Person person:filteredGroup){
            String currentOccupation = person.getOccupation();
            List listByOccupation = filteredGroupByOccupation.get(currentOccupation);
            if(listByOccupation == null){
                filteredGroupByOccupation.put(currentOccupation,new ArrayList<>());
                continue;
            }
            filteredGroupByOccupation.get(currentOccupation).add(person);
        }
        return filteredGroupByOccupation;
    }
}
