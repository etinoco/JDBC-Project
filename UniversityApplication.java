import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;


class GenericLinkedList <T extends Comparable<T> >
{
	private  class Node<T>
	 {
	 	T value;
	 	Node<T>  next;
	 	Node<T>  prev;
	 }	 
	
     private Node<T> first = null;
     int count=0;
     
    public void  add(T element)
     {
      	 Node<T> newnode = new Node<T>();
      	 newnode.value = element;
      	 newnode.next = null;

    	if (first== null)
    	{
    		first = newnode;
    		first.prev = null;
    	}
    	else
    	{
    		Node<T> lastnode = first;
    		for(int i = 1; i < count; i++)
    			lastnode = lastnode.next;
    		lastnode.next = newnode;
    		newnode.prev = lastnode;
    	}
     	 count++;
     }
    
    public T get(int pos)
    {
    	 Node<T> Nodeptr = first;
    	 int hopcount=0;
    	 while (hopcount < count && hopcount<pos)
    	 {   if(Nodeptr!=null)
    	 	 {
    		    Nodeptr = Nodeptr.next;
    	 	 }
    		 hopcount++;
    	 }
    	 if(Nodeptr == null)
    		 return null;
    	return  Nodeptr.value;
    }
    
    public void sort()
    {
    	for(int i = 0; i < count; i++)
    	{
    		for(int j = i + 1; j < count; j++)
    		{
    			if(get(i).compareTo(get(i)) == 1)
    			{
    				Node<T> firstNode = first , secNode = first;
    				int hopcount=0;
    		    	while (hopcount < count && hopcount < i)
    		    	{   
    		    		if(firstNode != null)
    		    	 	{
    		    			firstNode = firstNode.next;
    		    	 	}
    		    		hopcount++;
    		    	}
    		    	hopcount=0;
    		    	while (hopcount < count && hopcount < j)
    		    	{   
    		    		if(secNode != null)
    		    	 	{
    		    			secNode = secNode.next;
    		    	 	}
    		    		hopcount++;
    		    	}
    		    	T temp = firstNode.value;
    		    	firstNode.value = secNode.value;
    		    	secNode.value = temp;
    			}
    		}
    	}
    }
    
    public void delete(int pos)
    {
    	Node<T> Nodeptr = first;
   	 	int hopcount=0;
   	 	while (hopcount < count && hopcount<pos)
   	 	{   
   	 		if(Nodeptr!=null)
   	 		{
   	 			Nodeptr = Nodeptr.next;
   	 		}
   	 		hopcount++;
   	 	}
   	 	Nodeptr.prev = Nodeptr.next;
    }
    
    public void delete(T item)
    {
    	Node<T> Nodeptr = first;
   	 	while(Nodeptr != null && Nodeptr.value != item)
   	 	{   
   	 		if(Nodeptr!=null)
   	 		{
   	 			Nodeptr = Nodeptr.next;
   	 		}
   	 	}
   	 	Nodeptr.prev = Nodeptr.next;
    }
}

