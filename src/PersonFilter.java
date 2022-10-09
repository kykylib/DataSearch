import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonFilter {

    public List<Person> MultiFilter(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation){
        List<Person> filteredGroup = new ArrayList<>();
        final boolean isEmptyOrNullFirstName = firstName==null || firstName.isEmpty();
        final boolean isEmptyOrNullLastName = lastName==null || lastName.isEmpty();
        final boolean isNullDateOfBirth = dateOfBirth==null;
        final boolean isEmptyOrNullOccupation = occupation==null || occupation.isEmpty();

        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
            if(!isEmptyOrNullFirstName){
                boolean isNotMatchOfFirstName = !(stringFilter(person.getFirstName(), firstName));
                if(isNotMatchOfFirstName){
                    continue;
                }
            }
            if(!isEmptyOrNullLastName){
                boolean isNotMatchOfLastName = !(stringFilter(person.getLastName(),lastName));
                if(isNotMatchOfLastName){
                    continue;
                }
            }
           if(!isNullDateOfBirth){
               boolean isNotMatchOfDateOfBirth = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
               if(isNotMatchOfDateOfBirth){
                   continue;
               }
           }
           if(!isEmptyOrNullOccupation){
               boolean isNotMatchOfOccupation = !(stringFilter(person.getOccupation(),occupation));
               if(isNotMatchOfOccupation){
                   continue;
               }
           }
           filteredGroup.add(person);
        }
        return filteredGroup;
    }

    public List<Person> MultiFilterWithMale(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation,boolean male){
        List<Person> filteredGroup = new ArrayList<>();
        final boolean isEmptyOrNullFirstName = firstName==null || firstName.isEmpty();
        final boolean isEmptyOrNullLastName = lastName==null || lastName.isEmpty();
        final boolean isNullDateOfBirth = dateOfBirth==null;
        final boolean isEmptyOrNullOccupation = occupation==null || occupation.isEmpty();

        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
            if(!isEmptyOrNullFirstName){
                boolean isNotMatchOfFirstName = !(stringFilter(person.getFirstName(), firstName));
                if(isNotMatchOfFirstName){
                    continue;
                }
            }
            if(!isEmptyOrNullLastName){
                boolean isNotMatchOfLastName = !(stringFilter(person.getLastName(),lastName));
                if(isNotMatchOfLastName){
                    continue;
                }
            }
           if(!isNullDateOfBirth){
               boolean isNotMatchOfDateOfBirth = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
               if(isNotMatchOfDateOfBirth){
                   continue;
               }
           }
           if(!isEmptyOrNullOccupation){
               boolean isNotMatchOfOccupation = !(stringFilter(person.getOccupation(),occupation));
               if(isNotMatchOfOccupation){
                   continue;
               }
           }
           boolean isNotMatchOfOccupation = !(booleanFilter(person.isMale(),male));
           if(isNotMatchOfOccupation){
               continue;
           }
           filteredGroup.add(person);
        }
        return filteredGroup;
    }

    private boolean stringFilter(String currentComparable,String filterOfString){
        int entryIndex = currentComparable.toLowerCase(Locale.ROOT).indexOf(filterOfString.toLowerCase(Locale.ROOT));
        boolean isEmpty = filterOfString.isEmpty();
        boolean isStartOfWord = entryIndex == 0;
        return !isEmpty && isStartOfWord;
    }

    private boolean dateFilter(LocalDate currentComparable, LocalDate filterOfDate){
        boolean isSame = currentComparable.equals(filterOfDate);
        return isSame;
    }

    private boolean booleanFilter(boolean currentComparable, boolean filterOfBoolean){
        boolean isSame = currentComparable == filterOfBoolean;
        return isSame;
    }

    public List<OccupationsPersonsEntry> filterAndGroupByOccupation(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation){
        List<Person> filteredGroup = new ArrayList<>();
        final boolean isEmptyOrNullFirstName = firstName==null || firstName.isEmpty();
        final boolean isEmptyOrNullLastName = lastName==null || lastName.isEmpty();
        final boolean isNullDateOfBirth = dateOfBirth==null;
        final boolean isEmptyOrNullOccupation = occupation==null || occupation.isEmpty();

        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
            if(!isEmptyOrNullFirstName){
                boolean isNotMatchOfFirstName = !(stringFilter(person.getFirstName(), firstName));
                if(isNotMatchOfFirstName){
                    continue;
                }
            }
            if(!isEmptyOrNullLastName){
                boolean isNotMatchOfLastName = !(stringFilter(person.getLastName(),lastName));
                if(isNotMatchOfLastName){
                    continue;
                }
            }
            if(!isNullDateOfBirth){
                boolean isNotMatchOfDateOfBirth = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
                if(isNotMatchOfDateOfBirth){
                    continue;
                }
            }
            if(!isEmptyOrNullOccupation){
                boolean isNotMatchOfOccupation = !(stringFilter(person.getOccupation(),occupation));
                if(isNotMatchOfOccupation){
                    continue;
                }
            }
            filteredGroup.add(person);
        }

        List<OccupationsPersonsEntry> filteredGroupByOccupation = new ArrayList<>();
        for(int j = 0;j<filteredGroup.size();j++){
            Person person = filteredGroup.get(j);
            if(filteredGroupByOccupation.isEmpty()){
                filteredGroupByOccupation.add(new OccupationsPersonsEntry(person.getOccupation()));
                List<Person> personList = filteredGroupByOccupation.get(j).getGroup();
                personList.add(person);
                continue;
            }
            boolean isAdded = false;
            for(int index = 0;index<filteredGroupByOccupation.size();index++){
                OccupationsPersonsEntry occupationsPersonEntry = filteredGroupByOccupation.get(index);
                String personEntryOccupation = occupationsPersonEntry.getOccupation();
                if(personEntryOccupation.equals(person.getOccupation())){
                    occupationsPersonEntry.getGroup().add(person);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                filteredGroupByOccupation.add(new OccupationsPersonsEntry(person.getOccupation()));
                List<Person> personList = filteredGroupByOccupation.get(filteredGroupByOccupation.size()-1).getGroup();
                personList.add(person);
            }
        }
        return filteredGroupByOccupation;
    }
    public List<OccupationsPersonsEntry> filterWithMaleAndGroupByOccupation(List<Person> group, String firstName,String lastName,LocalDate dateOfBirth,String occupation,boolean male){
        List<Person> filteredGroup = new ArrayList<>();
        final boolean isEmptyOrNullFirstName = firstName==null || firstName.isEmpty();
        final boolean isEmptyOrNullLastName = lastName==null || lastName.isEmpty();
        final boolean isNullDateOfBirth = dateOfBirth==null;
        final boolean isEmptyOrNullOccupation = occupation==null || occupation.isEmpty();

        for(int i=0;i<group.size();i++){
            Person person = group.get(i);
            if(!isEmptyOrNullFirstName){
                boolean isNotMatchOfFirstName = !(stringFilter(person.getFirstName(), firstName));
                if(isNotMatchOfFirstName){
                    continue;
                }
            }
            if(!isEmptyOrNullLastName){
                boolean isNotMatchOfLastName = !(stringFilter(person.getLastName(),lastName));
                if(isNotMatchOfLastName){
                    continue;
                }
            }
            if(!isNullDateOfBirth){
                boolean isNotMatchOfDateOfBirth = !(dateFilter(person.getDateOfBirth(),dateOfBirth));
                if(isNotMatchOfDateOfBirth){
                    continue;
                }
            }
            if(!isEmptyOrNullOccupation){
                boolean isNotMatchOfOccupation = !(stringFilter(person.getOccupation(),occupation));
                if(isNotMatchOfOccupation){
                    continue;
                }
            }
            boolean isNotMatchOfOccupation = !(booleanFilter(person.isMale(),male));
            if(isNotMatchOfOccupation){
                continue;
            }
            filteredGroup.add(person);
        }

        List<OccupationsPersonsEntry> filteredGroupByOccupation = new ArrayList<>();
        for(int j = 0;j<filteredGroup.size();j++){
            Person person = filteredGroup.get(j);
            if(filteredGroupByOccupation.isEmpty()){
                filteredGroupByOccupation.add(new OccupationsPersonsEntry(person.getOccupation()));
                List<Person> personList = filteredGroupByOccupation.get(j).getGroup();
                personList.add(person);
                continue;
            }
            boolean isAdded = false;
            for(int index = 0;index<filteredGroupByOccupation.size();index++){
                OccupationsPersonsEntry occupationsPersonEntry = filteredGroupByOccupation.get(index);
                String personEntryOccupation = occupationsPersonEntry.getOccupation();
                if(personEntryOccupation.equals(person.getOccupation())){
                    occupationsPersonEntry.getGroup().add(person);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                filteredGroupByOccupation.add(new OccupationsPersonsEntry(person.getOccupation()));
                List<Person> personList = filteredGroupByOccupation.get(filteredGroupByOccupation.size()-1).getGroup();
                personList.add(person);
            }
        }
        return filteredGroupByOccupation;
    }
}
