package analyzer.visitors;

import analyzer.ast.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CounterVisitor implements ParserVisitor {

    private final PrintWriter m_writer;
    private Integer m_assCounter;
    private Integer m_opCounter;
    private ArrayList<String>  m_varDefinie;
    private ArrayList<String> m_varRequises;
    private ArrayList<String> m_varSeen;
    private String m_currentIdAssignation;
    private boolean varSeenIsAssigned;
    private int m_currentNumber = 0;
    private boolean alreadyAssigned;

    public CounterVisitor(PrintWriter writer) {
        m_writer = writer;
        m_assCounter = 0;
        m_opCounter = 0;
        m_varRequises = new ArrayList<>();
        m_varSeen = new ArrayList<>();
        m_varDefinie = new ArrayList<>();
        m_currentIdAssignation = "";
        varSeenIsAssigned = false;
        alreadyAssigned = false;
    }

    @Override
    public Object visit(SimpleNode node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTProgram node, Object data) {
        doDefault(node);

        for (String id:m_varSeen) {
            if(!m_varDefinie.contains(id)){
                m_varRequises.add(id);
            }
        }
        m_writer.println("assignations : " + m_assCounter+';');
        m_writer.println("operations : " + m_opCounter+';');

        m_writer.print("variables requises : ");

        for(int i =0; i<m_varRequises.size();i++){
            if(i<m_varRequises.size()-1){
                m_writer.print(m_varRequises.get(i)+", ");
            }
            else{
                m_writer.print(m_varRequises.get(i)+";\n");
            }
        }
        m_writer.print("variables definies : ");
        for(int i = 0; i<m_varDefinie.size();i++){
            if(i<m_varDefinie.size()-1){
                m_writer.print(m_varDefinie.get(i) +", ");
            }
            else{
                m_writer.print(m_varDefinie.get(i)+";");
            }
        }

        return null;
    }

    @Override
    public Object visit(ASTBlock node, Object data) {
        doDefault(node);

        return null;
    }

    @Override
    public Object visit(ASTStmt node, Object data) {
        if( node.jjtGetChild(0).jjtGetChild(0) instanceof ASTIdentifier ) {
            String idName = ((ASTIdentifier) node.jjtGetChild(0).jjtGetChild(0)).getValue();
            if (m_varDefinie.contains(idName)) {
                alreadyAssigned = true;
            }
            else {
                m_varDefinie.add(idName);
                alreadyAssigned = false;
            }
            m_currentIdAssignation = idName;
            varSeenIsAssigned = true;
        }
        doDefault(node);

        return null;

    }

    @Override
    public Object visit(ASTAssignStmt node, Object data) {
        m_assCounter++;
        doDefault(node);
        return null;
    }



    @Override
    public Object visit(ASTAddExpr node, Object data) {
        doDefault(node);
        m_opCounter ++;
        return null;
    }

    @Override
    public Object visit(ASTMultExpr node, Object data) {
        doDefault(node);
        return null;
    }


    @Override
    public Object visit(ASTUnaryOpExpr node, Object data) {
        doDefault(node);
        return null;
    }

    @Override
    public Object visit(ASTBasicExpr node, Object data) {
        doDefault(node);
        return null;
    }


    @Override
    public Object visit(ASTIdentifier node, Object data) {
        String current = node.getValue();
        if (!m_varRequises.contains(current)) {
            boolean idOnBothSides = (current.equals(m_currentIdAssignation) && !varSeenIsAssigned && !alreadyAssigned); //and not assigned at prev step
            if ((!m_varDefinie.contains(current) && !varSeenIsAssigned) || idOnBothSides) {
                m_varRequises.add(current);
            }
        }
        varSeenIsAssigned = false;
        doDefault(node);//

        return null;
    }

    @Override
    public Object visit(ASTIntValue node, Object data) {
        doDefault(node);
        return null;
    }



    private void assignNumber(SimpleNode node) {
        node.setNumber(m_currentNumber);
        m_currentNumber++;
    }

    private void doDefault(SimpleNode node) {
        assignNumber(node);
        node.childrenAccept(this, null);
    }
}
