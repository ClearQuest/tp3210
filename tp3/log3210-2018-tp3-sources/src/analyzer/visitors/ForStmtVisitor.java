package analyzer.visitors;

import analyzer.ast.*;
import java.util.ArrayList;

import java.io.PrintWriter;

public class ForStmtVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private int m_currentNumber = 0;
    private ArrayList<ForLoopInformation> forLoopInformationList;
    private ArrayList<String> allVarGlobale;
    private Boolean isInsideForStmt = false;
    private int profondeur = 0;

    public ForStmtVisitor(PrintWriter writer) {
        this.m_writer = writer;
        this.forLoopInformationList = new ArrayList<>();
        this.allVarGlobale = new ArrayList<>();
    }

    /* Every nodes */
    @Override
    public Object visit(SimpleNode node, Object data) { return data; }

    @Override
    public Object visit(ASTProgram node, Object data) {

        /* First node: Start symbol */
        assignNumber(node);
        data = 0; // Utile pour les couches ?

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
        info.addVarGlobalesAvantBoucles(this.allVarGlobale);
        data = (int)data+1;
        int couche = (int)data;
        info.setNivImbrication(couche);

        this.forLoopInformationList.add(info);

        node.childrenAccept(this, data);

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
                this.addVarGlobaleToList(node.getValue().toString());
            }
        }


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

    private void addVarGlobaleToList(String str) {
        if(!this.allVarGlobale.contains(str)) {
            this.allVarGlobale.add(str);
        }
        else {
            // Do nothing
        }
    }
}