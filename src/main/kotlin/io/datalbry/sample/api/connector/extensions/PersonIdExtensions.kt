package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.PersonId
import io.datalbry.sample.api.connector.model.PersonKeyNode

fun PersonId.toKeyNode() = PersonKeyNode(id = id)