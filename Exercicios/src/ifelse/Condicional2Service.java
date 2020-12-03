package ifelse;

public class Condicional2Service {

	int horasTrab, horasExtra;
	Double salario, salarioExcedente, excedente, salarioTotal;

	public Double setSalario() {
		if(horasTrab < 50) {
		salario = 10.00 * horasTrab;
		return salario;
	}else {
		return salario = 500.00;
	}}

	public Double salarioExcedente() {
		if (horasTrab > 50) {
			excedente = 20.00;
			salarioExcedente = (horasTrab - 50) * excedente;
			return salarioExcedente;
		} else {
			salarioExcedente = 0.0;
			return salarioExcedente;
		}

	}

	public Double salarioTotal() {
		if (horasTrab > 50) {
			excedente = 20.00;
			return setSalario() + salarioExcedente();
		} else {
			excedente = 0.00;
			return setSalario() + excedente;
		}

	}

	public int horas() {
		if (horasTrab <= 50) {
			horasExtra = 0;
			return horasExtra;
		} else {
			horasExtra = horasTrab - 50;
			return horasExtra;
		}
	}

	public String toString() {
		return "Você trabalhou: " + horasTrab + " horas" + "\n" + "Você excedeu: " + horas() + " hora(s)" + "\n"
				+ "Valor excedente R$ " + String.format("%.2f",salarioExcedente()) + "\n" + "Salario total R$ " + String.format("%.2f",salarioTotal());

	}

}
