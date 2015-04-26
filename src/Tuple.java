
class Tuple 
{
	//Attributi
	private Item[] tuple;
	
	//Metodi
	Tuple(int size)
	{
		tuple = new Item[size];
	}
	
	int getLength()
	{
		return tuple.length;
	}
	
	Item get(int i)
	{
		return tuple[i];
	}
	
	void add(Item c, int i)
	{
		tuple[i] = c;
	}
	
	double getDistance(Tuple obj)
	{
		double distance=0;
		for (int i=0; i < getLength(); i++)
			distance += get(i).distance(obj.get(i));
		
		return distance;
	}
	
	double avgDistance(Data data, int clusteredData[])
	{
		double p=0.0,sumD=0.0;
		for(int i=0;i<clusteredData.length;i++)
		{
			double d= getDistance(data.getItemSet(clusteredData[i]));
			sumD+=d;
		}
		p=sumD/clusteredData.length;
		return p;
	}
}
