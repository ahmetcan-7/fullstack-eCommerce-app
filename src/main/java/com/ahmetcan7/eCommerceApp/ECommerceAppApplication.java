package com.ahmetcan7.eCommerceApp;


import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.repository.BrandRepository;
import com.ahmetcan7.eCommerceApp.repository.CategoryRepository;
import com.ahmetcan7.eCommerceApp.repository.ProductRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ECommerceAppApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final BrandRepository brandRepository;
	private final ProductRepository productRepository;

	public ECommerceAppApplication(CategoryRepository categoryRepository, BrandRepository brandRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceAppApplication.class, args);
	}

	//Swagger customize
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String description,
								 @Value("${application-version}") String version){
		return new OpenAPI()
				.info(new Info()
						.title("EcommerceApp API")
						.version(version)
						.description(description)
						.license(new License().name("EcommerceApp API Licence")));
	}


	@Override
	public void run(String... args) throws Exception {
		Category c1= new Category();
		c1.setId(1L);
		c1.setCategoryName("kirtasiye");

		Category c2=new Category();
		c2.setId(2L);
		c2.setCategoryName("kitap");

		categoryRepository.saveAll(Arrays.asList(c1,c2));

		Brand b1=new Brand();
		b1.setId(3L);
		b1.setBrandName("faber castel");

		Brand b2 = new Brand();
		b2.setId(4L);
		b2.setBrandName("iş bankası yayınları");

		brandRepository.saveAll(Arrays.asList(b1,b2));

		Product p1 = Product.builder()
				.id(1L)
				.category(c1)
				.brand(b1)
				.productName("kursun kalem")
				.discountRate(10)
				.price(30)
				.stock(25)
				.build();

		Product p2 = Product.builder()
				.id(2L)
				.category(c1)
				.brand(b1)
				.productName("dolma kalem")
				.discountRate(20)
				.price(40)
				.stock(15)
				.build();

		Product p3 = Product.builder()
				.id(3L)
				.category(c2)
				.brand(b2)
				.productName("hamlet")
				.discountRate(10)
				.price(30)
				.stock(25)
				.build();

		Product p4 = Product.builder()
				.id(4L)
				.category(c2)
				.brand(b2)
				.productName("yer altından notlar")
				.discountRate(10)
				.price(30)
				.stock(25)
				.build();

		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
