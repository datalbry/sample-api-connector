package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Id
import io.datalbry.connector.api.annotation.stereotype.Document
import io.datalbry.precise.api.schema.SchemaAware

@SchemaAware
@Document
data class ProjectDocument(
    @Id val id: String,
    @Id val personId: String,
    val name: String,
    val projectInformation: ProjectInformationRecord
)
