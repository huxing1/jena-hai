package org.hyzs;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.riot.system.StreamRDFLib;
import org.apache.jena.util.FileManager;

import java.io.*;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-10 09:13
 **/
public class JSON2RDF {
    private static String baseURI="https://localhost/";
    private static Charset inputCharset = UTF_8;
    private static void Json2NTriples() throws FileNotFoundException {
        String json ="{\"evidences\":{\"evidence_object\":[{\"index\":\"书\",\"text\":\"1\"},{\"index\":\"本子\",\"text\":\"22\"}]},\"judgment\":{\"laws\":[{\"law_name\":{\"index\":\"200,201\",\"text\":\"抢劫\"},\"article_names\":[{\"index\":\"853,854,855,856,857,858,859,860,861\",\"text\":\"第二百三十七第一款\"},{\"index\":\"863,864,865,866,867,868,869,870\",\"text\":\"第六十七条第三款\"}]},{\"law_name\":{\"index\":\"300,301\",\"text\":\"杀人\"},\"article_names\":[{\"index\":\"853,854,855,856,857,858,859,860,861\",\"text\":\"第九百三十七第五款\"},{\"index\":\"863,864,865,866,867,868,869,870\",\"text\":\"第九十七条第五款\"}]}],\"appeal\":{\"appeal_due\":{\"index\":\"976,977,978,979,980,981,982,983,984,985,986,987,988\",\"text\":\"接到判决书的第二日起十日内\"},\"appeal_courts\":[{\"index\":\"992,993\",\"text\":\"本院\"},{\"index\":\"999,1000,1001,1002,1003,1004,1005,1006,1007,1008,1009,1010\",\"text\":\"湖北省武汉市中级人民法院\"}]}}}";
        Reader reader = new StringReader(json);
        OutputStream outputStream = new FileOutputStream(new File("nTriplesResult.ttl"));
        StreamRDF rdfStream =StreamRDFLib.writer(outputStream);
        new JenaRDFStreamWrite(reader, rdfStream, baseURI).convert();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Json2NTriples();

        Model model = ModelFactory.createDefaultModel();
        InputStream is = FileManager.get().open("nTriplesResult.ttl");
        OutputStream out = new FileOutputStream("filename.ttl");
        if (is!= null) {
            model.read(is, null,"N-TRIPLE");
            RDFDataMgr.write(out, model, RDFFormat.TURTLE);
        } else {
            System.err.println("cannot read inputfile");
        }
        System.out.println("完成");
    }
}
