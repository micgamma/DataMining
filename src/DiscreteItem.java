
class DiscreteItem extends Item
{
	//Metodi
	DiscreteItem(DiscreteAttribute attribute, String value)
	{
		super(attribute, value);
	}
	
	double distance(Object a)
	{
		return (getValue().equals(((DiscreteItem)a).getValue()) ? 0.0 : 1.0 );
	}
}
