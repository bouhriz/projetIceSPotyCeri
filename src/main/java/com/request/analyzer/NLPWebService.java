package com.request.analyzer;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  http://localhost:8080/Analyzer/action/je veux écouter Formidable

@RestController
@RequestMapping("/Analyzer")
public class NLPWebService{

	static Action action = new Action();
	
	@RequestMapping("/hello")
    public String hello() {
        return "Hello World RESTful with Spring Boot";
    }

    @RequestMapping("/ListMusic")
public String listListMusic() {
        
        String resultat = "";

        if(this.action.ListActions.size() != 0){

             for(String musicTitre : this.action.ListMusic){
                  resultat += musicTitre + "-";
             }
        }
        return resultat;
    }



    @RequestMapping("/ListAction")
public String listListActions() {
        
        String resultat = "";

        if(this.action.ListActions.size() != 0){
	         for(String action : this.action.ListActions){
	              resultat += action + "-";
	         }}
        return resultat;
    }

    
  
    
    @RequestMapping("action/{name}")
    public String action(@PathVariable String name) {
        
        
        boolean actionTrouvee = false;
        boolean musicTrouvee = false;
        String resultat = "";

        for(String action : this.action.ListActions){
             
        	  if(name.toLowerCase().contains(action.toLowerCase())){
                  resultat += action + "-";
                  actionTrouvee = true;

        	  }
        }

        for(String musicTitre : this.action.ListMusic){
            
            if(name.toLowerCase().contains(musicTitre.toLowerCase())){
                  resultat += musicTitre;
                  musicTrouvee = true;
             }
        }

        if(actionTrouvee == false || musicTrouvee == false){
            resultat += "Action ou music non trouvées";
        }

       return resultat;

   
}


    
    @RequestMapping("/addMusic/{name}")
    public void addMusic(@PathVariable String name) {

          this.action.ListMusic.add(name);

    }



}
