package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.Project
import io.datalbry.sample.api.connector.model.ProjectDocument

fun Project.toDocument() = ProjectDocument(
    id = id,
    personId = personId,
    name = projectName,
    projectInformation = projectInformation.toRecord()
)