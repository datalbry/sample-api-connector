package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.ComputerId
import io.datalbry.sample.api.connector.model.ComputerKeyNode

fun ComputerId.toKeyNode() = ComputerKeyNode(id = id, personId = personId)