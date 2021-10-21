package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.extensions.toFeign
import io.datalbry.sample.api.connector.model.ComputerDocument
import io.datalbry.sample.api.connector.model.ComputerKeyNode
import org.springframework.stereotype.Component

@Component
class ComputerKeyNodeToComputerDocumentProcessor(private val client: SampleApiClient) :
    DocumentProcessor<ComputerKeyNode, ComputerDocument> {
    override fun process(edge: ComputerKeyNode): Collection<ComputerDocument> {
        return listOf(
            client.getComputer(edge.toFeign()).toDocument()
        )
    }

}