/* Generated By:JavaCC: Do not edit this line. Gramatica.java */
package grammar;
import grammar.ts.Arbol;
import grammar.ts.Operador;
import grammar.ts.GrammarException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pattern_abstract.Instruccion;
import pattern_abstract.expresion.Primitivo;
import pattern_abstract.expresion.Operacion;
import pattern_abstract.nodoast.Nodo;
import pattern_abstract.nodoast.WriteFile;
/** New line translator. */
public class Gramatica implements GramaticaConstants {


  /** Main entry point. */
public static List<GrammarException> lstE = new ArrayList<>();
  public static void main(String args[]) throws ParseException, TokenMgrError {
    Gramatica parser = new Gramatica(System.in);
    Instruccion inst = parser.inicio();

    Arbol ast = new Arbol(inst, null, lstE);
    int result = (Integer)ast.getInstruccion().interpretar();
      System.out.println("==============resultado========="+result);

    
    Nodo init = new Nodo("Ast_Root");
    Nodo instNodo = new Nodo("Instruccion");
    instNodo.addHijoNodo(ast.getInstruccion().getNodo());

    init.addHijoNodo(instNodo);
    String grafo = ast.getDot(init);
    
    WriteFile wf = new WriteFile();
    wf.writeFile("grafo.dot", grafo);
    wf.dibujar("grafo.dot", "grafo.png");
    System.out.println("==Fin==");
  }
  

  final public Instruccion inicio() throws ParseException {
                      Instruccion instruccion;
         System.out.println("inciiando");
    instruccion = E();
         {if (true) return instruccion;}
    throw new Error("Missing return statement in function");
  }

  final public Instruccion E() throws ParseException {
 Instruccion txtT,txtEp;
    txtT = T();
                 System.out.println("txtT "+txtT.toString());
    txtEp = Ep();
            if(txtEp == null){
                {if (true) return txtEp;}
             }else{
                    {if (true) return new Operacion(Operador.MAS,txtT,txtEp,1,1);}
                }
    throw new Error("Missing return statement in function");
  }

  final public Instruccion Ep() throws ParseException {
 Instruccion txtT;Instruccion txtEp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAS:
      jj_consume_token(MAS);
      txtT = T();
      txtEp = Ep();
                if(txtEp != null){
                        {if (true) return new Operacion(Operador.MAS,txtT,txtEp,1,1);}
                }
                {if (true) return txtT;}
      break;
    default:
      jj_la1[0] = jj_gen;
           {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Instruccion T() throws ParseException {
 Instruccion txtF;Instruccion txtTp;
    txtF = F();
    txtTp = Tp();
                if(txtF == null){
                  lstE.add(new GrammarException("Sintactico", "Se esperaba un Valor Primitivo"  , 1,1));
                  {if (true) return null;}
                }
                if(txtTp != null ){

                    {if (true) return new Operacion(Operador.POR,txtF,txtTp,1,1);}
                   }
                else{
                    {if (true) return txtF;}
                }
    throw new Error("Missing return statement in function");
  }

  final public Instruccion Tp() throws ParseException {
 Instruccion txtF;
Instruccion txtTp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case POR:
      jj_consume_token(POR);
      txtF = F();
      txtTp = Tp();
              if(txtF == null){
                  lstE.add(new GrammarException("Sintactico", "Se esperaba un Valor Primitivo"  , 1,1));
                  {if (true) return null;}
                }
                if(txtTp != null ){
                    {if (true) return new Operacion(Operador.POR,txtF,txtTp,1,1);}
                   }
                else{
                    {if (true) return txtF;}
                }
      break;
    default:
      jj_la1[1] = jj_gen;
           {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Instruccion F() throws ParseException {
 Token token; Instruccion valE;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      token = jj_consume_token(NUM);
            {if (true) return new Primitivo(1,1,token.image.toString());}
      break;
    case PAR_A:
      jj_consume_token(PAR_A);
      valE = E();
      jj_consume_token(PAR_C);
                                    System.out.println("F E"+valE); {if (true) return valE;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public GramaticaTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x40,0x120,};
   }

  /** Constructor with InputStream. */
  public Gramatica(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Gramatica(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Gramatica(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Gramatica(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
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

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[10];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
