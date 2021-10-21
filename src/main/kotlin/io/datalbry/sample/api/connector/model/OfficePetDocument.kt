package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Children
import io.datalbry.connector.api.annotation.property.Id
import io.datalbry.connector.api.annotation.stereotype.Document
import io.datalbry.precise.api.schema.Exclude
import io.datalbry.precise.api.schema.SchemaAware


@SchemaAware
@Document
data class OfficePetDocument(
    @Id val id: String,
    @Children @Exclude val keyNode: OfficePetKeyNode,
    val name: String,
    val type: String,
)


