/*
 * Copyright 2015 Open mHealth
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

package org.openmhealth.schema.domain;

import org.testng.annotations.BeforeClass;

import static java.math.BigDecimal.TEN;
import static org.openmhealth.schema.domain.MassUnit.KILOGRAM;


/**
 * @author Emerson Farrugia
 */
public class MassUnitValueUnitTests extends DataProvidingSerializationUnitTests {

    public static final String SCHEMA_FILENAME = "schema/omh/mass-unit-value-1.0.json";

    @Override
    protected String getSchemaFilename() {
        return SCHEMA_FILENAME;
    }

    @BeforeClass
    public void addSerializationTuples() {

        addSerializationTuple("{\"unit\":\"kg\",\"value\":10}", new MassUnitValue(KILOGRAM, TEN));
    }
}
