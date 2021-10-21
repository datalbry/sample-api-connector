package io.datalbry.sample.api.connector.model

import io.datalbry.connector.api.annotation.property.Children
import io.datalbry.connector.api.annotation.stereotype.Container

@Container
data class ComputerKeyNodeContainer(
    @Children val collection: Collection<ComputerKeyNode>

)