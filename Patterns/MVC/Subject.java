package MVC;

public interface Subject {
	public void attachObserver(Observer observer);

    public void detachObserver(Observer observer);

    public void notifyObservers();
}
