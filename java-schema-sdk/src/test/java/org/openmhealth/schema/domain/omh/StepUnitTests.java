package org.openmhealth.schema.domain.omh;

import org.openmhealth.schema.domain.ork.Step;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author Anders Borch
 */
public class StepUnitTests extends SerializationUnitTests {

    public static final String SCHEMA_FILENAME = "schema/ork/step-1.0.json";

    private Step step;

    @BeforeTest
    public void initializeFixture() {

        String id = "f249ae04-ee0d-46f1-a7db-701907d3b45c";

        step = new Step.Builder(id)
                .setTitle("Title")
                .setType("overview")
                .setSensors(new ArrayList<String>() {{
                    add("gps");
                    add("audio");
                    add("motion");
                }})
                .setPrivate(true)
                .setSkippable(true)
                .build();
    }

    @Override
    protected String getSchemaFilename() {
        return SCHEMA_FILENAME;
    }

    @Test
    public void objectShouldSerializeCorrectly() throws Exception {
        String document = "{\n" +
                "   \"id\": \"f249ae04-ee0d-46f1-a7db-701907d3b45c\",\n" +
                "   \"title\": \"Title\",\n" +
                "   \"type\": \"overview\",\n" +
                "   \"sensors\": [\"gps\", \"audio\", \"motion\"],\n" +
                "   \"private\": true,\n" +
                "   \"skippable\": true\n" +
                "}";

        serializationShouldCreateValidDocument(step, document);
        deserializationShouldCreateValidObject(document, step);
    }
}
