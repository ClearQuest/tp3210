package analyzer.ast;/* Generated By:JJTree: Do not edit this line. ASTAssignStmt.java */

import java.util.ArrayList;
import java.util.Vector;

public class ASTAssignStmt extends SimpleNode {
  public ASTAssignStmt(int id) {
    super(id);
  }
  public ASTAssignStmt(ASTAssignStmt aStmt){super (aStmt.id);}
  public ASTAssignStmt(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

public ArrayList<String> reduce(){
    ArrayList<String> s = new ArrayList<>();

    if(this.jjtGetChild(0) instanceof ASTIdentifier) {
        ASTIdentifier tempNode = new ASTIdentifier();
        tempNode = (ASTIdentifier)jjtGetChild(0);
        s.add(tempNode.reduce().get(0)); //identifier
    }

    for(int i = 1; i<this.jjtGetNumChildren(); i++) {
        if(this.jjtGetChild(i) instanceof ASTAddExpr) {
            ASTAddExpr tempNode = new ASTAddExpr((ASTAddExpr)this.jjtGetChild(i));
            ArrayList<String> bob = tempNode.reduce();
            String temp ="";
            for(int j = 0; j<bob.size(); j++){
                temp += bob.get(j);
            }
            s.add(temp); //identifier
        }
        //s.addAll(this.jjtGetChild(1).reduce());
    }
    return s;
}
  // PLB
  private Vector<String> m_ops = new Vector<>();
  public void addOp(String o) { m_ops.add(o); }
  public Vector getOps() { return m_ops; }
}
