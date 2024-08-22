package com.luna.school.initialisation;

import com.luna.school.luna.ParametrageEmailAdministrateurSchoolTable;
import com.luna.school.luna.TypeAdministrateurLuna;
import com.luna.school.repository.JpaParametrageEmailAdministrateurSchoolRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

/**
 * @author BOUA YVES 2023-05-23
 */
public class ParametrageEmailAdministrateurSchoolDb {

  private final JpaParametrageEmailAdministrateurSchoolRepository
      jpaParametrageEmailAdministrateurSchoolRepository;

  public ParametrageEmailAdministrateurSchoolDb(ApplicationContext context) {
    this.jpaParametrageEmailAdministrateurSchoolRepository = context
        .getBean(JpaParametrageEmailAdministrateurSchoolRepository.class);
  }

  public void execute() {
    this.enregistrerEmail();
  }

  private void enregistrerEmail() {
    List<InformationEmail> informationEmails = List.of(
        new InformationEmail("yveslobon96@gmail.com", "0142804744",true,
            TypeAdministrateurLuna.TECHNIQUE),
        new InformationEmail("yveslobon96@gmail.com","0709793478", true,
            TypeAdministrateurLuna.DIRECTION),
        new InformationEmail("zahiatoubamba@gmail.com", "07890000",true,
            TypeAdministrateurLuna.DIRECTION),
        new InformationEmail("ketohafranck@gmail.com","078925639874", true,
            TypeAdministrateurLuna.TECHNIQUE)
    );
    for (InformationEmail parametreEmail : informationEmails) {
      if (!emailExistePourType(parametreEmail.getEmail(), parametreEmail.getType())) {
        var paramEmail = new ParametrageEmailAdministrateurSchoolTable();
        paramEmail.setId(UUID.randomUUID());
        paramEmail.setEmail(parametreEmail.getEmail());
        paramEmail.setContact(parametreEmail.getContact());
        paramEmail.setActif(true);
        paramEmail.setType(parametreEmail.getType());
        jpaParametrageEmailAdministrateurSchoolRepository.save(paramEmail);
      }
    }
  }

  private boolean emailExistePourType(String email, TypeAdministrateurLuna type) {
    return jpaParametrageEmailAdministrateurSchoolRepository.existsByEmailAndType(email, type);
  }

  @Setter
  @Getter
  @AllArgsConstructor
  public static class InformationEmail {

    private String email;
    private String contact;
    private boolean actif;
    private TypeAdministrateurLuna type;
  }
}
