package org.example.app;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	final static String ENDPOINT = "https://platform.brexapis.com/interview/v1/transactions";
	final OkHttpClient client = new OkHttpClient();

	public String get(String url) {
		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			System.out.println("Unable to get from endpoint" + e);
		}
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		HashMap<String, Integer> hashMap = new HashMap<>();
		MainApplication mainApp = new MainApplication();
		String response = mainApp.get(ENDPOINT);
		System.out.println(hashMap);
	}

		@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
}