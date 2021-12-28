package warSimulator;

public abstract class Branch 
{
	public abstract double calculatePower(); 
	public abstract void purchaseOrHireSomething(Military military, int setterChoice, double price, String nameOfItem);
	public abstract void selectRightSetter(int setter, int userInput);
}
