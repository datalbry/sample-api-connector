package io.datalbry.sample.api.connector.config

import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.client.feign.SampleApiClientConfig
import io.datalbry.sample.api.client.feign.SampleApiClientFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(SampleApiProperties::class)
open class SampleApiConnectorConfig {

    @Bean
    open fun clockifyClient(properties: SampleApiProperties): SampleApiClient {
        val config = SampleApiClientConfig(properties.uri)
        return SampleApiClientFactory().create(config)
    }

}