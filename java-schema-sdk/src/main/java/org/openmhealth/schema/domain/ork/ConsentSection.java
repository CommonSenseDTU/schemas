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
public class ConsentSection implements SchemaSupport {

    public static final SchemaId SCHEMA_ID = new SchemaId(ORK_NAMEPACE, "consent-section", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime modificationDateTime;
    private ConsentSectionType type;
    private String title;
    private String summary;
    private String content;
    private String popup;
    private ArrayList<String> options;

    @SerializationConstructor
    protected ConsentSection() {}

    public static class Builder {
        private String id;
        private OffsetDateTime creationDateTime;
        private OffsetDateTime modificationDateTime;
        private ConsentSectionType type;
        private String title;
        private String summary;
        private String content;
        private String popup;

        public Builder(String id, ConsentSectionType type, OffsetDateTime creationDateTime, OffsetDateTime modificationDateTime) {

            this.id = id;
            this.type = type;
            this.creationDateTime = creationDateTime;
            this.modificationDateTime = modificationDateTime;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setPopup(String popup) {
            this.popup = popup;
            return this;
        }

        public ConsentSection build() {
            return new ConsentSection(this);
        }
    }

    private ConsentSection(Builder builder) {

        this.id = builder.id;
        this.type = builder.type;
        this.creationDateTime = builder.creationDateTime;
        this.modificationDateTime = builder.modificationDateTime;
        this.title = builder.title;
        this.summary = builder.summary;
        this.content = builder.content;
        this.popup = builder.popup;
    }

    public String getId() {
        return id;
    }

    public ConsentSectionType getType() {
        return type;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public OffsetDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setModificationDateTime(OffsetDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public String getPopup() {
        return popup;
    }

    public ArrayList<String> getOptions() {
        return options;
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

        ConsentSection that = (ConsentSection) object;

        if (!creationDateTime.equals(that.creationDateTime)) {
            return false;
        }

        if (!modificationDateTime.equals(that.modificationDateTime)) {
            return false;
        }

        if (!title.equals(that.title)) {
            return false;
        }

        if (summary != null && !summary.equals(that.summary)) {
            return false;
        } else if (that.summary != null) {
            return false;
        }

        if (content != null && !content.equals(that.content)) {
            return false;
        } else if (that.content != null) {
            return false;
        }

        if (popup != null && !popup.equals(that.popup)) {
            return false;
        } else if (that.popup != null) {
            return false;
        }

        if (options != null && !options.equals(that.options)) {
            return false;
        } else if (that.options != null) {
            return false;
        }

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + creationDateTime.hashCode();
        result = 31 * result + modificationDateTime.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + popup.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }
}
