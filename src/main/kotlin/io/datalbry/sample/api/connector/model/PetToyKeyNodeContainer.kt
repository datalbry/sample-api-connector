package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Children
import io.datalbry.connector.api.annotation.stereotype.Container

@Container
data class PetToyKeyNodeContainer(
    @Children val collection: Collection<PetToyKeyNode>
)
