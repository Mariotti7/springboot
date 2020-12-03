package ifelse;

import java.util.Locale;
import java.util.Scanner;

public class Condicional2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		Condicional2Service service = new Condicional2Service();
		/*
		 * Elabore um sistema que leia as vari�veis C e N, respectivamente c�digo e
		 * n�mero de horas trabalhadas de um oper�rio. E calcule o sal�rio sabendo-se
		 * que ele ganha R$ 10,00 por hora. Quando o n�mero de horas exceder a 50
		 * calcule o excesso de pagamento armazenando-o na vari�vel E, caso contr�rio
		 * zerar tal vari�vel. A hora excedente de trabalho vale R$ 20,00. No final do
		 * processamento imprimir o sal�rio total e o sal�rio excedente.
		 */

		int codigoOp;

		System.out.print("Ol� Oper�rio, entre com o seu c�digo: ");
		codigoOp = sc.nextInt();

		System.out.println();
		System.out.print("Digite as horas trabalhadas: ");
		service.horasTrab = sc.nextInt();

		System.out.println("==========================");
		System.out.printf("HOLERITE - Oper�rio %d%n", codigoOp);
		System.out.println("==========================");
		System.out.println(service.toString());

		sc.close();

	}

}
