package analyzer.visitors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clque on 18-03-01.
 */
public class ForLoopInformation {

    /* Proprierties to print (In order) */
    private int nivImbrication;                             // #1: Le niveau d’imbrication de la boucle
    private String tableauParcouru;                         // #2: Le tableau parcouru
    private ArrayList<String> varGlobalesAvantBoucle;       // #3: Les variables globales définies avant la boucle
    private String varlocaleAssigneeParBoucle;              // #4: La variable locale assignée par la boucle
    private ArrayList<String> autresVarLocDsBoucle;         // #5: Les autres variables locales définies dans la boucle
    private ArrayList<String> varRedefDansBoucle;           // #6: Les variables redéfinies par la boucle (sauf locales)
    private ArrayList<String> varRequiseParBoucle;          // #7: Les variables requises par la boucle (sauf locales)
    private boolean isTailleTableauModified;                // #8: Un booléen indiquant si la taille du tableau parcouru est modifiée pendant la boucle
    private boolean isVarLocDefinedDansBoucle;              // #9: Un booléen indiquant si la variable locale a déjà été définie en dehors de la boucle
    private ArrayList<String> varDefDansInnerBoucle;
    private ForLoopInformation parentInfo;

    /* Constructors */
    public ForLoopInformation() {
        this.nivImbrication = 0;
        this.tableauParcouru = "";
        this.varGlobalesAvantBoucle = new ArrayList<String>();
        this.varlocaleAssigneeParBoucle = "";
        this.autresVarLocDsBoucle = new ArrayList<String>();
        this.varRedefDansBoucle = new ArrayList<String>();
        this.varRequiseParBoucle = new ArrayList<String>();
        this.varDefDansInnerBoucle = new ArrayList<String>();
        this.isTailleTableauModified = false;
        this.isVarLocDefinedDansBoucle = false;
        this.verifierIsVarLocDefinedDansBoucle();
    }
    public ForLoopInformation(ForLoopInformation info) {
        this.nivImbrication = info.nivImbrication;
        this.tableauParcouru = info.tableauParcouru;
        this.varGlobalesAvantBoucle = new ArrayList<String>(info.varGlobalesAvantBoucle);
        this.varlocaleAssigneeParBoucle = info.varlocaleAssigneeParBoucle;
        this.autresVarLocDsBoucle = new ArrayList<String>(info.autresVarLocDsBoucle);
        this.varRedefDansBoucle = new ArrayList<String>(info.varRedefDansBoucle);
        this.varRequiseParBoucle = new ArrayList<String>(info.varRequiseParBoucle);
        this.isTailleTableauModified = info.isTailleTableauModified;
        this.isVarLocDefinedDansBoucle = info.isVarLocDefinedDansBoucle;
        this.verifierIsVarLocDefinedDansBoucle();
    }

    /* Print the results */
    public String getAllInformationPrintable() {
        String var1 = Integer.toString(this.nivImbrication);
        String var2 = this.tableauParcouru;
        String var3 = arrayListToString(this.varGlobalesAvantBoucle);
        String var4 = this.varlocaleAssigneeParBoucle;
        String var5 = arrayListToString(this.autresVarLocDsBoucle);
        String var6 = arrayListToString(this.varRedefDansBoucle);
        String var7 = arrayListToString(this.varRequiseParBoucle);
        String var8 = boolToStrintg(this.isTailleTableauModified);
        String var9 = boolToStrintg(this.isVarLocDefinedDansBoucle);

        // ex of expected print: " FOR : 1, x, [n,m,x,y,z,i], e, [], [i,x], [i,n,x], False, False; "
        return "FOR : " + var1 + ", " + var2 + ", " + var3 + ", " + var4 + ", " + var5 + ", " + var6 + ", " + var7 + ", " + var8 + ", " + var9 + ";";
    }
    public String arrayListToString(ArrayList<String> list) {
        String result = "[";
        if (list.size() > 0) {
            for (int i = 0; i < list.size()-1; i++)
            {
                result += list.get(i) + ",";
            }
            result += list.get(list.size()-1);
        }
        result += "]";

        return result;
    }
    public String boolToStrintg(Boolean bool) {
        String result = "";
        if (bool == true) {
            result = "True";
        } else if (bool == false) {
            result = "False";
        } else {
            result = "Error";
        }
        return result;
    }

    /* Verify two bools */
    public void verifierIsTailleTableauModified() {
    } // to do ?
    public void verifierIsVarLocDefinedDansBoucle() {
        this.isVarLocDefinedDansBoucle = this.varGlobalesAvantBoucle.contains(this.varlocaleAssigneeParBoucle);
    }

