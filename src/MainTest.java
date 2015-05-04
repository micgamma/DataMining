import keyboardinput.Keyboard;
import mining.ClusteringRadiusException;
import mining.QTMiner;
import data.Data;
import data.EmptyDatasetException;


public class MainTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try
		{
			Data data = new Data();
			System.out.println(data);
			
			double radius;
			char choose;
			
			do
			{
				//Prende in input il raggio
				do
				{
					System.out.print("Insert radius (>0) = ");
					radius = Keyboard.readDouble();
				} while(radius<=0);
				
				//Esecuzione programma
				QTMiner qt=new QTMiner(radius);
				try
				{
					int numIter=qt.compute(data);
					System.out.println("Number of clusters:"+numIter);
					System.out.println(qt.getC().toString(data));
				}
				catch (ClusteringRadiusException e)
				{
					System.out.println(e.getMessage());
				}
				
				//Prende in input la scelta di fare una nuova esecuzione
				System.out.print("New Execution ? (y/n) : ");
				choose = Keyboard.readChar();
				
			}while(choose=='y' || choose=='Y');
			
		}
		catch(EmptyDatasetException e)
		{
			System.out.println(e.getMessage());
		}
		
	}		

}
