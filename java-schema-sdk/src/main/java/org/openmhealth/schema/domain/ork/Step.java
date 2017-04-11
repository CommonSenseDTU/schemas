package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.domain.omh.DataPoint;
import org.openmhealth.schema.domain.omh.SchemaId;
import org.openmhealth.schema.domain.omh.SchemaSupport;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private String title;
    private String type;
    private List<String> sensors;
    private Map<String, Object> settings;

    @JsonProperty("private")
    private boolean isPrivate;

    private List<Map<String, Object>> items;

    @JsonProperty("skippable")
    private boolean isSkippable;

    @SerializationConstructor
    protected Step() {}

    public static class Builder {

        private String id;
        private String title;
        private String type;
        private List<String> sensors;
        private Map<String, Object> settings;
        private boolean isPrivate;
        private List<Map<String, Object>> items;
        private boolean isSkippable;

        public Builder(String id) {
            this.id = id;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setSensors(List<String> sensors) {
            this.sensors = sensors;
            return this;
        }

        public Builder setSettings(Map<String, Object> settings) {
            this.settings = settings;
            return this;
        }

        public Builder setPrivate(boolean aPrivate) {
            isPrivate = aPrivate;
            return this;
        }

        public Builder setItems(List<Map<String, Object>> items) {
            this.items = items;
            return this;
        }

        public Builder setSkippable(boolean skippable) {
            isSkippable = skippable;
            return this;
        }

        public Step build() {
            return new Step(this);
        }
    }

    protected Step(Builder builder) {

        this.id = builder.id;
        this.title = builder.title;
        this.type = builder.type;
        this.sensors = builder.sensors;
        this.settings = builder.settings;
        this.isPrivate = builder.isPrivate;
        this.items = builder.items;
        this.isSkippable = builder.isSkippable;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public List<String> getSensors() {
        return sensors;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public List<Map<String, Object>> getItems() {
        return items;
    }

    public boolean isSkippable() {
        return isSkippable;
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