    /* Mutators */
    public void setNivImbrication(int niveau) {
        this.nivImbrication = niveau;
    }
    public void incrementNiveauImbrication() {
        this.nivImbrication++;
    }
    public void setTableauParcouru(String tableName){ this.tableauParcouru = tableName; }
    public void setVarLocaleAssigneParBoucle(String varLocale){ this.varlocaleAssigneeParBoucle = varLocale; }
    public void setIsTailleTableauModif(boolean isTabModif){ this.isTailleTableauModified = isTabModif; }
    public void setIsVarLocDefDansBoucle(boolean isVarLocDef){ this.isVarLocDefinedDansBoucle = isVarLocDef; }
    public void setIsVarLocDefDansBoucle(String varLocale) { this.isVarLocDefinedDansBoucle = this.varGlobalesAvantBoucle.contains(varLocale); }
    public void setParentInfo(ForLoopInformation parent){
        this.parentInfo.autresVarLocDsBoucle = parent.autresVarLocDsBoucle;
        this.parentInfo.isTailleTableauModified = parent.isTailleTableauModified;
        this.parentInfo.isVarLocDefinedDansBoucle = parent.isVarLocDefinedDansBoucle;
        this.parentInfo.nivImbrication = parent.nivImbrication;
        this.parentInfo.varGlobalesAvantBoucle = parent.varGlobalesAvantBoucle;

    }
    /* Accessors */
    public int getNivImbrication() { return this.nivImbrication; }
    public  String getTableauParcouru() { return this.tableauParcouru; }
    public ArrayList<String> getVarGlobalesAvantBoucle() { return this.varGlobalesAvantBoucle; }
    public String getVarlocaleAssigneeParBoucle() { return this.varlocaleAssigneeParBoucle; }
    public ArrayList<String> getAutresVarLocDsBoucle() { return this.autresVarLocDsBoucle; }
    public ArrayList<String> getVarRedefDansBoucle() { return this.varRedefDansBoucle; }
    public ArrayList<String> getVarRequiseParBoucle() { return this.varRequiseParBoucle; }
    public boolean getIsTailleTableauModified() { return this.isTailleTableauModified; }
    public boolean getIsVarLocDefinedDansBoucle() { return this.isVarLocDefinedDansBoucle; }

    /* Add an element or a list of elements in any ArrayLyst parameters */
    public void addVarGlobalesAvantBoucles(String varGlobale){
        if(!this.varGlobalesAvantBoucle.contains(varGlobale)) {
            this.varGlobalesAvantBoucle.add(varGlobale);
        }
    }
    public void addVarGlobalesAvantBoucles(List<String> varGlobales){

        for (String variable: varGlobales) {
            if(!this.varGlobalesAvantBoucle.contains(variable)) {
                this.varGlobalesAvantBoucle.add(variable);
            }
        }

    }
    public void removeVarGlobalesAvantBoucles() { this.varGlobalesAvantBoucle.clear(); }

    public void addAutreVarLocDsBoucle(String varLocale){
        if(!this.autresVarLocDsBoucle.contains(varLocale)) {
            this.autresVarLocDsBoucle.add(varLocale);
        }
    }
    public void addAutreVarLocDsBoucle(List<String> varLocales){
       for(String variable : varLocales) {
           if(!this.autresVarLocDsBoucle.contains(variable)) {
               this.autresVarLocDsBoucle.add(variable);
           }
       }
    }
    public void addVarRedefDansBoucle(String varRedefinie){
        if(!this.varRedefDansBoucle.contains(varRedefinie)) {
            this.varRedefDansBoucle.add(varRedefinie);
        }
    }
    public void addVarRedefDansBoucle(List<String> varRedefinies){
        for(String variable : varRedefinies) {
            if(!this.varRedefDansBoucle.contains(variable)) {
                this.varRedefDansBoucle.add(variable);
            }
        }
    }
    public void addVarRequiseParBoucle(String varRequise){
        if(!this.varRequiseParBoucle.contains(varRequise)) {
            this.varRequiseParBoucle.add(varRequise);
        }
    }
    public void addVarRequiseParBoucle(List<String>  varRequises){
        for(String variable : varRequises) {
            if(!varRequiseParBoucle.contains(variable)) {
                this.varRequiseParBoucle.add(variable);
            }
        }
    }
    public void addVarDefDansInnerBoucle(List<String>  innerVar){
        for(String variable : innerVar) {
            if(!varDefDansInnerBoucle.contains(variable)) {
                this.varDefDansInnerBoucle.add(variable);
            }
        }
    }
    public List<String> getVarDefDansInnerBoucle(){
        return varDefDansInnerBoucle;
    }
    public void addVarDefDansInnerBoucle(String  innerVar) {
        if (!varDefDansInnerBoucle.contains(innerVar)) {
            this.varDefDansInnerBoucle.add(innerVar);
        }

    }
}
