
package data;

import java.util.Random;
import java.util.*;

public class Data {

	private List<Example> data; // una matrice formata da liste di example dove ogni riga modella una transazioni
	private int numberOfExamples; // cardinalità dell’insieme di transazioni (numero di righe in data)
	private List<Attribute> explanatorySet; // lista degli attributi in ciascuna tupla (schema della tabella di dati)
	
	public class Example implements Comparable<Example> {
		
		List<Object> example; // ogni example è una lista di Object
		
		Example()
		{
			example = new ArrayList<Object>();
		}
		
		void add(Object o)
		{
			example.add(o);
		}
		
		Object get(int i)
		{
			return example.get(i);
		}
		
		public int compareTo(Example ex)
		{
			int i; 
			
			i = 0;
			while (i < getNumberOfExplanatoryAttributes())
			{
				if (!(this.get(i).equals(ex.get(i))))
				{
					return ((String)this.get(i)).compareTo((String)ex.get(i));
				}
				
				i++;
			}
			
			return 0;
		}
		
		public String toString()
		{
			String stato = "[";
			
			for (Object item : example)
			{
				stato = stato + "  " + (String)item;
			}
			stato = stato + "]";
			
			return stato;
		}
		
	}
	
	public Data()
	{			
		TreeSet<Example> tempData = new TreeSet<Example>();
		
		explanatorySet = new LinkedList<Attribute>(); // diventa una lista linkata
		
		TreeSet<String> outLookValues = new TreeSet<String>();
		outLookValues.add("overcast");
		outLookValues.add("rain");
		outLookValues.add("sunny");
		explanatorySet.add(new DiscreteAttribute("Outlook", 0, outLookValues));
		
		TreeSet<String> temperatureValues = new TreeSet<String>();
		temperatureValues.add("hot");
		temperatureValues.add("mild");
		temperatureValues.add("cool");
		explanatorySet.add(new DiscreteAttribute("Temperature", 1, temperatureValues));
		
		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("high");
		humidityValues.add("normal");
		explanatorySet.add(new DiscreteAttribute("Humidity", 2, humidityValues));
		
		TreeSet<String> windValues = new TreeSet<String>();
		windValues.add("weak");
		windValues.add("strong");
		explanatorySet.add(new DiscreteAttribute("Wind", 3, windValues));
		
		TreeSet<String> playTennisValues = new TreeSet<String>();
		playTennisValues.add("no");
		playTennisValues.add("yes");
		explanatorySet.add(new DiscreteAttribute("Playtennis", 4, playTennisValues));
		
		Example ex0 = new Example();
		ex0.add(new String("sunny"));
		ex0.add(new String("hot"));
		ex0.add(new String("high"));
		ex0.add(new String("weak"));
		ex0.add(new String("no"));
		tempData.add(ex0);
		
		Example ex1 = new Example();
		ex1.add(new String("sunny"));
		ex1.add(new String("hot"));
		ex1.add(new String("high"));
		ex1.add(new String("strong"));
		ex1.add(new String("no"));
		tempData.add(ex1);
		
		Example ex2 = new Example();
		ex2.add(new String("overcast"));
		ex2.add(new String("hot"));
		ex2.add(new String("high"));
		ex2.add(new String("weak"));
		ex2.add(new String("yes"));
		tempData.add(ex2);
		
		Example ex3 = new Example();
		ex3.add(new String("rain"));
		ex3.add(new String("mild"));
		ex3.add(new String("high"));
		ex3.add(new String("weak"));
		ex3.add(new String("yes"));
		tempData.add(ex3);
		
		Example ex4 = new Example();
		ex4.add(new String("rain"));
		ex4.add(new String("cool"));
		ex4.add(new String("normal"));
		ex4.add(new String("weak"));
		ex4.add(new String("yes"));
		tempData.add(ex4);
		
		Example ex5 = new Example();
		ex5.add(new String("rain"));
		ex5.add(new String("cool"));
		ex5.add(new String("normal"));
		ex5.add(new String("strong"));
		ex5.add(new String("no"));
		tempData.add(ex5);
		
		Example ex6 = new Example();
		ex6.add(new String("overcast"));
		ex6.add(new String("cool"));
		ex6.add(new String("normal"));
		ex6.add(new String("strong"));
		ex6.add(new String("yes"));
		tempData.add(ex6);
		
		Example ex7 = new Example();
		ex7.add(new String("sunny"));
		ex7.add(new String("mild"));
		ex7.add(new String("high"));
		ex7.add(new String("weak"));
		ex7.add(new String("no"));
		tempData.add(ex7);

		Example ex8 = new Example();
		ex8.add(new String("sunny"));
		ex8.add(new String("cool"));
		ex8.add(new String("normal"));
		ex8.add(new String("weak"));
		ex8.add(new String("yes"));
		tempData.add(ex8);
		
		Example ex9 = new Example();
		ex9.add(new String("rain"));
		ex9.add(new String("mild"));
		ex9.add(new String("normal"));
		ex9.add(new String("weak"));
		ex9.add(new String("yes"));
		tempData.add(ex9);
		
		Example ex10 = new Example();
		ex10.add(new String("sunny"));
		ex10.add(new String("mild"));
		ex10.add(new String("normal"));
		ex10.add(new String("strong"));
		ex10.add(new String("yes"));
		tempData.add(ex10);
		
		Example ex11 = new Example();
		ex11.add(new String("overcast"));
		ex11.add(new String("mild"));
		ex11.add(new String("high"));
		ex11.add(new String("strong"));
		ex11.add(new String("yes"));
		tempData.add(ex11);
		
		Example ex12 = new Example();
		ex12.add(new String("overcast"));
		ex12.add(new String("hot"));
		ex12.add(new String("normal"));
		ex12.add(new String("weak"));
		ex12.add(new String("yes"));
		tempData.add(ex12);
		
		Example ex13 = new Example();
		ex13.add(new String("rain"));
		ex13.add(new String("mild"));
		ex13.add(new String("high"));
		ex13.add(new String("strong"));
		ex13.add(new String("no"));
		tempData.add(ex13);
		
		data = new ArrayList<Example>(tempData);
		
		numberOfExamples = data.size();		  
			
	}
		
