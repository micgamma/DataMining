/** Rappresenta un attributo continuo, quindi con dominio infinito. 
 * Tale classe include i metodi per la “normalizzazione” del dominio dell'attributo nell'intervallo [0,1]
 *  al fine da rendere confrontabili attributi aventi domini diversi
 */
class ContinuousAttribute extends Attribute
{
	//Attributi
	
	/** Estremo inferiore del dominio */
	private double min;
	
	/** Estremo superiore del dominio */
	private double max;
	
	//Metodi
	
	/** Crea un attributo continuo, indicandone nome, indice ed estremi del dominio
	 * 
	 * @param name			nome dell'attributo continuo
	 * @param index			indice dell'attributo continuo
	 * @param min			estremo inferiore del dominio
	 * @param max			estremo superiore del dominio
	 */
	ContinuousAttribute(String name , int index , double min , double max)
	{
		super(name,index);
		this.min=min;
		this.max=max;
	}
	
	/** Restituisce il valore in input normalizzato
	 * 
	 * @param v		valore dell'attributo da normalizzare	
	 * @return		valore normalizzato
	 */
	double getScaledValue(double v)
	{
		return (v-min)/(max-min);
	}

}
