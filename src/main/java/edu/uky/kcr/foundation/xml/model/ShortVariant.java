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
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("short-variant")	
public class ShortVariant
{
	@XStreamAsAttribute
	@XStreamAlias("cds-effect")
	private String cdsEffect = null;

	@XStreamAsAttribute
	@XStreamAlias("allele-fraction")
	private String alleleFraction = null;

	@XStreamAsAttribute
	private Integer depth = null;

	@XStreamAlias("gene")
	@XStreamAsAttribute
	private String geneName = null;

	@XStreamAsAttribute
	private String equivocal = null;

	@XStreamAlias("percent-reads")
	@XStreamAsAttribute
	private String percentReads = null;

	@XStreamAsAttribute
	private String position = null;

	@XStreamAsAttribute
	@XStreamAlias("protein-effect")
	private String proteinEffect = null;

	@XStreamAsAttribute
	private String status = null;

	@XStreamAsAttribute
	private String transcript = null;

	@XStreamAsAttribute
	private String strand = null;

	@XStreamAsAttribute
	@XStreamAlias("functional-effect")
	private String functionalEffect = null;
	
	@XStreamAsAttribute
	private String subclonal = null;

	@XStreamAlias("dna-evidence")	
	@XStreamImplicit
    private List<DnaEvidence> dnaEvidenceList = null;

	@XStreamAlias("rna-evidence")	
	@XStreamImplicit
    private List<RnaEvidence> rnaEvidenceList = null;

	public List<DnaEvidence> getDnaEvidenceList()
	{
		if (this.dnaEvidenceList == null)
		{
			this.dnaEvidenceList = new ArrayList<DnaEvidence>();
		}
		return dnaEvidenceList;
	}

	public List<RnaEvidence> getRnaEvidenceList()
	{
		if (this.rnaEvidenceList == null)
		{
			this.rnaEvidenceList = new ArrayList<RnaEvidence>();
		}
		return rnaEvidenceList;
	}

	public String getCdsEffect()
	{
		return cdsEffect;
	}

	public String getAlleleFraction()
	{
		return alleleFraction;
	}

	public Integer getDepth()
	{
		return depth;
	}

	public String getGeneName()
	{
		return geneName;
	}

	public String getEquivocal()
	{
		return equivocal;
	}

	public String getPercentReads()
	{
		return percentReads;
	}

	public String getPosition()
	{
		return position;
	}

	public String getProteinEffect()
	{
		return proteinEffect;
	}

	public String getStatus()
	{
		return status;
	}

	public String getTranscript()
	{
		return transcript;
	}

	public String getStrand()
	{
		return strand;
	}

	public String getFunctionalEffect()
	{
		return functionalEffect;
	}

	public String getSubclonal()
	{
		return subclonal;
	}
}
