import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class SearchTerm {

    public static String TERM = "";

    public static class TokenizerMapper extends Mapper<Object, Text, Text, Text> {

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] line = value.toString().split("\t");
            if (line[0].equals(TERM))
                context.write(new Text(TERM), new Text(line[1]));
        }
    }

    public static class FileReducer extends Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            String s = "";
            for (Text t : values)
                s += t.toString();
            context.write(key, new Text(s));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        GenericOptionsParser optionParser = new GenericOptionsParser(conf, args);
        String[] remainingArgs = optionParser.getRemainingArgs();
        if (remainingArgs.length != 3) {
            System.err.println("Usage: searchterm <in> <out> <term>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "search term");
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setJarByClass(SearchTerm.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(FileReducer.class);
        job.setReducerClass(FileReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        TERM = remainingArgs[2];

        FileInputFormat.addInputPath(job, new Path(remainingArgs[0]));
        FileSystem fs = FileSystem.get(new Configuration());
        fs.delete(new Path(remainingArgs[1]), true);
        FileOutputFormat.setOutputPath(job, new Path(remainingArgs[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}