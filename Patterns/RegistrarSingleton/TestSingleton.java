package RegistrarSingleton;

public class TestSingleton {

	public static void main(String args[]) {
		System.out.println("Initializing Registrar");

		Registrar registrar1 = Registrar.getInstance();
		System.out.println("registrar1 is an instance of Registrar\n");
		
		System.out.println("trying to get a second instance of registrar and assign to registrar2.");
		Registrar registrar2 = Registrar.getInstance();
		System.out.println("registrar2 is an instance of Registrar\n");
		
		registrar1.createCourse("CS101", 5);
		registrar2.createCourse("English101", 5);		
		System.out.println("CS101 has been initialized using registrar1 \n" +
				"and English201 has been initialized using registrar2 \n" +
				"both have a capacity of 5 students");
		for (int i = 101; i < 105; i++) {
			registrar1.addStudent("CS101", i);
		}
		for (int i = 101; i < 105; i++) {
			registrar2.addStudent("English101", i);
		}
		System.out.println("Both Courses have 4 spots filled with studentID 101-104 \n");
		
		System.out.println("Trying to create course with same name (CS101) as one created by registrar1 using registrar2");
		registrar2.createCourse("CS101", 10);
		System.out.println();
		System.out.println("Using registrar2 to fill CS101 (plus trying to add an extra student)");
		for (int i = 105; i < 107; i++) {
			registrar2.addStudent("CS101", i);
		}
		System.out.println();
		
		System.out.println("Trying to create course with same name (English101) as one created by registrar2 using registrar1");
		registrar1.createCourse("English101", 10);
		System.out.println();
		System.out.println("Using registrar1 to fill English101 (plus trying to add an extra student)");
		for (int i = 105; i < 107; i++) {
			registrar1.addStudent("English101", i);
		}
		System.out.println();
		
		System.out.println("Comparing registrar1's value to registrar2's value.");
		if (registrar1 == registrar2) {
			System.out.println("Registrar is a singleton. registrar1 equals registrar2");
		} else {
			System.out.println("Registrar is not a singleton");
		}

	}


}
