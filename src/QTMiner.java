
class QTMiner 
{
	//Attributi
	private ClusterSet C;
	private double radius;
	
	//Metodi
	
	QTMiner(double radius)
	{
		C = new ClusterSet();
		this.radius = radius;
	}
	
	ClusterSet getC()
	{
		return C;
	}
	
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
	
	Cluster buildCandidateCluster(Data data, boolean isClustered[])
	{
		// Creazione cluster con tupla vuota come centroide
		Cluster finalCluster = new Cluster(new Tuple(data.getNumberOfExplanatoryAttributes()));
		//System.out.println(data.getNumberOfExamples());
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
