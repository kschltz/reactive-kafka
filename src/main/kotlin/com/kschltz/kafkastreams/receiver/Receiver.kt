package com.kschltz.kafkastreams.receiver

import com.kschltz.kafkastreams.sender.reactKafkaProp
import org.springframework.stereotype.Service
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverOptions

@Service
class Receiver(val reactKafkaProp: reactKafkaProp) {

        fun listen() {
            val receiverOptions = ReceiverOptions.create<Int, String>(reactKafkaProp.props)
            receiverOptions.subscription(listOf("topic-zero"))
            KafkaReceiver.create(receiverOptions)
                    .receive()
                    .log()
                    .subscribe()
        }
}