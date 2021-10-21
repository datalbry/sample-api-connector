package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.model.PetToyDocument
import io.datalbry.sample.api.connector.model.PetToyKeyNode
import io.datalbry.sample.api.connector.model.toFeign
import org.springframework.stereotype.Component

@Component
class PetToyKeyNodeToPetToyDocumentProcessor(private val client: SampleApiClient) :
    DocumentProcessor<PetToyKeyNode, PetToyDocument> {
    override fun process(edge: PetToyKeyNode): Collection<PetToyDocument> {
        return listOf(
            client.getPetToy(edge.toFeign()).toDocument()
        )
    }
}