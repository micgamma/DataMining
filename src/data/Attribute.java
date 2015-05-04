package data;
/** Modella il generico attributo di una transazione */
abstract class Attribute 
{
	//Attributi
	
	/** Nome dell'attributo */
	protected String name;
	
	/** Indice dell'attributo */
	protected int index;
	
	//Metodi
	
	/** Costruisce un attributo con nome e indice indicati
	 * 
	 * @param name			nome dell'attributo
	 * @param index			indice dell'attributo
	 */
	Attribute(String name, int index)
	{
		this.name=name;
		this.index=index;
	}
	
	/** Restituisce il nome dell'attributo 
	 * 
	 * @return		Nome dell'attributo
	 */
	String getName()
	{
		return name;
	}
	
	/** Restituisce l'indice dell'attributo
	 * 
	 * @return		Indice dell'attributo
	 */
	int getIndex()
	{
		return index;
	}
	
	/** 
	 * Restituisce una stringa che rappresenta l'attributo contenente il nome dell'attributo stesso
	 * @return Stringa contenente il nome dell'attributo
	 */
	public String toString()
	{
		return name;
	}
	
}