// Student, Instructor, Course, School
class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private String birthday;
    private String address;
    private int studentID;
    private ArrayList<Enrollment> enrollments;

    public Student(String fn, String ln, String bd, String a) {
        firstName = fn;
        lastName = ln;
        birthday = bd;
        address = a;

        University.studentCounter++;
        studentID = University.studentCounter;

        enrollments = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void setName(String name) {
        String[] names = name.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    @Override
	public int compareTo(Student s) {
    	if(this.studentID == s.studentID)  
    	   return 0;  
    	else if( this.studentID > s.studentID)  
    	   return 1;  
    	else  
    	   return -1;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", address="
				+ address + ", studentID=" + studentID + ", enrollments=" + enrollments + "]";
	}
    
    
}

class Department{
	private String departmentName;
	private int departmentID;
	
	public Department(String name , int id)
	{
		departmentName = name;
		departmentID = id;
	}
	
	public String getName() {
        return departmentName;
    }
	
	public int getID()
	{
		return departmentID;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
}

class Instructor{

    private String name;
    
    private int ID;
    
    private int did;

    public Instructor(String n , int id , int d) {
        name = n;
        ID = id;
        did = d;
    }

    public String getName() {
        return name;
    }
    
    public int getID() {
        return ID;
    }
    
    public int getDepartment() {
        return did;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setDepartment(int did) {
		this.did = did;
	}
    
}

class Classroom {

    private String locationName;

    public Classroom(String loc) {
        locationName = loc;
    }

    public String getLocationName() {
        return locationName;
    }
}

class Course implements Comparable<Course>{

    private String number;
    private String name;
    private Instructor Instructor;
    private Department department;
    private Classroom classroom;
    private int courseID;
    private int year;
    private String semester;
    private ArrayList<Enrollment> enrollments;

    public Course(String number, String name, Instructor Instructor, Department department, Classroom classroom, int year, String semester) {
    	this.number = number;
        this.name = name;
        this.Instructor = Instructor;
        this.department = department;
        this.classroom = classroom;
        this.year = year;
        this.semester = semester;
        this.enrollments = new ArrayList<Enrollment>();

        University.courseCounter++;
        courseID = University.courseCounter;
    }

    public Course(String number, String name, Instructor Instructor, Department department, Classroom classroom) {
        this.number = number;
        this.name = name;
        this.Instructor = Instructor;
        this.department = department;
        this.classroom = classroom;
        this.year = University.currentYear;
        this.semester = University.currentSemester;
        this.enrollments = new ArrayList<Enrollment>();

        University.courseCounter++;
        courseID = University.courseCounter;
    }

    public String getName() {
        return name;
    }

    public Instructor getInstructor() {
        return Instructor;
    }
    
    public Department getDepartment() {
        return department;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public int getCourseID() { return courseID; }

    public String getNumber() { return number; }

    public int getYear() { return year; }

    public String getSemester() { return semester; }

    public ArrayList<Enrollment> getEnrollments() { return enrollments; }

    public void addEnrollment(Enrollment enrollment) {
    	if(enrollment != null)
    		enrollments.add(enrollment);
    }

    public void saveCourseData(String number, String name, Instructor Instructor, Department department, Classroom classroom) {
        this.number = number;
        this.name = name;
        this.Instructor = Instructor;
        this.department = department;
        this.classroom = classroom;
    }
    
    @Override
	public int compareTo(Course c) {
    	if(this.courseID == c.courseID)  
    	   return 0;  
    	else if( this.courseID > c.courseID)  
    	   return 1;  
    	else  
    	   return -1;
	}

	@Override
	public String toString() {
		return "Course [number=" + number + ", name=" + name + ", Instructor=" + Instructor + ", department="
				+ department + ", classroom=" + classroom + ", courseID=" + courseID + ", year=" + year + ", semester="
				+ semester + ", enrollments=" + enrollments + "]";
	}
}

class Enrollment {

    private int enrollmentID;
    private Course course;
    private int year;
    private String semester;
    private String grade;
    private Student student;

    public Enrollment(Course course, int year, String semester, String grade, Student student) {
        this.course = course;
        this.year = year;
        this.semester = semester;
        this.grade = grade;
        this.student = student;

        University.enrollmentCounter++;
        this.enrollmentID = University.enrollmentCounter;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public Course getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public String getGrade() {
        return grade;
    }

    public String getSemester() {
        return semester;
    }

    public Student getStudent() {
        return student;
    }
    
    public void setGrade(String grade)
    {
    	this.grade = grade;
    }
}

class University {

	GenericLinkedList<Student> students;
	ArrayList<Department> Departments;
	ArrayList<Instructor> Instructors;
	ArrayList<Classroom> classrooms;
	GenericLinkedList<Course> Courses;

    static public int studentCounter = 0;
    static public int courseCounter = 0;
    static public int enrollmentCounter = 0;
    static public int currentYear = 2019;
    static public String currentSemester = "Fall";

    public University() {
    	
    	students = new GenericLinkedList<>();
    	File f = new File("student.dat");
    	if(f.exists() && !f.isDirectory()) {
    		try (BufferedReader br = new BufferedReader(new FileReader("student.dat"))) {
    	    	String line;
    	    	br.readLine(); br.readLine();
    	    	while ((line = br.readLine()) != null) {
    	    		String tokens [] = line.split("\t");
    	    		Student student = new Student(tokens[1].split(" ")[0], tokens[1].split(" ")[1], tokens[3], tokens[2]);
    	    		student.setStudentID(Integer.parseInt(tokens[0]));
    	    		students.add(student);
    	    	}
    		}catch(IOException e){}
    	}
        
        Departments = new ArrayList<>();
        f = new File("department.dat");
    	if(f.exists() && !f.isDirectory()) {
    		try (BufferedReader br = new BufferedReader(new FileReader("department.dat"))) {
    	    	String line;
    	    	br.readLine(); br.readLine();
    	    	while ((line = br.readLine()) != null) {
    	    		String tokens [] = line.split("\t");
    	    		Departments.add(new Department(tokens[1], Integer.parseInt(tokens[0])));
    	    	}
    		}catch(IOException e){}
    	}
    	else
    	{
    		Departments.add(new Department("CS" , 1));
    		Departments.add(new Department("SW" , 2));
    		Departments.add(new Department("IT" , 3));
    		Departments.add(new Department("IS" , 4));
    	}
        
        Instructors = new ArrayList<>();
        
        f = new File("instructor.dat");
    	if(f.exists() && !f.isDirectory()) {
    		try (BufferedReader br = new BufferedReader(new FileReader("instructor.dat"))) {
    	    	String line;
    	    	br.readLine(); br.readLine();
    	    	while ((line = br.readLine()) != null) {
    	    		String tokens [] = line.split("\t");
    	    		Instructors.add(new Instructor(tokens[1], Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2])));
    	    	}
    		}catch(Exception e){}
    	}
    	else
    	{
    		Instructors.add(new Instructor("RAGHAVACHARY, S." , 1 , 1));
    		Instructors.add(new Instructor("RYUTOV, T." , 2 , 2));
    		Instructors.add(new Instructor("PEROOMIAN, V." , 3 , 3));
    		Instructors.add(new Instructor("COTE, A." , 4 , 4));
    		Instructors.add(new Instructor("SCHINDLER, M." , 5 , 1));
    		Instructors.add(new Instructor("MILLER, J." , 6 , 2));
    	}
    	
        classrooms = new ArrayList<>();
        classrooms.add(new Classroom("GFS102"));
        classrooms.add(new Classroom("VHE306"));
        classrooms.add(new Classroom("OHE412"));
        classrooms.add(new Classroom("SLH200"));

        Courses = new GenericLinkedList<>();
        f = new File("course.dat");
    	if(f.exists() && !f.isDirectory()) {
    		try (BufferedReader br = new BufferedReader(new FileReader("course.dat"))) {
    	    	String line;
    	    	br.readLine(); br.readLine();
    	    	while ((line = br.readLine()) != null) {
    	    		String tokens [] = line.split("\t");
    	    		Course course = new Course(tokens[0], tokens[1], findInstructor(Integer.parseInt(tokens[2])), findDepartment(Integer.parseInt(tokens[3])), findLocation(tokens[4]), Integer.parseInt(tokens[5]) , tokens[6]);
    	    		Courses.add(course);
    	    	}
    		}catch(Exception e){}
    	}
    	else
    	{
    		Courses.add(new Course("CS103", "Intro to Programming", Instructors.get(0), Departments.get(0), classrooms.get(0), 2015, "Spring"));
    		Courses.add(new Course("CS350", "Intro to Operating Systems", Instructors.get(1), Departments.get(1), classrooms.get(1), 2018, "Fall"));
    		Courses.add(new Course("PHYS152", "Physics 2", Instructors.get(2), Departments.get(2), classrooms.get(2), 2019, "Spring"));
    		Courses.add(new Course("CS270", "Intro to Algorithms", Instructors.get(3), Departments.get(3), classrooms.get(3), 2016, "Fall"));
    	}
    	f = new File("enrollment.dat");
    	if(f.exists() && !f.isDirectory()) {
    		try (BufferedReader br = new BufferedReader(new FileReader("enrollment.dat"))) {
    	    	String line;
    	    	br.readLine();
    	    	while ((line = br.readLine()) != null) {
    	    		String tokens [] = line.split("\t");
    	    		Enrollment enrollment = new Enrollment(findCourse(Integer.parseInt(tokens[1])), Integer.parseInt(tokens[2]), tokens[3], tokens[4] , findStudent(Integer.parseInt(tokens[0])));
    	    		findStudent(Integer.parseInt(tokens[0])).addEnrollment(enrollment);
    	    		findCourse(Integer.parseInt(tokens[1])).addEnrollment(enrollment);
    	    	}
    		}catch(Exception e){}
    	}
    }

    public void addStudent(Student student) {
        students.add(student);
        students.sort();
        writeStudentData();
    }

    public void addCourse(Course course) {
    	Courses.add(course);
    	Courses.sort();
        writeCourseData();
    }
    
    public void addInstructor(Instructor instructor) {
    	boolean flag = false;
    	for(Instructor instruct : Instructors)
    		if(instruct.getID() == instructor.getID())
    		{
    			flag = true;
    			Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("can't add this instructor because there is already instructor exists with same id");
                alert.showAndWait();
                break;
    		}
    	if(!flag)
    		Instructors.add(instructor);
        writeInstructorData();
    }
    
    public void addDepartment(Department department) {
    	boolean flag = false;
    	for(Department depart : Departments)
    		if(depart.getID() == department.getID())
    		{
    			flag = true;
    			Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("can't add this department because there is already department exists with same id");
                alert.showAndWait();
                break;
    		}
    	if(!flag)
    		Departments.add(department);
        writeDepartmentsData();
    }

    public Student findStudent(int id) throws Exception {
        for (int i = 0; i < students.count; i++) {
            if (students.get(i).getStudentID() == id) {
                return students.get(i);
            }
        }
        throw new Exception("Student not found");
    }
    
    public Classroom findLocation(String name){
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getLocationName().equals(name)) {
                return classrooms.get(i);
            }
        }
        return null;
    }

    public Course findCourse(int id) throws Exception {
        for (int i = 0; i < Courses.count; i++) {
            if (Courses.get(i).getCourseID() == id) {
                return Courses.get(i);
            }
        }
        throw new Exception("Course not found");
    }
    
    public Instructor findInstructor(int id) throws Exception {
        for (int i = 0; i < Instructors.size(); i++) {
            if (Instructors.get(i).getID() == id) {
                return Instructors.get(i);
            }
        }
        throw new Exception("Instructor not found");
    }
    
    public Department findDepartment(int id) throws Exception {
        for (int i = 0; i < Departments.size(); i++) {
            if (Departments.get(i).getID() == id) {
                return Departments.get(i);
            }
        }
        throw new Exception("Department not found");
    }

    public GenericLinkedList<Student> getStudents() {
        return students;
    }

    public GenericLinkedList<Course> getCourses() {
        return Courses;
    }

    public ArrayList<Instructor> getInstructors() {
        return Instructors;
    }
    
    public ArrayList<Department> getDepartments() {
        return Departments;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }


    public Course findCourse(String number) throws Exception {
        for (int i = 0; i < Courses.count; i++) {
            if (Courses.get(i).getNumber().equals(number)) {
                return Courses.get(i);
            }
        }
        throw new Exception("Course not found");
    }

    public void writeStudentData() {
        // Streams
        try {
            	PrintWriter fw = new PrintWriter(new FileWriter("student.dat"));
            	fw.println("Students");
            	fw.println("SID\t\tName\t\tAddress\t\tbirthday");

                for (int i = 0; i < students.count; i++) {
                    Student student = students.get(i);
                    fw.println(student.getStudentID() + "\t" + student.getFirstName() + " " + student.getLastName() +
                    "\t" + student.getAddress() + "\t" + student.getBirthday());
                }
                fw.flush();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
         }
    }

    public void writeCourseData() {
        
    	try {
            	PrintWriter fw = new PrintWriter(new FileWriter("course.dat"));
            	fw.println("Courses");
            	fw.println("Course Number\tName\tInstructor\tDepartment\tClassroom\tyear\tsemester\tcourseID");

                for (int i = 0; i < Courses.count; i++) {
                    Course course = Courses.get(i);
                    fw.println(course.getNumber() + "\t" + course.getName() + "\t" + 
                    course.getInstructor().getID() + "\t" + course.getDepartment().getID() + "\t" +
                    course.getClassroom().getLocationName() + "\t" + course.getYear() + "\t" + course.getSemester());
                }
                fw.flush();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
        }
}
    
    public void writeInstructorData() {
        // Streams
        try {
        	PrintWriter fw = new PrintWriter(new FileWriter("instructor.dat"));
        	fw.println("Instructors");
        	fw.println("Iid\t\tName\t\tdid");

            for (int i = 0; i < Instructors.size(); i++) {
                Instructor instructor = Instructors.get(i);
                fw.println(instructor.getID() +"\t" + instructor.getName() +
                "\t" + instructor.getDepartment());
            }
            fw.flush();
        } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
        }
    }
    
    public void writeDepartmentsData() {
        // Streams
        try {
            PrintWriter fw = new PrintWriter(new FileWriter("department.dat"));
            fw.println("Departments");
            fw.println("did\t\tName");

            for (int i = 0; i < Departments.size(); i++) {
                Department department = Departments.get(i);
                fw.println(department.getID()+ "\t" + department.getName());
            }
            fw.flush();
        } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
        }
    }
  
  	public void writeEnrollmentData() {
      	try {
      		PrintWriter fw = new PrintWriter(new FileWriter("enrollment.dat"));
      		fw.println("STID\tCourse Id\tYear\tSemester\tGrade");
              	
            for (int i = 0; i < students.count; i++) {
                for (Enrollment enrollment : students.get(i).getEnrollments()) {
                  	fw.println(students.get(i).getStudentID() + "\t" + enrollment.getCourse().getCourseID()+ "\t" +
                    enrollment.getYear() + "\t" + enrollment.getSemester() + "\t" + enrollment.getGrade());
                }
            }
            fw.flush();
        } catch (IOException ioe) {
             System.out.println(ioe.getMessage());
        }
    }
}

