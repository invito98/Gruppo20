import data.Data;
import mining.KmeansMiner;
import keyboardinput.Keyboard;

public class MainTest {

	public static void main(String[] args) {
		
		char choose='y';
		int k;
		
		Data data =new Data();
		System.out.println(data);
		Keyboard in = new Keyboard();
		do {
		System.out.println("Inserisci il numero d Cluster da scoprire: ");
		
		k = in.readInt();
		KmeansMiner kmeans=new KmeansMiner(k);
		
		int numIter=kmeans.kmeans(data);
		
		System.out.println("Numero di Iterazione:"+numIter);
		System.out.println(kmeans.getC().toString(data));
		
		System.out.println("Vuoi ripetere l'esecuzione?(y/n) ");
		choose = in.readChar();
		}while(choose != 'n');
		
	}

}