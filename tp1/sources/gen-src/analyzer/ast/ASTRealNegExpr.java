/* Generated By:JJTree: Do not edit this line. ASTRealNegExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

public
class ASTRealNegExpr extends SimpleNode {
  public ASTRealNegExpr(int id) {
    super(id);
  }

  public ASTRealNegExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=8a90230c775323f15e988d5b53eccb65 (do not edit this line) */
