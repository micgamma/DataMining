package mining;
import utility.ArraySet;
import data.Data;
import data.Tuple;

/**
 * Classe che modella un cluster, un insieme di transazioni aventi 
 * distanza da un centroide al più uguale ad un raggio predefinito.
 */
class Cluster {
	/**
	 * Centroide, ovvero quella transazione che rappresenta il cluster */
	private Tuple centroid;
	/**
	 * ArraySet utilizzato per indicare la composizione del cluster*/
	private ArraySet clusteredData; 
	
	/*Cluster(){
		
	}*/
	
	/**
	 * Crea un cluster vuoto con centroide fornito
	 * @param centroid Centroide del cluster
	 */
	Cluster(Tuple centroid){
		this.centroid=centroid;
		clusteredData=new ArraySet();
		
	}
		
	/**
	 * Restituisce il centroide del cluster
	 * @return centroide del cluster
	 */
	Tuple getCentroid(){
		return centroid;
	}
	
	/**
	 * Aggiunge una transazione identificata tramite un ID al cluster
	 * @param id ID identificatore della transazione
	 * @return Restituisce <b>true</b> se è stata modificata la struttura del cluster, <b>false</b> altrimenti 
	 */
	boolean addData(int id){
		return clusteredData.add(id);
		
	}
	
	/**
	 * Verifica se una transazione è clusterizzata nel cluster corrente
	 * @param id ID della transazione
	 * @return Restituisce <b>true</b> se la transazione è clusterizzata nel cluster corrente, <b>false</b> altrimenti
	 */
	boolean contain(int id){
		return clusteredData.get(id);
	}
	
	/**
	 * Rimuove una transazione presente nel cluster 
	 * @param id ID della transazione
	 */
	void removeTuple(int id){
		clusteredData.delete(id);
		
	}
	
	/**
	 * Restituisce il numero di transazioni nel cluster corrente
	 * @return Numero di transazioni nel cluster
	 */
	int getSize(){
		return clusteredData.size();
	}
	
	/**
	 * Restituisce l' insieme degli ID delle transazioni clusterizzate nel cluster corrente
	 * @return insieme degli ID delle transazioni clusterizzate
	 */
	int[] iterator(){
		return clusteredData.toArray();
	}
	
	/**
	 *  Restituisce una stringa che rappresenta il cluster indicandone solo il centroide
	 * @return Stringa che rappresenta il centroide
	 */
	public String toString(){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i);
		str+=")";
		return str;
	}
	
	


	/**
	 *  Restituisce una stringa che descriva lo stato del cluster corrente
	 *  indicando il centroide ed elencado le transazioni clusterizzate al suo interno
	 * @param data Insieme di tutte le transazioni
	 * @return	Stringa che contiene il centroide del cluster e le sue transazioni clusterizzate
	 */
	public String toString(Data data){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i)+ " ";
		str+=")\nExamples:\n";
		int array[]=clusteredData.toArray();
		for(int i=0;i<array.length;i++){
			str+="[";
			for(int j=0;j<data.getNumberOfExplanatoryAttributes();j++)
				str+=data.getAttributeValue(array[i], j)+" ";
			str+="] dist="+getCentroid().getDistance(data.getItemSet(array[i]))+"\n";
			
		}
		str+="\nAvgDistance="+getCentroid().avgDistance(data, array);
		return str;
		
	}

}
