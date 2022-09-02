package polymorphism.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;


@Component("sony2")
public class SonySpeaker implements Speaker {
	
	// Slf4J
	private static Logger log = LoggerFactory.getLogger(SamsungTV.class);
	// Log4J2
	// private static Logger log = LogManager.getLogger(SonySpeaker.class);
	
	public SonySpeaker() {
		// System.out.println("===> SonySpeaker 객체 생성");
		log.debug("===> SonySpeaker 객체 생성");
	}

	public void volumeUp() {
		// System.out.println("SonySpeaker---소리 올린다.");
		log.debug("SonySpeaker---소리 올린다.");
	}

	public void volumeDown() {
		// System.out.println("SonySpeaker---소리 내린다.");
		log.debug("SonySpeaker---소리 내린다.");
	}
	
}