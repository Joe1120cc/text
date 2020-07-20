package utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

public class GsonUtils {
	public static String toJson(Object object) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		//gsonBuilder.setPrettyPrinting();
		com.google.gson.Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
	
	/**
	 * 将json格式字符串对象转成object (针对文件中一行是一个对象的情况)
	 */
	public static Object toObj(String fd, Class<?> C) {
		JsonParser parser = new JsonParser();
		// 将JSON的String 转成一个JsonArray对象
		JsonArray jsonArray = parser.parse(fd).getAsJsonArray();
		Gson gson = new Gson();
		Object obj = null;
		for (JsonElement item : jsonArray) {
			obj = gson.fromJson(item, C);
		}
		return obj;
	}
	
	/**
	 * 将json格式字符串对象转成object集合 (针对文件中一行是多个对象的情况)
	 */
	public static List<Object> toObjList(String fd, Class<?> C) {
		JsonParser parser = new JsonParser();
		// 将JSON的String 转成一个JsonArray对象
		JsonArray jsonArray = parser.parse(fd).getAsJsonArray();
		Gson gson = new Gson();
		ArrayList<Object> objList = new ArrayList<>();
		for (JsonElement item : jsonArray) {
			Object obj = gson.fromJson(item, C);
			objList.add(obj);
		}
		return objList;
	}

}
