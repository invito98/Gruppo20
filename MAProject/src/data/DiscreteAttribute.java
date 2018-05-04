package data;

import utility.ArraySet;

class DiscreteAttribute extends Attribute {
	
	private String values[];
	
	DiscreteAttribute (String name, int index, String values[])
	{
		super (name, index); // invoca il costruttore della classe madre
		this.values = values;
	}
	
	int getNumberOfDistinctValues()
	{
		return values.length;
	}
	
	String getValue(int i)
	{
		return values[i];
	}

	int frequency (Data data,ArraySet idList,String v) 
	{
		int i,frequency,index;
		int vector[] = idList.toArray(); /* converte il vettore di booleani, in uno di interi in cui ogni 
		                                  * elemento Ë l'indice della riga in cui c'Ë vero
		                                  */
		
		index = findColumn(data, v); /* trova la colonna in cui si trover‡ nella matrice data la stringa v
		                              * servendosi di DiscreteAttribute
		                              */
		i = frequency = 0;
		while (i < vector.length) 
		{
			if (v.equals(data.getAttributeValue(vector[i], index))) 
			{
				frequency += 1;
			}
			i++;
		}
		
		return frequency;
	}

	private int findColumn (Data data, String v)
	{
		int i, j, index;
		i=0;
		while(i < data.getNumberOfExplanatoryAttributes())
		{
			DiscreteAttribute a = (DiscreteAttribute)data.getAttribute(i); // cast di a ad DiscreteAttribute																		
			j=0;
			while (j < a.getNumberOfDistinctValues())
			{
				if (v == a.getValue(j))
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
