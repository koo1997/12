package polymorphism;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsungTV implements TV {
	
	// Slf4J
	private static Logger log = LoggerFactory.getLogger(SamsungTV.class);
	// Log4J2
	// private static Logger log = LogManager.getLogger(SamsungTV.class);
	
	// private SonySpeaker speaker;
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		// System.out.println("===> SamsungTV 객체 생성");
		log.debug("===> SamsungTV(1) 객체 생성");
	}
	
	// public SamsungTV(SonySpeaker speaker) {
	public SamsungTV(Speaker speaker) {
		// System.out.println("===> SamsungTV 객체 생성");
		log.debug("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	// public SamsungTV(SonySpeaker speaker, int price) {
	public SamsungTV(Speaker speaker, int price) {
		// System.out.println("===> SamsungTV 객체 생성");
		log.debug("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void powerOn() {
		// System.out.println("SamsungTV---전원 켠다.");
		// log.debug("SamsungTV---전원 켠다. (가격 : " + price + ")");
		log.debug("SamsungTV---전원 켠다. (가격 : {})", price);
	}

	public void powerOff() {
		// System.out.println("SamsungTV---전원 끈다.");
		log.debug("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}

	public static void setLog(Logger log) {
		SamsungTV.log = log;
	}

	public void setSpeaker(Speaker speaker) {
		log.debug("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		log.debug("===> setPrice() 호출");
		this.price = price;
	}
	
}
