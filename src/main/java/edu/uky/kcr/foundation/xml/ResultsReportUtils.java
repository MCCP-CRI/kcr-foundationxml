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

import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.apache.commons.lang.StringUtils;

import java.util.TimeZone;

public class ResultsReportUtils
{
	public static final String VARIANT_REPORT_SCHEMA_URI_PREFIX = "http://www.foundationmedicine.com/compbio/variant-report-external-";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String[] OTHER_DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss"};
	public static final String DEFAULT_TIME_ZONE = "EST";

	public static DateConverter createDateConverter()
	{
		return new DateConverter(DEFAULT_DATE_FORMAT, OTHER_DATE_FORMATS, TimeZone.getTimeZone(DEFAULT_TIME_ZONE));
	}

	public static String parseVariantReportSchemaVersion(String schemaLocation)
	{
		String variantReportSchemaVersion = null;

		String[] allUris = StringUtils.split(schemaLocation, ' ');

		for (int i = 0; i < allUris.length; i++)
		{
			if (allUris[i].startsWith(VARIANT_REPORT_SCHEMA_URI_PREFIX))
			{
				variantReportSchemaVersion = StringUtils.removeEnd(StringUtils.removeStart(allUris[i], VARIANT_REPORT_SCHEMA_URI_PREFIX), ".xsd");
				break;
			}
		}

		return variantReportSchemaVersion;
	}
}
