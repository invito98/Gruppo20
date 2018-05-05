package data;

import java.util.Random;
import utility.ArraySet;

public class Data {
//
	private Object data [][]; // una matrice nXm di tipo Object dove ogni riga modella una transazioni
	private int numberOfExamples; // cardinalit‡ dellíinsieme di transazioni (numero di righe in data)
	private Attribute explanatorySet[]; // un vettore degli attributi in ciascuna tupla (schema della tabella di dati)
	private int distinctTuples;
	
	public Data()
	{	
		data = new Object [14][5];
		
		data[0][0] = "sunny";
		data[0][1] = "hot";
		data[0][2] = "high";
		data[0][3] = "weak";
		data[0][4] = "no";
		
		data[1][0] = "sunny";
		data[1][1] = "hot";
		data[1][2] = "high";
		data[1][3] = "strong";
		data[1][4] = "no";
		
		data[2][0] = "overcast";
		data[2][1] = "hot";
		data[2][2] = "high";
		data[2][3] = "weak";
		data[2][4] = "yes";
		
		data[3][0] = "rain";
		data[3][1] = "mild";
		data[3][2] = "high";
		data[3][3] = "weak";
		data[3][4] = "yes";
		
		data[4][0] = "rain";
		data[4][1] = "cool";
		data[4][2] = "normal";
		data[4][3] = "weak";
		data[4][4] = "yes";
		
		data[5][0] = "rain";
		data[5][1] = "cool";
		data[5][2] = "normal";
		data[5][3] = "strong";
		data[5][4] = "no";
		
		data[6][0] = "overcast";
		data[6][1] = "cool";
		data[6][2] = "normal";
		data[6][3] = "weak";
		data[6][4] = "no";
		
		data[7][0] = "sunny";
		data[7][1] = "mild";
		data[7][2] = "high";
		data[7][3] = "weak";
		data[7][4] = "no";
		
		data[8][0] = "sunny";
		data[8][1] = "cool";
		data[8][2] = "normal";
		data[8][3] = "weak";
		data[8][4] = "yes";
		
		data[9][0] = "rain";
		data[9][1] = "mild";
		data[9][2] = "normal";
		data[9][3] = "strong";
		data[9][4] = "no";
		
		data[10][0] = "sunny";
		data[10][1] = "mild";
		data[10][2] = "normal";
		data[10][3] = "strong";
		data[10][4] = "yes";
		
		data[11][0] = "overcast";
		data[11][1] = "mild";
		data[11][2] = "high";
		data[11][3] = "strong";
		data[11][4] = "yes";
		
		data[12][0] = "overcast";
		data[12][1] = "hot";		
		data[12][2] = "normal";
		data[12][3] = "weak";
		data[12][4] = "yes";
		
		data[13][0] = "rain";
		data[13][1] = "mild";
		data[13][2] = "high";
		data[13][3] = "strong";
		data[13][4] = "no";
		
		numberOfExamples = 14;		 
		 
		explanatorySet = new Attribute[5];
			
		String outLookValues[] = new String[3];
		outLookValues[0] = "overcast";
		outLookValues[1] = "rain";
		outLookValues[2] = "sunny";
		explanatorySet[0] = new DiscreteAttribute ("Outlook", 0, outLookValues);
		
		String temperatureValues[] = new String[3];
		temperatureValues[0] = "hot";
		temperatureValues[1] = "mild";
		temperatureValues[2] = "cool";
		explanatorySet[1] = new DiscreteAttribute ("Temperature", 1, temperatureValues);
		
		String humidityValues[] = new String[2];
		humidityValues[0] = "high";
		humidityValues[1] = "normal";
		explanatorySet[2] = new DiscreteAttribute ("Humidity", 2, humidityValues);
		
		String windValues[] = new String[2];
		windValues[0] = "weak";
		windValues[1] = "strong";
		explanatorySet[3] = new DiscreteAttribute ("Wind", 3, windValues);
		
		String playTennisValues[] = new String[2];
		playTennisValues[0] = "no";
		playTennisValues[1] = "yes";
		explanatorySet[4] = new DiscreteAttribute ("Playtennis", 4, playTennisValues);
			
		distinctTuples=countDistinctTuples();
	}
		
