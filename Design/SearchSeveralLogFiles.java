package Design;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.eclipse.jetty.websocket.common.frames.DataFrame;

import java.util.Arrays;
import java.util.List;

public class SearchSeveralLogFiles {
    public static void main(String[] args) {
        // Creates a DataFrame having a single column named "line"
        SparkSession sc = SparkSession.builder().appName("Simple Application").getOrCreate();
        List<StructField> fields = Arrays.asList(
                DataTypes.createStructField("line", DataTypes.StringType, true));
        StructType schema = DataTypes.createStructType(fields);
        Dataset<String> df = sc.read().schema(schema).textFile("hdfs://...");

        Dataset<String> errors = df.filter(df.col("line").like("%ERROR%"));
        // Counts all the errors
        errors.count();
        // Counts errors mentioning MySQL
        errors.filter(df.col("line").like("%MySQL%")).count();
        // Fetches the MySQL errors as an array of strings
        errors.filter(df.col("line").like("%MySQL%")).collect();

        sc.stop();
    }
}
