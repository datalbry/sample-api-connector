package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.OfficePet
import io.datalbry.sample.api.connector.model.OfficePetDocument
import io.datalbry.sample.api.connector.model.OfficePetKeyNode

fun OfficePet.toDocument() = OfficePetDocument(
    id = id,
    keyNode = OfficePetKeyNode(id),
    name = name,
    type = type,
)