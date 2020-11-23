import java.io.*;
import java.util.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.mapreduce.Reducer;

public class TopN {
    public static int N = 5;

    public static class TopNMapper extends Mapper<Object, Text, Text, LongWritable> {

        private TreeMap<Long, String> tmap;

        @Override
        public void setup(Context context) throws IOException, InterruptedException {
            tmap = new TreeMap<Long, String>();
        }

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] tokens = value.toString().split("\t");

            String word = tokens[0];
            long frequency = Long.parseLong(tokens[1]);

            // insert data into treeMap,
            // we want top 10 viewed movies
            // so we pass no_of_views as key
            tmap.put(frequency, word);

            // we remove the first key-value
            // if it's size increases 10
            if (tmap.size() > N) {
                tmap.remove(tmap.firstKey());
            }
        }

        @Override
        public void cleanup(Context context) throws IOException, InterruptedException {
            for (Map.Entry<Long, String> entry : tmap.entrySet()) {

                long count = entry.getKey();
                String word = entry.getValue();

                context.write(new Text(word), new LongWritable(count));
            }
        }
    }

    public static class TopNReducer extends Reducer<Text, LongWritable, LongWritable, Text> {

        private TreeMap<Long, String> tmap2;

        @Override
        public void setup(Context context) throws IOException, InterruptedException {
            tmap2 = new TreeMap<Long, String>();
        }

        @Override
        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {

            // input data from mapper
            // key values
            // movie_name [ count ]
            String word = key.toString();
            long count = 0;

            for (LongWritable val : values) {
                count = val.get();
            }

            // insert data into treeMap,
            // we want top 10 viewed movies
            // so we pass count as key
            tmap2.put(count, word);

            // we remove the first key-value
            // if it's size increases 10
            if (tmap2.size() > 10) {
                tmap2.remove(tmap2.firstKey());
            }
        }

        @Override
        public void cleanup(Context context) throws IOException, InterruptedException {

            for (Map.Entry<Long, String> entry : tmap2.entrySet()) {

                long count = entry.getKey();
                String name = entry.getValue();
                context.write(new LongWritable(count), new Text(name));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        // if less than two paths
        // provided will show error
        if (otherArgs.length < 2) {
            System.err.println("Error: please provide two paths");
            System.exit(2);
        }

        Job job = Job.getInstance(conf, "top N");
        job.setJarByClass(TopN.class);

        job.setMapperClass(TopNMapper.class);
        job.setReducerClass(TopNReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
