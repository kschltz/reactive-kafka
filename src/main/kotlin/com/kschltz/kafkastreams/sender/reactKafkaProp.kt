package com.kschltz.kafkastreams.sender

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "reactor-kafka")
class reactKafkaProp( var props :HashMap<String,Any>)
