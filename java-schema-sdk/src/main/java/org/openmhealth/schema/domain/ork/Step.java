package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.domain.omh.DataPoint;
import org.openmhealth.schema.domain.omh.SchemaId;
import org.openmhealth.schema.domain.omh.SchemaSupport;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.openmhealth.schema.domain.omh.SchemaSupport.ORK_NAMEPACE;

/**
 * Created by Anders Borch on 09/12/16.
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Step implements SchemaSupport {

    public static final SchemaId SCHEMA_ID = new SchemaId(ORK_NAMEPACE, "step", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;

    @SerializationConstructor
    protected Step() {}

    public static class Builder {

        private String id;

        public Builder(String id) {
            this.id = id;
        }

        public Step build() {
            return new Step(this);
        }
    }

    protected Step(Builder builder) {

        this.id = builder.id;
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

        Step that = (Step) object;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
