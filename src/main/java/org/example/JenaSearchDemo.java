package org.example;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-03-25 09:26
 **/
public class JenaSearchDemo {
    private static void addProperty() {
        String personURI = "http://jene/demo";
        String givenName = "John";
        String familyName = "Smith";
        String fullNme = givenName + " " + familyName;

        //创建模板
        Model model = ModelFactory.createDefaultModel();
        Resource johnSmith = model.createResource(personURI).addProperty(VCARD.FN, fullNme)
                .addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName).addProperty(VCARD.Family, familyName));
        StmtIterator iterator = model.listStatements();
        while (iterator.hasNext()) {
            Statement statement = iterator.nextStatement();
            //主题
            Resource subject = statement.getSubject();
            //取到谓语
            Property predicate = statement.getPredicate();
            //对象
            RDFNode object = statement.getObject();

            System.out.print(subject.toString());
            System.out.print(" " + predicate + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                System.out.print("\"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }
    }

    public static void main(String[] args) {
        addProperty();
    }
}

