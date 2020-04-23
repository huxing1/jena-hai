package org.hyzs.entry;

import java.util.List;

/**
 * @program: jena-hai
 * @description:
 * @author: hux
 * @create: 2020-04-22 11:54
 **/
public class JsonEntry {
    /**
     * document_name : {"index":"","text":""}
     * document_producer : {"index":"","text":""}
     * document_type : {"index":"","text":""}
     * document_reference : {"JDN":{"index":"","text":""},"trail":{"index":"","text":""}}
     * document_category : {"index":"","text":""}
     * prosecutors : {"index":"","text":""}
     * defendants : [{"defendant_base":{"defendant_name":{"index":"","text":""},"NN":{"index":"","text":""},"FN":{"index":"","text":""},"S":{"index":"","text":""},"BD":{"index":"","text":""},"BA":{"index":"","text":""},"PN":{"index":"","text":""},"defendant_nativePlace":{"index":"","text":""},"FA":{"index":"","text":""},"defendant_occupation":{"index":"","text":""},"DR":{"index":"","text":""},"PS":{"index":"","text":""},"E":{"index":"","text":""},"defendant_capacity":{"index":"","text":""},"defendant_identity":{"index":"","text":""},"special_identity":{"identity_foreigner":{"index":"","text":""},"identity_hongkongmacau":{"index":"","text":""},"identity_taiwan":{"index":"","text":""},"identity_partygroupings":{"index":"","text":""},"identity_officer":{"index":"","text":""},"identity_leader":{"index":"","text":""},"identity_intellectual":{"index":"","text":""},"identity_npc_member":{"index":"","text":""},"identity_cppcc_members":{"index":"","text":""},"identity_star":{"index":"","text":""},"identity_sportstar":{"index":"","text":""},"identity_others":{"index":"","text":""}}},"defendant_preConvictions":[{"preConviction_time":{"index":"","text":""},"preConviction_chargeName":{"index":"","text":""},"preConviction_penalty":[{"index":"","text":""}],"preConviction_release":{"index":"","text":""}}],"charges":[{"suspect_charge_name":{"index":"","text":""},"charge_enforcements":[{"charge_enforcement_type":{"index":"","text":""},"charge_enforcement_time":{"index":"","text":""},"charge_enforcement_organ":{"index":"","text":""}}]}],"detain":{"inPrison":{"index":"","text":""},"inPrison_place":{"index":"","text":""}},"attorneys":[{"attorney_type":{"index":"","text":""},"attorney_name":{"index":"","text":""},"attorney_workplace":{"index":"","text":""},"attorney_occupation":{"index":"","text":""},"attorney_relation":{"index":"","text":""}}],"judgment":{"defendant_joint_crime":{"index":"","text":""},"penalties":[{"JA":{"index":"","text":""},"penalty_principal":{"index":"","text":""},"penalty_suspend":{"index":"","text":""},"penalty_supplementaries":[{"penalty_supplementary_type":{"index":"","text":""},"penalty_supplementary_content":{"index":"","text":""},"penalty_supplementary_money":{"index":"","text":""}}],"penalty_duration":{"index":"","text":""},"penalty_notimprison":{"index":"","text":""}}]}}]
     * accusation : {"accusation_type":{"index":"","text":""},"accusation_procurator":{"index":"","text":""},"accusation_reference":{"index":"","text":""},"prosecute_charge_name":{"index":"","text":""},"accusation_time":{"index":"","text":""}}
     * hear_info : {"hear_way":{"index":"","text":""},"hear_procedure":{"index":"","text":""},"hear_isPublic":{"index":"","text":""},"hear_prosecutors":[{"hear_prosecutor_name":{"index":"","text":""},"hear_prosecutor_occupation":{"index":"","text":""}}],"hear_defendant_names":[{"index":"","text":""}],"hear_attorney_names":[{"index":"","text":""}],"hear_time":{"index":"","text":""}}
     * evidences : {"evidence_object":[{"index":"","text":""}],"evidence_text":[{"index":"","text":""}],"witness_testimony":[{"index":"","text":""}],"plaintiff_statement":[{"index":"","text":""}],"accused_statement":[{"index":"","text":""}],"expert_conclusion":[{"index":"","text":""}],"evidence_records":[{"index":"","text":""}],"evidence_audiovisuals":[{"index":"","text":""}],"evidence_others":[{"index":"","text":""}]}
     * judgment : {"affirm_content":[{"index":"","text":""}],"notaffirm_content":[{"index":"","text":""}],"notaffirm_reasons":{"procedure_illegal":{"index":"","text":""},"means_illegal":{"index":"","text":""},"form_illegal":{"index":"","text":""},"fakeevidence":{"index":"","text":""},"evidence_suspected":{"index":"","text":""},"fakecopy":{"index":"","text":""},"evidence_flaw":{"index":"","text":""},"evidence_unverify":{"index":"","text":""},"fact_norelevance":{"index":"","text":""},"doubt":{"index":"","text":""},"evidence_old":{"index":"","text":""},"other":{"index":"","text":""}},"laws":[{"law_name":{"index":"","text":""},"article_names":[{"index":"","text":""}]}],"appeal":{"appeal_due":{"index":"","text":""},"appeal_courts":[{"index":"","text":""}]},"staff":{"judges":[{"index":"","text":""}],"chief_judge":{"index":"","text":""},"jurors":[{"index":"","text":""}],"clerks":[{"index":"","text":""}]},"judgement_date":{"index":"","text":""}}
     */

    private DocumentNameBean document_name;
    private DocumentProducerBean document_producer;
    private DocumentTypeBean document_type;
    private DocumentReferenceBean document_reference;
    private DocumentCategoryBean document_category;
    private ProsecutorsBean prosecutors;
    private AccusationBean accusation;
    private HearInfoBean hear_info;
    private EvidencesBean evidences;
    private JudgmentBean judgment;
    private List<DefendantsBean> defendants;

    public DocumentNameBean getDocument_name() {
        return document_name;
    }

    public void setDocument_name(DocumentNameBean document_name) {
        this.document_name = document_name;
    }

    public DocumentProducerBean getDocument_producer() {
        return document_producer;
    }

    public void setDocument_producer(DocumentProducerBean document_producer) {
        this.document_producer = document_producer;
    }

    public DocumentTypeBean getDocument_type() {
        return document_type;
    }

    public void setDocument_type(DocumentTypeBean document_type) {
        this.document_type = document_type;
    }

    public DocumentReferenceBean getDocument_reference() {
        return document_reference;
    }

