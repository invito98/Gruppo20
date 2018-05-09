
package data;

import java.util.*;

class DiscreteAttribute extends Attribute implements Iterable<String> {
	
	private TreeSet<String> values;
	
	DiscreteAttribute(String name, int index, TreeSet<String> values)
	{
		super (name, index); // invoca il costruttore della classe madre
		this.values = values;
	}
	
	public Iterator<String> iterator()
	{
		Iterator<String> itr = values.iterator(); // mi restituisce l'iteratore all'oggetto voluto, nel caso alla stringa
		
		return itr;
	}
	
	int getNumberOfDistinctValues()
	{
		return values.size();
	}

	int frequency(Data data, HashSet<Integer> idList, String v) 
	{
		int frequency, index;
		
		index = findColumn(data, v); /* trova la colonna in cui si troverà nella matrice data la stringa v
		                              * servendosi di DiscreteAttribute
		                              */
		frequency = 0;
		Iterator<Integer> itr = idList.iterator();
		while (itr.hasNext()) 
		{	
			if (v.equals(data.getAttributeValue(itr.next(), index))) 
			{
				frequency += 1;
			}
		}
		
		return frequency;
	}

	private int findColumn(Data data, String v) /* trovare la colonna di Data in cui poter trovare la stringa v
												  * trovando prima v a che discreteAttribute appartiene
												  */
	{
		int i, j, index;
		
		i = 0;
		while(i < data.getNumberOfExplanatoryAttributes())
		{
			DiscreteAttribute a = (DiscreteAttribute)data.getAttribute(i); // cast di a ad DiscreteAttribute																		
			j = 0;
			Iterator<String> itr = a.iterator();
			while (j < a.getNumberOfDistinctValues())
			{
				if (v == itr.next())
				{
					index = i;
					return index;
				}
				
				j++;
			}
			
			i++;
		}
		
		return -1;
	}
	
}
