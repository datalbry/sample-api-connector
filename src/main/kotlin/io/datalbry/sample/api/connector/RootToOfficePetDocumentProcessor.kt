package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.connector.api.root.DocumentRoot
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.model.OfficePetDocument
import org.springframework.stereotype.Component

@Component
class RootToOfficePetDocumentProcessor(private val client: SampleApiClient) :
    DocumentProcessor<DocumentRoot, OfficePetDocument> {
    override fun process(edge: DocumentRoot): Collection<OfficePetDocument> {
        return client.getOfficePets().asSequence().toList().map { it.toDocument() }
    }
}