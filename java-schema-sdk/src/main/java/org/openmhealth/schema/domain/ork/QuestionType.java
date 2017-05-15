package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openmhealth.schema.domain.omh.SchemaEnumValue;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anders Borch on 09/12/16.
 */
public enum QuestionType implements SchemaEnumValue {
    NONE,
    SCALE,
    SINGLECHOICE,
    MULTIPLECHOICE,
    DECIMAL,
    INTEGER,
    BOOLEAN,
    TEXT,
    TIMEOFDAY,
    DATEANDTIME,
    DATE,
    TIMEINTERVAL,
    LOCATION,
    IMAGECHOICE;

    private String schemaValue;
    private static final Map<String, QuestionType> constantsBySchemaValue = new HashMap<>();

    static {
        for (QuestionType constant : values()) {
            constantsBySchemaValue.put(constant.getSchemaValue(), constant);
        }
    }

    QuestionType() {
        this.schemaValue = name().toLowerCase().replace('_', ' ');
    }

    @Override
    @JsonValue
    public String getSchemaValue() {
        return this.schemaValue;
    }

    @Nullable
    @JsonCreator
    public static QuestionType findBySchemaValue(String schemaValue) {
        return constantsBySchemaValue.get(schemaValue);
    }
}
