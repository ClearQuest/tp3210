/* Generated By:JJTree: Do not edit this line. ASTForStmt.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;

import analyzer.visitors.ForLoopInformation;

public
class ASTForStmt extends SimpleNode {

    private ForLoopInformation info_ = new ForLoopInformation();

    public void setForLoopInformation(ForLoopInformation info) { this.info_ = info; }
    public ForLoopInformation getForLoopInformation() { return this.info_; }

    /* Constructors */
    public ASTForStmt(int id) {
    super(id);
  }
    public ASTForStmt(Parser p, int id) {
    super(p, id);
  }

    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data) { return visitor.visit(this, data); }
}
/* JavaCC - OriginalChecksum=deb96f61edbe50ff3646f773ccc4830b (do not edit this line) */
