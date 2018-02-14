package analyzer.visitors;

import analyzer.ast.*;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created: 17-08-02
 * Last Changed: 17-08-02
 * Author: Nicolas Cloutier
 *
 * Description: This visitor explore the AST
 * and "pretty" print the code.
 */

public class PrintVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    int value = 0;
    private String m_indent;

    public PrintVisitor(PrintWriter writer) {
        m_writer = writer;
        m_indent = "";
    }

    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTProgram node, Object data) {
        // Production: Program -> (DeclareStmt;)* Block
        for(int i = 0; i < node.jjtGetNumChildren(); i++) {
            node.jjtGetChild(i).jjtAccept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(ASTBlock node, Object data) {
        // Production: Block -> Stmt*
        node.childrenAccept(this, null);
        return null;
    }

    @Override
    public Object visit(ASTStmt node, Object data) {
        // Production: Stmt -> AssignStmt ;
        if(node.jjtGetChild(0).getClass() == ASTAssignStmt.class) {
            //m_writer.print(m_indent);
            node.jjtGetChild(0).jjtAccept(this, null);
           // m_writer.println(";");
            return null;
        }


        else {
            throw new RuntimeException("Unexpected child");
        }
    }



    @Override
    public Object visit(ASTAssignStmt node, Object data) {
        // Production: AssignStmt -> (Id AssignOp)+ OrExpr
        node.jjtGetChild(0).jjtAccept(this, null);
        for(int i = 1; i < node.jjtGetNumChildren(); i++) {
           // m_writer.print(node.getOps().get(i-1));
            node.jjtGetChild(i).jjtAccept(this, null);
        }
        ArrayList<String> list = node.reduce();
        for(int i =0; i<list.size();i++){
            if(i == 0){
                m_writer.print(list.get(i) + "=");
            }
            else
                m_writer.print(list.get(i));
        }
        m_writer.print(";\n");
        return null;
    }

    @Override
    public Object visit(ASTAddExpr node, Object data) {

        // Production: AddExpr -> MultExpr ( Op MultExpr )*
        node.jjtGetChild(0).jjtAccept(this, null);
        for(int i = 1; i < node.jjtGetNumChildren(); i++) {
           // m_writer.print(node.getOps().get(i - 1));
            node.jjtGetChild(i).jjtAccept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(ASTMultExpr node, Object data) {

        // Production: MultExpr -> PowExpr ( Op PowExpr )*
        node.jjtGetChild(0).jjtAccept(this, null);
        for(int i = 1; i < node.jjtGetNumChildren(); i++) {
            //m_writer.print(node.getOps().get(i - 1));
            node.jjtGetChild(i).jjtAccept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(ASTUnaryOpExpr node, Object data) {
        // Production: NegExpr -> UnaryOp BasicExpr

        if(!node.getOps().isEmpty()) {
            for(int i = 0; i < node.getOps().size(); i++) {
                //m_writer.print("-");
            }
            return node.jjtGetChild(0).jjtAccept(this, data);
        }
        // Production: NegExpr -> BasicExpr
        else {
            return node.jjtGetChild(0).jjtAccept(this, data);
        }
    }

    @Override
    public Object visit(ASTBasicExpr node, Object data) {

        if(node.jjtGetChild(0).getClass() == ASTIdentifier.class) {
            return node.jjtGetChild(0).jjtAccept(this, data);
        }

        // Production: BasicExpr -> Int
        else if(node.jjtGetChild(0).getClass() == ASTIntValue.class) {
            return node.jjtGetChild(0).jjtAccept(this, data);
        }

        else if(node.jjtGetChild(0).getClass() == ASTAddExpr.class) {
            //m_writer.print("(");
            node.jjtGetChild(0).jjtAccept(this, data);
            //m_writer.print(")");
            return null;
        }

        else {
            throw new RuntimeException("Unexpected child");
        }
    }


    @Override
    public Object visit(ASTIdentifier node, Object data) {
        // Production: Id -> letter ( letter | digit )*
        //.print(node.getValue());

        return node.getValue();
    }

    @Override
    public Object visit(ASTIntValue node, Object data) {
        // Production: Int -> integer
       // m_writer.print(node.getValue());

        return node.getValue();
    }

}