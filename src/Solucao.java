import java.util.List;

public class Solucao { //cont�m  os itens da solu��o e o valor da mesma
	
	public List<Item> items; //lista com os itens da solu��o
	public int valor;  //valor m�ximo da solu��o
	
	
	public Solucao(List<Item> items, int valor){
		this.items = items;
		this.valor = valor;
	}
	
	public void Print(){	
		
		if(items != null && !items.isEmpty()){
			System.out.println("Solu��o:");
			System.out.println("Valor: " + valor);
			System.out.println("Items: ");
			
			for(Item item : items){
				System.out.println("->" + item.toString());
			}
		}
		
	}


}
