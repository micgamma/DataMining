/**
 *	Rappresenta la generica coppia <Attributo, Valore>
 */
abstract class Item 
{
	//Attributi
	/**Attributo coinvolto nell'item */
	private Attribute attribute;
	/**Valore assegnato all'attributo */
	private Object value;
	
	//Metodi
	/** Crea un nuovo Item con attributo e valore assegnati
	 * 
	 * @param attribute attributo dell' oggetto
	 * @param value valore dell' attributo
	 */
	Item(Attribute attribute, Object value)
	{
		this.attribute = attribute;
		this.value = value;
	}
	
	/** Restituisce l'attributo dell'Item
	 * @return	Attributo che l'Item rappresenta
	 */
	Attribute getAttribute()
	{
		return attribute;
	}
	
	/** Restituisce il valore dell'Item
	 * @return Valore dell'attributo rappresentato dall'Item corrente
	 */
	Object getValue()
	{
		return value;
	}
	
	/** Restistuisce la rappresentazione dell'Item mediante il suo valore
	 * @return Stringa contenente il valore dell'Item
	 */
	public String toString()
	{
		return value.toString();
	}
	
	
	/** Restituisce la distanza tra due Item 
	 *  L'implementazione del metodo astratto differisce
	 *  per item discreto e item continuo
	 * 
	 * @param a item da confrontare
	 * @return Restituisce la distanza tra gli Item confrontati
	 */
	abstract double distance(Object a);

}
