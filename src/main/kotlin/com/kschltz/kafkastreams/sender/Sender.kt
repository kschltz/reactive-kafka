package com.kschltz.kafkastreams.sender

import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderRecord
import reactor.kafka.sender.SenderRecord.create
import java.time.Duration.ofMillis
import java.time.LocalDateTime.now
import java.util.stream.Stream

@Service
class Sender(val sender: KafkaSender<Int,String>) {

    fun send(name:String){
        val infiniteIntegerStream = Flux.fromStream(Stream.iterate(1) { it + 1 })
        sender.send(infiniteIntegerStream.map { createRecords("It is I: $it $name") })
                .delayElements(ofMillis(1))
                .subscribe()
    }
    fun createRecords(msg:String): SenderRecord<Int, String,String> {
      return create( ProducerRecord<Int,String>("topic-zero",msg),"time: ${now()}")
    }
}