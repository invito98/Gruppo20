package data;
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
		tuple[i]=c;
	}

	public double getDistance(Tuple obj)
	{
		double distanza;
		int i;

		i = 0;
		distanza = 0.0;
		while(i < this.getLength())
		{
			distanza = distanza + tuple[i].distance(obj.get(i).getValue()); // serve a stabilire quanti valori si differenziano di una stessa tupla, per poi farne la media
			i++;
		}
		
		return distanza;
	}

	public double avgDistance(Data data, int clusteredData[])
	{
		 double p = 0.0;
		 double sumD = 0.0;
		 for(int i=0; i < clusteredData.length; i++)
		 {
			 double d = getDistance(data.getItemSet(clusteredData[i]));
			 sumD = sumD + d;
		 }
		 p = sumD / clusteredData.length; // media della somma delle distanza
		 
		 return p;
	}
}