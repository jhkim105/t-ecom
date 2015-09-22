package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiController {

	@Autowired
	@Qualifier("jsonStringConverter")
	private StringConverter jConverter;

	@Autowired
	@Qualifier("xmlStringConverter")
	private StringConverter xConverter;

	@RequestMapping("/toJson")
	@ResponseBody
	public String toJsonString() {
		DateVO result = new DateVO();
		return jConverter.toString(result);
	}

	@RequestMapping("/toXml")
	@ResponseBody
	public String toXmlString() {
		DateVO result = new DateVO();
		return xConverter.toString(result);
	}

}
