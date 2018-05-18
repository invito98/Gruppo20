<<<<<<< HEAD

package data;

import java.util.*;

public class Tuple {
	
	private Item[] tuple; // detto da 	"LEI" !!!

	public Tuple(int size)
	{
		tuple = new Item[size];
	}

	public int getLength()
	{
		return tuple.length;
	}

	public Item get(int i)
	{
		return tuple[i];
	}

	void add(Item c, int i)
	{
		tuple[i]=c;
	}

	public double getDistance(Tuple obj)
	{
		double distanza;
		int i;

		i = 0;
		distanza = 0.0;
		while(i < getLength())
		{
			distanza = distanza + tuple[i].distance(obj.get(i).getValue()); // serve a stabilire quanti valori si differenziano di una stessa tupla, per poi farne la media
			i++;
		}
		
		return distanza;
	}

	public double avgDistance(Data data, HashSet<Integer> clusteredData)
	{
		 double p = 0.0;
		 double sumD = 0.0;
		 Iterator<Integer> itr = clusteredData.iterator();
		 for(int i=0; i < clusteredData.size(); i++)
		 {
			 double d = getDistance(data.getItemSet(itr.next()));
			 sumD = sumD + d;
		 }
		 p = sumD / clusteredData.size(); // media della somma delle distanza
		 
		 return p;
	}
}
=======

package data;

import java.util.*;

public class Tuple {
	
	private Item[] tuple;

	public Tuple(int size)
	{
		tuple = new Item[size];
	}

	public int getLength()
	{
		return tuple.length;
	}

	public Item get(int i)
	{
		return tuple[i];
	}

	void add(Item c, int i)
	{
		tuple[i] = c;
	}

	public double getDistance(Tuple obj)
	{
		double distanza;
		int i;

		i = 0;
		distanza = 0.0;
		while (i < getLength())
		{
			distanza = distanza + tuple[i].distance(obj.get(i).getValue()); // serve a stabilire quanti valori si differenziano di una stessa tupla, per poi farne la media
			i++;
		}
		
		return distanza;
	}

	public double avgDistance(Data data, HashSet<Integer> clusteredData)
	{
		 double p = 0.0;
		 double sumD = 0.0;
		 Iterator<Integer> itr = clusteredData.iterator();
		 for (int i=0; i < clusteredData.size(); i++)
		 {
			 double d = getDistance(data.getItemSet(itr.next()));
			 sumD = sumD + d;
		 }
		 
		 p = sumD / clusteredData.size(); // media della somma delle distanza
		 
		 return p;
	}
}
>>>>>>> 741ff817e60052cb01a51f71b8e37de0b6844fe0