    public void setDocument_reference(DocumentReferenceBean document_reference) {
        this.document_reference = document_reference;
    }

    public DocumentCategoryBean getDocument_category() {
        return document_category;
    }

    public void setDocument_category(DocumentCategoryBean document_category) {
        this.document_category = document_category;
    }

    public ProsecutorsBean getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(ProsecutorsBean prosecutors) {
        this.prosecutors = prosecutors;
    }

    public AccusationBean getAccusation() {
        return accusation;
    }

    public void setAccusation(AccusationBean accusation) {
        this.accusation = accusation;
    }

    public HearInfoBean getHear_info() {
        return hear_info;
    }

    public void setHear_info(HearInfoBean hear_info) {
        this.hear_info = hear_info;
    }

    public EvidencesBean getEvidences() {
        return evidences;
    }

    public void setEvidences(EvidencesBean evidences) {
        this.evidences = evidences;
    }

    public JudgmentBean getJudgment() {
        return judgment;
    }

    public void setJudgment(JudgmentBean judgment) {
        this.judgment = judgment;
    }

    public List<DefendantsBean> getDefendants() {
        return defendants;
    }

    public void setDefendants(List<DefendantsBean> defendants) {
        this.defendants = defendants;
    }

    public static class DocumentNameBean {
        /**
         * index :
         * text :
         */

