/* Generated By:JJTree: Do not edit this line. ASTArrayValue.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

import java.util.ArrayList;
import java.util.List;

public
class ASTArrayValue extends SimpleNode {
  public ASTArrayValue(int id) {
    super(id);
  }

  public ASTArrayValue(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }


  // PLB
  private int m_size = 0;
  public void addSize() { m_size++; }
  public int  getSize() { return m_size; }
}
/* JavaCC - OriginalChecksum=952903d9cc88c05e8cb6f7b15d3b368a (do not edit this line) */
