package data;
/**
 * Rappresenta la generica transazione della matrice delle transazioni
 */
public class Tuple 
{
	//Attributi
	/** Insieme degli attributi che compongono la transazione	 */
	private Item[] tuple;
	
	//Metodi
	/** Crea una nuova transazione con numero di attributi dati in input
	 *  @param size numero di attributi della transazione
	 */
	public Tuple(int size)
	{
		tuple = new Item[size];
	}
	
	/** Restituisce la lunghezza della transazione
	 *  @return numero di attributi che compongono lo schema della transazione
	 */
	public int getLength()
	{
		return tuple.length;
	}
	
	/**
	 * Restituisce l'i-esimo Item dello schema della transazione
	 * @param i Indice dell'Item all'interno dello schema della transazione
	 * @return I-esimo Item della transazione
	 */
	public Item get(int i)
	{
		return tuple[i];
	}
	
	/**
	 * Aggiunge un Item allo schema della transazione
	 * @param c Item da memorizzare
	 * @param i Posizione dello schema in cui memorizzare il nuovo Item
	 */
	void add(Item c, int i)
	{
		tuple[i] = c;
	}
	
	/**
	 *  Determina la distanza tra la transazione riferita da obj e la transazione corrente (riferita da this). 
	 *  La distanza è ottenuta come la somma delle distanze tra gli item in posizioni uguali nelle due transazioni
	 * @param obj	seconda transazione
	 * @return distanza tra le due transazioni
	 */
	public double getDistance(Tuple obj)
	{
		double distance=0;
		for (int i=0; i < getLength(); i++)
			distance += get(i).distance(obj.get(i));
		
		return distance;
	}
	
	/**
	 * Restituisce la media delle distanze tra la transazione corrente e quelle ottenibili dalle righe 
	 * della matrice in <b>data</b> aventi indice in <b>clusteredData</b>
	 * @param data				tabella delle transazioni
	 * @param clusteredData		lista delle posizioni delle transazioni con le quali calcolare la distanza 
	 * 							con la transazione corrente
	 * @return					Media delle distanze tra transazione corrente e lista di tuple
	 */
	public double avgDistance(Data data, int clusteredData[])
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
