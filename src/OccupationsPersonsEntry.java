import java.util.ArrayList;
import java.util.List;

public class OccupationsPersonsEntry {
    private String occupation;
    private List<Person> group = new ArrayList<>();

    public OccupationsPersonsEntry(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public List<Person> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "OccupationsPersonsEntry{" +
                "\n, group=" + group +
                '}' + "\n";
    }
}
