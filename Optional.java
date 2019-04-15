//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
// Also, sorry that the "Paste" feature no longer works! GitHub broke
// this (so we'll switch to a new provider): https://blog.github.com\
// /2018-02-18-deprecation-notice-removing-anonymous-gist-creation/
//*******************************************************************

import java.lang.*; // headers MUST be above the first class
import java.util.*;
// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
   	String result=new Three().getTwo().orElse(new Two()).getOne().get().getName().orElseThrow(()->new NumberFormatException());
    	System.out.println(result);
	  
	One result2=new Three().getTwo().orElse(new Two()).getOne().get();
	System.out.println(result2.getName().get());
	  
	result2.setName("kikoo2");
    	System.out.println(result2.getName());
	  
	result2.setName(null);
    	System.out.println(result2.getName());
  }
}

class One{
	String name="kikoo";
  	public Optional<String>getName(){
  			return Optional.ofNullable(name);
    }


}

class Two{
	One one=new One();
  	public Optional<One>getOne(){
  			return Optional.of(one);
    }


}

class Three{
	Two two;
  	public Optional<Two>getTwo(){
  			return Optional.ofNullable(two);
    }


}
