package demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonStringConverter implements StringConverter {

	@Override
	public String toString(Object obj) {
	    ObjectMapper mapper = new ObjectMapper();
	    String result = "";
	    try {
	      result = mapper.writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(String.format("convert to json string error..,%s", e.toString()), e);
	    }
	    return result;
	}
}
