package com.luna.school;

import com.luna.school.initialisation.InitialisationDb;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SchoolApplication {

	private static final Logger logger = Logger.getLogger(SchoolApplication.class.getName());

	private static final String KEY_INITIALISATION_PATH = "school.init.db";

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SchoolApplication.class, args);
		SchoolApplication.initialisationDb(context);
	}

	private static void initialisationDb(ConfigurableApplicationContext context) {
		ConfigurableEnvironment contextEnvironment = context.getEnvironment();
		String initialisationDb = contextEnvironment.getProperty(KEY_INITIALISATION_PATH);
		if (Objects.nonNull(initialisationDb) && initialisationDb.equals("true")) {
			logger.info("Debut d'initialisation des données dans la base de données !");
			InitialisationDb initialisation = new InitialisationDb(context);
			initialisation.initialiser();
			logger.info("Fin d'initialisation des données dans la base de données !");
		}
	}
}


