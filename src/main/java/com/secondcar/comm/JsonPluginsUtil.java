package com.secondcar.comm;

/**
 * Created with IntelliJ IDEA.
 * User: linyiming
 * Date: 13-8-12
 * Time: 涓嬪崍5:31
 * To change this template use File | Settings | File Templates.
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 
 * Json涓巎avaBean涔嬮棿鐨勮浆鎹㈠伐鍏风被
 * 
 * 
 * 
 * @author ailk
 * 
 * @version 20111
 * 
 *          鏀寔 * }
 */

public class JsonPluginsUtil {
	
	
	public static JSONObject strToJsonObj(String jsonString) {
		return   JSONObject.parseObject(jsonString);
	}

	
	//浠嶻API鎸繃鏉ョ殑銆�
	public static String mapToString (Map map) {
	return JSON.toJSONString(map);
	}
	
	public static JSONArray strToJsonArray(String jsonString) {
		return   JSONArray.parseArray(jsonString);
	}
	
	/**
	 * 
	 * 浠庝竴涓狫SON 瀵硅薄瀛楃鏍煎紡涓緱鍒颁竴涓猨ava瀵硅薄
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @param beanCalss
	 * 
	 * @return
	 */


	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		T bean = (T) JSONObject.toJavaObject(jsonObject, beanCalss);
		return bean;

	}

	/**
	 * 浠庝竴涓猨son涓蹭腑杩斿洖涓�釜澶嶆潅鐨刡ean瀵硅薄
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @param classMap
	 * @return
	 */

	public static <T> T jsonObjToBean(JSONObject obj, Class<T> beanCalss) {
		T bean = (T) JSONObject.toJavaObject(obj, beanCalss);
		return bean;
	}

	/**
	 * 
	 * 灏唈ava瀵硅薄杞崲鎴恓son瀛楃涓�
	 * 
	 * 
	 * 
	 * @param bean
	 * 
	 * @return
	 */
	public static String beanToJson(Object bean) {
		return JSONObject.toJSONString(bean, false);

	}

	public static JSONObject beanToJsonObj(Object bean) {
		return (JSONObject) JSONObject.toJSON(bean);
	}

	@SuppressWarnings("unchecked")
	public static String beanListToJson(List beans) {
		JSONArray array = beanListToJsonArray(beans);
		return array.toJSONString();
	}

	@SuppressWarnings("unchecked")
	public static JSONArray beanListToJsonArray(List beans) {

		JSONArray rest = new JSONArray();
		for (int i = 0; i < beans.size(); i++) {
			rest.add(beanToJsonObj(beans.get(i)));
		}
		return rest;
	}

	/**
	 * 
	 * 浠巎son HASH琛ㄨ揪寮忎腑鑾峰彇涓�釜map锛屾敼map鏀寔宓屽鍔熻兘
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */
	@SuppressWarnings( { "unchecked" })
	public static Map jsonToMap(String jsonString) {

		String key;
		Map valueMap = new HashMap();
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		Set<String> sets = jsonObject.keySet();
		if (sets == null)
			return valueMap;
		Iterator keyIter = sets.iterator();
		while (keyIter.hasNext()) {
			key = (String) keyIter.next();
			valueMap.put(key, jsonObject.get(key));
		}
		return valueMap;
	}

	public static String mapToJson(Object map) {
		String s_json = "";
		s_json = JSONObject.toJSONString(map);
		return s_json;
	}

	/**
	 * 
	 * 浠巎son鏁扮粍涓緱鍒扮浉搴攋ava鏁扮粍
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */
	public static Object[] jsonToObjectArray(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		return jsonArray.toArray();
	}

	/**
	 * 
	 * 浠巎son瀵硅薄闆嗗悎琛ㄨ揪寮忎腑寰楀埌涓�釜java瀵硅薄鍒楄〃
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @param beanClass
	 * 
	 * @return
	 */
	public static <T> List<T> jsonToBeanList(String jsonString,
			Class<T> beanClass) {

		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) jsonObjToBean(jsonObject, beanClass);
			list.add(bean);
		}
		return list;

	}
	
	public static <T> List<T> jsonArrayToBeanList(JSONArray jsonArray,
			Class<T> beanClass) {

		//JSONArray jsonArray = JSONArray.parseArray(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) jsonObjToBean(jsonObject, beanClass);
			list.add(bean);
		}
		return list;

	}

	/**
	 * 
	 * 浠巎son鏁扮粍涓В鏋愬嚭java瀛楃涓叉暟缁�
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */
	public static String[] jsonToStringArray(String jsonString) {

		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		int size = jsonArray.size();

		for (int i = 0; i < size; i++) {
			stringArray[i] = jsonArray.getString(i);
		}
		return stringArray;
	}

	/**
	 * 
	 * 浠巎son鏁扮粍涓В鏋愬嚭javaLong鍨嬪璞℃暟缁�
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */
	public static Long[] jsonToLongArray(String jsonString) {

		JSONArray jsonArray = JSONArray.parseArray(jsonString);

		int size = jsonArray.size();

		Long[] longArray = new Long[size];

		for (int i = 0; i < size; i++) {

			longArray[i] = jsonArray.getLong(i);

		}

		return longArray;

	}

	/**
	 * 
	 * 浠巎son鏁扮粍涓В鏋愬嚭java Integer鍨嬪璞℃暟缁�
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */

	public static Integer[] jsonToIntegerArray(String jsonString) {

		JSONArray jsonArray = JSONArray.parseArray(jsonString);

		int size = jsonArray.size();

		Integer[] integerArray = new Integer[size];

		for (int i = 0; i < size; i++) {

			integerArray[i] = jsonArray.getInteger(i);

		}

		return integerArray;

	}

	/**
	 * 
	 * 浠巎son鏁扮粍涓В鏋愬嚭java Double鍨嬪璞℃暟缁�
	 * 
	 * 
	 * 
	 * @param jsonString
	 * 
	 * @return
	 */

	public static Double[] jsonToDoubleArray(String jsonString) {

		JSONArray jsonArray = JSONArray.parseArray(jsonString);

		int size = jsonArray.size();

		Double[] doubleArray = new Double[size];

		for (int i = 0; i < size; i++) {

			doubleArray[i] = jsonArray.getDouble(i);

		}

		return doubleArray;

	}

	public static String toPrintString(Object obj) {
		
		return JSONArray.toJSONString(obj, true);
	}
	/**
	 * 鍒ゆ柇json绫诲瀷鏄槸涓嶆槸鏁扮粍绫诲瀷
	 */
	public static boolean isJsonArrayType(String jsonStr){
		boolean flag = false ;
		Gson gson = new Gson();  
		JsonParser ps = new JsonParser();
		JsonElement jsonEle = ps.parse(jsonStr);
		if(jsonEle.isJsonArray()){
			flag = true ;
		}
		return flag ;
	}

}