/**
 * Classe che si occupa dell'implementazione dell'algoritmo di DataMining
 */
class QTMiner 
{
	//Attributi
	/** 
	 * Insieme dei cluster individuati dall'algoritmo  
	 */
	private ClusterSet C;
	/**
	 * Raggio per la definizione dei cluster, viene utilizzato per aggiungere transazioni ad un
	 * cluster. Se la distanza tra una transazione e il centroide di un cluster è al più uguale al
	 * raggio, questa viene clusterizzata.
	 */
	private double radius;
	
	//Metodi
	/**
	 * Costruttore, setta il raggio per l'algoritmo del DataMining
	 * @param radius raggio per la clusterizzazione
	 */
	QTMiner(double radius)
	{
		C = new ClusterSet();
		this.radius = radius;
	}
	
	/**
	 * Restituisce l'insieme dei cluster individuati dall'algoritmo
	 * @return Insieme dei cluster individuati 
	 */
	ClusterSet getC()
	{
		return C;
	}
	
	/**
	 * Implementazione dell'algoritmo del DataMining.
	 * Costruisce un cluster per ciascuna transazione non ancora clusterizzata, 
	 * includendo nel cluster le transazioni non ancora clusterizzate 
	 * che ricadano nel vicinato sferico del centroide del cluster avente un certo raggio
	 * Salva il cluster candidato più popoloso e rimuove tutte le transazioni di tale cluster 
	 * dall'elenco delle transazioni ancora da clusterizzare 
	 * Ripete l'operazione finchè ci sono ancora transazioni da clusterizzare
	 * @param data Insieme delle transazioni da analizzare
	 * @return Numero di cluster individuati
	 */
	int compute(Data data)
	{ 
			int numclusters=0;
			boolean isClustered[]=new boolean[data.getNumberOfExamples()];
			for(int i=0;i<isClustered.length;i++)
			isClustered[i]=false;
			int countClustered=0;
			while(countClustered != data.getNumberOfExamples())
			{
				//Ricerca cluster più popoloso
				Cluster c = buildCandidateCluster(data, isClustered);
				C.add(c); 
				numclusters++;
				//Rimuovo tuple clusterizzate da dataset
				int clusteredTupleId[]=c.iterator();
				for(int i=0;i<clusteredTupleId.length;i++)
				{
					isClustered[clusteredTupleId[i]]=true;
				}
				countClustered += c.getSize();
			}
			return numclusters;
	}
	/**
	 * Individua il cluster candidato più popoloso definibile con le transazioni non ancora
	 * clusterizzate.
	 * @param data Insieme delle transazioni da analizzare
	 * @param isClustered Array di flag le cui posizioni sono associate ad ogni transazione, che indicano se una transazione
	 * è clusterizzata o meno
	 * @return Cluster candidato più popoloso
	 */
	Cluster buildCandidateCluster(Data data, boolean isClustered[])
	{
		// Creazione cluster con tupla vuota come centroide
		Cluster finalCluster = new Cluster(new Tuple(data.getNumberOfExplanatoryAttributes()));
		for(int i=0; i < data.getNumberOfExamples();i++)
		{
			if(isClustered[i]== false)
			{
				Tuple t = data.getItemSet(i);
				Cluster newC = new Cluster(t);
				for(int j = 0; j < data.getNumberOfExamples(); j++)
				{
					if(isClustered[j] == false)
					{
						Tuple temporary = data.getItemSet(j);
						if(newC.getCentroid().getDistance(temporary) <= radius)
						{
							newC.addData(j);
						}
					}
				}
				
				if(newC.getSize() > finalCluster.getSize())
					finalCluster = newC;
			}
		}
		return finalCluster;
	}
	
	
 }
