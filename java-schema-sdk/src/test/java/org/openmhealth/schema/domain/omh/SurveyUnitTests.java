package org.openmhealth.schema.domain.omh;

import org.openmhealth.schema.domain.ork.ConsentDocument;
import org.openmhealth.schema.domain.ork.Survey;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import static java.time.ZoneOffset.UTC;

/**
 * Created by Anders Borch on 03/01/17.
 */
public class SurveyUnitTests extends SerializationUnitTests {

    public static final String SCHEMA_FILENAME = "schema/ork/survey-1.0.json";

    private Survey survey;

    @BeforeTest
    public void initializeFixture() {

        String id = "f249ae04-ee0d-46f1-a7db-701907d3b45b";
        String guid = "e3f52f69-0a8e-438c-ab71-8a89efdbc73e";
        String docid = "9d81e5db-831f-4ac2-a0fa-2434a13fb52d";
        SchemaId schemaId = new SchemaId("ork", "survey", "1.0");
        OffsetDateTime creationDateTime = OffsetDateTime.of(2013, 2, 5, 7, 30, 0, 0, UTC);

        survey = new Survey.Builder(id, guid, "testUser", creationDateTime)
                .setParticipantIds(new ArrayList<String>())
                .setConsentDocument(
                        new ConsentDocument.Builder(docid, creationDateTime, creationDateTime).build()
                )
                .build();
    }

    @Override
    protected String getSchemaFilename() {
        return SCHEMA_FILENAME;
    }

    @Test
    public void objectShouldSerializeCorrectly() throws Exception {
        String document = "{\n" +
                "   \"id\": \"f249ae04-ee0d-46f1-a7db-701907d3b45b\",\n" +
                "   \"user_id\": \"testUser\",\n" +
                "   \"creation_date_time\": \"2013-02-05T07:30:00Z\",\n" +
                "   \"consent_document\": {\n" +
                "       \"id\": \"9d81e5db-831f-4ac2-a0fa-2434a13fb52d\",\n" +
                "       \"creation_date_time\": \"2013-02-05T07:30:00Z\",\n" +
                "       \"modification_date_time\": \"2013-02-05T07:30:00Z\",\n" +
                "       \"sections\": []\n" +
                "   },\n" +
                "   \"participant_ids\": []\n" +
                "}";

        serializationShouldCreateValidDocument(survey, document);
        deserializationShouldCreateValidObject(document, survey);
    }
}