public class UniversityApplication extends Application {

    public VBox menuPane;

    public Stage primaryStage;

    private StudentSearchView studentSearchView;
    private StudentAddView studentAddView;
    private GradeManagementView gradeManagementView;
    public GradeManagementSearchView gradeManagementSearchView;
    private CourseSearchView courseSearchView;
    public CourseResultsView courseResultsView;
    private CourseAddView courseAddView;
    public DepartmentSearchView departmentSearchView;
    public DepartmentAddView departmentAddView;
    public InstructorSearchView instructorSearchView;
    public InstructorAddView instructorAddView;
    private EnrollmentSearchView enrollmentSearchView;
    public EnrollmentResultsView enrollmentResultsView;
    private EnrollmentAddView enrollmentAddView;
    public EnrollmentAddResultsView enrollmentAddResultsView;
    private GenerateReportView generateReportView;
    public ReportView reportView;

    private University university;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ps) throws Exception {
        university = new University();

        primaryStage = ps;
        primaryStage.setTitle("Student Information System");

        menuPane = makeMenuPane();
        BorderPane bp = new BorderPane();
        bp.setTop(menuPane);

        setupViews();

        primaryStage.setScene(new Scene(bp, 500, 500));
        primaryStage.show();
    }

    private void setupViews() {
        studentSearchView = new StudentSearchView(this);
        studentAddView = new StudentAddView(this);

        gradeManagementView = new GradeManagementView(this);
        gradeManagementSearchView = new GradeManagementSearchView(this);

        courseSearchView = new CourseSearchView(this);
        courseResultsView = new CourseResultsView(this);
        courseAddView = new CourseAddView(this);
        
        departmentSearchView = new DepartmentSearchView(this);
        departmentAddView = new DepartmentAddView(this);
        
        instructorSearchView = new InstructorSearchView(this);
        instructorAddView = new InstructorAddView(this);

        enrollmentSearchView = new EnrollmentSearchView(this);
        enrollmentResultsView = new EnrollmentResultsView(this);
        enrollmentAddView = new EnrollmentAddView(this);
        enrollmentAddResultsView = new EnrollmentAddResultsView(this);

        generateReportView = new GenerateReportView(this);
        reportView = new ReportView(this);
    }

    public VBox makeMenuPane() {
        // Student Info
        Menu studentInfoMenu = new Menu("Student Info");
        MenuItem studentInfo1 = new MenuItem("Search");
        studentInfo1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(studentSearchView.searchScene);
            }
        });
        MenuItem studentInfo2 = new MenuItem("Add");
        studentInfo2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(studentAddView.addScene);
            }
        });
        studentInfoMenu.getItems().addAll(studentInfo1, studentInfo2);

        // Course
        Menu courseMenu = new Menu("Course");
        MenuItem course1 = new MenuItem("Search");
        MenuItem course2 = new MenuItem("Add");
        course1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	courseSearchView.setup();
                primaryStage.setScene(courseSearchView.courseSearchScene);
            }
        });
        course2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	courseAddView.setup();
                primaryStage.setScene(courseAddView.courseAddScene);
            }
        });
        courseMenu.getItems().addAll(course1, course2);
        
     // instructor
        Menu instructorMenu = new Menu("Instructor");
        MenuItem instructor1 = new MenuItem("Search");
        instructor1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	instructorSearchView.setup();
                primaryStage.setScene(instructorSearchView.searchScene);
            }
        });
        MenuItem instructor2 = new MenuItem("Add");
        instructor2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	instructorAddView.setup();
                primaryStage.setScene(instructorAddView.addScene);
            }
        });
        instructorMenu.getItems().addAll(instructor1, instructor2);
        
     // department
        Menu departmentMenu = new Menu("Department");
        MenuItem department1 = new MenuItem("Search");
        department1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	departmentSearchView.setup();
            	primaryStage.setScene(departmentSearchView.searchScene);
            }
        });
        MenuItem department2 = new MenuItem("Add");
        department2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	departmentAddView.setup();
                primaryStage.setScene(departmentAddView.addScene);
            }
        });
        departmentMenu.getItems().addAll(department1, department2);

        // Enrollment
        Menu enrollmentMenu = new Menu("Enrollment");
        MenuItem enrollment1 = new MenuItem("Search");
        enrollment1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	enrollmentSearchView.setup();
                primaryStage.setScene(enrollmentSearchView.enrollmentSearchScene);
            }
        });
        MenuItem enrollment2 = new MenuItem("Add");
        enrollment2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	enrollmentAddView.setup();
                primaryStage.setScene(enrollmentAddView.enrollmentAddScene);
            }
        });
        enrollmentMenu.getItems().addAll(enrollment1, enrollment2);

        // Grade Management
        Menu gradeManagementMenu = new Menu("Grade Management");
        MenuItem gradeManagement1 = new MenuItem("Manage Grade");
        gradeManagement1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	gradeManagementView.setup();
                primaryStage.setScene(gradeManagementView.gradeManagementScene);
            }
        });
        gradeManagementMenu.getItems().add(gradeManagement1);

        // Report
        Menu reportMenu = new Menu("Report");
        MenuItem report1 = new MenuItem("Generate Report");
        report1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	generateReportView.setup();
                primaryStage.setScene(generateReportView.generateReportScene);
            }
        });
        reportMenu.getItems().add(report1);

        // Make menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(studentInfoMenu, courseMenu, instructorMenu, departmentMenu, enrollmentMenu, gradeManagementMenu, reportMenu);

        return new VBox(menuBar);
    }

    public void submitGradeManagementSearch(String studentID, Integer year, String semester) {
        // Do some lookup on our University class object (to be created in the future)
        // String results = some kind of lookup to find the correct student
        String results = "EnrollID:CourseID:Year:Semester:Grade\n";
        int idNumber = Integer.parseInt(studentID);
        Student student;
        for (int i = 0; i < university.getStudents().count; i++) {
            if (university.getStudents().get(i).getStudentID() == idNumber) {
                student = university.getStudents().get(i);
                
                for (int j = 0; j < student.getEnrollments().size(); j++) {
                    if (student.getEnrollments().get(j).getSemester().equals(semester) && student.getEnrollments().get(j).getYear() == year) {
                        results += student.getEnrollments().get(j).getEnrollmentID() + ":"
                        		+ student.getEnrollments().get(j).getCourse().getCourseID() + ":"
                        		+ student.getEnrollments().get(j).getYear() + ":" + student.getEnrollments().get(j).getSemester()
                        		+ ":" + student.getEnrollments().get(j).getGrade() + "\n";
                    }
                }
                break;
            }
        }

        gradeManagementSearchView.setResultsString(results);
    }

    public void showCourseResultsView() {
    	courseResultsView.setup();
        primaryStage.setScene(courseResultsView.courseResultsScene);
    }

    public void showGradeManagementView() {
    	gradeManagementView.setup();
        primaryStage.setScene(gradeManagementView.gradeManagementScene);
    }

    public void showEnrollmentResultsView() {
    	enrollmentResultsView.setup();
        primaryStage.setScene(enrollmentResultsView.enrollmentResultsScene);
    }

    public void showEnrollmentAddView() {
    	enrollmentAddView.setup();
        primaryStage.setScene(enrollmentAddView.enrollmentAddScene);
    }

    public void showEnrollmentAddResultsView() {
    	enrollmentAddResultsView.setup();
        primaryStage.setScene(enrollmentAddResultsView.enrollmentAddResultsScene);
    }

    public void showReportView() {
    	reportView.setup();
        primaryStage.setScene(reportView.reportScene);
    }

    public University getUniversity() {
        return university;
    }
}

