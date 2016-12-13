package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openmhealth.schema.domain.omh.SchemaEnumValue;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anders Borch on 12/12/16.
 */
public enum ConsentSectionType implements SchemaEnumValue {
    OVERVIEW,
    DATAGATHERING,
    PRIVACY,
    DATAUSE,
    TIMECOMMITMENT,
    STUDYSURVEY,
    STUDYTASKS,
    WITHDRAWING,
    CUSTOM,
    ONLYINDOCUMENT;

    private String schemaValue;
    private static final Map<String, ConsentSectionType> constantsBySchemaValue = new HashMap<>();

    static {
        for (ConsentSectionType constant : values()) {
            constantsBySchemaValue.put(constant.getSchemaValue(), constant);
        }
    }

    ConsentSectionType() {
        this.schemaValue = name().toLowerCase().replace('_', ' ');
    }

    @Override
    @JsonValue
    public String getSchemaValue() {
        return this.schemaValue;
    }

    @Nullable
    @JsonCreator
    public static ConsentSectionType findBySchemaValue(String schemaValue) {
        return constantsBySchemaValue.get(schemaValue);
    }
}
