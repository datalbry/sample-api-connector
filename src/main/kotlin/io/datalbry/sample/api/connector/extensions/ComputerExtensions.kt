package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.Computer
import io.datalbry.sample.api.connector.model.ComputerDocument

fun Computer.toDocument() = ComputerDocument(
    id = id,
    personId = personId,
    model = model,
)