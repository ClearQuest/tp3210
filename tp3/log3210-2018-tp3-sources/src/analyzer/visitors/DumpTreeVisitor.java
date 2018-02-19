package analyzer.visitors;

import analyzer.ast.*;

import java.io.PrintWriter;

public class DumpTreeVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private int m_currentNumber = 0;

    public DumpTreeVisitor(PrintWriter writer) {
        m_writer = writer;
    }

    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTProgram node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTBlock node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTStmt node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTIntAssignStmt node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTFloatAssignStmt node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTArrayAssignStmt node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTForStmt node, Object data) {
        assignNumber(node);
        return null;
    }



    @Override
    public Object visit(ASTExpr node, Object data) {
        assignNumber(node);
        return null;
    }



    @Override
    public Object visit(ASTIntAddExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTIntMultExpr node, Object data) {
        assignNumber(node);
        return null;
    }


    @Override
    public Object visit(ASTIntUnaryOpExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTIntBasicExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTFloatAddExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTFloatMultExpr node, Object data) {
        assignNumber(node);
        return null;
    }


    @Override
    public Object visit(ASTFloatUnaryOpExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTFloatBasicExpr node, Object data) {
        assignNumber(node);
        return null;
    }



    @Override
    public Object visit(ASTArrayContExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTArrayRepExpr node, Object data) {
        assignNumber(node);
        return null;
    }


    @Override
    public Object visit(ASTArrayInvExpr node, Object data) {
        assignNumber(node);
        return null;
    }


    @Override
    public Object visit(ASTArrayBasicExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTArrayAccess node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTFctStmt node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTIdentifier node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTIntValue node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTRealValue node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTArrayValue node, Object data) {
        assignNumber(node);
        return null;
    }


    private void assignNumber(SimpleNode node) {
        node.setNumber(m_currentNumber);
        m_currentNumber++;
    }
}
