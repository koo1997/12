package polymorphism;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppleSpeaker implements Speaker {
	
	private static Logger log = LogManager.getLogger(AppleSpeaker.class);

	public AppleSpeaker() {
		log.debug("===> AppleSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		
		log.debug("AppleSpeaker---- 소리 올린다.");
	}

	@Override
	public void volumeDown() {

		log.debug("AppleSpeaker---- 소리 내린다.");
	}

}
