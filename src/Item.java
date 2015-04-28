/**
 *	Classe astratta che modella un generico Item <attributo,valore> 
 */
abstract class Item 
{
	//Attributi
	/**attributo coinvolto nell'item */
	private Attribute attribute;
	/**valore assegnato all'attributo */
	private Object value;
	
	//Metodi
	/** inizializza i valori dei membri attributi 
	 * 
	 * @param attribute attributo dell' oggetto
	 * @param value valore dell' attributo
	 */
	Item(Attribute attribute, Object value)
	{
		this.attribute = attribute;
		this.value = value;
	}
	
	/**   restituisce  l' attributo
	 * 
	 * @return	attribute
	 */
	Attribute getAttribute()
	{
		return attribute;
	}
	
	/** restituisce value
	 * 
	 * @return value
	 */
	Object getValue()
	{
		return value;
	}
	
	/** restituisce la stringa che rappresenta l' oggetto 
	 * @return value
	 */
	public String toString()
	{
		return value.toString();
	}
	
	
	/** L'implementazione del metodo astratto differisce
	 * per item discreto e item continuo
	 * 
	 * @param a item da confrontare
	 * @return distance restituisce la distanza
	 */
	abstract double distance(Object a);

}
