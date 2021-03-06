package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.hyzs.entry.JsonEntry;
import org.hyzs.jena.HaiIndividual;
import org.hyzs.utils.JsonUtils;
import org.hyzs.utils.MySQLUtil;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-24 10:16
 **/
public class Hai2OwlMethodTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException {
        test3();
    }

    private static void test2() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        File jsonFile = ResourceUtils.getFile("classpath:test.json");
        String json = FileUtils.readFileToString(jsonFile);

//        String json = IOUtils.toString(Hai2OwlMethodTest.class.getClassLoader().getResource("test0106"), StandardCharsets.UTF_8);
        JSONObject o = JSON.parseObject(json);
        JsonUtils.removeEmpty(o);
        JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);
        Map<String, Map<String, String>> defendantMap = new HashMap<>();
        HaiIndividual haiIndividual = new HaiIndividual();
        if (jsonEntry.getDefendants() != null) {
            //多位被告人
            for (JsonEntry.DefendantsBean defendantsBean : jsonEntry.getDefendants()) {
                if (defendantsBean.getDefendant_base() != null) {
                    //判断defendant实例的keywords是否存在
                    if (defendantsBean.getDefendant_base().getDefendant_name() != null) {
                        //需要创建哪些属性
                        Map<String, Object> defendantProperties =new HashMap<>();
                        defendantProperties.put("被告人姓名",defendantsBean.getDefendant_base().getDefendant_name());
                        defendantProperties.put("被告人性别",defendantsBean.getDefendant_base().getS());
                        defendantProperties.put("被告人职业",defendantsBean.getDefendant_base().getDefendant_occupation());
                        defendantProperties.put("被告人民族",defendantsBean.getDefendant_base().getPN());
                        defendantProperties.put("被告人出生日期",defendantsBean.getDefendant_base().getBD());
                        defendantProperties.put("被告人出生地址",defendantsBean.getDefendant_base().getBA());
                        defendantProperties.put("被告人籍贯",defendantsBean.getDefendant_base().getDefendant_nativePlace());
                        defendantProperties.put("被告人住址",defendantsBean.getDefendant_base().getDR());
                        defendantProperties.put("被告人政治面貌",defendantsBean.getDefendant_base().getPS());
                        defendantProperties.put("被告人文化程度",defendantsBean.getDefendant_base().getE());



                        Map<String, Map<String, String>> keyText = haiIndividual.getKeyText(defendantProperties);
                        System.out.println(".");
                    }
                }
            }
        }
    }

    private static void test1() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        JSONObject o = JSON.parseObject(JSON.toJSONString(xsyspj));
        File jsonFile = ResourceUtils.getFile("classpath:test.json");
        String json = FileUtils.readFileToString(jsonFile);

