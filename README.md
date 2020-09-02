# **Java Library for Parsing Foundation Medicine XML Variant Reports and Converting to CSV** #

**Input:** Foundation Medicine XML file, contact your representative from [Foundation Medicine, Inc.](https://www.foundationmedicine.com/) to obtain XML files.

**Output:** [CSV File](src/main/resources/KCR999999_flatvariants.csv) with variant and identifier information:

| variantType   | geneName1 | geneName2 | position1                  | position2                 | cdsEffect     | proteinEffect | transcript | functionalEffect | copyNumber | numberOfExons | ratio | copyNumberAlterationType | description   | alleleFraction | msi | tmb          | pmiSubmittedDiagnosis  | pmiSpecSite | pmiCollDate | fmId      | cliaNumber | signature                                                                              | baitSet |
|---------------|-----------|-----------|----------------------------|---------------------------|---------------|---------------|------------|------------------|------------|---------------|-------|--------------------------|---------------|----------------|-----|--------------|------------------------|-------------|-------------|-----------|------------|----------------------------------------------------------------------------------------|---------|
| shortVariant  | PIK3CA    |           | chr4:918936091             |                           | 1099G>A       | E545K         | NM_008818  | missense         |            |               |       |                          |               | 0.5995         | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| shortVariant  | ATM       |           | chr12:108197793            |                           | 6123_6124insA | T2333fs*40    | NM_000091  | frameshift       |            |               |       |                          |               | 0.8388         | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| shortVariant  | BRCA2     |           | chr23:309892764            |                           | 8812A>G       | N1758D        | NM_000034  | missense         |            |               |       |                          |               | 0.7067         | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| rearrangement | SUFU      | ARL3      | chr17:104093620-104998761  | chr17:100975238-100988763 |               |               |            |                  |            |               |       |                          | rearrangement |                | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| copyNumber    | BCL2L1    |           | chr19:33098751-34988921    |                           |               |               |            |                  | 5          | 4 of 4        | 1.53  | amplification            |               |                | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| copyNumber    | MYST3     |           | chr6:48999999-49999999     |                           |               |               |            |                  | 6          | 16 of 16      | 1.45  | amplification            |               |                | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |
| copyNumber    | RNF43     |           | chr12:0988776260-098876938 |                           |               |               |            |                  | 10         | 9 of 9        | 3.12  | amplification            |               |                | MSS | intermediate | Breast carcinoma (NOS) | Breast      | 10/18/19    | KCR999999 | 00D9099111 | Fred Flintstone, M.D. \| Mister Anderson, M.D., Medical Director (2019-02-19 10:30:00) | K9      |  

## Command-Line Usage  ##

- Download and install a Java Runtime version 11 or later, such as 
[AdoptOpenJDK 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
- Download the [latest Runnable JAR release](../../releases) of this project
  ### Convert a single XML file into a CSV file ###
  ```
  java -jar kcr-foundationxml-<version>-bin.jar input.xml
  ```
  This will create a CSV output file called *input_flatvariants.csv* in the same directory 
  as the input file.

  ### Convert a single Foundation XML file into a CSV file ###
  ```
  java -jar kcr-foundationxml-<version>-bin.jar input.xml some_directory/output.csv
  ```
  This will create a CSV output file called *output.csv* in *some_directory*.

  ### Convert a directory of XML files into a single CSV output file ###
  ```
  java -jar kcr-foundationxml-<version>-bin.jar input_directory/ some_directory/output.csv
  ```
  This will create a single CSV output file called *output.csv* in *some_directory*, 
  the file will contain a report of all variants found in all input files.

  ### Convert a directory of Foundation XML files into multiple CSV output files ###
  ```
  java -jar kcr-foundationxml-<version>-bin.jar input_directory/ some_directory/
  ```
  This will create multiple CSV output files in *some_directory*, one for each input file 
  in *input_directory*. Each output file will be named with the original input filename with 
  *_flatvariants.csv* appended.

## Support and Contributions ##
For support, feature requests, or to make contributions, please [open an issue](../../issues/new).

Created and maintained by the [Cancer Research Informatics Shared
Resource Facility](https://ukhealthcare.uky.edu/markey-cancer-center/research/cri) and the [Kentucky Cancer Registry](https://www.kcr.uky.edu)
at the [University of Kentucky Markey Cancer Center](https://ukhealthcare.uky.edu/markey-cancer-center).

