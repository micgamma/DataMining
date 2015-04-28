import java.util.Arrays;

/**
 *	Modella un insieme mediante la realizzazione con array di flag
 */
class ArraySet {
	
	/** Array di flag */
	private boolean set[];
	
	/** lunghezza dell'array */
	private int size=0;
	
	/** numero di elementi dell'array */
	private int cardinality=0;
	
	/** Crea un ArraySet con 50 elementi e lo inizializza a false. La dimensione massima potrà cambiare 
	 * sfruttando la tecnica del raddoppio */ 
	ArraySet ()
	{
		set=new boolean[50];
		for(int i=0;i<set.length;i++)
			set[i]=false;
	}
	
	/**
	 * Aggiunge un elemento cambiando il relativo valore booleano nell'array. Nel caso in cui sia stata raggiunta
	 * la dimensione massima, questa viene raddoppiata  
	 * @param i		elemento dell'ArraySet da inserire cambiando il valore del rispettivo flag a <b>true</b>
	 * @return		booleano che indica se è stata modificata la struttura del set
	 */
	boolean add(int i){
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
	 * Elimina un elemento modificando il relativo valore booleano nell' array
	 * @param i		indice elemento da eliminare
	 * @return		booleano che indica se l'elemento è stato eliminato o meno
	 */
	boolean delete(int i){
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
	 * Ritorna il valore di verità in una certa posizione dell' array
	 * @param i		indice del valore di verità ricercato
	 * @return		valore di verità dell'elemento in posizione i
	 */
	boolean get(int i){
		return set[i];
	}
	
	/**
	 * Ritorna la cardinalità dell' array
	 * @return	cardinalità dell' array
	 */
	int size (){
		return cardinality;
	}
	
	/**
	 * Ritorna un array di interi contenente gli indici dell'array set
	 * che hanno valore di verità vero
	 * @return	array delle posizioni vere
	 */
	int[] toArray(){
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
