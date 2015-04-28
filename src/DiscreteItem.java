/**
 * Rappresenta una coppia <Attributo discreto , valore discreto> 
 */
class DiscreteItem extends Item
{
	//Metodi
	
	/** Crea un DiscreteItem con attibuto e valore dati.
	 * 
	 * @param attribute attributo discreto dell' oggetto
	 * @param value valore dell' attributto
	 */
	DiscreteItem(DiscreteAttribute attribute, String value)
	{
		super(attribute, value);
	}
	
	/**
	 * Restituisce la distanza tra due DiscreteItem
	 * @param a Oggetto con cui confrontare l'Item corrente
	 * @return 	Restituisce <b>0</b> se gli oggetti confrontati sono uguali, <b>1</b> altrimenti.
	 */
	double distance(Object a)
	{
		return (getValue().equals(((DiscreteItem)a).getValue()) ? 0.0 : 1.0 );
	}
}
