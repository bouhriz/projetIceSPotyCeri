package com.request.analyzer;
import java.util.ArrayList;

public class Action{
	  public Action(){}

	   public Action(ArrayList<String> ListMusic){

	        this.ListMusic = ListMusic;
	   }

   ArrayList<String> ListActions = new ArrayList<String>() {{
      add("lancer");
      add("écouter");
      add("stoper");
   }};

   ArrayList<String> ListMusic = new ArrayList<String>() {{
      add("Hôtel California");
      add("L'enfer");
      add("Formidable");
   }};
   
 
}