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
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Anders Borch on 03/12/16.
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Survey implements SchemaSupport {
    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "survey", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private String userId;
    private OffsetDateTime creationDateTime;
    private ConsentDocument consentDocument;
    private Task task;
    private List<String> participantIds;

    @SerializationConstructor
    protected Survey() {
    }
    public static class Builder {

        private String id;
        private String userId;
        private OffsetDateTime creationDateTime;
        private ConsentDocument consentDocument;
        private Task task;
        private List<String> participantIds;

        /**
         * @param id the identifier of the survey
         * @param userId the identifier of the user owning the survey
         */
        public Builder(String id, String guid, String userId) {

            this(id, guid, userId, OffsetDateTime.now());
        }

        /**
         * @param id the identifier of the data point
         * @param userId the identifier of the user owning the survey
         * @param creationDateTime the creation date time of this data point
         */
        public Builder(String id, String guid, String userId, OffsetDateTime creationDateTime) {

            checkNotNull(id, "An identifier hasn't been specified.");
            checkNotNull(guid, "A globally unique identifier hasn't been specified.");
            checkNotNull(userId, "A user identifier hasn't been specified.");
            checkArgument(!id.isEmpty(), "An empty identifier has been specified.");
            checkNotNull(creationDateTime, "A creation date time hasn't been specified.");

            this.id = id;
            this.userId = userId;
            this.creationDateTime = creationDateTime;
        }

        public Builder setParticipantIds(List<String> participantIds) {
            this.participantIds = participantIds;
            return this;
        }

        public Builder setConsentDocument(ConsentDocument consentDocument) {
            this.consentDocument = consentDocument;
            return this;
        }

        public Builder setTask(Task task) {
            this.task = task;
            return this;
        }

        public Survey build() {
            return new Survey(this);
        }
    }

    private Survey(Builder builder) {

        this.id = builder.id;
        this.userId = builder.userId;
        this.creationDateTime = builder.creationDateTime;
        this.consentDocument = builder.consentDocument;
        this.task = builder.task;
        this.participantIds = builder.participantIds;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public ConsentDocument getConsentDocument() {
        return consentDocument;
    }

    public Task getTask() {
        return task;
    }

    public List<String> getParticipantIds() {
        return participantIds;
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

        Survey that = (Survey) object;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
