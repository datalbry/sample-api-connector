package io.datalbry.sample.api.connector.model

import io.datalbry.sample.api.client.model.PetToyId

fun PetToyKeyNode.toFeign() = PetToyId(id = id, petId = petId)