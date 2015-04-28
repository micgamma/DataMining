/**
 * Classe rappresentante la generica tupla della matrice delle transazioni
 */
class Tuple 
{
	//Attributi
	/** insieme degli attributi che compongono la tupla	 */
	private Item[] tuple;
	
	//Metodi
	/**
	 * costruisce l' oggetto riferito da tuple
	 * @param size numero di attributi della tupla
	 */
	Tuple(int size)
	{
		tuple = new Item[size];
	}
	
	/**
	 * restituisce la lunghezza della tupla
	 * @return tuple.lenght
	 */
	int getLength()
	{
		return tuple.length;
	}
	
	/**
	 * restituisce lo item in posizione i
	 * @param i indice del vettore di cui restituire l' item
	 * @return Item item restituito in posizione i
	 */
	Item get(int i)
	{
		return tuple[i];
	}
	
	/**
	 * memorizza l' item c in posizione i
	 * @param c item c da memorizzare
	 * @param i posizione del vettore in cui memorizzare l' item c
	 */
	void add(Item c, int i)
	{
		tuple[i] = c;
	}
	
	/**
	 *  determina la distanza tra la tupla riferita da obj e la tupla corrente (riferita da this). 
	 *  La distanza è ottenuta come la somma delle distanze tra gli item in posizioni eguali nelle due tuple
	 * @param obj	seconda tupla
	 * @return	distanza tra le due tuple
	 */
	double getDistance(Tuple obj)
	{
		double distance=0;
		for (int i=0; i < getLength(); i++)
			distance += get(i).distance(obj.get(i));
		
		return distance;
	}
	
	/**
	 * restituisce la media delle distanze tra la tupla corrente
	 * e quelle ottenibili dalle righe della matrice in data aventi indice  in clusteredData
	 * @param data				tabella delle transazioni
	 * @param clusteredData		lista delle posizioni delle tuple con le quali calcolare la distanza con la tupla corrente
	 * @return					media delle distanze tra tupla corrente e lista di tuple
	 */
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
