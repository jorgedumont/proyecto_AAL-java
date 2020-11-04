package application;

import javafx.beans.property.SimpleIntegerProperty;

public class Numero {
	
	private final SimpleIntegerProperty numero = new SimpleIntegerProperty(0);

	
	public Numero(){}
	public Numero(int Numero){
		setNumero(Numero);
	}

	public int getNumero(){
		return numero.get();
	}
	public void setNumero(int Valor){
		this.numero.set(Valor);
	}
}
