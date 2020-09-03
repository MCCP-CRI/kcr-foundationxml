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

import edu.uky.kcr.foundation.xml.ResultsReportFactory;
import edu.uky.kcr.foundation.xml.ResultsReportUtils;
import edu.uky.kcr.foundation.xml.model.CopyNumberAlteration;
import edu.uky.kcr.foundation.xml.model.ProcessSite;
import edu.uky.kcr.foundation.xml.model.Rearrangement;
import edu.uky.kcr.foundation.xml.model.ResultsReport;
import edu.uky.kcr.foundation.xml.model.ShortVariant;
import edu.uky.kcr.foundation.xml.model.Signature;
import edu.uky.kcr.foundation.xml.model.VariantReportSample;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlatVariantCsvFormatter
		implements FoundationFormatter
{
	private static final DateFormat DEFAULT_DATE_FORMATTER = new SimpleDateFormat(ResultsReportUtils.DEFAULT_DATE_FORMAT);

	public static final String SHORT_VARIANT_TYPE = "shortVariant";
	public static final String REARRANGEMENT_TYPE = "rearrangement";
	public static final String COPY_NUMBER_TYPE = "copyNumber";

	private ResultsReport resultsReport = null;
	private File xmlInputFile = null;

	public static final String[] HEADER = new String[]{
			"variantType",
			"geneName1",
			"geneName2",
			"position1",
			"position2",
			"cdsEffect",
			"proteinEffect",
			"transcript",
			"strand",
			"functionalEffect",
			"copyNumber",
			"numberOfExons",
			"ratio",
			"copyNumberAlterationType",
			"description",
			"alleleFraction",
			"msi",
			"tmb",
			"pmiSubmittedDiagnosis",
			"pmiSpecSite",
			"pmiCollDate",
			"fmId",
			"cliaNumber",
			"signature",
			"baitSet"};

	protected FlatVariantCsvFormatter(File xmlInputFile)
			throws IOException
	{
		super();
		initialize(xmlInputFile);
	}

	protected FlatVariantCsvFormatter(ResultsReport resultsReport)
			throws IOException
	{
		super();
		initialize(resultsReport);
	}

	protected void initialize(ResultsReport resultsReport)
			throws IOException
	{
		setResultsReport(resultsReport);
	}

	protected void initialize(File xmlInputFile)
			throws IOException
	{
		ResultsReport resultsReport = ResultsReportFactory.createResultsReport(xmlInputFile);
		setResultsReport(resultsReport);
		setXmlInputFile(xmlInputFile);
	}

	public String getDefaultOutputFilename()
	{
		String basename = null;

		if (xmlInputFile != null)
		{
			basename = FilenameUtils.getBaseName(getXmlInputFile().getName());
		}
		else
		{
			basename = getResultsReport().getFinalReport().getFinalReportReportId();
		}

		String defautOutputFilename = String.format("%s_%s.csv", basename, FoundationFormatter.FLAT_VARIANTS_FORMAT);

		return defautOutputFilename;
	}

	public File getDefaultOutputDirectory()
	{
		File defautOutputDirectory = null;

		if (xmlInputFile != null)
		{
			defautOutputDirectory = getXmlInputFile().getParentFile();
		}
		else
		{
			defautOutputDirectory = new File(System.getProperty("user.dir"));
		}

		return defautOutputDirectory;
	}

	private File getXmlInputFile()
	{
		return xmlInputFile;
	}

	private void setXmlInputFile(File xmlInputFile)
	{
		this.xmlInputFile = xmlInputFile;
	}

	public File toDefaultFile()
			throws IOException
	{
		File outputCsvFile = new File(getDefaultOutputDirectory(), getDefaultOutputFilename());

		toFile(outputCsvFile);

		return outputCsvFile;
	}

	public File toDirectory(File outputDirectory)
			throws IOException
	{
		File outputCsvFile = new File(outputDirectory, getDefaultOutputFilename());

		toFile(outputCsvFile);

		return outputCsvFile;
	}

	public File toFile(File outputFile)
			throws IOException
	{
		File actualOutputFile = null;

		if (outputFile == null)
		{
			actualOutputFile = toDefaultFile();
		}
		else if (outputFile.isDirectory())
		{
			actualOutputFile = toDirectory(outputFile);
		}
		else
		{
			actualOutputFile = toCsvFile(outputFile);
		}

		return actualOutputFile;
	}

	private File toCsvFile(File outputFile)
			throws IOException
	{
		boolean append = outputFile.exists();

		try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outputFile, append)))
		{
			CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter, CSVFormat.EXCEL);

			if (append == false)
			{
				csvPrinter.printRecord(HEADER);
			}

			String tmb = resultsReport.getVariantReport().getBiomarkers().getTumorMutationBurden().getStatus();
			String msi = resultsReport.getVariantReport().getBiomarkers().getMicrosatelliteInstability().getStatus();
			String pmiSubmittedDiagnosis = resultsReport.getFinalReport().getPmi().getPmiSubmittedDiagnosis();
			String pmiSpecSite = resultsReport.getFinalReport().getPmi().getPmiSpecSite();
			String pmiCollDate = DEFAULT_DATE_FORMATTER.format(resultsReport.getFinalReport().getPmi()
																	   .getPmiCollDate());
			String fmId = resultsReport.getFinalReport().getSample().getSampleFmId();
			String cliaNumber = getDistinctCliaNumbers(resultsReport.getFinalReport().getSample().getProcessSites()
															   .getList());
			String signature = getSignatures(resultsReport.getFinalReport().getSignatures().getList());
			String baitSet = getDistinctBaitSets(resultsReport.getVariantReport().getSamples().getList());

			for (ShortVariant shortVariant : resultsReport.getVariantReport().getShortVariants().getList())
			{
				List<String> recordValues = new ArrayList<>();

				recordValues.add(SHORT_VARIANT_TYPE); //"variantType",
				recordValues.add(shortVariant.getGeneName()); //"geneName1",
				recordValues.add(StringUtils.EMPTY); //"geneName2",
				recordValues.add(shortVariant.getPosition()); //"position1",
				recordValues.add(StringUtils.EMPTY); //"position2",
				recordValues.add(shortVariant.getCdsEffect()); //"cdsEffect",
				recordValues.add(shortVariant.getProteinEffect()); //"proteinEffect",
				recordValues.add(shortVariant.getTranscript()); //"transcript",
				recordValues.add(shortVariant.getStrand()); //"strand",
				recordValues.add(shortVariant.getFunctionalEffect()); //"functionalEffect",
				recordValues.add(StringUtils.EMPTY); //"copyNumber",
				recordValues.add(StringUtils.EMPTY); //"numberOfExons",
				recordValues.add(StringUtils.EMPTY); //"ratio",
				recordValues.add(StringUtils.EMPTY); //"copyNumberAlterationType",
				recordValues.add(StringUtils.EMPTY); //"description",
				recordValues.add(Objects.toString(shortVariant
														  .getAlleleFraction(), StringUtils.EMPTY)); //"alleleFraction",
				recordValues.add(msi); //"msi",
				recordValues.add(tmb); //"tmb",
				recordValues.add(pmiSubmittedDiagnosis); //"pmiSubmittedDiagnosis",
				recordValues.add(pmiSpecSite); //"pmiSpecSite",
				recordValues.add(pmiCollDate); //"pmiCollDate",
				recordValues.add(fmId); //"fmId",
				recordValues.add(cliaNumber); //"cliaNumber",
				recordValues.add(signature); //"signature",
				recordValues.add(baitSet); //"baitSet"

				csvPrinter.printRecord(recordValues.toArray(new String[]{}));
				csvPrinter.flush();
			}

			for (Rearrangement rearrangement : resultsReport.getVariantReport().getRearrangements().getList())
			{
				List<String> recordValues = new ArrayList<>();

				recordValues.add(REARRANGEMENT_TYPE); //"variantType",
				recordValues.add(rearrangement.getTargetedGene()); //"geneName1",
				recordValues.add(rearrangement.getOtherGene()); //"geneName2",
				recordValues.add(rearrangement.getPos1()); //"position1",
				recordValues.add(rearrangement.getPos2()); //"position2",
				recordValues.add(StringUtils.EMPTY); //"cdsEffect",
				recordValues.add(StringUtils.EMPTY); //"proteinEffect",
				recordValues.add(StringUtils.EMPTY); //"transcript",
				recordValues.add(StringUtils.EMPTY); //"strand",
				recordValues.add(StringUtils.EMPTY); //"functionalEffect",
				recordValues.add(StringUtils.EMPTY); //"copyNumber",
				recordValues.add(StringUtils.EMPTY); //"numberOfExons",
				recordValues.add(StringUtils.EMPTY); //"ratio",
				recordValues.add(StringUtils.EMPTY); //"copyNumberAlterationType",
				recordValues.add(rearrangement.getDescription()); //"description",
				recordValues.add(StringUtils.EMPTY); //"alleleFraction",
				recordValues.add(msi); //"msi",
				recordValues.add(tmb); //"tmb",
				recordValues.add(pmiSubmittedDiagnosis); //"pmiSubmittedDiagnosis",
				recordValues.add(pmiSpecSite); //"pmiSpecSite",
				recordValues.add(pmiCollDate); //"pmiCollDate",
				recordValues.add(fmId); //"fmId",
				recordValues.add(cliaNumber); //"cliaNumber",
				recordValues.add(signature); //"signature",
				recordValues.add(baitSet); //"baitSet"

				csvPrinter.printRecord(recordValues.toArray(new String[]{}));
				csvPrinter.flush();
			}

			for (CopyNumberAlteration copyNumberAlteration : resultsReport.getVariantReport().getCopyNumberAlterations()
					.getList())
			{
				List<String> recordValues = new ArrayList<>();

				recordValues.add(COPY_NUMBER_TYPE); //"variantType",
				recordValues.add(copyNumberAlteration.getGene()); //"geneName1",
				recordValues.add(StringUtils.EMPTY); //"geneName2",
				recordValues.add(copyNumberAlteration.getPosition()); //"position1",
				recordValues.add(StringUtils.EMPTY); //"position2",
				recordValues.add(StringUtils.EMPTY); //"cdsEffect",
				recordValues.add(StringUtils.EMPTY); //"proteinEffect",
				recordValues.add(StringUtils.EMPTY); //"transcript",
				recordValues.add(StringUtils.EMPTY); //"strand",
				recordValues.add(StringUtils.EMPTY); //"functionalEffect",
				recordValues.add(copyNumberAlteration.getCopyNumber().toString()); //"copyNumber",
				recordValues.add(copyNumberAlteration.getNumberOfExons()); //"numberOfExons",
				recordValues.add(copyNumberAlteration.getRatio().toString()); //"ratio",
				recordValues.add(copyNumberAlteration.getCopyNumberAlterationType()); //"copyNumberAlterationType",
				recordValues.add(StringUtils.EMPTY); //"description",
				recordValues.add(StringUtils.EMPTY); //"alleleFraction",
				recordValues.add(msi); //"msi",
				recordValues.add(tmb); //"tmb",
				recordValues.add(pmiSubmittedDiagnosis); //"pmiSubmittedDiagnosis",
				recordValues.add(pmiSpecSite); //"pmiSpecSite",
				recordValues.add(pmiCollDate); //"pmiCollDate",
				recordValues.add(fmId); //"fmId",
				recordValues.add(cliaNumber); //"cliaNumber",
				recordValues.add(signature); //"signature",
				recordValues.add(baitSet); //"baitSet"

				csvPrinter.printRecord(recordValues.toArray(new String[]{}));
				csvPrinter.flush();
			}

			csvPrinter.close();
		}

		return outputFile;
	}

	private String getDistinctCliaNumbers(List<ProcessSite> processSites)
	{
		List<String> cliaNumberList = new ArrayList<>();

		for (ProcessSite processSite : processSites)
		{
			if (cliaNumberList.contains(processSite.getCliaNumber()) == false)
			{
				cliaNumberList.add(processSite.getCliaNumber());
			}
		}

		return StringUtils.join(cliaNumberList.toArray(new String[]{}), ",");
	}

	private String getDistinctBaitSets(List<VariantReportSample> samples)
	{
		List<String> sampleList = new ArrayList<>();

		for (VariantReportSample sample : samples)
		{
			if (sampleList.contains(sample.getBaitSet()) == false)
			{
				sampleList.add(sample.getBaitSet());
			}
		}

		return StringUtils.join(sampleList.toArray(new String[]{}), ",");
	}

	private String getSignatures(List<Signature> signatures)
	{
		List<String> signatureList = new ArrayList<>();

		for (Signature signature : signatures)
		{
			signatureList.add(
					String.format("%s (%s)", signature.getSignatureText(), signature.getSignatureServerTime()));
		}

		return StringUtils.join(signatureList.toArray(new String[]{}), " | ");
	}

	private ResultsReport getResultsReport()
	{
		return resultsReport;
	}

	private void setResultsReport(ResultsReport resultsReport)
	{
		this.resultsReport = resultsReport;
	}


}
