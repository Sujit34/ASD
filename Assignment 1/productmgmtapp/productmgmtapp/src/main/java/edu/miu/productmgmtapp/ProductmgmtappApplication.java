package edu.miu.productmgmtapp;

import edu.miu.productmgmtapp.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;


@SpringBootApplication
public class ProductmgmtappApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductmgmtappApplication.class, args);

		Product[] products = new Product[]{
				new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 1.24f, .55f),
				new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18f, 1.09f),
				new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89f, 2.99f)
		};
		printProducts(products);
	}

	public static void printProducts(Product[] products) {

		Arrays.sort(products, Comparator.comparing(Product::getName));

		// print products
		System.out.println("Console Print....");
		for (var product : products) {
			System.out.println("Product Id: " + product.getProductId() + "  " +
					"Product Name : " + product.getName() + "  " +
					"Date Supplied: " + product.getDateSupplied() + "  " +
					"Quantity in Stock: " + product.getQuantityInStock() + "  " +
					"Unit Price: " + product.getUnitPrice());
		}

		System.out.println("\nJSON Format....");
		for (Product product : products) {
			System.out.println("{ \"productId\": " + product.getProductId() + ", \"name\": \"" + product.getName() + "\", \"dateSupplied\": \"" + product.getDateSupplied() + "\", \"quantityInStock\": " + product.getQuantityInStock() + ", \"unitPrice\": " + product.getUnitPrice() + " }");
		}

		System.out.println("\nXML Format....");
		System.out.println("<products>");
		for (Product product : products) {
			System.out.println("\t<product>");
			System.out.println("\t\t<productId>" + product.getProductId() + "</productId>");
			System.out.println("\t\t<name>" + product.getName() + "</name>");
			System.out.println("\t\t<dateSupplied>" + product.getDateSupplied() + "</dateSupplied>");
			System.out.println("\t\t<quantityInStock>" + product.getQuantityInStock() + "</quantityInStock>");
			System.out.println("\t\t<unitPrice>" + product.getUnitPrice() + "</unitPrice>");
			System.out.println("\t</product>");
		}
		System.out.println("</products>");

		System.out.println("\nCSV Format....");
		for (Product product : products) {
			System.out.println(product.getProductId() + "," + product.getName() + "," + product.getDateSupplied() + "," + product.getQuantityInStock() + "," + product.getUnitPrice());
		}


	}
}
