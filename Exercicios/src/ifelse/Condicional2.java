package ifelse;

import java.util.Locale;
import java.util.Scanner;

public class Condicional2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		Condicional2Service service = new Condicional2Service();
		/*
		 * Elabore um sistema que leia as variáveis C e N, respectivamente código e
		 * número de horas trabalhadas de um operário. E calcule o salário sabendo-se
		 * que ele ganha R$ 10,00 por hora. Quando o número de horas exceder a 50
		 * calcule o excesso de pagamento armazenando-o na variável E, caso contrário
		 * zerar tal variável. A hora excedente de trabalho vale R$ 20,00. No final do
		 * processamento imprimir o salário total e o salário excedente.
		 */

		int codigoOp;

		System.out.print("Olá Operário, entre com o seu código: ");
		codigoOp = sc.nextInt();

		System.out.println();
		System.out.print("Digite as horas trabalhadas: ");
		service.horasTrab = sc.nextInt();

		System.out.println("==========================");
		System.out.printf("HOLERITE - Operário %d%n", codigoOp);
		System.out.println("==========================");
		System.out.println(service.toString());

		sc.close();

	}

}
