package com.luna.school.initialisation;

import java.util.logging.Logger;
import lombok.SneakyThrows;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author BOUA YVES 2024-05-23
 */
public class InitialisationDb {

  private static final Logger logger = Logger.getLogger(InitialisationDb.class.getName());

  private final ConfigurableApplicationContext context;

  public InitialisationDb(ConfigurableApplicationContext context) {
    this.context = context;
  }

  @SneakyThrows
  public void initialiser() {
    this.initialisationPays(context);
    this.initialiserEmailAdministrateur(context);
  }


  @SneakyThrows
  private void initialisationPays(ConfigurableApplicationContext context) {
    logger.info("Debut d'initialisation des pays !");
    PaysInitDb paysDb = new PaysInitDb(context);
    paysDb.execute();
    logger.info("Fin d'initialisation des pays !");
  }

  private void initialiserEmailAdministrateur(ConfigurableApplicationContext context) {
    logger.info("Debut d'initialisation des mails des administrateurs de Luna !");
    var parametrageEmailAdministrateurSchoolDb = new ParametrageEmailAdministrateurSchoolDb(context);
    parametrageEmailAdministrateurSchoolDb.execute();
    logger.info("Fin d'initialisation des mails des administrateurs de Luna !");
  }

}
