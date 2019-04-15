//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
// Also, sorry that the "Paste" feature no longer works! GitHub broke
// this (so we'll switch to a new provider): https://blog.github.com\
// /2018-02-18-deprecation-notice-removing-anonymous-gist-creation/
//*******************************************************************

import java.lang.*; // headers MUST be above the first class
import java.util.*;
import java.util.stream.*;
// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    List<Integer> intList=Arrays.asList(1,2,30,50,35,12,12,8,13,14);
    Integer i=intList.stream().reduce((x,y)->x<y?x:y).get();
    System.out.println(i);
   
    i=intList.stream().reduce((x,y)->x>=y?x:y).get();
    System.out.println(i);
    
    
    
    Stream<Elem> s=intList.stream().map(Elem::new);
    List<Elem>elemList=s.collect(Collectors.toList());
    Elem e=elemList.stream().reduce(new Elem(),(x,y)->{
                                       if(y.getValue()>10)
                                        x.add(y);
                                      
                                      return x;
                                    }
                            );
   e.getElemList().stream().map(Elem::toValue).forEach(System.out::println);
    
  }
 
}

class Elem{
	private List<Elem>elemList;
  	private int value;
  	Elem(){
      	System.out.println("appellée");
    	this.elemList=new ArrayList<>();     	
    }
  
 	Elem(int value){
     this.value=value;
    }
  
  	void add(Elem elem){
     	 elemList.add(elem);
  	}
  
  	int getValue(){
      return value;
  	}
  
  	void setValue(int value){
      value=value;
  	}
 	List<Elem> getElemList(){
  	return elemList;
 	}
   static int toValue(Elem e){
  	  return e.getValue();
  }
}


