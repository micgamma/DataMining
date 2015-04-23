class ContinuousAttribute extends Attribute
{
	//Attributi
	private double min;
	private double max;
	
	//Metodi
	ContinuousAttribute(String name , int index , double min , double max)
	{
		super(name,index);
		this.min=min;
		this.max=max;
	}
	
	double getScaledValue(double v)
	{
		return (v-min)/(max-min);
	}
}
