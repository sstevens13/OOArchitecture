package RegistrarSingleton;

import java.util.ArrayList;

public class Registrar {
	
	private static Registrar instance = null;
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	//constructor is private
	//no instances can be created with the new keyword
	private Registrar() { }

	//returns the only existing instance of registrar if it exists
	//else initialize a single instance and return it
	public static Registrar getInstance() {
		if (instance == null) {
			synchronized (Registrar.class) {
				if (instance == null) {
					instance = new Registrar();
				}
			}
		} else {
			System.out.println("Sorry, an instance of registrar already exists");
		}
		return instance;
	}
	
	/*
	 * returns true if course is created
	 * else returns false if course already exists or can't be created
	 * 		due to bad value (courseSize <1 or >500)
	 */
	public boolean createCourse(String courseName, int courseSize) {
		if (courseSize < 1 || courseSize > 500) {
			System.out.println("Error: course is too small or large");
			return false;
		}
		for (Course course : courseList) {
			if (course.toString().equals(courseName)) {
				System.out.println("Error: course already exists");
				return false;
			}
		}
		
		courseList.add(new Course(courseName, courseSize));
		return true;
	}
	
	/*
	 * returns true if student is added to course or student already belongs to course
	 * else returns false
	 */
	public boolean addStudent(String courseName, int studentID) {
		Course course = null;
		for (Course c : courseList) {
			if (c.toString().equals(courseName)) {
				course = c;
			}
		}
		if (course == null) {
			System.out.println("Error: course does not exist");
			return false;
		} else {
			return course.addStudent(studentID);
		}	
	}
	
	public void listCourses() {
		for (Course c : courseList) {
			System.out.println(c.toString());
		}
	}
	
	
}
