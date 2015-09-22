package demo;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

@Component
public class XmlStringConverter implements StringConverter {

	@Override
	public String toString(Object obj) {
	    StringWriter writer = new StringWriter();
	    try {
	      JAXBContext context = JAXBContext.newInstance(obj.getClass());
	      Marshaller m = context.createMarshaller();
	      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
	      m.marshal(obj, writer);
	    } catch (Exception ex) {
	      throw new RuntimeException(String.format("object convert to xml string error..,%s", ex.toString()), ex);
	    }
	    return writer.toString();
	}

}
