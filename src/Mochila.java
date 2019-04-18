import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 


public class Mochila {
	
	private Item[] items;
	private int capacidade;
	
	
	public Mochila(Item[] items, int capacidade){
		this.items = items;
		this.capacidade = capacidade;
	}
	
	  public void display() {
		    if (items != null  &&  items.length > 0) {
		      System.out.println("Problema da mochila");
		      System.out.println("Capacidade: " + capacidade);
		      System.out.println("Itens :");

		      for (Item item : items) {
		        System.out.println("- " + item.toString());
		      }
		    }
	}
	
	public Solucao tabela(){
		int TOTAL_ITEMS = items.length;
		int[][] matriz = new int[TOTAL_ITEMS + 1][capacidade + 1];
		
		
		//a primeira linha é 0
		for(int i = 0; i <= capacidade; i++){
			matriz[0][i] = 0;
		}
		
		for(int i = 1; i <= TOTAL_ITEMS; i++){ //começando do 1 pois já inicializamos a primeira linha
			//lihas
			for(int j = 0; j <= capacidade; j++){
				//colunas
				if(items[i - 1].peso > j){
					matriz[i][j] = matriz[i-1][j];
				}else{
					matriz[i][j] = Math.max(matriz[i-1][j], matriz[i-1][j-items[i-1].peso] + items[i-1].valor);
				}
			}
	
		}
		
		int ss = matriz[TOTAL_ITEMS][capacidade];
		int pes = capacidade;
		List<Item> iSol = new ArrayList<>();
		
		
		for(int i = TOTAL_ITEMS; i > 0 && ss > 0; i--){
			if(ss != matriz[i-1][pes]){ //se o valor do item de cima for diferente do atual
				iSol.add(items[i-1]); //adicionamos a solução
				
				//e removemos o valor e peso
				ss -= items[i-1].valor;
				pes -= items[i-1].peso;
				
			}
		}
		
		return new Solucao(iSol, matriz[TOTAL_ITEMS][capacidade]);
		
		
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int tam, peso;
		//String path = "C:/Users/Anderson/workspace/MochilaInteira/src/mochila01.txt";
		String path;
	
		path = System.getProperty("user.dir") + args[0];
	
		File file = new File(path);
		Scanner s = null;
		s = new Scanner(file);
		
		tam = s.nextInt();
		peso = s.nextInt();

		Item[] itens = new Item[tam];

		for(int i=0; i < tam; i++){
			itens[i] = new Item("I" + (i+1), s.nextInt(), s.nextInt());
		}
		
		s.close();
		
		System.out.println("lenght: " + itens.length);
		Mochila mochila = new Mochila(itens, peso); //cria a mochila do tamanho possível
		mochila.display();
		Solucao solucao = mochila.tabela(); //cria a tabela de solução
		
		solucao.Print();

		

	}
	

}
