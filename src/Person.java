import java.time.LocalDate;

public class Person {
    final private String firstName;
    final private String lastName;
    final private LocalDate dateOfBirth;
    final private String occupation;
    final private boolean male;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean isMale() {
        return male;
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String occupation, boolean male) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.male = male;
    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = this.dateOfBirth;
        int age = currentDate.getYear() - birthDate.getYear();
        boolean wasBirthThisYear = false;
        boolean currentMonthIsTheSameBirthMonth = currentDate.getMonthValue() == birthDate.getMonthValue();
        if(currentMonthIsTheSameBirthMonth){
            wasBirthThisYear = currentDate.getDayOfMonth() > birthDate.getDayOfMonth();
        }
        if(!currentMonthIsTheSameBirthMonth){
            wasBirthThisYear=currentDate.getMonthValue() > birthDate.getMonthValue();
        }
        if(!wasBirthThisYear){
            age-=1;
        }
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", occupation='" + occupation + '\'' +
                ", male=" + male +
                '}' + "\n";
    }
}
