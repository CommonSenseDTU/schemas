/*
 * Copyright 2016 Open mHealth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openmhealth.schema.domain.ork;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openmhealth.schema.domain.omh.SchemaEnumValue;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anders Borch on 01/12/16.
 */
public enum Confidentiality implements SchemaEnumValue {
    PRIVATE, INDIVIDUAL_STUDY, PUBLIC;

    private String schemaValue;
    private static final Map<String, Confidentiality> constantsBySchemaValue = new HashMap<>();

    static {
        for (Confidentiality constant : values()) {
            constantsBySchemaValue.put(constant.getSchemaValue(), constant);
        }
    }

    Confidentiality() {
        this.schemaValue = name().toLowerCase().replace('_', ' ');
    }

    @Override
    @JsonValue
    public String getSchemaValue() {
        return this.schemaValue;
    }

    @Nullable
    @JsonCreator
    public static Confidentiality findBySchemaValue(String schemaValue) {
        return constantsBySchemaValue.get(schemaValue);
    }
}
