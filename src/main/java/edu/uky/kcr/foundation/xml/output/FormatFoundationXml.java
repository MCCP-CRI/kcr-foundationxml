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

package edu.uky.kcr.foundation.xml.output;

import edu.uky.kcr.cli.CliParser;
import edu.uky.kcr.cli.CliUtils;
import edu.uky.kcr.cli.DefaultCliAdapter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FormatFoundationXml
		extends DefaultCliAdapter
{
	private static final String OPT_INPUT = "i";
	private static final String OPT_OUTPUT = "o";

	public static void main(String[] args)
			throws IOException
	{
		CliParser cliParser = new CliParser("java -jar kcr-foundationxml-<version>-bin.jar -i <INPUT> [-o Output]")
				.withRequiredOption(OPT_INPUT, "input", true, "Input xml file or directory with xml files, input directories will be searched for *.xml files.")
				.withOption(OPT_OUTPUT, "output", true, "Optional output CSV file or directory, defaults to <input file>_flatvariants.csv. " +
						"If a directory is specified, one output file for each input file will be created in the output directory. " +
						"If a file is specified, input files can be distinguished by the fmId CSV header.")
				.withListener(new FormatFoundationXml());

		if (cliParser.parse(args))
		{
			try
			{
				File input = CliUtils.convertParsedValue(File.class, cliParser.getParsedValue(OPT_INPUT));
				File output = CliUtils.convertParsedValue(File.class, cliParser.getParsedValue(OPT_OUTPUT));

				if (input.isDirectory())
				{
					Collection<File> inputFiles = FileUtils.listFiles(input,
																	  new String[]{"xml"}, false);

					for (File xmlInputFile : inputFiles)
					{
						FoundationFormatter.fromInputXml(xmlInputFile).toFile(output);
					}
				}
				else
				{
					FoundationFormatter.fromInputXml(input).toFile(output);
				}
			}
			catch (ParseException parseException)
			{
				cliParser.defaultHandleParseException(parseException);
			}
		}
	}

	@Override
	public void handleParsedOption(String opt,
								   String[] parsedValues,
								   CliParser cliParser)
			throws ParseException
	{
		switch (opt)
		{
			case OPT_INPUT:
			{
				File inputFile = CliUtils.convertParsedValue(File.class, cliParser.getParsedValue(OPT_INPUT));

				if (inputFile == null || inputFile.exists() == false)
				{
					throw new ParseException(String.format("Input file or directory not found: %s", cliParser
							.getParsedValue(OPT_INPUT)));
				}

				break;
			}
		}
	}
}
