# Fastq Cropper

This directory contains tool for cropping length of FASTQ reads.

## Functionality

- ```--headcrop``` cut the specified number of bases from the start of the read
- ```--tailcrop``` cut the specified number of bases from the end of the read

## Usage

To use Fastq Cropper you need to specify path to your input FASTQ data and to your result FASTQ file. After that use one of the flags from functionality section.  

Example:  
``` kotlin ./Fastq_Cropper.kts ~/FASTQ_samples/SRR1705860.fastq ~/FASTQ_samples/SRR1705860_result.fastq -- --headcrop ```

## Recommended system requirements
- Unix based operational system
- Kotlin version 1.3.72-release-468 (JRE 11.0.6+10-post-Ubuntu-1ubuntu118.04.1)
- openjdk version "11.0.6" 2020-01-14
