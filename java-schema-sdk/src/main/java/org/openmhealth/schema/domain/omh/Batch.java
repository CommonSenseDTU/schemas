package org.openmhealth.schema.domain.omh;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.openmhealth.schema.domain.omh.SchemaSupport.OMH_NAMESPACE;

/**
 * A data point.
 *
 * @author Anders Borch
 * @version 1.0
 * @see <a href="http://www.openmhealth.org/documentation/#/schema-docs/schema-library/schemas/omh_batch">batch</a>
 */
public class Batch<T> implements SchemaSupport {
    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "data-point", "1.0");

    private String id; // this is duplicated from the header to make Spring Data happy
    private DataPointHeader header;
    private ArrayList<DataPoint<T>> dataPoints;

    @SerializationConstructor
    protected Batch() {}

    /**
     * @param header the header common to the data points in the list
     * @param dataPoints the list of data points
     */
    @JsonCreator
    public Batch(@JsonProperty("header") DataPointHeader header, @JsonProperty("data_points") ArrayList<DataPoint<T>> dataPoints) {

        checkNotNull(dataPoints, "Data points haven't been specified.");

        this.id = header.getId();
        this.header = header;
        this.dataPoints = dataPoints;
    }

    public DataPointHeader getHeader() {
        return header;
    }

    public ArrayList<DataPoint<T>> getDataPoints() {
        return dataPoints;
    }

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
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

        Batch<?> that = (Batch<?>) object;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!header.equals(that.header)) {
            return false;
        }
        return dataPoints.equals(that.dataPoints);
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + header.hashCode();
        result = 31 * result + dataPoints.hashCode();
        return result;
    }

}
