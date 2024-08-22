package com.luna.school.initialisation;


import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.springframework.core.io.ClassPathResource;

/**
 * @author BOUA YVES 2024-05-23
 */
public abstract class InitDb {

  private XmlMapper xmlMapper;

  protected InputStream getFileStream(String fileName) throws IOException {
    var classPathResource = new ClassPathResource("initdb/" + fileName);
    return classPathResource.getInputStream();
  }

  protected XmlMapper buildXmlMapper() {
    if (Objects.isNull(xmlMapper)) {
      var module = new JacksonXmlModule();
      module.setDefaultUseWrapper(false);
      this.xmlMapper = new XmlMapper(module);
    }
    return this.xmlMapper;
  }
}
