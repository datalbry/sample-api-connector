package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Id

data class PetToyKeyNode(
    @Id val id: String,
    @Id val petId: String,
)
