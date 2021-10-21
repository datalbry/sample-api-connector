package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.extensions.toFeign
import io.datalbry.sample.api.connector.model.PersonKeyNode
import io.datalbry.sample.api.connector.model.ProjectDocument
import org.springframework.stereotype.Component

@Component
class PersonKeyNodeToProjectDocumentProcessor(private val client: SampleApiClient) :
    DocumentProcessor<PersonKeyNode, ProjectDocument> {
    override fun process(edge: PersonKeyNode): Collection<ProjectDocument> {
        return client.getProjects(edge.toFeign()).asSequence().toList().map { it.toDocument() }
    }

}