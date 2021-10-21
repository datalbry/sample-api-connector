package io.datalbry.sample.api.connector

import io.datalbry.alxndria.client.api.PlatformClient
import io.datalbry.alxndria.client.api.dto.Datasource
import io.datalbry.connector.api.DocumentEdge
import io.datalbry.connector.api.root.createRoot
import io.datalbry.connector.sdk.ConnectorApplication
import io.datalbry.connector.sdk.messaging.Channel
import io.datalbry.connector.sdk.test.ConnectorTestExtension
import io.datalbry.connector.sdk.test.awaitConvergence
import io.datalbry.connector.sdk.test.containsFields
import io.datalbry.connector.sdk.test.getAllDocumentsByDatasourceIdentiferOfType
import io.datalbry.precise.api.schema.document.generic.GenericField
import io.datalbry.precise.core.schema.factory.ReflectionSchemaFactory
import io.datalbry.sample.api.connector.extension.SampleApiConnectorTestExtension
import io.datalbry.sample.api.connector.model.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.Duration

@Testcontainers
@SpringBootTest(classes = [ConnectorApplication::class])
@ExtendWith(value = [ConnectorTestExtension::class, SampleApiConnectorTestExtension::class])
@DisplayName("Sample API Connector integration test")
class SampleApiConnectorTest {


    private val datasourceIdentifier = System.getProperty("io.datalbry.connector.alxndria.datasource")!!

    @Autowired
    lateinit var alxndria: PlatformClient

    @Autowired
    lateinit var addition: Channel<DocumentEdge>

    @Test
    fun iterate_startFromRoot_traversesDocuments() {
        val schema = ReflectionSchemaFactory().deriveSchema(
            PersonDocument::class.java,
            ComputerDocument::class.java,
            ProjectDocument::class.java,
            ProjectInformationRecord::class.java,
            OfficePetDocument::class.java,
            PetToyDocument::class.java,
        )

        alxndria.datasource.putDatasource(Datasource(datasourceIdentifier))
        alxndria.datasource.putSchema(datasourceIdentifier, schema)

        addition.propagate(createRoot())

        awaitConvergence(
            await = { alxndria.index.getDocumentIds(datasourceIdentifier).asSequence().toList().size },
            convergenceCriterion = { previous: Int, current: Int -> previous != current },
            timeout = Duration.ofMinutes(2),
            steps = Duration.ofSeconds(10),
        )

        test_traverseDocuments_notEmpty_containsExpectedFields<PersonDocument>(EXPECTED_PERSON_DOCUMENT_FIELDS)
        test_traverseDocuments_notEmpty_containsExpectedFields<ComputerDocument>(EXPECTED_COMPUTER_DOCUMENT_FIELDS)
        test_traverseDocuments_notEmpty_containsExpectedFields<ProjectDocument>(EXPECTED_PROJECT_DOCUMENT_FIELDS)
        test_traverseDocuments_notEmpty_containsExpectedFields<OfficePetDocument>(EXPECTED_OFFICE_PET_DOCUMENT_FIELDS)
        test_traverseDocuments_notEmpty_containsExpectedFields<PetToyDocument>(EXPECTED_PET_TOY_DOCUMENT_FIELDS)
    }


    private inline fun <reified DocumentType> test_traverseDocuments_notEmpty_containsExpectedFields(expectedFields: List<GenericField<*>>) {
        val documents = alxndria.getAllDocumentsByDatasourceIdentiferOfType<DocumentType>(datasourceIdentifier)
        assertTrue(
            documents.isNotEmpty(),
            "No documents for \"${DocumentType::class.simpleName}\" found"
        )
        assertTrue(
            documents.any { it.containsFields(expectedFields) },
            "No documents with expected fields for \"${DocumentType::class.simpleName}\" found"
        )
    }

    companion object {
        val EXPECTED_PERSON_DOCUMENT_FIELDS = listOf(
            GenericField(name = "id", value = "first"),
        )
        val EXPECTED_COMPUTER_DOCUMENT_FIELDS = listOf(
            GenericField(name = "personId", value = "first"),
            GenericField(name = "id", value = "aaac"),
            GenericField(name = "model", value = "Notebook 2020"),
        )
        val EXPECTED_PROJECT_DOCUMENT_FIELDS = listOf(
            GenericField(name = "personId", value = "first"),
            GenericField(name = "id", value = "ca"),
            GenericField(name = "name", value = "Super Duper Project"),
        )
        val EXPECTED_OFFICE_PET_DOCUMENT_FIELDS = listOf(
            GenericField(name = "name", value = "Broccoli"),
        )
        val EXPECTED_PET_TOY_DOCUMENT_FIELDS = listOf(
            GenericField(name="id", value="10"),
            GenericField(name="petId", value="p1"),
            GenericField(name="description", value="Ball"),
        )
    }
}