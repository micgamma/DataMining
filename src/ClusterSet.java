/**
 * Insieme dei cluster ottenuti da una tabella delle transazioni
 */

class ClusterSet {
	
	//Attributi
	/**
	 * Insieme dei cluster
	 */
	private Cluster C[] = new Cluster [0];
	
	//Metodi
	
	/**
	 * Crea un ClusterSet vuoto
	 */
	ClusterSet()
	{
		
	}
	
	/**
	 * Aggiunge un cluster al ClusterSet
	 * @param c cluster da aggiungere
	 */
	void add(Cluster c)
	{
		Cluster tempC[]=new Cluster[C.length+1];
		for(int i=0;i<C.length;i++)
			tempC[i]=C[i];
		tempC[C.length]=c;
		C=tempC;
	}
	
	/**
	 * Restituisce l' i-esimo cluster del ClusterSet
	 * @param i indice del Cluster nel ClusterSet
	 * @return  cluster in posizione i
	 */
	Cluster get(int i)
	{
		return C[i];
	}
	
	/**
	 * Restituisce una stringa fatta dai centroidi di ogni cluster del ClusterSet
	 * @return Stringa che descrive ogni cluster del ClusterSet indicandone il centroide
	 */
	public String toString()
	{
		String result = "";
		for(int i=0; i< C.length; i++)
			result += "C" + i + " = " + C[i].toString() + "\n" ;
		return result;
	}
	
	/**
	 *  Restituisce una stringa  che descriva lo stato di ciascun cluster nel ClusterSet 
	 * @param data Insieme di tutte le transazioni
	 * @return Stringa che descrive ogni cluster del ClusterSet indicandone il centroide
	 * e le transazioni che lo compongono
	 */
	public String toString(Data data )
	{
		String str="";
		for(int i=0;i<C.length;i++)
		{
			if (C[i]!=null)
			{
				str+=i+":"+C[i].toString(data)+"\n";
			}
		}
		return str;
	}
}
