package io.datalbry.sample.api.connector.config

import io.datalbry.config.api.STRING_KEY
import io.datalbry.config.api.annotation.ConfigSchema
import io.datalbry.config.api.annotation.PropertyDescription
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.net.URI


@ConfigSchema
@ConstructorBinding
@ConfigurationProperties(prefix = "datalbry.sample.api")
data class SampleApiProperties(
    @PropertyDescription(
        key = "datalbry.sample.api.uri",
        group = "Sample API Instance",
        type = STRING_KEY,
        description = "The URL for the sample API instance",
        label = "URL",
        required = true
    )
    val uri: URI
)
