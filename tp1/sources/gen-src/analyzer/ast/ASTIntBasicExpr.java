/* Generated By:JJTree: Do not edit this line. ASTIntBasicExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

public
class ASTIntBasicExpr extends SimpleNode {
  public ASTIntBasicExpr(int id) {
    super(id);
  }

  public ASTIntBasicExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=76953e0a38f2865296bd321769198064 (do not edit this line) */
