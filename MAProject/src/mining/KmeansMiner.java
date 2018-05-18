<<<<<<< HEAD

package mining;

import data.Data;
import data.OutOfRangeSampleSize;

public class KmeansMiner {

	private ClusterSet C;
	
	public KmeansMiner(int k)
	{
		C = new ClusterSet(k);
	}
	
	public ClusterSet getC() 
	{
		return C;
	}
	
	public int kmeans(Data data) throws OutOfRangeSampleSize
	{
		int numberOfIterations = 0;
		//STEP 1
		C.initializeCentroids(data);
		boolean changedCluster = false;
		do {
			numberOfIterations++;
			//STEP 2
			changedCluster = false;
			for (int i = 0; i < data.getNumberOfExamples(); i++)
			{
				Cluster nearestCluster = C.nearestCluster(data.getItemSet(i));
				Cluster oldCluster = C.currentCluster(i);
				boolean currentChange = nearestCluster.addData(i);
				if (currentChange)
				{
					changedCluster = true;
					//rimuovo la tupla dal vecchio cluster
				}
					
				if (currentChange && oldCluster != null)
				{
					//il nodo va rimosso dal suo vecchio cluster
					oldCluster.removeTuple(i);
				}
			}
			//STEP 3
			C.updateCentroids(data);
			
		} while(changedCluster);
			
		return numberOfIterations;
	}
=======

package mining;

import data.Data;
import data.OutOfRangeSampleSize;

public class KmeansMiner {

	private ClusterSet C;
	
	public KmeansMiner(int k)
	{
		C = new ClusterSet(k);
	}
	
	public ClusterSet getC() 
	{
		return C;
	}
	
	public int kmeans(Data data) throws OutOfRangeSampleSize
	{
		int numberOfIterations = 0;
		//STEP 1
		C.initializeCentroids(data);
		boolean changedCluster = false;
		do {
			numberOfIterations++;
			//STEP 2
			changedCluster = false;
			for (int i = 0; i < data.getNumberOfExamples(); i++)
			{
				Cluster nearestCluster = C.nearestCluster(data.getItemSet(i));
				Cluster oldCluster = C.currentCluster(i);
				boolean currentChange = nearestCluster.addData(i);
				if (currentChange)
				{
					changedCluster = true;
					//rimuovo la tupla dal vecchio cluster
				}
					
				if (currentChange && oldCluster != null)
				{
					//il nodo va rimosso dal suo vecchio cluster
					oldCluster.removeTuple(i);
				}
			}
			//STEP 3
			C.updateCentroids(data);
			
		} while(changedCluster);
			
		return numberOfIterations;
	}
>>>>>>> 741ff817e60052cb01a51f71b8e37de0b6844fe0
}