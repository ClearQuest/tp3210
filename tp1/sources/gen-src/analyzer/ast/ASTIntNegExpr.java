/* Generated By:JJTree: Do not edit this line. ASTIntNegExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

public
class ASTIntNegExpr extends SimpleNode {
  public ASTIntNegExpr(int id) {
    super(id);
  }

  public ASTIntNegExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f6bcb79c9e4e658057a7096499001cd7 (do not edit this line) */
