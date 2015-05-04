package data;
/**
 * Modella la tabella delle transazioni
 * fornendo informazioni anche sullo schema della tabella stessa
 */

public class Data {
	
	/** Tabella delle transazioni */
	private Object data [][];      
	
	/** Numero delle transazioni */
	private int numberOfExamples;	
	
	/** Insieme degli attributi della tabella delle transazioni */
	private Attribute explanatorySet[];			
	
	/**
	 * Crea una nuova tabella delle transazioni
	 * @throws EmptyDatasetException 
	 */
	public Data() throws EmptyDatasetException{
		
		data = new Object [14][5];
	
		//Inserimento transazioni nella tabella
		int i=0;
		   //Tupla 1
		   data[i][0]="Sunny"; data[i][1]="Hot"; data[i][2]="High"; data[i][3]="Weak"; data[i][4]="No"; i++;
		   
		   //Tupla 2
		   data[i][0]="Sunny"; data[i][1]="Hot"; data[i][2]="High"; data[i][3]="Strong"; data[i][4]="No"; i++;
		   
		   //Tupla 3
		   data[i][0]="Overcast"; data[i][1]="Hot"; data[i][2]="High"; data[i][3]="Weak"; data[i][4]="Yes"; i++;
		   
		   //Tupla 4
		   data[i][0]="Rain"; data[i][1]="Mild"; data[i][2]="High"; data[i][3]="Weak"; data[i][4]="Yes"; i++;
		   
		   //Tupla 5
		   data[i][0]="Rain"; data[i][1]="Cool"; data[i][2]="Normal"; data[i][3]="Weak"; data[i][4]="Yes"; i++;

		   //Tupla 6
		   data[i][0]="Rain"; data[i][1]="Cool"; data[i][2]="Normal"; data[i][3]="Strong"; data[i][4]="No"; i++;
		
		   //Tupla 7
		   data[i][0]="Overcast"; data[i][1]="Cool"; data[i][2]="Normal"; data[i][3]="Strong"; data[i][4]="Yes"; i++;
		    
		   //Tupla 8
		   data[i][0]="Sunny"; data[i][1]="Mild"; data[i][2]="High"; data[i][3]="Weak"; data[i][4]="No"; i++;
		   
		   //Tupla 9
		   data[i][0]="Sunny"; data[i][1]="Cool"; data[i][2]="Normal"; data[i][3]="Weak"; data[i][4]="Yes"; i++;
		   
		   //Tupla 10
		   data[i][0]="Rain"; data[i][1]="Mild"; data[i][2]="Normal"; data[i][3]="Weak"; data[i][4]="Yes"; i++;
		   
		   //Tupla 11
		   data[i][0]="Sunny"; data[i][1]="Mild"; data[i][2]="Normal"; data[i][3]="Strong"; data[i][4]="Yes"; i++;
		   
		   //Tupla 12
		   data[i][0]="Overcast"; data[i][1]="Mild"; data[i][2]="High"; data[i][3]="Strong"; data[i][4]="Yes"; i++;
		   
		   //Tupla 13
		   data[i][0]="Overcast"; data[i][1]="Hot"; data[i][2]="Normal"; data[i][3]="Weak"; data[i][4]="Yes"; i++;
		   
		   //Tupla 14
		   data[i][0]="Rain"; data[i][1]="Mild"; data[i][2]="High"; data[i][3]="Strong"; data[i][4]="No"; i++;
		  
		   
		 // numberOfExamples
		 numberOfExamples=14;		 
		 
		
		//explanatory Set  
		explanatorySet = new Attribute[5];	
		
		
		//Attributo 1
		String outLookValues[]=new String[3];
		
		//Dominio dell'attributo outlook
		outLookValues[0]="Overcast";
		outLookValues[1]="Rain";
		outLookValues[2]="Sunny";
		
		explanatorySet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
		
		//Attributo 2
		String temperatureValues[]=new String[3];
		
		temperatureValues[0]="Hot";
		temperatureValues[1]="Mild";
		temperatureValues[2]="Cool";
		
		explanatorySet[1] = new DiscreteAttribute("Temperature",1, temperatureValues);
		
		//Attributo 3
		String humidityValues[]=new String[2];
		
		humidityValues[0]="High";
		humidityValues[1]="Normal";
		
		explanatorySet[2] = new DiscreteAttribute("Humidity",2, humidityValues);
		
		//Attributo 4
		String windValues[]=new String[2];
				
		windValues[0]="Weak";
		windValues[1]="Strong";
				
		explanatorySet[3] = new DiscreteAttribute("Wind",3, windValues);
		
		//Attributo 5
		String playTennisValues[]=new String[2];
						
		playTennisValues[0]="Yes";
		playTennisValues[1]="No";
						
		explanatorySet[4] = new DiscreteAttribute("PlayTennis",4, playTennisValues);
		
		if(getNumberOfExamples()==0)
			throw new EmptyDatasetException("Empty Dataset!");
	}
	
	
	/** Restituisce il numero di transazioni presenti nella tabella delle transazioni
	 * @return		Numero di transazioni all'interno della tabella
	 * */
	public int getNumberOfExamples()
	{
		return numberOfExamples;
	}
	
	/**Restituisce il numero di attributi della transazione 
	 * @return		numero di attributi di cui si compone la transazione
	 * */
	public int getNumberOfExplanatoryAttributes()
	{
		return explanatorySet.length;
	}
	
	
	/**Restituisce il valore di un attributo di una data transazione
	 * @param exampleIndex			indice della transazione 
	 * @param attributeIndex		indice dell'attributo della transazione
	 * @return						valore dell'attributo cercato nella transazione
	 * */
	public Object getAttributeValue(int exampleIndex, int attributeIndex)
	{
		return data[exampleIndex][attributeIndex];
	}
	
	/** Restituisce lo schema della tabella delle transazioni, quindi l'insieme di attributi che compongono
	 *  una generica transazione 
	 * @return 		insieme degli attributi della generica transazione con i relativi domini
	 * */
	Attribute[] getAttributeSchema()
	{
		return explanatorySet;
	}
	
	/** Restituisce la tabella delle transazioni indicando gli attributi e i valori che questi assumono in ogni transazione 
	 * @return Stringa rappresentante l'intera tabella delle transazioni
	 * */
	public String toString()
	{
		String result = "";
		Attribute attributes[]=getAttributeSchema();
		
		for(int i=0; i<getNumberOfExplanatoryAttributes(); i++)
			result = result + attributes[i]+" ,";
		
		result += "\n";
	
		for(int i=0; i<getNumberOfExamples(); i++)
		{
			result += (i+1) + " : ";
			for(int j=0; j<getNumberOfExplanatoryAttributes(); j++)
				result += getAttributeValue(i,j) + " , ";
			
			result += "\n";
		}
		
		return result;
	}
	
	/**
	 * Restituisce una riga della tabella delle transazioni sotto forma di tupla
	 * @param index indice della riga da restituire
	 * @return Tupla contenente i dati della transazione richiesta
	 */
	public Tuple getItemSet(int index)
	{
		Tuple tuple=new Tuple(explanatorySet.length);
		for(int i=0;i<explanatorySet.length;i++)
			tuple.add(new DiscreteItem((DiscreteAttribute)explanatorySet[i], (String)data[index][i]),i);
		return tuple;
	}

}
