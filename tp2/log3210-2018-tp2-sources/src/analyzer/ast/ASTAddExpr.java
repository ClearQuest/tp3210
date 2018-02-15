package analyzer.ast;/* Generated By:JJTree: Do not edit this line. ASTAddExpr.java */

import java.util.ArrayList;
import java.util.Vector;	// PLB

public class ASTAddExpr extends SimpleNode {
    public ASTAddExpr(int id) {
        super(id);
    }
    public ASTAddExpr(){};
    public ASTAddExpr(ASTAddExpr addE){
        super(addE.getId());
        this.parser = addE.parser;
        this.children = addE.children;
        this.m_ops = addE.m_ops;
        this.parent = addE.parent;
    }
    public ASTAddExpr(Parser p, int id) {
        super(p, id);
    }


    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    /*public ArrayList<String> reduce(){
        int val = 1;
        ArrayList<String> identifiers = new ArrayList<>();
        int countMinus = 0;
        for (int  i = 0 ; i<this.jjtGetNumChildren(); i++) {

            ArrayList<String> currArray = jjtGetChild(i).reduce();

            for (int j = 0; j < currArray.size(); j++) {
                String current = currArray.get(j);
                if (this.isStringInt(current)) {
                    val *= Integer.parseInt(current);
                } else {
                    if (current.charAt(0) == '-') {
                        countMinus++; // remind val may be neg
                        current.substring(1);
                    }
                    if (!current.equals(""))
                        identifiers.add(current);
                }
            }
        }
        if(val < 0){
            countMinus ++;
            val *= -1;
        }
        ArrayList<String> ret = new ArrayList<>();
        if (val!=0) {
            if (countMinus%2 == 0)
                ret.add("-");
            ret.add(Integer.toString(val));
            ret.addAll(identifiers);
        }
        else ret.add("0");
        return ret;
    }*/

    /*
    @Override
    public ArrayList<String> reduce() {
        ArrayList<String> leftArray =  new ArrayList<>(), rightArray  =  new ArrayList<>(), returnArray  =  new ArrayList<>();
        boolean isLeftString = false, isLeftExpr = false,isRightExpr = false, isRightString = false;
        int leftValue = 0, rightValue = 0;

        // Si il a juste un enfant, c'est un Identifier
        if(this.jjtGetNumChildren() == 1){ // bubble up
           ASTMultExpr tempNode = (ASTMultExpr)jjtGetChild(0);
           return tempNode.reduce();
        }

        ASTMultExpr tempNode = (ASTMultExpr)jjtGetChild(0);

        leftArray =  tempNode.reduce();
        tempNode = (ASTMultExpr)jjtGetChild(1);
        rightArray = tempNode.reduce();

        if(leftArray.size() == 1) {// int or string
            if(this.isStringInt(leftArray.get(0))){
                leftValue =  Integer.parseInt(leftArray.get(0));
            }
            else
                isLeftString = true;
        }
        else
            isLeftExpr = true;

        if(rightArray.size() == 1) {// int or string
            if(this.isStringInt(rightArray.get(0))){
                rightValue =  Integer.parseInt(rightArray.get(0));
            }
            else
                isRightString = true;
        }
        else
            isRightExpr = true;

        if(!isLeftExpr && !isLeftString){
            if(!isRightExpr&&!isRightString){ // both are values
                if(m_ops.get(1).equals("+"))
                    returnArray.add(Integer.toString(rightValue + leftValue));
                else
                    returnArray.add(Integer.toString(leftValue - rightValue));

            }
            else if( !isRightExpr) {//is a string value

            }
        }
        return returnArray;
    }
    */

