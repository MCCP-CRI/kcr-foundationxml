# **Java Library for Parsing Foundation Medicine XML Variant Reports and Converting to CSV** #

## Parsing Foundation Medicine XML ##

## onverting  ##

- Download and install a Java Runtime version 11 or later, such as 
[AdoptOpenJDK 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
- Download the [latest Runnable JAR release](../../releases) of this project
  ### Convert a single XML file into a CSV file ###
  ```
  java -jar <Runnable JAR> input.xml
  ```
  This will create a CSV output file called *input_flatvariants.csv* in the same directory 
  as the input file.

  ### Convert a single Foundation XML file into a CSV file ###
  ```
  java -jar <Runnable JAR> input.xml some_directory/output.csv
  ```
  This will create a CSV output file called *output.csv* in *some_directory*.

  ### Convert a directory of XML files into a single CSV output file ###
  ```
  java -jar <Runnable JAR> input_directory/ some_directory/output.csv
  ```
  This will create a single CSV output file called *output.csv* in *some_directory*, 
  the file will contain a report of all variants found in all input files.

  ### Convert a directory of Foundation XML files into multiple CSV output files ###
  ```
  java -jar <Runnable JAR> input_directory/ some_directory/
  ```
  This will create multiple CSV output files in *some_directory*, one for each input file 
  in *input_directory*. Each output file will be named with the original input filename with 
  *_flatvariants.csv* appended.

## Support and Contributions ##
For support, feature requests, or to make contributions, please [open an issue](../../issues/new).

Created and maintained by the [Cancer Research Informatics Shared
Resource Facility](https://ukhealthcare.uky.edu/markey-cancer-center/research/cri) and the [Kentucky Cancer Registry](https://www.kcr.uky.edu)
at the [University of Kentucky Markey Cancer Center](https://ukhealthcare.uky.edu/markey-cancer-center).