class StudentSearchView {

    UniversityApplication app;

    public Scene searchScene;
    HBox searchBox;
    HBox resultsBox;
    HBox editBox;
    TextField searchField;

    Label idResultLabel;
    Label nameResultLabel;
    Label birthdayResultLabel;
    Label addressResultLabel;
    TextField editIDField;
    TextField editNameField;
    TextField editBirthdayField;
    TextField editAddressField;

    BorderPane mainPane;

    Student foundStudent;

    public StudentSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        searchBox = makeSearchBox();
        resultsBox = makeResultsBox();

        mainPane = new BorderPane();
        mainPane.setTop(searchBox);
        mainPane.setCenter(resultsBox);

        BorderPane bp2 = new BorderPane();
        bp2.setTop(app.makeMenuPane());
        bp2.setCenter(mainPane);


        searchScene = new Scene(bp2, 500, 300);

        resultsBox.setVisible(false);
    }

    private HBox makeSearchBox() {
        Label searchLabel = new Label("Enter Student ID");
        searchField = new TextField();
        Button searchbutton = new Button("Search");
        searchbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                	int id = Integer.parseInt(searchField.getText());
                    Student student = app.getUniversity().findStudent(id);

                    idResultLabel.setText(Integer.toString(student.getStudentID()));
                    nameResultLabel.setText(student.getFirstName() + " " + student.getLastName());
                    birthdayResultLabel.setText(student.getBirthday());
                    addressResultLabel.setText(student.getAddress());

                    resultsBox.setVisible(true);
                    foundStudent = student;
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This Student ID does not exist: " + searchField.getText());
                    alert.showAndWait();
                }
            }
        });

        HBox box = new HBox(5);
        box.getChildren().addAll(searchLabel, searchField, searchbutton);
        box.setAlignment(Pos.CENTER);

        return box;
    }

    private HBox makeResultsBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label birthdayLabel = new Label("Birthday");
        Label addressLabel = new Label("Address");
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editBox = makeEditBox();
                mainPane.setCenter(editBox);
                mainPane.setTop(null);
            }
        });

        VBox leftBox = new VBox(10);
        leftBox.getChildren().addAll(idLabel, nameLabel, birthdayLabel, addressLabel, editButton);

        idResultLabel = new Label("");
        nameResultLabel = new Label("");
        birthdayResultLabel = new Label("");
        addressResultLabel = new Label("");

        VBox rightBox = new VBox(10);
        rightBox.getChildren().addAll(idResultLabel, nameResultLabel, birthdayResultLabel, addressResultLabel);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }

    private HBox makeEditBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label birthdayLabel = new Label("Birthday");
        Label addressLabel = new Label("Address");
        Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                foundStudent.setStudentID(Integer.parseInt(editIDField.getText()));
                foundStudent.setName(editNameField.getText());
                foundStudent.setAddress(editAddressField.getText());
                foundStudent.setBirthday(editBirthdayField.getText());

                idResultLabel.setText(Integer.toString(foundStudent.getStudentID()));
                nameResultLabel.setText(foundStudent.getFirstName() + " " + foundStudent.getLastName());
                birthdayResultLabel.setText(foundStudent.getBirthday());
                addressResultLabel.setText(foundStudent.getAddress());
                app.getUniversity().writeStudentData();

                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox leftBox = new VBox(20);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(idLabel, nameLabel, birthdayLabel, addressLabel, updateButton);

        editIDField = new TextField();
        editIDField.setText(Integer.toString(foundStudent.getStudentID()));
        editNameField = new TextField();
        editNameField.setText(foundStudent.getFirstName() + " " + foundStudent.getLastName());
        editBirthdayField = new TextField();
        editBirthdayField.setText(foundStudent.getBirthday());
        editAddressField = new TextField();
        editAddressField.setText(foundStudent.getAddress());
        Button cancelButton = new Button("Cancel Update");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox rightBox = new VBox(10);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(editIDField, editNameField, editBirthdayField, editAddressField, cancelButton);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }
}


class DepartmentSearchView {

    UniversityApplication app;

    public Scene searchScene;
    HBox searchBox;
    HBox resultsBox;
    HBox editBox;
    TextField searchField;

    Label idResultLabel;
    Label nameResultLabel;
    TextField editIDField;
    TextField editNameField;

    BorderPane mainPane;

    Department foundDepartment;

    public DepartmentSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        searchBox = makeSearchBox();
        resultsBox = makeResultsBox();

        mainPane = new BorderPane();
        mainPane.setTop(searchBox);
        mainPane.setCenter(resultsBox);

        BorderPane bp2 = new BorderPane();
        bp2.setTop(app.makeMenuPane());
        bp2.setCenter(mainPane);


        searchScene = new Scene(bp2, 500, 300);

        resultsBox.setVisible(false);
    }

    private HBox makeSearchBox() {
        Label searchLabel = new Label("Enter Department ID");
        searchField = new TextField();
        Button searchbutton = new Button("Search");
        searchbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                try {
                	int id = Integer.parseInt(searchField.getText());
                    Department department = app.getUniversity().findDepartment(id);

                    idResultLabel.setText(Integer.toString(department.getID()));
                    nameResultLabel.setText(department.getName());

                    resultsBox.setVisible(true);
                    foundDepartment = department;
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This Department ID does not exist: " + searchField.getText());
                    alert.showAndWait();
                }
            }
        });

        HBox box = new HBox(5);
        box.getChildren().addAll(searchLabel, searchField, searchbutton);
        box.setAlignment(Pos.CENTER);

        return box;
    }

    private HBox makeResultsBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editBox = makeEditBox();
                mainPane.setCenter(editBox);
                mainPane.setTop(null);
            }
        });

        VBox leftBox = new VBox(10);
        leftBox.getChildren().addAll(idLabel, nameLabel, editButton);

        idResultLabel = new Label("");
        nameResultLabel = new Label("");

        VBox rightBox = new VBox(10);
        rightBox.getChildren().addAll(idResultLabel, nameResultLabel);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }

    private HBox makeEditBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                foundDepartment.setDepartmentID(Integer.parseInt(editIDField.getText()));
                foundDepartment.setDepartmentName(editNameField.getText());

                idResultLabel.setText(Integer.toString(foundDepartment.getID()));
                nameResultLabel.setText(foundDepartment.getName());
                app.getUniversity().writeDepartmentsData();;

                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox leftBox = new VBox(20);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(idLabel, nameLabel, updateButton);

        editIDField = new TextField();
        editIDField.setText(Integer.toString(foundDepartment.getID()));
        editNameField = new TextField();
        editNameField.setText(foundDepartment.getName());
        Button cancelButton = new Button("Cancel Update");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox rightBox = new VBox(10);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(editIDField, editNameField, cancelButton);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }
}

class InstructorSearchView {

    UniversityApplication app;

    public Scene searchScene;
    HBox searchBox;
    HBox resultsBox;
    HBox editBox;
    TextField searchField;

    Label idResultLabel;
    Label nameResultLabel;
    Label didResultLabel;
    TextField editIDField;
    TextField editNameField;
    TextField editDIDField;

    BorderPane mainPane;

    Instructor foundInstructor;

    public InstructorSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        searchBox = makeSearchBox();
        resultsBox = makeResultsBox();

        mainPane = new BorderPane();
        mainPane.setTop(searchBox);
        mainPane.setCenter(resultsBox);

        BorderPane bp2 = new BorderPane();
        bp2.setTop(app.makeMenuPane());
        bp2.setCenter(mainPane);


        searchScene = new Scene(bp2, 500, 300);

