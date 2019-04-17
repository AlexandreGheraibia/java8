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
import java.util.function.*;
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
    
    
    
    Stream<Elem3> s=intList.stream().map(Elem3::new);
    List<Elem3>elemList=s.collect(Collectors.toList());
    elemList.stream().reduce(new Elem3(),(x,y)->{
                                       if(y.getValue()>10)
                                        x.add(y);
                                      
                                      return x;
                                    }
                  				).getElemList()
      							 .stream()
      							 .map(Elem3::toValue)
      							 .forEach(System.out::println);
    
  }
 
}


class Elem3 extends Elem2<Integer>{
  Elem3(){
      	super();   	
    }
  Elem3(Integer value){
     super(value);
    }
 
}


class Elem2<T>{
	private List<Elem2>elemList;
  	private T value;
    
  	Elem2(){
      	System.out.println("appellée");
    	this.elemList=new ArrayList<>();     	
    }
  
 	Elem2(T value){
     this.value=value;
    }
  
  	void add(Elem2 elem){
     	 elemList.add(elem);
  	}
  
  	T getValue(){
      return value;
  	}
  
  	void setValue(T value){
      value=value;
  	}
 	List<Elem2> getElemList(){
  	return elemList;
 	}
     
  
    public static  <E extends Elem2<?>>  Object toValue(E e){
  	  return e.getValue();
  }
}
