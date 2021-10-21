package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.PetToyId
import io.datalbry.sample.api.connector.model.PetToyKeyNode

fun PetToyId.toKeyNode() = PetToyKeyNode(id = id, petId = petId)