        resultsBox.setVisible(false);
    }

    private HBox makeSearchBox() {
        Label searchLabel = new Label("Enter Instructor ID");
        searchField = new TextField();
        Button searchbutton = new Button("Search");
        searchbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                	int id = Integer.parseInt(searchField.getText());
                    Instructor instructor = app.getUniversity().findInstructor(id);

                    idResultLabel.setText(Integer.toString(instructor.getID()));
                    nameResultLabel.setText(instructor.getName());
                    didResultLabel.setText(Integer.toString(instructor.getDepartment()));

                    resultsBox.setVisible(true);
                    foundInstructor = instructor;
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This Instructor ID does not exist: " + searchField.getText());
                    alert.showAndWait();
                }
            }
        });

        HBox box = new HBox(5);
        box.getChildren().addAll(searchLabel, searchField, searchbutton);
        box.setAlignment(Pos.CENTER);

        return box;
    }

    private HBox makeResultsBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label birthdayLabel = new Label("Department ID");
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editBox = makeEditBox();
                mainPane.setCenter(editBox);
                mainPane.setTop(null);
            }
        });

        VBox leftBox = new VBox(10);
        leftBox.getChildren().addAll(idLabel, nameLabel, birthdayLabel, editButton);

        idResultLabel = new Label("");
        nameResultLabel = new Label("");
        didResultLabel = new Label("");

        VBox rightBox = new VBox(10);
        rightBox.getChildren().addAll(idResultLabel, nameResultLabel, didResultLabel);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }

    private HBox makeEditBox() {
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label didLabel = new Label("Department ID");
        Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	foundInstructor.setID(Integer.parseInt(editIDField.getText()));
            	foundInstructor.setName(editNameField.getText());
            	foundInstructor.setDepartment(Integer.parseInt(editDIDField.getText()));

                idResultLabel.setText(Integer.toString(foundInstructor.getID()));
                nameResultLabel.setText(foundInstructor.getName());
                didResultLabel.setText(Integer.toString(foundInstructor.getDepartment()));
                app.getUniversity().writeInstructorData();

                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox leftBox = new VBox(20);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(idLabel, nameLabel, didLabel, updateButton);

        editIDField = new TextField();
        editIDField.setText(Integer.toString(foundInstructor.getID()));
        editNameField = new TextField();
        editNameField.setText(foundInstructor.getName());
        editDIDField = new TextField();
        editDIDField.setText(Integer.toString(foundInstructor.getDepartment()));
        Button cancelButton = new Button("Cancel Update");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.setTop(searchBox);
                mainPane.setCenter(resultsBox);
            }
        });

        VBox rightBox = new VBox(10);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(editIDField, editNameField, editDIDField, cancelButton);

        HBox mainBox = new HBox(40);
        mainBox.getChildren().addAll(leftBox, rightBox);
        return mainBox;
    }
}


class StudentAddView {

    UniversityApplication app;

    public Scene addScene;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField birthdayField;
    private TextField addressField;

    public StudentAddView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        // Setup left VBox
        Label firstNameLabel = new Label("First Name (*Require)");
        Label lastNameLabel = new Label("Last Name (*Require)");
        Label birthdayLabel = new Label("Birthday (*Require)");
        Label addressLabel = new Label("Address");
        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(firstNameField.getText().equals("") || lastNameField.getText().equals("") || birthdayField.getText().equals(""))
            	{
            		Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("enter all required fields first");
                    alert.showAndWait();
            		return;
            	}
                Student student = new Student(firstNameField.getText(), lastNameField.getText(),
                        birthdayField.getText(), addressField.getText());
                app.getUniversity().addStudent(student);
                firstNameField.clear();
                lastNameField.clear();
                birthdayField.clear();
                addressField.clear();
            }
        });
        VBox leftBox = new VBox(25);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(firstNameLabel, lastNameLabel, birthdayLabel, addressLabel, addButton);

        // Setup right VBox
        firstNameField = new TextField();
        lastNameField = new TextField();
        birthdayField = new TextField();
        addressField = new TextField();
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firstNameField.clear();
                lastNameField.clear();
                birthdayField.clear();
                addressField.clear();
            }
        });
        VBox rightBox = new VBox(15);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(firstNameField, lastNameField, birthdayField, addressField, resetButton);

        HBox box = new HBox(15);
        box.getChildren().addAll(leftBox, rightBox);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(box);

        addScene = new Scene(bp, 500, 400);
    }

}

class DepartmentAddView {

    UniversityApplication app;

    public Scene addScene;
    private TextField idField;
    private TextField nameField;

    public DepartmentAddView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        // Setup left VBox
        Label firstNameLabel = new Label("Department ID (*Require)");
        Label lastNameLabel = new Label("Department Name (*Require)");
        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(nameField.getText().equals("") || idField.getText().equals(""))
            	{
            		Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("enter all required fields first");
                    alert.showAndWait();
            		return;
            	}
                Department department = new Department(nameField.getText(), Integer.parseInt(idField.getText()));
                app.getUniversity().addDepartment(department);;
                idField.clear();
                nameField.clear();
            }
        });
        VBox leftBox = new VBox(25);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(firstNameLabel, lastNameLabel, addButton);

        // Setup right VBox
        idField = new TextField();
        nameField = new TextField();
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                idField.clear();
                nameField.clear();
            }
        });
        VBox rightBox = new VBox(15);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(idField, nameField, resetButton);

        HBox box = new HBox(15);
        box.getChildren().addAll(leftBox, rightBox);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(box);

        addScene = new Scene(bp, 500, 400);
    }

}

class InstructorAddView {

    UniversityApplication app;

    public Scene addScene;
    private TextField idField;
    private TextField nameField;
    private ComboBox<Integer> didField;

    public InstructorAddView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        // Setup left VBox
        Label idLabel = new Label("Instructor ID (*Require)");
        Label nameLabel = new Label("Instructor Name (*Require)");
        Label didLabel = new Label("Department ID (*Require)");
        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(nameField.getText().equals("") || idField.getText().equals("") || didField.getSelectionModel().isEmpty())
            	{
            		Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("enter all required fields first");
                    alert.showAndWait();
            		return;
            	}
                Instructor instructor = new Instructor(nameField.getText(), Integer.parseInt(idField.getText()), Integer.parseInt(didField.getValue() + ""));
                app.getUniversity().addInstructor(instructor);
                nameField.clear();
                idField.clear();
            }
        });
        VBox leftBox = new VBox(25);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(idLabel, nameLabel, didLabel, addButton);

        // Setup right VBox
        idField = new TextField();
        nameField = new TextField();
        didField = new ComboBox<>();
        for(int i = 0; i < app.getUniversity().getDepartments().size(); i++)
        	didField.getItems().add(app.getUniversity().getDepartments().get(i).getID());
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	idField.clear();
            	nameField.clear();
            }
        });
        VBox rightBox = new VBox(15);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.getChildren().addAll(idField, nameField, didField, resetButton);

        HBox box = new HBox(15);
        box.getChildren().addAll(leftBox, rightBox);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(box);

        addScene = new Scene(bp, 500, 400);
    }

}

class CourseAddView {

    private TextField numberField;
    private TextField titleField;
    private ComboBox<String> instructorComboBox;
    private ComboBox<String> departmentComboBox;
    private ComboBox<String> locationComboBox;
    private Button addButton;

    UniversityApplication app;
    Scene courseAddScene;

    public CourseAddView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        Label numberLabel = new Label("Enter course number");
        Label titleLabel = new Label("Enter course title");
        Label instructorLabel = new Label("Enter course instructor");
        Label departmentLabel = new Label("Enter course department");
        Label locationLabel = new Label("Enter course location");
        addButton = new Button("Add");
        addButton.setDisable(true);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int locationIndex = locationComboBox.getSelectionModel().getSelectedIndex();
                
                Department department = null;
                for(Department depart : app.getUniversity().getDepartments())
                	if(depart.getName().equals(departmentComboBox.getValue()))
                	{
                		department = depart;
                	}
                Instructor instructor = null;;
                for(Instructor instruct : app.getUniversity().getInstructors())
                	if(instruct.getName().equals(instructorComboBox.getValue()) && department.getID() == instruct.getDepartment())
                	{
                		instructor = instruct;
                	}
                Classroom location = app.getUniversity().getClassrooms().get(locationIndex);

                Course course = new Course(numberField.getText(), titleField.getText(), instructor,department, location);
                app.getUniversity().addCourse(course);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("Course data has been added for course ID " + course.getCourseID());
                alert.showAndWait();

