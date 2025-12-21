public class Main {

    public static Student getTopStudent(Student[] arr) {
        Student top = arr[0];
        for (Student s : arr) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }
        return top;
    }

    public static int countHonors(Student[] arr) {
        int count = 0;
        for (Student s : arr) {
            if (s.isHonors()) {
                count++;
            }
        }
        return count;
    }

    public static int totalCredits(Student[] arr) {
        int sum = 0;
        for (Student s : arr) {
            sum += s.getCredits();
        }
        return sum;
    }

    public static void main(String[] args) {

        Student[] students = new Student[5];

        students[0] = new Student("Alice Brown", "S001", "CS");
        students[1] = new Student("Bob Smith", "S002", "Engineering");
        students[2] = new Student("Charlie Lee", "S003", "Math");
        students[3] = new Student("Diana White", "S004", "IT");
        students[4] = new Student("Ethan Green", "S005", "Physics");

        students[0].updateGPA(3.8); students[0].addCredits(90);
        students[1].updateGPA(3.1); students[1].addCredits(70);
        students[2].updateGPA(3.9); students[2].addCredits(100);
        students[3].updateGPA(2.7); students[3].addCredits(60);
        students[4].updateGPA(3.6); students[4].addCredits(80);

        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("Top GPA Student: " + getTopStudent(students));
        System.out.println("Honors Count: " + countHonors(students));
        System.out.println("Total Credits: " + totalCredits(students));

        Course course = new Course("Java OOP", "Dr. Smith", 5);

        for (int i = 0; i < students.length; i++) {
            course.addStudent(students[i], i);
        }

        System.out.println(course);
        System.out.println("Average GPA: " + course.courseAverageGPA());
        System.out.println("Highest Credit Student: " + course.highestCreditStudent());
    }
}