	public int getNumberOfExamples()
	{
		return numberOfExamples;
	}
		
	public int getNumberOfExplanatoryAttributes()
	{
	    return explanatorySet.size();
	}
	
	public List<Attribute> getAttributeSchema()
	{
		return explanatorySet;
	}
		
	public Object getAttributeValue(int exampleIndex, int attributeIndex)
	{
		return data.get(exampleIndex).get(attributeIndex);
	}
	
	public Attribute getAttribute(int index) // ritorna l'attribute identificato nella linked list come index
	{
		return explanatorySet.get(index);
	}
		
	public String toString()
	{
		int i, j;
		String tabella = new String (explanatorySet.get(0) + " " + explanatorySet.get(1) + " " + explanatorySet.get(2) + " " + explanatorySet.get(3) + " " + explanatorySet.get(4));
		i = 0;
		while (i < getNumberOfExamples())
		{
			j = 0;
			tabella = tabella + "\n" + i + ". ";
			while (j < getNumberOfExplanatoryAttributes())
			{
				tabella = tabella + " " + getAttributeValue(i, j);
				
				j++;
			}
			
			i++;
		}
		
		return tabella;
	}
	
	public Tuple getItemSet(int index) /* restituisce una tupla, vettore di Item, composto di 5 Item, quanto è 
								 * explanatorySet, 
								 */
	{
		Tuple tuple = new Tuple(explanatorySet.size());
		for (int i = 0; i < explanatorySet.size(); i++)
		{
			tuple.add(new DiscreteItem((DiscreteAttribute)explanatorySet.get(i), (String)data.get(index).get(i)), i);
		}
		
		return tuple;
	}

	public int[] sampling(int k)throws OutOfRangeSampleSize
	{
		if (k <= 0 || k > getNumberOfExamples()) 
		{
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

	private boolean compare(int i, int j)
	{
		int k = 0;
		
		while(k < getNumberOfExplanatoryAttributes())
		{
			if (getAttributeValue(i, k).equals(getAttributeValue(j, k)) == false)
			{
				return false;
			}
			
			k++;
		}
		
		return true;
	}

	String computePrototype(HashSet<Integer> idList, DiscreteAttribute attribute) /* calcola e restituisce la stringa 
																		   * più presente di un DiscreteAttribute
																		   */
	{
		int j;
		int i; // contatore per scandire di quante posizioni l'iteratore dovrà andare avanti nel TreeSet di attribute
		String word;

		int[] a = new int[attribute.getNumberOfDistinctValues()];
		
		j = 0;
		Iterator<String> itr = attribute.iterator();
		while (j < a.length)
		{
			word = itr.next(); // da modificare perché adesso attribute è un TreeSet
			a[j] = attribute.frequency(this, idList, word);
			j++;
		}
		j = max(a);
		
		itr = attribute.iterator(); // per far ricominciare l'iteratore dall'inizio del TreeSet, fino a j
		i = 0;
		while (i < j) // ciclo per far andare avanti l'iteratore del TreeSet di j volte, perché j è l'indice del vettore					
		{
			itr.next();
			i++;
		}
		
		return itr.next();
	}

	private int max(int vettore[]) // calcolo del massimo per un vettore, contiene le occorrenze di tutte le stringhe
	{
		int i, j, max, best; // j serve per ritornare l'indice del best
		i = best = j = 0;
		
		while (i < vettore.length)
		{
			max = vettore[i];
			if (best < max)
			{
				best = max;
				j = i;
			}
		
			i++;
		}
		
		return j;
	}

	Object computePrototype(HashSet<Integer> idList, Attribute attribute)
	{
		return computePrototype(idList, (DiscreteAttribute)attribute);
	}
	
}
