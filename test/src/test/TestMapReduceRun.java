package test;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;
import org.apache.hadoop.util.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMapReduceRun extends Configured implements Tool{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestMapReduceRun.class);
	
	protected static class TestMapper extends Mapper<LongWritable, Text, Text, Text>{

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.map(key, value, context);
		}

		@Override
		protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.setup(context);
		}
		
	}
	
	protected static class TestTeduce extends Reducer<LongWritable, Text, Text, Text>{
		
		@Override
		protected void reduce(LongWritable arg0, Iterable<Text> arg1,
				Reducer<LongWritable, Text, Text, Text>.Context arg2) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.reduce(arg0, arg1, arg2);
		}

		@Override
		protected void setup(Reducer<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.setup(context);
		}
		
	}
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		
		Configuration conf = getConf();
		
		Job job = Job.getInstance(conf , TestMapReduceRun.class.getSimpleName());
		job.setJarByClass(TestMapReduceRun.class);
		job.setMapOutputKeyClass(TestMapper.class);
		job.setReducerClass(TestTeduce.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputFormatClass(NullOutputFormat.class);
		job.setOutputFormatClass(TableOutputFormat.class);
		job.getConfiguration().set(TableOutputFormat.OUTPUT_TABLE, "table_name");
		return 0;
		
	}
	
	
}
