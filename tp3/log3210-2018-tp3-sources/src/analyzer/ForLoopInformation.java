package analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clque on 18-03-01.
 */
public class ForLoopInformation {
/*Constructors*/
    public ForLoopInformation(){
        this.nivImbrication = 0;
    }
    //used for boucle imbriquee
    public ForLoopInformation(ForLoopInformation parent){
        this.nivImbrication = parent.nivImbrication + 1;
        this.addVarGlobalesAvantBoucles(parent.varGlobalesAvantBoucle);
    }
    public ForLoopInformation(int nivImbrication, String nomTableau){
        this.nivImbrication = nivImbrication;
        this.tableauParcouru = nomTableau;
    }

    public void setIsTailleTableauModif(boolean isTabModif){
        this.isTailleTableauModif = isTabModif;
    }

    public void setIsVarLocDefDansBoucle(boolean isVarLocDef){
        this.isVarLocDefDansBoucle = isVarLocDef;
    }

    public void setTableauParcouru(String tableName){
        this.tableauParcouru = tableName;
    }

    // variables globales presentes avant la boucle
    public void addVarGlobalesAvantBoucles(String varGlobale){
        this.varGlobalesAvantBoucle.add(varGlobale);
    }
    public void addVarGlobalesAvantBoucles(List<String> varGlobales){
        this.varGlobalesAvantBoucle.addAll(varGlobales);
    }

   //variables locales assignes par la boucle
    public void addVarlocalesAssigneeParBoucle(String varLocale){
        this.varlocalesAssigneeParBoucle.add(varLocale);
    }
    public void addVarlocalesAssigneeParBoucle(List<String> varLocales){
        this.varlocalesAssigneeParBoucle.addAll(varLocales);
    }

    //autres variables locales dans la boucle
    public void addAutreVarLocDsBoucle(String varLocale){
        this.autreVarLocDsBoucle.add(varLocale);
    }
    public void addAutreVarLocDsBoucle(List<String> varLocales){
        this.autreVarLocDsBoucle.addAll(varLocales);
    }

    //var redefinies dans la boucle
    public void addVarRedefDansBoucle(String varRedefinie){
        this.varRedefDansBoucle.add(varRedefinie);
    }
    public void addVarRedefDansBoucle(List<String> varRedefinies){
        this.varRedefDansBoucle.addAll(varRedefinies);
    }

    //var requises par la boucle
    public void addVarRequiseParBoucle(String varRequise){
        this.varRequiseParBoucle.add(varRequise);
    }
    public void addVarRequiseParBoucle(List<String>  varRequises){
        this.varRequiseParBoucle.addAll(varRequises);
    }



    int nivImbrication;
    boolean isTailleTableauModif = false;
    boolean isVarLocDefDansBoucle = false;
    String tableauParcouru = "";

    List<String> varGlobalesAvantBoucle = new ArrayList<String>();
    List<String> varlocalesAssigneeParBoucle = new ArrayList<String>();
    List<String> autreVarLocDsBoucle = new ArrayList<String>();
    List<String> varRedefDansBoucle = new ArrayList<String>();
    List<String> varRequiseParBoucle = new ArrayList<String>();


}
