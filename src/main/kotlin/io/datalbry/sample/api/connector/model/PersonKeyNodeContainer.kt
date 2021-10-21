package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Children
import io.datalbry.connector.api.annotation.stereotype.Container

@Container
data class PersonKeyNodeContainer(
    @Children val collection: Collection<PersonKeyNode>
)
