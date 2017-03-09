package org.openmhealth.schema.domain.omh;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Anders Borch
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ParticipationMetaData implements SchemaSupport {

    public static final SchemaId SCHEMA_ID = new SchemaId(ORK_NAMEPACE, "participation-meta-data", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private String surveyId;
    private String userId;
    private Map<String, Object> data;

    @SerializationConstructor
    protected ParticipationMetaData() {}

    public String getId() {
        return id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ParticipationMetaData that = (ParticipationMetaData) object;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
