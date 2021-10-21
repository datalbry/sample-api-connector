package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Id
import io.datalbry.connector.api.annotation.stereotype.Document
import io.datalbry.precise.api.schema.SchemaAware

@SchemaAware
@Document
data class PetToyDocument(
    @Id val id: String,
    @Id val petId: String,
    val description: String,
)
