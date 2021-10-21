package io.datalbry.sample.api.connector.extensions

import io.datalbry.sample.api.client.model.Person
import io.datalbry.sample.api.connector.model.PersonDocument

fun Person.toDocument() = PersonDocument(
    id = id,
    name = name
)