    @Override
    public ArrayList<String> reduce() {

        ArrayList<String> tempAdditionnableAL  =  new ArrayList<>();    // ArrayList avec des String (int et op) Ex: ["a" "+" "3"]
        ArrayList<String> tempNonAdditionnableAL  =  new ArrayList<>(); // ArrayList avec des String Ex: ["a*5", "+", "b*3"]


        /* FIRST ELEMENT */
        ASTMultExpr tempNode2 = (ASTMultExpr)jjtGetChild(0);
        ArrayList<String> tempArrayList2 = new ArrayList<>();
        tempArrayList2 = tempNode2.reduce();

        if(tempArrayList2.size() == 1)
        {
            String value = tempArrayList2.get(0);
            if(this.isStringInt(value))
            {
                tempAdditionnableAL.add("+");
                tempAdditionnableAL.add(value);
            }
            else // if its not an int, its a string of mult ["a*5"]
            {
                tempNonAdditionnableAL.add("+");
                tempNonAdditionnableAL.add(value);
            }
        }

        else
        {
            for(int i = 1; i < (tempArrayList2.size()+1)/2; i+=2)
            {
                String value = tempArrayList2.get(i+1);
                if(this.isStringInt(value))
                {
                    if(tempArrayList2.get(i) == "+")
                    {
                        tempAdditionnableAL.add("+");
                    }
                    else if(tempArrayList2.get(i) == "-")
                    {
                        tempAdditionnableAL.add("-");
                    }
                    tempAdditionnableAL.add(value);
                }
                else // if its not an int, its a string of mult ["a*5"]
                {
                    tempNonAdditionnableAL.add("+");
                    tempNonAdditionnableAL.add(value);
                }

            }
        }

        /* OTHERS (Si il y a un ou plus autre children dans { Mult (+/- Mult)* }) */
        for (int i = 1; i < this.jjtGetNumChildren(); i++)
        {
            ASTMultExpr tempNode = (ASTMultExpr)jjtGetChild(i);
            ArrayList<String> tempArrayList = new ArrayList<>();
            tempArrayList = tempNode.reduce();

            if(tempArrayList.size() == 1) {// int or string
                String value = tempArrayList.get(0);
                if(this.isStringInt(value))
                {
                    tempAdditionnableAL.add(m_ops.get(i-1));
                    tempAdditionnableAL.add(value);
                }
                else // if its not an int, its a string of mult ["a*5"]
                {
                    tempNonAdditionnableAL.add(m_ops.get(i-1));
                    tempNonAdditionnableAL.add(value);
                }
            }
            else
            {
                for(int j = 1; j < (tempArrayList2.size()+1)/2; j+=2)
                {
                    String value = tempArrayList2.get(j+1);
                    if(this.isStringInt(value))
                    {
                        if(tempArrayList2.get(j) == "+")
                        {
                            tempAdditionnableAL.add("+");
                        }
                        else if(tempArrayList2.get(j) == "-")
                        {
                            tempAdditionnableAL.add("-");
                        }
                        tempAdditionnableAL.add(value);
                    }
                    else // if its not an int, its a string of mult ["a*5"]
                    {
                        tempNonAdditionnableAL.add("+");
                        tempNonAdditionnableAL.add(value);
                    }

                }
            }

        }

        /* Maintenant qu'on a nos deux arrayList, on simplifie celle avec des éléments "additionnables" */
        /*
            Ex:
            tempAdditionnableAL     =   ["3" "-" "1"] = ["2"]
            tempNonAdditionnableAL  =   ["a*5" "+" "b*3"]
        */

        int reducedValue = 0;
        if(tempAdditionnableAL.size() > 2)
        {
            for (int i = 0; i <= (tempAdditionnableAL.size()+2)/2; i+=2)
            {
                int valueToAdd = 0;
                if(this.isStringInt(tempAdditionnableAL.get(i+1))) {
                    valueToAdd = Integer.parseInt(tempAdditionnableAL.get(i + 1));

                    if(tempAdditionnableAL.get(i) == "+")
                    {
                        reducedValue += valueToAdd;
                    }
                    else if(tempAdditionnableAL.get(i) == "-")
                    {
                        reducedValue -= valueToAdd;
                    }
                    else
                    {
                        // Error
                    }
                }
            }
        }
        else if (tempAdditionnableAL.size() == 2)
        {
            reducedValue = Integer.parseInt(tempAdditionnableAL.get(1));
        }
        else
        {
            // Error
        }


        ArrayList<String> reducedArrayList  =  new ArrayList<>();
        if(reducedValue != 0)
        {
            reducedArrayList.add(Integer.toString(reducedValue));
            reducedArrayList.addAll(tempNonAdditionnableAL);
        }
        else
        {
            reducedArrayList.addAll(tempNonAdditionnableAL);
            reducedArrayList.remove(0);
        }

        return reducedArrayList;
    }

    // PLB
    private Vector<String> m_ops = new Vector<>();
    public void addOp(String o) { m_ops.add(o); }
    public Vector getOps() { return m_ops; }
}
