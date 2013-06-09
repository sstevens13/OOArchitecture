package RegistrarSingleton;

public class Course {

	private String courseName;
	private int[] studentIDs;
	
	// initializes a course with a size limit
	protected Course(String courseName, int courseSize) {
		this.courseName = courseName;
		studentIDs = new int[courseSize];
	}
	
	/*
	 *  adds student if there is an empty spot (0 value)
	 *  returns true if student is added or already belongs to the course
	 *  else returns false
	 *  studentID must be positive ints
	 */
	protected boolean addStudent(int studentID) {
		if (studentID < 1) {
			System.out.println("Error: studentID is a bad value");
			return false;
		}
		if (registered(studentID)) return true;
		for (int i = 0; i < studentIDs.length; i++) {
			if (studentIDs[i] == 0) {
				studentIDs[i] = studentID;
				return true;
			}
		}
		System.out.println("Error: there is no more room in the course");
		return false;
	}
	
	/*
	 * removes student from course if student is currently registered for course
	 * and returns true
	 */
	protected boolean dropStudent(int studentID) {
		for (int i = 0; i < studentIDs.length; i++) {
			if (studentIDs[i] == studentID) {
				studentIDs[i] = 0;
				return true;
			}
		}
		System.out.println("Can't drop, student is not in this course");
		return false; 
	}
	
	/*
	 * returns true if student registered for course
	 */
	protected boolean registered(int studentID) {
		for (int i = 0; i < studentIDs.length; i++) {
			if (studentIDs[i] == studentID) {
				System.out.println("Student is already registered for this course");
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return courseName;
	}
	
}