//        String json = IOUtils.toString(Hai2OwlMethodTest.class.getClassLoader().getResource("test0106"), StandardCharsets.UTF_8);
        JSONObject o = JSON.parseObject(json);
        JsonUtils.removeEmpty(o);
        JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);

        HaiIndividual haiIndividual=new HaiIndividual();

        Map<String, Map<String, String>> defendantMap = new HashMap<>();
        if (jsonEntry.getDefendants() != null) {
            for (JsonEntry.DefendantsBean defendantsBean : jsonEntry.getDefendants()) {
                if (defendantsBean.getDefendant_base().getDefendant_name() != null) {
                    Map<String, Object> defendantProperties =new HashMap<>();
                    defendantProperties.put("被告人姓名",defendantsBean.getDefendant_base().getDefendant_name());
//                    for ( Map.Entry<String, Object> property : defendantProperties.entrySet()) {
//                        property.getKey();
//                        Class<?> s=property.getValue().getClass();
//
////                        Class clazz = Class.forName(className);
//                        for (Field f:property.getValue().getClass().getDeclaredFields()){   //遍历通过反射获取object的类中的属性名
//                            f.setAccessible(true);    //设置改变属性为可访问
//                            if(f.getName().equals("text")){
////                                String text= f.get(property.getValue().getClass().getMethod("getText")).toString();
//                                Method m = property.getValue().getClass().getMethod("getIndex");
//                                Object invoke = m.invoke(property.getValue());
//                                String index="";
//                                if (invoke!=null) {
//                                   index = invoke.toString();
//                                }else {
//                                     index = "";
//                                }
//                                System.out.println(index);
//                            }
//                    }
//
////                    defendantMap.put("被告人姓名", keyText);
//                }
            }

//        Individual individual=ontClass.createIndividual(keyWords);
            for (Map.Entry<String, Map<String, String>> property : defendantMap.entrySet()) {
//            DatatypeProperty datatypeProperty = base.createDatatypeProperty(NS + property.getKey());
                property.getKey();

                for (Map.Entry<String, String> keyText : property.getValue().entrySet()) {
                    keyText.getKey();
                    keyText.getValue();
                }
//            individual.addProperty(datatypeProperty,property.getValue());
            }
//        return individual;
            System.out.println("0");
        }
    }
}
private static void test3() throws SQLException {
    //json数据转化为实体
//        AiOpenClientConfig aiOpenClientConfig = new AiOpenClientConfig();
//        AIOpenClient aiClient = aiOpenClientConfig.aiOpenClient();
//        String text = "河南省沁阳市人民法院刑 事 判 决 书（2018）豫0882刑初522号公诉机关沁阳市人民检察院。被告人王鸿森，男，1966年3月1日出生于辽宁省鞍山市千山区，汉族，初中文化程度，无业，户籍所在地辽宁省鞍山市千山区。因涉嫌犯非法运输爆炸物罪于2017年10月28日被沁阳市公安局刑事拘留，于同年12月5日被逮捕。指定辩护人赵荣飞，河南陈彦东律师事务所律师。被告人原华北，男，1986年8月15日出生于辽宁省海城市，汉族，初中文化程度，鞍山市物流公司经营人，户籍所在地辽宁省鞍山市铁**，捕前住辽宁省鞍山市铁西区。因涉嫌犯非法运输爆炸物罪于2017年11月7日投案，同年11月8日被沁阳市公安局刑事拘留（期间羁押1天），于同年12月5日被逮捕。辩护人李博，辽宁钢城正大律师事务所律师。辩护人游丽媛，辽宁杜泽律师事务所律师。被告人王勤安，男，1964年6月14日出生于陕西省兴平市，汉族，初中文化程度，陕西兴华运输服务有限公司法定代表人，捕前住陕西省兴平市。因涉嫌犯非法运输爆炸物罪于2017年10月29日被沁阳市公安局刑事拘留，于同年12月5日被逮捕。辩护人李薇，陕西古渡律师事务所律师。沁阳市人民检察院以沁检公诉刑诉〔2018〕420号起诉书，指控被告人王鸿森、原华北、王勤安犯危险物品肇事罪，于2018年9月21日向本院提起公诉,同日予以立案。诉讼过程中，附带民事诉讼原告人吉林省通联供应链管理有限公司、河南省交通运输厅高速公路少林寺至新乡管理处、焦作市公安交通管理支队向本院提出附带民事诉讼。本院依法适用普通程序，组成合议庭，公开开庭进行了审理。沁阳市人民检察院指派检察员李玥言、检察官助理张丹丹出庭支持公诉，被告人王鸿森及其指定辩护人赵荣飞、被告人原华北及其辩护人李博、游丽媛、被告人王勤安及其辩护人李薇到庭参加了诉讼。诉讼期间，沁阳市人民检察院分别于2018年12月20日、2019年4月12日向本院申请延期审理，于2019年1月17日、2019年4月23日恢复审理。现已审理终结。经审理查明，陕西兴华运输服务有限公司成立于2012年3月13日，经营范围为普通货物运输、硝酸铵专项运输、货物信息服务（依法须经批准的项目，经相关部门批准后方可开展经营活动），被告人王勤安系该公司法定代表人。被告人原华北系鞍山市华北物流公司经营人，被告人王鸿森系原华北雇佣从事运输的司机。辽Ｃ×××**/辽CG1**车辆的道路运输证经营范围为道路普通货物运输，该车委托鞍山市金路通运输有限公司进行托管。2017年1月3日，陕西兴化集团有限责任公司的曹某代表该公司与黄某代表的鞍钢矿业爆破有限公司签订2017年度销售1.5万吨多孔硝酸铵和1.5万吨工业硝酸铵的购销合同，合同约定卖方库房交货、代办运输，提供爆炸物品运输证，运输费用由买受方承担。2017年9月20日，曹某代表陕西兴化集团有限责任公司与被告人王勤安代表的陕西兴华运输服务有限公司（未取得民用爆炸物品运输许可证）签订运输协议，内容为：“一、运输货物名称：硝酸铵；吨位：（实际供货量）吨；单吨运价：460元/吨；运费金额：按实际供货量计算；装货地点：陕西省兴平市陕西兴化集团有限责任公司库房；运达地：辽宁鞍钢矿业（大孤山、弓长岭、大连）；合同履行日期：2017年9月20日至2017年12月31日。二、运费结算及支付方式：1.款到发货；2.根据以前年度的合作模式及经验，用户提出为节省时效，方便供货及时、到货安全完整、不延误工期等一再要来改为一票制结算。乙方凭正规增值税专用运输发票在兴化集团财务结算运费，甲方应在受理运输票据后10日内现款结算付清运费（因要时给运输年辆的司机支付运费）；3.因石油价格上下浮动、国家交通部门政策性变动等因素，运费价格可做调整。三、乙方责任：1.运输车辆由乙方安排，路途安全事宜，承运方自行负责；2.保证货物在运输过程中的安全，严禁出现丢失、污染、溅水等情况；3.及时提供车辆运输，在装货启运后规定时间内抵达运达地，途中不得转车运输。装车启运后，及时给收货方传真或发短信我司发车车号及数量；4.按国家对硝酸铵的运输标准运输，严禁超载。运输途中发生交通事故、货物丢失损毁及其他意外事故所产生的责任与费用均由乙方承担。四、甲方责任：1.货物完整运至运达地由接货单位验收；2.车辆到达运达地及时办理手续卸车；3.向乙方提供爆炸物品运输证。五、本协议在执行过程中如有分歧，甲乙双方可通过友好协商及时解决，协商解决不成时按《合同法》有关规定处理。六、本协议正本一式两份，双方各执一份，签字盖章后生效。”运输协议签订后，王勤安在明知硝酸铵具有危险性，且未核实被告人原华北的车辆是否具备运输硝酸铵资质的情况下，安排原华北承运硝酸铵。2017年10月27日，原华北指派不具备相关驾驶资质且没有经过专业培训的被告人王鸿森、肖某等多名司机，驾驶其所有的十辆不具备道路危险货物运输许可，且挂车经加装油罐的大货车，在王勤安的安排下到陕西兴化集团有限责任公司装载硝酸铵，并运往辽宁鞍钢矿业爆破有限公司。2017年10月28日凌晨，由被告人王鸿森驾驶（肖某乘坐）的车牌照为辽辽Ｃ×××**型半挂牵引车/辽辽Ｃ×××**型仓栅式半挂车装载多孔硝酸铵，途经长济高速路K218+800米处沁阳市柏香高速路口附近路段，由超车道向行车道变更车道，以每小时0.35公里的速度（基本处于停驶状态）行驶时，后方由袁某驾驶（宋某1乘坐）的在行车道同方向行驶的吉Ｃ吉Ｃ×××**半挂牵引车/吉C吉C26**平板半挂车与王鸿森驾驶的车辆追尾，发生碰撞，起火燃烧，后引发辽Ｃ×辽Ｃ×××**×辽Ｃ×××**孔硝酸铵发生爆炸，造成一人死亡、多人受伤、周边群众受伤和房屋受损的后果。案发后，事故发生地所属的沁阳市柏香镇政府代收赔偿款共计28000000元，分别是：陕西兴化集团有限责任公司、陕西兴华运输服务有限公司以闫宏斌、陈团位、苏利平、张艳生、巨文涛、任伟、成莉、沁阳市公安局代转的名义先后转账19000000元，鞍山市金路通汽车销售有限公司以金素华的名义转账2000000元，鞍钢矿业爆破有限公司以陈伟、鞍钢名义转账7000000元（另1000000元转至沁阳市公安局取保候审保证金账户）。具体损失及赔偿情况如下：1.王鸿森驾驶的车牌照号为辽Ｃ×辽Ｃ×××**挂牵引车/辽Ｃ×辽Ｃ×××**栅式半挂车报废，经沁阳市价格认证中心认定，该车实际损失价值为233840元。2.袁某驾驶的车牌照号为吉Ｃ**吉Ｃ×××**牵引车/吉C**吉C26**半挂车报废，经沁阳市价格认证中心认定，该车实际损失价值为326233元；该车所拉货物价值为481742.14元；驾驶员袁某当场死亡，乘坐人宋某1受伤。经沁阳市公安局物证鉴定室鉴定,宋某1骨盆骨折、右侧肋骨多发性骨折，符合交通事故所致，根据病历材料及法医学检验，宋某1右侧2.3.4.8.9.10.11肋骨折、左侧髖自及耻、坐骨支骨折，损伤程度评定为轻伤一级；宋某1右耳鼓膜穿孔，符合爆炸冲击波所致，根据病历材料及法医学检验，宋某1右耳外伤性鼓膜穿孔6周不能自行愈合，损伤程度暂评定为轻伤二级，其损伤所致的并发症、后遗症待具备鉴定条件后予以补充鉴定。综上，宋某1损伤程度暂评定为轻伤一级。案发后，被害单位吉林省通联供应链管理有限公司获得赔偿款400000元，被害人杨某（系吉Ｃ×**吉Ｃ×××**际损失人）获得赔偿款525000元，被害人袁某的家属获得赔偿款1100000元，被害人宋某1获得赔偿款400000元。附带民事诉讼原告人吉林省通联供应链管理有限公司以民事部分已经解决为由向本院申请撤回起诉，本院已裁定准许其撤回起诉。3.途经该路段的鲁Ｅ×**鲁Ｅ×××**途乘用车报废，经沁阳市价格认证中心认定，该车损失价值为88000元；车上人员王某5、马某3、范某受伤。经沁阳市公安局物证鉴定室鉴定，王某5因爆炸致左眼球破裂，并行眼球摘除术，损伤程度评定为重伤二级，其面部损伤所致的后遗症、并发症待具备鉴定条件后再进行补充鉴定。案发后，鲁Ｅ×**鲁Ｅ×××**2获得赔偿款88000元，王某5获得赔偿款890000元。4.途经该路段的沪Ｄ×**沪Ｄ×××**沁阳市价格认证中心认定，该车部分损失价值为1315元。案发后，该车主叶丹获得赔偿款42000元。5.途经该路段的豫Ｃ×**豫Ｃ×××**厢式货车损坏，经沁阳市价格认证中心认定，该车损失价值为54321元；车上人员刘某3、盛某受伤。案发后，刘某3、盛某共获得赔偿85000元。6.途经该路段的豫H0**豫H05**沁阳市价格认证中心认定，该车损失价值为11640元；交警乔丙军受伤。案发后，被害单位焦作市公安交通管理支队获得赔偿款15450元。附带民事诉讼原告人焦作市公安交通管理支队以民事部分已经解决为由向本院申请撤回刑事附带民事起诉，本院已裁定准许其撤回起诉。7.途经该路段的豫Ａ××**豫Ａ×××**坏，经沁阳市价格认证中心认定，该车损失价值为14185元。8.事故发生地沁阳市柏香镇周边群众受伤和房屋受损价值为17180426.49元，沁阳市柏香镇政府出具证明，该损失已经全部代为赔付。9.案发地高速路段存在损毁，河南省交通运输厅高速公路少林寺至新乡管理处对此提出附带民事诉讼，本院经审查认为其提出的诉讼请求不在公诉机关指控范围，依法不能在本案中提起附带民事诉讼，已裁定不予受理。事故发生后，被告人王鸿森赶在爆炸之前积极救助后车乘坐人宋某1，在接受公安机关调查询问时主动表明肇事司机身份，归案后如实供述犯罪事实。2017年10月29日，沁阳市公安局将案发时被告人原华北安排一起运载硝酸铵的车牌照号为辽Ｃ××**辽Ｃ×××**C辽C91**××辽Ｃ×××**挂辽C26**×/辽Ｃ×××**、辽C17**/辽辽Ｃ×××**辽辽CG2**辽C辽Ｃ×××**Ｃ辽CG5**37辽Ｃ×××**扣押在沁阳市公安局停车场，将车辆上运输的硝酸铵查封于陕西兴化集团有限责任公司。2017年10月29日，被告人王勤安到陕西省咸阳市公安局秦岭分局惠兴派出所投案，归案后如实供述犯罪事实。2017年11月7日，被告人原华北到辽宁省鞍山市公安局立山分局曙光派出所投案，供述运输的是化肥，系一般货物，且对运输的是硝酸铵以及所运货物系危险品不知情。庭审中，原华北如实供述主要犯罪事实，当庭表示认罪。2017年11月8日，经国家民用爆破器材质量监督检验中心、南京理工大学化学材料测试中心鉴定,涉案多孔硝酸铵具有爆炸性。2017年11月14日，经陕西长安大学机动车物证司法鉴定中心鉴定，吉Ｃ×××**/吉C2吉Ｃ×××**瞬吉C26**约为56km/h；辽Ｃ×××**/辽Ｃ**辽Ｃ×××**瞬辽Ｃ×××**为0.35km/h，基本处于停驶状态。2017年11月28日，经焦作市公安交通管理支队高速公路交通管理处认定,被告人王鸿森的行为违反了《中华人民共和国道路交通安全法》第四十八条第一款“机动车载物应当符合核定的载质量，严禁超载；载物的长、宽、高不得违反装载要求，不得遗洒、飘散载运物”、《中华人民共和国道路交通安全法实施条例》第四十四条第二款“在道路同方向划有2条以上机动车道的，变更车道的机动车不得影响相关车道内行驶的机动车的正常行驶”和第七十八条第一款“高速公路应当标明车道的行驶速度，最高车速不得超过每小时120公里，最低车速不得低于每小时60公里”之规定，王鸿森驾驶的辽Ｃ×××**/辽Ｃ×**辽Ｃ×××**0辽Ｃ×××**度行驶，低于规定的最低时速行驶，是造成该起道路交通事故的原因。根据《中华人民共和国道路交通安全法实施条例》第九十一条之规定：一、王鸿森承担该起道路交通事故的全部责任；二、袁某、肖某、宋某1不承担该起道路交通事故的责任。上述事实，被告人王鸿森、原华北、王勤安在开庭审理过程中亦无异议。并有物证：车牌号为辽Ｃ×××**/辽C9**辽Ｃ×××**×辽C91**2B辽Ｃ×××**×辽C26**D挂辽Ｃ×××**×辽C17**挂、辽Ｃ×××**/辽CG2**、辽辽Ｃ×××**G辽CG5**车辆辽Ｃ×××**吨多孔粒状硝酸铵、35吨硝酸铵；书证：受案登记表，道路交通事故认定书，发破案经过，王鸿森、原华北、王勤安的照片、户籍证明及无违反犯罪记录证明，到案证明，车牌号为辽Ｃ×××**车的卡口记录、新安西出辽Ｃ×××**口的抓拍图像，焦某、胜雪、董某、梅某的机动车驾驶证复印件，接受证据材料清单及运输协议，19台车辆经营范围证明材料，王鸿森、肖某等人资质证明，肖某、韩某的资格证明，税收完税证明复印件、机动车销售发票复印件及鲁Ｅ×××**车辆信息，民用爆炸物品鲁Ｅ×××**省增值税专用发票复印件，兴平市市场和质量监督管理局出具的证明，陕西兴华运输公司的纳税情况证明、民用爆炸物品购买许可证复印件、营业执照复印件、道路运输经营许可证复印件、公司登记基本情况，陕西兴化集团运输公司货运服务中心的登记基本情况，陕西兴化集团有限责任公司营业执照复印件、民用爆炸物品销售许可证复印件、安全生产许可证复印件、开户许可证复印件、公司登记基本情况以及集团销售部开票员、业务员、库管员的岗位职责、销售部曹某于2017年10月31日出具的证明、硝铵车间高伟、冯卫出具的工业硝酸铵与多孔硝酸铵的区别说明，多孔粒状硝酸铵分析结果报告单复印件，库房发货记录台帐复印件，鞍钢矿业爆破有限公司民用爆炸物品生产许可证复印件、辽宁省民用爆炸物品安全生产许可证复印件、爆破作业单位许可证复印件、安全生产许可证复印件、营业执照复印件，黄某提供的身份证复印件及鞍钢爆破有限公司出具的情况说明，陈伟的身份证复印件，报价通知单复印件，民用爆炸物品购买许可证复印件，道路运输经营许可证，兴平市道路运输管理所出具的证明及兴平市国家税务局出具的证明，陕西省兴平化肥厂汽车运输有限责任公司设立登记档案、变更登记为陕西兴化集团运输公司的相关文件，陕西兴化集团运输公司变更经营范围、法定代表人相关文件，陕西兴化集团运输公司货物服务中心设立登记档案、变更登记档案及变更经营范围文件，陕西兴华运输服务有限公司基本情况说明，民用爆炸物品购销合同及鞍钢矿业爆破有限公司合同审批表复印件，多孔粒状硝酸铵质量抽检报告复印件，工业硝酸铵分析结果报告单复印件，货运单复印件，鞍钢矿业爆破有限公司文件，陕西兴化集团有限责任公司与陕西兴华运输服务有限公司签订的运输协议复印件，产品出库票复印件，陕西兴化集团有限责任公司销售部出具的证明、2017年1-10月兴化集团对鞍钢矿业销售硝酸铵出厂价格表、2017年1-10月兴化集团对鞍钢矿业销售硝酸铵价格表（含装运费），兴平市公安局治安管理大队出具的证明及情况说明，鞍山市金路通运输有限公司营业执照复印件、道路运输经营许可证复印件，陈玉书的身份证复印件，鞍山市金路通运输有限公司出具的情况说明、安全生产管理相关材料、危货运输企业从业人员安全教育培训手册、借款合同、贷款用户还款明细及证明、发票复印件，车牌号为辽Ｃ×××**/辽CG1**、辽Ｃ辽Ｃ×××**C辽CG1**Ｃ×辽Ｃ×××**G辽CG3**××辽Ｃ×××**5辽CG0**××辽Ｃ×××**2辽CG5**××辽Ｃ×××**C辽C26**、车辽Ｃ×××**记辽C92**证、检测评级信息及货车托管合同复印件，吉林省通联供应链管理有限公司营业执照复印件、道路运输经营许可证，吉林省通联供应链管理有限公司提供的吉吉Ｃ×××**注册登记信息复印件、公主岭市公安吉Ｃ×××**提供的吉吉Ｃ×××**检信息、交通违法行为记录及道路运吉Ｃ×××**，鞍山市金路通运输有限公司的车辆保险及检测档案材料复印件，胜雪、焦某、郭某2驾驶证、道路从业资质复印件，燕东职务证明、身份证复印件，车辆所有人证明及贷款用户还款明细，矿业爆破有限公司硝酸铵采购流程优化措施，矿业爆破有限公司提供的民用爆破器材买卖合同复印件、民用爆炸物品购销合同复印件，陕西兴化集团有限责任公司销售部出具的说明，大车照片，办案说明，受伤人宋某1妻子郭春霞、死亡人袁某妻子宫丽艳出具的证明，沁阳市柏香镇受损情况证明、赔偿证明，2017年硝酸铵行业工作会资料，运输协议、运输款项凭证，2016年5月22日和7月30日运输硝酸铵的运输时间、车号、单价等情况登记以及运输费用支付银行转账记录，王勤安和兴华运输公司转给柏香镇政府款项部分凭证等；证人张某1、任某、赵某1、曹某、王某1、桂某、王某2、王某3、黄某、张某2、吴某、艾某、马某1、高某、李某1、胡某、林某、肖某、郭某1、贾某、刘某1、焦某、胜雪、祖某、许某、韩某、郭某2、何某1、董某、赵某2、马某2、梅某、张某3、何某2、王某4、陈某、杨某的证言；被害人宋某1、庞某、张某4、王某5、马某3、范某、刘某2、宋某2、王某6、宰某、秦某、孙某、李某2、刘某3、盛某的陈述；鉴定意见：DNA鉴定书，检验报告、鉴定人资格证书及鉴定机构资格证书，血液酒精含量检验报告单两份、鉴定资质，伤情鉴定书、鉴定人资格证书及鉴定机构资格证书，价格认定结论书、车辆损失价格认定清单、沁阳市公安局价格认定协助书、价格认定标的物明细表，长济高速公路10·28交通事故鉴定意见书、司法鉴定许可证及鉴定人资质证明复印件，检验报告两份、资质认定授权证书、资质认定计量认证证书及附表、鉴定人资质证明、爆炸嫌疑物鉴定委托单两份、附图17张；现场勘验笔录及3张现场勘验制图、64张现场照片、提取痕迹、物证登记表，车辆检验笔录2份及检验照片；视听资料等证据证实，足以认定。本院认为，危险物品肇事罪是指违反爆炸性、易燃性、放射性、毒害性、腐蚀性物品的管理规定，在生产、储存、运输、使用中，由于过失发生重大事故，造成严重后果的行为。本案中，被告人王鸿森、原华北、王勤安违反爆炸性物品的管理规定，在运输具有爆炸性的硝酸铵过程中,因王鸿森驾驶车辆与同向行驶的后车发生碰撞后起火燃烧,引发车辆上的多孔硝酸铵发生爆炸的重大事故,给人民群众的生命、身体健康和公私财产造成严重危害，后果特别严重,其行为均构成危险物品肇事罪。沁阳市人民检察院指控王鸿森、原华北、王勤安犯危险物品肇事罪，事实清楚，证据确实、充分，予以确认。三被告人在未依法取得相关安全许可证件的情况下，从事生产经营活动，依法应当从重处罚。鉴于被告人王鸿森在接受公安机关询问时主动表明肇事司机身份，归案后如实供述犯罪事实，应视为自首，依法可以从轻或者减轻处罚。事故发生后，王鸿森积极救助后车乘坐人宋某1，可对其酌情从轻处罚。被告人原华北虽然主动到公安机关投案，但其归案后未如实供述罪行，不构成自首，鉴于其当庭如实供述罪行，依法可以从轻处罚。被告人王勤安主动到公安机关投案，归案后如实供述犯罪事实，系自首，依法可以从轻或者减轻处罚。王勤安任法定代表人的陕西兴华运输服务有限公司积极赔偿造成的经济损失，可对其酌情从轻处罚。本案造成的大部分损失已得到弥补，亦可对三被告人酌情从轻处罚。根据王勤安的犯罪情节、悔罪表现等情形，对其适用缓刑符合法律规定，可对其宣告缓刑。在案扣押的六辆大货车，以及查封车辆上运输的硝酸铵，与本案无关，应由扣押、查封机关依法处理。根据被告人王鸿森、原华北、王勤安犯罪的事实、性质、情节及社会危害程度等，依照《中华人民共和国刑法》第一百三十六条、第六十七条第一、三款、第七十二条、第七十三条，《最高人民法院、最高人民检察院关于办理危害生产安全刑事案件适用法律若干问题的解释》第七条第一款第二项、第十二条第一款第一项、第十三条，《最高人民法院关于处理自首和立功若干具体问题的意见》一之规定，判决如下：被告人王鸿森犯危险物品肇事罪，判处有期徒刑三年十个月。（刑期从判决执行之日起开始计算。判决执行以前先行羁押的，羁押一日折抵刑期一日。即自2017年10月28日起至2021年8月27日止。）被告人原华北犯危险物品肇事罪，判处有期徒刑三年六个月。（刑期从判决执行之日起开始计算。判决执行以前先行羁押的，羁押一日折抵刑期一日。即自2017年11月8日起至2021年5月6日止。）被告人王勤安犯危险物品肇事罪，判处有期徒刑二年六个月，缓刑三年。（缓刑考验期从判决确定之日起开始计算。）如不服本判决，可在接到判决书的第二日起十日内，通过本院或直接向河南省焦作市中级人民法院提出上诉。书面上诉的，应当提交上诉状正本一份，副本七份。审　判　长　　张敏洁审　判　员　　范献献人民陪审员　　朱伟锋二〇一九年五月十七日书　记　员　　樊　晨";
//        Map<String, Object> xsyspj = aiClient.nerAggregation("xsyspj", text);
//        JSONObject o = JSON.parseObject(JSON.toJSONString(xsyspj));
//        JsonUtils.removeEmpty(o);
//        JsonEntry jsonEntry = JSON.parseObject(o.toJSONString(), JsonEntry.class);

    Connection connection = MySQLUtil.getConnection();
    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery("select judgement_date FROM judicial_document WHERE judicial_id=\"0000001ecd6de6a8fafd1dad348baf78\"");
    while (resultSet.next()) {
        String judgement_date = resultSet.getString("judgement_date");
        System.out.println(judgement_date);
    }
}
}
