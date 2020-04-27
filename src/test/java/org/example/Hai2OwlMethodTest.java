package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.hyzs.entry.JsonEntry;
import org.hyzs.jena.HaiIndividual;
import org.hyzs.utils.JsonUtils;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-24 10:16
 **/
public class Hai2OwlMethodTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        test2();
    }

    private static void test2() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        File jsonFile = ResourceUtils.getFile("classpath:test.json");
        String json = FileUtils.readFileToString(jsonFile);

//        String json = IOUtils.toString(Hai2OwlMethodTest.class.getClassLoader().getResource("test0106"), StandardCharsets.UTF_8);
        JSONObject o = JSON.parseObject(json);
        JsonUtils.removeEmpty(o);
        JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);
        Map<String, Map<String, String>> defendantMap = new HashMap<>();
        HaiIndividual haiIndividual = new HaiIndividual();
        if (jsonEntry.getDefendants() != null) {
            //多位被告人
            for (JsonEntry.DefendantsBean defendantsBean : jsonEntry.getDefendants()) {
                if (defendantsBean.getDefendant_base() != null) {
                    //判断defendant实例的keywords是否存在
                    if (defendantsBean.getDefendant_base().getDefendant_name() != null) {
                        //需要创建哪些属性
                        Map<String, Object> defendantProperties =new HashMap<>();
                        defendantProperties.put("被告人姓名",defendantsBean.getDefendant_base().getDefendant_name());
                        defendantProperties.put("被告人性别",defendantsBean.getDefendant_base().getS());
                        defendantProperties.put("被告人职业",defendantsBean.getDefendant_base().getDefendant_occupation());
                        defendantProperties.put("被告人民族",defendantsBean.getDefendant_base().getPN());
                        defendantProperties.put("被告人出生日期",defendantsBean.getDefendant_base().getBD());
                        defendantProperties.put("被告人出生地址",defendantsBean.getDefendant_base().getBA());
                        defendantProperties.put("被告人籍贯",defendantsBean.getDefendant_base().getDefendant_nativePlace());
                        defendantProperties.put("被告人住址",defendantsBean.getDefendant_base().getDR());
                        defendantProperties.put("被告人政治面貌",defendantsBean.getDefendant_base().getPS());
                        defendantProperties.put("被告人文化程度",defendantsBean.getDefendant_base().getE());



                        Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(defendantProperties);
                        System.out.println(".");
                    }
                }
            }
        }
    }

    private static void test1() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        JSONObject o = JSON.parseObject(JSON.toJSONString(xsyspj));
        File jsonFile = ResourceUtils.getFile("classpath:test.json");
        String json = FileUtils.readFileToString(jsonFile);

//        String json = IOUtils.toString(Hai2OwlMethodTest.class.getClassLoader().getResource("test0106"), StandardCharsets.UTF_8);
        JSONObject o = JSON.parseObject(json);
        JsonUtils.removeEmpty(o);
        JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);

        HaiIndividual haiIndividual=new HaiIndividual();

        Map<String, Map<String, String>> defendantMap = new HashMap<>();
        if (jsonEntry.getDefendants() != null) {
            for (JsonEntry.DefendantsBean defendantsBean : jsonEntry.getDefendants()) {
                if (defendantsBean.getDefendant_base().getDefendant_name() != null) {
                    Map<String, Object> defendantProperties =new HashMap<>();
                    defendantProperties.put("被告人姓名",defendantsBean.getDefendant_base().getDefendant_name());
//                    for ( Map.Entry<String, Object> property : defendantProperties.entrySet()) {
//                        property.getKey();
//                        Class<?> s=property.getValue().getClass();
//
////                        Class clazz = Class.forName(className);
//                        for (Field f:property.getValue().getClass().getDeclaredFields()){   //遍历通过反射获取object的类中的属性名
//                            f.setAccessible(true);    //设置改变属性为可访问
//                            if(f.getName().equals("text")){
////                                String text= f.get(property.getValue().getClass().getMethod("getText")).toString();
//                                Method m = property.getValue().getClass().getMethod("getIndex");
//                                Object invoke = m.invoke(property.getValue());
//                                String index="";
//                                if (invoke!=null) {
//                                   index = invoke.toString();
//                                }else {
//                                     index = "";
//                                }
//                                System.out.println(index);
//                            }
//                    }
//
////                    defendantMap.put("被告人姓名", keyText);
//                }
            }

//        Individual individual=ontClass.createIndividual(keyWords);
            for (Map.Entry<String, Map<String, String>> property : defendantMap.entrySet()) {
//            DatatypeProperty datatypeProperty = base.createDatatypeProperty(NS + property.getKey());
                property.getKey();

                for (Map.Entry<String, String> keyText : property.getValue().entrySet()) {
                    keyText.getKey();
                    keyText.getValue();
                }
//            individual.addProperty(datatypeProperty,property.getValue());
            }
//        return individual;
            System.out.println("0");
        }
    }
}
}
