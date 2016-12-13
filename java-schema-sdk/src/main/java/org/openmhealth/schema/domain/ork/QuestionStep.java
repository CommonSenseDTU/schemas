package org.openmhealth.schema.domain.ork;

import org.openmhealth.schema.serializer.SerializationConstructor;

/**
 * Created by Anders Borch on 09/12/16.
 */
public class QuestionStep extends Step {

    private QuestionType type;

    @SerializationConstructor
    protected QuestionStep() {}

    public static class Builder extends Step.Builder {

        private QuestionType type;

        public Builder(String id, QuestionType type) {

            super(id);
            this.type = type;
        }

        @Override
        public QuestionStep build() {
            return new QuestionStep(this);
        }
    }

    private QuestionStep(Builder builder) {

        super(builder);
        this.type = builder.type;
    }

}
