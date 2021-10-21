package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.ComputerId
import io.datalbry.sample.api.connector.model.ComputerKeyNode

fun ComputerKeyNode.toFeign() = ComputerId(id = id, personId = personId)