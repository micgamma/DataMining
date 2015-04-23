public class Data {
	private Object data [][];        			//Ogni riga della matrice è una transazione
	private int numberOfExamples;				//Numero di righe in data
	private Attribute explanatorySet[];			//Aggregazione
	
	Data(){
		
		//data
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
	}
	
	int getNumberOfExamples()
	{
		return numberOfExamples;
	}
	
	int getNumberOfExplanatoryAttributes()
	{
		return explanatorySet.length;
	}	
	
	Object getAttributeValue(int exampleIndex, int attributeIndex)
	{
		return data[exampleIndex][attributeIndex];
	}
	
	Attribute[] getAttributeSchema()
	{
		return explanatorySet;
	}
	
	
	public String toString()
	{
		String result = "";
		Attribute attributes[]=getAttributeSchema();
		
		for(int i=0; i<getNumberOfExplanatoryAttributes(); i++)
			result = result + attributes[i]+" ,";
		
		result += "\n";
	
		for(int i=0; i<getNumberOfExamples(); i++)
		{
			result += (i +1) + " : ";
			for(int j=0; j<getNumberOfExplanatoryAttributes(); j++)
				result += getAttributeValue(i,j) + " , ";
			
			result += "\n";
		}
		
		return result;
	}

	public static void main(String args[]){
		Data trainingSet=new Data();
		System.out.println(trainingSet);
	}
}
