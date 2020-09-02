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

@XStreamAlias("Alteration")
public class Alteration {
	
	@XStreamAlias("Name")
	private String alterationName = null;
	
	@XStreamAlias("Include")
	private String alterationInclude = null;
	
	@XStreamAlias("AlterationProperties")
	private AlterationProperties alterationProperties = null;
	
	@XStreamAlias("Interpretation")
	private String alterationInterpretation = null;

	@XStreamAlias("Relavance")
	private String alterationRelevance = null;

	@XStreamAlias("Indication")
	private String alterationIndication = null;

	@XStreamAlias("ClinicalTrialNote")
	private String alterationClinicalTrialNote = null;
	
	@XStreamAlias("Therapies")
	private Therapies therapies = null;

	@XStreamAlias("ReferenceLinks")
	private ReferenceLinks referenceLinks = null;
	
	@XStreamAlias("ClinicalTrialLinks")
	private ClinicalTrialLinks clinicalTrialLinks = null;

	public String getAlterationRelevance()
	{
		return alterationRelevance;
	}

	public String getAlterationName()
	{
		return alterationName;
	}

	public String getAlterationInclude()
	{
		return alterationInclude;
	}

	public String getAlterationInterpretation()
	{
		return alterationInterpretation;
	}

	public String getAlterationIndication()
	{
		return alterationIndication;
	}

	public String getAlterationClinicalTrialNote()
	{
		return alterationClinicalTrialNote;
	}

	public AlterationProperties getAlterationProperties()
	{
		if (this.alterationProperties == null)
		{
			this.alterationProperties = new AlterationProperties();
		}
		return alterationProperties;
	}

	public ClinicalTrialLinks getClinicalTrialLinks()
	{
		if (this.clinicalTrialLinks == null)
		{
			this.clinicalTrialLinks = new ClinicalTrialLinks();
		}
		return clinicalTrialLinks;
	}

	public ReferenceLinks getReferenceLinks()
	{
		if (this.referenceLinks == null)
		{
			this.referenceLinks = new ReferenceLinks();
		}
		return referenceLinks;
	}

	public Therapies getTherapies()
	{
		if (this.therapies == null)
		{
			this.therapies = new Therapies();
		}
		return therapies;
	}

}