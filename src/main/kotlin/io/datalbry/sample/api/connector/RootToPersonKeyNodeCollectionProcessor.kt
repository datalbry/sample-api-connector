package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.connector.api.root.DocumentRoot
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toKeyNode
import io.datalbry.sample.api.connector.model.PersonKeyNodeContainer
import org.springframework.stereotype.Component

@Component
class RootToPersonKeyNodeCollectionProcessor(private val client: SampleApiClient) :
    DocumentProcessor<DocumentRoot, PersonKeyNodeContainer> {
    override fun process(edge: DocumentRoot): Collection<PersonKeyNodeContainer> {
        return listOf(
            PersonKeyNodeContainer(
                client.getPersonIds().asSequence().toList().map { it.toKeyNode() }
            )
        )
    }
}