	public int getNumberOfExamples()
	{
		return numberOfExamples;
	}
		
	public int getNumberOfExplanatoryAttributes()
	{
	    return explanatorySet.length;
	}
	
	Attribute[] getAttributeSchema()
	{
		return explanatorySet;
	}
		
	public Object getAttributeValue(int exampleIndex, int attributeIndex)
	{
		return data[exampleIndex][attributeIndex];
	}
	
	Attribute getAttribute (int index)
	{
		return explanatorySet[index];
	}
		
	public String toString()
	{
		int i, j;
		String tabella = new String (explanatorySet[0] + " " + explanatorySet[1] + " " + explanatorySet[2] + " " + explanatorySet[3] + " " + explanatorySet[4]);
		i = 0;
		while (i < 14)
		{
			j = 0;
			tabella = tabella + "\n" + i + ". ";
			while (j < 5)
			{
				tabella = tabella + " " + getAttributeValue(i, j);
				j++;
			}
			
			i++;
		}
		
		return tabella;
	}
	
	public Tuple getItemSet(int index) /* restituisce una tupla, vettore di Item, composto di 5 Item, quanto Ë 
								 * explanatorySet, 
								 */
	{
		Tuple tuple = new Tuple(explanatorySet.length);
		for (int i = 0; i < explanatorySet.length; i++)
		{
			tuple.add(new DiscreteItem((DiscreteAttribute)explanatorySet[i],(String)data[index][i]), i);
		}
		
		return tuple;
	}

	public int[] sampling(int k)throws OutOfRangeSampleSize
	{
		if(k<=0 || k>distinctTuples) {
			throw new OutOfRangeSampleSize("\nNumero di cluser non valido\n");
		}
		int centroidIndexes[] = new int[k];
		//choose k random different centroids in data.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < k; i++)
		{
			boolean found = false;
			int c;
			do
			{
				found = false;
				c = rand.nextInt(getNumberOfExamples());
				// verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes
				for (int j=0; j < i; j++)
				{
					if (compare(centroidIndexes[j],c))
					{
						found = true;
						break;
					}
				}
				
			} while(found);
			
			centroidIndexes[i] = c;
		}
		
		return centroidIndexes;
	}

	private boolean compare(int i,int j)
	{
		int k = 0;
		
		while(k < getNumberOfExplanatoryAttributes())
		{
			if (data[i][k].equals(data[j][k]) == false)
			{
				return false;
			}
			k++;
		}
		
		return true;
	}

	String computePrototype(ArraySet idList, DiscreteAttribute attribute) /* calcola e restituisce la stringa 
																		   * pi˘ presente di un DiscreteAttribute
																		   */
	{
		int j;
		String word;

		int[] a = new int[attribute.getNumberOfDistinctValues()];
		j=0;
		while (j < a.length)
		{
			word = attribute.getValue(j);
			a[j] = attribute.frequency(this, idList, word);
			
			j++;
			
		}
		j = max(a);
		
		
		return attribute.getValue(j);
	}

	private int max(int vettore[]) // calcolo del massimo per un vettore
	{
		int i, max, best,j;
		i = best = j = 0;
		
		while (i < vettore.length)
		{
			max = vettore[i];
			if (best < max)
			{
				best = max;
				j=i; // indice del vettore di occorrenze della stringa maggiore
			}
		
			i++;
		}
		
		return j;
	}

	Object computePrototype(ArraySet idList,Attribute attribute)
	{
		return computePrototype(idList,(DiscreteAttribute)attribute);
	}
	
	public int countDistinctTuples() {
		ArraySet found = new ArraySet();
		int j;
		int i=0;
		while(i<numberOfExamples) {
			if(found.get(i)!=true) {
			j=i+1;
			while(j<numberOfExamples) {
					if(compare(i,j)==true) {
						found.add(j);
					}
					j++;
				}
			}
			i++;
		}
		i=0;
		while(i<numberOfExamples) {
			if(found.get(i)==true) {
				numberOfExamples--;
			}
			i++;
		}
		return numberOfExamples;
	}
	
}
