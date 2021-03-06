package org.example;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.XSD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-16 17:42
 **/
public class CreateOWL {
    public static void main(String[] args) throws FileNotFoundException {
        write();
    }
    private static  void write() throws FileNotFoundException {

        OntModel m = ModelFactory.createOntologyModel();
        String SOURCE = "http://www.eswc2006.org/technologies/ontology";
        String NS = SOURCE + "#";
        OntModel base = ModelFactory.createOntologyModel( OWL_MEM );

        OntClass lawClass= base.createClass(NS+"law");
        OntClass placeClass=base.createClass(NS+"place");
        OntClass personClass=base.createClass(NS+"person");
        OntClass actionClass = base.createClass(NS + "action");
        OntClass clerkClass = base.createClass(NS + "clerk");
        OntClass crimeClass = base.createClass(NS + "crime");

        OntClass lawArticleClass = base.createClass(NS + "lawArticle");
        OntClass lawOfficeClass = base.createClass(NS + "lawOffice");
        OntClass lawyerClass = base.createClass(NS + "lawyer");
        OntClass penaltyClass = base.createClass(NS + "penalty");
        OntClass prisonClass = base.createClass(NS + "prison");
        OntClass judgeClass = base.createClass(NS + "judge");
        OntClass moneyClass = base.createClass(NS + "money");
        OntClass opinionClass = base.createClass(NS + "opinion");
        OntClass courtClass = base.createClass(NS + "court");
        OntClass docClass = base.createClass(NS + "doc");
        OntClass defendantClass = base.createClass(NS + "defendant");

        lawClass.addSubClass(lawArticleClass);
        placeClass.addSubClass(lawOfficeClass);
        placeClass.addSubClass(courtClass);
        personClass.addSubClass(clerkClass);
        personClass.addSubClass(judgeClass);
        personClass.addSubClass(lawyerClass);
        personClass.addSubClass(defendantClass);
        penaltyClass.addSubClass(prisonClass);
        penaltyClass.addSubClass(moneyClass);
        lawClass.addSubClass(lawArticleClass);

        ObjectProperty acceptedObjectProperty = base.createObjectProperty(NS + "accepted");
        acceptedObjectProperty.addDomain(courtClass);
        acceptedObjectProperty.addRange(opinionClass);
        acceptedObjectProperty.addLabel("accepted","en");

        ObjectProperty baseOnObjectProperty = base.createObjectProperty(NS + "baseOn");
        baseOnObjectProperty.addDomain(crimeClass);
        baseOnObjectProperty.addRange(lawClass);
        baseOnObjectProperty.addLabel("base on","en");

        ObjectProperty chargedObjectProperty = base.createObjectProperty(NS + "charged");
        chargedObjectProperty.addDomain(defendantClass);
        chargedObjectProperty.addRange(crimeClass);
        chargedObjectProperty.addLabel("charged","en");

        ObjectProperty crimeTogetherObjectProperty = base.createObjectProperty(NS + "crimeTogether");
        crimeTogetherObjectProperty.addDomain(defendantClass);
        crimeTogetherObjectProperty.addRange(defendantClass);
        crimeTogetherObjectProperty.addLabel("crime together","en");

        ObjectProperty hasActedObjectProperty = base.createObjectProperty(NS + "hasActed");
        InverseFunctionalProperty hasHappenedInInverseFunctionalProperty = base.createInverseFunctionalProperty(NS + "hasHappenedIn");
        hasActedObjectProperty.addInverseOf(hasHappenedInInverseFunctionalProperty);
        hasActedObjectProperty.addDomain(defendantClass);
        hasActedObjectProperty.addRange(actionClass);
        hasActedObjectProperty.addLabel("has acted","en");

        ObjectProperty hasDefendantObjectProperty = base.createObjectProperty(NS + "hasDefendant");
        hasDefendantObjectProperty.addDomain(docClass);
        hasDefendantObjectProperty.addRange(defendantClass);
        hasDefendantObjectProperty.addLabel("has defendant","en");

        ObjectProperty hasHappenedInObjectProperty = base.createObjectProperty(NS + "hasHappenedIn");
        hasHappenedInObjectProperty.addDomain(actionClass);
        hasHappenedInObjectProperty.addRange(docClass);
        hasHappenedInObjectProperty.addLabel("has happened in","en");

        ObjectProperty hasJudgeObjectProperty = base.createObjectProperty(NS + "hasJudge");
        hasJudgeObjectProperty.addDomain(docClass);
        hasJudgeObjectProperty.addRange(judgeClass);
        hasJudgeObjectProperty.addLabel("has judge","en");

        ObjectProperty hasLawyerObjectProperty = base.createObjectProperty(NS + "hasLawyer");
        hasLawyerObjectProperty.addDomain(defendantClass);
        hasLawyerObjectProperty.addRange(lawyerClass);
        hasLawyerObjectProperty.addLabel("has lawyer","en");

        ObjectProperty hasOpinionObjectProperty = base.createObjectProperty(NS + "hasOpinion");
        hasOpinionObjectProperty.addDomain(lawyerClass);
        hasOpinionObjectProperty.addRange(opinionClass);
        hasOpinionObjectProperty.addLabel("has opinion","en");

        ObjectProperty hasPenaltyObjectProperty = base.createObjectProperty(NS + "hasPenalty");
        hasPenaltyObjectProperty.addDomain(defendantClass);
        hasPenaltyObjectProperty.addRange(penaltyClass);
        hasPenaltyObjectProperty.addLabel("has penalty","en");

        ObjectProperty inCourtObjectProperty = base.createObjectProperty(NS + "inCourt");
        inCourtObjectProperty.addDomain(docClass);
        inCourtObjectProperty.addRange(courtClass);
        inCourtObjectProperty.addLabel("in court","en");

        ObjectProperty isFromObjectProperty = base.createObjectProperty(NS + "isFrom");
        isFromObjectProperty.addDomain(lawyerClass);
        isFromObjectProperty.addRange(lawOfficeClass);
        isFromObjectProperty.addLabel("is from","en");

        ObjectProperty isPartofObjectProperty = base.createObjectProperty(NS + "isPartof");
        isPartofObjectProperty.addDomain(lawArticleClass);
        isPartofObjectProperty.addRange(lawClass);
        isPartofObjectProperty.addLabel("is part of","en");

        DatatypeProperty defendantdDatatypeProperty = base.createDatatypeProperty(NS + "defendant");
        defendantdDatatypeProperty.addDomain(defendantClass);
        defendantdDatatypeProperty.addRange(XSD.xstring);

//        Property categoryProperty = base.createProperty("category");
//        docClass.addProperty(categoryProperty,"1214");


        DatatypeProperty nameDatatypeProperty = base.createDatatypeProperty(NS + "Name");
        DatatypeProperty occupationDatatypeProperty = base.createDatatypeProperty(NS + "occupation");
        DatatypeProperty indexDatatypeProperty = base.createDatatypeProperty(NS + "index");
        DatatypeProperty textDatatypeProperty = base.createDatatypeProperty(NS + "text");
        //TODO 测试测试
        Individual individual1 = defendantClass.createIndividual(NS + "被告人1XXX");
        individual1.addProperty(nameDatatypeProperty,"被告人1");
        individual1.addProperty(occupationDatatypeProperty,"农民");


        Individual individual2 = defendantClass.createIndividual(NS + "被告人2XXX");
        individual2.addProperty(nameDatatypeProperty,"被告人2");
        individual2.addProperty(occupationDatatypeProperty,"程序员");

        base.write(new FileOutputStream(new File("test1.owl")), "RDF/XML-ABBREV");

    }

    private static void createDefendantProperty(){

    }
}
