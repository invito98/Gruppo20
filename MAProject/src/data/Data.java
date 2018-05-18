<<<<<<< HEAD

package data;

import java.util.*;

public class Data {

	private List<Example> data; // una matrice formata da liste di example dove ogni riga modella una transazioni
	private int numberOfExamples; // cardinalitï¿½ dellï¿½insieme di transazioni (numero di righe in data)
	private List<Attribute> explanatorySet; // lista degli attributi in ciascuna tupla (schema della tabella di dati)
	
	public class Example implements Comparable<Example> {
		
		List<Object> example = new ArrayList<Object>(); // ogni example ï¿½ una lista di Object
		
		void add(Object o)
		{
			example.add(o);
		}
		
		Object get(int i)
		{
			return example.get(i);
		}
		
		public Iterator<Object> iterator()
		{
			Iterator<Object> itr = example.iterator(); // mi restituisce l'iteratore all'oggetto voluto
			
			return itr;
		}
		
		public int compareTo(Example ex)
		{ 	
			Iterator<Object> itr1 = example.iterator(); 
			Iterator<Object> itr2 = ex.example.iterator();
			
			while (itr1.hasNext())
			{
				Object comp1, comp2;
				comp1 = itr1.next();
				comp2 = itr2.next();
				if (!(comp1.equals(comp2)))
				{
					return ((Comparable)comp1).compareTo((Comparable)comp2);
				}
				
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
	
	@SuppressWarnings("deprecation")
	public Data()
	{			
		TreeSet<Example> tempData = new TreeSet<Example>();
		
		explanatorySet = new LinkedList<Attribute>(); // diventa una lista linkata
		
		TreeSet<String> outLookValues = new TreeSet<String>();
		outLookValues.add("overcast");
		outLookValues.add("rain");
		outLookValues.add("sunny");
		
		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("high");
		humidityValues.add("normal");
		
		TreeSet<String> windValues = new TreeSet<String>();
		windValues.add("weak");
		windValues.add("strong");
		
		TreeSet<String> playTennisValues = new TreeSet<String>();
		playTennisValues.add("no");
		playTennisValues.add("yes");
		
		explanatorySet.add(new DiscreteAttribute("Outlook", 0, outLookValues));
		explanatorySet.add(new ContinuousAttribute("Temperature", 1, 3.2, 38.7));
		explanatorySet.add(new DiscreteAttribute("Humidity", 2, humidityValues));
		explanatorySet.add(new DiscreteAttribute("Wind", 3, windValues));
		explanatorySet.add(new DiscreteAttribute("Playtennis", 4, playTennisValues));
		
		Example ex0 = new Example();
		ex0.add(new String("sunny"));
		ex0.add(new Double(37.5));
		ex0.add(new String("high"));
		ex0.add(new String("weak"));
		ex0.add(new String("no"));
		tempData.add(ex0);
		
		Example ex1 = new Example();
		ex1.add(new String("sunny"));
		ex1.add(new Double(38.7));
		ex1.add(new String("high"));
		ex1.add(new String("strong"));
		ex1.add(new String("no"));
		tempData.add(ex1);
		
		Example ex2 = new Example();
		ex2.add(new String("overcast"));
		ex2.add(new Double(37.5));
		ex2.add(new String("high"));
		ex2.add(new String("weak"));
		ex2.add(new String("yes"));
		tempData.add(ex2);
		
		Example ex3 = new Example();
		ex3.add(new String("rain"));
		ex3.add(new Double(20.5));
		ex3.add(new String("high"));
		ex3.add(new String("weak"));
		ex3.add(new String("yes"));
		tempData.add(ex3);
		
		Example ex4 = new Example();
		ex4.add(new String("rain"));
		ex4.add(new Double(20.7));
		ex4.add(new String("normal"));
		ex4.add(new String("weak"));
		ex4.add(new String("yes"));
		tempData.add(ex4);
		
		Example ex5 = new Example();
		ex5.add(new String("rain"));
		ex5.add(new Double(21.2));
		ex5.add(new String("normal"));
		ex5.add(new String("strong"));
		ex5.add(new String("no"));
		tempData.add(ex5);
		
		Example ex6 = new Example();
		ex6.add(new String("overcast"));
		ex6.add(new Double(20.5));
		ex6.add(new String("normal"));
		ex6.add(new String("strong"));
		ex6.add(new String("yes"));
		tempData.add(ex6);
		
		Example ex7 = new Example();
		ex7.add(new String("sunny"));
		ex7.add(new Double(21.2));
		ex7.add(new String("high"));
		ex7.add(new String("weak"));
		ex7.add(new String("no"));
		tempData.add(ex7);

		Example ex8 = new Example();
		ex8.add(new String("sunny"));
		ex8.add(new Double(21.2));
		ex8.add(new String("normal"));
		ex8.add(new String("weak"));
		ex8.add(new String("yes"));
		tempData.add(ex8);
		
		Example ex9 = new Example();
		ex9.add(new String("rain"));
		ex9.add(new Double(19.8));
		ex9.add(new String("normal"));
		ex9.add(new String("weak"));
		ex9.add(new String("yes"));
		tempData.add(ex9);
		
		Example ex10 = new Example();
		ex10.add(new String("sunny"));
		ex10.add(new Double(3.5));
		ex10.add(new String("normal"));
		ex10.add(new String("strong"));
		ex10.add(new String("yes"));
		tempData.add(ex10);
		
		Example ex11 = new Example();
		ex11.add(new String("overcast"));
		ex11.add(new Double(3.6));
		ex11.add(new String("high"));
		ex11.add(new String("strong"));
		ex11.add(new String("yes"));
		tempData.add(ex11);
		
		Example ex12 = new Example();
		ex12.add(new String("overcast"));
		ex12.add(new Double(3.5));
		ex12.add(new String("normal"));
		ex12.add(new String("weak"));
		ex12.add(new String("yes"));
		tempData.add(ex12);
		
		Example ex13 = new Example();
		ex13.add(new String("rain"));
		ex13.add(new Double(3.2));
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
	
	private <T> T getNext(Iterator<T> temp)
	{
		return temp.next();
	}
		
	public String toString()
	{
		int i;
		String tabella = new String (explanatorySet.get(0) + " " + explanatorySet.get(1) + " " + explanatorySet.get(2) + " " + explanatorySet.get(3) + " " + explanatorySet.get(4));
		
		i = 0;
		Iterator<Example> riga = data.iterator();
		while (riga.hasNext())
		{
			Example temp = getNext(riga);
			tabella = tabella + "\n" + i + ". ";
			Iterator<Object> colonna = temp.example.iterator();
			while (colonna.hasNext())
			{
				tabella = tabella + " " + getNext(colonna);
			}	
			
			i++;
		}
		
		return tabella;
	}
	
	public Tuple getItemSet(int index) /* restituisce una tupla, vettore di Item, composto di 5 Item, quanto ï¿½ 
								        * explanatorySet, 
								        */
	{
		Tuple tuple = new Tuple(explanatorySet.size());
		
		int i = 0;
		
		Iterator<Attribute> itr = explanatorySet.iterator();
		Iterator<Object> colonna = data.get(index).iterator();
		
		while (itr.hasNext())
		{
			Attribute temp = getNext(itr);
			if(temp.getClass().getSimpleName().equals("ContinuousAttribute")) {
				
				tuple.add(new ContinuousItem( (ContinuousAttribute)temp, (double)getNext(colonna)), i);
				
			}else {
				
				tuple.add(new DiscreteItem( (DiscreteAttribute)temp , (String)getNext(colonna)), i);
				
			}
			
			i++;
		}
		
		return tuple;
	}

	public int[] sampling(int k) throws OutOfRangeSampleSize // non modificato perchï¿½ dato da lei
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
				for (int j = 0; j < i; j++)
				{
					if (compare(centroidIndexes[j], c))
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
		Iterator<Object> colonna1 = data.get(i).iterator();
		Iterator<Object> colonna2 = data.get(j).iterator();
		
		while(colonna1.hasNext())
		{
			if (!(colonna1.next().equals(colonna2.next())))
			{
				return false;
			}
		}
		
		return true;
	}

	String computePrototype(HashSet<Integer> idList, DiscreteAttribute attribute) /* calcola e restituisce la stringa 
																		   * piï¿½ presente di un DiscreteAttribute
																		   */
	{
		int max;
		int i; // contatore per scandire di quante posizioni l'iteratore dovrï¿½ andare avanti nel TreeSet di attribute
		String word;

		List<Integer> temp = new ArrayList<Integer>(attribute.getNumberOfDistinctValues());
		
		Iterator<String> itr = attribute.iterator();
		while (itr.hasNext())
		{
			word = itr.next(); // da modificare perchï¿½ adesso attribute ï¿½ un TreeSet
			temp.add(attribute.frequency(this, idList, word));
		}
		max = max(temp);
		
		itr = attribute.iterator(); // per far ricominciare l'iteratore dall'inizio del TreeSet, fino a j
		i = 0;
		while (i < max) // ciclo per far andare avanti l'iteratore del TreeSet di j volte, perchï¿½ j ï¿½ l'indice del vettore					
		{
			itr.next();
			i++;
		}
		
		return itr.next();
	}

	private int max(List<Integer> list) // calcolo del massimo per un vettore, contiene le occorrenze di tutte le stringhe
	{
		int i, j, max, best; // j serve per ritornare l'indice del best
		i = best = j = 0;
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext())
		{
			max = itr.next();
			if (best < max)
			{
				best = max;
				j = i;
			}
			
			i++;
		}
		
		return j;
	}
	
	Double computePrototype(HashSet<Integer> idList,ContinuousAttribute attribute)
    {
		double somma=0;
		int colonna = attribute.getIndex();
		
		Iterator<Integer> riga = idList.iterator();
		while(riga.hasNext())
		{
			somma=somma+(double)getAttributeValue(riga.next(),colonna);
		}
		Double risultato = somma/idList.size();
		return risultato;
	}
	
	Object computePrototype(HashSet<Integer> idList, Attribute attribute)
	{
		if(attribute.getClass().getSimpleName().equals("ContinuousAttribute")) 
		{
			return computePrototype(idList, (ContinuousAttribute)attribute);
			
		}else {
		
			return computePrototype(idList, (DiscreteAttribute)attribute);
			
		}
	 
	}
}
=======

package data;

import java.util.*;

public class Data {

	private List<Example> data; // una matrice formata da liste di example dove ogni riga modella una transazioni
	private int numberOfExamples; // cardinalità dell’insieme di transazioni (numero di righe in data)
	private List<Attribute> explanatorySet; // lista degli attributi in ciascuna tupla (schema della tabella di dati)
	
	class Example implements Comparable<Example> {
		
		private List<Object> example = new ArrayList<Object>(); // ogni example è una lista di Object
		
		void add(Object o)
		{
			example.add(o);
		}
		
		Object get(int i)
		{
			return example.get(i);
		}
		
		public Iterator<Object> iterator()
		{
			Iterator<Object> itr = example.iterator(); // mi restituisce l'iteratore all'oggetto voluto
			
			return itr;
		}
		
		public int compareTo(Example ex)
		{ 	
			Iterator<Object> itr1 = example.iterator(); 
			Iterator<Object> itr2 = ex.example.iterator();
			
			Object comp1, comp2;
			while (itr1.hasNext())
			{
				comp1 = itr1.next();
				comp2 = itr2.next();
				if (!(comp1.equals(comp2)))
				{
					return ((Comparable)comp1).compareTo((Comparable)comp2);
				}
				
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
		
		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("high");
		humidityValues.add("normal");
		
		TreeSet<String> windValues = new TreeSet<String>();
		windValues.add("weak");
		windValues.add("strong");
		
		TreeSet<String> playTennisValues = new TreeSet<String>();
		playTennisValues.add("no");
		playTennisValues.add("yes");
		
		explanatorySet.add(new DiscreteAttribute("Outlook", 0, outLookValues));
		explanatorySet.add(new ContinuousAttribute("Temperature", 1, 3.2, 38.7));
		explanatorySet.add(new DiscreteAttribute("Humidity", 2, humidityValues));
		explanatorySet.add(new DiscreteAttribute("Wind", 3, windValues));
		explanatorySet.add(new DiscreteAttribute("Playtennis", 4, playTennisValues));
		
		Example ex0 = new Example();
		ex0.add(new String("sunny"));
		ex0.add(new Double(37.5));
		ex0.add(new String("high"));
		ex0.add(new String("weak"));
		ex0.add(new String("no"));
		tempData.add(ex0);
		
		Example ex1 = new Example();
		ex1.add(new String("sunny"));
		ex1.add(new Double(38.7));
		ex1.add(new String("high"));
		ex1.add(new String("strong"));
		ex1.add(new String("no"));
		tempData.add(ex1);
		
		Example ex2 = new Example();
		ex2.add(new String("overcast"));
		ex2.add(new Double(37.5));
		ex2.add(new String("high"));
		ex2.add(new String("weak"));
		ex2.add(new String("yes"));
		tempData.add(ex2);
		
		Example ex3 = new Example();
		ex3.add(new String("rain"));
		ex3.add(new Double(20.5));
		ex3.add(new String("high"));
		ex3.add(new String("weak"));
		ex3.add(new String("yes"));
		tempData.add(ex3);
		
		Example ex4 = new Example();
		ex4.add(new String("rain"));
		ex4.add(new Double(20.7));
		ex4.add(new String("normal"));
		ex4.add(new String("weak"));
		ex4.add(new String("yes"));
		tempData.add(ex4);
		
		Example ex5 = new Example();
		ex5.add(new String("rain"));
		ex5.add(new Double(21.2));
		ex5.add(new String("normal"));
		ex5.add(new String("strong"));
		ex5.add(new String("no"));
		tempData.add(ex5);
		
		Example ex6 = new Example();
		ex6.add(new String("overcast"));
		ex6.add(new Double(20.5));
		ex6.add(new String("normal"));
		ex6.add(new String("strong"));
		ex6.add(new String("yes"));
		tempData.add(ex6);
		
		Example ex7 = new Example();
		ex7.add(new String("sunny"));
		ex7.add(new Double(21.2));
		ex7.add(new String("high"));
		ex7.add(new String("weak"));
		ex7.add(new String("no"));
		tempData.add(ex7);

		Example ex8 = new Example();
		ex8.add(new String("sunny"));
		ex8.add(new Double(21.2));
		ex8.add(new String("normal"));
		ex8.add(new String("weak"));
		ex8.add(new String("yes"));
		tempData.add(ex8);
		
		Example ex9 = new Example();
		ex9.add(new String("rain"));
		ex9.add(new Double(19.8));
		ex9.add(new String("normal"));
		ex9.add(new String("weak"));
		ex9.add(new String("yes"));
		tempData.add(ex9);
		
		Example ex10 = new Example();
		ex10.add(new String("sunny"));
		ex10.add(new Double(3.5));
		ex10.add(new String("normal"));
		ex10.add(new String("strong"));
		ex10.add(new String("yes"));
		tempData.add(ex10);
		
		Example ex11 = new Example();
		ex11.add(new String("overcast"));
		ex11.add(new Double(3.6));
		ex11.add(new String("high"));
		ex11.add(new String("strong"));
		ex11.add(new String("yes"));
		tempData.add(ex11);
		
		Example ex12 = new Example();
		ex12.add(new String("overcast"));
		ex12.add(new Double(3.5));
		ex12.add(new String("normal"));
		ex12.add(new String("weak"));
		ex12.add(new String("yes"));
		tempData.add(ex12);
		
		Example ex13 = new Example();
		ex13.add(new String("rain"));
		ex13.add(new Double(3.2));
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
		int i;
		String tabella = new String (explanatorySet.get(0) + " " + explanatorySet.get(1) + " " + explanatorySet.get(2) + " " + explanatorySet.get(3) + " " + explanatorySet.get(4));
		
		i = 0;
		Iterator<Example> riga = data.iterator();
		Example temp;
		while (riga.hasNext())
		{
			temp = riga.next();
			tabella = tabella + "\n" + i + ". ";
			Iterator<Object> colonna = temp.iterator();
			while (colonna.hasNext())
			{
				tabella = tabella + " " + colonna.next();
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
		
		int i = 0;
		
		Iterator<Attribute> itr = explanatorySet.iterator();
		Iterator<Object> colonna = data.get(index).iterator();
		
		Attribute temp;
		while (itr.hasNext())
		{
			temp = itr.next();
			if (temp instanceof ContinuousAttribute) 
			{
				tuple.add(new ContinuousItem((ContinuousAttribute)temp, (double)colonna.next()), i);
				
			}
			else 
			{	
				tuple.add(new DiscreteItem((DiscreteAttribute)temp, (String)colonna.next()), i);	
			}
			
			i++;
		}
		
		return tuple;
	}

	public int[] sampling(int k) throws OutOfRangeSampleSize // non modificato perché dato da lei
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
				for (int j = 0; j < i; j++)
				{
					if (compare(centroidIndexes[j], c))
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
		Iterator<Object> colonna1 = data.get(i).iterator();
		Iterator<Object> colonna2 = data.get(j).iterator();
		
		while(colonna1.hasNext())
		{
			if (!(colonna1.next().equals(colonna2.next())))
			{
				return false;
			}
		}
		
		return true;
	}

	String computePrototype(HashSet<Integer> idList, DiscreteAttribute attribute) /* calcola e restituisce la stringa 
																		   * più presente di un DiscreteAttribute
																		   */
	{
		int max;
		int i; // contatore per scandire di quante posizioni l'iteratore dovrà andare avanti nel TreeSet di attribute
		String word;

		List<Integer> temp = new ArrayList<Integer>(attribute.getNumberOfDistinctValues());
		
		Iterator<String> itr = attribute.iterator();
		while (itr.hasNext())
		{
			word = itr.next(); // da modificare perché adesso attribute è un TreeSet
			temp.add(attribute.frequency(this, idList, word));
		}
		max = max(temp);
		
		itr = attribute.iterator(); // per far ricominciare l'iteratore dall'inizio del TreeSet, fino a j
		i = 0;
		while (i < max) // ciclo per far andare avanti l'iteratore del TreeSet di j volte, perché j è l'indice del vettore					
		{
			itr.next();
			i++;
		}
		
		return itr.next();
	}

	private int max(List<Integer> list) // calcolo del massimo per un vettore, contiene le occorrenze di tutte le stringhe
	{
		int i, j, max, best; // j serve per ritornare l'indice del best
		i = best = j = 0;
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext())
		{
			max = itr.next();
			if (best < max)
			{
				best = max;
				j = i;
			}
			
			i++;
		}
		
		return j;
	}

	Double computePrototype(HashSet<Integer> idList, ContinuousAttribute attribute)
    {
		double somma = 0;
		int colonna = attribute.getIndex();
		
		Iterator<Integer> riga = idList.iterator();
		while (riga.hasNext())
		{
			somma = somma + (double)getAttributeValue(riga.next(),colonna);
		}
		
		Double result = somma / idList.size();
		
		return  result;
	}
	
	Object computePrototype(HashSet<Integer> idList, Attribute attribute)
	{
		if (attribute instanceof ContinuousAttribute) 
		{
			return computePrototype(idList, (ContinuousAttribute)attribute);
			
		}
		else 
		{	
			return computePrototype(idList, (DiscreteAttribute)attribute);	
		}
	
	}
	
}
>>>>>>> 741ff817e60052cb01a51f71b8e37de0b6844fe0
