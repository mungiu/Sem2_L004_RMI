package Shared.JewelStory;

public class TheJewel
{
	private String name;
	private int valueInDollars;

	public TheJewel(String name, int valueInDollars)
	{
		this.name = name;
		this.valueInDollars = valueInDollars;
	}

	public String getName()
	{
		return name;
	}

	public int getDollarValue()
	{
		return valueInDollars;
	}
}
