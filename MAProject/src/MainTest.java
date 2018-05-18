
import java.io.FileNotFoundException;
import java.io.IOException;

import keyboardinput.Keyboard;
import mining.KmeansMiner;
import data.Data;
import data.OutOfRangeSampleSize;


public class MainTest {

	/**
	 * @param args
	 */
	
	private static int menu(){
		int answer;
		System.out.println("Scegli una opzione");
		do{
			System.out.println("(1) Carica Cluster da File");
			System.out.println("(2) Carica Dati");
			System.out.print("Risposta:");
			answer=Keyboard.readInt();
		}
		while(answer<=0 || answer>2);
		return answer;
		
	}
	
	static KmeansMiner learningFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		String fileName="";
		System.out.print("Nome archivio:");
		fileName=Keyboard.readString();
		return new KmeansMiner(fileName+".dmp");
		
	}
	public static void main(String[] args) {
		
		do{
			int menuAnswer=menu();
			switch(menuAnswer)
			{
				case 1:
					try {
						KmeansMiner kmeans=learningFromFile();
						System.out.println(kmeans);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					Data data =new Data();
					System.out.println(data);
					char answer='y';
					do{
						int k=1;
						System.out.print("Inserisci k:");
						k=Keyboard.readInt();
						KmeansMiner kmeans=new KmeansMiner(k);
						try
						{
							int numIter=kmeans.kmeans(data);
							System.out.println("Numero di Iterazione:"+numIter);
							System.out.println(kmeans.getC().toString(data));
							System.out.print("Nome file di backup:");
							String fileName=Keyboard.readString()+".dmp";
							System.out.println("Salvataggio in "+fileName);
							try {
								kmeans.salva(fileName);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Fine operazioni di salvataggio!");
							
							
						}
						catch(OutOfRangeSampleSize e)
						{
							System.out.println(e.getMessage());
						}
						System.out.print("Vuoi ripetere l'esecuzione?(y/n)");
						answer=Keyboard.readChar();
					}
					while(answer=='y');
					break;
				default:
					System.out.println("Opzione non valida!");
		
			}
			
			System.out.print("Vuoi scegliere una nuova operazione da menu?(y/n)");
			if(Keyboard.readChar()!='y')
				break;
			}
		while(true);
		}
	}

/*import mining.KmeansMiner;
import keyboardinput.Keyboard;
import data.Data;
import data.OutOfRangeSampleSize;

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
			try 
			{
				System.out.println("Inserisci il numero di Cluster da scoprire: ");
				k = in.readInt();
				KmeansMiner kmeans = new KmeansMiner(k);
				int numIter = kmeans.kmeans(data);
				System.out.println("\nNumero di Iterazione : " + numIter);
				System.out.println(kmeans.getC().toString(data));
			}
			catch (OutOfRangeSampleSize e) 
			{
				System.out.println("\nNumero di Cluster non valido\n ");
			}
			System.out.println("Vuoi ripetere l'esecuzione?(y/n) ");
			choose = in.readChar();
			
		} while (choose != 'n'); // da modificare, continua anche se scrivi a
	
		
	}

}*/
