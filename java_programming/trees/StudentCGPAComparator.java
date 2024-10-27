import java.util.Comparator;

public class StudentCGPAComparator implements Comparator<Student> 
{
    @Override
    public int compare(Student o1, Student o2)
    {
        if(o1.cgpa == o2.cgpa) return 0;
        else if(o1.cgpa > o2.cgpa) return 1;
        else return -1;
    }    
}
