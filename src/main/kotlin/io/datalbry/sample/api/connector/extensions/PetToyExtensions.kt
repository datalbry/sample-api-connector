package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.PetToy
import io.datalbry.sample.api.connector.model.PetToyDocument

fun PetToy.toDocument() = PetToyDocument(
    id = id,
    petId = petId,
    description = description,
)