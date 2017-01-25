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
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Anders Borch
 */
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class InformedConsent implements SchemaSupport {

    public static final SchemaId SCHEMA_ID = new SchemaId(ORK_NAMEPACE, "informed-consent", "1.0");

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    private String id;
    private OffsetDateTime creationDateTime;

    /**
     * The document's title in a localized string.
     * <p>
     * The title appears only in the generated PDF for review; it is not used in the visual consent
     * process.
     */
    private String title;

    /**
     */
    private boolean canWithdraw;
    private boolean withdrawn;
    private Optional<OffsetDateTime> expiryDateTime;
    private Confidentiality confidentiality;
    private String surveyId;
    private String signatureId;

    @SerializationConstructor
    protected InformedConsent() {
    }

    public static class Builder {

        private String id;
        private OffsetDateTime creationDateTime;
        private String title;
        private boolean canWithdraw;
        private boolean withdrawn;
        private Optional<OffsetDateTime> expiryDateTime;
        private Confidentiality confidentiality;
        private String surveyId;
        private String signatureId;

        /**
         * @param id the identifier of the informed consent document
         * @param surveyGuid the globally unique identifier of the survey
         */
        public Builder(String id, String surveyGuid) {
            this(id, surveyGuid, OffsetDateTime.now());
        }

        /**
         * @param id the identifier of the data point
         * @param surveyId the identifier of the survey
         * @param creationDateTime the creation date time of this informed consent document
         */
        public Builder(String id, String surveyId, OffsetDateTime creationDateTime) {

            checkNotNull(id, "An identifier hasn't been specified.");
            checkArgument(!id.isEmpty(), "An empty identifier has been specified.");
            checkNotNull(surveyId, "A id hasn't been specified.");
            checkArgument(!surveyId.isEmpty(), "An empty id has been specified.");
            checkNotNull(creationDateTime, "A creation date time hasn't been specified.");

            this.id = id;
            this.surveyId = surveyId;
            this.creationDateTime = creationDateTime;
            this.withdrawn = false;
            this.canWithdraw = false;
            this.confidentiality = Confidentiality.PRIVATE;
        }

        /**
         * @param title the title of this document
         * @return this builder
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * @param canWithdraw true if the user can withdraw consent
         * @return this builder
         */
        public Builder setCanWithdraw(boolean canWithdraw) {
            this.canWithdraw = canWithdraw;
            return this;
        }

        public boolean isWithdrawn() {
            return withdrawn;
        }

        public Builder setWithdrawn(boolean withdrawn) {
            this.withdrawn = withdrawn;
            return this;
        }

        /**
         * @param expiryDateTime consent expiration date time or empty if consent has no expiration date
         * @return this builder
         */
        public Builder setExpiryDateTime(Optional<OffsetDateTime> expiryDateTime) {
            this.expiryDateTime = expiryDateTime;
            return this;
        }

        /**
         * @param confidentiality the confidentiality level of the data point
         * @return this builder
         */
        public Builder setConfidentiality(Confidentiality confidentiality) {
            this.confidentiality = confidentiality;
            return this;
        }

        public Builder setSignatureId(String signatureId) {
            this.signatureId = signatureId;
            return this;
        }

        public InformedConsent build() {
            return new InformedConsent(this);
        }
    }

    private InformedConsent(Builder builder) {
        this.id = builder.id;
        this.creationDateTime = builder.creationDateTime;
        this.title = builder.title;
        this.canWithdraw = builder.canWithdraw;
        this.withdrawn = builder.withdrawn;
        this.expiryDateTime = builder.expiryDateTime;
        this.confidentiality = builder.confidentiality;
        this.surveyId = builder.surveyId;
        this.signatureId = builder.signatureId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCanWithdraw() {
        return canWithdraw;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public Optional<OffsetDateTime> getExpiryDateTime() {
        return expiryDateTime;
    }

    public Confidentiality getConfidentiality() {
        return confidentiality;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public String getSignatureId() {
        return signatureId;
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

        InformedConsent that = (InformedConsent) object;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
