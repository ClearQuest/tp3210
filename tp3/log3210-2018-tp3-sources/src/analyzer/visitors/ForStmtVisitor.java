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
        // listeVariablesGlobales = new ArrayList<>();
    }

    /* Every nodes */
    @Override
    public Object visit(SimpleNode node, Object data) { return data; }

    @Override
    public Object visit(ASTProgram node, Object data) {

        /* First node: Start symbol */
        assignNumber(node);
        //data = 0; // Utile pour les couches ?

        ForLoopInformation info = new ForLoopInformation();
        info.setNivImbrication(1);
        data = info;
        node.childrenAccept(this, data);

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
        //info.addVarGlobalesAvantBoucles(this.listeVariablesGlobales);

        if(node.jjtGetParent().jjtGetParent().jjtGetParent().getClass() == ASTForStmt.class) {
            ASTForStmt parentNode = (ASTForStmt)node.jjtGetParent().jjtGetParent().jjtGetParent();
            info.setNivImbrication(parentNode.getForLoopInformation().nivImbrication+1);
        }

        node.setForLoopInformation(info);
        this.forLoopInformationList.add(info);

        data = info;
        node.childrenAccept(this, data);

        /* On sort du for loop ici */
        info.removeVarGlobalesAvantBoucles();
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
            }
        }

                // this.addVarGlobaleToList(node.getValue().toString());
        node.childrenAccept(this, data);

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

    /*
    private void addVarGlobaleToList(String str) {

        if(!this.listeVariablesGlobales.contains(str)) {
            this.listeVariablesGlobales.add(str);
        }
        else {
            // Do nothing
        }
    }
    */
}