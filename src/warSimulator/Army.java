package warSimulator;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Army extends Branch implements Pi, RecommendedAmount
{
	private int numTank = 0;//M1A1 Battle Tank - 6 million
	private int numHelicopter = 0;//UH-60A/L Black Hawk - 10 million
	private int numMRAP = 0;// - 1 million
	private int numGrenadeLauncher = 0;//M320 - $3500
	private int numSquadMG = 0;//M249 machine gun - $4000
	private int numRifle = 0;//M4 carbines - $1,300
	private int numEnlisted = 0;
	private int numLieutenant = 0;
	private int numCaptain = 0;
	private int numMajor = 0;
	private int numColonel = 0;
	private int numGeneral = 0;
	
	
	public Army() {
		super();
	}
	
	public Army(String hardCode) {
		
		if(hardCode.equals("US Army")) 
		{
			setNumTank(6333);
			setNumHelicopter(1200);
			setNumMRAP(11000);
			setNumGrenadeLauncher(5000);
			setNumSquadMG(5000);
			setNumRifle(200000);
			
			setNumEnlisted(387075);
			setNumLieutenant(21269);
			setNumCaptain(28501);
			setNumMajor(15506);
			setNumColonel(4023);
			setNumGeneral(13);
		}
		else if(hardCode.equals("Chinese Army")) 
		{
			//same numbers for now
			setNumTank(10000);
			setNumHelicopter(5000);
			setNumMRAP(10000);
			setNumGrenadeLauncher(5000);
			setNumSquadMG(25000);
			setNumRifle(60000);
			
			setNumEnlisted(80000);
			setNumLieutenant(24000);
			setNumCaptain(4000);
			setNumMajor(300);
			setNumColonel(40);
			setNumGeneral(15);
		}
		else if(hardCode.equals("Russian Army"))
		{
			setNumTank(2000);
			setNumHelicopter(2000);
			setNumMRAP(5000);
			setNumGrenadeLauncher(1000);
			setNumSquadMG(2500);
			setNumRifle(50000);
			
			setNumEnlisted(60000);
			setNumLieutenant(12000);
			setNumCaptain(3000);
			setNumMajor(200);
			setNumColonel(20);
			setNumGeneral(8);
		}
	}
	
	
	public int getNumTank() {
		return numTank;
	}
	
	
	public void setNumTank(int numTank) {
		this.numTank = numTank;
	}
	
	
	public int getNumHelicopter() {
		return numHelicopter;
	}
	
	
	public void setNumHelicopter(int numHelicopter) {
		this.numHelicopter = numHelicopter;
	}
	
	
	public int getNumMRAP() {
		return numMRAP;
	}
	
	
	public void setNumMRAP(int numMRAP) {
		this.numMRAP = numMRAP;
	}
	
	
	public int getNumGrenadeLauncher() {
		return numGrenadeLauncher;
	}
	
	
	public void setNumGrenadeLauncher(int numGrenadeLauncher) {
		this.numGrenadeLauncher = numGrenadeLauncher;
	}
	
	
	public int getNumSquadMG() {
		return numSquadMG;
	}
	
	
	public void setNumSquadMG(int numSquadMG) {
		this.numSquadMG = numSquadMG;
	}
	
	
	public int getNumRifle() {
		return numRifle;
	}
	
	
	public void setNumRifle(int numRifle) {
		this.numRifle = numRifle;
	}
	
	
	public int getNumEnlisted() {
		return numEnlisted;
	}
	
	
	public void setNumEnlisted(int numEnlisted) {
		this.numEnlisted = numEnlisted;
	}
	
	
	public int getNumLieutenant() {
		return numLieutenant;
	}
	
	
	public void setNumLieutenant(int numLieutenant) {
		this.numLieutenant = numLieutenant;
	}
	
	
	public int getNumCaptain() {
		return numCaptain;
	}
	
	
	public void setNumCaptain(int numCaptain) {
		this.numCaptain = numCaptain;
	}
	
	
	public int getNumMajor() {
		return numMajor;
	}
	
	
	public void setNumMajor(int numMajor) {
		this.numMajor = numMajor;
	}
	
	
	public int getNumColonel() {
		return numColonel;
	}
	
	
	public void setNumColonel(int numColonel) {
		this.numColonel = numColonel;
	}
	
	
	public int getNumGeneral() {
		return numGeneral;
	}
	
	
	public void setNumGeneral(int numGeneral) {
		this.numGeneral = numGeneral;
	}
	
/****************************************************************************************/
	/*OTHER METHODS*/
/****************************************************************************************/

	public void purchaseOrHireSomething(Military military, int setterChoice, double price, String name) 
	{
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400,100));
		int userInput = Methods.getInt("How many "+name+" would you like to purchase: ");
		
		if(military.getBalance() - (userInput * price) < 0) {
			JOptionPane.showMessageDialog(null, "You do not have enough money to buy "+userInput+ name);
		}
		else {
			military.setBalance(military.getBalance() - (userInput * price));
			selectRightSetter(setterChoice, userInput);
		}
	}
	
	public void removeOrFireSomething(Military military, int setterChoice, double price, String nameOfItem) 
	{
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
		int	numberOfThingsToSell = Methods.getInt("How many " + nameOfItem + " would you like to remove: ");
		
		switch(setterChoice)
		{
		case 1:
			if(getNumTank() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 2:
			if(getNumHelicopter() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 3:
			if(getNumMRAP() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 4:
			if(getNumGrenadeLauncher() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 5:
			if(getNumSquadMG() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 6:
			if(getNumRifle() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 7:
			if(getNumGeneral() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 8:
			if(getNumColonel() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 9:
			if(getNumMajor() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 10:
			if(getNumCaptain() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 11:
			if(getNumLieutenant() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		case 12:
			if(getNumEnlisted() < numberOfThingsToSell)
			{
				JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
			}
			else 
			{
				military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
				selectRightSetter(setterChoice, -numberOfThingsToSell);
			}
			break;
		}//end of switch
	}//end of removeOrFireSomething
	
	public void selectRightSetter(int setter, int userInput) 
	{
		switch(setter) 
		{
		case 1:
			setNumTank(getNumTank() + userInput);
			break;
		case 2:
			setNumHelicopter(getNumHelicopter() + userInput);
			break;
		case 3:
			setNumMRAP(getNumMRAP() + userInput);
			break;
		case 4:
			setNumGrenadeLauncher(getNumGrenadeLauncher() + userInput);
			break;
		case 5:
			setNumSquadMG(getNumSquadMG() + userInput);
			break;
		case 6:
			setNumRifle(getNumRifle() + userInput);
			break;
		case 7:
			setNumGeneral(getNumGeneral() + userInput);
			break;
		case 8:
			setNumColonel(getNumColonel() + userInput);
			break;
		case 9:
			setNumMajor(getNumMajor() + userInput);
			break;
		case 10:
			setNumCaptain(getNumCaptain() + userInput);
			break;
		case 11:
			setNumLieutenant(getNumLieutenant() + userInput);
			break;
		case 12:
			setNumEnlisted(getNumEnlisted() + userInput);
			break;
		}
	}
	
	@Override
	public double calculatePower() 
	{
		double totalNumberOfSoldiersYouHave = getNumGeneral() + getNumColonel() + getNumMajor() + getNumCaptain() + getNumLieutenant() + getNumEnlisted()
			+ 0.000000000001;

		//calculate the theoretical number of crew that a certain rank can efficiently support based on known US proportions (Western Bias?)
		double generalProportion = getNumGeneral() / totalNumberOfSoldiersYouHave;
		double generalDeviation = (generalProportion - 0.000028) / 0.000028;
		if(generalDeviation > 0)
		{
			generalDeviation = 0;//too many generals will not hurt your score
		}
		double colonelProportion = getNumColonel() / totalNumberOfSoldiersYouHave;
		double colonelDeviation = (colonelProportion - 0.008815) / 0.008815;
		if(colonelDeviation > 0)
		{
			colonelDeviation = 0;//too many colonels will not hurt your score
		}
		double majorProportion = getNumMajor() / totalNumberOfSoldiersYouHave;
		double majorDeviation = (majorProportion - 0.033976) / 0.033976;
		if(majorDeviation > 0)
		{
			majorDeviation = 0;//too many majors will not hurt your score
		}
		double captainProportion = getNumCaptain() / totalNumberOfSoldiersYouHave;
		double captainDeviation = (captainProportion - 0.062449) / 0.062449;
		if(captainDeviation > 0)
		{
			captainDeviation = 0;//too many captains will not hurt your score
		}
		double lieutenantProportion = getNumLieutenant() / totalNumberOfSoldiersYouHave;
		double lieutenantDeviation = (lieutenantProportion - 0.046603) / 0.046603;
		if(lieutenantDeviation > 0)
		{
			lieutenantDeviation = 0;//too many lieutenants will not hurt your score
		}
		double enlistedProportion = getNumEnlisted() / totalNumberOfSoldiersYouHave;
		double enlistedDeviation = (enlistedProportion - 0.848129) / 0.848129;
		if(enlistedDeviation > 0)
		{
			enlistedDeviation = 0;//too many enlisted troops will not hurt your score
		}
		
		double averageDeviation = (generalDeviation + colonelDeviation + majorDeviation + captainDeviation + lieutenantDeviation + enlistedDeviation)/6;
		double averageDeviationWeighted = Math.pow((averageDeviation), 2);
		double crewProportionEfficiency = 1 - ((2/pi) * Math.atan(averageDeviationWeighted));
		
		//calculate the power of the equipment?
		int effectiveMRAPs = 0;
		int effectiveHelicopters = 0;
		int effectiveTanks = 0;
		int effectiveSquadMG = 0;
		int effectiveGrenadeLaunchers = 0;
		int effectiveRifles = 0;
		double numberOfSoldiersLeft = totalNumberOfSoldiersYouHave;
		boolean exit = false;
		while(exit == false)
		{
			if(numberOfSoldiersLeft >= 4 && effectiveTanks < getNumTank())
			{
				effectiveTanks++;
				numberOfSoldiersLeft -= 4;
			}
			if(numberOfSoldiersLeft >= 3 && effectiveHelicopters < getNumHelicopter())
			{
				effectiveHelicopters++;
				numberOfSoldiersLeft -= 3;
			}
			if(numberOfSoldiersLeft >= 2 && effectiveMRAPs < getNumMRAP())
			{
				effectiveMRAPs++;
				numberOfSoldiersLeft -= 2;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveSquadMG < getNumSquadMG())
			{
				effectiveSquadMG++;
				numberOfSoldiersLeft -= 1;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveGrenadeLaunchers < getNumGrenadeLauncher())
			{
				effectiveGrenadeLaunchers++;
				numberOfSoldiersLeft -= 1;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveRifles < getNumRifle())
			{
				effectiveRifles++;
				numberOfSoldiersLeft -= 1;
			}
			else
			{
				exit = true;
			}
		}
		
		/******************************************************************************/
		
		
		//apply the balanced square root algorithm
		double helicopterPower = (1 + Math.pow(effectiveHelicopters, ((double)1/8)) + 0.0001/*cost of equipment in hundreds of billions*/ * effectiveHelicopters);
		double tankPower = (1 + Math.pow(effectiveTanks, ((double)1/9)) + 0.00006 * effectiveTanks);
		double mrapPower= (1 + Math.pow(effectiveMRAPs, ((double)1/11)) + 0.00001 * effectiveMRAPs);
		double assaultRiflePower = (1 + Math.pow(effectiveRifles, ((double)1/24)) + 0.000000013 * effectiveRifles);
		double grenadeLauncherPower = (1 + Math.pow(effectiveGrenadeLaunchers, ((double)1/21)) + 0.000000035 * effectiveGrenadeLaunchers);
		double machineGunPower = (1 + Math.pow(effectiveSquadMG, ((double)1/20)) + 0.00000004 * effectiveSquadMG);
		double armyPower = helicopterPower * tankPower * mrapPower * assaultRiflePower * grenadeLauncherPower * machineGunPower;
		
		//apply the raw power money multiplier algorithm
		armyPower += Math.pow((effectiveHelicopters * 0.05/*cost of equipment in hundreds of millions/2*/ + effectiveTanks * 0.03 + effectiveMRAPs * 0.005
				+ effectiveRifles * 0.0000065 + effectiveGrenadeLaunchers * 0.0000175 + effectiveSquadMG * 0.00002), (double)4/5);
		
		//apply the crew proportion efficiency
		armyPower *= crewProportionEfficiency;
		
		//this is to account for branch-specific equipment variability
		armyPower /= 5;//default minus one bonus
		
		return armyPower;
	}//end of calculatePower()
	
	public int recommendedAmount(String rank)
	{
		int recommendedAmount = 0;
		int totalNumberOfSoldiersNeededToOperateEquipment = getNumMRAP() * 2 + getNumTank() * 4
				+ getNumHelicopter() * 3 + getNumRifle() + getNumGrenadeLauncher() + getNumSquadMG();
		
		if(rank.equals("General"))
		{
			recommendedAmount = (int)(0.000028 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Colonel"))
		{
			recommendedAmount = (int)(0.008815 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Major"))
		{
			recommendedAmount = (int)(0.033976 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Captain"))
		{
			recommendedAmount = (int)(0.062449 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Lieutenant"))
		{
			recommendedAmount = (int)(0.046603 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Enlisted"))
		{
			recommendedAmount = (int)(0.848129 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else
		{
			recommendedAmount = -1;
			System.out.println("Given rank is not recognizable... returning -1");
		}
		return recommendedAmount;
	}//end of recommendedAmount
	public boolean equals(Object obj) 
	{
		if(!(obj instanceof Army)) 
		{
			return false;
		}
		else if(((Army)obj).getNumTank() == this.getNumTank() &&
				((Army)obj).getNumHelicopter() == this.getNumTank() &&
				((Army)obj).getNumMRAP() == this.getNumMRAP() &&
				((Army)obj).getNumGrenadeLauncher() == this.getNumGrenadeLauncher() &&
				((Army)obj).getNumSquadMG() == this.getNumSquadMG() &&
				((Army)obj).getNumRifle() == this.getNumRifle() &&
				((Army)obj).getNumGeneral() == this.getNumGeneral() &&
				((Army)obj).getNumColonel() == this.getNumColonel() &&
				((Army)obj).getNumMajor() == this.getNumMajor() &&
				((Army)obj).getNumCaptain() == this.getNumCaptain() &&
				((Army)obj).getNumLieutenant() == this.getNumLieutenant() &&
				((Army)obj).getNumEnlisted() == this.getNumEnlisted())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}//end of equals method
}//end of army class