                numberField.clear();
                titleField.clear();
                instructorComboBox.setValue(null);
                locationComboBox.setValue(null);
                addButton.setDisable(true);
            }
        });

        VBox leftBox = new VBox(20);
        leftBox.getChildren().addAll(numberLabel, titleLabel, departmentLabel, instructorLabel, locationLabel, addButton);

        numberField = new TextField();
        numberField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleAddButton();
            }
        });
        titleField = new TextField();
        titleField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleAddButton();
            }
        });
        instructorComboBox = new ComboBox<>();
        instructorComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleAddButton();
            }
        });
        departmentComboBox = new ComboBox<>();
        for (int i = 0; i < app.getUniversity().getDepartments().size(); i++) {
            Department department = app.getUniversity().getDepartments().get(i);
            departmentComboBox.getItems().add(department.getName());
        }
        departmentComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	instructorComboBox.getItems().clear();
            	for (int i = 0; i < app.getUniversity().getInstructors().size(); i++) {
                    Instructor Instructor = app.getUniversity().getInstructors().get(i);
                    try {
                    	//System.out.println(app.getUniversity().getInstructors().get(i).getDepartment());
						if(app.getUniversity().findDepartment(app.getUniversity().getInstructors().get(i).getDepartment()).getName().equals(departmentComboBox.getValue()))
							instructorComboBox.getItems().add(Instructor.getName());
					} catch (Exception e) {
						Alert alert = new Alert(Alert.AlertType.WARNING);
	                    alert.setTitle("Error");
	                    alert.setContentText(e.getMessage());
	                    alert.showAndWait();
					}
                }
            }
        });
        locationComboBox = new ComboBox<>();
        for (int i = 0; i < app.getUniversity().getClassrooms().size(); i++) {
            Classroom classroom = app.getUniversity().getClassrooms().get(i);
            locationComboBox.getItems().add(classroom.getLocationName());
        }
        locationComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleAddButton();
            }
        });
        VBox rightBox = new VBox(10);
        rightBox.getChildren().addAll(numberField, titleField, departmentComboBox, instructorComboBox, locationComboBox);

        HBox addBox = new HBox(5);
        addBox.setPadding(new Insets(15, 15, 15, 15));
        addBox.getChildren().addAll(leftBox, rightBox);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(addBox);
        bp.setAlignment(addBox, Pos.CENTER);

        courseAddScene = new Scene(bp, 600, 600);
    }

    private void toggleAddButton() {
        boolean hasNumber = numberField.getText().length() > 0;
        boolean hasTitle = titleField.getText().length() > 0;
        boolean hasInstructor = instructorComboBox.getValue() != null;
        boolean hasLocation = locationComboBox.getValue() != null;
        boolean shouldEnable = hasNumber && hasTitle && hasInstructor && hasLocation;
        addButton.setDisable(!shouldEnable);
    }
}

class CourseSearchView {
    private TextField idField;
    private Button searchButton;

    UniversityApplication app;
    Scene courseSearchScene;

    public CourseSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        Label enterCourseIDLabel = new Label("Enter Course ID");
        idField = new TextField();
        idField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchButton.setDisable(idField.getText().length() <= 0);
            }
        });
        searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int courseID = Integer.parseInt(idField.getText());
                    Course course = app.getUniversity().findCourse(courseID);
                    app.courseResultsView.setCourse(course);
                    app.showCourseResultsView();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This course ID does not exist: " + idField.getText());
                    alert.showAndWait();
                }
            }
        });
        searchButton.setDisable(true);

        HBox searchBox = new HBox(10);
        searchBox.getChildren().addAll(enterCourseIDLabel, idField, searchButton);
        searchBox.setPadding(new Insets(15, 15, 15, 15));

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(searchBox);
        bp.setAlignment(searchBox, Pos.CENTER);

        courseSearchScene = new Scene(bp, 600, 300);
    }
}

class CourseResultsView {

    UniversityApplication app;
    Scene courseResultsScene;

    private TextField idTextField;
    private Label idResultLabel;
    private Label numberResultLabel;
    private Label nameResultLabel;
    private Label instructorResultLabel;
    private Label departmentResultLabel;
    private Label classroomResultLabel;
    private Label idResultEditingLabel;
    private TextField numberTextField;
    private TextField nameTextField;
    private ComboBox<String> instructorComboBox;
    private ComboBox<String> departmentComboBox;
    private ComboBox<String> classroomComboBox;
    private Button editButton;

    private VBox leftBox;
    private VBox staticRightBox;
    private VBox editingRightBox;
    private BorderPane innerPane;

    private Boolean isEditing = false;
    private Course currentCourse;

    public CourseResultsView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        Label enterCourseIDLabel = new Label("Enter Course ID");
        idTextField = new TextField();
        Button searchButton = new Button("Search");

        HBox searchBox = new HBox(10);
        searchBox.getChildren().addAll(enterCourseIDLabel, idTextField, searchButton);
        searchBox.setPadding(new Insets(15, 15, 15, 15));

        Label idLabel = new Label("ID");
        Label numberLabel = new Label("Number");
        Label nameLabel = new Label("Name");
        Label instructorLabel = new Label("Instructor");
        Label departmentLabel = new Label("Department");
        Label classroomLabel = new Label("Classroom");
        editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isEditing = !isEditing;
                if (isEditing) {
                    innerPane.setCenter(editingRightBox);
                    editButton.setText("Save");
                    leftBox.setSpacing(20);
                } else {
                    Department department = null;
                    for(Department depart : app.getUniversity().getDepartments())
                    	if(depart.getName().equals(departmentComboBox.getValue()))
                    	{
                    		department = depart;
                    	}
                    Instructor instructor = null;;
                    for(Instructor instruct : app.getUniversity().getInstructors())
                    	if(instruct.getName().equals(instructorComboBox.getValue()) && department.getID() == instruct.getDepartment())
                    	{
                    		instructor = instruct;
                    	}
                    int classroomIndex = classroomComboBox.getSelectionModel().getSelectedIndex();
                    Classroom classroom = app.getUniversity().getClassrooms().get(classroomIndex);
                    currentCourse.saveCourseData(numberTextField.getText(), nameTextField.getText(), instructor, department, classroom);
                    setCourse(currentCourse);
                    app.getUniversity().writeCourseData();
                    idResultLabel.setText(Integer.toString(currentCourse.getCourseID()));
                	idResultEditingLabel.setText(Integer.toString(currentCourse.getCourseID()));
                	numberResultLabel.setText(currentCourse.getNumber());
                	nameResultLabel.setText(currentCourse.getName());
                	instructorResultLabel.setText(currentCourse.getInstructor().getName());
                	departmentResultLabel.setText(currentCourse.getDepartment().getName());
                	classroomResultLabel.setText(currentCourse.getClassroom().getLocationName());

                	numberTextField.setText(currentCourse.getNumber());
                	nameTextField.setText(currentCourse.getName());
                	instructorComboBox.setValue(currentCourse.getInstructor().getName());
                	departmentComboBox.setValue(currentCourse.getDepartment().getName());
                	classroomComboBox.setValue(currentCourse.getClassroom().getLocationName());

                    innerPane.setCenter(staticRightBox);
                    editButton.setText("Edit");
                    leftBox.setSpacing(10);
                }
            }
        });

        leftBox = new VBox(10);
        leftBox.getChildren().addAll(idLabel, numberLabel, nameLabel, departmentLabel, instructorLabel, classroomLabel, editButton);
        leftBox.setPadding(new Insets(15, 15, 15, 15));

        idResultLabel = new Label();
        idResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        numberResultLabel = new Label();
        numberResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        nameResultLabel = new Label();
        nameResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        instructorResultLabel = new Label();
        instructorResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        departmentResultLabel = new Label();
        departmentResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        classroomResultLabel = new Label();
        classroomResultLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        staticRightBox = new VBox(10);
        staticRightBox.getChildren().addAll(idResultLabel, numberResultLabel, nameResultLabel, departmentResultLabel, instructorResultLabel, classroomResultLabel);
        staticRightBox.setPadding(new Insets(15, 15, 15, 15));

        idResultEditingLabel = new Label();
        idResultEditingLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        numberTextField = new TextField();
        nameTextField = new TextField();
        instructorComboBox = new ComboBox<>();
        departmentComboBox = new ComboBox<>();
        classroomComboBox = new ComboBox<>();
        for (Department department : app.getUniversity().getDepartments()) {
        	departmentComboBox.getItems().add(department.getName());
        }
        for (Classroom classroom : app.getUniversity().getClassrooms()) {
            classroomComboBox.getItems().add(classroom.getLocationName());
        }
        departmentComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	instructorComboBox.getItems().clear();
            	for (int i = 0; i < app.getUniversity().getInstructors().size(); i++) {
                    Instructor Instructor = app.getUniversity().getInstructors().get(i);
                    try {
                    	//System.out.println(app.getUniversity().getInstructors().get(i).getDepartment());
						if(app.getUniversity().findDepartment(app.getUniversity().getInstructors().get(i).getDepartment()).getName().equals(departmentComboBox.getValue()))
							instructorComboBox.getItems().add(Instructor.getName());
					} catch (Exception e) {
						Alert alert = new Alert(Alert.AlertType.WARNING);
	                    alert.setTitle("Error");
	                    alert.setContentText(e.getMessage());
	                    alert.showAndWait();
					}
                }
            }
        });
        if(currentCourse != null)
        {
        	idResultLabel.setText(Integer.toString(currentCourse.getCourseID()));
        	idResultEditingLabel.setText(Integer.toString(currentCourse.getCourseID()));
        	numberResultLabel.setText(currentCourse.getNumber());
        	nameResultLabel.setText(currentCourse.getName());
        	instructorResultLabel.setText(currentCourse.getInstructor().getName());
        	departmentResultLabel.setText(currentCourse.getDepartment().getName());
        	classroomResultLabel.setText(currentCourse.getClassroom().getLocationName());

        	numberTextField.setText(currentCourse.getNumber());
        	nameTextField.setText(currentCourse.getName());
        	instructorComboBox.setValue(currentCourse.getInstructor().getName());
        	departmentComboBox.setValue(currentCourse.getDepartment().getName());
        	classroomComboBox.setValue(currentCourse.getClassroom().getLocationName());
        }
        editingRightBox = new VBox(10);
        editingRightBox.getChildren().addAll(idResultEditingLabel, numberTextField, nameTextField, departmentComboBox, instructorComboBox, classroomComboBox);
        editingRightBox.setPadding(new Insets(15, 15, 15, 15));

        innerPane = new BorderPane();
        innerPane.setTop(searchBox);
        innerPane.setLeft(leftBox);
        innerPane.setCenter(staticRightBox);

        BorderPane outerPane = new BorderPane();
        outerPane.setTop(app.makeMenuPane());
        outerPane.setCenter(innerPane);

        courseResultsScene = new Scene(outerPane, 500, 400);
    }

    public void setCourse(Course course) {
        currentCourse = course;
    }
}

