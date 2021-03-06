package analyzer.ast;/* Generated By:JJTree: Do not edit this line. ASTMultExpr.java */

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector; // PLB

public class ASTMultExpr extends SimpleNode {
  public ASTMultExpr(int id) {
    super(id);
  }
  public ASTMultExpr(ASTMultExpr mExpr){
      this.parser = mExpr.parser;
      this.id = mExpr.id;
      this.children = mExpr.children;
      this.parent = mExpr.parent;
      this.m_ops = mExpr.m_ops;
  }

  public ASTMultExpr(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  

    public ArrayList<String> reduce() {
       /* String leftStr = "", rightStr = "";
        boolean isLeftId, isRightId = false;*/

        //int leftVal = 1, rightVal = 1;
        //  ArrayList<String> leftArray, rightArray = new ArrayList<>(), stringValues = new ArrayList<>();
        ArrayList<String> returnValues = new ArrayList<>();
        ArrayList<ArrayList<String>> arrays = new ArrayList<>();
        ArrayList<String> str = new ArrayList<String>();
        ArrayList<Boolean> isId = new ArrayList<Boolean>();
        ArrayList<Integer> val = new ArrayList<Integer>();

        for (int i = 0; i < this.jjtGetNumChildren(); i++) {
            ASTUnaryOpExpr tempNode = (ASTUnaryOpExpr) this.jjtGetChild(i);
            ArrayList<String> reducedUn = tempNode.reduce();
            arrays.add(reducedUn);
            str.add(hasIdentifier(arrays.get(i)));
            isId.add(!(str.get(i).equals("")));
            if (!isId.get(i) && this.isStringInt(arrays.get(i).get(0))) { //get int values
                val.add(Integer.parseInt(arrays.get(i).get(0)));
            } else val.add(1);

        }
        if (this.jjtGetNumChildren() == 1) { // only left exists
            returnValues.addAll(arrays.get(0)); //only want to bubble up regular array. could be eg (7+a) ready to go with +5
            return returnValues;
        }
        int totalValue = 1;
        String totalString = "";
        for (int i = 0; i < this.jjtGetNumChildren(); i++) { // what do we return?
            if (!isId.get(i)) { // is int
                totalValue *= val.get(i); // mult the values
            } else { // isId
                totalString += str.get(i)+"*";
            }
        }
        if(totalString.length()>0) {
            totalString = totalString.substring(0, totalString.length() - 1);
        }
        if (totalString.length() > 1 && totalString.charAt(0) != '(') { //add parenth
            totalString = "(" + totalString + ")";
        }

        //RETURNS

        if (totalValue == 0) {
            returnValues.add("0");
            return returnValues;
        }
        String returnString = "";
        if ((totalValue == 1 && totalString.length() < 1) || totalValue != 1) {
            returnString += Integer.toString(totalValue);
            if (totalString.length() > 0)
                returnString += "*";
        }
        returnString += totalString;
        returnValues.add(returnString);
        return returnValues;
    }

    private String hasIdentifier(ArrayList<String> array){
        String idString = "";
        boolean isStr = false;
        for (int r = 0; r < array.size(); r++) {
            if (!(array.get(r).equals("+") || array.get(r).equals("-") || array.get(r).equals("*"))) {
                if (!this.isStringInt(array.get(r))) {
                    isStr = true;
                }
            }
            idString += array.get(r);
        }
        if (!array.get(0).equals("(") && array.size()>1) { //dont want to parenth a single value.
            idString = "(" + idString + ")";
        }
        if (!isStr) return "";

        return idString;
    }
    // PLB
  private Vector<String> m_ops = new Vector<>();
  public void addOp(String o) { m_ops.add(o); }
  public Vector getOps() { return m_ops; }
}
