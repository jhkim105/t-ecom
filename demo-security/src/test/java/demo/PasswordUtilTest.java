package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordUtilTest extends DemoSecurityApplicationTests {

	Log log = LogFactory.getLog(PasswordUtilTest.class);

	@Autowired
	PasswordUtil passwordUtil;

	@Test
	public void testEncodePassword() {
		log.debug(passwordUtil.encodePassword("1111"));
	}

}
