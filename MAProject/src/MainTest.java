
import mining.KmeansMiner;
import keyboardinput.Keyboard;
import data.Data;

public class MainTest {
	
	public static void main(String[] args) 
	{
		Data data = new Data();
		char choose = 'y';
		int k;
		System.out.println(data);
		Keyboard in = new Keyboard();
		
		do 
		{
			System.out.println("Inserisci il numero di Cluster da scoprire: ");
			k = in.readInt();
			KmeansMiner kmeans = new KmeansMiner(k);
			
			int numIter = kmeans.kmeans(data);
			
			System.out.println("\nNumero di Iterazione : " + numIter);
			System.out.println(kmeans.getC().toString(data));
			
			System.out.println("Vuoi ripetere l'esecuzione?(y/n) ");
			choose = in.readChar();
			
		} while (choose != 'n');
	
		
	}

}
