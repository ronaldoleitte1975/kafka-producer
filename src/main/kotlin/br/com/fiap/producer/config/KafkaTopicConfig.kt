package br.com.fiap.producer.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig {

    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String? = null

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = HashMap<String, Any?>()
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
        return KafkaAdmin(configs)
    }

    @Bean
    fun testTopic(): NewTopic {
        return NewTopic("testTopic", 1, 1.toShort())
    }
}
