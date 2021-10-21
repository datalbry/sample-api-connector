package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.extensions.toFeign
import io.datalbry.sample.api.connector.model.PersonDocument
import io.datalbry.sample.api.connector.model.PersonKeyNode
import org.springframework.stereotype.Component

@Component
class PersonKeyNodeToPersonDocumentProcessor(private val client: SampleApiClient) :
    DocumentProcessor<PersonKeyNode, PersonDocument> {
    override fun process(edge: PersonKeyNode): Collection<PersonDocument> {
        return listOf(client.getPerson(edge.toFeign()).toDocument())
    }

}