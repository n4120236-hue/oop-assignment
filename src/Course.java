public class Course {

    private String courseName;
    private String instructor;
    private Student[] students;

    public Course(String courseName, String instructor, int size) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new Student[size];
    }

    public void addStudent(Student s, int index) {
        if (index >= 0 && index < students.length) {
            students[index] = s;
        }
    }

    public double courseAverageGPA() {
        double sum = 0;
        int count = 0;

        for (Student s : students) {
            if (s != null) {
                sum += s.getGpa();
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    public Student highestCreditStudent() {
        Student max = null;

        for (Student s : students) {
            if (s != null) {
                if (max == null || s.getCredits() > max.getCredits()) {
                    max = s;
                }
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Course{name='" + courseName +
                "', instructor='" + instructor + "'}";
    }
}
