/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package analyzer.ast;
import java.lang.reflect.Array;
import java.util.ArrayList;
public
class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected Parser parser;
  public SimpleNode(){}
  public SimpleNode(SimpleNode sN){
      this.parser = sN.parser;


  }
  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(Parser p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data)
{
    return visitor.visit(this, data);
  }

  /** Accept the visitor. **/
  public Object childrenAccept(ParserVisitor visitor, Object data)
{
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        children[i].jjtAccept(visitor, data);
      }
    }
    return data;
  }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the , otherwise overriding toString() is probably all
     you need to do. way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String)*/

  public String toString() {
    return ParserTreeConstants.jjtNodeName[id];
  }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }

  public ArrayList<String> reduce(){
      return new ArrayList<String>(){{add("");}};
}

  public int getId() {
    return id;
  }
  protected boolean isStringInt(String string){
      try{
          Integer.parseInt(string);
      }catch(NumberFormatException e){
          return false;
      } catch(NullPointerException e){
          return false;
      }
      return true;
  }

  private int number = -1;
  public int getNumber() { return number; }
  public void setNumber(int number) { this.number = number; }
}

/* JavaCC - OriginalChecksum=6f9aeb8fe347b5774584d58dcc38a7c4 (do not edit this line) */
