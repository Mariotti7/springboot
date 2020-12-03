package ifelse;

import java.util.Locale;
import java.util.Scanner;

public class Condicional {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*
		 * Jo�o Papo-de-Pescador, homem de bem, comprou um microcomputador para controlar o rendimento di�rio de seu 
		 * trabalho. Toda vez que ele traz um peso de tomate maior que o estabelecido pelo regulamento do estado de S�o Paulo 
		 * (50 quilos) deve pagar um multa de R$ 4,00 por quilo excedente. Jo�o precisa que voc� fa�a um sistema que leia a
		 *  vari�vel P (peso de tomates) e verifique se h� excesso. Se houver, gravar na vari�vel E (Excesso) e na vari�vel
		 *   M o valor da multa que Jo�o dever� pagar. Caso contr�rio mostrar tais vari�veis com o conte�do ZERO.

		 * */
		
		String nome;
		Double multa;
		int peso, excedente, p = 50;
		
		System.out.println("SECRETARIA DO ESTADO DE S�O PAULO");
		System.out.println("=================================");
		
		System.out.print("Digite seu nome: ");
		nome = sc.nextLine();
		System.out.println("=================================");

		System.out.println("Ol�, " + nome);
		System.out.println();
	
		System.out.println("Digite o peso do tomate");
		System.out.print("kg: ");
		peso = sc.nextInt();
		System.out.println("=================================");

		if(peso <= p) {
			System.out.printf("Seu tomate pesa %dkg%n",peso);
			System.out.println("Peso aprovado pela Secretaria de at� 50kg");
			System.out.println("Secret�ria de S�o Paulo Agropecu�ria agradece o seu trabalho!");
		}else {
		 excedente = peso - p;
		 multa = excedente * 4.00;
		 System.out.printf("Seu tomate pesa %dkg%n", peso);
		 System.out.println("Peso ultrapassou o limite estabelecido pela secretaria, a cada 1kg excedido ser� acrescido R$ 4,00.");
		 System.out.printf("Sua multa ser� de R$ %.2f%n", multa);
		 System.out.println("Secret�ria de S�o Paulo Agropecu�ria agradece o seu trabalho!");
		}
		
		
		sc.close();
	}

}
