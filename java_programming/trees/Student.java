// every object in java is a child of Object class (by default)
public class Student
{
    // old class -> public class Student implements Comparable<Student>
    public int id;
    public String name;
    public float cgpa;

    public Student(int id, String name, float cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name + " " + this.cgpa;
    }

    // @Override
    // public int compareTo(Student s)
    // {
    //     if(this.cgpa == s.cgpa) return 0;
    //     else if(this.cgpa > s.cgpa) return 1;
    //     else return -1;
    // }

    public static void main(String[] args) {
        Student s = new Student(393, "Harsh", 9.93f);
        System.out.println(s);
    }
}