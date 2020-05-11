package org.hyzs.utils;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-05-09 13:57
 **/
public class TextUtil {
    public  String replaceS(String s){
        return s.replace("`"," ");
    }

//    public static void main(String[] args) {
//        String s="第二十六条第一`四款";
//        System.out.println(replaceS(s));
//    }
}
