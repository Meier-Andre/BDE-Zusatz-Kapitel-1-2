package HDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class Append {

	public static void main(String[] args) throws IOException {
		System.setProperty("hadoop.home.dir", "/usr/lib/hadoop");
		System.setProperty("$HBASE_HOME", "/usr/lib/hbase");
		Configuration conf = new Configuration();
		conf.addResource(new Path("/etc/alternatives/hadoop-conf/core-site.xml"));
		conf.addResource(new Path("/etc/alternatives/hadoop-conf/hdfs-site.xml"));
		FileSystem fs = FileSystem.get(conf);
		
		String[] links = getInput(args[0]);
		
		Path outFile = new Path(fs.getHomeDirectory() + "/BDE/zusatzaufgaben/Kapitel_1_2/append.txt");
		System.out.println("Output Path: " + outFile);
		
		FSDataOutputStream out_log = fs.create(new Path(fs.getHomeDirectory() + "/BDE/zusatzaufgaben/Kapitel_1_2/log.txt"));
		BufferedWriter logFile = new BufferedWriter(new OutputStreamWriter(out_log));
		
		int count = 0;
		for (int i = 0; i < links.length; i++) {
			URL u = new URL(links[i]);
			InputStream is = u.openStream();
			
			FSDataOutputStream out = null;
			if (i == 0) {
				out = fs.create(outFile);
			} else {
				out = fs.append(outFile);
			}
			
			byte[] buffer = new byte[1024];
			int len1 = 0;
			
			int count1 = 0;
			
			logFile.write("Write File " + (i+1) + "\n");
			logFile.write("Source: " + u.toString() + "\n");
			if(is != null) {
				while ((len1 = is.read(buffer)) > 0) {
					out.write(buffer,0, len1);  
					count = count + len1;
					count1 = count1 + len1;
				}
			}
			
			logFile.write("Bytes: " + count1 + "\n");
			logFile.write("\n");
			System.out.println("File " + (i+1) + " finished");
			out.close();
		}
		
		
		logFile.write("################################################\n");
		logFile.write("Result:\n");
		logFile.write("Files written: " + links.length + "\n");
		logFile.write("Bytes written: " + count + "\n");
		logFile.flush();
		logFile.close();
		System.out.println("Finished");
	}
	
	public static String[] getInput(String inputFile) throws IOException {
		Configuration conf = new Configuration();
		conf.addResource(new Path("/etc/alternatives/hadoop-conf/core-site.xml"));
		conf.addResource(new Path("/etc/alternatives/hadoop-conf/hdfs-site.xml"));
		FileSystem fs = FileSystem.get(conf);

		FSDataInputStream in = fs.open(new Path (inputFile));
		FSDataInputStream in2 = fs.open(new Path (inputFile));

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(in2));
		int counter = 0;
		String line = reader.readLine(); 

		while (line != null){
			counter++;
			line = reader.readLine();
		}
		String[] array = new String[counter];
		counter = 0;
		line = reader2.readLine();
		while (line != null){
			array[counter] = line;
			counter++;
			line = reader2.readLine();
		}
		return array;
	}

}
