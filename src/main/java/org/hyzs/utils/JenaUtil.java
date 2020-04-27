package org.hyzs.utils;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.hyzs.entry.JsonEntry;

import java.util.Map;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-23 11:37
 **/
public class JenaUtil {

    //为单个实体创建单个实例
    public  Individual createIndividual(OntModel base, String NS,OntClass ontClass,String keyWords, Map<String,Map<String,String>>  properties){
        Individual individual=ontClass.createIndividual(keyWords);
        for (Map.Entry<String,Map<String,String>>  property : properties.entrySet()) {
            DatatypeProperty datatypeProperty = base.createDatatypeProperty(NS + property.getKey());
            property.getValue();
//            for (Map.Entry<String,String> keyText:property.getValue())
//            individual.addProperty(datatypeProperty,property.getValue());
        }
        return individual;
    }

}
