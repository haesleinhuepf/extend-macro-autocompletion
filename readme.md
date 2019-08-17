# ImageJ macro extensions and extending auto completion in Fijis script editor
Since we introduced auto-completion in Fijis script editor, some developers asked me 
how they can make their tools discoverable by auto-completion users. 
This article explains how to achieve this. I'm providing a [fully functional example](https://github.com/haesleinhuepf/extend-macro-autocompletion) as 
this might be a better starting point for developers.

## Starting point a SciJava Fiji plugin
As a starting point we assume to have a [maven](https://maven.apache.org/) project with a 
[pom.xml](http://github.com/haesleinhuepf/extend) file 





