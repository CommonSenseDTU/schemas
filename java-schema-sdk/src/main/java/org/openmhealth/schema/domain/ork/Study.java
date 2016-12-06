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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.domain.omh.SchemaId;
import org.openmhealth.schema.domain.omh.SchemaSupport;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.time.OffsetDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Anders Borch on 03/12/16.
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Study implements SchemaSupport {
    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "survey", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private String guid;

    @SerializationConstructor
    protected Study() {
    }
    public static class Builder {

        private String id;
        private String guid;

        /**
         * @param id the identifier of the study
         * @param guid the globally unique identifier of the study
         */
        public Builder(String id, String guid) {

            this(id, guid, OffsetDateTime.now());
        }

        /**
         * @param id the identifier of the data point
         * @param guid the globally unique identifier of the study
         * @param creationDateTime the creation date time of this data point
         */
        public Builder(String id, String guid, OffsetDateTime creationDateTime) {

            checkNotNull(id, "An identifier hasn't been specified.");
            checkNotNull(guid, "A globally unique identifier hasn't been specified.");
            checkArgument(!id.isEmpty(), "An empty identifier has been specified.");
            checkNotNull(creationDateTime, "A creation date time hasn't been specified.");

            this.id = id;
            this.guid = guid;
        }

        public Study build() {
            return new Study(this);
        }
    }

    private Study(Builder builder) {

        this.id = builder.id;
        this.guid = builder.guid;
    }

    public String getId() {
        return id;
    }

    public String getGuid() {
        return guid;
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

        Study that = (Study) object;

        return guid.equals(that.guid);
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }

}
