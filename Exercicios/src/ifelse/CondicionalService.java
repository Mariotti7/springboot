package ifelse;

public class CondicionalService {
	
	public Double multa = 4.00;
	public int excedido;
	public int peso;
	public int p = 50;
	
	public int setExcesso() {
		
		excedido = peso - p;
		return excedido;
			
	}
	
	public Double setMulta() {
		return multa * setExcesso();
	}
	
	public String toString() {
		if(peso <= p) {
			return "Peso " + peso + "kg" +"\n" + "Sem multa";
		}else {
			return "Peso " + peso + "kg" +"\n" + "Excedido " + setExcesso() + "kg" + "\n" + "Valor da Multa R$ " + setMulta();
		}
	}

}
