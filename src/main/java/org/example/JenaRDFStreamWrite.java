package org.example;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.riot.system.IRIResolver;
import org.apache.jena.riot.system.StreamRDF;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-10 10:13
 **/
public class JenaRDFStreamWrite {
    private final JsonParser parser;
    private final StreamRDF rdfStream;
    private final IRIResolver iriResolver;


    public JenaRDFStreamWrite(Reader reader, StreamRDF rdfStream, String baseURI)
    {
        this(Json.createParser(reader), rdfStream, baseURI);
    }
    public JenaRDFStreamWrite(JsonParser parser, StreamRDF rdfStream, String baseURI) {
        this.rdfStream = rdfStream;
        this.iriResolver = IRIResolver.create(baseURI);
        this.parser = parser;
    }

    protected StreamRDF getStreamRDF()
    {
        return rdfStream;
    }

    public static void write(JsonParser parser, StreamRDF rdfStream, IRIResolver iriResolver)
    {
        Deque<Node> subjectStack = new ArrayDeque<>();
        Map<Node, Node> arrayProperties = new HashMap<>();

        Node property = null;
        while (parser.hasNext())
        {
            JsonParser.Event event = parser.next();

            switch (event)
            {
                case START_ARRAY:
                    if (!subjectStack.isEmpty() && property != null) arrayProperties.put(subjectStack.getLast(), property);
                    break;
                case END_ARRAY:
                    if (!subjectStack.isEmpty()) arrayProperties.remove(subjectStack.getLast());
                    break;
                case START_OBJECT:
                    Node subject = NodeFactory.createBlankNode();
                    // add triple with current array property, if any
                    if (property != null && !subjectStack.isEmpty()) rdfStream.triple(new Triple(subjectStack.getLast(), property, subject));
                    subjectStack.addLast(subject);
                    break;
                case END_OBJECT:
                    subjectStack.removeLast();
                    // restore previous array property, if there was any
                    if (!subjectStack.isEmpty() && arrayProperties.containsKey(subjectStack.getLast())) property = arrayProperties.get(subjectStack.getLast());
                    break;
                case VALUE_FALSE:
                    rdfStream.triple(new Triple(subjectStack.getLast(), property, NodeFactory.createLiteralByValue(Boolean.FALSE, XSDDatatype.XSDboolean)));
                    break;
                case VALUE_TRUE:
                    rdfStream.triple(new Triple(subjectStack.getLast(), property, NodeFactory.createLiteralByValue(Boolean.TRUE, XSDDatatype.XSDboolean)));
                    break;
                case KEY_NAME:
                    property = NodeFactory.createURI(iriResolver.resolveToString("#" + parser.getString()));
                    break;
                case VALUE_STRING:
                    if (property != null) rdfStream.triple(new Triple(subjectStack.getLast(), property, NodeFactory.createLiteral(parser.getString())));
                    break;
                case VALUE_NUMBER:
                    try
                    {
                        rdfStream.triple(new Triple(subjectStack.getLast(), property,NodeFactory.createLiteralByValue(Integer.valueOf(parser.getString()), XSDDatatype.XSDint)));
                    }
                    catch (NumberFormatException ex)
                    {
                        rdfStream.triple(new Triple(subjectStack.getLast(), property,NodeFactory.createLiteralByValue(Float.valueOf(parser.getString()), XSDDatatype.XSDfloat)));
                    }
                    break;
                case VALUE_NULL:
                    break;
            }
        }
    }

    public void convert()
    {
        getStreamRDF().start();

        write(getParser(), getStreamRDF(), getIRIResolver());

        getStreamRDF().finish();
    }

    protected JsonParser getParser()
    {
        return parser;
    }


    protected IRIResolver getIRIResolver()
    {
        return iriResolver;
    }
}
