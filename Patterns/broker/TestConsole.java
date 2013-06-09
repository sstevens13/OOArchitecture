package broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestConsole {
	private static ServerProxy serverProxy = new ServerProxy("Lab 2 Server");
	private static ClientProxy clientProxy = new ClientProxy("client");
	
	public static void main(String[] args) throws IOException {
		boolean exitConsole = false;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(!exitConsole) {
			System.out.println("Enter numerical choice: \n" +
					"  1. specify server \n" +
					"  2. change server \n" +
					"  3. add two integers \n" +
					"  4. measure the length of a string \n" +
					"  5. exit");
			String key = input.readLine();
			
			switch (key) {
			case "1":
				System.out.println("Specify server to run methods (suggested server: \"Lab 2 Server\" - no quotes): ");
				String serverName = input.readLine();
				clientProxy.setServer(serverName);
				break;
			case "2":
				System.out.println("Enter first value: ");
				String value = input.readLine().trim();
				int val1, val2;
				try {
					if (isInteger(value)) {
						val1 = Integer.valueOf(value);
					} else {
						System.out.println("Not an integer!");
						break;
					}
					System.out.println("Enter second value: ");
					value = input.readLine().trim();
					if (isInteger(value)) {
						val2 = Integer.valueOf(value);
						int sum = val1 + val2; 
						System.out.println("RETURN VALUE SHOULD BE: " + sum);
						clientProxy.addIntegers(val1, val2);
					} else {
						System.out.println("Not an integer!");
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Integer is out of bounds");
				}
				break;
			case "3":
				System.out.println("Enter string: ");
				String str = input.readLine();
				System.out.println("RETURN VALUE SHOULD BE: " + str.length());
				clientProxy.getLength(str);
				break;
			case "4":
				System.out.println("Goodbye");
				exitConsole = true;
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
			
		}
		
	}
	
	private static boolean isInteger(String str) {
		if (str.matches("^-?\\d+$")) {
			return true;
		} else {
			return false;
		}
	}
	
}
