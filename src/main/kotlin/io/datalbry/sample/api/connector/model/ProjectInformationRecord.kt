package io.datalbry.sample.api.connector.model

import io.datalbry.precise.api.schema.SchemaAware

@SchemaAware
data class ProjectInformationRecord(
    val numberCommits: Int,
    val numberCollaborators: Int,
    val hostingPlatform: String
)
