package analyzer.ast;/* Generated By:JJTree: Do not edit this line. ASTAddExpr.java */

import java.util.ArrayList;
import java.util.Vector;	// PLB

public class ASTAddExpr extends SimpleNode {
    public ASTAddExpr(int id) {
        super(id);
    }
    public ASTAddExpr(){};
    public ASTAddExpr(ASTAddExpr addE){
        this.id = addE.id;
        this.parser = addE.parser;
        this.children = addE.children;
        this.m_ops = addE.m_ops;
        this.parent = addE.parent;
        this.value = addE.value;
    }
    public ASTAddExpr(Parser p, int id) {
        super(p, id);
    }


    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

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
            for(int i = 0; i <= (tempArrayList2.size()+1)/2; i+=2)
            {
                String value = tempArrayList2.get(i);
                if(this.isStringInt(value))
                {
                    if(i==0)
                    {
                        tempAdditionnableAL.add("+");
                    }
                    else
                    {
                        if(tempArrayList2.get(i+1) == "+")
                        {
                            tempAdditionnableAL.add("+");
                        }
                        else if(tempArrayList2.get(i+1) == "-")
                        {
                            tempAdditionnableAL.add("-");
                        }
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

        int test = this.jjtGetNumChildren();
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
                for(int j = 0; j <= (tempArrayList.size()+1)/2; j+=2)
                {
                    String value = tempArrayList.get(j);
                    if(this.isStringInt(value))
                    {
                        if(tempArrayList.get(j+1) == "+")
                        {
                            tempAdditionnableAL.add("+");
                        }
                        else if(tempArrayList.get(j+1) == "-")
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
        else if (reducedValue == 0 && this.jjtGetNumChildren() > 1)
        {
            reducedArrayList.addAll(tempNonAdditionnableAL);
            if(reducedArrayList.size()>0) {
                reducedArrayList.remove(0);
            }
            else reducedArrayList.add("0");
        }
        else if (reducedValue == 0 && this.jjtGetNumChildren() == 1)
        {
            reducedArrayList.addAll(tempNonAdditionnableAL);
            if(reducedArrayList.size()>0) {
                reducedArrayList.remove(0);
            }
            else
                reducedArrayList.add("0");
        }
        else
        {
            // Error
        }

        return reducedArrayList;
    }

    // PLB
    private Vector<String> m_ops = new Vector<>();
    public void addOp(String o) { m_ops.add(o); }
    public Vector getOps() { return m_ops; }
}
