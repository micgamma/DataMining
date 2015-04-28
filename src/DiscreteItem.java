/**
 *	Classe che estende la classe Item 
 *	e rappresenta una coppia <Attributo discreto , valore discreto> 
 */
class DiscreteItem extends Item
{
	//Metodi
	
	/** invoca il costruttore della classe madre
	 * 
	 * @param attribute attributo discreto dell' oggetto
	 * @param value valore dell' attributto
	 */
	DiscreteItem(DiscreteAttribute attribute, String value)
	{
		super(attribute, value);
	}
	
	/**
	 * restituisce 0 se l' oggetto a  e quello corrente sono uguali
	 * restituisce 1 altrimenti
	 * 
	 * @param a oggetto passato su cui eseguire il confronto con l' oggetto corrente
	 * @return distance
	 */
	double distance(Object a)
	{
		return (getValue().equals(((DiscreteItem)a).getValue()) ? 0.0 : 1.0 );
	}
}
