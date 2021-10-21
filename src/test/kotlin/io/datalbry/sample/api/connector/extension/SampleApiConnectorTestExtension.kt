package io.datalbry.sample.api.connector.extension

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SampleApiConnectorTestExtension : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        System.setProperty("datalbry.sample.api.uri", System.getenv("sample-api-uri"))
    }
}