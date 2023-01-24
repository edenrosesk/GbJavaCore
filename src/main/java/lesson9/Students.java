package lesson9;
import java.util.List;

public class Students {

    private String name;

    List<Courses> coursesList;

    public Students(String name, List<Courses> coursesList) {
        this.name = name;
        this.coursesList = coursesList;
    }

    public String getName() {
        return name;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }
}