import java.util.*;

public class TestStudent {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(1, "a", 10.0f);
        students[1] = new Student(2, "b", 2.0f);
        students[2] = new Student(3, "c", 8.0f);
        students[3] = new Student(4, "d", 4.0f);
        students[4] = new Student(5, "e", 7.0f);
        
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentCGPAComparator());
        System.out.println(Arrays.toString(students));

        //inline comparator
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.cgpa == o2.cgpa) return 0;
                else if(o1.cgpa > o2.cgpa) return 1;
                else return -1;
            }
        });

        System.out.println(Arrays.toString(students));

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // even shorter inline comparator
        Arrays.sort(students, (o1, o2) -> {
            return Float.compare(o1.cgpa, o2.cgpa);
        });

        System.out.println(Arrays.toString(students));


        // Arrays dont support generics
        // so we need to use Collections like List
        System.out.println("Using List");

        List<Student> studentList = Arrays.asList(students);
        // Collections.sort(studentList);
        System.out.println(studentList);

    }    
}
