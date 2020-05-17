package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.importedProduct;
import entities.usedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
				
		System.out.print("quantos produtos?: ");
		int quant = sc.nextInt();
		for(int i=1;i<quant+1;i++) {
			System.out.print("comun, importado ou usado?(c,i,u): ");
			char imp = sc.next().charAt(0);
			System.out.printf("dados do %d° prduto: %n", i);
			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("preço: ");
			double price = sc.nextDouble();
			if(imp == 'I' || imp == 'i' ) {
			System.out.print("taixa de importação: ");
			double tax = sc.nextDouble();
			System.out.println();
			list.add(new importedProduct(name, price, tax)); 
			}else if(imp == 'u' || imp == 'U') {
				System.out.print("data da devolução?: ");
				sc.nextLine();
				String date = sc.nextLine();
				Date Dt = sdf.parse(date);
				list.add(new usedProduct(name,price,Dt));
			}else if(imp == 'c' || imp == 'C') {
				list.add(new Product(name,price));
			}		
		}
		
		
		System.out.println();
		System.out.println("Price Tags: ");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
		
		
	}

}
