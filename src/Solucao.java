import java.util.List;

public class Solucao { //contém  os itens da solução e o valor da mesma
	
	public List<Item> items; //lista com os itens da solução
	public int valor;  //valor máximo da solução
	
	
	public Solucao(List<Item> items, int valor){
		this.items = items;
		this.valor = valor;
	}
	
	public void Print(){	
		
		if(items != null && !items.isEmpty()){
			System.out.println("Solução:");
			System.out.println("Valor: " + valor);
			System.out.println("Items: ");
			
			for(Item item : items){
				System.out.println("->" + item.toString());
			}
		}
		
	}


}
