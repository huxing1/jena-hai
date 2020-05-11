package org.hyzs.jena;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb2.TDB2;
import org.apache.jena.tdb2.TDB2Factory;
import org.apache.jena.util.FileManager;
import org.hyzs.utils.FilesUtils;

import java.io.File;

/**
 * @program: jena-hai
 * @description:  多条owl数据写入jena tdb2
 * @author: hux
 * @create: 2020-05-11 14:32
 **/
public class JenaTDB2 {
    private static void loadToTDB2(){
        String directory = "D:\\文档书籍代码\\华云中盛\\项目\\知识图谱\\TDB2\\";  //tdb索引希望存放的位置
        Dataset dataset= TDB2Factory.connectDataset(directory); //TDB2中createDataset修改为了connectDataset方法
        dataset.begin(ReadWrite.WRITE);  //开始一个transaction
        Model tdb2 = dataset.getDefaultModel();
        FilesUtils filesUtils = new FilesUtils();
        String dir = "D:\\文档书籍代码\\华云中盛\\项目\\知识图谱\\resultfile";  //数据文件所在的位置
        File[] files = filesUtils.readFiles(dir);
        if (files != null) {

            for (File f : files) {
                String source=f.getAbsolutePath();

                FileManager.get().readModel(tdb2, source);  //读入数据

                System.out.println(f.getName().substring(0, f.getName().lastIndexOf("."))+"写入成功");
            }
            }
        dataset.commit();
         //把数据真正提交给tdb
        dataset.end();  //结束一个transaction
    }

    public static void main(String[] args) {
        loadToTDB2();
    }

}
