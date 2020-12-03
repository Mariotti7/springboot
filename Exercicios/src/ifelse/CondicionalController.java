package ifelse;

import java.util.Locale;
import java.util.Scanner;

public class CondicionalController {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		CondicionalService service = new CondicionalService();
		
		System.out.println("SECRETARIA DO ESTADO DE SÃO PAULO");
		System.out.println("=================================");
		
		System.out.println("Digite o peso do tomate");
		System.out.print("kg: ");
		service.peso = sc.nextInt();
		System.out.println("=================================");
		
		System.out.println(service.toString());
		
		
		sc.close();

	}

}
