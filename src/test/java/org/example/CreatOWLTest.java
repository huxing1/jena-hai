package org.example;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-22 15:40
 **/
public class CreatOWLTest {
    private static  void write() throws FileNotFoundException {

        OntModel m = ModelFactory.createOntologyModel();
        String SOURCE = "http://www.eswc2006.org/technologies/ontology";
        String NS = SOURCE + "#";
        OntModel base = ModelFactory.createOntologyModel(OWL_MEM);

        OntClass lawClass= base.createClass(NS+"law");
        OntClass placeClass=base.createClass(NS+"place");
        OntClass personClass=base.createClass(NS+"person");
        OntClass footClass=base.createClass(NS+"foot");

        ObjectProperty acceptedObjectProperty = base.createObjectProperty(NS + "accepted");
        acceptedObjectProperty.addDomain(lawClass);
        acceptedObjectProperty.addRange(placeClass);
        acceptedObjectProperty.addLabel("accepted","en");

        ObjectProperty acceptedObjectProperty1 = base.createObjectProperty(NS + "accepted");
        acceptedObjectProperty1.addDomain(footClass);
        acceptedObjectProperty1.addRange(personClass);


        //TODO 测试测试 张三被指控盗窃
        DatatypeProperty nameDatatypeProperty = base.createDatatypeProperty(NS + "Name");
        DatatypeProperty occupationDatatypeProperty = base.createDatatypeProperty(NS + "occupation");
        DatatypeProperty nameIndexDatatypeProperty = base.createDatatypeProperty(NS + "nameIndex");
        DatatypeProperty occupationIndexDatatypeProperty = base.createDatatypeProperty(NS + "occupationIndex");

        nameDatatypeProperty.addSubProperty(nameIndexDatatypeProperty);
        occupationDatatypeProperty.addSubProperty(occupationIndexDatatypeProperty);

        Individual 张三 = personClass.createIndividual(NS +"/name/"+ "张三");
        张三.addProperty(occupationDatatypeProperty,"农民");

        Individual 李四 = lawClass.createIndividual(NS + "张三");
        李四.addProperty(nameDatatypeProperty,"被告人2");
        李四.addProperty(nameIndexDatatypeProperty,"1,2,3");
        李四.addProperty(occupationIndexDatatypeProperty,"2,3,4");
        李四.addProperty(occupationDatatypeProperty,"程序员");

        Individual 累犯 = lawClass.createIndividual(NS + "累犯");
//        personClass.dropIndividual(累犯);
        ObjectProperty objectPropertyHasHusband = base.createObjectProperty(NS + "is");
        //李四--》累犯
        李四.addProperty(acceptedObjectProperty,累犯);

        Individual 王五 = personClass.createIndividual(NS + "王五");
        王五.addProperty(nameDatatypeProperty,"被告人3");
        王五.addProperty(occupationDatatypeProperty,"老板");
        王五.addProperty(nameIndexDatatypeProperty,"45,4,5");
        王五.addProperty(occupationIndexDatatypeProperty,"123,345");

        ObjectProperty testObjectProperty = base.createObjectProperty(NS + "测试cs");

        张三.addProperty(testObjectProperty,李四);
        张三.addProperty(testObjectProperty,王五);
        base.write(new FileOutputStream(new File("test2.owl")), "RDF/XML-ABBREV");
    }

    public static void main(String[] args) throws FileNotFoundException {
        write();
        System.out.println("执行完成");
    }
}
