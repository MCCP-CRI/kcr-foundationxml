/*
 * Copyright 2020 University of Kentucky
 * University of Kentucky Markey Cancer Control Program
 * Markey Cancer Research Informatics Shared Resource Facility
 *
 * Permission is hereby granted, free of charge, to use a copy of this software
 * and associated documentation files (the “Software”) for any non-profit or
 * educational use, including without limitation the right to use, copy, modify,
 * merge, publish, and distribute copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * For any for-profit or other commercial use, potential users should contact:
 * University of Kentucky Markey Cancer Control Program
 * ATTN: Associate Director of Cancer Informatics
 * 2365 Harrodsburg Road, Suite A230
 * Lexington, KY 40504-3381
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package edu.uky.kcr.foundation.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("variant-report")
public class VariantReport
{
	@XStreamAsAttribute
	@XStreamAlias("xsi:schemaLocation")
	private String schemaLocation = null;
	
	@XStreamAlias("samples")
	private VariantReportSamples samples = null;
	
	@XStreamAlias("short-variants")
	private ShortVariants shortVariants = null;
	
	@XStreamAlias("copy-number-alterations")
	private CopyNumberAlterations copyNumberAlterations = null;
	
	@XStreamAlias("rearrangements")
	private Rearrangements rearrangements = null;
	
	@XStreamAlias("biomarkers")
	private Biomarkers biomarkers = null;
	
	@XStreamAlias("non-human-content")
	private NonHumanContent nonHumanContent = null;
	
	@XStreamAsAttribute
	@XStreamAlias("disease")
	private String disease = null;
	
	@XStreamAsAttribute
	@XStreamAlias("disease-ontology")
	private String diseaseOntology = null;
	
	@XStreamAsAttribute
	@XStreamAlias("flowcell-analysis")
	private Integer flowcellAnalysis = null;
	
	@XStreamAsAttribute
	@XStreamAlias("gender")
	private String gender = null;
	
	@XStreamAsAttribute
	@XStreamAlias("pathology-diagnosis")
	private String pathologyDiagnosis = null;
	
	@XStreamAsAttribute
	@XStreamAlias("percent-tumor-nuclei")
	private Integer percentTumorNuclei = null;
	
	@XStreamAsAttribute
	@XStreamAlias("pipeline-version")
	private String pipelineVersion = null;
	
	@XStreamAsAttribute
	@XStreamAlias("purity-assessment")
	private Float purityAssessment = null;
	
	@XStreamAsAttribute
	@XStreamAlias("specimen")
	private String specimen = null;
	
	@XStreamAsAttribute
	@XStreamAlias("standard-nucleic-acid-types")
	private String standardNucleicAcidTypes = null;
	
	@XStreamAsAttribute
	@XStreamAlias("study")
	private String study = null;
	
	@XStreamAsAttribute
	@XStreamAlias("test-request")
	private String testRequest = null;
	
	@XStreamAsAttribute
	@XStreamAlias("test-type")
	private String testType = null;
	
	@XStreamAsAttribute
	@XStreamAlias("tissue-of-origin")
	private String tissueOfOrigin = null;

	public CopyNumberAlterations getCopyNumberAlterations()
	{
		if (this.copyNumberAlterations == null)
		{
			this.copyNumberAlterations = new CopyNumberAlterations();
		}
		
		return copyNumberAlterations;
	}

	public void setCopyNumberAlterations(CopyNumberAlterations copyNumberAlterations)
	{
		this.copyNumberAlterations = copyNumberAlterations;
	}

	public ShortVariants getShortVariants()
	{
		if (this.shortVariants == null)
		{
			this.shortVariants = new ShortVariants();
		}
		
		return shortVariants;
	}

	public void setShortVariants(ShortVariants shortVariants)
	{
		this.shortVariants = shortVariants;
	}

	public VariantReportSamples getSamples()
	{
		if (this.samples == null)
		{
			this.samples = new VariantReportSamples();
		}
		
		return samples;
	}

	public void setSamples(VariantReportSamples samples)
	{
		this.samples = samples;
	}

	public Rearrangements getRearrangements()
	{
		if (this.rearrangements == null)
		{
			this.rearrangements = new Rearrangements();
		}
		
		return rearrangements;
	}

	public void setRearrangements(Rearrangements rearrangements)
	{
		this.rearrangements = rearrangements;
	}

	public Biomarkers getBiomarkers()
	{
		if (this.biomarkers == null)
		{
			this.biomarkers = new Biomarkers();
		}
		
		return biomarkers;
	}

	public void setBiomarkers(Biomarkers biomarkers)
	{
		this.biomarkers = biomarkers;
	}

	public NonHumanContent getNonHumanContent()
	{
		if (this.nonHumanContent == null)
		{
			this.nonHumanContent = new NonHumanContent();
		}
		
		return nonHumanContent;
	}

	public void setNonHumanContent(NonHumanContent nonHumanContent)
	{
		this.nonHumanContent = nonHumanContent;
	}

	public String getSchemaLocation()
	{
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation)
	{
		this.schemaLocation = schemaLocation;
	}

	public String getDisease()
	{
		return disease;
	}

	public void setDisease(String disease)
	{
		this.disease = disease;
	}

	public String getDiseaseOntology()
	{
		return diseaseOntology;
	}

	public void setDiseaseOntology(String diseaseOntology)
	{
		this.diseaseOntology = diseaseOntology;
	}

	public Integer getFlowcellAnalysis()
	{
		return flowcellAnalysis;
	}

	public void setFlowcellAnalysis(Integer flowcellAnalysis)
	{
		this.flowcellAnalysis = flowcellAnalysis;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getPathologyDiagnosis()
	{
		return pathologyDiagnosis;
	}

	public void setPathologyDiagnosis(String pathologyDiagnosis)
	{
		this.pathologyDiagnosis = pathologyDiagnosis;
	}

	public Integer getPercentTumorNuclei()
	{
		return percentTumorNuclei;
	}

	public void setPercentTumorNuclei(Integer percentTumorNuclei)
	{
		this.percentTumorNuclei = percentTumorNuclei;
	}

	public String getPipelineVersion()
	{
		return pipelineVersion;
	}

	public void setPipelineVersion(String pipelineVersion)
	{
		this.pipelineVersion = pipelineVersion;
	}

	public Float getPurityAssessment()
	{
		return purityAssessment;
	}

	public void setPurityAssessment(Float purityAssessment)
	{
		this.purityAssessment = purityAssessment;
	}

	public String getSpecimen()
	{
		return specimen;
	}

	public void setSpecimen(String specimen)
	{
		this.specimen = specimen;
	}

	public String getStandardNucleicAcidTypes()
	{
		return standardNucleicAcidTypes;
	}

	public void setStandardNucleicAcidTypes(String standardNucleicAcidTypes)
	{
		this.standardNucleicAcidTypes = standardNucleicAcidTypes;
	}

	public String getStudy()
	{
		return study;
	}

	public void setStudy(String study)
	{
		this.study = study;
	}

	public String getTestRequest()
	{
		return testRequest;
	}

	public void setTestRequest(String testRequest)
	{
		this.testRequest = testRequest;
	}

	public String getTestType()
	{
		return testType;
	}

	public void setTestType(String testType)
	{
		this.testType = testType;
	}

	public String getTissueOfOrigin()
	{
		return tissueOfOrigin;
	}

	public void setTissueOfOrigin(String tissueOfOrigin)
	{
		this.tissueOfOrigin = tissueOfOrigin;
	}
	
	

}
