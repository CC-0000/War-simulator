package warSimulator;

public class Military 
{
	private String name;
	private double balance;//one trillion default?
	private Navy navy;
	private Airforce airforce;
	private Army army;
	private Marines marines;

	public Military(String name, double balance, Navy navy, Airforce airforce, Army army, Marines marines) 
	{
		super();
		setName(name);
		setBalance(balance);
		setNavy(navy);
		setAirforce(airforce);
		setArmy(army);
		setMarines(marines);
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Navy getNavy() 
	{
		return navy;
	}

	public void setNavy(Navy navy) 
	{
		this.navy = navy;
	}

	public Marines getMarines() 
	{
		return marines;
	}

	public void setMarines(Marines marines) 
	{
		this.marines = marines;
	}
	
	public Airforce getAirforce() {
		return airforce;
	}

	public void setAirforce(Airforce airforce) {
		this.airforce = airforce;
	}

	public Army getArmy() {
		return army;
	}

	public void setArmy(Army army) {
		this.army = army;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	
	public int calculatePower()
	{
		return 0;
	}
}
