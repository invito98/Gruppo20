package utility;
import java.util.Arrays;

public class ArraySet {
	
	private boolean set[];
	private int size = 0; // indica la posizione dell'ultimo vero
	
	public ArraySet ()
	{
		set = new boolean[50];
		for(int i = 0; i < set.length; i++)
			set[i] = false;
	}
	
	//return true if add is changing the arraySet
	public boolean add(int i)
	{
		if(i >= set.length)
		{
			//enlarge the set
			boolean temp[] = new boolean[set.length*2];
			Arrays.fill(temp, false);
			System.arraycopy(set, 0, temp, 0, set.length);
			set = temp;
		}	
		boolean added = set[i];
		set[i] = true;
		if (i >= size)
		{
			size = i + 1;
		}
	
		return !added;
	}
	
	public boolean delete(int i)
	{
		if (i < size)
		{
			boolean deleted = set[i];
			set[i] = false;
			if (i == size-1) // trova la posizione del penultimo vero, eliminando l'ultimo vero
			{
				//update size
				int j;
				for(j = size-1; j >= 0 && set[j] == false; j--); // Non fa altro che decrementare la j finchÈ non trova il primo vero
				size = j + 1; // prende come ultimo vero la posizione di j pi˘ 1
			}
			
			return deleted; // elimina un elemento, se Ë un vero fa l'if, in cui si salva l'ultima posizione
		}
		return false; // non posso eliminare niente perchÈ sei in tutti falsi
	}
	
	public boolean get(int i)
	{
		return set[i];
	}
	
	public int[] toArray()
	{
		int a[] = new int[0];
		for(int i = 0; i < size; i++) // finchÈ non arriva all'ultimo vero, dopo di che saranno tutti falsi 
		{
			if (get(i) == true) // modificato da get(i), se vero li mette nel vettore, se falsi passa avanti
			{
				int temp[] = new int[a.length + 1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a = temp;
				a[a.length - 1] = i;
			}
		}
		
		return a;
	}
}