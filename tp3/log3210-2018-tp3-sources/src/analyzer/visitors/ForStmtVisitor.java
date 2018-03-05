package analyzer.visitors;

import analyzer.ast.*;
import java.util.ArrayList;

import java.io.PrintWriter;

public class ForStmtVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private int m_currentNumber = 0;
    private ArrayList<ForLoopInformation> forLoopInformationList;
   // private ArrayList<String> listeVariablesGlobales;

    public ForStmtVisitor(PrintWriter writer) {
        this.m_writer = writer;
        this.forLoopInformationList = new ArrayList<>();
        //his.listeVariablesGlobales = new ArrayList<>();
    }

    /* Every nodes */
    @Override
    public Object visit(SimpleNode node, Object data) { return data; }

    @Override
    public Object visit(ASTProgram node, Object data) {
        /* First node: Start symbol */
        assignNumber(node);

        //ForLoopInformation info = new ForLoopInformation();
        //info.setNivImbrication(0);
       // data = info;
        node.childrenAccept(this, data);

        for (int i = 0; i < this.forLoopInformationList.size(); i++) {
            String forLoopResult = new String();
            if(forLoopInformationList.get(i).getVarDefDansInnerBoucle() != null) {
                forLoopInformationList.get(i).addAutreVarLocDsBoucle(forLoopInformationList.get(i).getVarDefDansInnerBoucle());
            }
            forLoopResult = forLoopInformationList.get(i).getAllInformationPrintable();
            m_writer.println(forLoopResult);
        }
        return data;
    }

    @Override
    public Object visit(ASTBlock node, Object data) {

        assignNumber(node);
        if (node.jjtGetParent() instanceof ASTForStmt) {
            ASTForStmt parent = (ASTForStmt) node.jjtGetParent();
            ASTBlock grandDad = parent.getParentBlock();
            String varLocale = ((ASTIdentifier) parent.jjtGetChild(0)).getValue().toString();
            node.information.setNivImbrication(grandDad.information.getNivImbrication() + 1);
            node.information.setVarLocaleAssigneParBoucle(varLocale);

            node.information.addVarGlobalesAvantBoucles(grandDad.information.getAutresVarLocDsBoucle());
            node.information.addVarGlobalesAvantBoucles(grandDad.information.getVarGlobalesAvantBoucle());

            if (grandDad.information.getVarlocaleAssigneeParBoucle() != ""){
                node.information.addVarGlobalesAvantBoucles(grandDad.information.getVarlocaleAssigneeParBoucle());
            }
            if(!forLoopInformationList.contains(node.information)){
            forLoopInformationList.add(node.information);}
        }

        Object bob = node.childrenAccept(this, node.information);

        if (node.jjtGetParent() instanceof ASTForStmt) {


            ASTForStmt parent = (ASTForStmt)node.jjtGetParent();
            ASTBlock grandDad = parent.getParentBlock();

            node.information.setTableauParcouru(grandDad.information.getTableauParcouru());




            //variables redefinies
            for(String element : node.information.getAutresVarLocDsBoucle()){
                if(node.information.getVarGlobalesAvantBoucle().contains(element)
                        || node.information.getVarlocaleAssigneeParBoucle().equals(element)
                        || node.information.getTableauParcouru().equals(element)){
                    node.information.addVarRedefDansBoucle(element);
                }
            }


            //retire superflu de variables locales
            for (String variable: node.information.getVarGlobalesAvantBoucle()) {
                node.information.getAutresVarLocDsBoucle().remove(variable);
            }
            node.information.getAutresVarLocDsBoucle().remove(node.information.getVarlocaleAssigneeParBoucle());
            //variables dans boucles imbriquées
            grandDad.information.addVarDefDansInnerBoucle(node.information.getAutresVarLocDsBoucle());
            grandDad.information.addVarDefDansInnerBoucle(node.information.getVarDefDansInnerBoucle());


        }

        return data;
    }

    @Override
    public Object visit(ASTStmt node, Object data) {
        assignNumber(node);

        Object identifier =  node.childrenAccept(this, data);
         if(node.jjtGetParent() instanceof ASTBlock && identifier instanceof String){
             ASTBlock parent =  (ASTBlock)node.jjtGetParent();
             parent.information.addAutreVarLocDsBoucle((String)identifier);
         }

        return identifier;
    }

    @Override
    public Object visit(ASTIntAssignStmt node, Object data) {
        assignNumber(node);

        Object identifier = node.childrenAccept(this, data);
        return identifier;
    }

    @Override
    public Object visit(ASTFloatAssignStmt node, Object data) {
        assignNumber(node);

        Object identifier = node.childrenAccept(this, data);
        return identifier;
    }

    @Override
    public Object visit(ASTArrayAssignStmt node, Object data) {
        assignNumber(node);

        Object identifier = node.childrenAccept(this, data);
        return identifier;
    }

    @Override
    public Object visit(ASTForStmt node, Object data) {
        assignNumber(node);

        Object Identifier = node.childrenAccept(this, data);
        /* On sort du for loop ici */

        return data;
    }

    @Override
    public Object visit(ASTExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIntAddExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIntMultExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIntUnaryOpExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIntBasicExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFloatAddExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFloatMultExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFloatUnaryOpExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFloatBasicExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayContExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTArrayRepExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayInvExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayBasicExpr node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayAccess node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFctStmt node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIdentifier node, Object data) {
        assignNumber(node);
        String identifier = "";

         if (node.jjtGetParent().getClass() != ASTFctStmt.class && ! (node.jjtGetParent().getClass() == ASTForStmt.class) && node.jjtGetParent().getClass() == ASTArrayBasicExpr.class) {
            if (node.jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent().getClass() == ASTForStmt.class) {
                String tableId = node.getValue().toString(); //parsed table name
                ((ForLoopInformation)data).setTableauParcouru( tableId);
            }
        }



        node.childrenAccept(this, data);
        identifier = node.getValue().toString();


        return identifier;
    }

    @Override
    public Object visit(ASTIntValue node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTRealValue node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayValue node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    private void assignNumber(SimpleNode node) {
        node.setNumber(m_currentNumber);
        m_currentNumber++;
    }

    public ArrayList<String> addVarToList(String var, ArrayList<String> ensemble) {
        if (!ensemble.contains(var)) {
            ensemble.add(var);
        }
        return ensemble;
    }

  /*  private void addVarGlobaleToList(String str) {

       if(!this.listeVariablesGlobales.contains(str)) {
            this.listeVariablesGlobales.add(str);
        }
        else {
            // Do nothing
        }
    }*/

    /*private void addVarGlobaleToList(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!this.listeVariablesGlobales.contains(list.get(i))) {
                this.listeVariablesGlobales.add(list.get(i));
            }
        }
    }*/
}