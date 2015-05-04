package utility;
import java.util.Arrays;

/**
 *	Modella un insieme mediante la realizzazione con array di flag
 */
public class ArraySet {
	
	/** Array di flag */
	private boolean set[];
	
	/** lunghezza dell'array */
	private int size=0;
	
	/** numero di elementi dell'array */
	private int cardinality=0;
	
	/** Crea un ArraySet con 50 elementi e lo inizializza a false. La dimensione massima potrà cambiare 
	 * sfruttando la tecnica del raddoppio */ 
	public ArraySet ()
	{
		set=new boolean[50];
		for(int i=0;i<set.length;i++)
			set[i]=false;
	}
	
	/**
	 * Aggiunge un elemento cambiando il relativo valore booleano nell'array. Nel caso in cui sia stata raggiunta
	 * la dimensione massima, questa viene raddoppiata  
	 * @param i		Elemento dell'ArraySet da inserire cambiando il valore del rispettivo flag a <b>true</b>
	 * @return		Flag che indica se è stata modificata la struttura del set
	 */
	public boolean add(int i){
		if(i>=set.length)
		{
			//enlarge the set
			boolean temp[]=new boolean[set.length*2];
			Arrays.fill(temp,false);
			System.arraycopy(set, 0, temp, 0, set.length);
			set=temp;
		}	
		boolean added=set[i];
		set[i]=true;
		if(i>=size)
			size=i+1;
		if(!added)
			cardinality++;
		return !added;
		
		
	}
	
	/**
	 * Elimina un elemento modificando il relativo valore booleano nell'array
	 * @param i		Indice elemento da eliminare
	 * @return		Flag che indica se l'elemento è stato eliminato o meno
	 */
	public boolean delete(int i){
		if(i<size){
			boolean deleted=set[i];
			set[i]=false;
			if(i==size-1){
				//update size
				int j;
				for(j=size-1;j>=0 && !set[j];j--);
				
				size=j+1;
			}
			if(deleted)
				cardinality--;
			
			return deleted;
		}
		return false;
	}
	
	/**
	 * Restituisce un flag che indica se l'i-esimo elemento è contenuto o meno nell'ArraySet
	 * @param i		indice del valore di verità ricercato
	 * @return		valore di verità dell'elemento in posizione i
	 */
	public boolean get(int i){
		return set[i];
	}
	
	/**
	 * Restituisce il numero di elementi contenuti nell'ArraySet
	 * @return	cardinalità dell'ArraySet
	 */
	public int size (){
		return cardinality;
	}
	
	/**
	 * Restituisce un array di interi contenente le posizioni dell'ArraySet
	 * che contengono un elemento (valore di verita <b>true</b>)
	 * @return Insieme delle posizioni contenti valori di verità <b>true</b>
	 */
	public int[] toArray(){
		int a[]=new int[0];
		for(int i=0;i<size;i++){
			if(get(i)){
				int temp[]=new int[a.length+1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a=temp;
				a[a.length-1]=i;
			}
		}
		return a;
	}
}
