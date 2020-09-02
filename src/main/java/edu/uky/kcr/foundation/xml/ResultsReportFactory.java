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

package edu.uky.kcr.foundation.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import edu.uky.kcr.foundation.xml.model.ResultsReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Factory for parsing Foundation Medicine XML variant reports
 */
public class ResultsReportFactory
{

	private ResultsReportFactory()
	{
	}

	public static ResultsReport createResultsReport(File xmlFile)
			throws IOException
	{
		ResultsReport resultsReport = null;

		try (FileInputStream fileInputStream = new FileInputStream(xmlFile))
		{
			resultsReport = createResultsReport(fileInputStream);
		}

		return resultsReport;
	}

	public static ResultsReport createResultsReport(InputStream xmlInputStream)
	{
		StaxDriver staxDriver = new StaxDriver();
		XStream xStream = new XStream(staxDriver);
		XStream.setupDefaultSecurity(xStream);
		xStream.allowTypesByWildcard(new String[]{"edu.uky.kcr.foundation.xml.model.**"});
		xStream.autodetectAnnotations(true);
		xStream.ignoreUnknownElements();
		xStream.processAnnotations(ResultsReport.class);
		xStream.registerConverter(ResultsReportUtils.createDateConverter());

		ResultsReport resultsReport = (ResultsReport)xStream.fromXML(xmlInputStream);

		return resultsReport;
	}
}
