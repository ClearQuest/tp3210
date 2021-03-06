/* Generated By:JJTree: Do not edit this line. ASTUnaryOpExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

import java.util.ArrayList;
import java.util.Vector; // PLB

public
class ASTUnaryOpExpr extends SimpleNode {
  public ASTUnaryOpExpr(int id) {
    super(id);
  }
  public ASTUnaryOpExpr(ASTUnaryOpExpr uOpExpr){
      this.parser = uOpExpr.parser;
      this.children = uOpExpr.children;
      this.id = uOpExpr.id;
      this.parent = uOpExpr.parent;
      this.value = uOpExpr.value;

  }
  public ASTUnaryOpExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }

    public ArrayList<String> reduce(){
        ArrayList<String> negArray = new ArrayList<>();
        if(this.jjtGetChild(0) instanceof  ASTBasicExpr) {
            ASTBasicExpr temp = (ASTBasicExpr)this.jjtGetChild(0);
            ArrayList<String> steve = temp.reduce();

            //positive
            if (this.m_ops.size() % 2 == 0) {
                return steve;
            }

            //negative
            negArray = temp.reduce();

            String prev = "";
            for( int i = 0; i<negArray.size();i++){
                String negS = negArray.get(i);

                if(negS.length() > 0) {
                    if (i == 0 && negS.charAt(0) == '-'){
                        negS = negS.substring(1);
                    }
                    else if(!negS.equals("-") && ! negS.equals("+") && ! negS.equals("*") && !prev.equals("*")){
                        negS = "-" + negS;
                    }
                    negArray.set(i, negS);
                }
                prev = negS;
            }

            //s.addAll(temp.reduce());
        }
        return negArray;
    }

  // PLB
  private Vector<String> m_ops = new Vector<>();
  public void addOp(String o) { m_ops.add(o); }
  public Vector getOps() { return m_ops; }
}
/* JavaCC - OriginalChecksum=b0bc9dd8edfe4f3c8a086e3dc24afcde (do not edit this line) */
