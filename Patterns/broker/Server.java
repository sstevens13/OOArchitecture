package broker;

public class Server {
		
	public int addIntegers(int val1, int val2) {
		ServantSumIntegers servant = new ServantSumIntegers();
		return servant.addIntegers(val1, val2);
	}
	
	public int getLength(String str) {
		ServantStringLength servant = new ServantStringLength();
		return servant.getLength(str);
	}
	
}



