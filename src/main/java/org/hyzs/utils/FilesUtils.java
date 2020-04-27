package org.hyzs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-27 16:32
 **/
public class FilesUtils {
    public  File[] readFiles(String fileDir){
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }
//        for (File f : files) {
//            System.out.println(f.getName());
//            System.out.println(f.getName().substring(0, f.getName().lastIndexOf(".")));
//            System.out.println(f.getAbsolutePath());
//        }
        return files;
//         遍历，目录下的所有文件
//        for (File f : files) {
//            if (f.isFile()) {
//                fileList.add(f);
//            } else if (f.isDirectory()) {
//                System.out.println(f.getAbsolutePath());
//                readFiles(f.getAbsolutePath());
//            }
//        }
//        for (File f1 : fileList) {
//            System.out.println(f1.getName());
//        }

    }

//    public static void main(String[] args) {
//        readFiles("D:\\文档书籍代码\\华云中盛\\项目\\知识图谱\\testPackage\\");
//    }
}
