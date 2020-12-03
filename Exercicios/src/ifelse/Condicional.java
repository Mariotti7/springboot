package ifelse;

import java.util.Locale;
import java.util.Scanner;

public class Condicional {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*
		 * João Papo-de-Pescador, homem de bem, comprou um microcomputador para controlar o rendimento diário de seu 
		 * trabalho. Toda vez que ele traz um peso de tomate maior que o estabelecido pelo regulamento do estado de São Paulo 
		 * (50 quilos) deve pagar um multa de R$ 4,00 por quilo excedente. João precisa que você faça um sistema que leia a
		 *  variável P (peso de tomates) e verifique se há excesso. Se houver, gravar na variável E (Excesso) e na variável
		 *   M o valor da multa que João deverá pagar. Caso contrário mostrar tais variáveis com o conteúdo ZERO.

		 * */
		
		String nome;
		Double multa;
		int peso, excedente, p = 50;
		
		System.out.println("SECRETARIA DO ESTADO DE SÃO PAULO");
		System.out.println("=================================");
		
		System.out.print("Digite seu nome: ");
		nome = sc.nextLine();
		System.out.println("=================================");

		System.out.println("Olá, " + nome);
		System.out.println();
	
		System.out.println("Digite o peso do tomate");
		System.out.print("kg: ");
		peso = sc.nextInt();
		System.out.println("=================================");

		if(peso <= p) {
			System.out.printf("Seu tomate pesa %dkg%n",peso);
			System.out.println("Peso aprovado pela Secretaria de até 50kg");
			System.out.println("Secretária de São Paulo Agropecuária agradece o seu trabalho!");
		}else {
		 excedente = peso - p;
		 multa = excedente * 4.00;
		 System.out.printf("Seu tomate pesa %dkg%n", peso);
		 System.out.println("Peso ultrapassou o limite estabelecido pela secretaria, a cada 1kg excedido será acrescido R$ 4,00.");
		 System.out.printf("Sua multa será de R$ %.2f%n", multa);
		 System.out.println("Secretária de São Paulo Agropecuária agradece o seu trabalho!");
		}
		
		
		sc.close();
	}

}
