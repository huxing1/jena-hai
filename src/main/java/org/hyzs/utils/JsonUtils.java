package org.hyzs.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/***
 * @Description:
 * @Param:
 * @return:
 * @Author: hux
 * @Date: 2019/12/24 12:05
 */
public class JsonUtils {

    /**
     * 等号改为冒号
     *
     * @param content
     * @return
     */
    public static String changeEqualToColon(String content) {
        return content.replace("=", ":");
    }

    /**
     * 递归去除空元素
     *
     * @param object
     * @return
     */
    public static boolean removeEmpty(JSONObject object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Map) {
            Map<String, Object> map = (Map) object;
            if (map.isEmpty()) {
                return true;
            }
            Set<String> removeSet = new HashSet<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    removeSet.add(key);
                } else if (value instanceof Map) {
                    boolean remove = removeEmpty((JSONObject) value);
                    if (remove) {
                        removeSet.add(key);
                    }
                } else if (value instanceof Collection) {
                    Collection list = (Collection) value;
                    Collection removeList = new LinkedList();
                    for (Object e : list) {
                        boolean remove = removeEmpty((JSONObject) e);
                        if (remove) {
                            removeList.add(e);
                        }
                    }
                    list.removeAll(removeList);
                    if (list.isEmpty()) {
                        removeSet.add(key);
                    }
                }
            }
            for (String key : removeSet) {
                map.remove(key);
            }
            return map.isEmpty();
        } else {
            throw new RuntimeException("Type not know: " + object.getClass().getName());
        }
    }

    public static String readJsonData(String pactFile) throws IOException {
        // 读取文件数据

        StringBuilder strbuffer = new StringBuilder();
        File myFile = new File(pactFile);
        if (!myFile.exists()) {
            System.err.println("Can't Find " + pactFile);
        }
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);  //new String(str,"UTF-8")
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return strbuffer.toString();
    }
    /**
     * null改为{}
     *
     * @param content
     * @return
     */
    public static String changeNullToEmpty(String content) {
        return content.replace("null", "{}");
    }

}
