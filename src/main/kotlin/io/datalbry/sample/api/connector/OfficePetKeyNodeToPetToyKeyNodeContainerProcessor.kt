package io.datalbry.sample.api.connector

import io.datalbry.connector.api.document.DocumentProcessor
import io.datalbry.sample.api.client.feign.SampleApiClient
import io.datalbry.sample.api.connector.extensions.toKeyNode
import io.datalbry.sample.api.connector.model.OfficePetKeyNode
import io.datalbry.sample.api.connector.model.PetToyKeyNodeContainer
import org.springframework.stereotype.Component

@Component
class OfficePetKeyNodeToPetToyKeyNodeContainerProcessor(private val client: SampleApiClient) :
    DocumentProcessor<OfficePetKeyNode, PetToyKeyNodeContainer> {
    override fun process(edge: OfficePetKeyNode): Collection<PetToyKeyNodeContainer> {
        return listOf(
            PetToyKeyNodeContainer(
                client.getPetToysForOfficePet(edge.id).asSequence().toList().map { it.toKeyNode() }
            )
        )
    }

}