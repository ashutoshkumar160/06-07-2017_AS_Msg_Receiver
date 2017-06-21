package org.stackroute.consumer;

import java.util.concurrent.CountDownLatch;

import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.model.Car;

public class AsMsgReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${topic.json}")
	public void msgReceive(Car car) {
		LOGGER.info("received car='{}'", car.toString());
		latch.countDown();
	}
}
