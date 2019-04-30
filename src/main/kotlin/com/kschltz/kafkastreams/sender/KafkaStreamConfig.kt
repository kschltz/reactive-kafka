package com.kschltz.kafkastreams.sender

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaStreamConfig(val reactKafkaProp: reactKafkaProp) {

    @Bean
    fun kafkasender():KafkaSender<Int,String>{
        val senderOptions = SenderOptions.create<Int,String>(reactKafkaProp.props)
        senderOptions.maxInFlight(2)
      return  KafkaSender.create(senderOptions)
    }



}