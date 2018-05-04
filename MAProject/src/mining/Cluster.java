package mining;
import data.Data;
import data.Tuple;
import utility.ArraySet;

public class Cluster {
	
	private Tuple centroid; // vettore di item, contenenti un Attribute e un oggetto
	private ArraySet clusteredData; // vettore inizialmente di booleani

	Cluster() // costruttore con valori casuali
	{
		centroid = new Tuple(5); 
		clusteredData = new ArraySet();
	}

	Cluster(Tuple centroid)
	{
		this.centroid = centroid;
		clusteredData = new ArraySet();
	}

	Tuple getCentroid()
	{
		return centroid;
	}

	void computeCentroid(Data data)
	{
		for (int i = 0; i < centroid.getLength(); i++)
		{
			centroid.get(i).update(data,clusteredData);
		}

	}
	
	//return true if the tuple is changing cluster
	boolean addData(int id)
	{
		return clusteredData.add(id);
	}

	//verifica se una transazione À clusterizzata nell'array corrente
	boolean contain(int id)
	{
		return clusteredData.get(id);
	}

	//remove the tuple that has changed the cluster
	void removeTuple(int id)
	{
		clusteredData.delete(id);
	}

	public String toString()
	{
		String str = "Centroid = (";
		for (int i = 0; i < centroid.getLength(); i++)
		{
			str += centroid.get(i);
		}
		str += ")";
		
		return str;
	}

	public String toString(Data data)
	{
		String str = "Centroid = (";
		
		for(int i = 0; i < centroid.getLength(); i++)
			str += centroid.get(i) + " ";
		str += ")\n Examples:\n";
		
		int array[] = clusteredData.toArray(); // array di booleani in array di indici delle righe vere
		for (int i=0; i < array.length; i++)
		{
			str += "[";
			for (int j = 0; j < data.getNumberOfExplanatoryAttributes(); j++)
			{
				str += data.getAttributeValue(array[i], j) + " ";
			}
			str += "] dist=" + getCentroid().getDistance(data.getItemSet(array[i])) + "\n";
		}
		str += "\n AvgDistance="+getCentroid().avgDistance(data, array);
		
		return str;
	}
	
}
