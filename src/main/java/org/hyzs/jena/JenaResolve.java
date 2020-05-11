package org.hyzs.jena;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-05-07 14:02
 **/
public class JenaResolve {
    static String SOURCE = "http://hyzs.org/ontology";
    static String NS = SOURCE + "#";

    private static OntModel baseModel() {
        OntModel base = ModelFactory.createOntologyModel(OWL_MEM);

        RDFDataMgr.read(base, "00ac4b6420024363cd2d7f94d80670d3.owl");
        return base;
    }

    /**
    * @Description: 查询所有实例 method1
    * @Param: [base]
    * @return: void
    * @Author: hux
    * @Date: 2020/5/7
    */
    private static void queryIndividual(OntModel base) throws FileNotFoundException {

        OntClass defendantClass = base.getOntClass(NS + "defendant");
        OntClass lawArticleClass = base.getOntClass(NS + "lawArticle");

        ResIterator res = base.listSubjectsWithProperty(RDF.type, lawArticleClass);
        while (res.hasNext()) {
            Resource resource = (Resource) res.next();

            System.out.println(resource);
        }

    }

    /**
    * @Description: 查询所有实例 method2 ,需要判断实例属于哪个class
    * @Param: [base]
    * @return: void
    * @Author: hux
    * @Date: 2020/5/7
    */
    private static void queryIndividual2(OntModel base) throws FileNotFoundException {
        ExtendedIterator<Individual> individuals= base.listIndividuals();
        while (individuals.hasNext()){
            Resource resource=individuals.next();
            System.out.println(resource);
        }
    }

    /**
    * @Description: 删除class
    * @Param: [base]
    * @return: void
    * @Author: hux
    * @Date: 2020/5/7
    */
    private static void deleteClass(OntModel base) throws FileNotFoundException {
        OntClass defendantClass = base.getOntClass(NS + "defendant");
        OntClass superClass=defendantClass.getSuperClass();
        defendantClass.remove();
//        superClass.removeSubClass(defendantClass);
        //写入新的文件中
        String filename = "1.owl";
       base.write(new FileOutputStream(new File(filename)),"RDF/XML-ABBREV");
    }


    public static void main(String[] args) throws FileNotFoundException {
        queryIndividual2(baseModel());
    }
}
