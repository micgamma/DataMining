/** Classe che modella gli attributi della transazione */
abstract class Attribute 
{
	//Attributi
	
	/** Nome dell'attributo */
	protected String name;
	
	/** Indice dell'attributo */
	protected int index;
	
	//Metodi
	
	/** Costruttore dell'attributo , inizializza i parametri dell'attributo
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
	 * @return		nome dell'attributo
	 */
	String getName()
	{
		return name;
	}
	
	/** Restituisce l'indice dell'attributo
	 * 
	 * @return		indice dell'attributo
	 */
	int getIndex()
	{
		return index;
	}
	
	/** 
	 * 
	 */
	public String toString()
	{
		return name;
	}
	
}
