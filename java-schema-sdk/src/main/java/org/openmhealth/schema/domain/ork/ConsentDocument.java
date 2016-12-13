package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.domain.omh.SchemaId;
import org.openmhealth.schema.domain.omh.SchemaSupport;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Created by Anders Borch on 09/12/16.
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ConsentDocument implements SchemaSupport {

    public static final SchemaId SCHEMA_ID = new SchemaId(ORK_NAMEPACE, "consent-document", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime modificationDateTime;
    private List<ConsentSection> sections;

    @SerializationConstructor
    protected ConsentDocument() {}

    public static class Builder {
        private String id;
        private OffsetDateTime creationDateTime;
        private OffsetDateTime modificationDateTime;
        private List<ConsentSection> sections;

        public Builder(String id, OffsetDateTime creationDateTime, OffsetDateTime modificationDateTime) {

            this.id = id;
            this.creationDateTime = creationDateTime;
            this.modificationDateTime = modificationDateTime;
            sections = new ArrayList<ConsentSection>();
        }

        public Builder setSections(List<ConsentSection> sections) {
            this.sections = sections;
            return this;
        }

        public Builder addSection(ConsentSection section) {
            sections.add(section);
            return this;
        }

         public ConsentDocument build() {
            return new ConsentDocument(this);
         }
    }

    private ConsentDocument(Builder builder) {

        this.id = builder.id;
        this.creationDateTime = builder.creationDateTime;
        this.modificationDateTime = builder.modificationDateTime;
        this.sections = builder.sections;
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setModificationDateTime(OffsetDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public OffsetDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public List<ConsentSection> getSections() {
        return sections;
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

        ConsentDocument that = (ConsentDocument) object;

        if (!creationDateTime.equals(that.creationDateTime)) {
            return false;
        }

        if (!modificationDateTime.equals(that.modificationDateTime)) {
            return false;
        }

        if (!sections.equals(that.sections)) {
            return false;
        }

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + creationDateTime.hashCode();
        result = 31 * result + modificationDateTime.hashCode();
        result = 31 * result + (sections != null ? sections.hashCode() : 0);
        return result;
    }

}
