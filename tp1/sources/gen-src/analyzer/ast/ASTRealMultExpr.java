/* Generated By:JJTree: Do not edit this line. ASTRealMultExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

public
class ASTRealMultExpr extends SimpleNode {
  public ASTRealMultExpr(int id) {
    super(id);
  }

  public ASTRealMultExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2f4eb7523ff0e2c53e93f661d4170067 (do not edit this line) */
