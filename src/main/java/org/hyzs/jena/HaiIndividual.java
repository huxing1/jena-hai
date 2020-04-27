package org.hyzs.jena;

import jdk.nashorn.internal.objects.NativeUint8Array;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.hyzs.entry.JsonEntry;
import org.omg.CORBA.MARSHAL;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-24 10:09
 **/
public class HaiIndividual {

    /**
    * @Description: 获取实体的index和text值
    * @Param: [defendantProperties]
    * @return: java.util.Map.Entry<java.lang.String,java.util.Map<java.lang.String,java.lang.String>>
    * @Author: hux
    * @Date: 2020/4/26
    */
    public  Map<String, Map<String, String>> getKeyText(Map<String, Object> properties) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Map<String, Map<String, String>> keyText=new HashMap<>();
        for ( Map.Entry<String, Object> property : properties.entrySet()) {
            Map<String, String> tempMap=new HashMap<>();
            String text="";
            String index="";
            if (property.getValue()!=null) {
                for (Field f : property.getValue().getClass().getDeclaredFields()) {   //遍历通过反射获取object的类中的属性名
                    f.setAccessible(true);    //设置改变属性为可访问
                    if (f.getName().equals("text")) {
//                                String text= f.get(property.getValue().getClass().getMethod("getText")).toString();
                        Method m = property.getValue().getClass().getMethod("getText");
                        Object invoke = m.invoke(property.getValue());
                        text = invoke.toString() == null ? "" : invoke.toString();
                    }
                    if (f.getName().equals("index")) {
                        Method m = property.getValue().getClass().getMethod("getIndex");
                        Object invoke = m.invoke(property.getValue());
                        index = invoke == null ? "" : invoke.toString();
                    }
                }
            }
            tempMap.put("text",text);
            tempMap.put("index",index);
            keyText.put(property.getKey(),tempMap);
        }
        return keyText;
    }

   /**
   * @Description: 获取实体的index和text值
   * @Param: [list]
   * @return: java.util.Map<java.lang.String,java.util.Map<java.lang.String,java.lang.String>>
   * @Author: hux
   * @Date: 2020/4/27
   */
    public  Map<String, Map<String, String>> getKeyText(List<Map<String, Object>> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> properties=new HashMap<>();
        for(Map<String, Object> map :list ){
            properties.putAll(map);
        }

        Map<String, Map<String, String>> keyText=new HashMap<>();
        for ( Map.Entry<String, Object> property : properties.entrySet()) {
            Map<String, String> tempMap=new HashMap<>();
            String text="";
            String index="";
            if (property.getValue()!=null) {
                for (Field f : property.getValue().getClass().getDeclaredFields()) {   //遍历通过反射获取object的类中的属性名
                    f.setAccessible(true);    //设置改变属性为可访问
                    if (f.getName().equals("text")) {
//                                String text= f.get(property.getValue().getClass().getMethod("getText")).toString();
                        Method m = property.getValue().getClass().getMethod("getText");
                        Object invoke = m.invoke(property.getValue());
                        text = invoke.toString() == null ? "" : invoke.toString();
                    }
                    if (f.getName().equals("index")) {
                        Method m = property.getValue().getClass().getMethod("getIndex");
                        Object invoke = m.invoke(property.getValue());
                        index = invoke == null ? "" : invoke.toString();
                    }
                }
            }
            tempMap.put("text",text);
            tempMap.put("index",index);
            keyText.put(property.getKey(),tempMap);
        }
        return keyText;
    }

    /**
    * @Description: 判断实例是否为空，若实例不为空则返回实例对应的属性，并把keywords对应的空value改成UUID
    * @Param: [keyText, keyWord]
    * @return: java.util.Map<java.lang.String,java.util.Map<java.lang.String,java.lang.String>>
    * @Author: hux
    * @Date: 2020/4/26
    */
    public  Map<String, Map<String, String>> isEmptyIndividual(Map<String, Map<String, String>> keyText,String keyWord){
        int i=0;
        for ( Map.Entry<String, Map<String, String>> keyTextTmp:keyText.entrySet()){

            for (Map.Entry<String, String> mapTmp:keyTextTmp.getValue().entrySet()){
                if (mapTmp.getValue()!="") i++;

                if (keyTextTmp.getKey()==keyWord&&mapTmp.getKey()=="text"){
                    String keyWordText=mapTmp.getValue()==""? UUID.randomUUID().toString():mapTmp.getValue();
                    Map<String, String> map=new HashMap<>();
                    map.put("text",keyWordText);
                    keyText.put(keyWord,map);
                }
            }

        }
        if (i>0) {
            return keyText;
        }else {
            return null;
        }
    }

    /**
    * @Description: 创建实例及属性
    * @Param: [keyText, base, NS, ontClass, keyWord]
    * @return: void
    * @Author: hux
    * @Date: 2020/4/26
    */
    public Individual createIndividual(Map<String, Map<String, String>> keyText, OntModel base, String NS, OntClass ontClass, String keyWord, DatatypeProperty textDatatypeProperty, DatatypeProperty indexDatatypeProperty){

//        Individual individual1 = defendantClass.createIndividual(NS + "被告人1XXX");
//        individual1.addProperty(nameDatatypeProperty,"被告人1");
//        individual1.addProperty(occupationDatatypeProperty,"农民");
        Individual individual = null;

        for (Map.Entry<String, Map<String, String>> property : keyText.entrySet()) {
            if (property.getKey()==keyWord){
                for (Map.Entry<String, String> mapTmp : property.getValue().entrySet()) {
                    if (mapTmp.getKey()=="text"){
                        String keyWordText=mapTmp.getValue();
                        individual=ontClass.createIndividual(NS+"/"+keyWord+"/"+keyWordText);
//                        if (keyWord=="前科涉嫌罪名") ontClass.dropIndividual(individual);
                    }
                }
            }
          }
        for (Map.Entry<String, Map<String, String>> property : keyText.entrySet()) {
            //冗余，可优化
            DatatypeProperty datatypeProperty = base.createDatatypeProperty(NS + property.getKey());
            for (Map.Entry<String, String> mapTmp : property.getValue().entrySet()) {
                if (mapTmp.getKey()=="text") individual.addProperty(datatypeProperty,mapTmp.getValue());
//                if (mapTmp.getKey()=="index") individual.addProperty(indexDatatypeProperty,mapTmp.getValue());
            }
        }
        return individual;
    }
}
