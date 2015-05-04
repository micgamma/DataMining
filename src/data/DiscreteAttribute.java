package data;
/** Rappresenta un attributo discreto, quindi con dominio finito
 */
class DiscreteAttribute extends Attribute
{
	//Attributi
	
	/** Dominio dell'attributo discreto */
	private String values[];
	
	//Metodi
	
	/** Crea un attributo discreto, con nome, indice e dominio assegnato
	 * 
	 * @param name			nome dell'attributo discreto
	 * @param index			indice dell'attributo discreto
	 * @param values		dominio dell'attributo discreto
	 */
	DiscreteAttribute(String name,int index,String[] values)
	{
		super(name,index);
		this.values=values;	
	}
	
	/** Restituisce il numero dei possibili valori del dominio dell'attributo discreto
	 * 
	 * @return		cardinalità del dominio
	 */
	int getNumberOfDistinctValues()
	{
		return values.length;
	}
	
	/** Restituisce l'i-esimo valore del dominio 
	 * 
	 * @param i			indice del valore del dominio
	 * @return			i-esimo valore del dominio
	 */
	String getValue(int i)
	{
		return values[i];
	}
	
}
