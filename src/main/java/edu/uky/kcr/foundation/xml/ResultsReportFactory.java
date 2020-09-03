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
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.FloatConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.converters.basic.NullConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import edu.uky.kcr.foundation.xml.model.ResultsReport;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/**
 * Factory for parsing Foundation Medicine XML variant reports
 */
public class ResultsReportFactory
{
	public static final String RESULTS_REPORT_START = "<ResultsReport";
	public static final String RESULTS_REPORT_START_NS = "<rr:ResultsReport";
	private static final int PEEK_BUFFER_SIZE = 8192;

	private ResultsReportFactory()
	{
	}

	public static boolean isFoundationXmlReport(File xmlFile)
	{
		boolean isReport = false;

		if (xmlFile.isFile())
		{
			try (FileReader fileReader = new FileReader(xmlFile))
			{
				char[] buffer = new char[PEEK_BUFFER_SIZE];
				IOUtils.read(fileReader, buffer);
				String xmlStart = new String(buffer);

				if ((xmlStart.indexOf(RESULTS_REPORT_START) > -1) || (xmlStart.indexOf(RESULTS_REPORT_START_NS) > -1))
				{
					isReport = true;
				}
			}
			catch (IOException ioException)
			{
				isReport = false;
			}
		}

		return isReport;
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
		XStream xStream = new XStream(new StaxDriver()
		{
			@Override
			public HierarchicalStreamWriter createWriter(Writer out)
			{
				return new PrettyPrintWriter(out, "    ");
			}
		})
		{
			// only register the converters we need; other converters generate a private access warning in the console on Java9+...
			@Override
			protected void setupConverters()
			{
				registerConverter(new NullConverter(), PRIORITY_VERY_HIGH);
				registerConverter(new IntConverter(), PRIORITY_NORMAL);
				registerConverter(new FloatConverter(), PRIORITY_NORMAL);
				registerConverter(new DoubleConverter(), PRIORITY_NORMAL);
				registerConverter(new LongConverter(), PRIORITY_NORMAL);
				registerConverter(new ShortConverter(), PRIORITY_NORMAL);
				registerConverter(new BooleanConverter(), PRIORITY_NORMAL);
				registerConverter(new ByteConverter(), PRIORITY_NORMAL);
				registerConverter(new StringConverter(), PRIORITY_NORMAL);
				registerConverter(new DateConverter(), PRIORITY_NORMAL);
				registerConverter(new CollectionConverter(getMapper()), PRIORITY_NORMAL);
				registerConverter(new ReflectionConverter(getMapper(), getReflectionProvider()), PRIORITY_VERY_LOW);
			}
		};

		XStream.setupDefaultSecurity(xStream);
		xStream.allowTypesByWildcard(new String[]{"edu.uky.kcr.foundation.xml.model.**"});
		xStream.autodetectAnnotations(true);
		xStream.ignoreUnknownElements();
		xStream.processAnnotations(ResultsReport.class);
		xStream.registerConverter(ResultsReportUtils.createDateConverter());

		ResultsReport resultsReport = (ResultsReport) xStream.fromXML(xmlInputStream);

		return resultsReport;
	}
}
