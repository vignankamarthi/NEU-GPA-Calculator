import java.util.ArrayList;
import java.util.List;

// to represent a course with its name, grade, and credit hours
class Course {
    private String name;
    private String grade;
    private int credits;

    Course(String name, String grade, int credits) {
        this.name = name;
        this.grade = grade;
        this.credits = credits;
    }

    String getName() {
        return name;
    }

    String getGrade() {
        return grade;
    }

    int getCredits() {
        return credits;
    }
}

// to represent a list of courses as a list of Course objects
class CoursesList {
    private List<Course> courses;

    public CoursesList(List<Course> courses) {
        this.courses = courses;
    }

    // to get this CourseList's list of courses
    public List<Course> getCourses() {
        return courses;
    }
}

// to represent a GPA Calculator
public class GPACalculator {

    // Method to convert letter grades into grade point average values
    public double convertGradeToPoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A":
                return 4.0;
            case "A-":
                return 3.667;
            case "B+":
                return 3.33;
            case "B":
                return 3.0;
            case "B-":
                return 2.667;
            case "C+":
                return 2.333;
            case "C":
                return 2.0;
            case "C-":
                return 1.667;
            case "D+":
                return 1.333;
            case "D":
                return 1.0;
            case "D-":
                return 0.667;
            case "F":
                return 0.0;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    // to calculate the GPA of a CoursesList object
    public double calculateGPA(CoursesList coursesList) {
        List<Course> courses = coursesList.getCourses();

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Course course : courses) {
            double gradePoint = convertGradeToPoints(course.getGrade());
            totalPoints += gradePoint * course.getCredits();
            totalCredits += course.getCredits();
        }

        if (totalCredits == 0) {
            return 0.0;
        } else {
            return totalPoints / totalCredits;
        }
    }

    // Main method to run the GPA calculator
    public static void main(String[] args) {

        // list of current courses
        List<Course> currentCourses = new ArrayList<>();
        currentCourses.add(new Course("Fundamentals of Computer Science 1", "A-", 4));
        currentCourses.add(new Course("Lab for Fundamentals of Computer Science 1", "A-", 1));
        currentCourses.add(new Course("Discrete Math", "A", 4));
        currentCourses.add(new Course("Recitation for Discrete Math", "A", 1));
        currentCourses.add(new Course("Psychology 101", "A", 4));
        currentCourses.add(new Course("English 101", "A", 4));
        currentCourses.add(new Course("Introduction to Information Systems and Digital Technologies", "A-", 4));
        currentCourses.add(new Course("Business Statistics", "A-", 4));
        currentCourses.add(new Course("Music in Everyday Life", "A", 4));
        currentCourses.add(new Course("Financial Accounting", "A", 4));
        currentCourses.add(new Course("Fundamentals of Computer Science 2", "B", 4));
        currentCourses.add(new Course("Lab for Fundamentals of Computer Science 2", "B", 1));
        currentCourses.add(new Course("Managerial Accounting", "A", 4));
        currentCourses.add(new Course("Algorithms", "A", 4));

        // creating a CoursesList object for the initial courses
        CoursesList currentCoursesList = new CoursesList(currentCourses);

        // creating a GPACalculator object
        GPACalculator calculator = new GPACalculator();

        // calculating the GPA for the initial courses
        double gpa = calculator.calculateGPA(currentCoursesList);
        System.out.println("GPA for initial courses is: " + gpa);

        // creating a new list and add all the initial courses
        List<Course> futureCourses = new ArrayList<>(currentCourses);

        // adding additional courses to the list
        futureCourses.add(new Course("Financial Management", "A", 4));
        futureCourses.add(new Course("Foundations of Data Science", "A", 4));
        futureCourses.add(new Course("Microeconomics", "A", 4));

        // Create a CoursesList object for the potential courses
        CoursesList futureCoursesList = new CoursesList(futureCourses);

        // Calculate GPA for the potential courses
        double potentialGPA = calculator.calculateGPA(futureCoursesList);
        System.out.println("Potential GPA for future courses is: " + potentialGPA);
    }
}