package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.ProjectInformation
import io.datalbry.sample.api.connector.model.ProjectInformationRecord

fun ProjectInformation.toRecord() = ProjectInformationRecord(
    numberCommits = numberCommits,
    numberCollaborators = numberCollaborators,
    hostingPlatform = hostingPlatform,
)