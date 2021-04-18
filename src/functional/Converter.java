package functional;

import annotations.MyAnnotation;


public class Converter {  
	  String doConversion(ConverterFunction<String, Integer, String> f) {
	    // … valid implementation here
		  
		  
		  return f.apply("", 1);
	  }
	}
