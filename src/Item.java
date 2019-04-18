
public class Item {
	

	public String nome;
	public int valor;
	public int peso;
	
	public Item(String nome, int peso, int valor){
		this.nome = nome;
		this.valor = valor;
		this.peso = peso;
	}
	
	public String toString() {
		return "Item [nome=" + nome + ", peso=" + peso + ", valor=" + valor + "]";
	}

}
