package org.hyzs.jena;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.hyzs.entry.JsonEntry;
import org.hyzs.utils.FilesUtils;
import org.hyzs.utils.JsonUtils;
import org.hyzs.utils.MySQLUtil;
import org.hyzs.utils.TextUtil;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-23 11:20
 **/
public class Hai2Owl {
    private static String packageDir = "D:\\文档书籍代码\\华云中盛\\项目\\知识图谱\\jsonfile\\";
    private static String resultFile = "D:\\文档书籍代码\\华云中盛\\项目\\知识图谱\\resultfile\\";
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IOException, IllegalAccessException, SQLException {
        resolveOwl();
    }

    private static void resolveOwl() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, SQLException {

        TextUtil textUtil=new TextUtil();
        Connection connection = MySQLUtil.getConnection();
        Statement statement = connection.createStatement();
        FilesUtils filesUtils = new FilesUtils();
        File[] files = filesUtils.readFiles(packageDir);
        if (files != null) {

            for (File f : files) {

                OntModel m = ModelFactory.createOntologyModel();
                String SOURCE = "http://hyzs.org/ontology";
                String NS = SOURCE + "#";
                OntModel base = ModelFactory.createOntologyModel(OWL_MEM);

                OntClass crimeClass = base.createClass(NS + "crime");
                OntClass docClass = base.createClass(NS + "doc");
                OntClass lawClass = base.createClass(NS + "law");
                OntClass penatlyClass = base.createClass(NS + "penatly");
                OntClass placeClass = base.createClass(NS + "place");
                OntClass presentMembersClass = base.createClass(NS + "presentMembers");
                OntClass trialClass = base.createClass(NS + "trial");

                OntClass lawArticleClass = base.createClass(NS + "lawArticle");

                OntClass accessoryPenaltyClass = base.createClass(NS + "accessoryPenalty");
                OntClass principalPenaltyClass = base.createClass(NS + "principalPenalty");
                OntClass suspendedSentenceClass = base.createClass(NS + "suspendedSentence");

                OntClass courtClass = base.createClass(NS + "court");
                OntClass lawofficeClass = base.createClass(NS + "lawoffice");

                OntClass staffClass = base.createClass(NS + "staff");
                OntClass defendantClass = base.createClass(NS + "defendant");
                OntClass defenderClass = base.createClass(NS + "defender");
                OntClass lawyerClass = base.createClass(NS + "lawyer");
                OntClass prosecutorClass = base.createClass(NS + "prosecutor");

                lawClass.addSubClass(lawArticleClass);
                penatlyClass.addSubClass(accessoryPenaltyClass);
                penatlyClass.addSubClass(principalPenaltyClass);
                penatlyClass.addSubClass(suspendedSentenceClass);
                placeClass.addSubClass(courtClass);
                placeClass.addSubClass(lawofficeClass);
                presentMembersClass.addSubClass(staffClass);
                presentMembersClass.addSubClass(defendantClass);
                presentMembersClass.addSubClass(defenderClass);
                presentMembersClass.addSubClass(lawyerClass);
                presentMembersClass.addSubClass(prosecutorClass);

                ObjectProperty abaseOnCrimeObjectProperty = base.createObjectProperty(NS + "baseOnCrime");
                abaseOnCrimeObjectProperty.addDomain(penatlyClass);
                abaseOnCrimeObjectProperty.addRange(crimeClass);
                abaseOnCrimeObjectProperty.addLabel("base on crime", "en");

                ObjectProperty baseOnLawObjectProperty = base.createObjectProperty(NS + "baseOnLaw");
                baseOnLawObjectProperty.addDomain(crimeClass);
                baseOnLawObjectProperty.addRange(lawArticleClass);
                baseOnLawObjectProperty.addLabel("base on law", "en");

                ObjectProperty beTriedObjectProperty = base.createObjectProperty(NS + "beTried");
                beTriedObjectProperty.addDomain(defendantClass);
                beTriedObjectProperty.addRange(trialClass);
                beTriedObjectProperty.addLabel("be tried", "en");

                ObjectProperty chargedObjectProperty = base.createObjectProperty(NS + "charged");
                chargedObjectProperty.addDomain(defendantClass);
                chargedObjectProperty.addRange(crimeClass);
                chargedObjectProperty.addLabel("charged", "en");

                ObjectProperty crimeTogetherObjectProperty = base.createObjectProperty(NS + "crimeTogether");
                crimeTogetherObjectProperty.addDomain(defendantClass);
                crimeTogetherObjectProperty.addRange(defendantClass);
                crimeTogetherObjectProperty.addLabel("crime together", "en");

                ObjectProperty defendObjectProperty = base.createObjectProperty(NS + "defend");
                defendObjectProperty.addDomain(defenderClass);
                defendObjectProperty.addRange(defendantClass);
                defendObjectProperty.addLabel("defend", "en");

                ObjectProperty hasDefendantObjectProperty = base.createObjectProperty(NS + "hasDefendant");
                hasDefendantObjectProperty.addDomain(docClass);
                hasDefendantObjectProperty.addRange(defendantClass);
                hasDefendantObjectProperty.addLabel("has defendant", "en");

                ObjectProperty hasLawyerObjectProperty = base.createObjectProperty(NS + "hasLawyer");
                hasLawyerObjectProperty.addDomain(defendantClass);
                hasLawyerObjectProperty.addRange(lawyerClass);
                hasLawyerObjectProperty.addLabel("has lawyer", "en");


                ObjectProperty hasPenaltyObjectProperty = base.createObjectProperty(NS + "hasPenalty");
                hasPenaltyObjectProperty.addDomain(defendantClass);
                hasPenaltyObjectProperty.addRange(penatlyClass);
                hasPenaltyObjectProperty.addLabel("has penalty", "en");

                ObjectProperty implementObjectProperty = base.createObjectProperty(NS + "implement");
                implementObjectProperty.addDomain(suspendedSentenceClass);
                implementObjectProperty.addDomain(principalPenaltyClass);
                implementObjectProperty.addDomain(accessoryPenaltyClass);
                implementObjectProperty.addRange(defendantClass);
                implementObjectProperty.addLabel("implement", "en");

                ObjectProperty inCourtObjectProperty = base.createObjectProperty(NS + "inCourt");
                inCourtObjectProperty.addDomain(docClass);
                inCourtObjectProperty.addRange(courtClass);
                inCourtObjectProperty.addLabel("in court", "en");

                ObjectProperty isFromObjectProperty = base.createObjectProperty(NS + "isFrom");
                isFromObjectProperty.addDomain(lawyerClass);
                isFromObjectProperty.addRange(lawofficeClass);
                isFromObjectProperty.addLabel("is from", "en");

                ObjectProperty isPartOfObjectProperty = base.createObjectProperty(NS + "isPartof");
                isPartOfObjectProperty.addDomain(lawArticleClass);
                isPartOfObjectProperty.addRange(lawClass);
                isPartOfObjectProperty.addLabel("is part of", "en");

                ObjectProperty judgementObjectProperty = base.createObjectProperty(NS + "judgement");
                judgementObjectProperty.addDomain(trialClass);
                judgementObjectProperty.addRange(crimeClass);
                judgementObjectProperty.addLabel("judgement", "en");

                ObjectProperty participationObjectProperty = base.createObjectProperty(NS + "participation");
                participationObjectProperty.addDomain(staffClass);
                participationObjectProperty.addDomain(defenderClass);
                participationObjectProperty.addDomain(prosecutorClass);
                participationObjectProperty.addRange(trialClass);
                participationObjectProperty.addLabel("participation", "en");

                ObjectProperty prosecuteObjectProperty = base.createObjectProperty(NS + "prosecute");
                prosecuteObjectProperty.addDomain(prosecutorClass);

                prosecuteObjectProperty.addRange(defendantClass);
                prosecuteObjectProperty.addLabel("prosecute", "en");

                ObjectProperty sponsorObjectProperty = base.createObjectProperty(NS + "sponsor");
                sponsorObjectProperty.addDomain(courtClass);

                sponsorObjectProperty.addRange(trialClass);
                sponsorObjectProperty.addLabel("sponsor", "en");

                ObjectProperty workOnObjectProperty = base.createObjectProperty(NS + "workOn");
                workOnObjectProperty.addDomain(defenderClass);
                workOnObjectProperty.addRange(lawyerClass);
                workOnObjectProperty.addLabel("work on", "en");

                ObjectProperty everCommittedObjectProperty = base.createObjectProperty(NS + "everCommitted");

                DatatypeProperty textDatatypeProperty = base.createDatatypeProperty(NS + "text");
                DatatypeProperty indexDatatypeProperty = base.createDatatypeProperty(NS + "index");


                File jsonFile = ResourceUtils.getFile(f.getAbsolutePath());
                String judicialId = f.getName().substring(0, f.getName().lastIndexOf("."));
                String judgementDate = "";
                ResultSet resultSet = statement.executeQuery("select judgement_date FROM judicial_document WHERE judicial_id=\"0000001ecd6de6a8fafd1dad348baf78\"");
                while (resultSet.next()) {
                    judgementDate = resultSet.getString("judgement_date");
                }

                String json = FileUtils.readFileToString(jsonFile);
//        String json = IOUtils.toString(Hai2OwlMethodTest.class.getClassLoader().getResource("test0106"), StandardCharsets.UTF_8);
                JSONObject o = JSON.parseObject(json);
                JsonUtils.removeEmpty(o);
                JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);

                HaiIndividual haiIndividual = new HaiIndividual();


                List<Individual> defendantIndividuals = new ArrayList<>();
                List<Individual> defenderIndividuals = new ArrayList<>();
                List<Individual> staffIndividuals = new ArrayList<>();

                List<Individual> lawArticleIndividuals = new ArrayList<>();
                List<Individual> crimeIndividuals = new ArrayList<>();
                Individual courtIndividual = null;

                Individual prosecutorIndividual = null;
                Individual trialIndividual = null;
                Individual docIndividual = null;
//        Map<String, Map<String, String>> defendantMap = new HashMap<>();
                if (jsonEntry.getDefendants() != null) {
                    //多位被告人
                    for (JsonEntry.DefendantsBean defendantsBean : jsonEntry.getDefendants()) {
                        Individual defendantIndividual = null;
                        Individual preConvictionsIndividual = null;
                        Individual defenderIndividual = null;
                        Individual lawyerIndividual = null;
                        Individual lawofficeIndividual = null;
                        Individual crimeIndividual = null;
                        Individual principalPenaltyIndividual = null;
                        Individual suspendedSentenceIndividual = null;
                        Individual accessoryPenaltyIndividual = null;

                        //为defendant相关创建实例
                        if (defendantsBean.getDefendant_base() != null) {
                            //defendant需要创建哪些属性
                            Map<String, Object> defendantProperties = new HashMap<>();
                            defendantProperties.put("被告人姓名", defendantsBean.getDefendant_base().getDefendant_name());
                            defendantProperties.put("被告人性别", defendantsBean.getDefendant_base().getS());
                            defendantProperties.put("被告人职业", defendantsBean.getDefendant_base().getDefendant_occupation());
                            defendantProperties.put("被告人民族", defendantsBean.getDefendant_base().getPN());
                            defendantProperties.put("被告人出生日期", defendantsBean.getDefendant_base().getBD());
                            defendantProperties.put("被告人出生地址", defendantsBean.getDefendant_base().getBA());
                            defendantProperties.put("被告人籍贯", defendantsBean.getDefendant_base().getDefendant_nativePlace());
                            defendantProperties.put("被告人住址", defendantsBean.getDefendant_base().getDR());
                            defendantProperties.put("被告人政治面貌", defendantsBean.getDefendant_base().getPS());
                            defendantProperties.put("被告人文化程度", defendantsBean.getDefendant_base().getE());

                            Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(defendantProperties);

                            //创建实例

                            if (haiIndividual.isEmptyIndividual(keyText, "被告人姓名") != null) {
                                Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(keyText, "被告人姓名");
                                defendantIndividual = haiIndividual.createIndividual(newKeyText, base, NS, defendantClass, "被告人姓名", textDatatypeProperty, indexDatatypeProperty);
                                defendantIndividuals.add(defendantIndividual);
                            }
                        }

                        //被告人为空则无需创建有无前科相关的实例
                        if (defendantIndividual != null) {
                            //为每位被告人创建有无前科相关的实例defendant_preConvictions
                            if (defendantsBean.getDefendant_preConvictions() != null) {
                                //defendant_preConvictions需要创建那些实例
                                Map<String, Object> preConvictionsProperties = new HashMap<>();
                                //每个被告人可能有多个前科
                                for (JsonEntry.DefendantsBean.DefendantPreConvictionsBean defendantPreConvictionsBean :
                                        defendantsBean.getDefendant_preConvictions()) {
                                    preConvictionsProperties.put("前科涉嫌罪名", defendantPreConvictionsBean.getPreConviction_chargeName());
                                    preConvictionsProperties.put("前科犯罪时间", defendantPreConvictionsBean.getPreConviction_time());
//                            preConvictionsProperties.put("前科判决结果", defendantPreConvictionsBean.getPreConviction_penalty());
                                    preConvictionsProperties.put("前科刑满日期", defendantPreConvictionsBean.getPreConviction_release());

                                    Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(preConvictionsProperties);

                                    if (haiIndividual.isEmptyIndividual(keyText, "前科涉嫌罪名") != null) {
                                        Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(keyText, "前科涉嫌罪名");
                                        preConvictionsIndividual = haiIndividual.createIndividual(newKeyText, base, NS, defendantClass, "前科涉嫌罪名", textDatatypeProperty, indexDatatypeProperty);
                                        defendantClass.dropIndividual(preConvictionsIndividual);
                                        //添加关系：被告人--everCommitted-》前科犯罪
                                        defendantIndividual.addProperty(everCommittedObjectProperty, preConvictionsIndividual);
                                    }
                                }
                                //可以在这里添加前科判决结果的实例
                            }
                        }


                        //为辩护人相关创建实例
                        if (defendantsBean.getAttorneys() != null) {
                            //辩护人
                            Map<String, Object> defenderProperties = new HashMap<>();
                            //律师
                            Map<String, Object> lawyerProperties = new HashMap<>();
                            //律所
                            Map<String, Object> lawofficeProperties = new HashMap<>();

                            for (JsonEntry.DefendantsBean.AttorneysBean attorneysBean :
                                    defendantsBean.getAttorneys()) {
                                defenderProperties.put("辩护人姓名", attorneysBean.getAttorney_name());
                                defenderProperties.put("辩护人职业", attorneysBean.getAttorney_occupation());
                                defenderProperties.put("辩护人工作单位", attorneysBean.getAttorney_workplace());

                                Map<String, Map<String, String>> defenderKeyText = haiIndividual.getKeyText(defenderProperties);
                                if (haiIndividual.isEmptyIndividual(defenderKeyText, "辩护人姓名") != null) {
                                    Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(defenderKeyText, "辩护人姓名");
                                    defenderIndividual = haiIndividual.createIndividual(newKeyText, base, NS, defenderClass, "辩护人姓名", textDatatypeProperty, indexDatatypeProperty);
                                    defenderIndividuals.add(defenderIndividual);
                                    if (defendantIndividual != null) {
                                        //添加关系：辩护人--defend-》被告人
                                        defenderIndividual.addProperty(defendObjectProperty, defendantIndividual);
                                    }
                                }
                                if (attorneysBean.getAttorney_type()!=null) {
                                    if (attorneysBean.getAttorney_type().getText().equals("律师")) {
                                        lawyerProperties.put("律师姓名", attorneysBean.getAttorney_name());
                                        lawyerProperties.put("律师工作单位", attorneysBean.getAttorney_workplace());

                                        lawofficeProperties.put("律所名称", attorneysBean.getAttorney_workplace());

                                        //律师相关的实例
                                        Map<String, Map<String, String>> lawyerKeyText = haiIndividual.getKeyText(lawyerProperties);
                                        if (haiIndividual.isEmptyIndividual(lawyerKeyText, "律师姓名") != null) {
                                            Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(lawyerKeyText, "律师姓名");
                                            lawyerIndividual = haiIndividual.createIndividual(newKeyText, base, NS, lawyerClass, "律师姓名", textDatatypeProperty, indexDatatypeProperty);
                                            //添加关系：被告人 --haslawyer->律师
                                            if (defendantIndividual != null) {
                                                defendantIndividual.addProperty(hasLawyerObjectProperty, lawyerIndividual);
                                            }
                                            //添加关系：辩护人--workOn->律师
                                            if (defenderIndividual != null) {
                                                defenderIndividual.addProperty(workOnObjectProperty, lawyerIndividual);

                                            }

                                        }
                                        //律所相关的实例
                                        Map<String, Map<String, String>> lawofficeKeyText = haiIndividual.getKeyText(lawofficeProperties);
                                        if (haiIndividual.isEmptyIndividual(lawofficeKeyText, "律所名称") != null) {
                                            Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(lawofficeKeyText, "律所名称");
                                            lawofficeIndividual = haiIndividual.createIndividual(newKeyText, base, NS, lawofficeClass, "律所名称", textDatatypeProperty, indexDatatypeProperty);
                                            //添加关系：律师 --attorney_name->律所
                                            if (lawyerIndividual != null)
                                                lawyerIndividual.addProperty(isFromObjectProperty, lawofficeIndividual);
                                        }
                                    }
                                }


                            }
                        }

                        //为涉嫌罪名创建实例
                        if (defendantsBean.getCharges() != null) {
                            Map<String, Object> crimeProperties = new HashMap<>();
                            for (JsonEntry.DefendantsBean.ChargesBean chargesBean :
                                    defendantsBean.getCharges()) {
                                crimeProperties.put("涉嫌罪名", chargesBean.getSuspect_charge_name());

                                Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(crimeProperties);
                                if (haiIndividual.isEmptyIndividual(keyText, "涉嫌罪名") != null) {
                                    Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(keyText, "涉嫌罪名");
                                    crimeIndividual = haiIndividual.createIndividual(newKeyText, base, NS, crimeClass, "涉嫌罪名", textDatatypeProperty, indexDatatypeProperty);
                                    crimeIndividuals.add(crimeIndividual);
                                    if (defendantIndividual != null) {
                                        //添加关系：被告人--charged-》涉嫌罪名
                                        defendantIndividual.addProperty(chargedObjectProperty, crimeIndividual);
                                    }
                                }
                            }
                        }

                        //为主刑，附加刑，缓刑创建实例
                        if (defendantsBean.getJudgment() != null) {
                            //主刑
                            Map<String, Object> principalPenaltyProperties = new HashMap<>();
                            //附加刑
                            Map<String, Object> accessoryPenaltyProperties = new HashMap<>();
                            //缓刑
                            Map<String, Object> suspendedSentenceProperties = new HashMap<>();
                            if (defendantsBean.getJudgment().getPenalties() != null) {
                                for (JsonEntry.DefendantsBean.JudgmentBeanX.PenaltiesBean penaltiesBean :
                                        defendantsBean.getJudgment().getPenalties()) {
//                            principalPenaltyProperties.put("判处罪名",penaltiesBean.getJA());
                                    principalPenaltyProperties.put("主刑", penaltiesBean.getPenalty_principal());
                                    principalPenaltyProperties.put("主刑刑法期间", penaltiesBean.getPenalty_duration());

                                    suspendedSentenceProperties.put("缓刑", penaltiesBean.getPenalty_suspend());

                                    //创建主刑实例
                                    Map<String, Map<String, String>> principalPenaltyKeyText = haiIndividual.getKeyText(principalPenaltyProperties);
                                    if (haiIndividual.isEmptyIndividual(principalPenaltyKeyText, "主刑") != null) {
                                        Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(principalPenaltyKeyText, "主刑");
                                        principalPenaltyIndividual = haiIndividual.createIndividual(newKeyText, base, NS, principalPenaltyClass, "主刑", textDatatypeProperty, indexDatatypeProperty);

                                        if (defendantIndividual != null) {
                                            //添加关系：主刑--implement-》被告人
                                            principalPenaltyIndividual.addProperty(implementObjectProperty, defendantIndividual);
                                        }
                                    }

                                    //创建缓刑实例
                                    Map<String, Map<String, String>> suspendedSentenceKeyText = haiIndividual.getKeyText(suspendedSentenceProperties);
                                    if (haiIndividual.isEmptyIndividual(suspendedSentenceKeyText, "缓刑") != null) {
                                        Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(suspendedSentenceKeyText, "缓刑");
                                        suspendedSentenceIndividual = haiIndividual.createIndividual(newKeyText, base, NS, suspendedSentenceClass, "缓刑", textDatatypeProperty, indexDatatypeProperty);

                                        if (defendantIndividual != null) {
                                            //添加关系：缓刑--implement-》被告人
                                            suspendedSentenceIndividual.addProperty(implementObjectProperty, defendantIndividual);
                                        }
                                    }

                                    if (penaltiesBean.getPenalty_supplementaries()!=null) {
                                        //创建附加刑实例
                                        for (JsonEntry.DefendantsBean.JudgmentBeanX.PenaltiesBean.PenaltySupplementariesBean penaltySupplementariesBean :
                                                penaltiesBean.getPenalty_supplementaries()) {
                                            accessoryPenaltyProperties.put("附加刑内容", penaltySupplementariesBean.getPenalty_supplementary_content());

                                            Map<String, Map<String, String>> accessoryPenaltyKeyText = haiIndividual.getKeyText(accessoryPenaltyProperties);
                                            if (haiIndividual.isEmptyIndividual(accessoryPenaltyKeyText, "附加刑内容") != null) {
                                                Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(accessoryPenaltyKeyText, "附加刑内容");
                                                accessoryPenaltyIndividual = haiIndividual.createIndividual(newKeyText, base, NS, accessoryPenaltyClass, "附加刑内容", textDatatypeProperty, indexDatatypeProperty);

                                                if (defendantIndividual != null) {
                                                    //添加关系：附加刑--implement-》被告人
                                                    accessoryPenaltyIndividual.addProperty(implementObjectProperty, defendantIndividual);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }

//        Individual individual1 = defendantClass.createIndividual(NS + "被告人1XXX");
//        individual1.addProperty(nameDatatypeProperty,"被告人1");
//        individual1.addProperty(occupationDatatypeProperty,"农民");


                if (jsonEntry.getJudgment() != null) {
                    Individual lawIndividual = null;
                    Individual lawAriticleIndividual = null;
                    if (jsonEntry.getJudgment().getStaff() != null) {
                        DatatypeProperty nameDatatypeProperty = base.createDatatypeProperty(NS + "姓名");
                        DatatypeProperty positionDatatypeProperty = base.createDatatypeProperty(NS + "职位");
                        //为审判长创建实例
                        if (jsonEntry.getJudgment().getStaff().getChief_judge() != null) {
                            if (jsonEntry.getJudgment().getStaff().getChief_judge().getText() != null) {
                                Individual individual = staffClass.createIndividual(NS + "/审判长/" + jsonEntry.getJudgment().getStaff().getChief_judge().getText());

                                individual.addProperty(nameDatatypeProperty, jsonEntry.getJudgment().getStaff().getChief_judge().getText());
                                individual.addProperty(positionDatatypeProperty, "审判长");
                                //审判长实例list集合
                                staffIndividuals.add(individual);
                            }
                        }

                        if (jsonEntry.getJudgment().getStaff().getJudges() != null) {
                            for (JsonEntry.JudgmentBean.StaffBean.JudgesBean judgesBean : jsonEntry.getJudgment().getStaff().getJudges()) {
                                if (judgesBean.getText() != null) {
                                    Individual individual = staffClass.createIndividual(NS + "/审判员/" + judgesBean.getText());
                                    individual.addProperty(nameDatatypeProperty, judgesBean.getText());
                                    individual.addProperty(positionDatatypeProperty, "审判员");
                                    //审判员实例list集合
                                    staffIndividuals.add(individual);
                                }
                            }
                        }

                        if (jsonEntry.getJudgment().getStaff().getJurors() != null) {
                            for (JsonEntry.JudgmentBean.StaffBean.JurorsBean jurorsBean : jsonEntry.getJudgment().getStaff().getJurors()) {
                                if (jurorsBean.getText() != null) {
                                    Individual individual = staffClass.createIndividual(NS + "/人民陪审员/" + jurorsBean.getText());
                                    individual.addProperty(nameDatatypeProperty, jurorsBean.getText());
                                    individual.addProperty(positionDatatypeProperty, "人民陪审员");
                                    //人民陪审员实例list集合
                                    staffIndividuals.add(individual);
                                }
                            }
                        }

                        if (jsonEntry.getJudgment().getStaff().getClerks() != null) {
                            for (JsonEntry.JudgmentBean.StaffBean.ClerksBean clerksBean : jsonEntry.getJudgment().getStaff().getClerks()) {
                                if (clerksBean.getText() != null) {
                                    Individual individual = staffClass.createIndividual(NS + "/书记员/" + clerksBean.getText());
                                    individual.addProperty(nameDatatypeProperty, clerksBean.getText());
                                    individual.addProperty(positionDatatypeProperty, "书记员");
                                    //人民陪审员实例list集合
                                    staffIndividuals.add(individual);
                                }
                            }
                        }

                    }
                    if (jsonEntry.getJudgment().getLaws() != null) {
                        Map<String, Object> lawProperties = new HashMap<>();
                        Map<String, Object> lawAriticleProperties = new HashMap<>();
                        for (JsonEntry.JudgmentBean.LawsBean lawsBean : jsonEntry.getJudgment().getLaws()) {

                            lawProperties.put("依据法律名称", lawsBean.getLaw_name());

                            Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(lawProperties);
                            if (haiIndividual.isEmptyIndividual(keyText, "依据法律名称") != null) {
                                Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(keyText, "依据法律名称");
                                lawIndividual = haiIndividual.createIndividual(newKeyText, base, NS, lawClass, "依据法律名称", textDatatypeProperty, indexDatatypeProperty);
                            }

                            if (lawsBean.getArticle_names() != null) {
                                for (JsonEntry.JudgmentBean.LawsBean.ArticleNamesBean articleNamesBean : lawsBean.getArticle_names()) {
                                    if (articleNamesBean.getText() != null) {
                                        lawAriticleIndividual = lawArticleClass.createIndividual(NS + "/依据法律条款/" + articleNamesBean.getText() );
                                        DatatypeProperty datatypeProperty = base.createDatatypeProperty(NS + "依据法律条款");
                                        lawAriticleIndividual.addProperty(datatypeProperty, articleNamesBean.getText());
                                        lawArticleIndividuals.add(lawAriticleIndividual);

                                        if (lawIndividual != null) {
                                            //添加关系：法律条款--implement-》法律名称
                                            lawAriticleIndividual.addProperty(isPartOfObjectProperty, lawIndividual);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                //创建court实例
                if (jsonEntry.getDocument_producer() != null) {
                    if (jsonEntry.getDocument_producer().getText() != null) {
                        Map<String, Object> courtProperties = new HashMap<>();
                        courtProperties.put("文书制作单位", jsonEntry.getDocument_producer());

                        Map<String, Map<String, String>> KeyText = haiIndividual.getKeyText(courtProperties);
                        if (haiIndividual.isEmptyIndividual(KeyText, "文书制作单位") != null) {
                            Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(KeyText, "文书制作单位");
                            courtIndividual = haiIndividual.createIndividual(newKeyText, base, NS, courtClass, "文书制作单位", textDatatypeProperty, indexDatatypeProperty);
                        }

                    }
                }

                //创建prosecutor实例
                if (jsonEntry.getAccusation() != null) {
                    Map<String, Object> prosecutorProperties = new HashMap<>();
                    prosecutorProperties.put("起诉人", jsonEntry.getAccusation().getAccusation_procurator());
                    prosecutorProperties.put("起诉文书号", jsonEntry.getAccusation().getAccusation_reference());
                    prosecutorProperties.put("起诉时间", jsonEntry.getAccusation().getAccusation_time());

                    Map<String, Map<String, String>> KeyText = haiIndividual.getKeyText(prosecutorProperties);
                    if (haiIndividual.isEmptyIndividual(KeyText, "起诉人") != null) {
                        Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(KeyText, "起诉人");
                        prosecutorIndividual = haiIndividual.createIndividual(newKeyText, base, NS, prosecutorClass, "起诉人", textDatatypeProperty, indexDatatypeProperty);

                    }

                }

                //创建trial实例
                if (jsonEntry.getHear_info() != null) {
                    Map<String, Object> trialProperties = new HashMap<>();
                    trialProperties.put("审理方式种类", jsonEntry.getHear_info().getHear_way());
                    trialProperties.put("审理公开情况", jsonEntry.getHear_info().getHear_isPublic());

                    Map<String, Map<String, String>> hearInfoKeyText = haiIndividual.getKeyText(trialProperties);
                    if (haiIndividual.isEmptyIndividual(hearInfoKeyText, "审理方式种类") != null) {
                        Map<String, Map<String, String>> newKeyText = haiIndividual.isEmptyIndividual(hearInfoKeyText, "审理方式种类");
                        trialIndividual = haiIndividual.createIndividual(newKeyText, base, NS, trialClass, "审理方式种类", textDatatypeProperty, indexDatatypeProperty);
                    }
                }

                //创建doc实例
                if (judicialId != null) {
                    docIndividual = docClass.createIndividual(NS + "/文书编号/" + judicialId);
                    DatatypeProperty judgementIdProperty = base.createDatatypeProperty(NS + "文书编号");
                    DatatypeProperty judgementDateProperty = base.createDatatypeProperty(NS + "审判时间");
                    DatatypeProperty documentCategoryProperty = base.createDatatypeProperty(NS + "案件类别");
                    DatatypeProperty JDNProperty = base.createDatatypeProperty(NS + "文书案号");
                    docIndividual.addProperty(judgementIdProperty, judicialId);
                    docIndividual.addProperty(judgementDateProperty, judgementDate);

                    if (jsonEntry.getDocument_category() != null) {
                        if (jsonEntry.getDocument_category().getText() != null) {
                            docIndividual.addProperty(documentCategoryProperty, jsonEntry.getDocument_category().getText());
                        }
                        if (jsonEntry.getDocument_reference() != null) {
                            if (jsonEntry.getDocument_reference().getJDN() != null) {
                                if (jsonEntry.getDocument_reference().getJDN().getText() != null) {
                                    docIndividual.addProperty(JDNProperty, jsonEntry.getDocument_reference().getJDN().getText());
                                }
                            }
                        }
                    }

                }


                if (defendantIndividuals.size() > 0) {
                    for (Individual dIndividual : defendantIndividuals) {
                        //添加关系：prosecutor--prosecute-》被告人
                        if (prosecutorIndividual != null)
                            prosecutorIndividual.addProperty(beTriedObjectProperty, dIndividual);
                        //添加关系：被告人--beTried-》trial
                        if (trialIndividual != null) dIndividual.addProperty(beTriedObjectProperty, trialIndividual);
                        //添加关系：doc--beTried-》trial
                        if (docIndividual != null) docIndividual.addProperty(hasDefendantObjectProperty, dIndividual);
                    }
                }

                if (defenderIndividuals.size() > 0) {
                    for (Individual deIndividual : defenderIndividuals) {
                        //添加关系：defender--participation-》trial
                        if (trialIndividual != null)
                            deIndividual.addProperty(participationObjectProperty, trialIndividual);
                    }
                }

                //添加关系：doc--inCourt-》court
                if (docIndividual != null && courtIndividual != null)
                    docIndividual.addProperty(inCourtObjectProperty, courtIndividual);
                //添加关系：court--sponsor-》trial
                if (courtIndividual != null && trialIndividual != null)
                    courtIndividual.addProperty(sponsorObjectProperty, trialIndividual);

                //添加关系：trial--judgement-》crime
                if (crimeIndividuals.size() > 0) {
                    for (Individual cIndividual : crimeIndividuals) {
                        if (trialIndividual != null) trialIndividual.addProperty(judgementObjectProperty, cIndividual);
                        if (lawArticleIndividuals.size() > 0) {
                            for (Individual lIndividual : lawArticleIndividuals) {
                                //添加关系：crime--baseOnLaw-》lawArticle
                                cIndividual.addProperty(baseOnLawObjectProperty, lIndividual);
                            }
                        }

                    }
                }
                //添加关系：prosecutor--participation-》trial
                if (prosecutorIndividual != null && trialIndividual != null)
                    prosecutorIndividual.addProperty(participationObjectProperty, trialIndividual);
                //添加关系：staff--participation-》trial
                if (staffIndividuals.size() > 0) {
                    for (Individual sIndividual : staffIndividuals) {
                        if (trialIndividual != null)
                            sIndividual.addProperty(participationObjectProperty, trialIndividual);
                    }
                }

                //添加关系：defendant-crimetogether-defendant
                if (defendantIndividuals.size() > 0) {
                    for (int i = 0; i < defendantIndividuals.size(); i++) {
                        for (int j = 0; j < defendantIndividuals.size(); j++) {
                            if (j != i) {
                                defendantIndividuals.get(i).addProperty(crimeTogetherObjectProperty, defendantIndividuals.get(j));
                            }
                        }
                    }
                }
                String filename=resultFile+judicialId+".owl";
                base.write(new FileOutputStream(new File(filename)), "RDF/XML-ABBREV");
            }
        }
    }
}

