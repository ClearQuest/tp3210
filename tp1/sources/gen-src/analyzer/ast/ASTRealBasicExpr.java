/* Generated By:JJTree: Do not edit this line. ASTRealBasicExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

public
class ASTRealBasicExpr extends SimpleNode {
  public ASTRealBasicExpr(int id) {
    super(id);
  }

  public ASTRealBasicExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=769cb523c7c88939e2a7ecf877dc04b9 (do not edit this line) */
