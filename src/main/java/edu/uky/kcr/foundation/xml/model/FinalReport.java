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

@XStreamAlias("FinalReport")
public class FinalReport
{
	@XStreamAsAttribute
	@XStreamAlias("StagingId")
	private String stagingId = null;
	
	@XStreamAsAttribute
	@XStreamAlias("clinicalId")
	private String clinicalId = null;
	
	@XStreamAlias("Application")
	private Application application = null;
	
	@XStreamAlias("ReportId")
	private String finalReportReportId = null;
	
	@XStreamAlias("SampleName")
	private String finalReportSampleName = null;

	@XStreamAlias("PerformanceDataId")
	@XStreamAsAttribute
	private String performanceDataId = null;

	@XStreamAlias("Version")
	private String finalReportVersion = null;

	@XStreamAlias("DemographicCorrectionDate")
	private String demographicCorrectionDate = null;

	@XStreamAlias("Sample")
	private Sample sample = null;
	
	@XStreamAlias("PMI")
	private Pmi pmi = null;
	
	@XStreamAlias("PertinentNegatives")
	private PertinentNegatives pertinentNegatives = null;
	
	@XStreamAlias("Summaries")
	private Summaries summaries = null;
	
	@XStreamAlias("VariantProperties")	
	private VariantProperties variantProperties = null;
	
	@XStreamAlias("Genes")
	private Genes genes = null;
	
	@XStreamAlias("Trials")	
	private Trials trials = null;

	@XStreamAlias("References")	
	private References references = null;
	
	@XStreamAlias("Signatures")	
	private Signatures signatures = null;
	
	@XStreamAlias("AAC")	
	private AAC aac = null;
	
	public String getStagingId()
	{
		return stagingId;
	}

	public void setStagingId(String stagingId)
	{
		this.stagingId = stagingId;
	}

	public String getClinicalId()
	{
		return clinicalId;
	}

	public void setClinicalId(String clinicalId)
	{
		this.clinicalId = clinicalId;
	}

	public String getFinalReportReportId()
	{
		return finalReportReportId;
	}

	public void setFinalReportReportId(String finalReportReportId)
	{
		this.finalReportReportId = finalReportReportId;
	}

	public String getFinalReportSampleName()
	{
		return finalReportSampleName;
	}

	public void setFinalReportSampleName(String finalReportSampleName)
	{
		this.finalReportSampleName = finalReportSampleName;
	}

	public Pmi getPmi()
	{
		if (this.pmi == null)
		{
			this.pmi = new Pmi();
		}
		
		return pmi;
	}

	public void setPmi(Pmi pmi)
	{
		this.pmi = pmi;
	}

	public PertinentNegatives getPertinentNegatives()
	{
		if (this.pertinentNegatives == null)
		{
			this.pertinentNegatives = new PertinentNegatives();
		}
		
		return pertinentNegatives;
	}

	public void setPertinentNegatives(PertinentNegatives pertinentNegatives)
	{
		this.pertinentNegatives = pertinentNegatives;
	}

	public Summaries getSummaries()
	{
		if (this.summaries == null)
		{
			this.summaries = new Summaries();
		}
		return summaries;
	}

	public void setSummaries(Summaries summaries)
	{
		this.summaries = summaries;
	}

	public VariantProperties getVariantProperties()
	{
		if (this.variantProperties == null)
		{
			this.variantProperties = new VariantProperties();
		}
		return variantProperties;
	}

	public void setVariantProperties(VariantProperties variantProperties)
	{
		this.variantProperties = variantProperties;
	}

	public Genes getGenes()
	{
		if (this.genes == null)
		{
			this.genes = new Genes();
		}
		return genes;
	}

	public void setGenes(Genes genes)
	{
		this.genes = genes;
	}

	public Trials getTrials()
	{
		if (this.trials == null)
		{
			this.trials = new Trials();
		}
		return trials;
	}

	public void setTrials(Trials trials)
	{
		this.trials = trials;
	}

	public References getReferences()
	{
		if (this.references == null)
		{
			this.references = new References();
		}
		return references;
	}

	public void setReferences(References references)
	{
		this.references = references;
	}

	public Signatures getSignatures()
	{
		if (this.signatures == null)
		{
			this.signatures = new Signatures();
		}
		return signatures;
	}

	public void setSignatures(Signatures signatures)
	{
		this.signatures = signatures;
	}

	public AAC getAac()
	{
		if (this.aac == null)
		{
			this.aac = new AAC();
		}
		return aac;
	}

	public void setAac(AAC aac)
	{
		this.aac = aac;
	}

	public Sample getSample()
	{
		if (this.sample == null)
		{
			this.sample = new Sample();
		}
		return sample;
	}

	public void setSample(Sample sample)
	{
		this.sample = sample;
	}

	public Application getApplication() {
		
		if (this.application == null) {
			
			this.application = new Application();
		
		}
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getVersion() {
		return finalReportVersion;
	}

	public void setVersion(String version) {
		finalReportVersion = version;
	}

	public String getDemographicCorrectionDate() 
	{
		
		if (this.demographicCorrectionDate == null) {
			this.demographicCorrectionDate = "";
		}
		return demographicCorrectionDate;
	}

	public void setDemographicCorrectionDate(String demographicCorrectionDate) {
		this.demographicCorrectionDate = demographicCorrectionDate;
	}

	public String getPerformanceDataId()
	{
		return performanceDataId;
	}
}

