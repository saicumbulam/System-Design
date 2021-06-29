package Design;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.util.*;
import scala.Tuple2;

import java.nio.file.Paths;
import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        String logFile = "YOUR_SPARK_HOME/README.md"; // Should be some file on your system
        SparkSession sc = SparkSession.builder().appName("Simple Application").getOrCreate();
        // read file into RDD
        JavaRDD<String> textFile = sc.sparkContext().textFile("", 1).toJavaRDD();
        //PairRdd = key value pair RDD
        // Basically, some operations that allow us to act on each key in parallel,
        // that exposes those operations. Moreover, through this,
        // we can regroup the data across the network. Like, in spark paired
        // RDDs reduceByKey() method aggregate data separately for each key
        // Flat-Mapping is transforming each RDD element using a function
        // that could return multiple elements to new RDD.
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);

        // for Top k words
        textFile.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b).sortByKey(false).take(10);

        counts.saveAsTextFile("hdfs://...");
        sc.stop();
    }
}
