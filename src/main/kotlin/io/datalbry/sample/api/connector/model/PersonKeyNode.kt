package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Id

data class PersonKeyNode(
    @Id val id: String
)
