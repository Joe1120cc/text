package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {
	/**
	 * 读取文件
	 * 
	 * @param filename：文件名称
	 * @param type:操作类型
	 * @return 对象集合
	 */
	public static List<Object> getData(String fileName, Class<?> C) {
		List<Object> ret = new ArrayList<>();
		try {
			String path = "data/" + fileName;
			FileReader inOne = new FileReader(path);
			BufferedReader inTwo = new BufferedReader(inOne);
			String fr = null;

			while ((fr = inTwo.readLine()) != null) {
				fr = "[" + fr + "]";
				Object obj = GsonUtils.toObj(fr, C);// C=Flow.class
				ret.add(obj);
			}
			inTwo.close();
			inOne.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 写入文件
	 * 
	 * @param data：json格式的字符串
	 * @param filename：文件名称
	 * @return
	 * @throws IOException
	 */
	public static void writeData(String data, String filename,boolean x) throws IOException {
		String fileName = "data/" + filename;
		FileWriter writer = new FileWriter(fileName, x);
		BufferedWriter outWriter = new BufferedWriter(writer);

		outWriter.write(data);
		outWriter.newLine();
		//刷新流
		outWriter.flush();
        outWriter.close();
		writer.close();
	}

}
