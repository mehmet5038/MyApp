package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;



public class App 
{
	
//creates a mixed username of numbers and characters which depends on user's input
    
    public static String createUsername(ArrayList<Integer> list, Integer[] array, String string1, String string2) {
    	Integer result = 0;
    	for (Integer i : list) {
			result += i;
		}
    	for (Integer i : array) {
			result *= i;
		}
    	return string2 + result.toString() + string1;
    }
	
    public static void main( String[] args )
    {
    	port(getHerokuAssignedPort());
        get("/", (req, res) -> "Welcome to my program, please enter /compute to end of the link in the address tab above to continue! :)");
        post("/compute", (req, res) -> {
          String input1 = req.queryParams("list");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
          }
          System.out.println(inputList1);
          
          String input2 = req.queryParams("array");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);


          String input3 = req.queryParams("string1").replaceAll("\\s","");
          String input4 = req.queryParams("string2").replaceAll("\\s","");


          String result = App.createUsername(inputList1, inputList2.toArray(new Integer[inputList2.size()]), input3, input4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not created yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());

    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