class GradeManagementView {

    UniversityApplication app;
    Scene gradeManagementScene;

    TextField idTextField;
    ComboBox<Integer> yearComboBox;
    ComboBox<String> semesterComboBox;
    Button searchButton;

    public GradeManagementView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    private void toggleSearchButton() {
        boolean hasID = idTextField.getText().length() > 0;
        boolean hasYear = semesterComboBox.getValue() != null;
        boolean hasSemester = semesterComboBox.getValue() != null;
        boolean shouldEnable = hasID && hasYear && hasSemester;
        searchButton.setDisable(!shouldEnable);
    }

    public void setup() {
        Label inputLabel = new Label("Import Student ID");
        idTextField = new TextField();
        idTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleSearchButton();
            }
        });
        yearComboBox = new ComboBox<>();
        yearComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleSearchButton();
            }
        });
        yearComboBox.getItems().addAll(2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019);
        semesterComboBox = new ComboBox<>();
        semesterComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toggleSearchButton();
            }
        });
        semesterComboBox.getItems().addAll("Fall", "Winter", "Spring", "Summer");
        searchButton = new Button("Search");
        searchButton.setDisable(true);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.submitGradeManagementSearch(idTextField.getText(), yearComboBox.getValue(),
                        semesterComboBox.getValue());
                app.primaryStage.setScene(app.gradeManagementSearchView.gradeManagementSearchScene);
            }
        });
        HBox searchBox = new HBox(5);
        searchBox.setPadding(new Insets(15, 15, 15, 15));
        searchBox.getChildren().addAll(inputLabel, idTextField, yearComboBox, semesterComboBox, searchButton);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(searchBox);
        bp.setAlignment(searchBox, Pos.CENTER);

        gradeManagementScene = new Scene(bp, 600, 200);
    }
}

class GradeManagementSearchView {

    UniversityApplication app;
    Scene gradeManagementSearchScene;
    VBox result;
    Button save;
    
    ArrayList<ComboBox<String>> gradesBoxes; 
    ArrayList<Integer> enrollIDS; 

    public String resultsString;

    public GradeManagementSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
    	gradesBoxes = new ArrayList<>();
    	enrollIDS = new ArrayList<>();
        Label searchResultLabel = new Label("Search Result:1 (* means grade not assigned.)");
        result  = new VBox(5);
        Button editGradeButton = new Button("Edit Grade");
        editGradeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	save.setVisible(true);
                for(ComboBox<String> combo : gradesBoxes)
                	combo.setDisable(false);
            }
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.showGradeManagementView();
            }
        });
        save = new Button("Save");
        save.setVisible(false);
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(editGradeButton, cancelButton);
        VBox resultsBox = new VBox(5);
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setPadding(new Insets(15, 15, 15, 15));
        resultsBox.getChildren().addAll(searchResultLabel, result, buttonBox , save);
        
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save.setVisible(false);
                for(int id = 0; id < enrollIDS.size(); id++)
                {
                	for (int i = 0; i < app.getUniversity().getStudents().count; i++) {
                		for (int j = 0; j < app.getUniversity().getStudents().get(i).getEnrollments().size(); j++) {
                			if(app.getUniversity().getStudents().get(i).getEnrollments().get(j).getEnrollmentID() == enrollIDS.get(id))
                				app.getUniversity().getStudents().get(i).getEnrollments().get(j).setGrade(gradesBoxes.get(id).getValue());
                		}
                	}
                }
                app.getUniversity().writeEnrollmentData();
                for(int id = 0; id < enrollIDS.size(); id++)
                	gradesBoxes.get(id).setDisable(true);
            }
        });

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(resultsBox);

        gradeManagementSearchScene = new Scene(bp, 500, 300);
    }

    public void setResultsString(String results) {
        resultsString = results;
        gradesBoxes.clear();
        enrollIDS.clear();
        result.getChildren().clear();
        String tokens[] = resultsString.split("\n");
        
    	for(int i = 0; i < tokens.length;i++)
    	{
    		String rowDetails[] = tokens[i].split(":");
    		HBox row = new HBox(30);
    		row.getChildren().add(new Label(rowDetails[0]));
    		row.getChildren().add(new Label(rowDetails[1]));
    		row.getChildren().add(new Label(rowDetails[2]));
    		row.getChildren().add(new Label(rowDetails[3]));
    		if(i != 0){
    			enrollIDS.add(Integer.parseInt(rowDetails[0]));
    			ComboBox<String> grades = new ComboBox<>();
    			grades.getItems().addAll("not" ,"A" , "B" , "C" , "D" , "F");
    			grades.setValue(rowDetails[4]);
    			row.getChildren().add(grades);
    			grades.setEditable(false);
    			grades.setDisable(true);
    			gradesBoxes.add(grades);
    		}
    		result.getChildren().add(row);
    	}
    }
}

class EnrollmentSearchView {

    UniversityApplication app;
    Scene enrollmentSearchScene;

    public EnrollmentSearchView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        // Search HBox
        Label inputIDLabel = new Label("Input Student ID");
        TextField idTextField = new TextField();
        HBox searchBox = new HBox(5);
        searchBox.getChildren().addAll(inputIDLabel, idTextField);

        Label searchStudentLabel = new Label("Search by Student");
        Button searchButton = new Button("Search by Student ID");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int studentID = Integer.parseInt(idTextField.getText());
                    Student student = app.getUniversity().findStudent(studentID);
                    app.enrollmentResultsView.setStudent(student);
                    app.showEnrollmentResultsView();
                } catch (Exception e) {
                	Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This Student ID does not exist: " + idTextField.getText());
                    alert.showAndWait();
                }
            }
        });

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(15, 15, 15, 15));
        mainBox.getChildren().addAll(searchStudentLabel, searchBox, searchButton);
        mainBox.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(mainBox);

        enrollmentSearchScene = new Scene(bp, 500, 200);
    }
}

class EnrollmentResultsView {

    UniversityApplication app;
    Scene enrollmentResultsScene;
    Student student;

    private Label idResultLabel;
    private Label nameResultLabel;
    private ComboBox<String> courseComboBox;
    private Label yearLabel;
    private Label semesterLabel;

    public EnrollmentResultsView(UniversityApplication ua) {
        app = ua;
        
        setup();
    }

    public void setStudent(Student s) {
        student = s;

        
    }

