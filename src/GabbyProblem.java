import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by jvillegas on 3/8/17.
 */
public class GabbyProblem {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/gabbyFile1.txt"));
        ArrayList<Teacher> teachers = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        while (sc.hasNext()) {
            teachers.add(new Teacher(sc.nextInt(), sc.next(), formatter.parse(sc.next())));
        }
        sc = new Scanner(new File("src/gabbyFile2.txt"));
        ArrayList<Integer> ids = new ArrayList<>();
        while (sc.hasNextInt())
            ids.add(sc.nextInt());
        ArrayList<String> statuses = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++)
            statuses.add(sc.next());
        int temp = ids.size();
        for (int i = 0; i < temp; i++)
            teachers.add(new Teacher(ids.remove(0), statuses.remove(0), formatter.parse(sc.next())));
        Collections.sort(teachers);
        System.out.println("Gabby's rank is: " + teachers.indexOf(new Teacher(167489, null, null)));
        int i = 0;
        while (i < teachers.size())
            System.out.println((i + 1) + ". " + teachers.get(i++));
    }

    static class Teacher implements Comparable<Teacher> {
        final String PR1 = "PR1";
        final String PR2 = "PR2";
        final String PBC = "PBC";

        int id;
        Status status;
        Date dateStarted;

        Teacher(int id, String status, Date dateStarted) {
            this.id = id;
            switch ("" + status) {
                case PR1:
                    this.status = new Status(1, PR1);
                    break;
                case PR2:
                    this.status = new Status(2, PR2);
                    break;
                case PBC:
                    this.status = new Status(0, PBC);
                    break;
                default:
                    this.status = new Status(-1, "Other");
            }
            this.dateStarted = dateStarted;
        }

        @Override
        public int compareTo(Teacher o) {
            if (status.statusNum == o.status.statusNum)
                return this.dateStarted.compareTo(o.dateStarted);
            else
                return o.status.statusNum - status.statusNum;
        }

        @Override
        public boolean equals(Object obj) {
            return id == ((Teacher) obj).id;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "id=" + id +
                    ", status='" + status + '\'' +
                    ", dateStarted=" + dateStarted +
                    '}';
        }
    }

    static class Status {
        int statusNum;
        String statusString;

        Status(int num, String string) {
            statusNum = num;
            statusString = string;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "statusNum=" + statusNum +
                    ", statusString='" + statusString + '\'' +
                    '}';
        }
    }

}
