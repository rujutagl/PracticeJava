import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DominoDataLabGradeSortingInterviewQns implements Comparable<DominoDataLabGradeSortingInterviewQns> {
    private String grade;

    public DominoDataLabGradeSortingInterviewQns(String grade) {
        this.grade = grade;
        if (gpa() < 0.0) throw new IllegalArgumentException("Illegal grade");
    }

    public double gpa() {
        if (grade.equals("A"))  return 4.00;
        if (grade.equals("B"))  return 3.00;
        if (grade.equals("C"))  return 2.00;
        if (grade.equals("D"))  return 1.00;
        if (grade.equals("F"))  return 0.00;
        if (grade.equals("B+")) return 3.33;
        if (grade.equals("C+")) return 2.33;
        if (grade.equals("A-")) return 3.67;
        if (grade.equals("B-")) return 2.67;
        if (grade.equals("C-")) return 1.67;
        return -1.0;
    }

    public int compareTo(DominoDataLabGradeSortingInterviewQns that) {
        return Double.compare(this.gpa(), that.gpa());
    }

    // use %-2s flag to left justify
    public String toString() {
        return String.format("%-2s %3.2f", grade, gpa());
    }


    // test client
    public static void main(String[] args) {
        DominoDataLabGradeSortingInterviewQns[] grades = new DominoDataLabGradeSortingInterviewQns[8];
        grades[0] = new DominoDataLabGradeSortingInterviewQns("B+");
        grades[1] = new DominoDataLabGradeSortingInterviewQns("A");
        grades[2] = new DominoDataLabGradeSortingInterviewQns("C+");
        grades[3] = new DominoDataLabGradeSortingInterviewQns("B-");
        grades[4] = new DominoDataLabGradeSortingInterviewQns("A-");
        grades[5] = new DominoDataLabGradeSortingInterviewQns("D");
        grades[6] = new DominoDataLabGradeSortingInterviewQns("F");
        grades[7] = new DominoDataLabGradeSortingInterviewQns("A-");


        System.out.println("Unsorted");
        for (int i = 0; i < grades.length; i++)
            System.out.println(grades[i].grade);
        System.out.println();

        System.out.println("Sorted");
        Arrays.sort(grades, Collections.reverseOrder());
        for (int i = 0; i < grades.length; i++)
            System.out.println(grades[i].grade);
    }
    /*
    System design
    App to store user photos
    PhotoManager
    Function Req:
    POST - addPhoto(userid, photoDetails)
    GET - search(criteria)
    GET - getPhotoDetails(photoId)
    Non functional re - Availability
    Latency
    Scalability
    Durable
    Traffic:
    1
    High level
    User - phone - Local App -  LB - Web server -                        DB
                                                (MetaDataService)
                          (SearchEngine)
    MetaDataService -
    SearchEngine -
    Message Queue for job is done

    Design getUUID function where scale is very imp. millions are users per second and this needs to be unique
    I answered - keep 50 bit uuid
    41 bit can be timestamp with date and milliseconds + machineID + random counter.
     */

}