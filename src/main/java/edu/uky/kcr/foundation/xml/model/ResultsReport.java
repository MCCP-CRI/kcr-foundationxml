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

/**
 * This class represents the top level, de-serialized model of a Foundation
 * Medicine XML variant report, instances are created from the
 * {@link edu.uky.kcr.foundation.xml.ResultsReportFactory}.
 */
@XStreamAlias("ResultsReport")
public class ResultsReport
{
	//Hide the default constructor to force factory creation.
	protected ResultsReport()
	{

	}

	@XStreamAlias("FinalReport")
	private FinalReport finalReport = null;

	@XStreamAlias("variant-report")
	private VariantReport variantReport = null;

	@XStreamAlias("CustomerInformation")
	private CustomerInformation customerInformation = null;
	
	@XStreamAlias("ResultsPayload")
	private ResultsPayload resultsPayload = null;
	
	public CustomerInformation getCustomerInformation() {
		return customerInformation;
	}
	
	public ResultsPayload getResultsPayload() {
		return resultsPayload;
	}

	/**
	 *
	 * @return the {@link FinalReport} object parsed from an XML variant report.
	 * 	 For compatibility with v1 and v2 of the XML schema, will return the
	 * 	 {@link FinalReport} child entity of {@link ResultsPayload} if it exists
	 * 	 there instead of as a child of {@link ResultsReport}.
	 */
	public FinalReport getFinalReport()
	{
		if (this.finalReport == null && this.resultsPayload != null)
		{
			this.finalReport = this.resultsPayload.getFinalReport();
		}

		return finalReport;
	}

	/**
	 *
	 * @return the {@link VariantReport} object parsed from an XML variant report.
	 * 	 For compatibility with v1 and v2 of the XML schema, will return the
	 * 	 {@link VariantReport} child entity of {@link ResultsPayload} if it exists
	 * 	 there instead of as a child of {@link ResultsReport}.
	 */
	public VariantReport getVariantReport()
	{
		if (this.variantReport == null && this.resultsPayload != null)
		{
			this.variantReport = this.resultsPayload.getVariantReport();
		}

		return variantReport;
	}
}