        private String index;
        private String text;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class DocumentProducerBean {
        /**
         * index :
         * text :
         */

        private String index;
        private String text;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class DocumentTypeBean {
        /**
         * index :
         * text :
         */

        private String index;
        private String text;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class DocumentReferenceBean {
        /**
         * JDN : {"index":"","text":""}
         * trail : {"index":"","text":""}
         */

        private JDNBean JDN;
        private TrailBean trail;

        public JDNBean getJDN() {
            return JDN;
        }

        public void setJDN(JDNBean JDN) {
            this.JDN = JDN;
        }

        public TrailBean getTrail() {
            return trail;
        }

        public void setTrail(TrailBean trail) {
            this.trail = trail;
        }

        public static class JDNBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class TrailBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class DocumentCategoryBean {
        /**
         * index :
         * text :
         */

        private String index;
        private String text;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class ProsecutorsBean {
        /**
         * index :
         * text :
         */

        private String index;
        private String text;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class AccusationBean {
        /**
         * accusation_type : {"index":"","text":""}
         * accusation_procurator : {"index":"","text":""}
         * accusation_reference : {"index":"","text":""}
         * prosecute_charge_name : {"index":"","text":""}
         * accusation_time : {"index":"","text":""}
         */

        private AccusationTypeBean accusation_type;
        private AccusationProcuratorBean accusation_procurator;
        private AccusationReferenceBean accusation_reference;
        private ProsecuteChargeNameBean prosecute_charge_name;
        private AccusationTimeBean accusation_time;

        public AccusationTypeBean getAccusation_type() {
            return accusation_type;
        }

        public void setAccusation_type(AccusationTypeBean accusation_type) {
            this.accusation_type = accusation_type;
        }

        public AccusationProcuratorBean getAccusation_procurator() {
            return accusation_procurator;
        }

        public void setAccusation_procurator(AccusationProcuratorBean accusation_procurator) {
            this.accusation_procurator = accusation_procurator;
        }

        public AccusationReferenceBean getAccusation_reference() {
            return accusation_reference;
        }

        public void setAccusation_reference(AccusationReferenceBean accusation_reference) {
            this.accusation_reference = accusation_reference;
        }

        public ProsecuteChargeNameBean getProsecute_charge_name() {
            return prosecute_charge_name;
        }

        public void setProsecute_charge_name(ProsecuteChargeNameBean prosecute_charge_name) {
            this.prosecute_charge_name = prosecute_charge_name;
        }

        public AccusationTimeBean getAccusation_time() {
            return accusation_time;
        }

        public void setAccusation_time(AccusationTimeBean accusation_time) {
            this.accusation_time = accusation_time;
        }

        public static class AccusationTypeBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class AccusationProcuratorBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class AccusationReferenceBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class ProsecuteChargeNameBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class AccusationTimeBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class HearInfoBean {
        /**
         * hear_way : {"index":"","text":""}
         * hear_procedure : {"index":"","text":""}
         * hear_isPublic : {"index":"","text":""}
         * hear_prosecutors : [{"hear_prosecutor_name":{"index":"","text":""},"hear_prosecutor_occupation":{"index":"","text":""}}]
         * hear_defendant_names : [{"index":"","text":""}]
         * hear_attorney_names : [{"index":"","text":""}]
         * hear_time : {"index":"","text":""}
         */

        private HearWayBean hear_way;
        private HearProcedureBean hear_procedure;
        private HearIsPublicBean hear_isPublic;
        private HearTimeBean hear_time;
        private List<HearProsecutorsBean> hear_prosecutors;
        private List<HearDefendantNamesBean> hear_defendant_names;
        private List<HearAttorneyNamesBean> hear_attorney_names;

        public HearWayBean getHear_way() {
            return hear_way;
        }

        public void setHear_way(HearWayBean hear_way) {
            this.hear_way = hear_way;
        }

        public HearProcedureBean getHear_procedure() {
            return hear_procedure;
        }

        public void setHear_procedure(HearProcedureBean hear_procedure) {
            this.hear_procedure = hear_procedure;
        }

        public HearIsPublicBean getHear_isPublic() {
            return hear_isPublic;
        }

        public void setHear_isPublic(HearIsPublicBean hear_isPublic) {
            this.hear_isPublic = hear_isPublic;
        }

        public HearTimeBean getHear_time() {
            return hear_time;
        }

        public void setHear_time(HearTimeBean hear_time) {
            this.hear_time = hear_time;
        }

        public List<HearProsecutorsBean> getHear_prosecutors() {
            return hear_prosecutors;
        }

        public void setHear_prosecutors(List<HearProsecutorsBean> hear_prosecutors) {
            this.hear_prosecutors = hear_prosecutors;
        }

        public List<HearDefendantNamesBean> getHear_defendant_names() {
            return hear_defendant_names;
        }

        public void setHear_defendant_names(List<HearDefendantNamesBean> hear_defendant_names) {
            this.hear_defendant_names = hear_defendant_names;
        }

        public List<HearAttorneyNamesBean> getHear_attorney_names() {
            return hear_attorney_names;
        }

        public void setHear_attorney_names(List<HearAttorneyNamesBean> hear_attorney_names) {
            this.hear_attorney_names = hear_attorney_names;
        }

        public static class HearWayBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class HearProcedureBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class HearIsPublicBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class HearTimeBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class HearProsecutorsBean {
            /**
             * hear_prosecutor_name : {"index":"","text":""}
             * hear_prosecutor_occupation : {"index":"","text":""}
             */

            private HearProsecutorNameBean hear_prosecutor_name;
            private HearProsecutorOccupationBean hear_prosecutor_occupation;

            public HearProsecutorNameBean getHear_prosecutor_name() {
                return hear_prosecutor_name;
            }

            public void setHear_prosecutor_name(HearProsecutorNameBean hear_prosecutor_name) {
                this.hear_prosecutor_name = hear_prosecutor_name;
            }

            public HearProsecutorOccupationBean getHear_prosecutor_occupation() {
                return hear_prosecutor_occupation;
            }

            public void setHear_prosecutor_occupation(HearProsecutorOccupationBean hear_prosecutor_occupation) {
                this.hear_prosecutor_occupation = hear_prosecutor_occupation;
            }

            public static class HearProsecutorNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class HearProsecutorOccupationBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class HearDefendantNamesBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class HearAttorneyNamesBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class EvidencesBean {
        private List<EvidenceObjectBean> evidence_object;
        private List<EvidenceTextBean> evidence_text;
        private List<WitnessTestimonyBean> witness_testimony;
        private List<PlaintiffStatementBean> plaintiff_statement;
        private List<AccusedStatementBean> accused_statement;
        private List<ExpertConclusionBean> expert_conclusion;
        private List<EvidenceRecordsBean> evidence_records;
        private List<EvidenceAudiovisualsBean> evidence_audiovisuals;
        private List<EvidenceOthersBean> evidence_others;

        public List<EvidenceObjectBean> getEvidence_object() {
            return evidence_object;
        }

        public void setEvidence_object(List<EvidenceObjectBean> evidence_object) {
            this.evidence_object = evidence_object;
        }

        public List<EvidenceTextBean> getEvidence_text() {
            return evidence_text;
        }

        public void setEvidence_text(List<EvidenceTextBean> evidence_text) {
            this.evidence_text = evidence_text;
        }

        public List<WitnessTestimonyBean> getWitness_testimony() {
            return witness_testimony;
        }

        public void setWitness_testimony(List<WitnessTestimonyBean> witness_testimony) {
            this.witness_testimony = witness_testimony;
        }

        public List<PlaintiffStatementBean> getPlaintiff_statement() {
            return plaintiff_statement;
        }

        public void setPlaintiff_statement(List<PlaintiffStatementBean> plaintiff_statement) {
            this.plaintiff_statement = plaintiff_statement;
        }

        public List<AccusedStatementBean> getAccused_statement() {
            return accused_statement;
        }

        public void setAccused_statement(List<AccusedStatementBean> accused_statement) {
            this.accused_statement = accused_statement;
        }

        public List<ExpertConclusionBean> getExpert_conclusion() {
            return expert_conclusion;
        }

        public void setExpert_conclusion(List<ExpertConclusionBean> expert_conclusion) {
            this.expert_conclusion = expert_conclusion;
        }

        public List<EvidenceRecordsBean> getEvidence_records() {
            return evidence_records;
        }

        public void setEvidence_records(List<EvidenceRecordsBean> evidence_records) {
            this.evidence_records = evidence_records;
        }

        public List<EvidenceAudiovisualsBean> getEvidence_audiovisuals() {
            return evidence_audiovisuals;
        }

        public void setEvidence_audiovisuals(List<EvidenceAudiovisualsBean> evidence_audiovisuals) {
            this.evidence_audiovisuals = evidence_audiovisuals;
        }

        public List<EvidenceOthersBean> getEvidence_others() {
            return evidence_others;
        }

        public void setEvidence_others(List<EvidenceOthersBean> evidence_others) {
            this.evidence_others = evidence_others;
        }

        public static class EvidenceObjectBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class EvidenceTextBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class WitnessTestimonyBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class PlaintiffStatementBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class AccusedStatementBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class ExpertConclusionBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class EvidenceRecordsBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class EvidenceAudiovisualsBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class EvidenceOthersBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class JudgmentBean {
        /**
         * affirm_content : [{"index":"","text":""}]
         * notaffirm_content : [{"index":"","text":""}]
         * notaffirm_reasons : {"procedure_illegal":{"index":"","text":""},"means_illegal":{"index":"","text":""},"form_illegal":{"index":"","text":""},"fakeevidence":{"index":"","text":""},"evidence_suspected":{"index":"","text":""},"fakecopy":{"index":"","text":""},"evidence_flaw":{"index":"","text":""},"evidence_unverify":{"index":"","text":""},"fact_norelevance":{"index":"","text":""},"doubt":{"index":"","text":""},"evidence_old":{"index":"","text":""},"other":{"index":"","text":""}}
         * laws : [{"law_name":{"index":"","text":""},"article_names":[{"index":"","text":""}]}]
         * appeal : {"appeal_due":{"index":"","text":""},"appeal_courts":[{"index":"","text":""}]}
         * staff : {"judges":[{"index":"","text":""}],"chief_judge":{"index":"","text":""},"jurors":[{"index":"","text":""}],"clerks":[{"index":"","text":""}]}
         * judgement_date : {"index":"","text":""}
         */

        private NotaffirmReasonsBean notaffirm_reasons;
        private AppealBean appeal;
        private StaffBean staff;
        private JudgementDateBean judgement_date;
        private List<AffirmContentBean> affirm_content;
        private List<NotaffirmContentBean> notaffirm_content;
        private List<LawsBean> laws;

        public NotaffirmReasonsBean getNotaffirm_reasons() {
            return notaffirm_reasons;
        }

        public void setNotaffirm_reasons(NotaffirmReasonsBean notaffirm_reasons) {
            this.notaffirm_reasons = notaffirm_reasons;
        }

        public AppealBean getAppeal() {
            return appeal;
        }

        public void setAppeal(AppealBean appeal) {
            this.appeal = appeal;
        }

        public StaffBean getStaff() {
            return staff;
        }

        public void setStaff(StaffBean staff) {
            this.staff = staff;
        }

        public JudgementDateBean getJudgement_date() {
            return judgement_date;
        }

        public void setJudgement_date(JudgementDateBean judgement_date) {
            this.judgement_date = judgement_date;
        }

        public List<AffirmContentBean> getAffirm_content() {
            return affirm_content;
        }

        public void setAffirm_content(List<AffirmContentBean> affirm_content) {
            this.affirm_content = affirm_content;
        }

        public List<NotaffirmContentBean> getNotaffirm_content() {
            return notaffirm_content;
        }

        public void setNotaffirm_content(List<NotaffirmContentBean> notaffirm_content) {
            this.notaffirm_content = notaffirm_content;
        }

        public List<LawsBean> getLaws() {
            return laws;
        }

        public void setLaws(List<LawsBean> laws) {
            this.laws = laws;
        }

        public static class NotaffirmReasonsBean {
            /**
             * procedure_illegal : {"index":"","text":""}
             * means_illegal : {"index":"","text":""}
             * form_illegal : {"index":"","text":""}
             * fakeevidence : {"index":"","text":""}
             * evidence_suspected : {"index":"","text":""}
             * fakecopy : {"index":"","text":""}
             * evidence_flaw : {"index":"","text":""}
             * evidence_unverify : {"index":"","text":""}
             * fact_norelevance : {"index":"","text":""}
             * doubt : {"index":"","text":""}
             * evidence_old : {"index":"","text":""}
             * other : {"index":"","text":""}
             */

            private ProcedureIllegalBean procedure_illegal;
            private MeansIllegalBean means_illegal;
            private FormIllegalBean form_illegal;
            private FakeevidenceBean fakeevidence;
            private EvidenceSuspectedBean evidence_suspected;
            private FakecopyBean fakecopy;
            private EvidenceFlawBean evidence_flaw;
            private EvidenceUnverifyBean evidence_unverify;
            private FactNorelevanceBean fact_norelevance;
            private DoubtBean doubt;
            private EvidenceOldBean evidence_old;
            private OtherBean other;

            public ProcedureIllegalBean getProcedure_illegal() {
                return procedure_illegal;
            }

            public void setProcedure_illegal(ProcedureIllegalBean procedure_illegal) {
                this.procedure_illegal = procedure_illegal;
            }

            public MeansIllegalBean getMeans_illegal() {
                return means_illegal;
            }

            public void setMeans_illegal(MeansIllegalBean means_illegal) {
                this.means_illegal = means_illegal;
            }

            public FormIllegalBean getForm_illegal() {
                return form_illegal;
            }

            public void setForm_illegal(FormIllegalBean form_illegal) {
                this.form_illegal = form_illegal;
            }

            public FakeevidenceBean getFakeevidence() {
                return fakeevidence;
            }

            public void setFakeevidence(FakeevidenceBean fakeevidence) {
                this.fakeevidence = fakeevidence;
            }

            public EvidenceSuspectedBean getEvidence_suspected() {
                return evidence_suspected;
            }

            public void setEvidence_suspected(EvidenceSuspectedBean evidence_suspected) {
                this.evidence_suspected = evidence_suspected;
            }

            public FakecopyBean getFakecopy() {
                return fakecopy;
            }

            public void setFakecopy(FakecopyBean fakecopy) {
                this.fakecopy = fakecopy;
            }

            public EvidenceFlawBean getEvidence_flaw() {
                return evidence_flaw;
            }

            public void setEvidence_flaw(EvidenceFlawBean evidence_flaw) {
                this.evidence_flaw = evidence_flaw;
            }

            public EvidenceUnverifyBean getEvidence_unverify() {
                return evidence_unverify;
            }

            public void setEvidence_unverify(EvidenceUnverifyBean evidence_unverify) {
                this.evidence_unverify = evidence_unverify;
            }

            public FactNorelevanceBean getFact_norelevance() {
                return fact_norelevance;
            }

            public void setFact_norelevance(FactNorelevanceBean fact_norelevance) {
                this.fact_norelevance = fact_norelevance;
            }

            public DoubtBean getDoubt() {
                return doubt;
            }

            public void setDoubt(DoubtBean doubt) {
                this.doubt = doubt;
            }

            public EvidenceOldBean getEvidence_old() {
                return evidence_old;
            }

            public void setEvidence_old(EvidenceOldBean evidence_old) {
                this.evidence_old = evidence_old;
            }

            public OtherBean getOther() {
                return other;
            }

            public void setOther(OtherBean other) {
                this.other = other;
            }

            public static class ProcedureIllegalBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class MeansIllegalBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FormIllegalBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FakeevidenceBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class EvidenceSuspectedBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FakecopyBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class EvidenceFlawBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class EvidenceUnverifyBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FactNorelevanceBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DoubtBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class EvidenceOldBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class OtherBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class AppealBean {
            /**
             * appeal_due : {"index":"","text":""}
             * appeal_courts : [{"index":"","text":""}]
             */

            private AppealDueBean appeal_due;
            private List<AppealCourtsBean> appeal_courts;

            public AppealDueBean getAppeal_due() {
                return appeal_due;
            }

            public void setAppeal_due(AppealDueBean appeal_due) {
                this.appeal_due = appeal_due;
            }

            public List<AppealCourtsBean> getAppeal_courts() {
                return appeal_courts;
            }

            public void setAppeal_courts(List<AppealCourtsBean> appeal_courts) {
                this.appeal_courts = appeal_courts;
            }

            public static class AppealDueBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class AppealCourtsBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class StaffBean {
            /**
             * judges : [{"index":"","text":""}]
             * chief_judge : {"index":"","text":""}
             * jurors : [{"index":"","text":""}]
             * clerks : [{"index":"","text":""}]
             */

            private ChiefJudgeBean chief_judge;
            private List<JudgesBean> judges;
            private List<JurorsBean> jurors;
            private List<ClerksBean> clerks;

            public ChiefJudgeBean getChief_judge() {
                return chief_judge;
            }

            public void setChief_judge(ChiefJudgeBean chief_judge) {
                this.chief_judge = chief_judge;
            }

            public List<JudgesBean> getJudges() {
                return judges;
            }

            public void setJudges(List<JudgesBean> judges) {
                this.judges = judges;
            }

            public List<JurorsBean> getJurors() {
                return jurors;
            }

            public void setJurors(List<JurorsBean> jurors) {
                this.jurors = jurors;
            }

            public List<ClerksBean> getClerks() {
                return clerks;
            }

            public void setClerks(List<ClerksBean> clerks) {
                this.clerks = clerks;
            }

            public static class ChiefJudgeBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class JudgesBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class JurorsBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class ClerksBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class JudgementDateBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class AffirmContentBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class NotaffirmContentBean {
            /**
             * index :
             * text :
             */

            private String index;
            private String text;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class LawsBean {
            /**
             * law_name : {"index":"","text":""}
             * article_names : [{"index":"","text":""}]
             */

            private LawNameBean law_name;
            private List<ArticleNamesBean> article_names;

            public LawNameBean getLaw_name() {
                return law_name;
            }

            public void setLaw_name(LawNameBean law_name) {
                this.law_name = law_name;
            }

            public List<ArticleNamesBean> getArticle_names() {
                return article_names;
            }

            public void setArticle_names(List<ArticleNamesBean> article_names) {
                this.article_names = article_names;
            }

            public static class LawNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class ArticleNamesBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }

    public static class DefendantsBean {
        /**
         * defendant_base : {"defendant_name":{"index":"","text":""},"NN":{"index":"","text":""},"FN":{"index":"","text":""},"S":{"index":"","text":""},"BD":{"index":"","text":""},"BA":{"index":"","text":""},"PN":{"index":"","text":""},"defendant_nativePlace":{"index":"","text":""},"FA":{"index":"","text":""},"defendant_occupation":{"index":"","text":""},"DR":{"index":"","text":""},"PS":{"index":"","text":""},"E":{"index":"","text":""},"defendant_capacity":{"index":"","text":""},"defendant_identity":{"index":"","text":""},"special_identity":{"identity_foreigner":{"index":"","text":""},"identity_hongkongmacau":{"index":"","text":""},"identity_taiwan":{"index":"","text":""},"identity_partygroupings":{"index":"","text":""},"identity_officer":{"index":"","text":""},"identity_leader":{"index":"","text":""},"identity_intellectual":{"index":"","text":""},"identity_npc_member":{"index":"","text":""},"identity_cppcc_members":{"index":"","text":""},"identity_star":{"index":"","text":""},"identity_sportstar":{"index":"","text":""},"identity_others":{"index":"","text":""}}}
         * defendant_preConvictions : [{"preConviction_time":{"index":"","text":""},"preConviction_chargeName":{"index":"","text":""},"preConviction_penalty":[{"index":"","text":""}],"preConviction_release":{"index":"","text":""}}]
         * charges : [{"suspect_charge_name":{"index":"","text":""},"charge_enforcements":[{"charge_enforcement_type":{"index":"","text":""},"charge_enforcement_time":{"index":"","text":""},"charge_enforcement_organ":{"index":"","text":""}}]}]
         * detain : {"inPrison":{"index":"","text":""},"inPrison_place":{"index":"","text":""}}
         * attorneys : [{"attorney_type":{"index":"","text":""},"attorney_name":{"index":"","text":""},"attorney_workplace":{"index":"","text":""},"attorney_occupation":{"index":"","text":""},"attorney_relation":{"index":"","text":""}}]
         * judgment : {"defendant_joint_crime":{"index":"","text":""},"penalties":[{"JA":{"index":"","text":""},"penalty_principal":{"index":"","text":""},"penalty_suspend":{"index":"","text":""},"penalty_supplementaries":[{"penalty_supplementary_type":{"index":"","text":""},"penalty_supplementary_content":{"index":"","text":""},"penalty_supplementary_money":{"index":"","text":""}}],"penalty_duration":{"index":"","text":""},"penalty_notimprison":{"index":"","text":""}}]}
         */

        private DefendantBaseBean defendant_base;
        private DetainBean detain;
        private JudgmentBeanX judgment;
        private List<DefendantPreConvictionsBean> defendant_preConvictions;
        private List<ChargesBean> charges;
        private List<AttorneysBean> attorneys;

        public DefendantBaseBean getDefendant_base() {
            return defendant_base;
        }

        public void setDefendant_base(DefendantBaseBean defendant_base) {
            this.defendant_base = defendant_base;
        }

        public DetainBean getDetain() {
            return detain;
        }

        public void setDetain(DetainBean detain) {
            this.detain = detain;
        }

        public JudgmentBeanX getJudgment() {
            return judgment;
        }

        public void setJudgment(JudgmentBeanX judgment) {
            this.judgment = judgment;
        }

        public List<DefendantPreConvictionsBean> getDefendant_preConvictions() {
            return defendant_preConvictions;
        }

        public void setDefendant_preConvictions(List<DefendantPreConvictionsBean> defendant_preConvictions) {
            this.defendant_preConvictions = defendant_preConvictions;
        }

        public List<ChargesBean> getCharges() {
            return charges;
        }

        public void setCharges(List<ChargesBean> charges) {
            this.charges = charges;
        }

        public List<AttorneysBean> getAttorneys() {
            return attorneys;
        }

        public void setAttorneys(List<AttorneysBean> attorneys) {
            this.attorneys = attorneys;
        }

        public static class DefendantBaseBean {
            /**
             * defendant_name : {"index":"","text":""}
             * NN : {"index":"","text":""}
             * FN : {"index":"","text":""}
             * S : {"index":"","text":""}
             * BD : {"index":"","text":""}
             * BA : {"index":"","text":""}
             * PN : {"index":"","text":""}
             * defendant_nativePlace : {"index":"","text":""}
             * FA : {"index":"","text":""}
             * defendant_occupation : {"index":"","text":""}
             * DR : {"index":"","text":""}
             * PS : {"index":"","text":""}
             * E : {"index":"","text":""}
             * defendant_capacity : {"index":"","text":""}
             * defendant_identity : {"index":"","text":""}
             * special_identity : {"identity_foreigner":{"index":"","text":""},"identity_hongkongmacau":{"index":"","text":""},"identity_taiwan":{"index":"","text":""},"identity_partygroupings":{"index":"","text":""},"identity_officer":{"index":"","text":""},"identity_leader":{"index":"","text":""},"identity_intellectual":{"index":"","text":""},"identity_npc_member":{"index":"","text":""},"identity_cppcc_members":{"index":"","text":""},"identity_star":{"index":"","text":""},"identity_sportstar":{"index":"","text":""},"identity_others":{"index":"","text":""}}
             */

            private DefendantNameBean defendant_name;
            private NNBean NN;
            private FNBean FN;
            private SBean S;
            private BDBean BD;
            private BABean BA;
            private PNBean PN;
            private DefendantNativePlaceBean defendant_nativePlace;
            private FABean FA;
            private DefendantOccupationBean defendant_occupation;
            private DRBean DR;
            private PSBean PS;
            private EBean E;
            private DefendantCapacityBean defendant_capacity;
            private DefendantIdentityBean defendant_identity;
            private SpecialIdentityBean special_identity;

            public DefendantNameBean getDefendant_name() {
                return defendant_name;
            }

            public void setDefendant_name(DefendantNameBean defendant_name) {
                this.defendant_name = defendant_name;
            }

            public NNBean getNN() {
                return NN;
            }

            public void setNN(NNBean NN) {
                this.NN = NN;
            }

            public FNBean getFN() {
                return FN;
            }

            public void setFN(FNBean FN) {
                this.FN = FN;
            }

            public SBean getS() {
                return S;
            }

            public void setS(SBean S) {
                this.S = S;
            }

            public BDBean getBD() {
                return BD;
            }

            public void setBD(BDBean BD) {
                this.BD = BD;
            }

            public BABean getBA() {
                return BA;
            }

            public void setBA(BABean BA) {
                this.BA = BA;
            }

            public PNBean getPN() {
                return PN;
            }

            public void setPN(PNBean PN) {
                this.PN = PN;
            }

            public DefendantNativePlaceBean getDefendant_nativePlace() {
                return defendant_nativePlace;
            }

            public void setDefendant_nativePlace(DefendantNativePlaceBean defendant_nativePlace) {
                this.defendant_nativePlace = defendant_nativePlace;
            }

            public FABean getFA() {
                return FA;
            }

            public void setFA(FABean FA) {
                this.FA = FA;
            }

            public DefendantOccupationBean getDefendant_occupation() {
                return defendant_occupation;
            }

            public void setDefendant_occupation(DefendantOccupationBean defendant_occupation) {
                this.defendant_occupation = defendant_occupation;
            }

            public DRBean getDR() {
                return DR;
            }

            public void setDR(DRBean DR) {
                this.DR = DR;
            }

            public PSBean getPS() {
                return PS;
            }

            public void setPS(PSBean PS) {
                this.PS = PS;
            }

            public EBean getE() {
                return E;
            }

            public void setE(EBean E) {
                this.E = E;
            }

            public DefendantCapacityBean getDefendant_capacity() {
                return defendant_capacity;
            }

            public void setDefendant_capacity(DefendantCapacityBean defendant_capacity) {
                this.defendant_capacity = defendant_capacity;
            }

            public DefendantIdentityBean getDefendant_identity() {
                return defendant_identity;
            }

            public void setDefendant_identity(DefendantIdentityBean defendant_identity) {
                this.defendant_identity = defendant_identity;
            }

            public SpecialIdentityBean getSpecial_identity() {
                return special_identity;
            }

            public void setSpecial_identity(SpecialIdentityBean special_identity) {
                this.special_identity = special_identity;
            }

            public static class DefendantNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class NNBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FNBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class SBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class BDBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class BABean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PNBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DefendantNativePlaceBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class FABean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DefendantOccupationBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DRBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PSBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class EBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DefendantCapacityBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class DefendantIdentityBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class SpecialIdentityBean {
                /**
                 * identity_foreigner : {"index":"","text":""}
                 * identity_hongkongmacau : {"index":"","text":""}
                 * identity_taiwan : {"index":"","text":""}
                 * identity_partygroupings : {"index":"","text":""}
                 * identity_officer : {"index":"","text":""}
                 * identity_leader : {"index":"","text":""}
                 * identity_intellectual : {"index":"","text":""}
                 * identity_npc_member : {"index":"","text":""}
                 * identity_cppcc_members : {"index":"","text":""}
                 * identity_star : {"index":"","text":""}
                 * identity_sportstar : {"index":"","text":""}
                 * identity_others : {"index":"","text":""}
                 */

                private IdentityForeignerBean identity_foreigner;
                private IdentityHongkongmacauBean identity_hongkongmacau;
                private IdentityTaiwanBean identity_taiwan;
                private IdentityPartygroupingsBean identity_partygroupings;
                private IdentityOfficerBean identity_officer;
                private IdentityLeaderBean identity_leader;
                private IdentityIntellectualBean identity_intellectual;
                private IdentityNpcMemberBean identity_npc_member;
                private IdentityCppccMembersBean identity_cppcc_members;
                private IdentityStarBean identity_star;
                private IdentitySportstarBean identity_sportstar;
                private IdentityOthersBean identity_others;

                public IdentityForeignerBean getIdentity_foreigner() {
                    return identity_foreigner;
                }

                public void setIdentity_foreigner(IdentityForeignerBean identity_foreigner) {
                    this.identity_foreigner = identity_foreigner;
                }

                public IdentityHongkongmacauBean getIdentity_hongkongmacau() {
                    return identity_hongkongmacau;
                }

                public void setIdentity_hongkongmacau(IdentityHongkongmacauBean identity_hongkongmacau) {
                    this.identity_hongkongmacau = identity_hongkongmacau;
                }

                public IdentityTaiwanBean getIdentity_taiwan() {
                    return identity_taiwan;
                }

                public void setIdentity_taiwan(IdentityTaiwanBean identity_taiwan) {
                    this.identity_taiwan = identity_taiwan;
                }

                public IdentityPartygroupingsBean getIdentity_partygroupings() {
                    return identity_partygroupings;
                }

                public void setIdentity_partygroupings(IdentityPartygroupingsBean identity_partygroupings) {
                    this.identity_partygroupings = identity_partygroupings;
                }

                public IdentityOfficerBean getIdentity_officer() {
                    return identity_officer;
                }

                public void setIdentity_officer(IdentityOfficerBean identity_officer) {
                    this.identity_officer = identity_officer;
                }

                public IdentityLeaderBean getIdentity_leader() {
                    return identity_leader;
                }

                public void setIdentity_leader(IdentityLeaderBean identity_leader) {
                    this.identity_leader = identity_leader;
                }

                public IdentityIntellectualBean getIdentity_intellectual() {
                    return identity_intellectual;
                }

                public void setIdentity_intellectual(IdentityIntellectualBean identity_intellectual) {
                    this.identity_intellectual = identity_intellectual;
                }

                public IdentityNpcMemberBean getIdentity_npc_member() {
                    return identity_npc_member;
                }

                public void setIdentity_npc_member(IdentityNpcMemberBean identity_npc_member) {
                    this.identity_npc_member = identity_npc_member;
                }

                public IdentityCppccMembersBean getIdentity_cppcc_members() {
                    return identity_cppcc_members;
                }

                public void setIdentity_cppcc_members(IdentityCppccMembersBean identity_cppcc_members) {
                    this.identity_cppcc_members = identity_cppcc_members;
                }

                public IdentityStarBean getIdentity_star() {
                    return identity_star;
                }

                public void setIdentity_star(IdentityStarBean identity_star) {
                    this.identity_star = identity_star;
                }

                public IdentitySportstarBean getIdentity_sportstar() {
                    return identity_sportstar;
                }

                public void setIdentity_sportstar(IdentitySportstarBean identity_sportstar) {
                    this.identity_sportstar = identity_sportstar;
                }

                public IdentityOthersBean getIdentity_others() {
                    return identity_others;
                }

                public void setIdentity_others(IdentityOthersBean identity_others) {
                    this.identity_others = identity_others;
                }

                public static class IdentityForeignerBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityHongkongmacauBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityTaiwanBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityPartygroupingsBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityOfficerBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityLeaderBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityIntellectualBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityNpcMemberBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityCppccMembersBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityStarBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentitySportstarBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class IdentityOthersBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }
            }
        }

        public static class DetainBean {
            /**
             * inPrison : {"index":"","text":""}
             * inPrison_place : {"index":"","text":""}
             */

            private InPrisonBean inPrison;
            private InPrisonPlaceBean inPrison_place;

            public InPrisonBean getInPrison() {
                return inPrison;
            }

            public void setInPrison(InPrisonBean inPrison) {
                this.inPrison = inPrison;
            }

            public InPrisonPlaceBean getInPrison_place() {
                return inPrison_place;
            }

            public void setInPrison_place(InPrisonPlaceBean inPrison_place) {
                this.inPrison_place = inPrison_place;
            }

            public static class InPrisonBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class InPrisonPlaceBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class JudgmentBeanX {
            /**
             * defendant_joint_crime : {"index":"","text":""}
             * penalties : [{"JA":{"index":"","text":""},"penalty_principal":{"index":"","text":""},"penalty_suspend":{"index":"","text":""},"penalty_supplementaries":[{"penalty_supplementary_type":{"index":"","text":""},"penalty_supplementary_content":{"index":"","text":""},"penalty_supplementary_money":{"index":"","text":""}}],"penalty_duration":{"index":"","text":""},"penalty_notimprison":{"index":"","text":""}}]
             */

            private DefendantJointCrimeBean defendant_joint_crime;
            private List<PenaltiesBean> penalties;

            public DefendantJointCrimeBean getDefendant_joint_crime() {
                return defendant_joint_crime;
            }

            public void setDefendant_joint_crime(DefendantJointCrimeBean defendant_joint_crime) {
                this.defendant_joint_crime = defendant_joint_crime;
            }

            public List<PenaltiesBean> getPenalties() {
                return penalties;
            }

            public void setPenalties(List<PenaltiesBean> penalties) {
                this.penalties = penalties;
            }

            public static class DefendantJointCrimeBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PenaltiesBean {
                /**
                 * JA : {"index":"","text":""}
                 * penalty_principal : {"index":"","text":""}
                 * penalty_suspend : {"index":"","text":""}
                 * penalty_supplementaries : [{"penalty_supplementary_type":{"index":"","text":""},"penalty_supplementary_content":{"index":"","text":""},"penalty_supplementary_money":{"index":"","text":""}}]
                 * penalty_duration : {"index":"","text":""}
                 * penalty_notimprison : {"index":"","text":""}
                 */

                private JABean JA;
                private PenaltyPrincipalBean penalty_principal;
                private PenaltySuspendBean penalty_suspend;
                private PenaltyDurationBean penalty_duration;
                private PenaltyNotimprisonBean penalty_notimprison;
                private List<PenaltySupplementariesBean> penalty_supplementaries;

                public JABean getJA() {
                    return JA;
                }

                public void setJA(JABean JA) {
                    this.JA = JA;
                }

                public PenaltyPrincipalBean getPenalty_principal() {
                    return penalty_principal;
                }

                public void setPenalty_principal(PenaltyPrincipalBean penalty_principal) {
                    this.penalty_principal = penalty_principal;
                }

                public PenaltySuspendBean getPenalty_suspend() {
                    return penalty_suspend;
                }

                public void setPenalty_suspend(PenaltySuspendBean penalty_suspend) {
                    this.penalty_suspend = penalty_suspend;
                }

                public PenaltyDurationBean getPenalty_duration() {
                    return penalty_duration;
                }

                public void setPenalty_duration(PenaltyDurationBean penalty_duration) {
                    this.penalty_duration = penalty_duration;
                }

                public PenaltyNotimprisonBean getPenalty_notimprison() {
                    return penalty_notimprison;
                }

                public void setPenalty_notimprison(PenaltyNotimprisonBean penalty_notimprison) {
                    this.penalty_notimprison = penalty_notimprison;
                }

                public List<PenaltySupplementariesBean> getPenalty_supplementaries() {
                    return penalty_supplementaries;
                }

                public void setPenalty_supplementaries(List<PenaltySupplementariesBean> penalty_supplementaries) {
                    this.penalty_supplementaries = penalty_supplementaries;
                }

                public static class JABean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class PenaltyPrincipalBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class PenaltySuspendBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class PenaltyDurationBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class PenaltyNotimprisonBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class PenaltySupplementariesBean {
                    /**
                     * penalty_supplementary_type : {"index":"","text":""}
                     * penalty_supplementary_content : {"index":"","text":""}
                     * penalty_supplementary_money : {"index":"","text":""}
                     */

                    private PenaltySupplementaryTypeBean penalty_supplementary_type;
                    private PenaltySupplementaryContentBean penalty_supplementary_content;
                    private PenaltySupplementaryMoneyBean penalty_supplementary_money;

                    public PenaltySupplementaryTypeBean getPenalty_supplementary_type() {
                        return penalty_supplementary_type;
                    }

                    public void setPenalty_supplementary_type(PenaltySupplementaryTypeBean penalty_supplementary_type) {
                        this.penalty_supplementary_type = penalty_supplementary_type;
                    }

                    public PenaltySupplementaryContentBean getPenalty_supplementary_content() {
                        return penalty_supplementary_content;
                    }

                    public void setPenalty_supplementary_content(PenaltySupplementaryContentBean penalty_supplementary_content) {
                        this.penalty_supplementary_content = penalty_supplementary_content;
                    }

                    public PenaltySupplementaryMoneyBean getPenalty_supplementary_money() {
                        return penalty_supplementary_money;
                    }

                    public void setPenalty_supplementary_money(PenaltySupplementaryMoneyBean penalty_supplementary_money) {
                        this.penalty_supplementary_money = penalty_supplementary_money;
                    }

                    public static class PenaltySupplementaryTypeBean {
                        /**
                         * index :
                         * text :
                         */

                        private String index;
                        private String text;

                        public String getIndex() {
                            return index;
                        }

                        public void setIndex(String index) {
                            this.index = index;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }

                    public static class PenaltySupplementaryContentBean {
                        /**
                         * index :
                         * text :
                         */

                        private String index;
                        private String text;

                        public String getIndex() {
                            return index;
                        }

                        public void setIndex(String index) {
                            this.index = index;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }

                    public static class PenaltySupplementaryMoneyBean {
                        /**
                         * index :
                         * text :
                         */

                        private String index;
                        private String text;

                        public String getIndex() {
                            return index;
                        }

                        public void setIndex(String index) {
                            this.index = index;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }
                }
            }
        }

        public static class DefendantPreConvictionsBean {
            /**
             * preConviction_time : {"index":"","text":""}
             * preConviction_chargeName : {"index":"","text":""}
             * preConviction_penalty : [{"index":"","text":""}]
             * preConviction_release : {"index":"","text":""}
             */

            private PreConvictionTimeBean preConviction_time;
            private PreConvictionChargeNameBean preConviction_chargeName;
            private PreConvictionReleaseBean preConviction_release;
            private List<PreConvictionPenaltyBean> preConviction_penalty;

            public PreConvictionTimeBean getPreConviction_time() {
                return preConviction_time;
            }

            public void setPreConviction_time(PreConvictionTimeBean preConviction_time) {
                this.preConviction_time = preConviction_time;
            }

            public PreConvictionChargeNameBean getPreConviction_chargeName() {
                return preConviction_chargeName;
            }

            public void setPreConviction_chargeName(PreConvictionChargeNameBean preConviction_chargeName) {
                this.preConviction_chargeName = preConviction_chargeName;
            }

            public PreConvictionReleaseBean getPreConviction_release() {
                return preConviction_release;
            }

            public void setPreConviction_release(PreConvictionReleaseBean preConviction_release) {
                this.preConviction_release = preConviction_release;
            }

            public List<PreConvictionPenaltyBean> getPreConviction_penalty() {
                return preConviction_penalty;
            }

            public void setPreConviction_penalty(List<PreConvictionPenaltyBean> preConviction_penalty) {
                this.preConviction_penalty = preConviction_penalty;
            }

            public static class PreConvictionTimeBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PreConvictionChargeNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PreConvictionReleaseBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class PreConvictionPenaltyBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class ChargesBean {
            /**
             * suspect_charge_name : {"index":"","text":""}
             * charge_enforcements : [{"charge_enforcement_type":{"index":"","text":""},"charge_enforcement_time":{"index":"","text":""},"charge_enforcement_organ":{"index":"","text":""}}]
             */

            private SuspectChargeNameBean suspect_charge_name;
            private List<ChargeEnforcementsBean> charge_enforcements;

            public SuspectChargeNameBean getSuspect_charge_name() {
                return suspect_charge_name;
            }

            public void setSuspect_charge_name(SuspectChargeNameBean suspect_charge_name) {
                this.suspect_charge_name = suspect_charge_name;
            }

            public List<ChargeEnforcementsBean> getCharge_enforcements() {
                return charge_enforcements;
            }

            public void setCharge_enforcements(List<ChargeEnforcementsBean> charge_enforcements) {
                this.charge_enforcements = charge_enforcements;
            }

            public static class SuspectChargeNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class ChargeEnforcementsBean {
                /**
                 * charge_enforcement_type : {"index":"","text":""}
                 * charge_enforcement_time : {"index":"","text":""}
                 * charge_enforcement_organ : {"index":"","text":""}
                 */

                private ChargeEnforcementTypeBean charge_enforcement_type;
                private ChargeEnforcementTimeBean charge_enforcement_time;
                private ChargeEnforcementOrganBean charge_enforcement_organ;

                public ChargeEnforcementTypeBean getCharge_enforcement_type() {
                    return charge_enforcement_type;
                }

                public void setCharge_enforcement_type(ChargeEnforcementTypeBean charge_enforcement_type) {
                    this.charge_enforcement_type = charge_enforcement_type;
                }

                public ChargeEnforcementTimeBean getCharge_enforcement_time() {
                    return charge_enforcement_time;
                }

                public void setCharge_enforcement_time(ChargeEnforcementTimeBean charge_enforcement_time) {
                    this.charge_enforcement_time = charge_enforcement_time;
                }

                public ChargeEnforcementOrganBean getCharge_enforcement_organ() {
                    return charge_enforcement_organ;
                }

                public void setCharge_enforcement_organ(ChargeEnforcementOrganBean charge_enforcement_organ) {
                    this.charge_enforcement_organ = charge_enforcement_organ;
                }

                public static class ChargeEnforcementTypeBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class ChargeEnforcementTimeBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class ChargeEnforcementOrganBean {
                    /**
                     * index :
                     * text :
                     */

                    private String index;
                    private String text;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }
            }
        }

        public static class AttorneysBean {
            /**
             * attorney_type : {"index":"","text":""}
             * attorney_name : {"index":"","text":""}
             * attorney_workplace : {"index":"","text":""}
             * attorney_occupation : {"index":"","text":""}
             * attorney_relation : {"index":"","text":""}
             */

            private AttorneyTypeBean attorney_type;
            private AttorneyNameBean attorney_name;
            private AttorneyWorkplaceBean attorney_workplace;
            private AttorneyOccupationBean attorney_occupation;
            private AttorneyRelationBean attorney_relation;

            public AttorneyTypeBean getAttorney_type() {
                return attorney_type;
            }

            public void setAttorney_type(AttorneyTypeBean attorney_type) {
                this.attorney_type = attorney_type;
            }

            public AttorneyNameBean getAttorney_name() {
                return attorney_name;
            }

            public void setAttorney_name(AttorneyNameBean attorney_name) {
                this.attorney_name = attorney_name;
            }

            public AttorneyWorkplaceBean getAttorney_workplace() {
                return attorney_workplace;
            }

            public void setAttorney_workplace(AttorneyWorkplaceBean attorney_workplace) {
                this.attorney_workplace = attorney_workplace;
            }

            public AttorneyOccupationBean getAttorney_occupation() {
                return attorney_occupation;
            }

            public void setAttorney_occupation(AttorneyOccupationBean attorney_occupation) {
                this.attorney_occupation = attorney_occupation;
            }

            public AttorneyRelationBean getAttorney_relation() {
                return attorney_relation;
            }

            public void setAttorney_relation(AttorneyRelationBean attorney_relation) {
                this.attorney_relation = attorney_relation;
            }

            public static class AttorneyTypeBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class AttorneyNameBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class AttorneyWorkplaceBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class AttorneyOccupationBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class AttorneyRelationBean {
                /**
                 * index :
                 * text :
                 */

                private String index;
                private String text;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}
