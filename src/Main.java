import java.util.Scanner;

import org.itstep.domain.Product;
import org.itstep.logic.ProductServiceImpl;
import org.itstep.storage.ProductStorage;
import org.itstep.storage.memory.ProductMemoryStorageImpl;
import org.itstep.ui.CommandManager;
import org.itstep.util.List;

public class Main {
	public static ProductServiceImpl getService() {
		ProductServiceImpl service = new ProductServiceImpl();
		ProductStorage storage = new ProductMemoryStorageImpl();
		service.setProductStorage(storage); // внедрение зависимости
		return service;
	}
	public static void output(List<Product> products) {
		System.out.println("*********************");
		for(int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
	}
	public static void main(String[] args) {
		/*
		ProductServiceImpl service = getService();
		Product product;
		product = new Product();
		product.setCategory("канцтовары");
		product.setName("Ручка");
		product.setPrice(23L);
		product.setAmount(15);
		service.save(product);
		product = new Product();
		product.setCategory("канцтовары");
		product.setName("Карандаш");
		product.setPrice(12L);
		product.setAmount(25);
		service.save(product);
		product = new Product();
		product.setCategory("товары для кухни");
		product.setName("Нож");
		product.setPrice(123L);
		product.setAmount(5);
		service.save(product);
		output(service.findAll());
		service.delete(2L);
		output(service.findAll());
		product = new Product();
		product.setCategory("товары для кухни");
		product.setName("Вилка");
		product.setPrice(14L);
		product.setAmount(50);
		service.save(product);
		output(service.findAll());
		product = new Product();
		product.setId(3L);
		product.setCategory("товары для кухни");
		product.setName("Нож");
		product.setPrice(1230L);
		product.setAmount(5);
		service.save(product);
		output(service.findAll());
		*/
		Scanner scanner = new Scanner(System.in);
		CommandManager manager = new CommandManager();
		while(true) {
			System.out.print("> ");
			String command = scanner.nextLine();
			manager.exec(command);
		}
	}
}