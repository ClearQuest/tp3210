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
    public Object visit(ASTAssignStmt node, Object data) {
        assignNumber(node);
        return null;
    }



    @Override
    public Object visit(ASTAddExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTMultExpr node, Object data) {
        assignNumber(node);
        return null;
    }



    @Override
    public Object visit(ASTUnaryOpExpr node, Object data) {
        assignNumber(node);
        return null;
    }

    @Override
    public Object visit(ASTBasicExpr node, Object data) {
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



    private void assignNumber(SimpleNode node) {
        node.setNumber(m_currentNumber);
        m_currentNumber++;
    }
}
