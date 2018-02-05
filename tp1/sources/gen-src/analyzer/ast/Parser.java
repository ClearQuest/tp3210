/* Parser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. Parser.java */
package analyzer.ast;

public class Parser/*@bgen(jjtree)*/implements ParserTreeConstants, ParserConstants {/*@bgen(jjtree)*/
  protected JJTParserState jjtree = new JJTParserState();public static ASTProgram ParseTree(java.io.InputStream input) throws ParseException
        {
                Parser c = new Parser(input);
                return c.Program();
        }

//
// SYNTAX ANALYSIS
//
  final public 
ASTProgram Program() throws ParseException {/*@bgen(jjtree) Program */
  ASTProgram jjtn000 = new ASTProgram(JJTPROGRAM);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Block();
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
                        jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
}

  final public void Block() throws ParseException {/*@bgen(jjtree) Block */
  ASTBlock jjtn000 = new ASTBlock(JJTBLOCK);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        Stmt();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
             jjtree.clearNodeScope(jjtn000);
             jjtc000 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte000 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte000;}
           }
           if (jjte000 instanceof ParseException) {
             {if (true) throw (ParseException)jjte000;}
           }
           {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
             jjtree.closeNodeScope(jjtn000, true);
           }
    }
}

  final public void Stmt() throws ParseException {/*@bgen(jjtree) Stmt */
  ASTStmt jjtn000 = new ASTStmt(JJTSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      AssignStmt();
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void AssignStmt() throws ParseException {/*@bgen(jjtree) AssignStmt */
                      ASTAssignStmt jjtn000 = new ASTAssignStmt(JJTASSIGNSTMT);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t;
    try {
      Identifier();
      jj_consume_token(ASSIGN);
      Expr();
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void Expr() throws ParseException {/*@bgen(jjtree) Expr */
  ASTExpr jjtn000 = new ASTExpr(JJTEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_1(2)) {
        IntExpr();
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LPAREN:
        case MINUSR:
        case IDENTIFIER:
        case REAL:{
          RealExpr();
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

// Support expressions entiers
  final public 
void IntExpr() throws ParseException {/*@bgen(jjtree) IntExpr */
  ASTIntExpr jjtn000 = new ASTIntExpr(JJTINTEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      IntAddExpr();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void IntAddExpr() throws ParseException {/*@bgen(jjtree) IntAddExpr */
                      ASTIntAddExpr jjtn000 = new ASTIntAddExpr(JJTINTADDEXPR);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t;
    try {
      IntMultExpr();
      label_2:
      while (true) {
        if (jj_2_2(2)) {
          ;
        } else {
          break label_2;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:{
          t = jj_consume_token(PLUS);
          break;
          }
        case MINUS:{
          t = jj_consume_token(MINUS);
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        IntMultExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void IntMultExpr() throws ParseException {/*@bgen(jjtree) IntMultExpr */
                       ASTIntMultExpr jjtn000 = new ASTIntMultExpr(JJTINTMULTEXPR);
                       boolean jjtc000 = true;
                       jjtree.openNodeScope(jjtn000);Token t;
    try {
      IntNegExpr();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FOIS:
        case DIV:{
          ;
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          break label_3;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FOIS:{
          t = jj_consume_token(FOIS);
          break;
          }
        case DIV:{
          t = jj_consume_token(DIV);
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        IntNegExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void IntNegExpr() throws ParseException {/*@bgen(jjtree) IntNegExpr */
  ASTIntNegExpr jjtn000 = new ASTIntNegExpr(JJTINTNEGEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MINUS:{
        jj_consume_token(MINUS);
        IntBasicExpr();
        break;
        }
      case LPAREN:
      case IDENTIFIER:
      case INTEGER:{
        IntBasicExpr();
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void IntBasicExpr() throws ParseException {/*@bgen(jjtree) IntBasicExpr */
  ASTIntBasicExpr jjtn000 = new ASTIntBasicExpr(JJTINTBASICEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_3(2)) {
        Identifier();
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case INTEGER:{
          IntValue();
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          if (jj_2_4(2)) {
            jj_consume_token(LPAREN);
            IntExpr();
            jj_consume_token(RPAREN);
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

// Support expressions réels (b)
  final public 
void RealExpr() throws ParseException {/*@bgen(jjtree) RealExpr */
  ASTRealExpr jjtn000 = new ASTRealExpr(JJTREALEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      RealAddExpr();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void RealAddExpr() throws ParseException {/*@bgen(jjtree) RealAddExpr */
                       ASTRealAddExpr jjtn000 = new ASTRealAddExpr(JJTREALADDEXPR);
                       boolean jjtc000 = true;
                       jjtree.openNodeScope(jjtn000);Token t;
    try {
      RealMultExpr();
      label_4:
      while (true) {
        if (jj_2_5(2)) {
          ;
        } else {
          break label_4;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUSR:{
          t = jj_consume_token(PLUSR);
          break;
          }
        case MINUSR:{
          t = jj_consume_token(MINUSR);
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        RealMultExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void RealMultExpr() throws ParseException {/*@bgen(jjtree) RealMultExpr */
                        ASTRealMultExpr jjtn000 = new ASTRealMultExpr(JJTREALMULTEXPR);
                        boolean jjtc000 = true;
                        jjtree.openNodeScope(jjtn000);Token t;
    try {
      RealNegExpr();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FOISR:
        case DIVR:{
          ;
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          break label_5;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FOISR:{
          t = jj_consume_token(FOISR);
          break;
          }
        case DIVR:{
          t = jj_consume_token(DIVR);
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        RealNegExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void RealNegExpr() throws ParseException {/*@bgen(jjtree) RealNegExpr */
  ASTRealNegExpr jjtn000 = new ASTRealNegExpr(JJTREALNEGEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MINUSR:{
        jj_consume_token(MINUSR);
        RealBasicExpr();
        break;
        }
      case LPAREN:
      case IDENTIFIER:
      case REAL:{
        RealBasicExpr();
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void RealBasicExpr() throws ParseException {/*@bgen(jjtree) RealBasicExpr */
  ASTRealBasicExpr jjtn000 = new ASTRealBasicExpr(JJTREALBASICEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_6(2)) {
        Identifier();
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case REAL:{
          RealValue();
          break;
          }
        default:
          jj_la1[11] = jj_gen;
          if (jj_2_7(2)) {
            jj_consume_token(LPAREN);
            RealExpr();
            jj_consume_token(RPAREN);
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////
  final public void TableExpr() throws ParseException {/*@bgen(jjtree) TableExpr */
  ASTTableExpr jjtn000 = new ASTTableExpr(JJTTABLEEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      TableConcatExpr();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void TableConcatExpr() throws ParseException {/*@bgen(jjtree) TableConcatExpr */
                           ASTTableConcatExpr jjtn000 = new ASTTableConcatExpr(JJTTABLECONCATEXPR);
                           boolean jjtc000 = true;
                           jjtree.openNodeScope(jjtn000);Token t;
    try {
      TableRepetitionExpr();
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PIPE:{
          ;
          break;
          }
        default:
          jj_la1[12] = jj_gen;
          break label_6;
        }
        t = jj_consume_token(PIPE);
        TableRepetitionExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void TableRepetitionExpr() throws ParseException {/*@bgen(jjtree) TableRepetitionExpr */
                               ASTTableRepetitionExpr jjtn000 = new ASTTableRepetitionExpr(JJTTABLEREPETITIONEXPR);
                               boolean jjtc000 = true;
                               jjtree.openNodeScope(jjtn000);Token t;
    try {
      TableInversionExpression();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SHARP:{
          ;
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          break label_7;
        }
        t = jj_consume_token(SHARP);
        TableInversionExpression();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void TableInversionExpression() throws ParseException {/*@bgen(jjtree) TableInversionExpression */
  ASTTableInversionExpression jjtn000 = new ASTTableInversionExpression(JJTTABLEINVERSIONEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TILD:{
        jj_consume_token(TILD);
        IntBasicExpr();
        break;
        }
      case CROOUVRANT:
      case IDENTIFIER:
      case REAL:{
        TableBasicExpression();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void TableBasicExpression() throws ParseException {/*@bgen(jjtree) TableBasicExpression */
  ASTTableBasicExpression jjtn000 = new ASTTableBasicExpression(JJTTABLEBASICEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_8(2)) {
        Identifier();
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case REAL:{
          RealValue();
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          if (jj_2_9(2)) {
            jj_consume_token(CROOUVRANT);
            Expr();
            jj_consume_token(CROFERMANT);
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

//<TABLE: (<CROOUVRANT>) + <ANY> (<COMMA> <SPACE><ANY>)* (<CROFERMANT>)>


//////////////////////////////////////////////////////////////////////////////////////////////////
  final public void Identifier() throws ParseException {/*@bgen(jjtree) Identifier */
                      ASTIdentifier jjtn000 = new ASTIdentifier(JJTIDENTIFIER);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                           jjtc000 = false;
jjtn000.setValue(t.image);
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void IntValue() throws ParseException {/*@bgen(jjtree) IntValue */
                    ASTIntValue jjtn000 = new ASTIntValue(JJTINTVALUE);
                    boolean jjtc000 = true;
                    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(INTEGER);
jjtree.closeNodeScope(jjtn000, true);
                        jjtc000 = false;
jjtn000.setValue(Integer.parseInt(t.image));
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void RealValue() throws ParseException {/*@bgen(jjtree) RealValue */
                     ASTRealValue jjtn000 = new ASTRealValue(JJTREALVALUE);
                     boolean jjtc000 = true;
                     jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(REAL);
jjtree.closeNodeScope(jjtn000, true);
                     jjtc000 = false;
jjtn000.setValue(Double.parseDouble(t.image));
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_3()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_4()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_5()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_6()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_7()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_8()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_9()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_3R_28()
 {
    if (jj_scan_token(INTEGER)) return true;
    return false;
  }

  private boolean jj_3R_24()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3_4()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_3()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_20()
 {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3_7()
 {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_10()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_27()
 {
    if (jj_3R_29()) return true;
    return false;
  }

  private boolean jj_3R_25()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3_7()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_6()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_19()
 {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    return false;
  }

  private boolean jj_3R_22()
 {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3_2()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(31)) {
    jj_scanpos = xsp;
    if (jj_scan_token(32)) return true;
    }
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3_9()
 {
    if (jj_scan_token(CROOUVRANT)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_21()
 {
    if (jj_scan_token(MINUSR)) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    return false;
  }

  private boolean jj_3R_23()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(33)) {
    jj_scanpos = xsp;
    if (jj_scan_token(34)) return true;
    }
    return false;
  }

  private boolean jj_3R_18()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3_8()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3_5()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) return true;
    }
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_9()
 {
    if (jj_3R_15()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_23()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_11()
 {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_3R_9()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_2()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_8()
 {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    return false;
  }

  private boolean jj_3R_12()
 {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_29()
 {
    if (jj_scan_token(REAL)) return true;
    return false;
  }

  private boolean jj_3_4()
 {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_26()
 {
    if (jj_3R_28()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x0,0x0,0x80000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x400000,0x0,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x100000,0x1120010,0x1,0x6,0x6,0x900011,0x800000,0x30000,0xc0000,0xc0000,0x1120010,0x1000000,0x800,0x1000,0x1102000,0x1000000,};
	}
  final private JJCalls[] jj_2_rtns = new JJCalls[9];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 jj_input_stream = new JavaCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new JavaCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[59];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 16; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 59; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 9; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			   case 2: jj_3_3(); break;
			   case 3: jj_3_4(); break;
			   case 4: jj_3_5(); break;
			   case 5: jj_3_6(); break;
			   case 6: jj_3_7(); break;
			   case 7: jj_3_8(); break;
			   case 8: jj_3_9(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
