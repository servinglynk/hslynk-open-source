package com.servinglynk.hmis.warehouse.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for Sources element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "source"
})
@XmlRootElement(name = "Sources")
public class Sources {

    @XmlElement(name = "Source", required = true)
    protected Source source;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link Source }
     *     
     */
    public Source getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link Source }
     *     
     */
    public void setSource(Source value) {
        this.source = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sourceID",
        "sourceType",
        "softwareName",
        "softwareVersion",
        "sourceContactEmail",
        "sourceContactExtension",
        "sourceContactFirst",
        "sourceContactLast",
        "sourceContactPhone",
        "sourceName",
        "export",
    })
    public static class Source {

        @XmlElement(name = "SourceID")
        protected String sourceID;
       
        @XmlElement(name = "SourceType")
        protected String sourceType;
        @XmlElement(name = "SoftwareName")
        protected String softwareName;
        
        @XmlElement(name = "SoftwareVersion")
        protected byte softwareVersion;
        @XmlElement(name = "SourceContactEmail", required = true)
        protected String sourceContactEmail;
        @XmlElement(name = "SourceContactExtension")
        protected short sourceContactExtension;
        @XmlElement(name = "SourceContactFirst", required = true)
        protected String sourceContactFirst;
        @XmlElement(name = "SourceContactLast", required = true)
        protected String sourceContactLast;
        @XmlElement(name = "SourceContactPhone")
        protected long sourceContactPhone;
        @XmlElement(name = "SourceName", required = true)
        protected String sourceName;
        @XmlElement(name = "Export", required = true)
        protected Export export;

        /**
         * Gets the value of the sourceID property.
         * 
         */
        public String getSourceID() {
            return sourceID;
        }

        /**
         * Sets the value of the sourceID property.
         * 
         */
        public void setSourceID(String value) {
            this.sourceID = value;
        }

        
        /**
         * Gets the value of the softwareVersion property.
         * 
         */
        public byte getSoftwareVersion() {
            return softwareVersion;
        }

        public String getSourceType() {
			return sourceType;
		}

		public void setSourceType(String sourceType) {
			this.sourceType = sourceType;
		}

		public String getSoftwareName() {
			return softwareName;
		}

		public void setSoftwareName(String softwareName) {
			this.softwareName = softwareName;
		}

		/**
         * Sets the value of the softwareVersion property.
         * 
         */
        public void setSoftwareVersion(byte value) {
            this.softwareVersion = value;
        }

        /**
         * Gets the value of the sourceContactEmail property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceContactEmail() {
            return sourceContactEmail;
        }

        /**
         * Sets the value of the sourceContactEmail property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceContactEmail(String value) {
            this.sourceContactEmail = value;
        }

        /**
         * Gets the value of the sourceContactExtension property.
         * 
         */
        public short getSourceContactExtension() {
            return sourceContactExtension;
        }

        /**
         * Sets the value of the sourceContactExtension property.
         * 
         */
        public void setSourceContactExtension(short value) {
            this.sourceContactExtension = value;
        }

        /**
         * Gets the value of the sourceContactFirst property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceContactFirst() {
            return sourceContactFirst;
        }

        /**
         * Sets the value of the sourceContactFirst property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceContactFirst(String value) {
            this.sourceContactFirst = value;
        }

        /**
         * Gets the value of the sourceContactLast property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceContactLast() {
            return sourceContactLast;
        }

        /**
         * Sets the value of the sourceContactLast property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceContactLast(String value) {
            this.sourceContactLast = value;
        }

        /**
         * Gets the value of the sourceContactPhone property.
         * 
         */
        public long getSourceContactPhone() {
            return sourceContactPhone;
        }

        /**
         * Sets the value of the sourceContactPhone property.
         * 
         */
        public void setSourceContactPhone(long value) {
            this.sourceContactPhone = value;
        }

        /**
         * Gets the value of the sourceName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceName() {
            return sourceName;
        }

        /**
         * Sets the value of the sourceName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceName(String value) {
            this.sourceName = value;
        }

        /**
         * Gets the value of the export property.
         * 
         * @return
         *     possible object is
         *     {@link Export }
         *     
         */
        public Export getExport() {
            return export;
        }

        /**
         * Sets the value of the export property.
         * 
         * @param value
         *     allowed object is
         *     {@link Export }
         *     
         */
        public void setExport(Export value) {
            this.export = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "exportID",
            "exportDate",
            "exportPeriod",
            "exportPeriodType",
            "exportDirective",
            "affiliation",
            "client",
            "contact",
            "dateOfEngagement",
            "disabilities",
            "domesticViolence",
            "education",
            "employment",
            "enrollment",
            "enrollmentCoC",
            "exit",
            "exitHousingAssessment",
            "exitPATH",
            "exitRHY",
            "funder",
            "healthInsurance",
            "healthStatus",
            "housingAssessmentDisposition",
            "incomeAndSources",
            "inventory",
            "medicalAssistance",
            "nonCashBenefits",
            "organization",
            "pathStatus",
            "entrySSVF",
            "project",
            "coC",
            "moveInDate",
            "rhybcpStatus",
            "services",
            "site",
            "clientVeteranInfo",
            "entryRHY",
            "entryRHSP",
            "geography",
            "connectionWithSOAR",
            "vashExitReason",
            "rhyAfterCare",
        })
        public static class Export {

            @XmlElement(name = "ExportID")
            protected String exportID;
            @XmlElement(name = "ExportDate", required = true)
            protected XMLGregorianCalendar exportDate;
            @XmlElement(name = "ExportPeriod", required = true)
            protected ExportPeriod exportPeriod;
            @XmlElement(name = "ExportPeriodType", required = true)
            protected String exportPeriodType;
            @XmlElement(name = "ExportDirective", required = true)
            protected String exportDirective;
            @XmlElement(name = "Client", required = true)
            protected List<Client> client;
            @XmlElement(name = "Affiliation")
            protected List<Affiliation> affiliation;
            @XmlElement(name = "Contact", required = true)
            protected List<Contact> contact;
            @XmlElement(name = "DateOfEngagement", required = true)
            protected List<DateOfEngagement> dateOfEngagement;
            @XmlElement(name = "Disabilities", required = true)
            protected List<Disabilities> disabilities;
            @XmlElement(name = "DomesticViolence", required = true)
            protected List<DomesticViolence> domesticViolence;
            @XmlElement(name = "Education", required = true)
            protected List<Education> education;
            @XmlElement(name = "Employment", required = true)
            protected List<Employment> employment;
            @XmlElement(name = "Enrollment", required = true)
            protected List<Enrollment> enrollment;
            @XmlElement(name = "EnrollmentCoC", required = true)
            protected List<EnrollmentCoC> enrollmentCoC;
            @XmlElement(name = "Exit", required = true)
            protected List<Exit> exit;
            @XmlElement(name = "ExitHousingAssessment", required = true)
            protected List<ExitHousingAssessment> exitHousingAssessment;
            @XmlElement(name = "ExitPATH", required = true)
            protected List<ExitPATH> exitPATH;
            @XmlElement(name = "ExitRHY", required = true)
            protected List<ExitRHY> exitRHY;
            @XmlElement(name = "Funder", required = true)
            protected List<Funder> funder;
            @XmlElement(name = "HealthInsurance", required = true)
            protected List<HealthInsurance> healthInsurance;
            @XmlElement(name = "HealthStatus", required = true)
            protected List<HealthStatus> healthStatus;
            @XmlElement(name = "HousingAssessmentDisposition", required = true)
            protected List<HousingAssessmentDisposition> housingAssessmentDisposition;
            @XmlElement(name = "IncomeAndSources", required = true)
            protected List<IncomeAndSources> incomeAndSources;
            @XmlElement(name = "Inventory", required = true)
            protected List<Inventory> inventory;
            @XmlElement(name = "MedicalAssistance", required = true)
            protected List<MedicalAssistance> medicalAssistance;
            @XmlElement(name = "NonCashBenefits", required = true)
            protected List<NonCashBenefits> nonCashBenefits;
            @XmlElement(name = "Organization", required = true)
            protected List<Organization> organization;
            @XmlElement(name = "PATHStatus", required = true)
            protected List<PATHStatus> pathStatus;
            @XmlElement(name = "EntrySSVF", required = true)
            protected List<EntrySSVF> entrySSVF;
            @XmlElement(name = "Project", required = true)
            protected List<Project> project;
            @XmlElement(name = "CoC", required = true)
            protected List<CoC> coC;
            @XmlElement(name = "MoveInDate", required = true)
            protected List<Moveindate> moveInDate;
            @XmlElement(name = "RHYBCPStatus", required = true)
            protected List<RHYBCPStatus> rhybcpStatus;
            @XmlElement(name = "Services", required = true)
            protected List<Services> services;
            @XmlElement(name = "Site", required = true)
            protected List<Site> site;
            @XmlElement(name = "ClientVeteranInfo", required = true)
            protected List<ClientVeteranInfo> clientVeteranInfo;
            @XmlElement(name = "EntryRHY", required = true)
            protected List<EntryRHY> entryRHY;
            @XmlElement(name = "Geography", required = true)
            protected List<Geography> geography;
            @XmlElement(name = "ConnectionWithSoar", required = true)
            protected List<ConnectionWithSOAR> connectionWithSOAR;
            @XmlElement(name = "VASHExitReason", required = true)
            protected List<VASHExitReason> vashExitReason;
            @XmlElement(name = "RHYAfterCare", required = true)
            protected List<RHYAfterCare> rhyAfterCare;
            @XmlElement(name = "EntryRHSP", required = true)
            protected List<EntryRHSP> entryRHSP;
            
            
            /**
             * Gets the value of the exportID property.
             * 
             */
            public String getExportID() {
                return exportID;
            }

            /**
             * Sets the value of the exportID property.
             * 
             */
            public void setExportID(String value) {
                this.exportID = value;
            }

            /**
             * Gets the value of the exportDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getExportDate() {
                return exportDate;
            }

            /**
             * Sets the value of the exportDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setExportDate(XMLGregorianCalendar value) {
                this.exportDate = value;
            }

            /**
             * Gets the value of the exportPeriod property.
             * 
             * @return
             *     possible object is
             *     {@link ExportPeriod }
             *     
             */
            public ExportPeriod getExportPeriod() {
                return exportPeriod;
            }

            /**
             * Sets the value of the exportPeriod property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportPeriod }
             *     
             */
            public void setExportPeriod(ExportPeriod value) {
                this.exportPeriod = value;
            }

            /**
             * Gets the value of the exportPeriodType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExportPeriodType() {
                return exportPeriodType;
            }

            /**
             * Sets the value of the exportPeriodType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExportPeriodType(String value) {
                this.exportPeriodType = value;
            }

            /**
             * Gets the value of the exportDirective property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExportDirective() {
                return exportDirective;
            }

            /**
             * Sets the value of the exportDirective property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExportDirective(String value) {
                this.exportDirective = value;
            }
            /**
             * Gets the value of the affiliation property.
             * 
             * @return
             *     possible object is
             *     {@link Affiliation }
             *     
             */
            public List<Affiliation> getAffiliation() {
                return affiliation;
            }

            /**
             * Sets the value of the affiliation property.
             * 
             * @param value
             *     allowed object is
             *     {@link Affiliation }
             *     
             */
            public void setAffiliation(List<Affiliation> value) {
                this.affiliation = value;
            }
            /**
             * Gets the value of the VASHExitReason property.
             * 
             * @return
             *     possible object is
             *     {@link VASHExitReason }
             *     
             */
            public List<VASHExitReason> getVashExitReason() {
                return vashExitReason;
            }

            /**
             * Sets the value of the VASHExitReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link VASHExitReason }
             *     
             */
            public void setVashExitReason(List<VASHExitReason> value) {
                this.vashExitReason = value;
            }
            
            /**
             * Gets the value of the RHYAfterCare property.
             * 
             * @return
             *     possible object is
             *     {@link RHYAfterCare }
             *     
             */
            public List<RHYAfterCare> getRhyAfterCare() {
                return rhyAfterCare;
            }

            /**
             * Sets the value of the RHYAfterCare property.
             * 
             * @param value
             *     allowed object is
             *     {@link RHYAfterCare }
             *     
             */
            public void setRhyAfterCaren(List<RHYAfterCare> value) {
                this.rhyAfterCare = value;
            }
            /**
             * Gets the value of the client property.
             * 
             * @return
             *     possible object is
             *     {@link Client }
             *     
             */
            public List<Client> getClient() {
                return client;
            }

            /**
             * Sets the value of the client property.
             * 
             * @param value
             *     allowed object is
             *     {@link Client }
             *     
             */
            public void setClients(List<Client> value) {
                this.client = value;
            }

            /**
             * Gets the value of the contact property.
             * 
             * @return
             *     possible object is
             *     {@link Contact }
             *     
             */
            public List<Contact> getContact() {
                return contact;
            }

            /**
             * Sets the value of the contact property.
             * 
             * @param value
             *     allowed object is
             *     {@link Contact }
             *     
             */
            public void setContact(List<Contact> value) {
                this.contact = value;
            }

            /**
             * Gets the value of the dateOfEngagement property.
             * 
             * @return
             *     possible object is
             *     {@link DateOfEngagement }
             *     
             */
            public List<DateOfEngagement> getDateOfEngagement() {
                return dateOfEngagement;
            }

            /**
             * Sets the value of the ConnectionWithSoar property.
             * 
             * @param value
             *     allowed object is
             *     {@link ConnectionWithSoar }
             *     
             */
            public void setConnectionWithSoar(List<ConnectionWithSOAR> value) {
                this.connectionWithSOAR = value;
            }
            
            /**
             * Gets the value of the ConnectionWithSoar property.
             * 
             * @return
             *     possible object is
             *     {@link ConnectionWithSoar }
             *     
             */
            public List<ConnectionWithSOAR> getConnectionWithSoar() {
                return connectionWithSOAR;
            }

            /**
             * Sets the value of the dateOfEngagement property.
             * 
             * @param value
             *     allowed object is
             *     {@link DateOfEngagement }
             *     
             */
            public void setDateOfEngagement(List<DateOfEngagement> value) {
                this.dateOfEngagement = value;
            }

            /**
             * Gets the value of the disabilities property.
             * 
             * @return
             *     possible object is
             *     {@link Disabilities }
             *     
             */
            public List<Disabilities> getDisabilities() {
                return disabilities;
            }

            /**
             * Sets the value of the disabilities property.
             * 
             * @param value
             *     allowed object is
             *     {@link Disabilities }
             *     
             */
            public void setDisabilities(List<Disabilities> value) {
                this.disabilities = value;
            }

            /**
             * Gets the value of the domesticViolence property.
             * 
             * @return
             *     possible object is
             *     {@link DomesticViolence }
             *     
             */
            public List<DomesticViolence> getDomesticViolence() {
                return domesticViolence;
            }

            /**
             * Sets the value of the domesticViolence property.
             * 
             * @param value
             *     allowed object is
             *     {@link DomesticViolence }
             *     
             */
            public void setDomesticViolence(List<DomesticViolence> value) {
                this.domesticViolence = value;
            }

            /**
             * Gets the value of the education property.
             * 
             * @return
             *     possible object is
             *     {@link Education }
             *     
             */
            public List<Education> getEducation() {
                return education;
            }

            /**
             * Sets the value of the education property.
             * 
             * @param value
             *     allowed object is
             *     {@link Education }
             *     
             */
            public void setEducation(List<Education> value) {
                this.education = value;
            }

            /**
             * Gets the value of the employment property.
             * 
             * @return
             *     possible object is
             *     {@link Employment }
             *     
             */
            public List<Employment> getEmployment() {
                return employment;
            }

            /**
             * Sets the value of the employment property.
             * 
             * @param value
             *     allowed object is
             *     {@link Employment }
             *     
             */
            public void setEmployment(List<Employment> value) {
            	  if (employment == null) {
            		  employment = new ArrayList<Employment>();
                  }
                this.employment = value;
            }

            /**
             * Gets the value of the enrollment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the enrollment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEnrollment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Enrollment }
             * 
             * 
             */
            public List<Enrollment> getEnrollment() {
                if (enrollment == null) {
                    enrollment = new ArrayList<Enrollment>();
                }
                return this.enrollment;
            }

            /**
             * Gets the value of the enrollmentCoC property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the enrollmentCoC property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEnrollmentCoC().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link EnrollmentCoC }
             * 
             * 
             */
            public List<EnrollmentCoC> getEnrollmentCoC() {
                if (enrollmentCoC == null) {
                    enrollmentCoC = new ArrayList<EnrollmentCoC>();
                }
                return this.enrollmentCoC;
            }

            /**
             * Gets the value of the exit property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the exit property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getExit().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Exit }
             * 
             * 
             */
            public List<Exit> getExit() {
                if (exit == null) {
                    exit = new ArrayList<Exit>();
                }
                return this.exit;
            }

            /**
             * Gets the value of the exitHousingAssessment property.
             * 
             * @return
             *     possible object is
             *     {@link ExitHousingAssessment }
             *     
             */
            public List<ExitHousingAssessment> getExitHousingAssessment() {
                return exitHousingAssessment;
            }

            /**
             * Sets the value of the exitHousingAssessment property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExitHousingAssessment }
             *     
             */
            public void setExitHousingAssessment(List<ExitHousingAssessment> value) {
                this.exitHousingAssessment = value;
            }

            /**
             * Gets the value of the exitPATH property.
             * 
             * @return
             *     possible object is
             *     {@link ExitPATH }
             *     
             */
            public List<ExitPATH> getExitPATH() {
                return exitPATH;
            }

            /**
             * Sets the value of the exitPATH property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExitPATH }
             *     
             */
            public void setExitPATH(List<ExitPATH> value) {
                this.exitPATH = value;
            }

            /**
             * Gets the value of the exitRHY property.
             * 
             * @return
             *     possible object is
             *     {@link ExitRHY }
             *     
             */
            public List<ExitRHY> getExitRHY() {
                return exitRHY;
            }

            /**
             * Sets the value of the exitRHY property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExitRHY }
             *     
             */
            public void setExitRHY(List<ExitRHY> value) {
                this.exitRHY = value;
            }

            /**
             * Gets the value of the funder property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the funder property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFunder().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Funder }
             * 
             * 
             */
            public List<Funder> getFunder() {
                if (funder == null) {
                    funder = new ArrayList<Funder>();
                }
                return this.funder;
            }

            /**
             * Gets the value of the healthInsurance property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the healthInsurance property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHealthInsurance().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HealthInsurance }
             * 
             * 
             */
            public List<HealthInsurance> getHealthInsurance() {
                if (healthInsurance == null) {
                    healthInsurance = new ArrayList<HealthInsurance>();
                }
                return this.healthInsurance;
            }

            /**
             * Gets the value of the healthStatus property.
             * 
             * @return
             *     possible object is
             *     {@link HealthStatus }
             *     
             */
            public List<HealthStatus> getHealthStatus() {
                return healthStatus;
            }

            /**
             * Sets the value of the healthStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link HealthStatus }
             *     
             */
            public void setHealthStatus(List<HealthStatus> value) {
                this.healthStatus = value;
            }

            /**
             * Gets the value of the housingAssessmentDisposition property.
             * 
             * @return
             *     possible object is
             *     {@link HousingAssessmentDisposition }
             *     
             */
            public List<HousingAssessmentDisposition> getHousingAssessmentDisposition() {
                return housingAssessmentDisposition;
            }

            /**
             * Sets the value of the housingAssessmentDisposition property.
             * 
             * @param value
             *     allowed object is
             *     {@link HousingAssessmentDisposition }
             *     
             */
            public void setHousingAssessmentDisposition(List<HousingAssessmentDisposition> value) {
                this.housingAssessmentDisposition = value;
            }

            /**
             * Gets the value of the incomeAndSources property.
             * 
             * @return
             *     possible object is
             *     {@link IncomeAndSources }
             *     
             */
            public List<IncomeAndSources> getIncomeAndSources() {
                return incomeAndSources;
            }

            /**
             * Sets the value of the incomeAndSources property.
             * 
             * @param value
             *     allowed object is
             *     {@link IncomeAndSources }
             *     
             */
            public void setIncomeAndSources(List<IncomeAndSources> value) {
                this.incomeAndSources = value;
            }

            /**
             * Gets the value of the inventory property.
             * 
             * @return
             *     possible object is
             *     {@link Inventory }
             *     
             */
            public List<Inventory> getInventory() {
                return inventory;
            }

            /**
             * Sets the value of the inventory property.
             * 
             * @param value
             *     allowed object is
             *     {@link Inventory }
             *     
             */
            public void setInventory(List<Inventory> value) {
                this.inventory = value;
            }

            /**
             * Gets the value of the medicalAssistance property.
             * 
             * @return
             *     possible object is
             *     {@link MedicalAssistance }
             *     
             */
            public List<MedicalAssistance> getMedicalAssistance() {
                return medicalAssistance;
            }

            /**
             * Sets the value of the medicalAssistance property.
             * 
             * @param value
             *     allowed object is
             *     {@link MedicalAssistance }
             *     
             */
            public void setMedicalAssistance(List<MedicalAssistance> value) {
                this.medicalAssistance = value;
            }
            /**
             * Gets the value of the EntryRHSP property.
             * 
             * @return
             *     possible object is
             *     {@link EntryRHSP }
             *     
             */
            public List<EntryRHSP> getEntryRHSP() {
                return entryRHSP;
            }

            /**
             * Sets the value of the EntryRHSP property.
             * 
             * @param value
             *     allowed object is
             *     {@link EntryRHSP }
             *     
             */
            public void setEntryRHSP(List<EntryRHSP> value) {
                this.entryRHSP = value;
            }
            
            /**
             * Gets the value of the nonCashBenefits property.
             * 
             * @return
             *     possible object is
             *     {@link NonCashBenefits }
             *     
             */
            public List<NonCashBenefits> getNonCashBenefits() {
                return nonCashBenefits;
            }

            /**
             * Sets the value of the nonCashBenefits property.
             * 
             * @param value
             *     allowed object is
             *     {@link NonCashBenefits }
             *     
             */
            public void setNonCashBenefits(List<NonCashBenefits> value) {
                this.nonCashBenefits = value;
            }

            /**
             * Gets the value of the organization property.
             * 
             * @return
             *     possible object is
             *     {@link Organization }
             *     
             */
            public List<Organization> getOrganization() {
                return organization;
            }

            /**
             * Sets the value of the organization property.
             * 
             * @param value
             *     allowed object is
             *     {@link Organization }
             *     
             */
            public void setOrganization(List<Organization> value) {
                this.organization = value;
            }

            /**
             * Gets the value of the pathStatus property.
             * 
             * @return
             *     possible object is
             *     {@link PATHStatus }
             *     
             */
            public List<PATHStatus> getPATHStatus() {
                return pathStatus;
            }

            /**
             * Sets the value of the pathStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link PATHStatus }
             *     
             */
            public void setPATHStatus(List<PATHStatus> value) {
                this.pathStatus = value;
            }

            /**
             * Gets the value of the entrySSVF property.
             * 
             * @return
             *     possible object is
             *     {@link EntrySSVF }
             *     
             */
            public List<EntrySSVF> getEntrySSVF() {
                return entrySSVF;
            }

            /**
             * Sets the value of the entrySSVF property.
             * 
             * @param value
             *     allowed object is
             *     {@link EntrySSVF }
             *     
             */
            public void setEntrySSVF(List<EntrySSVF> value) {
                this.entrySSVF = value;
            }

            /**
             * Gets the value of the project property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the project property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProject().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Project }
             * 
             * 
             */
            public List<Project> getProject() {
                if (project == null) {
                    project = new ArrayList<Project>();
                }
                return this.project;
            }

            /**
             * Gets the value of the coC property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the coC property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCoC().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CoC }
             * 
             * 
             */
            public List<CoC> getCoC() {
                if (coC == null) {
                    coC = new ArrayList<CoC>();
                }
                return this.coC;
            }

            /**
             * Gets the value of the moveInDate property.
             * 
             * @return
             *     possible object is
             *     {@link MoveInDate }
             *     
             */
            public List<Moveindate> getMoveInDate() {
                return moveInDate;
            }

            /**
             * Sets the value of the moveInDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link MoveInDate }
             *     
             */
            public void setMoveInDate(List<Moveindate> value) {
                this.moveInDate = value;
            }

            /**
             * Gets the value of the rhybcpStatus property.
             * 
             * @return
             *     possible object is
             *     {@link RHYBCPStatus }
             *     
             */
            public List<RHYBCPStatus> getRHYBCPStatus() {
                return rhybcpStatus;
            }

            /**
             * Sets the value of the rhybcpStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link RHYBCPStatus }
             *     
             */
            public void setRHYBCPStatus(List<RHYBCPStatus> value) {
                this.rhybcpStatus = value;
            }

            /**
             * Gets the value of the services property.
             * 
             * @return
             *     possible object is
             *     {@link Services }
             *     
             */
           /* public List<Services> getServices() {
                return services;
            }*/
            public List<Services> getServices() {
                return services;
            }
            

            /**
             * Sets the value of the services property.
             * 
             * @param value
             *     allowed object is
             *     {@link Services }
             *     
             */
            public void setServices(List<Services> value) {
                this.services = value;
            }
            
            /**
             * Gets the value of the site property.
             * 
             * @return
             *     possible object is
             *     {@link Site }
             *     
             */
            public List<Geography> getGeography() {
                return geography;
            }

            /**
             * Sets the value of the site property.
             * 
             * @param value
             *     allowed object is
             *     {@link Site }
             *     
             */
            public void setGeography(List<Geography> value) {
                this.geography = value;
            }

            
            /**
             * Gets the value of the site property.
             * 
             * @return
             *     possible object is
             *     {@link Site }
             *     
             */
            public List<Site> getSite() {
                return site;
            }

            /**
             * Sets the value of the site property.
             * 
             * @param value
             *     allowed object is
             *     {@link Site }
             *     
             */
            public void setSite(List<Site> value) {
                this.site = value;
            }

            /**
             * Gets the value of the clientVeteranInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ClientVeteranInfo }
             *     
             */
            public List<ClientVeteranInfo> getClientVeteranInfo() {
                return clientVeteranInfo;
            }

            /**
             * Sets the value of the clientVeteranInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ClientVeteranInfo }
             *     
             */
            public void setClientVeteranInfo(List<ClientVeteranInfo> value) {
                this.clientVeteranInfo = value;
            }

            /**
             * Gets the value of the entryRHY property.
             * 
             * @return
             *     possible object is
             *     {@link EntryRHY }
             *     
             */
            public List<EntryRHY> getEntryRHY() {
                return entryRHY;
            }

            /**
             * Sets the value of the entryRHY property.
             * 
             * @param value
             *     allowed object is
             *     {@link EntryRHY }
             *     
             */
            public void setEntryRHY(List<EntryRHY> value) {
                this.entryRHY = value;
            }
            
            

            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="AffiliationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ProjectID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ResProjectID" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "affiliationID",
                "projectID",
                "resProjectID"
            })
            public static class Affiliation {

                @XmlElement(name = "AffiliationID" , required = true)
                protected String affiliationID;
                @XmlElement(name = "ProjectID" , required = true)
                protected String projectID;
                @XmlElement(name = "ResProjectID" )
                protected String resProjectID;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the affiliationID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAffiliationID() {
                    return affiliationID;
                }

                /**
                 * Sets the value of the affiliationID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAffiliationID(String value) {
                    this.affiliationID = value;
                }

                /**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                /**
                 * Gets the value of the resProjectID property.
                 * 
                 */
                public String getResProjectID() {
                    return resProjectID;
                }

                /**
                 * Sets the value of the resProjectID property.
                 * 
                 */
                public void setResProjectID(String value) {
                    this.resProjectID = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }
            
            
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "entryRHSPID",
                "worstHousingSituation",
                "projectID"
            })
            public static class EntryRHSP {

                @XmlElement(name = "EntryRHSPID" , required = true)
                protected String entryRHSPID;
                @XmlElement(name = "ProjectID" , required = true)
                protected String projectID;
                @XmlElement(name = "WorstHousingSituation" )
                protected String worstHousingSituation;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;
                
                

                public String getEntryRHSPID() {
					return entryRHSPID;
				}

				public void setEntryRHSPID(String value) {
					this.entryRHSPID = value;
				}

				public String getWorstHousingSituation() {
					return worstHousingSituation;
				}

				public void setWorstHousingSituation(String value) {
					this.worstHousingSituation = value;
				}

				/**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="PersonalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="FirstName">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="MiddleName">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="LastName">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="NameSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="NameDataQuality" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SSN">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="SSNDataQuality" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="DOBDataQuality" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherGender" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Ethnicity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Race" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VeteranStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "personalID",
                "firstName",
                "middleName",
                "lastName",
                "nameSuffix",
                "nameDataQuality",
                "ssn",
                "ssnDataQuality",
                "dob",
                "dobDataQuality",
                "gender",
                "ethnicity",
                "race",
                "veteranStatus"
            })
            public static class Client {

                @XmlElement(name = "PersonalID", required = true)
                protected String personalID;
                @XmlElement(name = "FirstName", required = true)
                protected FirstName firstName;
                @XmlElement(name = "MiddleName", required = true)
                protected MiddleName middleName;
                @XmlElement(name = "LastName", required = true)
                protected LastName lastName;
                @XmlElement(name = "NameSuffix", required = true)
                protected String nameSuffix;
                @XmlElement(name = "NameDataQuality")
                protected byte nameDataQuality;
                @XmlElement(name = "SSN", required = true)
                protected SSN ssn;
                @XmlElement(name = "SSNDataQuality")
                protected byte ssnDataQuality;
                @XmlElement(name = "DOB", required = true)
                protected XMLGregorianCalendar dob;
                @XmlElement(name = "DOBDataQuality")
                protected byte dobDataQuality;
                @XmlElement(name = "Gender")
                protected byte gender;
                @XmlElement(name = "Ethnicity")
                protected byte ethnicity;
                @XmlElement(name = "Race")
                protected byte race;
                @XmlElement(name = "VeteranStatus")
                protected byte veteranStatus;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the personalID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPersonalID() {
                    return personalID;
                }

                /**
                 * Sets the value of the personalID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPersonalID(String value) {
                    this.personalID = value;
                }

                /**
                 * Gets the value of the firstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link FirstName }
                 *     
                 */
                public FirstName getFirstName() {
                    return firstName;
                }

                /**
                 * Sets the value of the firstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link FirstName }
                 *     
                 */
                public void setFirstName(FirstName value) {
                    this.firstName = value;
                }

                /**
                 * Gets the value of the middleName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link MiddleName }
                 *     
                 */
                public MiddleName getMiddleName() {
                    return middleName;
                }

                /**
                 * Sets the value of the middleName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link MiddleName }
                 *     
                 */
                public void setMiddleName(MiddleName value) {
                    this.middleName = value;
                }

                /**
                 * Gets the value of the lastName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link LastName }
                 *     
                 */
                public LastName getLastName() {
                    return lastName;
                }

                /**
                 * Sets the value of the lastName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link LastName }
                 *     
                 */
                public void setLastName(LastName value) {
                    this.lastName = value;
                }

                /**
                 * Gets the value of the nameSuffix property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNameSuffix() {
                    return nameSuffix;
                }

                /**
                 * Sets the value of the nameSuffix property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNameSuffix(String value) {
                    this.nameSuffix = value;
                }

                /**
                 * Gets the value of the nameDataQuality property.
                 * 
                 */
                public byte getNameDataQuality() {
                    return nameDataQuality;
                }

                /**
                 * Sets the value of the nameDataQuality property.
                 * 
                 */
                public void setNameDataQuality(byte value) {
                    this.nameDataQuality = value;
                }

                /**
                 * Gets the value of the ssn property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link SSN }
                 *     
                 */
                public SSN getSSN() {
                    return ssn;
                }

                /**
                 * Sets the value of the ssn property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link SSN }
                 *     
                 */
                public void setSSN(SSN value) {
                    this.ssn = value;
                }

                /**
                 * Gets the value of the ssnDataQuality property.
                 * 
                 */
                public byte getSSNDataQuality() {
                    return ssnDataQuality;
                }

                /**
                 * Sets the value of the ssnDataQuality property.
                 * 
                 */
                public void setSSNDataQuality(byte value) {
                    this.ssnDataQuality = value;
                }

                /**
                 * Gets the value of the dob property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDOB() {
                    return dob;
                }

                /**
                 * Sets the value of the dob property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDOB(XMLGregorianCalendar value) {
                    this.dob = value;
                }

                /**
                 * Gets the value of the dobDataQuality property.
                 * 
                 */
                public byte getDOBDataQuality() {
                    return dobDataQuality;
                }

                /**
                 * Sets the value of the dobDataQuality property.
                 * 
                 */
                public void setDOBDataQuality(byte value) {
                    this.dobDataQuality = value;
                }

                /**
                 * Gets the value of the gender property.
                 * 
                 */
                public byte getGender() {
                    return gender;
                }

                /**
                 * Sets the value of the gender property.
                 * 
                 */
                public void setGender(byte value) {
                    this.gender = value;
                }

               /**
                 * Gets the value of the ethnicity property.
                 * 
                 */
                public byte getEthnicity() {
                    return ethnicity;
                }

                /**
                 * Sets the value of the ethnicity property.
                 * 
                 */
                public void setEthnicity(byte value) {
                    this.ethnicity = value;
                }

                /**
                 * Gets the value of the race property.
                 * 
                 */
                public byte getRace() {
                    return race;
                }

                /**
                 * Sets the value of the race property.
                 * 
                 */
                public void setRace(byte value) {
                    this.race = value;
                }

                /**
                 * Gets the value of the veteranStatus property.
                 * 
                 */
                public byte getVeteranStatus() {
                    return veteranStatus;
                }

                /**
                 * Sets the value of the veteranStatus property.
                 * 
                 */
                public void setVeteranStatus(byte value) {
                    this.veteranStatus = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class FirstName {

                    @XmlValue
                    protected String value;
                    @XmlAttribute
                    protected Byte hashStatus;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the hashStatus property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getHashStatus() {
                        return hashStatus;
                    }

                    /**
                     * Sets the value of the hashStatus property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setHashStatus(Byte value) {
                        this.hashStatus = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class LastName {

                    @XmlValue
                    protected String value;
                    @XmlAttribute
                    protected Byte hashStatus;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the hashStatus property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getHashStatus() {
                        return hashStatus;
                    }

                    /**
                     * Sets the value of the hashStatus property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setHashStatus(Byte value) {
                        this.hashStatus = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class MiddleName {

                    @XmlValue
                    protected String value;
                    @XmlAttribute
                    protected Byte hashStatus;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the hashStatus property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getHashStatus() {
                        return hashStatus;
                    }

                    /**
                     * Sets the value of the hashStatus property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setHashStatus(Byte value) {
                        this.hashStatus = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="hashStatus" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class SSN {

                    @XmlValue
                    protected String value;
                    @XmlAttribute
                    protected Byte hashStatus;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the hashStatus property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getHashStatus() {
                        return hashStatus;
                    }

                    /**
                     * Sets the value of the hashStatus property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setHashStatus(Byte value) {
                        this.hashStatus = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ClientVeteranInfoID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PersonalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="YearEnteredService" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="YearSeparated" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="WorldWarII" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="KoreanWar" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VietnamWar" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DesertStorm" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AfghanistanOEF" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="IraqOIF" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="IraqOND" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherTheater" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MilitaryBranch" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DischargeStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "clientVeteranInfoID",
                "personalID",
                "yearEnteredService",
                "yearSeparated",
                "worldWarII",
                "koreanWar",
                "vietnamWar",
                "desertStorm",
                "afghanistanOEF",
                "iraqOIF",
                "iraqOND",
                "otherTheater",
                "militaryBranch",
                "dischargeStatus"
            })
            public static class ClientVeteranInfo {

                @XmlElement(name = "ClientVeteranInfoID", required = true)
                protected String clientVeteranInfoID;
                @XmlElement(name = "PersonalID", required = true)
                protected String personalID;
                @XmlElement(name = "YearEnteredService")
                protected short yearEnteredService;
                @XmlElement(name = "YearSeparated")
                protected short yearSeparated;
                @XmlElement(name = "WorldWarII")
                protected byte worldWarII;
                @XmlElement(name = "KoreanWar")
                protected byte koreanWar;
                @XmlElement(name = "VietnamWar")
                protected byte vietnamWar;
                @XmlElement(name = "DesertStorm")
                protected byte desertStorm;
                @XmlElement(name = "AfghanistanOEF")
                protected byte afghanistanOEF;
                @XmlElement(name = "IraqOIF")
                protected byte iraqOIF;
                @XmlElement(name = "IraqOND")
                protected byte iraqOND;
                @XmlElement(name = "OtherTheater")
                protected byte otherTheater;
                @XmlElement(name = "MilitaryBranch")
                protected byte militaryBranch;
                @XmlElement(name = "DischargeStatus")
                protected byte dischargeStatus;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the clientVeteranInfoID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClientVeteranInfoID() {
                    return clientVeteranInfoID;
                }

                /**
                 * Sets the value of the clientVeteranInfoID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClientVeteranInfoID(String value) {
                    this.clientVeteranInfoID = value;
                }

                /**
                 * Gets the value of the personalID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPersonalID() {
                    return personalID;
                }

                /**
                 * Sets the value of the personalID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPersonalID(String value) {
                    this.personalID = value;
                }

                /**
                 * Gets the value of the yearEnteredService property.
                 * 
                 */
                public short getYearEnteredService() {
                    return yearEnteredService;
                }

                /**
                 * Sets the value of the yearEnteredService property.
                 * 
                 */
                public void setYearEnteredService(short value) {
                    this.yearEnteredService = value;
                }

                /**
                 * Gets the value of the yearSeparated property.
                 * 
                 */
                public short getYearSeparated() {
                    return yearSeparated;
                }

                /**
                 * Sets the value of the yearSeparated property.
                 * 
                 */
                public void setYearSeparated(short value) {
                    this.yearSeparated = value;
                }

                /**
                 * Gets the value of the worldWarII property.
                 * 
                 */
                public byte getWorldWarII() {
                    return worldWarII;
                }

                /**
                 * Sets the value of the worldWarII property.
                 * 
                 */
                public void setWorldWarII(byte value) {
                    this.worldWarII = value;
                }

                /**
                 * Gets the value of the koreanWar property.
                 * 
                 */
                public byte getKoreanWar() {
                    return koreanWar;
                }

                /**
                 * Sets the value of the koreanWar property.
                 * 
                 */
                public void setKoreanWar(byte value) {
                    this.koreanWar = value;
                }

                /**
                 * Gets the value of the vietnamWar property.
                 * 
                 */
                public byte getVietnamWar() {
                    return vietnamWar;
                }

                /**
                 * Sets the value of the vietnamWar property.
                 * 
                 */
                public void setVietnamWar(byte value) {
                    this.vietnamWar = value;
                }

                /**
                 * Gets the value of the desertStorm property.
                 * 
                 */
                public byte getDesertStorm() {
                    return desertStorm;
                }

                /**
                 * Sets the value of the desertStorm property.
                 * 
                 */
                public void setDesertStorm(byte value) {
                    this.desertStorm = value;
                }

                /**
                 * Gets the value of the afghanistanOEF property.
                 * 
                 */
                public byte getAfghanistanOEF() {
                    return afghanistanOEF;
                }

                /**
                 * Sets the value of the afghanistanOEF property.
                 * 
                 */
                public void setAfghanistanOEF(byte value) {
                    this.afghanistanOEF = value;
                }

                /**
                 * Gets the value of the iraqOIF property.
                 * 
                 */
                public byte getIraqOIF() {
                    return iraqOIF;
                }

                /**
                 * Sets the value of the iraqOIF property.
                 * 
                 */
                public void setIraqOIF(byte value) {
                    this.iraqOIF = value;
                }

                /**
                 * Gets the value of the iraqOND property.
                 * 
                 */
                public byte getIraqOND() {
                    return iraqOND;
                }

                /**
                 * Sets the value of the iraqOND property.
                 * 
                 */
                public void setIraqOND(byte value) {
                    this.iraqOND = value;
                }

                /**
                 * Gets the value of the otherTheater property.
                 * 
                 */
                public byte getOtherTheater() {
                    return otherTheater;
                }

                /**
                 * Sets the value of the otherTheater property.
                 * 
                 */
                public void setOtherTheater(byte value) {
                    this.otherTheater = value;
                }

                /**
                 * Gets the value of the militaryBranch property.
                 * 
                 */
                public byte getMilitaryBranch() {
                    return militaryBranch;
                }

                /**
                 * Sets the value of the militaryBranch property.
                 * 
                 */
                public void setMilitaryBranch(byte value) {
                    this.militaryBranch = value;
                }

                /**
                 * Gets the value of the dischargeStatus property.
                 * 
                 */
                public byte getDischargeStatus() {
                    return dischargeStatus;
                }

                /**
                 * Sets the value of the dischargeStatus property.
                 * 
                 */
                public void setDischargeStatus(byte value) {
                    this.dischargeStatus = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="CoCCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ProjectID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "coCCode",
                "projectID"
            })
            public static class CoC {

                @XmlElement(name = "CoCCode", required = true)
                protected String coCCode;
                @XmlElement(name = "ProjectID", required = true)
                protected String projectID;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the coCCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCoCCode() {
                    return coCCode;
                }

                /**
                 * Sets the value of the coCCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCoCCode(String value) {
                    this.coCCode = value;
                }

                /**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ContactDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
             *         &lt;element name="ContactLocation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "contactID",
                "enrollmentID",
                "contactDate",
                "contactLocation"
            })
            public static class Contact {

                @XmlElement(name = "ContactID", required = true)
                protected String contactID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "ContactDate", required = true)
                protected XMLGregorianCalendar contactDate;
                @XmlElement(name = "ContactLocation")
                protected byte contactLocation;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the contactID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContactID() {
                    return contactID;
                }

                /**
                 * Sets the value of the contactID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContactID(String value) {
                    this.contactID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the contactDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getContactDate() {
                    return contactDate;
                }

                /**
                 * Sets the value of the contactDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setContactDate(XMLGregorianCalendar value) {
                    this.contactDate = value;
                }

                /**
                 * Gets the value of the contactLocation property.
                 * 
                 */
                public byte getContactLocation() {
                    return contactLocation;
                }

                /**
                 * Sets the value of the contactLocation property.
                 * 
                 */
                public void setContactLocation(byte value) {
                    this.contactLocation = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ConnectionWithSOARID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ConnectionWithSOAR" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "connectionWithSOARID",
                "enrollmentID",
                "connectionWithSOAR"
            })
            public static class ConnectionWithSOAR {

                @XmlElement(name = "ConnectionWithSOARID" , required = true)
                protected String connectionWithSOARID;
                @XmlElement(name = "EnrollmentID" , required = true)
                protected String enrollmentID;
                @XmlElement(name = "ConnectionWithSOAR" )
                protected String connectionWithSOAR;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String dataCollectionStage;
                
				public XMLGregorianCalendar getInformationDate() {
					return informationDate;
				}
				public void setInformationDate(XMLGregorianCalendar informationDate) {
					this.informationDate = informationDate;
				}
				public String getDataCollectionStage() {
					return dataCollectionStage;
				}
				public void setDataCollectionStage(String dataCollectionStage) {
					this.dataCollectionStage = dataCollectionStage;
				}
				public String getConnectionWithSOARID() {
					return connectionWithSOARID;
				}
				public void setConnectionWithSOARID(String connectionWithSOARID) {
					this.connectionWithSOARID = connectionWithSOARID;
				}
				public String getEnrollmentID() {
					return enrollmentID;
				}
				public void setEnrollmentID(String enrollmentID) {
					this.enrollmentID = enrollmentID;
				}
				public String getConnectionWithSOAR() {
					return connectionWithSOAR;
				}
				public void setConnectionWithSOAR(String connectionWithSOAR) {
					this.connectionWithSOAR = connectionWithSOAR;
				}
				public XMLGregorianCalendar getDateCreated() {
					return dateCreated;
				}
				public void setDateCreated(XMLGregorianCalendar dateCreated) {
					this.dateCreated = dateCreated;
				}
				public XMLGregorianCalendar getDateUpdated() {
					return dateUpdated;
				}
				public void setDateUpdated(XMLGregorianCalendar dateUpdated) {
					this.dateUpdated = dateUpdated;
				}
				public String getUserID() {
					return userID;
				}
				public void setUserID(String userID) {
					this.userID = userID;
				}

                
            }

            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="DateOfEngagementID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="DateOfEngagement" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "dateOfEngagementID",
                "enrollmentID",
                "dateOfEngagement"
            })
            public static class DateOfEngagement {

                @XmlElement(name = "DateOfEngagementID", required = true)
                protected String dateOfEngagementID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "DateOfEngagement", required = true)
                protected XMLGregorianCalendar dateOfEngagement;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the dateOfEngagementID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDateOfEngagementID() {
                    return dateOfEngagementID;
                }

                /**
                 * Sets the value of the dateOfEngagementID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDateOfEngagementID(String value) {
                    this.dateOfEngagementID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the dateOfEngagement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateOfEngagement() {
                    return dateOfEngagement;
                }

                /**
                 * Sets the value of the dateOfEngagement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateOfEngagement(XMLGregorianCalendar value) {
                    this.dateOfEngagement = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="DisabilitiesID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="DisabilityType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DisabilityResponse" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="IndefiniteAndImpairsIndependence" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DocumentationOnFile" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ReceivingServices" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PATHHowConfirmed" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PATHSMIInformation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TCellCountAvailable" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TCellCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="TCellSource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ViralLoadAvailable" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ViralLoad" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="ViralLoadSource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "disabilitiesID",
                "enrollmentID",
                "disabilityType",
                "disabilityResponse",
                "indefiniteAndImpairsIndependence",
                //"documentationOnFile",
                //"receivingServices",
                //"pathHowConfirmed",
                //"pathsmiInformation",
                "tCellCountAvailable",
                "tCellCount",
                "tCellSource",
                "viralLoadAvailable",
                "viralLoad",
                "viralLoadSource"
            })
            public static class Disabilities {

                @XmlElement(name = "DisabilitiesID", required = true)
                protected String disabilitiesID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "DisabilityType")
                protected byte disabilityType;
                @XmlElement(name = "DisabilityResponse")
                protected byte disabilityResponse;
                @XmlElement(name = "IndefiniteAndImpairsIndependence")
                protected byte indefiniteAndImpairsIndependence;
               /* @XmlElement(name = "DocumentationOnFile")
                protected byte documentationOnFile;
                @XmlElement(name = "ReceivingServices")
                protected byte receivingServices;
                @XmlElement(name = "PATHHowConfirmed")
                protected byte pathHowConfirmed;
                @XmlElement(name = "PATHSMIInformation")
                protected byte pathsmiInformation;*/
                @XmlElement(name = "TCellCountAvailable")
                protected byte tCellCountAvailable;
                @XmlElement(name = "TCellCount")
                protected short tCellCount;
                @XmlElement(name = "TCellSource")
                protected byte tCellSource;
                @XmlElement(name = "ViralLoadAvailable")
                protected byte viralLoadAvailable;
                @XmlElement(name = "ViralLoad")
                protected int viralLoad;
                @XmlElement(name = "ViralLoadSource")
                protected byte viralLoadSource;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the disabilitiesID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDisabilitiesID() {
                    return disabilitiesID;
                }

                /**
                 * Sets the value of the disabilitiesID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDisabilitiesID(String value) {
                    this.disabilitiesID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the disabilityType property.
                 * 
                 */
                public byte getDisabilityType() {
                    return disabilityType;
                }

                /**
                 * Sets the value of the disabilityType property.
                 * 
                 */
                public void setDisabilityType(byte value) {
                    this.disabilityType = value;
                }

                /**
                 * Gets the value of the disabilityResponse property.
                 * 
                 */
                public byte getDisabilityResponse() {
                    return disabilityResponse;
                }

                /**
                 * Sets the value of the disabilityResponse property.
                 * 
                 */
                public void setDisabilityResponse(byte value) {
                    this.disabilityResponse = value;
                }

                /**
                 * Gets the value of the indefiniteAndImpairsIndependence property.
                 * 
                 */
                public byte getIndefiniteAndImpairsIndependence() {
                    return indefiniteAndImpairsIndependence;
                }

                /**
                 * Sets the value of the indefiniteAndImpairsIndependence property.
                 * 
                 */
                public void setIndefiniteAndImpairsIndependence(byte value) {
                    this.indefiniteAndImpairsIndependence = value;
                }

                /**
                 * Gets the value of the documentationOnFile property.
                 * 
                 */
                /*public byte getDocumentationOnFile() {
                    return documentationOnFile;
                }*/

                /**
                 * Sets the value of the documentationOnFile property.
                 * 
                 */
                /*public void setDocumentationOnFile(byte value) {
                    this.documentationOnFile = value;
                }*/

                /**
                 * Gets the value of the receivingServices property.
                 * 
                 */
               /* public byte getReceivingServices() {
                    return receivingServices;
                }*/

                /**
                 * Sets the value of the receivingServices property.
                 * 
                 */
               /* public void setReceivingServices(byte value) {
                    this.receivingServices = value;
                }*/

                /**
                 * Gets the value of the pathHowConfirmed property.
                 * 
                 */
               /* public byte getPATHHowConfirmed() {
                    return pathHowConfirmed;
                }*/

                /**
                 * Sets the value of the pathHowConfirmed property.
                 * 
                 */
                /*public void setPATHHowConfirmed(byte value) {
                    this.pathHowConfirmed = value;
                }*/

                /**
                 * Gets the value of the pathsmiInformation property.
                 * 
                 */
                /*public byte getPATHSMIInformation() {
                    return pathsmiInformation;
                }*/

                /**
                 * Sets the value of the pathsmiInformation property.
                 * 
                 */
               /* public void setPATHSMIInformation(byte value) {
                    this.pathsmiInformation = value;
                }*/

                /**
                 * Gets the value of the tCellCountAvailable property.
                 * 
                 */
                public byte getTCellCountAvailable() {
                    return tCellCountAvailable;
                }

                /**
                 * Sets the value of the tCellCountAvailable property.
                 * 
                 */
                public void setTCellCountAvailable(byte value) {
                    this.tCellCountAvailable = value;
                }

                /**
                 * Gets the value of the tCellCount property.
                 * 
                 */
                public short getTCellCount() {
                    return tCellCount;
                }

                /**
                 * Sets the value of the tCellCount property.
                 * 
                 */
                public void setTCellCount(short value) {
                    this.tCellCount = value;
                }

                /**
                 * Gets the value of the tCellSource property.
                 * 
                 */
                public byte getTCellSource() {
                    return tCellSource;
                }

                /**
                 * Sets the value of the tCellSource property.
                 * 
                 */
                public void setTCellSource(byte value) {
                    this.tCellSource = value;
                }

                /**
                 * Gets the value of the viralLoadAvailable property.
                 * 
                 */
                public byte getViralLoadAvailable() {
                    return viralLoadAvailable;
                }

                /**
                 * Sets the value of the viralLoadAvailable property.
                 * 
                 */
                public void setViralLoadAvailable(byte value) {
                    this.viralLoadAvailable = value;
                }

                /**
                 * Gets the value of the viralLoad property.
                 * 
                 */
                public int getViralLoad() {
                    return viralLoad;
                }

                /**
                 * Sets the value of the viralLoad property.
                 * 
                 */
                public void setViralLoad(int value) {
                    this.viralLoad = value;
                }

                /**
                 * Gets the value of the viralLoadSource property.
                 * 
                 */
                public byte getViralLoadSource() {
                    return viralLoadSource;
                }

                /**
                 * Sets the value of the viralLoadSource property.
                 * 
                 */
                public void setViralLoadSource(byte value) {
                    this.viralLoadSource = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="DomesticViolenceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="DomesticViolenceVictim" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="WhenOccurred" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="CurrentlyFleeing" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "domesticViolenceID",
                "enrollmentID",
                "domesticViolenceVictim",
                "whenOccurred",
                "currentlyFleeing"
            })
            public static class DomesticViolence {

                @XmlElement(name = "DomesticViolenceID", required = true)
                protected String domesticViolenceID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "DomesticViolenceVictim")
                protected byte domesticViolenceVictim;
                @XmlElement(name = "WhenOccurred")
                protected byte whenOccurred;
                @XmlElement(name = "CurrentlyFleeing")
                protected byte currentlyFleeing;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the domesticViolenceID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDomesticViolenceID() {
                    return domesticViolenceID;
                }

                /**
                 * Sets the value of the domesticViolenceID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDomesticViolenceID(String value) {
                    this.domesticViolenceID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the domesticViolenceVictim property.
                 * 
                 */
                public byte getDomesticViolenceVictim() {
                    return domesticViolenceVictim;
                }

                /**
                 * Sets the value of the domesticViolenceVictim property.
                 * 
                 */
                public void setDomesticViolenceVictim(byte value) {
                    this.domesticViolenceVictim = value;
                }

                /**
                 * Gets the value of the whenOccurred property.
                 * 
                 */
                public byte getWhenOccurred() {
                    return whenOccurred;
                }

                /**
                 * Sets the value of the whenOccurred property.
                 * 
                 */
                public void setWhenOccurred(byte value) {
                    this.whenOccurred = value;
                }

                /**
                 * Gets the value of the currentlyFleeing property.
                 * 
                 */
                public byte getCurrentlyFleeing() {
                    return currentlyFleeing;
                }

                /**
                 * Sets the value of the currentlyFleeing property.
                 * 
                 */
                public void setCurrentlyFleeing(byte value) {
                    this.currentlyFleeing = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EducationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LastGradeCompleted" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SchoolStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "educationID",
                "enrollmentID",
                "lastGradeCompleted",
                "schoolStatus"
            })
            public static class Education {

                @XmlElement(name = "EducationID", required = true)
                protected String educationID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "LastGradeCompleted")
                protected byte lastGradeCompleted;
                @XmlElement(name = "SchoolStatus")
                protected byte schoolStatus;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the educationID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEducationID() {
                    return educationID;
                }

                /**
                 * Sets the value of the educationID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEducationID(String value) {
                    this.educationID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the lastGradeCompleted property.
                 * 
                 */
                public byte getLastGradeCompleted() {
                    return lastGradeCompleted;
                }

                /**
                 * Sets the value of the lastGradeCompleted property.
                 * 
                 */
                public void setLastGradeCompleted(byte value) {
                    this.lastGradeCompleted = value;
                }

                /**
                 * Gets the value of the schoolStatus property.
                 * 
                 */
                public byte getSchoolStatus() {
                    return schoolStatus;
                }

                /**
                 * Sets the value of the schoolStatus property.
                 * 
                 */
                public void setSchoolStatus(byte value) {
                    this.schoolStatus = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EmploymentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Employed" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="EmploymentType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NotEmployedReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "employmentID",
                "enrollmentID",
                "employed",
                "employmentType",
                "notEmployedReason"
            })
            public static class Employment {

                @XmlElement(name = "EmploymentID", required = true)
                protected String employmentID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "Employed")
                protected byte employed;
                @XmlElement(name = "EmploymentType")
                protected byte employmentType;
                @XmlElement(name = "NotEmployedReason")
                protected byte notEmployedReason;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the employmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEmploymentID() {
                    return employmentID;
                }

                /**
                 * Sets the value of the employmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEmploymentID(String value) {
                    this.employmentID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the employed property.
                 * 
                 */
                public byte getEmployed() {
                    return employed;
                }

                /**
                 * Sets the value of the employed property.
                 * 
                 */
                public void setEmployed(byte value) {
                    this.employed = value;
                }

                /**
                 * Gets the value of the employmentType property.
                 * 
                 */
                public byte getEmploymentType() {
                    return employmentType;
                }

                /**
                 * Sets the value of the employmentType property.
                 * 
                 */
                public void setEmploymentType(byte value) {
                    this.employmentType = value;
                }

                /**
                 * Gets the value of the notEmployedReason property.
                 * 
                 */
                public byte getNotEmployedReason() {
                    return notEmployedReason;
                }

                /**
                 * Sets the value of the notEmployedReason property.
                 * 
                 */
                public void setNotEmployedReason(byte value) {
                    this.notEmployedReason = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PersonalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ProjectID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="EntryDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="HouseholdID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="RelationshipToHoH" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ResidencePrior" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherResidencePrior" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ResidencePriorLengthOfStay" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="EntryFromStreetESSH" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DateToStreetESSH" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
             *         &lt;element name="TimesHomelessPastThreeYears" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MonthsHomelessPastThreeYears" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DisablingCondition" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HousingStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "enrollmentID",
                "personalID",
                "projectID",
                "entryDate",
                "householdID",
                "relationshipToHoH",
                "residencePrior",
                /*"otherResidencePrior",*/
                //"residencePriorLengthOfStay",
                /*"entryFromStreetESSH",*/
                "dateToStreetESSH",
                "timesHomelessPastThreeYears",
                "monthsHomelessPastThreeYears",
                "disablingCondition",
                //"housingStatus",
                "losUnderThreshold",
                "previousStreetESSH",
                "livingSituation",
                "lengthOfStay"
            })
            public static class Enrollment {

                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "PersonalID", required = true)
                protected String personalID;
                @XmlElement(name = "ProjectID", required = true)
                protected String projectID;
                @XmlElement(name = "EntryDate", required = true)
                protected XMLGregorianCalendar entryDate;
                @XmlElement(name = "HouseholdID", required = true)
                protected String householdID;
                @XmlElement(name = "RelationshipToHoH")
                protected byte relationshipToHoH;
                @XmlElement(name = "ResidencePrior")
                protected byte residencePrior;
                @XmlElement(name = "livingSituation")
                protected String livingSituation;
                @XmlElement(name = "lengthOfStay")
                protected String lengthOfStay;
                /*@XmlElement(name = "OtherResidencePrior", required = true)
                protected String otherResidencePrior;*/
                /*@XmlElement(name = "ResidencePriorLengthOfStay")
                protected byte residencePriorLengthOfStay;*/
                /*@XmlElement(name = "EntryFromStreetESSH")
                protected byte entryFromStreetESSH;*/
                @XmlElement(name="LOSUnderThreshold")
                protected byte losUnderThreshold;
                @XmlElement(name="PreviousStreetESSH")
                protected byte previousStreetESSH;
                @XmlElement(name = "DateToStreetESSH")
                protected XMLGregorianCalendar dateToStreetESSH;
                @XmlElement(name = "TimesHomelessPastThreeYears")
                protected byte timesHomelessPastThreeYears;
                @XmlElement(name = "MonthsHomelessPastThreeYears")
                protected byte monthsHomelessPastThreeYears;
                @XmlElement(name = "DisablingCondition")
                protected byte disablingCondition;
               /* @XmlElement(name = "HousingStatus")
                protected byte housingStatus;*/
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the personalID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPersonalID() {
                    return personalID;
                }

                /**
                 * Sets the value of the personalID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPersonalID(String value) {
                    this.personalID = value;
                }

                /**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                public String getLivingSituation() {
					return livingSituation;
				}

				public void setLivingSituation(String livingSituation) {
					this.livingSituation = livingSituation;
				}

				public String getLengthOfStay() {
					return lengthOfStay;
				}

				public void setLengthOfStay(String lengthOfStay) {
					this.lengthOfStay = lengthOfStay;
				}

				/**
                 * Gets the value of the entryDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEntryDate() {
                    return entryDate;
                }

                /**
                 * Sets the value of the entryDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEntryDate(XMLGregorianCalendar value) {
                    this.entryDate = value;
                }

                /**
                 * Gets the value of the householdID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHouseholdID() {
                    return householdID;
                }

                /**
                 * Sets the value of the householdID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHouseholdID(String value) {
                    this.householdID = value;
                }

                /**
                 * Gets the value of the relationshipToHoH property.
                 * 
                 */
                public byte getRelationshipToHoH() {
                    return relationshipToHoH;
                }

                /**
                 * Sets the value of the relationshipToHoH property.
                 * 
                 */
                public void setRelationshipToHoH(byte value) {
                    this.relationshipToHoH = value;
                }

                /**
                 * Gets the value of the residencePrior property.
                 * 
                 */
                public byte getResidencePrior() {
                    return residencePrior;
                }

                /**
                 * Sets the value of the residencePrior property.
                 * 
                 */
                public void setResidencePrior(byte value) {
                    this.residencePrior = value;
                }

                /**
                 * Gets the value of the otherResidencePrior property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                /*public String getOtherResidencePrior() {
                    return otherResidencePrior;
                }*/

                /**
                 * Sets the value of the otherResidencePrior property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                /*public void setOtherResidencePrior(String value) {
                    this.otherResidencePrior = value;
                }
*/
                /**
                 * Gets the value of the residencePriorLengthOfStay property.
                 * 
                 */
                /*public byte getResidencePriorLengthOfStay() {
                    return residencePriorLengthOfStay;
                }*/

                /**
                 * Sets the value of the residencePriorLengthOfStay property.
                 * 
                 */
               /* public void setResidencePriorLengthOfStay(byte value) {
                    this.residencePriorLengthOfStay = value;
                }*/

                /**
                 * Gets the value of the entryFromStreetESSH property.
                 * 
                 */
               /* public byte getEntryFromStreetESSH() {
                    return entryFromStreetESSH;
                }*/

                /**
                 * Sets the value of the entryFromStreetESSH property.
                 * 
                 */
               /* public void setEntryFromStreetESSH(byte value) {
                    this.entryFromStreetESSH = value;
                }*/
                
                
                /**
                 * Gets the value of the LOSUnderThreshold property.
                 * 
                 */
                public byte getLosUnderThreshold() {
					return losUnderThreshold;
				}

				public void setLosUnderThreshold(byte losUnderThreshold) {
					this.losUnderThreshold = losUnderThreshold;
				}

				/**
                 * Sets the value of the PreviousStreetESSH property.
                 * 
                 */
               				
				public byte getPreviousStreetESSH() {
					return previousStreetESSH;
				}

				public void setPreviousStreetESSH(byte previousStreetESSH) {
					this.previousStreetESSH = previousStreetESSH;
				}

				
                /**
                 * Gets the value of the dateToStreetESSH property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateToStreetESSH() {
                    return dateToStreetESSH;
                }

                /**
                 * Sets the value of the dateToStreetESSH property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateToStreetESSH(XMLGregorianCalendar value) {
                    this.dateToStreetESSH = value;
                }

                /**
                 * Gets the value of the timesHomelessPastThreeYears property.
                 * 
                 */
                public byte getTimesHomelessPastThreeYears() {
                    return timesHomelessPastThreeYears;
                }

                /**
                 * Sets the value of the timesHomelessPastThreeYears property.
                 * 
                 */
                public void setTimesHomelessPastThreeYears(byte value) {
                    this.timesHomelessPastThreeYears = value;
                }

                /**
                 * Gets the value of the monthsHomelessPastThreeYears property.
                 * 
                 */
                public byte getMonthsHomelessPastThreeYears() {
                    return monthsHomelessPastThreeYears;
                }

                /**
                 * Sets the value of the monthsHomelessPastThreeYears property.
                 * 
                 */
                public void setMonthsHomelessPastThreeYears(byte value) {
                    this.monthsHomelessPastThreeYears = value;
                }

                /**
                 * Gets the value of the disablingCondition property.
                 * 
                 */
                public byte getDisablingCondition() {
                    return disablingCondition;
                }

                /**
                 * Sets the value of the disablingCondition property.
                 * 
                 */
                public void setDisablingCondition(byte value) {
                    this.disablingCondition = value;
                }

                /**
                 * Gets the value of the housingStatus property.
                 * 
                 */
                /*public byte getHousingStatus() {
                    return housingStatus;
                }*/

                /**
                 * Sets the value of the housingStatus property.
                 * 
                 */
                /*public void setHousingStatus(byte value) {
                    this.housingStatus = value;
                }*/

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EnrollmentCoCID" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="CoCCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "enrollmentCoCID",
                "enrollmentID",
                "cocCode",
                "householdID",
                "informationDate"
            })
            public static class EnrollmentCoC {

                @XmlElement(name = "EnrollmentCoCID")
                protected String enrollmentCoCID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "CocCode", required = true)
                protected String cocCode;
                @XmlElement(name="HouseholdID")
                protected String householdID;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the enrollmentCoCID property.
                 * 
                 */
                public String getEnrollmentCoCID() {
                    return enrollmentCoCID;
                }

                /**
                 * Sets the value of the enrollmentCoCID property.
                 * 
                 */
                public void setEnrollmentCoCID(String value) {
                    this.enrollmentCoCID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the coCCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCocCode() {
                    return cocCode;
                }

                /**
                 * Sets the value of the coCCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCocCode(String value) {
                    this.cocCode = value;
                }
                
                public String getHouseholdID() {
					return householdID;
				}
                
                /**
                 * Sets the value of the householdID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */        
                
				public void setHouseholdID(String householdID) {
					this.householdID = householdID;
				}
				
				
				/**
                 * Gets the value of the coCCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
				/*public String getCocCode() {
					return cocCode;
				}*/

				/**
                 * Sets the value of the coCCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */ 
				/*public void setCocCode(String cocCode) {
					this.cocCode = cocCode;
				}*/

				/**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EntryRHYID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="HouseholdDynamics" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SexualOrientation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SexualOrientationGenderIdentityYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SexualOrientationGenderIDFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HousingIssuesYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HousingIssuesFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SchoolEducationalIssuesYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SchoolEducationalIssuesFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="UnemploymentYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="UnemploymentFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MentalHealthIssuesYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MentalHealthIssuesFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HealthIssuesYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HealthIssuesFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PhysicalDisabilityYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PhysicalDisabilityFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MentalDisabilityYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MentalDisabilityFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AbuseAndNeglectYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AbuseAndNeglectFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AlcoholDrugAbuseYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AlcoholDrugAbuseFam" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="InsufficientIncome" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ActiveMilitaryParent" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="IncarceratedParent" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="IncarceratedParentStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="WorkPlaceViolenceThreats" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="WorkplacePromiseDifference" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="CoercedToContinueWork" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="LaborExploitPastThreeMonths" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ExchangeForSex" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ExchangeForSexPastThreeMonths" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="CountOfExchangeForSex" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AskedOrForcedToExchangeForSex" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AskedOrForcedToExchangeForSexPastThreeMonths" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="FormerWardJuvenileJustice" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="JuvenileJusticeYears" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="JuvenileJusticeMonths" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="FormerWardChildWelfare" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ChildWelfareYears" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ChildWelfareMonths" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ReferralSource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="CountOutreachReferralApproaches" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "entryRHYID",
                "enrollmentID",
                "sexualOrientation",
                "unemploymentFam",
                "mentalHealthIssuesFam",
                "physicalDisabilityFam",
                "alcoholDrugAbuseFam",
                "insufficientIncome",
                "incarceratedParent",
                "formerWardJuvenileJustice",
                "juvenileJusticeYears",
                "juvenileJusticeMonths",
                "formerWardChildWelfare",
                "childWelfareYears",
                "childWelfareMonths",
                "referralSource",
                "countOutreachReferralApproaches"
            })
            public static class EntryRHY {

                @XmlElement(name = "EntryRHYID", required = true)
                protected String entryRHYID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "SexualOrientation")
                protected byte sexualOrientation;
                @XmlElement(name = "UnemploymentFam")
                protected byte unemploymentFam;
                @XmlElement(name = "MentalHealthIssuesFam")
                protected byte mentalHealthIssuesFam;
                @XmlElement(name = "PhysicalDisabilityFam")
                protected byte physicalDisabilityFam;
                @XmlElement(name = "AlcoholDrugAbuseFam")
                protected byte alcoholDrugAbuseFam;
                @XmlElement(name = "InsufficientIncome")
                protected byte insufficientIncome;
                @XmlElement(name = "IncarceratedParent")
                protected byte incarceratedParent;
                @XmlElement(name = "FormerWardJuvenileJustice")
                protected byte formerWardJuvenileJustice;
                @XmlElement(name = "JuvenileJusticeYears")
                protected byte juvenileJusticeYears;
                @XmlElement(name = "JuvenileJusticeMonths")
                protected byte juvenileJusticeMonths;
                @XmlElement(name = "FormerWardChildWelfare")
                protected byte formerWardChildWelfare;
                @XmlElement(name = "ChildWelfareYears")
                protected byte childWelfareYears;
                @XmlElement(name = "ChildWelfareMonths")
                protected byte childWelfareMonths;
                @XmlElement(name = "ReferralSource")
                protected byte referralSource;
                @XmlElement(name = "CountOutreachReferralApproaches")
                protected byte countOutreachReferralApproaches;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the entryRHYID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEntryRHYID() {
                    return entryRHYID;
                }

                /**
                 * Sets the value of the entryRHYID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEntryRHYID(String value) {
                    this.entryRHYID = value;
                }


                public String getEnrollmentID() {
					return enrollmentID;
				}

				public void setEnrollmentID(String enrollmentID) {
					this.enrollmentID = enrollmentID;
				}

				/**
                 * Gets the value of the sexualOrientation property.
                 * 
                 */
                public byte getSexualOrientation() {
                    return sexualOrientation;
                }

                /**
                 * Sets the value of the sexualOrientation property.
                 * 
                 */
                public void setSexualOrientation(byte value) {
                    this.sexualOrientation = value;
                }

                /**
                 * Gets the value of the unemploymentFam property.
                 * 
                 */
                public byte getUnemploymentFam() {
                    return unemploymentFam;
                }

                /**
                 * Sets the value of the unemploymentFam property.
                 * 
                 */
                public void setUnemploymentFam(byte value) {
                    this.unemploymentFam = value;
                }

                /**
                 * Gets the value of the mentalHealthIssuesFam property.
                 * 
                 */
                public byte getMentalHealthIssuesFam() {
                    return mentalHealthIssuesFam;
                }

                /**
                 * Sets the value of the mentalHealthIssuesFam property.
                 * 
                 */
                public void setMentalHealthIssuesFam(byte value) {
                    this.mentalHealthIssuesFam = value;
                }

                /**
                 * Gets the value of the physicalDisabilityFam property.
                 * 
                 */
                public byte getPhysicalDisabilityFam() {
                    return physicalDisabilityFam;
                }

                /**
                 * Sets the value of the physicalDisabilityFam property.
                 * 
                 */
                public void setPhysicalDisabilityFam(byte value) {
                    this.physicalDisabilityFam = value;
                }

                /**
                 * Gets the value of the alcoholDrugAbuseFam property.
                 * 
                 */
                public byte getAlcoholDrugAbuseFam() {
                    return alcoholDrugAbuseFam;
                }

                /**
                 * Sets the value of the alcoholDrugAbuseFam property.
                 * 
                 */
                public void setAlcoholDrugAbuseFam(byte value) {
                    this.alcoholDrugAbuseFam = value;
                }

                /**
                 * Gets the value of the insufficientIncome property.
                 * 
                 */
                public byte getInsufficientIncome() {
                    return insufficientIncome;
                }

                /**
                 * Sets the value of the insufficientIncome property.
                 * 
                 */
                public void setInsufficientIncome(byte value) {
                    this.insufficientIncome = value;
                }


                /**
                 * Gets the value of the incarceratedParent property.
                 * 
                 */
                public byte getIncarceratedParent() {
                    return incarceratedParent;
                }

                /**
                 * Sets the value of the incarceratedParent property.
                 * 
                 */
                public void setIncarceratedParent(byte value) {
                    this.incarceratedParent = value;
                }


                /**
                 * Gets the value of the formerWardJuvenileJustice property.
                 * 
                 */
                public byte getFormerWardJuvenileJustice() {
                    return formerWardJuvenileJustice;
                }

                /**
                 * Sets the value of the formerWardJuvenileJustice property.
                 * 
                 */
                public void setFormerWardJuvenileJustice(byte value) {
                    this.formerWardJuvenileJustice = value;
                }

                /**
                 * Gets the value of the juvenileJusticeYears property.
                 * 
                 */
                public byte getJuvenileJusticeYears() {
                    return juvenileJusticeYears;
                }

                /**
                 * Sets the value of the juvenileJusticeYears property.
                 * 
                 */
                public void setJuvenileJusticeYears(byte value) {
                    this.juvenileJusticeYears = value;
                }

                /**
                 * Gets the value of the juvenileJusticeMonths property.
                 * 
                 */
                public byte getJuvenileJusticeMonths() {
                    return juvenileJusticeMonths;
                }

                /**
                 * Sets the value of the juvenileJusticeMonths property.
                 * 
                 */
                public void setJuvenileJusticeMonths(byte value) {
                    this.juvenileJusticeMonths = value;
                }

                /**
                 * Gets the value of the formerWardChildWelfare property.
                 * 
                 */
                public byte getFormerWardChildWelfare() {
                    return formerWardChildWelfare;
                }

                /**
                 * Sets the value of the formerWardChildWelfare property.
                 * 
                 */
                public void setFormerWardChildWelfare(byte value) {
                    this.formerWardChildWelfare = value;
                }

                /**
                 * Gets the value of the childWelfareYears property.
                 * 
                 */
                public byte getChildWelfareYears() {
                    return childWelfareYears;
                }

                /**
                 * Sets the value of the childWelfareYears property.
                 * 
                 */
                public void setChildWelfareYears(byte value) {
                    this.childWelfareYears = value;
                }

                /**
                 * Gets the value of the childWelfareMonths property.
                 * 
                 */
                public byte getChildWelfareMonths() {
                    return childWelfareMonths;
                }

                /**
                 * Sets the value of the childWelfareMonths property.
                 * 
                 */
                public void setChildWelfareMonths(byte value) {
                    this.childWelfareMonths = value;
                }

                /**
                 * Gets the value of the referralSource property.
                 * 
                 */
                public byte getReferralSource() {
                    return referralSource;
                }

                /**
                 * Sets the value of the referralSource property.
                 * 
                 */
                public void setReferralSource(byte value) {
                    this.referralSource = value;
                }

                /**
                 * Gets the value of the countOutreachReferralApproaches property.
                 * 
                 */
                public byte getCountOutreachReferralApproaches() {
                    return countOutreachReferralApproaches;
                }

                /**
                 * Sets the value of the countOutreachReferralApproaches property.
                 * 
                 */
                public void setCountOutreachReferralApproaches(byte value) {
                    this.countOutreachReferralApproaches = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EntrySSVFID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PercentAMI" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HPScreeningScore" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VAMCStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LastPermanentStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LastPermanentCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LastPermanentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LastPermanentZIP" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="AddressDataQuality" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}short" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "entrySSVFID",
                "enrollmentID",
                "percentAMI",
                "hpScreeningScore",
                "vamcStation",
                "lastPermanentStreet",
                "lastPermanentCity",
                "lastPermanentState",
                "lastPermanentZIP",
                "addressDataQuality",
                "urgentReferral",
                "timeToHousingLoss",
                "zeroIncome",
                "annualPercentAMI",
                "financialChange",
                "householdChange",
                "evictionHistory",
                "subsidyAtRisk",
                "literalHomelessHistory",
                "disabledHoH",
                "criminalRecord",
                "sexOffender",
                "dependentUnder6",
                "singleParent",
                "hh5Plus",
                "iraqAfghanistan",
                "femVet",
                "hpsScreeningScore",
                "thresholdScore",
                "eRVisits",
                "jailNights",
                "hospitalNights"
            })
            public static class EntrySSVF {

                @XmlElement(name = "EntrySSVFID", required = true)
                protected String entrySSVFID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "PercentAMI")
                protected String percentAMI;
                @XmlElement(name = "HPScreeningScore")
                protected byte hpScreeningScore;
                @XmlElement(name = "VAMCStation", required = true)
                protected String vamcStation;
                @XmlElement(name = "LastPermanentStreet", required = true)
                protected String lastPermanentStreet;
                @XmlElement(name = "LastPermanentCity", required = true)
                protected String lastPermanentCity;
                @XmlElement(name = "LastPermanentState", required = true)
                protected String lastPermanentState;
                @XmlElement(name = "LastPermanentZIP")
                protected int lastPermanentZIP;
                @XmlElement(name = "AddressDataQuality")
                protected String addressDataQuality;
                
                @XmlElement(name = "UrgentReferral")
                protected String urgentReferral;
                @XmlElement(name = "TimeToHousingLoss")
                protected String timeToHousingLoss;
                @XmlElement(name = "ZeroIncome")
                protected String zeroIncome;
                @XmlElement(name = "AnnualPercentAMI")
                protected String annualPercentAMI;
                @XmlElement(name = "FinancialChange")
                protected String financialChange;
                @XmlElement(name = "HouseholdChange")
                protected String householdChange;
                @XmlElement(name = "EvictionHistory")
                protected String evictionHistory;
                @XmlElement(name = "SubsidyAtRisk")
                protected String subsidyAtRisk;
                @XmlElement(name = "LiteralHomelessHistory")
                protected String literalHomelessHistory;
                @XmlElement(name = "DisabledHoH")
                protected String disabledHoH;
                @XmlElement(name = "CriminalRecord")
                protected String criminalRecord;
                @XmlElement(name = "SexOffender")
                protected String sexOffender;
                @XmlElement(name = "DependentUnder6")
                protected String dependentUnder6;
                @XmlElement(name = "SingleParent")
                protected String singleParent;
                @XmlElement(name = "HH5Plus")
                protected String hh5Plus;
                @XmlElement(name = "IraqAfghanistan")
                protected String iraqAfghanistan;
                @XmlElement(name = "FemVet")
                protected String femVet;
                @XmlElement(name = "HPScreeningScore")
                protected String hpsScreeningScore;
                @XmlElement(name = "ThresholdScore")
                protected String thresholdScore;
                @XmlElement(name = "ERVisits")
                protected String eRVisits;
                @XmlElement(name = "JailNights")
                protected String jailNights;
                @XmlElement(name = "HospitalNights")
                protected String hospitalNights;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the entrySSVFID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEntrySSVFID() {
                    return entrySSVFID;
                }

                /**
                 * Sets the value of the entrySSVFID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEntrySSVFID(String value) {
                    this.entrySSVFID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the percentAMI property.
                 * 
                 */
                public String getPercentAMI() {
                    return percentAMI;
                }

                /**
                 * Sets the value of the percentAMI property.
                 * 
                 */
                public void setPercentAMI(String value) {
                    this.percentAMI = value;
                }

                /**
                 * Gets the value of the hpScreeningScore property.
                 * 
                 */
                public byte getHPScreeningScore() {
                    return hpScreeningScore;
                }

                /**
                 * Sets the value of the hpScreeningScore property.
                 * 
                 */
                public void setHPScreeningScore(byte value) {
                    this.hpScreeningScore = value;
                }
                
                

                /**
                 * Gets the value of the vamcStation property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVAMCStation() {
                    return vamcStation;
                }

                /**
                 * Sets the value of the vamcStation property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVAMCStation(String value) {
                    this.vamcStation = value;
                }
                
                
                public String getUrgentReferral() {
					return urgentReferral;
				}

				public void setUrgentReferral(String urgentReferral) {
					this.urgentReferral = urgentReferral;
				}

				public String getTimeToHousingLoss() {
					return timeToHousingLoss;
				}

				public void setTimeToHousingLoss(String timeToHousingLoss) {
					this.timeToHousingLoss = timeToHousingLoss;
				}

				public String getZeroIncome() {
					return zeroIncome;
				}

				public void setZeroIncome(String zeroIncome) {
					this.zeroIncome = zeroIncome;
				}

				public String getAnnualPercentAMI() {
					return annualPercentAMI;
				}

				public void setAnnualPercentAMI(String annualPercentAMI) {
					this.annualPercentAMI = annualPercentAMI;
				}

				public String getFinancialChange() {
					return financialChange;
				}

				public void setFinancialChange(String financialChange) {
					this.financialChange = financialChange;
				}

				public String getHouseholdChange() {
					return householdChange;
				}

				public void setHouseholdChange(String householdChange) {
					this.householdChange = householdChange;
				}

				public String getEvictionHistory() {
					return evictionHistory;
				}

				public void setEvictionHistory(String evictionHistory) {
					this.evictionHistory = evictionHistory;
				}

				public String getSubsidyAtRisk() {
					return subsidyAtRisk;
				}

				public void setSubsidyAtRisk(String subsidyAtRisk) {
					this.subsidyAtRisk = subsidyAtRisk;
				}

				public String getLiteralHomelessHistory() {
					return literalHomelessHistory;
				}

				public void setLiteralHomelessHistory(String literalHomelessHistory) {
					this.literalHomelessHistory = literalHomelessHistory;
				}

				public String getDisabledHoH() {
					return disabledHoH;
				}

				public void setDisabledHoH(String disabledHoH) {
					this.disabledHoH = disabledHoH;
				}

				public String getCriminalRecord() {
					return criminalRecord;
				}

				public void setCriminalRecord(String criminalRecord) {
					this.criminalRecord = criminalRecord;
				}

				public String getSexOffender() {
					return sexOffender;
				}

				public void setSexOffender(String sexOffender) {
					this.sexOffender = sexOffender;
				}

				public String getDependentUnder6() {
					return dependentUnder6;
				}

				public void setDependentUnder6(String dependentUnder6) {
					this.dependentUnder6 = dependentUnder6;
				}

				public String getSingleParent() {
					return singleParent;
				}

				public void setSingleParent(String singleParent) {
					this.singleParent = singleParent;
				}

				public String getHh5Plus() {
					return hh5Plus;
				}

				public void setHh5Plus(String hh5Plus) {
					this.hh5Plus = hh5Plus;
				}

				public String getIraqAfghanistan() {
					return iraqAfghanistan;
				}

				public void setIraqAfghanistan(String iraqAfghanistan) {
					this.iraqAfghanistan = iraqAfghanistan;
				}

				public String getFemVet() {
					return femVet;
				}

				public void setFemVet(String femVet) {
					this.femVet = femVet;
				}

				public String getHpsScreeningScore() {
					return hpsScreeningScore;
				}

				public void setHpsScreeningScore(String hpsScreeningScore) {
					this.hpsScreeningScore = hpsScreeningScore;
				}

				public String getThresholdScore() {
					return thresholdScore;
				}

				public void setThresholdScore(String thresholdScore) {
					this.thresholdScore = thresholdScore;
				}

				public String geteRVisits() {
					return eRVisits;
				}

				public void seteRVisits(String eRVisits) {
					this.eRVisits = eRVisits;
				}

				public String getJailNights() {
					return jailNights;
				}

				public void setJailNights(String jailNights) {
					this.jailNights = jailNights;
				}

				public String getHospitalNights() {
					return hospitalNights;
				}

				public void setHospitalNights(String hospitalNights) {
					this.hospitalNights = hospitalNights;
				}

				/**
                 * Gets the value of the lastPermanentStreet property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLastPermanentStreet() {
                    return lastPermanentStreet;
                }

                /**
                 * Sets the value of the lastPermanentStreet property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLastPermanentStreet(String value) {
                    this.lastPermanentStreet = value;
                }

                /**
                 * Gets the value of the lastPermanentCity property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLastPermanentCity() {
                    return lastPermanentCity;
                }

                /**
                 * Sets the value of the lastPermanentCity property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLastPermanentCity(String value) {
                    this.lastPermanentCity = value;
                }

                /**
                 * Gets the value of the lastPermanentState property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLastPermanentState() {
                    return lastPermanentState;
                }

                /**
                 * Sets the value of the lastPermanentState property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLastPermanentState(String value) {
                    this.lastPermanentState = value;
                }

                /**
                 * Gets the value of the lastPermanentZIP property.
                 * 
                 */
                public int getLastPermanentZIP() {
                    return lastPermanentZIP;
                }

                /**
                 * Sets the value of the lastPermanentZIP property.
                 * 
                 */
                public void setLastPermanentZIP(int value) {
                    this.lastPermanentZIP = value;
                }

                /**
                 * Gets the value of the addressDataQuality property.
                 * 
                 */
                public String getAddressDataQuality() {
                    return addressDataQuality;
                }

                /**
                 * Sets the value of the addressDataQuality property.
                 * 
                 */
                public void setAddressDataQuality(String value) {
                    this.addressDataQuality = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ExitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherDestination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "exitID",
                "enrollmentID",
                "exitDate",
                "destination",
                "otherDestination"
            })
            public static class Exit {

                @XmlElement(name = "ExitID", required = true)
                protected String exitID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "ExitDate", required = true)
                protected XMLGregorianCalendar exitDate;
                @XmlElement(name = "Destination")
                protected byte destination;
                @XmlElement(name = "OtherDestination")
                protected String otherDestination;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the exitID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitID() {
                    return exitID;
                }

                /**
                 * Sets the value of the exitID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitID(String value) {
                    this.exitID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the exitDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getExitDate() {
                    return exitDate;
                }

                /**
                 * Sets the value of the exitDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setExitDate(XMLGregorianCalendar value) {
                    this.exitDate = value;
                }

                /**
                 * Gets the value of the destination property.
                 * 
                 */
                public byte getDestination() {
                    return destination;
                }

                /**
                 * Sets the value of the destination property.
                 * 
                 */
                public void setDestination(byte value) {
                    this.destination = value;
                }

                /**
                 * Gets the value of the otherDestination property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOtherDestination() {
                    return otherDestination;
                }

                /**
                 * Sets the value of the otherDestination property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOtherDestination(String value) {
                    this.otherDestination = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ExitHousingAssessmentID" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="HousingAssessment" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SubsidyInformation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "exitHousingAssessmentID",
                "exitID",
                "housingAssessment",
                "subsidyInformation"
            })
            public static class ExitHousingAssessment {

                @XmlElement(name = "ExitHousingAssessmentID")
                protected String exitHousingAssessmentID;
                @XmlElement(name = "ExitID", required = true)
                protected String exitID;
                @XmlElement(name = "HousingAssessment")
                protected byte housingAssessment;
                @XmlElement(name = "SubsidyInformation")
                protected byte subsidyInformation;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the exitHousingAssessmentID property.
                 * 
                 */
                public String getExitHousingAssessmentID() {
                    return exitHousingAssessmentID;
                }

                /**
                 * Sets the value of the exitHousingAssessmentID property.
                 * 
                 */
                public void setExitHousingAssessmentID(String value) {
                    this.exitHousingAssessmentID = value;
                }

                /**
                 * Gets the value of the exitID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitID() {
                    return exitID;
                }

                /**
                 * Sets the value of the exitID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitID(String value) {
                    this.exitID = value;
                }

                /**
                 * Gets the value of the housingAssessment property.
                 * 
                 */
                public byte getHousingAssessment() {
                    return housingAssessment;
                }

                /**
                 * Sets the value of the housingAssessment property.
                 * 
                 */
                public void setHousingAssessment(byte value) {
                    this.housingAssessment = value;
                }

                /**
                 * Gets the value of the subsidyInformation property.
                 * 
                 */
                public byte getSubsidyInformation() {
                    return subsidyInformation;
                }

                /**
                 * Sets the value of the subsidyInformation property.
                 * 
                 */
                public void setSubsidyInformation(byte value) {
                    this.subsidyInformation = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ExitPATHID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ConnectionWithSOAR" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "exitPATHID",
                "exitID",
                "connectionWithSOAR"
            })
            public static class ExitPATH {

                @XmlElement(name = "ExitPATHID", required = true)
                protected String exitPATHID;
                @XmlElement(name = "ExitID", required = true)
                protected String exitID;
                @XmlElement(name = "ConnectionWithSOAR")
                protected byte connectionWithSOAR;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the exitPATHID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitPATHID() {
                    return exitPATHID;
                }

                /**
                 * Sets the value of the exitPATHID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitPATHID(String value) {
                    this.exitPATHID = value;
                }

                /**
                 * Gets the value of the exitID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitID() {
                    return exitID;
                }

                /**
                 * Sets the value of the exitID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitID(String value) {
                    this.exitID = value;
                }

                /**
                 * Gets the value of the connectionWithSOAR property.
                 * 
                 */
                public byte getConnectionWithSOAR() {
                    return connectionWithSOAR;
                }

                /**
                 * Sets the value of the connectionWithSOAR property.
                 * 
                 */
                public void setConnectionWithSOAR(byte value) {
                    this.connectionWithSOAR = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ExitRHYID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="WrittenAftercarePlan" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AssistanceMainstreamBenefits" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PermanentHousingPlacement" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TemporaryShelterPlacement" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ExitCounseling" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="FurtherFollowUpServices" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ScheduledFollowUpContacts" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ResourcePackage" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherAftercarePlanOrAction" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="FamilyReunificationAchieved" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ProjectCompletionStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="EarlyExitReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "exitRHYID",
                "exitID",
                "writtenAftercarePlan",
                "assistanceMainstreamBenefits",
                "permanentHousingPlacement",
                "temporaryShelterPlacement",
                "exitCounseling",
                "furtherFollowUpServices",
                "scheduledFollowUpContacts",
                "resourcePackage",
                "otherAftercarePlanOrAction",
                "familyReunificationAchieved",
                "projectCompletionStatus",
                "earlyExitReason"
            })
            public static class ExitRHY {

                @XmlElement(name = "ExitRHYID", required = true)
                protected String exitRHYID;
                @XmlElement(name = "ExitID", required = true)
                protected String exitID;
                @XmlElement(name = "WrittenAftercarePlan")
                protected byte writtenAftercarePlan;
                @XmlElement(name = "AssistanceMainstreamBenefits")
                protected byte assistanceMainstreamBenefits;
                @XmlElement(name = "PermanentHousingPlacement")
                protected byte permanentHousingPlacement;
                @XmlElement(name = "TemporaryShelterPlacement")
                protected byte temporaryShelterPlacement;
                @XmlElement(name = "ExitCounseling")
                protected byte exitCounseling;
                @XmlElement(name = "FurtherFollowUpServices")
                protected byte furtherFollowUpServices;
                @XmlElement(name = "ScheduledFollowUpContacts")
                protected byte scheduledFollowUpContacts;
                @XmlElement(name = "ResourcePackage")
                protected byte resourcePackage;
                @XmlElement(name = "OtherAftercarePlanOrAction")
                protected byte otherAftercarePlanOrAction;
                @XmlElement(name = "FamilyReunificationAchieved")
                protected byte familyReunificationAchieved;
                @XmlElement(name = "ProjectCompletionStatus")
                protected byte projectCompletionStatus;
                @XmlElement(name = "EarlyExitReason")
                protected byte earlyExitReason;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the exitRHYID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitRHYID() {
                    return exitRHYID;
                }

                /**
                 * Sets the value of the exitRHYID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitRHYID(String value) {
                    this.exitRHYID = value;
                }

                /**
                 * Gets the value of the exitID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitID() {
                    return exitID;
                }

                /**
                 * Sets the value of the exitID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitID(String value) {
                    this.exitID = value;
                }

                /**
                 * Gets the value of the writtenAftercarePlan property.
                 * 
                 */
                public byte getWrittenAftercarePlan() {
                    return writtenAftercarePlan;
                }

                /**
                 * Sets the value of the writtenAftercarePlan property.
                 * 
                 */
                public void setWrittenAftercarePlan(byte value) {
                    this.writtenAftercarePlan = value;
                }

                /**
                 * Gets the value of the assistanceMainstreamBenefits property.
                 * 
                 */
                public byte getAssistanceMainstreamBenefits() {
                    return assistanceMainstreamBenefits;
                }

                /**
                 * Sets the value of the assistanceMainstreamBenefits property.
                 * 
                 */
                public void setAssistanceMainstreamBenefits(byte value) {
                    this.assistanceMainstreamBenefits = value;
                }

                /**
                 * Gets the value of the permanentHousingPlacement property.
                 * 
                 */
                public byte getPermanentHousingPlacement() {
                    return permanentHousingPlacement;
                }

                /**
                 * Sets the value of the permanentHousingPlacement property.
                 * 
                 */
                public void setPermanentHousingPlacement(byte value) {
                    this.permanentHousingPlacement = value;
                }

                /**
                 * Gets the value of the temporaryShelterPlacement property.
                 * 
                 */
                public byte getTemporaryShelterPlacement() {
                    return temporaryShelterPlacement;
                }

                /**
                 * Sets the value of the temporaryShelterPlacement property.
                 * 
                 */
                public void setTemporaryShelterPlacement(byte value) {
                    this.temporaryShelterPlacement = value;
                }

                /**
                 * Gets the value of the exitCounseling property.
                 * 
                 */
                public byte getExitCounseling() {
                    return exitCounseling;
                }

                /**
                 * Sets the value of the exitCounseling property.
                 * 
                 */
                public void setExitCounseling(byte value) {
                    this.exitCounseling = value;
                }

                /**
                 * Gets the value of the furtherFollowUpServices property.
                 * 
                 */
                public byte getFurtherFollowUpServices() {
                    return furtherFollowUpServices;
                }

                /**
                 * Sets the value of the furtherFollowUpServices property.
                 * 
                 */
                public void setFurtherFollowUpServices(byte value) {
                    this.furtherFollowUpServices = value;
                }

                /**
                 * Gets the value of the scheduledFollowUpContacts property.
                 * 
                 */
                public byte getScheduledFollowUpContacts() {
                    return scheduledFollowUpContacts;
                }

                /**
                 * Sets the value of the scheduledFollowUpContacts property.
                 * 
                 */
                public void setScheduledFollowUpContacts(byte value) {
                    this.scheduledFollowUpContacts = value;
                }

                /**
                 * Gets the value of the resourcePackage property.
                 * 
                 */
                public byte getResourcePackage() {
                    return resourcePackage;
                }

                /**
                 * Sets the value of the resourcePackage property.
                 * 
                 */
                public void setResourcePackage(byte value) {
                    this.resourcePackage = value;
                }

                /**
                 * Gets the value of the otherAftercarePlanOrAction property.
                 * 
                 */
                public byte getOtherAftercarePlanOrAction() {
                    return otherAftercarePlanOrAction;
                }

                /**
                 * Sets the value of the otherAftercarePlanOrAction property.
                 * 
                 */
                public void setOtherAftercarePlanOrAction(byte value) {
                    this.otherAftercarePlanOrAction = value;
                }

                /**
                 * Gets the value of the familyReunificationAchieved property.
                 * 
                 */
                public byte getFamilyReunificationAchieved() {
                    return familyReunificationAchieved;
                }

                /**
                 * Sets the value of the familyReunificationAchieved property.
                 * 
                 */
                public void setFamilyReunificationAchieved(byte value) {
                    this.familyReunificationAchieved = value;
                }

                /**
                 * Gets the value of the projectCompletionStatus property.
                 * 
                 */
                public byte getProjectCompletionStatus() {
                    return projectCompletionStatus;
                }

                /**
                 * Sets the value of the projectCompletionStatus property.
                 * 
                 */
                public void setProjectCompletionStatus(byte value) {
                    this.projectCompletionStatus = value;
                }

                /**
                 * Gets the value of the earlyExitReason property.
                 * 
                 */
                public byte getEarlyExitReason() {
                    return earlyExitReason;
                }

                /**
                 * Sets the value of the earlyExitReason property.
                 * 
                 */
                public void setEarlyExitReason(byte value) {
                    this.earlyExitReason = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
             *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "startDate",
                "endDate"
            })
            public static class ExportPeriod {

                @XmlElement(name = "StartDate", required = true)
                protected XMLGregorianCalendar startDate;
                @XmlElement(name = "EndDate", required = true)
                protected XMLGregorianCalendar endDate;

                /**
                 * Gets the value of the startDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDate() {
                    return startDate;
                }

                /**
                 * Sets the value of the startDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDate(XMLGregorianCalendar value) {
                    this.startDate = value;
                }

                /**
                 * Gets the value of the endDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDate() {
                    return endDate;
                }

                /**
                 * Sets the value of the endDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDate(XMLGregorianCalendar value) {
                    this.endDate = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="FunderID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ProjectID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Funder" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="GrantID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "funderID",
                "projectID",
                "funder",
                "grantID",
                "startDate",
                "endDate"
            })
            public static class Funder {

                @XmlElement(name = "FunderID", required = true)
                protected String funderID;
                @XmlElement(name = "ProjectID", required = true)
                protected String projectID;
                @XmlElement(name = "Funder")
                protected byte funder;
                @XmlElement(name = "GrantID", required = true)
                protected String grantID;
                @XmlElement(name = "StartDate", required = true)
                protected XMLGregorianCalendar startDate;
                @XmlElement(name = "EndDate", required = true)
                protected XMLGregorianCalendar endDate;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the funderID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFunderID() {
                    return funderID;
                }

                /**
                 * Sets the value of the funderID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFunderID(String value) {
                    this.funderID = value;
                }

                /**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                /**
                 * Gets the value of the funder property.
                 * 
                 */
                public byte getFunder() {
                    return funder;
                }

                /**
                 * Sets the value of the funder property.
                 * 
                 */
                public void setFunder(byte value) {
                    this.funder = value;
                }

                /**
                 * Gets the value of the grantID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGrantID() {
                    return grantID;
                }

                /**
                 * Sets the value of the grantID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGrantID(String value) {
                    this.grantID = value;
                }

                /**
                 * Gets the value of the startDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDate() {
                    return startDate;
                }

                /**
                 * Sets the value of the startDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDate(XMLGregorianCalendar value) {
                    this.startDate = value;
                }

                /**
                 * Gets the value of the endDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDate() {
                    return endDate;
                }

                /**
                 * Sets the value of the endDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDate(XMLGregorianCalendar value) {
                    this.endDate = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="HealthInsuranceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="InsuranceFromAnySource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Medicaid" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoMedicaidReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Medicare" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoMedicareReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SCHIP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoSCHIPReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VAMedicalServices" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoVAMedReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="EmployerProvided" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoEmployerProvidedReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="COBRA" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoCOBRAReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PrivatePay" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoPrivatePayReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="StateHealthIns" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoStateHealthInsReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateDeleted" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "healthInsuranceID",
                "enrollmentID",
                "insuranceFromAnySource",
                "medicaid",
                "noMedicaidReason",
                "medicare",
                "noMedicareReason",
                "schip",
                "noSCHIPReason",
                "vaMedicalServices",
                "noVAMedReason",
                "employerProvided",
                "noEmployerProvidedReason",
                "cobra",
                "noCOBRAReason",
                "privatePay",
                "noPrivatePayReason",
                "stateHealthIns",
                "noStateHealthInsReason",
                "otherInsurance",
                "otherInsuranceIdentify",
                "indianHealthServices",
                "noIndianHealthServicesReason"
                /*"otherSource",
                "otherSourceIdentify"*/
                
            })
            public static class HealthInsurance {

                @XmlElement(name = "HealthInsuranceID", required = true)
                protected String healthInsuranceID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "InsuranceFromAnySource")
                protected byte insuranceFromAnySource;
                @XmlElement(name = "Medicaid")
                protected byte medicaid;
                @XmlElement(name = "NoMedicaidReason")
                protected byte noMedicaidReason;
                @XmlElement(name = "Medicare")
                protected byte medicare;
                @XmlElement(name = "NoMedicareReason")
                protected byte noMedicareReason;
                @XmlElement(name = "SCHIP")
                protected byte schip;
                @XmlElement(name = "NoSCHIPReason")
                protected byte noSCHIPReason;
                @XmlElement(name = "VAMedicalServices")
                protected byte vaMedicalServices;
                @XmlElement(name = "NoVAMedReason")
                protected byte noVAMedReason;
                @XmlElement(name = "EmployerProvided")
                protected byte employerProvided;
                @XmlElement(name = "NoEmployerProvidedReason")
                protected byte noEmployerProvidedReason;
                @XmlElement(name = "COBRA")
                protected byte cobra;
                @XmlElement(name = "NoCOBRAReason")
                protected byte noCOBRAReason;
                @XmlElement(name = "PrivatePay")
                protected byte privatePay;
                @XmlElement(name = "NoPrivatePayReason")
                protected byte noPrivatePayReason;
                @XmlElement(name = "StateHealthIns")
                protected byte stateHealthIns;
                @XmlElement(name = "NoStateHealthInsReason")
                protected byte noStateHealthInsReason;
                /*
                 * Added newly Starts*/
               /* @XmlElement(name = "otherSource")
                protected int otherSource;
                @XmlElement(name = "otherSourceIdentify")
                protected String otherSourceIdentify;*/
                /*
                 * Added newly Ends*/
                @XmlElement(name = "OtherInsurance")
                protected byte otherInsurance;
                @XmlElement(name = "OtherInsuranceIdentify")
                protected String otherInsuranceIdentify;
                @XmlElement(name = "IndianHealthServices")
                protected byte indianHealthServices;
                @XmlElement(name = "NoIndianHealthServicesReason")
                protected String noIndianHealthServicesReason;
                
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateDeleted;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                	
                /*
                 * Added newly Starts*/
               /* public int getOtherSource() {
					return otherSource;
				}

				public void setOtherSource(int value) {
					this.otherSource = value;
				}

				public String getOtherSourceIdentify() {
					return otherSourceIdentify;
				}

				public void setOtherSourceIdentify(String value) {
					this.otherSourceIdentify = value;
				}*/
				/*
                 * Added newly Ends*/
				
				/**
                 * Gets the value of the healthInsuranceID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHealthInsuranceID() {
                    return healthInsuranceID;
                }

                /**
                 * Sets the value of the healthInsuranceID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHealthInsuranceID(String value) {
                    this.healthInsuranceID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the insuranceFromAnySource property.
                 * 
                 */
                public byte getInsuranceFromAnySource() {
                    return insuranceFromAnySource;
                }

                /**
                 * Sets the value of the insuranceFromAnySource property.
                 * 
                 */
                public void setInsuranceFromAnySource(byte value) {
                    this.insuranceFromAnySource = value;
                }

                /**
                 * Gets the value of the medicaid property.
                 * 
                 */
                public byte getMedicaid() {
                    return medicaid;
                }

                /**
                 * Sets the value of the medicaid property.
                 * 
                 */
                public void setMedicaid(byte value) {
                    this.medicaid = value;
                }

                /**
                 * Gets the value of the noMedicaidReason property.
                 * 
                 */
                public byte getNoMedicaidReason() {
                    return noMedicaidReason;
                }

                /**
                 * Sets the value of the noMedicaidReason property.
                 * 
                 */
                public void setNoMedicaidReason(byte value) {
                    this.noMedicaidReason = value;
                }

                /**
                 * Gets the value of the medicare property.
                 * 
                 */
                public byte getMedicare() {
                    return medicare;
                }

                /**
                 * Sets the value of the medicare property.
                 * 
                 */
                public void setMedicare(byte value) {
                    this.medicare = value;
                }

                /**
                 * Gets the value of the noMedicareReason property.
                 * 
                 */
                public byte getNoMedicareReason() {
                    return noMedicareReason;
                }

                /**
                 * Sets the value of the noMedicareReason property.
                 * 
                 */
                public void setNoMedicareReason(byte value) {
                    this.noMedicareReason = value;
                }

                /**
                 * Gets the value of the schip property.
                 * 
                 */
                public byte getSCHIP() {
                    return schip;
                }

                /**
                 * Sets the value of the schip property.
                 * 
                 */
                public void setSCHIP(byte value) {
                    this.schip = value;
                }

                /**
                 * Gets the value of the noSCHIPReason property.
                 * 
                 */
                public byte getNoSCHIPReason() {
                    return noSCHIPReason;
                }

                /**
                 * Sets the value of the noSCHIPReason property.
                 * 
                 */
                public void setNoSCHIPReason(byte value) {
                    this.noSCHIPReason = value;
                }

                /**
                 * Gets the value of the vaMedicalServices property.
                 * 
                 */
                public byte getVAMedicalServices() {
                    return vaMedicalServices;
                }

                /**
                 * Sets the value of the vaMedicalServices property.
                 * 
                 */
                public void setVAMedicalServices(byte value) {
                    this.vaMedicalServices = value;
                }

                /**
                 * Gets the value of the noVAMedReason property.
                 * 
                 */
                public byte getNoVAMedReason() {
                    return noVAMedReason;
                }

                /**
                 * Sets the value of the noVAMedReason property.
                 * 
                 */
                public void setNoVAMedReason(byte value) {
                    this.noVAMedReason = value;
                }

                /**
                 * Gets the value of the employerProvided property.
                 * 
                 */
                public byte getEmployerProvided() {
                    return employerProvided;
                }

                /**
                 * Sets the value of the employerProvided property.
                 * 
                 */
                public void setEmployerProvided(byte value) {
                    this.employerProvided = value;
                }

                /**
                 * Gets the value of the noEmployerProvidedReason property.
                 * 
                 */
                public byte getNoEmployerProvidedReason() {
                    return noEmployerProvidedReason;
                }

                /**
                 * Sets the value of the noEmployerProvidedReason property.
                 * 
                 */
                public void setNoEmployerProvidedReason(byte value) {
                    this.noEmployerProvidedReason = value;
                }

                /**
                 * Gets the value of the cobra property.
                 * 
                 */
                public byte getCOBRA() {
                    return cobra;
                }

                /**
                 * Sets the value of the cobra property.
                 * 
                 */
                public void setCOBRA(byte value) {
                    this.cobra = value;
                }

                /**
                 * Gets the value of the noCOBRAReason property.
                 * 
                 */
                public byte getNoCOBRAReason() {
                    return noCOBRAReason;
                }

                /**
                 * Sets the value of the noCOBRAReason property.
                 * 
                 */
                public void setNoCOBRAReason(byte value) {
                    this.noCOBRAReason = value;
                }

                /**
                 * Gets the value of the privatePay property.
                 * 
                 */
                public byte getPrivatePay() {
                    return privatePay;
                }

                /**
                 * Sets the value of the privatePay property.
                 * 
                 */
                public void setPrivatePay(byte value) {
                    this.privatePay = value;
                }

                /**
                 * Gets the value of the noPrivatePayReason property.
                 * 
                 */
                public byte getNoPrivatePayReason() {
                    return noPrivatePayReason;
                }

                /**
                 * Sets the value of the noPrivatePayReason property.
                 * 
                 */
                public void setNoPrivatePayReason(byte value) {
                    this.noPrivatePayReason = value;
                }

                /**
                 * Gets the value of the stateHealthIns property.
                 * 
                 */
                public byte getStateHealthIns() {
                    return stateHealthIns;
                }

                /**
                 * Sets the value of the stateHealthIns property.
                 * 
                 */
                public void setStateHealthIns(byte value) {
                    this.stateHealthIns = value;
                }

                /**
                 * Gets the value of the noStateHealthInsReason property.
                 * 
                 */
                public byte getNoStateHealthInsReason() {
                    return noStateHealthInsReason;
                }

                /**
                 * Sets the value of the noStateHealthInsReason property.
                 * 
                 */
                public void setNoStateHealthInsReason(byte value) {
                    this.noStateHealthInsReason = value;
                }
                
                public byte getOtherInsurance() {
					return otherInsurance;
				}

				public void setOtherInsurance(byte otherInsurance) {
					this.otherInsurance = otherInsurance;
				}

				public String getOtherInsuranceIdentify() {
					return otherInsuranceIdentify;
				}

				public void setOtherInsuranceIdentify(String otherInsuranceIdentify) {
					this.otherInsuranceIdentify = otherInsuranceIdentify;
				}

				public byte getIndianHealthServices() {
					return indianHealthServices;
				}

				public void setIndianHealthServices(byte indianHealthServices) {
					this.indianHealthServices = indianHealthServices;
				}

				public String getNoIndianHealthServicesReason() {
					return noIndianHealthServicesReason;
				}

				public void setNoIndianHealthServicesReason(String noIndianHealthServicesReason) {
					this.noIndianHealthServicesReason = noIndianHealthServicesReason;
				}

				/**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateDeleted property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateDeleted() {
                    return dateDeleted;
                }

                /**
                 * Sets the value of the dateDeleted property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateDeleted(XMLGregorianCalendar value) {
                    this.dateDeleted = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="HealthStatusID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="HealthCategory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="HealthStatus" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "healthStatusID",
                "enrollmentID",
                "healthCategory",
                "healthStatus",
                "dueDate"
            })
            public static class HealthStatus {

                @XmlElement(name = "HealthStatusID", required = true)
                protected String healthStatusID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "HealthCategory")
                protected byte healthCategory;
                @XmlElement(name = "HealthStatus")
                protected byte healthStatus;
                @XmlElement(name = "DueDate", required = true)
                protected XMLGregorianCalendar dueDate;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the healthStatusID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHealthStatusID() {
                    return healthStatusID;
                }

                /**
                 * Sets the value of the healthStatusID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHealthStatusID(String value) {
                    this.healthStatusID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the healthCategory property.
                 * 
                 */
                public byte getHealthCategory() {
                    return healthCategory;
                }

                /**
                 * Sets the value of the healthCategory property.
                 * 
                 */
                public void setHealthCategory(byte value) {
                    this.healthCategory = value;
                }

                /**
                 * Gets the value of the healthStatus property.
                 * 
                 */
                public byte getHealthStatus() {
                    return healthStatus;
                }

                /**
                 * Sets the value of the healthStatus property.
                 * 
                 */
                public void setHealthStatus(byte value) {
                    this.healthStatus = value;
                }

                /**
                 * Gets the value of the dueDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDueDate() {
                    return dueDate;
                }

                /**
                 * Sets the value of the dueDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDueDate(XMLGregorianCalendar value) {
                    this.dueDate = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="HousingAssessmentDispositionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ExitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="AssessmentDisposition" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherDisposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "housingAssessmentDispositionID",
                "exitID",
                "assessmentDisposition",
                "otherDisposition"
            })
            public static class HousingAssessmentDisposition {

                @XmlElement(name = "HousingAssessmentDispositionID", required = true)
                protected String housingAssessmentDispositionID;
                @XmlElement(name = "ExitID", required = true)
                protected String exitID;
                @XmlElement(name = "AssessmentDisposition")
                protected byte assessmentDisposition;
                @XmlElement(name = "OtherDisposition", required = true)
                protected String otherDisposition;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the housingAssessmentDispositionID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHousingAssessmentDispositionID() {
                    return housingAssessmentDispositionID;
                }

                /**
                 * Sets the value of the housingAssessmentDispositionID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHousingAssessmentDispositionID(String value) {
                    this.housingAssessmentDispositionID = value;
                }

                /**
                 * Gets the value of the exitID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExitID() {
                    return exitID;
                }

                /**
                 * Sets the value of the exitID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExitID(String value) {
                    this.exitID = value;
                }

                /**
                 * Gets the value of the assessmentDisposition property.
                 * 
                 */
                public byte getAssessmentDisposition() {
                    return assessmentDisposition;
                }

                /**
                 * Sets the value of the assessmentDisposition property.
                 * 
                 */
                public void setAssessmentDisposition(byte value) {
                    this.assessmentDisposition = value;
                }

                /**
                 * Gets the value of the otherDisposition property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOtherDisposition() {
                    return otherDisposition;
                }

                /**
                 * Sets the value of the otherDisposition property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOtherDisposition(String value) {
                    this.otherDisposition = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="IncomeAndSourcesID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="IncomeFromAnySource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TotalMonthlyIncome" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="Earned" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="EarnedAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="Unemployment" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="UnemploymentAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="SSI" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SSIAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="SSDI" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SSDIAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="VADisabilityService" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VADisabilityServiceAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="VADisabilityNonService" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="VADisabilityNonServiceAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="PrivateDisability" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PrivateDisabilityAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="WorkersComp" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="WorkersCompAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="TANF" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TANFAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="GA" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="GAAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="SocSecRetirement" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SocSecRetirementAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="Pension" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="PensionAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="ChildSupport" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ChildSupportAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="Alimony" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="AlimonyAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="OtherSource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherSourceAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="OtherSourceIdentify" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "incomeAndSourcesID",
                "enrollmentID",
                "incomeFromAnySource",
                "totalMonthlyIncome",
                "earned",
                "earnedAmount",
                "unemployment",
                "unemploymentAmount",
                "ssi",
                "ssiAmount",
                "ssdi",
                "ssdiAmount",
                "vaDisabilityService",
                "vaDisabilityServiceAmount",
                "vaDisabilityNonService",
                "vaDisabilityNonServiceAmount",
                "privateDisability",
                "privateDisabilityAmount",
                "workersComp",
                "workersCompAmount",
                "tanf",
                "tanfAmount",
                "ga",
                "gaAmount",
                "socSecRetirement",
                "socSecRetirementAmount",
                "pension",
                "pensionAmount",
                "childSupport",
                "childSupportAmount",
                "alimony",
                "alimonyAmount",
                "otherSource",
                "otherAmount",
                "otherSourceIdentify"
            })
            public static class IncomeAndSources {

                @XmlElement(name = "IncomeAndSourcesID", required = true)
                protected String incomeAndSourcesID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "IncomeFromAnySource")
                protected byte incomeFromAnySource;
                @XmlElement(name = "TotalMonthlyIncome")
                protected float totalMonthlyIncome;
                @XmlElement(name = "Earned")
                protected byte earned;
                @XmlElement(name = "EarnedAmount")
                protected float earnedAmount;
                @XmlElement(name = "Unemployment")
                protected byte unemployment;
                @XmlElement(name = "UnemploymentAmount")
                protected float unemploymentAmount;
                @XmlElement(name = "SSI")
                protected byte ssi;
                @XmlElement(name = "SSIAmount")
                protected float ssiAmount;
                @XmlElement(name = "SSDI")
                protected byte ssdi;
                @XmlElement(name = "SSDIAmount")
                protected float ssdiAmount;
                @XmlElement(name = "VADisabilityService")
                protected byte vaDisabilityService;
                @XmlElement(name = "VADisabilityServiceAmount")
                protected float vaDisabilityServiceAmount;
                @XmlElement(name = "VADisabilityNonService")
                protected byte vaDisabilityNonService;
                @XmlElement(name = "VADisabilityNonServiceAmount")
                protected float vaDisabilityNonServiceAmount;
                @XmlElement(name = "PrivateDisability")
                protected byte privateDisability;
                @XmlElement(name = "PrivateDisabilityAmount")
                protected float privateDisabilityAmount;
                @XmlElement(name = "WorkersComp")
                protected byte workersComp;
                @XmlElement(name = "WorkersCompAmount")
                protected float workersCompAmount;
                @XmlElement(name = "TANF")
                protected byte tanf;
                @XmlElement(name = "TANFAmount")
                protected float tanfAmount;
                @XmlElement(name = "GA")
                protected byte ga;
                @XmlElement(name = "GAAmount")
                protected float gaAmount;
                @XmlElement(name = "SocSecRetirement")
                protected byte socSecRetirement;
                @XmlElement(name = "SocSecRetirementAmount")
                protected float socSecRetirementAmount;
                @XmlElement(name = "Pension")
                protected byte pension;
                @XmlElement(name = "PensionAmount")
                protected float pensionAmount;
                @XmlElement(name = "ChildSupport")
                protected byte childSupport;
                @XmlElement(name = "ChildSupportAmount")
                protected float childSupportAmount;
                @XmlElement(name = "Alimony")
                protected byte alimony;
                @XmlElement(name = "AlimonyAmount")
                protected float alimonyAmount;
                @XmlElement(name = "OtherSource")
                protected byte otherSource;
                @XmlElement(name = "OtherAmount")
                protected float otherAmount;
                @XmlElement(name = "OtherSourceIdentify", required = true)
                protected String otherSourceIdentify;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the incomeAndSourcesID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIncomeAndSourcesID() {
                    return incomeAndSourcesID;
                }

                /**
                 * Sets the value of the incomeAndSourcesID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIncomeAndSourcesID(String value) {
                    this.incomeAndSourcesID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the incomeFromAnySource property.
                 * 
                 */
                public byte getIncomeFromAnySource() {
                    return incomeFromAnySource;
                }

                /**
                 * Sets the value of the incomeFromAnySource property.
                 * 
                 */
                public void setIncomeFromAnySource(byte value) {
                    this.incomeFromAnySource = value;
                }

                /**
                 * Gets the value of the totalMonthlyIncome property.
                 * 
                 */
                public float getTotalMonthlyIncome() {
                    return totalMonthlyIncome;
                }

                /**
                 * Sets the value of the totalMonthlyIncome property.
                 * 
                 */
                public void setTotalMonthlyIncome(float value) {
                    this.totalMonthlyIncome = value;
                }

                /**
                 * Gets the value of the earned property.
                 * 
                 */
                public byte getEarned() {
                    return earned;
                }

                /**
                 * Sets the value of the earned property.
                 * 
                 */
                public void setEarned(byte value) {
                    this.earned = value;
                }

                /**
                 * Gets the value of the earnedAmount property.
                 * 
                 */
                public float getEarnedAmount() {
                    return earnedAmount;
                }

                /**
                 * Sets the value of the earnedAmount property.
                 * 
                 */
                public void setEarnedAmount(float value) {
                    this.earnedAmount = value;
                }

                /**
                 * Gets the value of the unemployment property.
                 * 
                 */
                public byte getUnemployment() {
                    return unemployment;
                }

                /**
                 * Sets the value of the unemployment property.
                 * 
                 */
                public void setUnemployment(byte value) {
                    this.unemployment = value;
                }

                /**
                 * Gets the value of the unemploymentAmount property.
                 * 
                 */
                public float getUnemploymentAmount() {
                    return unemploymentAmount;
                }

                /**
                 * Sets the value of the unemploymentAmount property.
                 * 
                 */
                public void setUnemploymentAmount(float value) {
                    this.unemploymentAmount = value;
                }

                /**
                 * Gets the value of the ssi property.
                 * 
                 */
                public byte getSSI() {
                    return ssi;
                }

                /**
                 * Sets the value of the ssi property.
                 * 
                 */
                public void setSSI(byte value) {
                    this.ssi = value;
                }

                /**
                 * Gets the value of the ssiAmount property.
                 * 
                 */
                public float getSSIAmount() {
                    return ssiAmount;
                }

                /**
                 * Sets the value of the ssiAmount property.
                 * 
                 */
                public void setSSIAmount(float value) {
                    this.ssiAmount = value;
                }

                /**
                 * Gets the value of the ssdi property.
                 * 
                 */
                public byte getSSDI() {
                    return ssdi;
                }

                /**
                 * Sets the value of the ssdi property.
                 * 
                 */
                public void setSSDI(byte value) {
                    this.ssdi = value;
                }

                /**
                 * Gets the value of the ssdiAmount property.
                 * 
                 */
                public float getSSDIAmount() {
                    return ssdiAmount;
                }

                /**
                 * Sets the value of the ssdiAmount property.
                 * 
                 */
                public void setSSDIAmount(float value) {
                    this.ssdiAmount = value;
                }

                /**
                 * Gets the value of the vaDisabilityService property.
                 * 
                 */
                public byte getVADisabilityService() {
                    return vaDisabilityService;
                }

                /**
                 * Sets the value of the vaDisabilityService property.
                 * 
                 */
                public void setVADisabilityService(byte value) {
                    this.vaDisabilityService = value;
                }

                /**
                 * Gets the value of the vaDisabilityServiceAmount property.
                 * 
                 */
                public float getVADisabilityServiceAmount() {
                    return vaDisabilityServiceAmount;
                }

                /**
                 * Sets the value of the vaDisabilityServiceAmount property.
                 * 
                 */
                public void setVADisabilityServiceAmount(float value) {
                    this.vaDisabilityServiceAmount = value;
                }

                /**
                 * Gets the value of the vaDisabilityNonService property.
                 * 
                 */
                public byte getVADisabilityNonService() {
                    return vaDisabilityNonService;
                }

                /**
                 * Sets the value of the vaDisabilityNonService property.
                 * 
                 */
                public void setVADisabilityNonService(byte value) {
                    this.vaDisabilityNonService = value;
                }

                /**
                 * Gets the value of the vaDisabilityNonServiceAmount property.
                 * 
                 */
                public float getVADisabilityNonServiceAmount() {
                    return vaDisabilityNonServiceAmount;
                }

                /**
                 * Sets the value of the vaDisabilityNonServiceAmount property.
                 * 
                 */
                public void setVADisabilityNonServiceAmount(float value) {
                    this.vaDisabilityNonServiceAmount = value;
                }

                /**
                 * Gets the value of the privateDisability property.
                 * 
                 */
                public byte getPrivateDisability() {
                    return privateDisability;
                }

                /**
                 * Sets the value of the privateDisability property.
                 * 
                 */
                public void setPrivateDisability(byte value) {
                    this.privateDisability = value;
                }

                /**
                 * Gets the value of the privateDisabilityAmount property.
                 * 
                 */
                public float getPrivateDisabilityAmount() {
                    return privateDisabilityAmount;
                }

                /**
                 * Sets the value of the privateDisabilityAmount property.
                 * 
                 */
                public void setPrivateDisabilityAmount(float value) {
                    this.privateDisabilityAmount = value;
                }

                /**
                 * Gets the value of the workersComp property.
                 * 
                 */
                public byte getWorkersComp() {
                    return workersComp;
                }

                /**
                 * Sets the value of the workersComp property.
                 * 
                 */
                public void setWorkersComp(byte value) {
                    this.workersComp = value;
                }

                /**
                 * Gets the value of the workersCompAmount property.
                 * 
                 */
                public float getWorkersCompAmount() {
                    return workersCompAmount;
                }

                /**
                 * Sets the value of the workersCompAmount property.
                 * 
                 */
                public void setWorkersCompAmount(float value) {
                    this.workersCompAmount = value;
                }

                /**
                 * Gets the value of the tanf property.
                 * 
                 */
                public byte getTANF() {
                    return tanf;
                }

                /**
                 * Sets the value of the tanf property.
                 * 
                 */
                public void setTANF(byte value) {
                    this.tanf = value;
                }

                /**
                 * Gets the value of the tanfAmount property.
                 * 
                 */
                public float getTANFAmount() {
                    return tanfAmount;
                }

                /**
                 * Sets the value of the tanfAmount property.
                 * 
                 */
                public void setTANFAmount(float value) {
                    this.tanfAmount = value;
                }

                /**
                 * Gets the value of the ga property.
                 * 
                 */
                public byte getGA() {
                    return ga;
                }

                /**
                 * Sets the value of the ga property.
                 * 
                 */
                public void setGA(byte value) {
                    this.ga = value;
                }

                /**
                 * Gets the value of the gaAmount property.
                 * 
                 */
                public float getGAAmount() {
                    return gaAmount;
                }

                /**
                 * Sets the value of the gaAmount property.
                 * 
                 */
                public void setGAAmount(float value) {
                    this.gaAmount = value;
                }

                /**
                 * Gets the value of the socSecRetirement property.
                 * 
                 */
                public byte getSocSecRetirement() {
                    return socSecRetirement;
                }

                /**
                 * Sets the value of the socSecRetirement property.
                 * 
                 */
                public void setSocSecRetirement(byte value) {
                    this.socSecRetirement = value;
                }

                /**
                 * Gets the value of the socSecRetirementAmount property.
                 * 
                 */
                public float getSocSecRetirementAmount() {
                    return socSecRetirementAmount;
                }

                /**
                 * Sets the value of the socSecRetirementAmount property.
                 * 
                 */
                public void setSocSecRetirementAmount(float value) {
                    this.socSecRetirementAmount = value;
                }

                /**
                 * Gets the value of the pension property.
                 * 
                 */
                public byte getPension() {
                    return pension;
                }

                /**
                 * Sets the value of the pension property.
                 * 
                 */
                public void setPension(byte value) {
                    this.pension = value;
                }

                /**
                 * Gets the value of the pensionAmount property.
                 * 
                 */
                public float getPensionAmount() {
                    return pensionAmount;
                }

                /**
                 * Sets the value of the pensionAmount property.
                 * 
                 */
                public void setPensionAmount(float value) {
                    this.pensionAmount = value;
                }

                /**
                 * Gets the value of the childSupport property.
                 * 
                 */
                public byte getChildSupport() {
                    return childSupport;
                }

                /**
                 * Sets the value of the childSupport property.
                 * 
                 */
                public void setChildSupport(byte value) {
                    this.childSupport = value;
                }

                /**
                 * Gets the value of the childSupportAmount property.
                 * 
                 */
                public float getChildSupportAmount() {
                    return childSupportAmount;
                }

                /**
                 * Sets the value of the childSupportAmount property.
                 * 
                 */
                public void setChildSupportAmount(float value) {
                    this.childSupportAmount = value;
                }

                /**
                 * Gets the value of the alimony property.
                 * 
                 */
                public byte getAlimony() {
                    return alimony;
                }

                /**
                 * Sets the value of the alimony property.
                 * 
                 */
                public void setAlimony(byte value) {
                    this.alimony = value;
                }

                /**
                 * Gets the value of the alimonyAmount property.
                 * 
                 */
                public float getAlimonyAmount() {
                    return alimonyAmount;
                }

                /**
                 * Sets the value of the alimonyAmount property.
                 * 
                 */
                public void setAlimonyAmount(float value) {
                    this.alimonyAmount = value;
                }

                /**
                 * Gets the value of the otherSource property.
                 * 
                 */
                public byte getOtherSource() {
                    return otherSource;
                }

                /**
                 * Sets the value of the otherSource property.
                 * 
                 */
                public void setOtherSource(byte value) {
                    this.otherSource = value;
                }

                /**
                 * Gets the value of the otherSourceAmount property.
                 * 
                 */
                public float getOtherAmount() {
                    return otherAmount;
                }

                /**
                 * Sets the value of the otherSourceAmount property.
                 * 
                 */
                public void setOtherAmount(float value) {
                    this.otherAmount = value;
                }

                /**
                 * Gets the value of the otherSourceIdentify property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOtherSourceIdentify() {
                    return otherSourceIdentify;
                }

                /**
                 * Sets the value of the otherSourceIdentify property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOtherSourceIdentify(String value) {
                    this.otherSourceIdentify = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="InventoryID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="CoCCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="HouseholdType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="BedType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Availability" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="UnitInventory" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="BedInventory">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="BedInventory" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *                   &lt;element name="CHBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *                   &lt;element name="VetBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *                   &lt;element name="YouthBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *                   &lt;element name="YouthAgeGroup" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="InventoryStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="InventoryEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="HMISParticipatingBeds" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "inventoryID",
                "coCCode",
                "householdType",
                "bedType",
                "availability",
                "unitInventory",
                "bedInventory",
                /*Added newly starts*/
                "chBedInventory",
                "vetBedInventory",
                "youthBedInventory",
                "youthAgeGroup",
                /*Added newly Ends*/
                "inventoryStartDate",
                "inventoryEndDate",
                "hmisParticipatingBeds"
              
            })
            public static class Inventory {

                @XmlElement(name = "InventoryID", required = true)
                protected String inventoryID;
                @XmlElement(name = "CoCCode", required = true)
                protected String coCCode;
                @XmlElement(name = "HouseholdType")
                protected byte householdType;
                @XmlElement(name = "BedType")
                protected byte bedType;
                @XmlElement(name = "Availability")
                protected byte availability;
                @XmlElement(name = "UnitInventory")
                protected int unitInventory;
                @XmlElement(name = "BedInventory", required = true)
                protected BedInventory bedInventory;
                @XmlElement(name = "InventoryStartDate", required = true)
                protected XMLGregorianCalendar inventoryStartDate;
                @XmlElement(name = "InventoryEndDate", required = true)
                protected XMLGregorianCalendar inventoryEndDate;
                @XmlElement(name = "HMISParticipatingBeds")
                protected int hmisParticipatingBeds;
                @XmlElement(name = "chBedInventory")
                protected int chBedInventory;
                @XmlElement(name = "vetBedInventory")
                protected int vetBedInventory;
                @XmlElement(name = "youthBedInventory")
                protected int youthBedInventory;
                @XmlElement(name = "youthAgeGroup")
                protected int youthAgeGroup;              
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;
                
                

                public int getChBedInventory() {
					return chBedInventory;
				}

				public void setChBedInventory(int value) {
					this.chBedInventory = value;
				}

				public int getVetBedInventory() {
					return vetBedInventory;
				}

				public void setVetBedInventory(int value) {
					this.vetBedInventory = value;
				}

				public int getYouthBedInventory() {
					return youthBedInventory;
				}

				public void setYouthBedInventory(int value) {
					this.youthBedInventory = value;
				}

				public int getYouthAgeGroup() {
					return youthAgeGroup;
				}

				public void setYouthAgeGroup(int value) {
					this.youthAgeGroup = value;
				}

				/**
                 * Gets the value of the inventoryID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getInventoryID() {
                    return inventoryID;
                }

                /**
                 * Sets the value of the inventoryID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setInventoryID(String value) {
                    this.inventoryID = value;
                }

                /**
                 * Gets the value of the coCCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCoCCode() {
                    return coCCode;
                }

                /**
                 * Sets the value of the coCCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCoCCode(String value) {
                    this.coCCode = value;
                }

                /**
                 * Gets the value of the householdType property.
                 * 
                 */
                public byte getHouseholdType() {
                    return householdType;
                }

                /**
                 * Sets the value of the householdType property.
                 * 
                 */
                public void setHouseholdType(byte value) {
                    this.householdType = value;
                }

                /**
                 * Gets the value of the bedType property.
                 * 
                 */
                public byte getBedType() {
                    return bedType;
                }

                /**
                 * Sets the value of the bedType property.
                 * 
                 */
                public void setBedType(byte value) {
                    this.bedType = value;
                }

                /**
                 * Gets the value of the availability property.
                 * 
                 */
                public byte getAvailability() {
                    return availability;
                }

                /**
                 * Sets the value of the availability property.
                 * 
                 */
                public void setAvailability(byte value) {
                    this.availability = value;
                }

                /**
                 * Gets the value of the unitInventory property.
                 * 
                 */
                public int getUnitInventory() {
                    return unitInventory;
                }

                /**
                 * Sets the value of the unitInventory property.
                 * 
                 */
                public void setUnitInventory(int value) {
                    this.unitInventory = value;
                }

                /**
                 * Gets the value of the bedInventory property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BedInventory }
                 *     
                 */
                public BedInventory getBedInventory() {
                    return bedInventory;
                }

                /**
                 * Sets the value of the bedInventory property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BedInventory }
                 *     
                 */
                public void setBedInventory(BedInventory value) {
                    this.bedInventory = value;
                }

                /**
                 * Gets the value of the inventoryStartDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInventoryStartDate() {
                    return inventoryStartDate;
                }

                /**
                 * Sets the value of the inventoryStartDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInventoryStartDate(XMLGregorianCalendar value) {
                    this.inventoryStartDate = value;
                }

                /**
                 * Gets the value of the inventoryEndDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInventoryEndDate() {
                    return inventoryEndDate;
                }

                /**
                 * Sets the value of the inventoryEndDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInventoryEndDate(XMLGregorianCalendar value) {
                    this.inventoryEndDate = value;
                }

                /**
                 * Gets the value of the hmisParticipatingBeds property.
                 * 
                 */
                public int getHMISParticipatingBeds() {
                    return hmisParticipatingBeds;
                }

                /**
                 * Sets the value of the hmisParticipatingBeds property.
                 * 
                 */
                public void setHMISParticipatingBeds(int value) {
                    this.hmisParticipatingBeds = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="BedInventory" type="{http://www.w3.org/2001/XMLSchema}short"/>
                 *         &lt;element name="CHBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
                 *         &lt;element name="VetBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
                 *         &lt;element name="YouthBedInventory" type="{http://www.w3.org/2001/XMLSchema}byte"/>
                 *         &lt;element name="YouthAgeGroup" type="{http://www.w3.org/2001/XMLSchema}byte"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "bedInventory",
                    "chBedInventory",
                    "vetBedInventory",
                    "youthBedInventory",
                    "youthAgeGroup"
                })
                public static class BedInventory {

                    @XmlElement(name = "BedInventory")
                    protected short bedInventory;
                    @XmlElement(name = "CHBedInventory")
                    protected byte chBedInventory;
                    @XmlElement(name = "VetBedInventory")
                    protected byte vetBedInventory;
                    @XmlElement(name = "YouthBedInventory")
                    protected byte youthBedInventory;
                    @XmlElement(name = "YouthAgeGroup")
                    protected byte youthAgeGroup;

                    /**
                     * Gets the value of the bedInventory property.
                     * 
                     */
                    public short getBedInventory() {
                        return bedInventory;
                    }

                    /**
                     * Sets the value of the bedInventory property.
                     * 
                     */
                    public void setBedInventory(short value) {
                        this.bedInventory = value;
                    }

                    /**
                     * Gets the value of the chBedInventory property.
                     * 
                     */
                    public byte getCHBedInventory() {
                        return chBedInventory;
                    }

                    /**
                     * Sets the value of the chBedInventory property.
                     * 
                     */
                    public void setCHBedInventory(byte value) {
                        this.chBedInventory = value;
                    }

                    /**
                     * Gets the value of the vetBedInventory property.
                     * 
                     */
                    public byte getVetBedInventory() {
                        return vetBedInventory;
                    }

                    /**
                     * Sets the value of the vetBedInventory property.
                     * 
                     */
                    public void setVetBedInventory(byte value) {
                        this.vetBedInventory = value;
                    }

                    /**
                     * Gets the value of the youthBedInventory property.
                     * 
                     */
                    public byte getYouthBedInventory() {
                        return youthBedInventory;
                    }

                    /**
                     * Sets the value of the youthBedInventory property.
                     * 
                     */
                    public void setYouthBedInventory(byte value) {
                        this.youthBedInventory = value;
                    }

                    /**
                     * Gets the value of the youthAgeGroup property.
                     * 
                     */
                    public byte getYouthAgeGroup() {
                        return youthAgeGroup;
                    }

                    /**
                     * Sets the value of the youthAgeGroup property.
                     * 
                     */
                    public void setYouthAgeGroup(byte value) {
                        this.youthAgeGroup = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="MedicalAssistanceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="HIVAIDSAssistance" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoHIVAIDSAssistanceReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ADAP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="NoADAPReason" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "medicalAssistanceID",
                "enrollmentID",
                "hivaidsAssistance",
                "noHIVAIDSAssistanceReason",
                "adap",
                "noADAPReason"
            })
            public static class MedicalAssistance {

                @XmlElement(name = "MedicalAssistanceID", required = true)
                protected String medicalAssistanceID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "HIVAIDSAssistance")
                protected byte hivaidsAssistance;
                @XmlElement(name = "NoHIVAIDSAssistanceReason")
                protected byte noHIVAIDSAssistanceReason;
                @XmlElement(name = "ADAP")
                protected byte adap;
                @XmlElement(name = "NoADAPReason")
                protected byte noADAPReason;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the medicalAssistanceID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMedicalAssistanceID() {
                    return medicalAssistanceID;
                }

                /**
                 * Sets the value of the medicalAssistanceID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMedicalAssistanceID(String value) {
                    this.medicalAssistanceID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the hivaidsAssistance property.
                 * 
                 */
                public byte getHIVAIDSAssistance() {
                    return hivaidsAssistance;
                }

                /**
                 * Sets the value of the hivaidsAssistance property.
                 * 
                 */
                public void setHIVAIDSAssistance(byte value) {
                    this.hivaidsAssistance = value;
                }

                /**
                 * Gets the value of the noHIVAIDSAssistanceReason property.
                 * 
                 */
                public byte getNoHIVAIDSAssistanceReason() {
                    return noHIVAIDSAssistanceReason;
                }

                /**
                 * Sets the value of the noHIVAIDSAssistanceReason property.
                 * 
                 */
                public void setNoHIVAIDSAssistanceReason(byte value) {
                    this.noHIVAIDSAssistanceReason = value;
                }

                /**
                 * Gets the value of the adap property.
                 * 
                 */
                public byte getADAP() {
                    return adap;
                }

                /**
                 * Sets the value of the adap property.
                 * 
                 */
                public void setADAP(byte value) {
                    this.adap = value;
                }

                /**
                 * Gets the value of the noADAPReason property.
                 * 
                 */
                public byte getNoADAPReason() {
                    return noADAPReason;
                }

                /**
                 * Sets the value of the noADAPReason property.
                 * 
                 */
                public void setNoADAPReason(byte value) {
                    this.noADAPReason = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="NonCashBenefitsID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="BenefitsFromAnySource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="SNAP" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="WIC" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TANFChildCare" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TANFTransportation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherTANF" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="RentalAssistanceOngoing" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="RentalAssistanceTemp" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherSource" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OtherSourceIdentify" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dataCollectionStage" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="informationDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "nonCashBenefitsID",
                "enrollmentID",
                "benefitsFromAnySource",
                "snap",
                "wic",
                "tanfChildCare",
                "tanfTransportation",
                "otherTANF",
                "rentalAssistanceOngoing",
                "rentalAssistanceTemp",
                "otherSource",
                "otherSourceIdentify"
            })
            public static class NonCashBenefits {

                @XmlElement(name = "NonCashBenefitsID", required = true)
                protected String nonCashBenefitsID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "BenefitsFromAnySource")
                protected byte benefitsFromAnySource;
                @XmlElement(name = "SNAP")
                protected byte snap;
                @XmlElement(name = "WIC")
                protected byte wic;
                @XmlElement(name = "TANFChildCare")
                protected byte tanfChildCare;
                @XmlElement(name = "TANFTransportation")
                protected byte tanfTransportation;
                @XmlElement(name = "OtherTANF")
                protected byte otherTANF;
                @XmlElement(name = "RentalAssistanceOngoing")
                protected byte rentalAssistanceOngoing;
                @XmlElement(name = "RentalAssistanceTemp")
                protected byte rentalAssistanceTemp;
                @XmlElement(name = "OtherSource")
                protected byte otherSource;
                @XmlElement(name = "OtherSourceIdentify", required = true)
                protected String otherSourceIdentify;
                @XmlAttribute
                protected Byte dataCollectionStage;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected XMLGregorianCalendar informationDate;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the nonCashBenefitsID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNonCashBenefitsID() {
                    return nonCashBenefitsID;
                }

                /**
                 * Sets the value of the nonCashBenefitsID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNonCashBenefitsID(String value) {
                    this.nonCashBenefitsID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the benefitsFromAnySource property.
                 * 
                 */
                public byte getBenefitsFromAnySource() {
                    return benefitsFromAnySource;
                }

                /**
                 * Sets the value of the benefitsFromAnySource property.
                 * 
                 */
                public void setBenefitsFromAnySource(byte value) {
                    this.benefitsFromAnySource = value;
                }

                /**
                 * Gets the value of the snap property.
                 * 
                 */
                public byte getSNAP() {
                    return snap;
                }

                /**
                 * Sets the value of the snap property.
                 * 
                 */
                public void setSNAP(byte value) {
                    this.snap = value;
                }

                /**
                 * Gets the value of the wic property.
                 * 
                 */
                public byte getWIC() {
                    return wic;
                }

                /**
                 * Sets the value of the wic property.
                 * 
                 */
                public void setWIC(byte value) {
                    this.wic = value;
                }

                /**
                 * Gets the value of the tanfChildCare property.
                 * 
                 */
                public byte getTANFChildCare() {
                    return tanfChildCare;
                }

                /**
                 * Sets the value of the tanfChildCare property.
                 * 
                 */
                public void setTANFChildCare(byte value) {
                    this.tanfChildCare = value;
                }

                /**
                 * Gets the value of the tanfTransportation property.
                 * 
                 */
                public byte getTANFTransportation() {
                    return tanfTransportation;
                }

                /**
                 * Sets the value of the tanfTransportation property.
                 * 
                 */
                public void setTANFTransportation(byte value) {
                    this.tanfTransportation = value;
                }

                /**
                 * Gets the value of the otherTANF property.
                 * 
                 */
                public byte getOtherTANF() {
                    return otherTANF;
                }

                /**
                 * Sets the value of the otherTANF property.
                 * 
                 */
                public void setOtherTANF(byte value) {
                    this.otherTANF = value;
                }

                /**
                 * Gets the value of the rentalAssistanceOngoing property.
                 * 
                 */
                public byte getRentalAssistanceOngoing() {
                    return rentalAssistanceOngoing;
                }

                /**
                 * Sets the value of the rentalAssistanceOngoing property.
                 * 
                 */
                public void setRentalAssistanceOngoing(byte value) {
                    this.rentalAssistanceOngoing = value;
                }

                /**
                 * Gets the value of the rentalAssistanceTemp property.
                 * 
                 */
                public byte getRentalAssistanceTemp() {
                    return rentalAssistanceTemp;
                }

                /**
                 * Sets the value of the rentalAssistanceTemp property.
                 * 
                 */
                public void setRentalAssistanceTemp(byte value) {
                    this.rentalAssistanceTemp = value;
                }

                /**
                 * Gets the value of the otherSource property.
                 * 
                 */
                public byte getOtherSource() {
                    return otherSource;
                }

                /**
                 * Sets the value of the otherSource property.
                 * 
                 */
                public void setOtherSource(byte value) {
                    this.otherSource = value;
                }

                /**
                 * Gets the value of the otherSourceIdentify property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOtherSourceIdentify() {
                    return otherSourceIdentify;
                }

                /**
                 * Sets the value of the otherSourceIdentify property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOtherSourceIdentify(String value) {
                    this.otherSourceIdentify = value;
                }

                /**
                 * Gets the value of the dataCollectionStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getDataCollectionStage() {
                    return dataCollectionStage;
                }

                /**
                 * Sets the value of the dataCollectionStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setDataCollectionStage(Byte value) {
                    this.dataCollectionStage = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the informationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getInformationDate() {
                    return informationDate;
                }

                /**
                 * Sets the value of the informationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setInformationDate(XMLGregorianCalendar value) {
                    this.informationDate = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="OrganizationID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="OrganizationCommonName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "organizationID",
                "organizationName",
//                "organizationCommonName"
            })
            public static class Organization {

                @XmlElement(name = "OrganizationID")
                protected String organizationID;
                @XmlElement(name = "OrganizationName", required = true)
                protected String organizationName;
                /*@XmlElement(name = "OrganizationCommonName", required = true)
                protected String organizationCommonName;*/
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the organizationID property.
                 * 
                 */
                public String getOrganizationID() {
                    return organizationID;
                }

                /**
                 * Sets the value of the organizationID property.
                 * 
                 */
                public void setOrganizationID(String value) {
                    this.organizationID = value;
                }

                /**
                 * Gets the value of the organizationName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOrganizationName() {
                    return organizationName;
                }

                /**
                 * Sets the value of the organizationName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOrganizationName(String value) {
                    this.organizationName = value;
                }

                /**
                 * Gets the value of the organizationCommonName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
               /* public String getOrganizationCommonName() {
                    return organizationCommonName;
                }*/

                /**
                 * Sets the value of the organizationCommonName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                /*public void setOrganizationCommonName(String value) {
                    this.organizationCommonName = value;
                }*/

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="PathStatusID" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="DateOfStatus" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="ClientEnrolledInPATH" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ReasonNotEnrolled" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "pathStatusID",
                "enrollmentID",
                "dateOfStatus",
                "clientEnrolledInPATH",
                "reasonNotEnrolled"
            })
            public static class PATHStatus {

                @XmlElement(name = "PathStatusID")
                protected String pathStatusID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "DateOfStatus", required = true)
                protected XMLGregorianCalendar dateOfStatus;
                @XmlElement(name = "ClientEnrolledInPATH")
                protected byte clientEnrolledInPATH;
                @XmlElement(name = "ReasonNotEnrolled")
                protected byte reasonNotEnrolled;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the pathStatusID property.
                 * 
                 */
                public String getPathStatusID() {
                    return pathStatusID;
                }

                /**
                 * Sets the value of the pathStatusID property.
                 * 
                 */
                public void setPathStatusID(String value) {
                    this.pathStatusID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the dateOfStatus property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateOfStatus() {
                    return dateOfStatus;
                }

                /**
                 * Sets the value of the dateOfStatus property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateOfStatus(XMLGregorianCalendar value) {
                    this.dateOfStatus = value;
                }

                /**
                 * Gets the value of the clientEnrolledInPATH property.
                 * 
                 */
                public byte getClientEnrolledInPATH() {
                    return clientEnrolledInPATH;
                }

                /**
                 * Sets the value of the clientEnrolledInPATH property.
                 * 
                 */
                public void setClientEnrolledInPATH(byte value) {
                    this.clientEnrolledInPATH = value;
                }

                /**
                 * Gets the value of the reasonNotEnrolled property.
                 * 
                 */
                public byte getReasonNotEnrolled() {
                    return reasonNotEnrolled;
                }

                /**
                 * Sets the value of the reasonNotEnrolled property.
                 * 
                 */
                public void setReasonNotEnrolled(byte value) {
                    this.reasonNotEnrolled = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ProjectID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="OrganizationID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ProjectName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ContinuumProject" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ProjectType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ResidentialAffiliation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TrackingMethod" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="TargetPopulation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ProjectCommonName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "projectID",
                "organizationID",
                "projectName",
                "continuumProject",
                "projectType",
                "residentialAffiliation",
                "trackingMethod",
                "targetPopulation",
                "operatingStartDate", 
                "operatingEndDate", 
                "victimServicesProvider", 
                "housingType",
                "projectCommonName"
            })
            public static class Project {

                @XmlElement(name = "ProjectID", required = true)
                protected String projectID;
                @XmlElement(name = "OrganizationID")
                protected String organizationID;
                @XmlElement(name = "ProjectName", required = true)
                protected String projectName;
                @XmlElement(name = "ContinuumProject")
                protected String continuumProject;
                @XmlElement(name = "ProjectType")
                protected String projectType;
                @XmlElement(name = "ResidentialAffiliation")
                protected String residentialAffiliation;
                @XmlElement(name = "TrackingMethod")
                protected byte trackingMethod;
                @XmlElement(name = "TargetPopulation")
                protected byte targetPopulation;
                @XmlElement(name = "OperatingStartDate")
                protected XMLGregorianCalendar operatingStartDate;
                @XmlElement(name = "OperatingEndDate")
                protected XMLGregorianCalendar operatingEndDate;
                @XmlElement(name = "VictimServicesProvider")
                protected String victimServicesProvider;
                @XmlElement(name = "HousingType")
                protected String housingType;
                @XmlElement(name = "ProjectCommonName", required = true)
                protected String projectCommonName;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the projectID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectID() {
                    return projectID;
                }

                /**
                 * Sets the value of the projectID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectID(String value) {
                    this.projectID = value;
                }

                /**
                 * Gets the value of the organizationID property.
                 * 
                 */
                public String getOrganizationID() {
                    return organizationID;
                }

                /**
                 * Sets the value of the organizationID property.
                 * 
                 */
                public void setOrganizationID(String value) {
                    this.organizationID = value;
                }

                /**
                 * Gets the value of the projectName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectName() {
                    return projectName;
                }

                /**
                 * Sets the value of the projectName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectName(String value) {
                    this.projectName = value;
                }

                /**
                 * Gets the value of the continuumProject property.
                 * 
                 */
                public String getContinuumProject() {
                    return continuumProject;
                }

                /**
                 * Sets the value of the continuumProject property.
                 * 
                 */
                public void setContinuumProject(String value) {
                    this.continuumProject = value;
                }

                /**
                 * Gets the value of the projectType property.
                 * 
                 */
                public String getProjectType() {
                    return projectType;
                }

                /**
                 * Sets the value of the projectType property.
                 * 
                 */
                public void setProjectType(String value) {
                    this.projectType = value;
                }

                /**
                 * Gets the value of the residentialAffiliation property.
                 * 
                 */
                public String getResidentialAffiliation() {
                    return residentialAffiliation;
                }

                /**
                 * Sets the value of the residentialAffiliation property.
                 * 
                 */
                public void setResidentialAffiliation(String value) {
                    this.residentialAffiliation = value;
                }

                /**
                 * Gets the value of the trackingMethod property.
                 * 
                 */
                public byte getTrackingMethod() {
                    return trackingMethod;
                }

                /**
                 * Sets the value of the trackingMethod property.
                 * 
                 */
                public void setTrackingMethod(byte value) {
                    this.trackingMethod = value;
                }

                /**
                 * Gets the value of the targetPopulation property.
                 * 
                 */
                public byte getTargetPopulation() {
                    return targetPopulation;
                }

                /**
                 * Sets the value of the targetPopulation property.
                 * 
                 */
                public void setTargetPopulation(byte value) {
                    this.targetPopulation = value;
                }

                
                public XMLGregorianCalendar getOperatingStartDate() {
					return operatingStartDate;
				}

				public void setOperatingStartDate(XMLGregorianCalendar operatingStartDate) {
					this.operatingStartDate = operatingStartDate;
				}

				public XMLGregorianCalendar getOperatingEndDate() {
					return operatingEndDate;
				}

				public void setOperatingEndDate(XMLGregorianCalendar operatingEndDate) {
					this.operatingEndDate = operatingEndDate;
				}

				public String getVictimServicesProvider() {
					return victimServicesProvider;
				}

				public void setVictimServicesProvider(String victimServicesProvider) {
					this.victimServicesProvider = victimServicesProvider;
				}

				public String getHousingType() {
					return housingType;
				}

				public void setHousingType(String housingType) {
					this.housingType = housingType;
				}

				/**
                 * Gets the value of the projectCommonName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProjectCommonName() {
                    return projectCommonName;
                }

                /**
                 * Sets the value of the projectCommonName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProjectCommonName(String value) {
                    this.projectCommonName = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="RHYBCPStatusID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="StatusDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="FYSBYouth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="ReasonNoServices" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "rhybcpStatusID",
                "enrollmentID",
                "statusDate",
                "eligibleForRHY",
                "runawayYouth",
                "reasonNoServices"
            })
            public static class RHYBCPStatus {

                @XmlElement(name = "RHYBCPStatusID", required = true)
                protected String rhybcpStatusID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "StatusDate", required = true)
                protected XMLGregorianCalendar statusDate;
                @XmlElement(name = "EligibleForRHY")
                protected String eligibleForRHY;
                @XmlElement(name = "RunawayYouth")
                protected String runawayYouth;
                @XmlElement(name = "ReasonNoServices")
                protected byte reasonNoServices;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the rhybcpStatusID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRHYBCPStatusID() {
                    return rhybcpStatusID;
                }

                /**
                 * Sets the value of the rhybcpStatusID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRHYBCPStatusID(String value) {
                    this.rhybcpStatusID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the statusDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStatusDate() {
                    return statusDate;
                }

                /**
                 * Sets the value of the statusDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStatusDate(XMLGregorianCalendar value) {
                    this.statusDate = value;
                }

                /**
                 * Gets the value of the reasonNoServices property.
                 * 
                 */
                public byte getReasonNoServices() {
                    return reasonNoServices;
                }

                /**
                 * Sets the value of the reasonNoServices property.
                 * 
                 */
                public void setReasonNoServices(byte value) {
                    this.reasonNoServices = value;
                }
                
				public String getEligibleForRHY() {
					return eligibleForRHY;
				}

				public void setEligibleForRHY(String eligibleForRHY) {
					this.eligibleForRHY = eligibleForRHY;
				}

				public String getRunawayYouth() {
					return runawayYouth;
				}

				public void setRunawayYouth(String runawayYouth) {
					this.runawayYouth = runawayYouth;
				}

				/**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="MoveInDateID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="InPermanentHousing" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="MoveInDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "moveInDateID",
                "enrollmentID",
                "inPermanentHousing",
                "moveInDate"
            })
            public static class Moveindate {

                @XmlElement(name = "MoveInDateID", required = true)
                protected String moveInDateID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "MoveInDate", required = true)
                protected XMLGregorianCalendar moveInDate;
                @XmlElement(name = "inpermanenthousing", required = true)
                protected byte inPermanentHousing;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the moveInDateID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMoveInDateID() {
                    return moveInDateID;
                }

                /**
                 * Sets the value of the moveInDateID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMoveInDateID(String value) {
                    this.moveInDateID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the inPermanentHousing property.
                 * 
                 */
                public byte getInPermanentHousing() {
                    return inPermanentHousing;
                }

                /**
                 * Sets the value of the inPermanentHousing property.
                 * 
                 */
                public void setInPermanentHousing(byte value) {
                    this.inPermanentHousing = value;
                }

                /**
                 * Gets the value of the moveInDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getMoveInDate() {
                    return moveInDate;
                }

                /**
                 * Sets the value of the roveInDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setMoveInDate(XMLGregorianCalendar value) {
                    this.moveInDate = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ServicesID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="DateProvided" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="RecordType" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="TypeProvided" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="OtherTypeProvided" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="SubTypeProvided" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="FAAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="ReferralOutcome" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "servicesID",
                "enrollmentID",
                "dateProvided",
                "recordType",
                "typeProvided",
                "otherTypeProvided",
                "subTypeProvided",
                "faAmount",
                "referralOutcome"
            })
            public static class Services {

                @XmlElement(name = "ServicesID", required = true)
                protected String servicesID;
                @XmlElement(name = "EnrollmentID", required = true)
                protected String enrollmentID;
                @XmlElement(name = "DateProvided", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateProvided;
                @XmlElement(name = "RecordType")
                protected String recordType;
                @XmlElement(name = "TypeProvided")
                protected short typeProvided;
                @XmlElement(name = "OtherTypeProvided", required = true)
                protected String otherTypeProvided;
                @XmlElement(name = "SubTypeProvided")
                protected byte subTypeProvided;
                @XmlElement(name = "FAAmount")
                protected float faAmount;
                @XmlElement(name = "ReferralOutcome")
                protected byte referralOutcome;
                @XmlAttribute(name = "dateCreated")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute(name = "dateUpdated")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute(name = "userID")
                protected String userID;

                /**
                 * Gets the value of the servicesID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getServicesID() {
                    return servicesID;
                }

                /**
                 * Sets the value of the servicesID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setServicesID(String value) {
                    this.servicesID = value;
                }

                /**
                 * Gets the value of the enrollmentID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnrollmentID() {
                    return enrollmentID;
                }

                /**
                 * Sets the value of the enrollmentID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnrollmentID(String value) {
                    this.enrollmentID = value;
                }

                /**
                 * Gets the value of the dateProvided property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateProvided() {
                    return dateProvided;
                }

                /**
                 * Sets the value of the dateProvided property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateProvided(XMLGregorianCalendar value) {
                    this.dateProvided = value;
                }

                /**
                 * Gets the value of the recordType property.
                 * 
                 */
                public String getRecordType() {
                    return recordType;
                }

                /**
                 * Sets the value of the recordType property.
                 * 
                 */
                public void setRecordType(String value) {
                    this.recordType = value;
                }

                /**
                 * Gets the value of the typeProvided property.
                 * 
                 */
                public short getTypeProvided() {
                    return typeProvided;
                }

                /**
                 * Sets the value of the typeProvided property.
                 * 
                 */
                public void setTypeProvided(short value) {
                    this.typeProvided = value;
                }

                /**
                 * Gets the value of the otherTypeProvided property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOtherTypeProvided() {
                    return otherTypeProvided;
                }

                /**
                 * Sets the value of the otherTypeProvided property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOtherTypeProvided(String value) {
                    this.otherTypeProvided = value;
                }

                /**
                 * Gets the value of the subTypeProvided property.
                 * 
                 */
                public byte getSubTypeProvided() {
                    return subTypeProvided;
                }

                /**
                 * Sets the value of the subTypeProvided property.
                 * 
                 */
                public void setSubTypeProvided(byte value) {
                    this.subTypeProvided = value;
                }

                /**
                 * Gets the value of the faAmount property.
                 * 
                 */
                public float getFAAmount() {
                    return faAmount;
                }

                /**
                 * Sets the value of the faAmount property.
                 * 
                 */
                public void setFAAmount(float value) {
                    this.faAmount = value;
                }

                /**
                 * Gets the value of the referralOutcome property.
                 * 
                 */
                public byte getReferralOutcome() {
                    return referralOutcome;
                }

                /**
                 * Sets the value of the referralOutcome property.
                 * 
                 */
                public void setReferralOutcome(byte value) {
                    this.referralOutcome = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }



            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="CoCCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PrincipalSite" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ZIP" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="Geocode" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "siteID",
                "coCCode",
                "principalSite",
                "address",
                "city",
                "state",
                "zip",
                "geocode"
            })
            public static class Site {

                @XmlElement(name = "SiteID")
                protected String siteID;
                @XmlElement(name = "CoCCode", required = true)
                protected String coCCode;
                @XmlElement(name = "PrincipalSite")
                protected byte principalSite;
                @XmlElement(name = "Address", required = true)
                protected String address;
                @XmlElement(name = "City", required = true)
                protected String city;
                @XmlElement(name = "State", required = true)
                protected String state;
                @XmlElement(name = "ZIP")
                protected int zip;
                @XmlElement(name = "Geocode")
                protected int geocode;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;

                /**
                 * Gets the value of the siteID property.
                 * 
                 */
                public String getSiteID() {
                    return siteID;
                }

                /**
                 * Sets the value of the siteID property.
                 * 
                 */
                public void setSiteID(String value) {
                    this.siteID = value;
                }

                /**
                 * Gets the value of the coCCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCoCCode() {
                    return coCCode;
                }

                /**
                 * Sets the value of the coCCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCoCCode(String value) {
                    this.coCCode = value;
                }

                /**
                 * Gets the value of the principalSite property.
                 * 
                 */
                public byte getPrincipalSite() {
                    return principalSite;
                }

                /**
                 * Sets the value of the principalSite property.
                 * 
                 */
                public void setPrincipalSite(byte value) {
                    this.principalSite = value;
                }

                /**
                 * Gets the value of the address property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAddress() {
                    return address;
                }

                /**
                 * Sets the value of the address property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAddress(String value) {
                    this.address = value;
                }

                /**
                 * Gets the value of the city property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCity() {
                    return city;
                }

                /**
                 * Sets the value of the city property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCity(String value) {
                    this.city = value;
                }

                /**
                 * Gets the value of the state property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getState() {
                    return state;
                }

                /**
                 * Sets the value of the state property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setState(String value) {
                    this.state = value;
                }

                /**
                 * Gets the value of the zip property.
                 * 
                 */
                public int getZIP() {
                    return zip;
                }

                /**
                 * Sets the value of the zip property.
                 * 
                 */
                public void setZIP(int value) {
                    this.zip = value;
                }

                /**
                 * Gets the value of the geocode property.
                 * 
                 */
                public int getGeocode() {
                    return geocode;
                }

                /**
                 * Sets the value of the geocode property.
                 * 
                 */
                public void setGeocode(int value) {
                    this.geocode = value;
                }

                /**
                 * Gets the value of the dateCreated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateCreated() {
                    return dateCreated;
                }

                /**
                 * Sets the value of the dateCreated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateCreated(XMLGregorianCalendar value) {
                    this.dateCreated = value;
                }

                /**
                 * Gets the value of the dateUpdated property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateUpdated() {
                    return dateUpdated;
                }

                /**
                 * Sets the value of the dateUpdated property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateUpdated(XMLGregorianCalendar value) {
                    this.dateUpdated = value;
                }

                /**
                 * Gets the value of the userID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserID() {
                    return userID;
                }

                /**
                 * Sets the value of the userID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserID(String value) {
                    this.userID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="WorstHousingSituationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="enrollmentID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="WorstHousingSituation" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *       &lt;/sequence>
             *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="dateUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="userID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "geographyID",
                "projectID",
                "coCCode",
                "geoCode",
                "geographyType",
                "address1",
                "address2",
                "city",
                "state",
<<<<<<< Updated upstream
            	"zip",
            	"dateCreated",
        		"dateUpdated",
        		"informationDate"
=======
            	"zip"
>>>>>>> Stashed changes
            })
            public static class Geography {

                @XmlElement(name = "GeographyID", required = true)
                protected String geographyID;
                @XmlElement(name = "ProjectID")
                protected String projectID;
                @XmlElement(name = "CoCCode")
                protected String coCCode;
                @XmlElement(name = "GeoCode")
                protected String geoCode;
                @XmlElement(name = "GeographyType")
                protected String geographyType;
                @XmlElement(name = "Address1")
                protected String address1;
                @XmlElement(name = "Address2")
                protected String address2;
                @XmlElement(name = "City")
                protected String city;
                @XmlElement(name = "State")
                protected String state;
                @XmlElement(name = "Zip")
                protected String zip;
                @XmlAttribute
                protected XMLGregorianCalendar dateCreated;
                @XmlAttribute
                protected XMLGregorianCalendar dateUpdated;
                @XmlAttribute
                protected String userID;
                @XmlAttribute
	            protected XMLGregorianCalendar informationDate;
                
				public String getGeographyID() {
					return geographyID;
				}
				public void setGeographyID(String geographyID) {
					this.geographyID = geographyID;
				}
				public String getProjectID() {
					return projectID;
				}
				public void setProjectID(String projectID) {
					this.projectID = projectID;
				}
				public String getCoCCode() {
					return coCCode;
				}
				public void setCoCCode(String coCCode) {
					this.coCCode = coCCode;
				}
				public String getGeoCode() {
					return geoCode;
				}
				public void setGeoCode(String geoCode) {
					this.geoCode = geoCode;
				}
				public String getGeographyType() {
					return geographyType;
				}
				public void setGeographyType(String geographyType) {
					this.geographyType = geographyType;
				}
				public String getAddress1() {
					return address1;
				}
				public void setAddress1(String address1) {
					this.address1 = address1;
				}
				
				public String getAddress2() {
					return address2;
				}
				public void setAddress2(String address2) {
					this.address2 = address2;
				}
				public String getCity() {
					return city;
				}
				public void setCity(String city) {
					this.city = city;
				}
				public String getState() {
					return state;
				}
				public void setState(String state) {
					this.state = state;
				}
				public String getZip() {
					return zip;
				}
				public void setZip(String zip) {
					this.zip = zip;
				}
				public XMLGregorianCalendar getDateCreated() {
					return dateCreated;
				}
				public void setDateCreated(XMLGregorianCalendar dateCreated) {
					this.dateCreated = dateCreated;
				}
				public XMLGregorianCalendar getDateUpdated() {
					return dateUpdated;
				}
				public void setDateUpdated(XMLGregorianCalendar dateUpdated) {
					this.dateUpdated = dateUpdated;
				}
				public XMLGregorianCalendar getInformationDate() {
					return informationDate;
				}
				public void setInformationDate(XMLGregorianCalendar informationDate) {
					this.informationDate = informationDate;
				}
				public String getUserID() {
					return userID;
				}
				public void setUserID(String userID) {
					this.userID = userID;
				}
				
            }
            
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
            		"vashExitReasonID",
            		"exitID",
            		"cmExitReason",
            		"dateCreated",
            		"dateUpdated"
            })

            public static class VASHExitReason {
	            @XmlElement(name = "VashExitReasonID", required = true)
	            protected String vashExitReasonID;
	            @XmlElement(name = "ExitID")
	            protected String exitID;
	            @XmlElement(name = "CMExitReason")
	            protected String cmExitReason;
	            @XmlElement(name = "dateCreated")
	            protected XMLGregorianCalendar dateCreated;
	            @XmlElement(name = "dateUpdated")
	            protected XMLGregorianCalendar dateUpdated;
				public String getVashExitReasonID() {
					return vashExitReasonID;
				}
				public void setVashExitReasonID(String vashExitReasonID) {
					this.vashExitReasonID = vashExitReasonID;
				}
				public String getExitID() {
					return exitID;
				}
				public void setExitID(String exitID) {
					this.exitID = exitID;
				}
				public String getCmExitReason() {
					return cmExitReason;
				}
				public void setCmExitReason(String cmExitReason) {
					this.cmExitReason = cmExitReason;
				}
				public XMLGregorianCalendar getDateCreated() {
					return dateCreated;
				}
				public void setDateCreated(XMLGregorianCalendar dateCreated) {
					this.dateCreated = dateCreated;
				}
				public XMLGregorianCalendar getDateUpdated() {
					return dateUpdated;
				}
				public void setDateUpdated(XMLGregorianCalendar dateUpdated) {
					this.dateUpdated = dateUpdated;
				}
	         }
            
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
            		"rhyAfterCareID", 
            		"exitID",
            		"afterCareDate",
            		"afterCareProvided",
            		"emailSocialMedia",
            		"telephone",
            		"inPersonIndividual",
            		"inPersonGroup",
            		"dateCreated",
            		"dateUpdated"
            })

            public static class RHYAfterCare {
	            @XmlElement(name = "RhyAfterCareID", required = true)
	            protected String rhyAfterCareID;
	            @XmlElement(name = "ExitID")
	            protected String exitID;
	            @XmlElement(name = "AfterCareDate")
	            protected XMLGregorianCalendar afterCareDate;
	            @XmlElement(name = "AfterCareProvided")
	            protected String afterCareProvided;
	            @XmlElement(name = "EmailSocialMedia")
	            protected String emailSocialMedia;
	            @XmlElement(name = "Telephone")
	            protected String telephone;
	            @XmlElement(name = "InPersonIndividual")
	            protected String inPersonIndividual;
	            @XmlElement(name = "InPersonGroup")
	            protected String inPersonGroup;
	            @XmlElement(name = "dateCreated")
	            protected XMLGregorianCalendar dateCreated;
	            @XmlElement(name = "dateUpdated")
	            protected XMLGregorianCalendar dateUpdated;
	            
				public String getRhyAfterCareID() {
					return rhyAfterCareID;
				}
				public void setRhyAfterCareID(String rhyAfterCareID) {
					this.rhyAfterCareID = rhyAfterCareID;
				}
				public String getExitID() {
					return exitID;
				}
				public void setExitID(String exitID) {
					this.exitID = exitID;
				}
				public String getAfterCareProvided() {
					return afterCareProvided;
				}
				public void setAfterCareProvided(String afterCareProvided) {
					this.afterCareProvided = afterCareProvided;
				}
				public XMLGregorianCalendar getAfterCareDate() {
					return afterCareDate;
				}
				public void setAfterCareDate(XMLGregorianCalendar afterCareDate) {
					this.afterCareDate = afterCareDate;
				}
				public String getEmailSocialMedia() {
					return emailSocialMedia;
				}
				public void setEmailSocialMedia(String emailSocialMedia) {
					this.emailSocialMedia = emailSocialMedia;
				}
				public String getTelephone() {
					return telephone;
				}
				public void setTelephone(String telephone) {
					this.telephone = telephone;
				}
				public String getInPersonIndividual() {
					return inPersonIndividual;
				}
				public void setInPersonIndividual(String inPersonIndividual) {
					this.inPersonIndividual = inPersonIndividual;
				}
				public String getInPersonGroup() {
					return inPersonGroup;
				}
				public void setInPersonGroup(String inPersonGroup) {
					this.inPersonGroup = inPersonGroup;
				}
				public XMLGregorianCalendar getDateCreated() {
					return dateCreated;
				}
				public void setDateCreated(XMLGregorianCalendar dateCreated) {
					this.dateCreated = dateCreated;
				}
				public XMLGregorianCalendar getDateUpdated() {
					return dateUpdated;
				}
				public void setDateUpdated(XMLGregorianCalendar dateUpdated) {
					this.dateUpdated = dateUpdated;
				}
				
	         }

            }


        }

    }