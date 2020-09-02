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

import java.util.Date;

@XStreamAlias("Pmi")	
public class Pmi
{
	@XStreamAlias("ReportId")	
	private String pmiReportId = null;

	@XStreamAlias("SampleId")
	private String pmiSampleId = null;

	@XStreamAlias("MRN")		
	private String pmiMrn = null;
	
	@XStreamAlias("FullName")		
	private String pmiFullName = null;
	
	@XStreamAlias("FirstName")		
	private String pmiFirstName = null;
	
	@XStreamAlias("LastName")		
	private String pmiLastName = null;
	
	@XStreamAlias("SubmittedDiagnosis")		
	private String pmiSubmittedDiagnosis = null;
	
	@XStreamAlias("Gender")		
	private String pmiGender = null;
	
	@XStreamAlias("DOB")		
	private Date pmiDob = null;
	
	@XStreamAlias("OrderingMD")		
	private String pmiOrderingMd = null;
	
	@XStreamAlias("OrderingMDId")		
	private String pmiOrderingMdId = null;
	
	@XStreamAlias("Pathologist")		
	private String pmiPathologist = null;
	
	@XStreamAlias("CopiedPhysician1")		
	private String pmiCopiedPhysician1 = null;
	
	@XStreamAlias("MedFacilName")		
	private String pmiMedFacilName = null;
	
	@XStreamAlias("MedFacilID")		
	private String pmiMedFacilId = null;
	
	@XStreamAlias("SpecSite")		
	private String pmiSpecSite = null;
	
	@XStreamAlias("CollDate")		
	private Date pmiCollDate = null;
	
	@XStreamAlias("ReceivedDate")		
	private Date pmiReceivedDate = null;

	@XStreamAlias("CountryOfOrigin")		
	private String countryOfOrigin = null;
	
	public String getPmiReportId()
	{
		return pmiReportId;
	}

	public String getPmiSampleId()
	{
		return pmiSampleId;
	}

	public void setPmiSampleId(String pmiSampleId)
	{
		this.pmiSampleId = pmiSampleId;
	}

	public void setPmiReportId(String pmiReportId)
	{
		this.pmiReportId = pmiReportId;
	}

	public String getPmiMrn()
	{
		return pmiMrn;
	}

	public void setPmiMrn(String pmiMrn)
	{
		this.pmiMrn = pmiMrn;
	}

	public String getPmiFullName()
	{
		return pmiFullName;
	}

	public void setPmiFullName(String pmiFullName)
	{
		this.pmiFullName = pmiFullName;
	}

	public String getPmiFirstName()
	{
		return pmiFirstName;
	}

	public void setPmiFirstName(String pmiFirstName)
	{
		this.pmiFirstName = pmiFirstName;
	}

	public String getPmiLastName()
	{
		return pmiLastName;
	}

	public void setPmiLastName(String pmiLastName)
	{
		this.pmiLastName = pmiLastName;
	}

	public String getPmiSubmittedDiagnosis()
	{
		return pmiSubmittedDiagnosis;
	}

	public void setPmiSubmittedDiagnosis(String pmiSubmittedDiagnosis)
	{
		this.pmiSubmittedDiagnosis = pmiSubmittedDiagnosis;
	}

	public String getPmiGender()
	{
		return pmiGender;
	}

	public void setPmiGender(String pmiGender)
	{
		this.pmiGender = pmiGender;
	}

	public Date getPmiDob()
	{
		return pmiDob;
	}

	public void setPmiDob(Date pmiDob)
	{
		this.pmiDob = pmiDob;
	}

	public String getPmiOrderingMd()
	{
		return pmiOrderingMd;
	}

	public void setPmiOrderingMd(String pmiOrderingMd)
	{
		this.pmiOrderingMd = pmiOrderingMd;
	}

	public String getPmiOrderingMdId()
	{
		return pmiOrderingMdId;
	}

	public void setPmiOrderingMdId(String pmiOrderingMdId)
	{
		this.pmiOrderingMdId = pmiOrderingMdId;
	}

	public String getPmiPathologist()
	{
		return pmiPathologist;
	}

	public void setPmiPathologist(String pmiPathologist)
	{
		this.pmiPathologist = pmiPathologist;
	}

	public String getPmiCopiedPhysician1()
	{
		return pmiCopiedPhysician1;
	}

	public void setPmiCopiedPhysician1(String pmiCopiedPhysician1)
	{
		this.pmiCopiedPhysician1 = pmiCopiedPhysician1;
	}

	public String getPmiMedFacilName()
	{
		return pmiMedFacilName;
	}

	public void setPmiMedFacilName(String pmiMedFacilName)
	{
		this.pmiMedFacilName = pmiMedFacilName;
	}

	public String getPmiMedFacilId()
	{
		return pmiMedFacilId;
	}

	public void setPmiMedFacilId(String pmiMedFacilId)
	{
		this.pmiMedFacilId = pmiMedFacilId;
	}

	public String getPmiSpecSite()
	{
		return pmiSpecSite;
	}

	public void setPmiSpecSite(String pmiSpecSite)
	{
		this.pmiSpecSite = pmiSpecSite;
	}

	public Date getPmiCollDate()
	{
		return pmiCollDate;
	}

	public void setPmiCollDate(Date pmiCollDate)
	{
		this.pmiCollDate = pmiCollDate;
	}

	public Date getPmiReceivedDate()
	{
		return pmiReceivedDate;
	}

	public void setPmiReceivedDate(Date pmiReceivedDate)
	{
		this.pmiReceivedDate = pmiReceivedDate;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
}
