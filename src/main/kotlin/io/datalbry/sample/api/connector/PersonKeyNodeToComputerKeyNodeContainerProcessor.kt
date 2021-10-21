package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toDocument
import io.datalbry.sample.api.connector.extensions.toFeign
import io.datalbry.sample.api.connector.extensions.toKeyNode
import io.datalbry.sample.api.connector.model.ComputerKeyNodeContainer
import io.datalbry.sample.api.connector.model.PersonDocument
import io.datalbry.sample.api.connector.model.PersonKeyNode
import org.springframework.stereotype.Component

@Component
class PersonKeyNodeToComputerKeyNodeContainerProcessor(private val client: SampleApiClient) :
    DocumentProcessor<PersonKeyNode, ComputerKeyNodeContainer> {
    override fun process(edge: PersonKeyNode): Collection<ComputerKeyNodeContainer> {
        return listOf(
            ComputerKeyNodeContainer(
                client.getComputerIds(edge.toFeign()).asSequence().toList().map {it.toKeyNode() }
            )
        )
    }

}