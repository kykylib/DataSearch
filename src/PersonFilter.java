import java.time.LocalDate;
import java.util.*;

public class PersonFilter {

    public List<Person> filter(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation,boolean male){
        List<Person> filteredGroup = new ArrayList<>();
        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
                boolean isMatch = !(stringFilter(person.getFirstName(), firstName));
                if(isMatch){
                    continue;
                }
                isMatch = !(stringFilter(person.getLastName(),lastName));
                if(isMatch){
                    continue;
                }
               isMatch = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
               if(isMatch){
                   continue;
               }
               isMatch = !(stringFilter(person.getOccupation(),occupation));
               if(isMatch){
                   continue;
               }
           isMatch = !(booleanFilter(person.isMale(),male));
           if(isMatch){
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
        HashMap<String,List> filteredGroupByOccupation = new HashMap<>();
        List<Person> filteredGroup = filter(group, firstName, lastName, dateOfBirth, occupation, male);
        for(int i=0;i<filteredGroup.size();i++){
            Person person = filteredGroup.get(i);
            String currentOccupation = person.getOccupation();
            boolean hasKey = filteredGroupByOccupation.containsKey(currentOccupation);
            if(hasKey){
                filteredGroupByOccupation.get(currentOccupation).add(person);
                continue;
            }
            List<Person> listOfPeople = new ArrayList<>();
            filteredGroupByOccupation.put(currentOccupation,listOfPeople);
            filteredGroupByOccupation.get(currentOccupation).add(person);
        }
        return filteredGroupByOccupation;
    }
}
