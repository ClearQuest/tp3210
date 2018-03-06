package analyzer.visitors;

import analyzer.ast.*;
import java.util.ArrayList;

import java.io.PrintWriter;

public class ForStmtVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private int m_currentNumber = 0;
    private ArrayList<ForLoopInformation> forLoopInformationList;


    public ForStmtVisitor(PrintWriter writer) {
        this.m_writer = writer;
        this.forLoopInformationList = new ArrayList<>();

    }

    /* Every nodes */
    @Override
    public Object visit(SimpleNode node, Object data) { return data; }

    @Override
    public Object visit(ASTProgram node, Object data) {
        /* First node: Start symbol */
        assignNumber(node);

        node.childrenAccept(this, data);

        //MODIFICATIONS
        for (int i = 0; i < this.forLoopInformationList.size(); i++) {
            ForLoopInformation current = forLoopInformationList.get(i);
            //set autres variables locales définie dans des boucles internes
            if(current.getVarDefDansInnerBoucle() != null) {
                current.addAutreVarLocDsBoucle(current.getVarDefDansInnerBoucle());
            }
            //change variable de aparcour par nom du tableau dans les variables redefinies si c'est le cas

            if(current.getVarRedefDansBoucle().contains(current.getVarlocaleAssigneeParBoucle())){
                current.getVarRedefDansBoucle().remove(current.getVarlocaleAssigneeParBoucle());
                current.addVarRedefDansBoucle(current.getTableauParcouru());
            }

            current.getVarRequiseParBoucle().remove(current.getVarlocaleAssigneeParBoucle());

            current.getVarRequiseParBoucle().removeAll(current.getAutresVarLocDsBoucle());
            current.addVarRequiseParBoucle(current.getTableauParcouru());
            current.getVarRequiseParBoucle().removeAll(current.getNomTableauImbriques());

        }

        //PRINT

        for (int i = 0; i < this.forLoopInformationList.size(); i++) {
            String forLoopResult = new String();
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

            grandDad.information.addVarRedefDansBoucle(node.information.getVarRedefDansBoucle());

            //retire superflu de variables locales
            for (String variable: node.information.getVarGlobalesAvantBoucle()) {
                node.information.getAutresVarLocDsBoucle().remove(variable);
            }
            node.information.getAutresVarLocDsBoucle().remove(node.information.getVarlocaleAssigneeParBoucle());

            //variables dans boucles imbriquées. utilisées pour setter les variables locales
            grandDad.information.addVarDefDansInnerBoucle(node.information.getAutresVarLocDsBoucle());
            grandDad.information.addVarDefDansInnerBoucle(node.information.getVarDefDansInnerBoucle());

            //Variable requises
            ArrayList<String> tempGranddadVarRequises = new ArrayList<String>();
            tempGranddadVarRequises.addAll(node.information.getVarRequiseParBoucle());
            tempGranddadVarRequises.remove(node.information.getVarlocaleAssigneeParBoucle());
            grandDad.information.addVarRequiseParBoucle(tempGranddadVarRequises);
            node.information.addNomTableauImbriques(node.information.getVarlocaleAssigneeParBoucle());
            grandDad.information.addNomTableauImbriques(node.information.getNomTableauImbriques());

            if(node.information.getListTableauxModifiés().contains(node.information.getTableauParcouru())){
                node.information.setIsTailleTableauModif(true);
            }

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
       // arraybasicExpr doesnt bubble up ok  if(node.jjtGetChild())
        return identifier;
    }

    @Override
    public Object visit(ASTArrayAssignStmt node, Object data) {
        assignNumber(node);

        Object identifier = node.childrenAccept(this, data);
        if(data instanceof ForLoopInformation && identifier instanceof String){
            if(node.jjtGetParent().jjtGetParent() instanceof ASTBlock){
                ((ASTBlock)node.jjtGetParent().jjtGetParent()).information.addListTableauxModifies((String)identifier);
            }
        }
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

        Object identifier = node.childrenAccept(this, data);
        if(data instanceof ForLoopInformation && identifier instanceof  String) {
            if (node.jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent() instanceof ASTBlock) {
                ASTBlock parentBlock = (ASTBlock) node.jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent();
                parentBlock.information.addAutreVarLocDsBoucle((String) identifier);
            }
        }
        //return data;
        return identifier;
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
                ((ForLoopInformation)data).setTableauParcouru(tableId);
                return null;
            }

        }

             node.childrenAccept(this, data);
             identifier = node.getValue().toString();

             if (data instanceof ForLoopInformation && !(node.jjtGetParent() instanceof ASTFctStmt)) {
                 // for(int i = 0;i<node.jjtGetNumChildren();i++) {
                 ((ForLoopInformation)data).addVarRequiseParBoucle(identifier);//add var req to parent instead

                 // }
             }


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