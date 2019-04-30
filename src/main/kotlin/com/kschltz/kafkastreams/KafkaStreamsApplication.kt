package com.kschltz.kafkastreams

import com.kschltz.kafkastreams.receiver.Receiver
import com.kschltz.kafkastreams.sender.Sender
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaStreamsApplication(val sender: Sender,
							  val receiver: Receiver):CommandLineRunner {

	override fun run(vararg args: String?) {
		receiver.listen()
		sender.send("Kaue")
	}
}

fun main(args: Array<String>){
	runApplication<KafkaStreamsApplication>(*args)
}
