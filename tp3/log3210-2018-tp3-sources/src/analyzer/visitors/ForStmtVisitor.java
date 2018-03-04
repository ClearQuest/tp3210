package analyzer.visitors;

import analyzer.ast.*;
import java.util.ArrayList;

import java.io.PrintWriter;

public class ForStmtVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private int m_currentNumber = 0;
    private ArrayList<ForLoopInformation> forLoopInformationList;
    private ArrayList<String> listeVariablesGlobales;

    public ForStmtVisitor(PrintWriter writer) {
        this.m_writer = writer;
        this.forLoopInformationList = new ArrayList<>();
        this.listeVariablesGlobales = new ArrayList<>();
    }

    /* Every nodes */
    @Override
    public Object visit(SimpleNode node, Object data) { return data; }

    @Override
    public Object visit(ASTProgram node, Object data) {
        /* First node: Start symbol */
        assignNumber(node);

        ForLoopInformation info = new ForLoopInformation();
        info.setNivImbrication(0);
        data = info;
        node.childrenAccept(this, data);

        /* Remove var glob leaving boucle */
        for (int i = 1; i < this.forLoopInformationList.size(); i++) {
            if (this.forLoopInformationList.get(i).getNivImbrication() < this.forLoopInformationList.get(i-1).getNivImbrication()) {
                /* Si on a quitté une boucle for */
                ArrayList<String> premierNiv = new ArrayList<String>();
                ArrayList<String> dernierNiv = new ArrayList<String>();
                ArrayList<String> ensembleASupprimer = new ArrayList<String>();

                if (this.forLoopInformationList.get(i-1).getNivImbrication() == 3) {
                    premierNiv = this.forLoopInformationList.get(i-3).getVarGlobalesAvantBoucle();
                }
                else if (this.forLoopInformationList.get(i-1).getNivImbrication() == 2) {
                    premierNiv = this.forLoopInformationList.get(i-2).getVarGlobalesAvantBoucle();
                }
                else {}
                dernierNiv = this.forLoopInformationList.get(i-1).getVarGlobalesAvantBoucle();

                for (int k = 0; k < dernierNiv.size(); k++) {
                    if (!premierNiv.contains(dernierNiv.get(k))) {
                        this.forLoopInformationList.get(i).removeVarGlobaleAvantBoucles(dernierNiv.get(k));
                        this.forLoopInformationList.get(i+1).removeVarGlobaleAvantBoucles(dernierNiv.get(k));
                    }
                }
            }
        }


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

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTStmt node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTIntAssignStmt node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTFloatAssignStmt node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTArrayAssignStmt node, Object data) {
        assignNumber(node);

        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(ASTForStmt node, Object data) {
        assignNumber(node);

        ForLoopInformation info = new ForLoopInformation();
        info = (ForLoopInformation)data;

        if (this.forLoopInformationList.size() == 0) {
            info.setNivImbrication(1);
        }
        else if(node.jjtGetParent().jjtGetParent().jjtGetParent().getClass() == ASTForStmt.class) {
            ASTForStmt parentNode = (ASTForStmt)node.jjtGetParent().jjtGetParent().jjtGetParent();
            info.setNivImbrication(parentNode.getForLoopInformation().nivImbrication+1);
        }
        else {
            // Do nothing: (info.setNivImbrication(0);)
        }

        node.setForLoopInformation(info);
        this.forLoopInformationList.add(info);
        this.addVarGlobaleToList(node.getForLoopInformation().getVarGlobalesAvantBoucle());

        data = info;
        data = node.childrenAccept(this, data);
        /* On sort du for loop ici */
        info.removeVarGlobalesAvantBoucles();
        info.addVarGlobalesAvantBoucles(this.listeVariablesGlobales);
        info.nivImbrication = 1;
        node.setForLoopInformation(info);

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

        /***************** OLD ****************/

        /* TO CLEAN */

        if (node.jjtGetParent().getClass() != ASTFctStmt.class) {
            if (node.jjtGetParent().getClass() == ASTForStmt.class) {
                String varLocale = node.getValue().toString();

                ForLoopInformation newFoorLoop = new ForLoopInformation(this.forLoopInformationList.get(this.forLoopInformationList.size()-1));
                newFoorLoop.setVarLocaleAssigneParBoucle(varLocale);
                this.forLoopInformationList.set(this.forLoopInformationList.size()-1, newFoorLoop);
            }
            else if (node.jjtGetParent().getClass() == ASTArrayBasicExpr.class) {
                if (node.jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent().jjtGetParent().getClass() == ASTForStmt.class) {
                    String varLocale = node.getValue().toString();
                    ForLoopInformation newFoorLoop = new ForLoopInformation(this.forLoopInformationList.get(this.forLoopInformationList.size()-1));
                    newFoorLoop.setTableauParcouru(varLocale);
                    this.forLoopInformationList.set(this.forLoopInformationList.size()-1, newFoorLoop);
                }
            }
            else{
                // Do nothing for now
                //this.addVarGlobaleToList(node.getValue().toString());
            }
        }

        ForLoopInformation info = new ForLoopInformation();
        info = (ForLoopInformation)data;
        if(!info.getVarGlobalesAvantBoucle().contains(node.getValue().toString())) {
            if(node.getValue().toString() != info.getVarlocaleAssigneeParBoucle()) {
                info.addVarGlobalesAvantBoucles(node.getValue().toString());
                //this.addVarGlobaleToList(node.getValue().toString());
            }
        }

        // this.addVarGlobaleToList(node.getValue().toString());

        node.childrenAccept(this, data);


        //node.childrenAccept(this, data);
        /***************** NEW ****************/

        return data;
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

    private void addVarGlobaleToList(String str) {

        if(!this.listeVariablesGlobales.contains(str)) {
            this.listeVariablesGlobales.add(str);
        }
        else {
            // Do nothing
        }
    }

    private void addVarGlobaleToList(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!this.listeVariablesGlobales.contains(list.get(i))) {
                this.listeVariablesGlobales.add(list.get(i));
            }
        }
    }
}