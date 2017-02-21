package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.domain.omh.SchemaId;
import org.openmhealth.schema.domain.omh.SchemaSupport;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.time.OffsetDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Anders Borch
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Signature implements SchemaSupport {
    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "signature", "1.0");

    @JsonProperty("schema_id")
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String imageData;
    private OffsetDateTime creationDateTime;
    private ConsentDocument document;

    @SerializationConstructor
    protected Signature() {}

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageData() {
        return imageData;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public ConsentDocument getDocument() {
        return document;
    }
}
