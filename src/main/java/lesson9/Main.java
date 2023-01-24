package lesson9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Students> result = getListOfStudents(3,3);
        //1 задание
        result.stream().flatMap(student -> student.getCoursesList().stream()).distinct().collect(Collectors.toList());
        result.stream().flatMap(student -> student.getCoursesList().stream()).collect(Collectors.toSet());

        //2 задание
        result.stream().sorted(Comparator.comparingInt(student -> student.getCoursesList().size())).limit(3).collect(Collectors.toList());

        //3 задание
        Courses paramCourse = new Courses("cours1");
        result.stream().filter(students -> students.getCoursesList().contains(paramCourse)).collect(Collectors.toList());

        System.out.println();

    }

    private static List<Students> getListOfStudents(int j, int m){
        ArrayList<Students> result = new ArrayList<>();
        for (int i=0; i<j ;i++){
            ArrayList<Courses> courses = new ArrayList<>();
            for (int h=0; h<m ;h++){
                courses.add(new Courses("course"+h));
            }
            result.add(new Students("student"+i, courses));
        }
        return result;
    }
}
