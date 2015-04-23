
abstract class Attribute 
{
	//Attributi
	
	protected String name;
	protected int index;
	
	//Metodi
	
	Attribute(String name, int index)
	{
		this.name=name;
		this.index=index;
	}
	
	String getName()
	{
		return name;
	}
	
	int getIndex()
	{
		return index;
	}
	
	public String toString()
	{
		return name;
	}
	
}
