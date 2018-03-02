package analyzer.visitors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clque on 18-03-01.
 */
public class ForLoopInformation {

    /* Proprierties to print (In order) */
    int nivImbrication;                             // #1: Le niveau d’imbrication de la boucle
    String tableauParcouru;                         // #2: Le tableau parcouru
    ArrayList<String> varGlobalesAvantBoucle;       // #3: Les variables globales définies avant la boucle
    String varlocaleAssigneeParBoucle;              // #4: La variable locale assignée par la boucle
    ArrayList<String> autresVarLocDsBoucle;         // #5: Les autres variables locales définies dans la boucle
    ArrayList<String> varRedefDansBoucle;           // #6: Les variables redéfinies par la boucle (sauf locales)
    ArrayList<String> varRequiseParBoucle;          // #7: Les variables requises par la boucle (sauf locales)
    boolean isTailleTableauModified;                // #8: Un booléen indiquant si la taille du tableau parcouru est modifiée pendant la boucle
    boolean isVarLocDefinedDansBoucle;              // #9: Un booléen indiquant si la variable locale a déjà été définie en dehors de la boucle

    /* Constructors */
    public ForLoopInformation() {
        this.nivImbrication = 1;
        this.tableauParcouru = "";
        this.varGlobalesAvantBoucle = new ArrayList<String>();
        this.varlocaleAssigneeParBoucle = "";
        this.autresVarLocDsBoucle = new ArrayList<String>();
        this.varRedefDansBoucle = new ArrayList<String>();
        this.varRequiseParBoucle = new ArrayList<String>();
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
    public void addVarGlobalesAvantBoucles(String varGlobale){ this.varGlobalesAvantBoucle.add(varGlobale); }
    public void addVarGlobalesAvantBoucles(List<String> varGlobales){ this.varGlobalesAvantBoucle.addAll(varGlobales); }
    public void removeVarGlobalesAvantBoucles() { this.varGlobalesAvantBoucle.clear(); }
    public void addAutreVarLocDsBoucle(String varLocale){
        this.autresVarLocDsBoucle.add(varLocale);
    }
    public void addAutreVarLocDsBoucle(List<String> varLocales){
        this.autresVarLocDsBoucle.addAll(varLocales);
    }
    public void addVarRedefDansBoucle(String varRedefinie){
        this.varRedefDansBoucle.add(varRedefinie);
    }
    public void addVarRedefDansBoucle(List<String> varRedefinies){
        this.varRedefDansBoucle.addAll(varRedefinies);
    }
    public void addVarRequiseParBoucle(String varRequise){
        this.varRequiseParBoucle.add(varRequise);
    }
    public void addVarRequiseParBoucle(List<String>  varRequises){
        this.varRequiseParBoucle.addAll(varRequises);
    }
}
