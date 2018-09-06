package com.formation;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.user.ChatConsole;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String name = "toto";
		LocalDate date = LocalDate.of(2018, 9, 3);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ChatConsole interaction = applicationContext.getBean(ChatConsole.class);

		interaction.sendGoodbyeTo(name);
	}
}