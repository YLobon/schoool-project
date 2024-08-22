package com.luna.school.initialisation;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.luna.school.entite.PaysTable;
import com.luna.school.repository.JpaPaysRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

/**
 * @author BOUA YVES 2024-04-18
 */
public class PaysInitDb extends InitDb {

  private final JpaPaysRepository jpaPaysRepository;

  public PaysInitDb(ApplicationContext context) {
    this.jpaPaysRepository = context.getBean(JpaPaysRepository.class);
  }

  public void execute() throws IOException {
    InputStream fileStream = this.getFileStream("pays.xml");
    XmlMapper xmlMapper = buildXmlMapper();
    ListePays paysTemplate = xmlMapper.readValue(fileStream, ListePays.class);
    List<PaysTable> valeurs = paysTemplate.getPays();
    valeurs.forEach(paysTable -> {
      if (this.jpaPaysRepository.findByNom(paysTable.getNom()).isEmpty()) {
        this.jpaPaysRepository.save(paysTable);
      }
    });
  }

  @Getter
  @Setter
  static final class ListePays {

    private List<PaysTable> pays;
  }
}