    public void setup() {
        Label studentid = new Label("Student ID");
        Label studentname= new Label("Student Name");
        yearLabel = new Label("");
        semesterLabel = new Label("");
        idResultLabel = new Label("");
        nameResultLabel = new Label("");

        HBox idBox = new HBox(25);
        HBox nameBox = new HBox(25);
        idBox.getChildren().addAll(studentid, idResultLabel);
        nameBox.getChildren().addAll(studentname,nameResultLabel);

        Label searchResultLabel = new Label("Search Result");
        VBox leftBox = new VBox(15);
        leftBox.getChildren().addAll(searchResultLabel, idBox, nameBox);

        courseComboBox = new ComboBox<>();
        for (int i = 0; i < app.getUniversity().getCourses().count; ++i) {
            Course course = app.getUniversity().getCourses().get(i);
            courseComboBox.getItems().add(course.getNumber());
        }
        
        if(student != null && student.getEnrollments().size() != 0)
        {
        	courseComboBox.getSelectionModel().select(student.getEnrollments().get(0).getCourse().getNumber());
        	idResultLabel.setText(Integer.toString(student.getStudentID()));
            nameResultLabel.setText(student.getFirstName() + " " + student.getLastName());
            yearLabel.setText(Integer.toString(student.getEnrollments().get(0).getYear()));
        	semesterLabel.setText(student.getEnrollments().get(0).getSemester());
        }
        courseComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String courseNumber = courseComboBox.getValue();
                try {
                    Course course = app.getUniversity().findCourse(courseNumber);
                    boolean flag = true;
                    for(Enrollment en : student.getEnrollments())
                    	if(en.getCourse().getCourseID() == course.getCourseID())
                    	{
                    		flag = false;
                    		yearLabel.setText(Integer.toString(en.getYear()));
                        	semesterLabel.setText(en.getSemester());
                    		break;
                    	}
                    if(flag){
                    	yearLabel.setText("(student didn't enroll to this course");
                    	semesterLabel.setText(")");
                    }
                } catch (Exception e) {
                    System.out.println("Course not found");
                }
            }
        });

        FlowPane courseDetailsPane = new FlowPane();
        courseDetailsPane.getChildren().addAll(leftBox, courseComboBox, yearLabel, semesterLabel);
        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(courseDetailsPane);
        bp.setAlignment(courseDetailsPane, Pos.CENTER);
        enrollmentResultsScene = new Scene(bp, 500, 500);
    }
}

class EnrollmentAddView {

    UniversityApplication app;
    Scene enrollmentAddScene;

    private Button searchButton;
    private TextField idTextField;

    public EnrollmentAddView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        Label studentIDLabel = new Label("Input Student ID");
        idTextField = new TextField();
        idTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchButton.setDisable(idTextField.getText().length() <= 0);
            }
        });
        searchButton = new Button("Search Student");
        searchButton.setDisable(true);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int id = Integer.parseInt(idTextField.getText());
                try {
                    Student student = app.getUniversity().findStudent(id);

                    app.enrollmentAddResultsView.setStudent(student);
                    app.showEnrollmentAddResultsView();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("This Student ID does not exist: " + idTextField.getText());
                    alert.showAndWait();
                }
            }
        });

        HBox searchBox = new HBox(10);
        searchBox.setPadding(new Insets(15, 15, 15, 15));
        searchBox.getChildren().addAll(studentIDLabel, idTextField, searchButton);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(searchBox);
        bp.setAlignment(searchBox, Pos.CENTER);

        enrollmentAddScene = new Scene(bp, 500, 200);
    }
}

class EnrollmentAddResultsView {
    UniversityApplication app;
    Scene enrollmentAddResultsScene;

    private Label studentIDLabel;
    private Label studentNameLabel;
    private ComboBox<String> courses;
    private ComboBox<Integer> years;
    private ComboBox<String> semesters;
    private Student currentStudent;

    public EnrollmentAddResultsView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        studentIDLabel = new Label("ID: ");
        studentNameLabel = new Label("Name: ");

        VBox leftBox = new VBox(10);
        leftBox.setPadding(new Insets(15, 15, 15, 15));
        leftBox.getChildren().addAll(studentIDLabel, studentNameLabel);

        courses = new ComboBox<>();
        for (int i = 0; i < app.getUniversity().getCourses().count; i++) {
            courses.getItems().add(app.getUniversity().getCourses().get(i).getNumber());
        }
        if(app.getUniversity().getCourses().get(0) != null)
        	courses.setValue(app.getUniversity().getCourses().get(0).getNumber());

        years = new ComboBox<>();
        years.getItems().addAll(2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019);
        years.setValue(2019);

        semesters = new ComboBox<>();
        semesters.getItems().addAll("Fall", "Winter", "Spring", "Summer");
        semesters.setValue("Fall");

        FlowPane courseInformationBox = new FlowPane();
        courseInformationBox.getChildren().addAll(courses, years, semesters);
        courseInformationBox.setPadding(new Insets(15, 15, 15, 15));

        Button enrollButton = new Button("Enroll");
        enrollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SingleSelectionModel courseSelectionModel = courses.getSelectionModel();
                int courseIndex = courseSelectionModel.getSelectedIndex();
                Course course = app.getUniversity().getCourses().get(courseIndex);

                Enrollment enrollment = new Enrollment(course, years.getValue(), semesters.getValue(), "Not assigned", currentStudent);
                currentStudent.addEnrollment(enrollment);
                course.addEnrollment(enrollment);
              	app.getUniversity().writeEnrollmentData();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("Enrollment data has been added for student ID " + Integer.toString(currentStudent.getStudentID()));
                alert.showAndWait();
            }
        });
        Button cancelEnrollButton = new Button("Cancel Enroll");
        cancelEnrollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.showEnrollmentAddView();
            }
        });
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(15, 15, 15, 15));
        buttonBox.getChildren().addAll(enrollButton, cancelEnrollButton);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setLeft(leftBox);
        bp.setRight(courseInformationBox);
        bp.setBottom(buttonBox);
        bp.setAlignment(buttonBox, Pos.CENTER);

        enrollmentAddResultsScene = new Scene(bp, 500, 200);
    }

    public void setStudent(Student student) {
        this.currentStudent = student;

        studentIDLabel.setText("ID: " + Integer.toString(student.getStudentID()));
        studentNameLabel.setText("Name: " + student.getFirstName() + " " + student.getLastName());
    }
}

class GenerateReportView {

    UniversityApplication app;
    Scene generateReportScene;

    private ComboBox<String> courses;

    public GenerateReportView(UniversityApplication ua) {
        app = ua;

        setup();
    }

    public void setup() {
        Label inputLabel = new Label("Input course number");

        courses = new ComboBox<>();
        for (int i = 0; i < app.getUniversity().getCourses().count ; i++) {
            courses.getItems().add(app.getUniversity().getCourses().get(i).getNumber());
        }
        if(app.getUniversity().getCourses().get(0) != null)
        	courses.setValue(app.getUniversity().getCourses().get(0).getNumber());

        Button searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SingleSelectionModel courseSelectionModel = courses.getSelectionModel();
                int courseIndex = courseSelectionModel.getSelectedIndex();
                Course course = app.getUniversity().getCourses().get(courseIndex);

                app.reportView.setCourse(course);
                app.showReportView();
            }
        });

        HBox inputBox = new HBox(10);
        inputBox.setPadding(new Insets(15, 15, 15, 15));
        inputBox.getChildren().addAll(inputLabel, courses, searchButton);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(inputBox);
        bp.setAlignment(inputBox, Pos.CENTER);

        generateReportScene = new Scene(bp, 500, 100);
    }
}

class ReportView {

    UniversityApplication app;
    Scene reportScene;

    private Label titleLabel;
    private Text text;

    private Course currentCourse;

    public ReportView(UniversityApplication ua) {
        app = ua;
        text = new Text();
        setup();
    }

    public void setup() {
        titleLabel = new Label("Report for Course: ");

        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(15, 15, 15, 15));
        mainBox.getChildren().addAll(titleLabel, text);

        BorderPane bp = new BorderPane();
        bp.setTop(app.makeMenuPane());
        bp.setCenter(mainBox);

        reportScene = new Scene(bp, 500, 300);
    }

    public void setCourse(Course course) {
        currentCourse = course;
        
        titleLabel.setText("Report for Course: " + course.getNumber());

        String reportString = "StudentID   Student Name   Semester   Grade\n";
        for (Enrollment enrollment : course.getEnrollments()) {
            reportString += Integer.toString(enrollment.getStudent().getStudentID()) + "\t\t";
            reportString += enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName()  + "\t\t";
            reportString += enrollment.getSemester() + "\t\t";
            reportString += enrollment.getGrade() + "\n";
        }
        text.setText(reportString);
    }
}