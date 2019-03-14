/* The following code was generated by JFlex 1.6.1 */

package br.ufpe.cin.if688.jflex;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/main/resources/MiniJava.jflex</tt>
 */
public class MiniJava {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\5\1\6\1\5\1\5\23\0\1\42\4\0\1\37"+
    "\1\0\1\43\1\43\1\7\1\40\1\43\1\40\1\43\1\4\1\2"+
    "\11\44\1\0\1\43\1\40\1\41\3\0\22\1\1\30\7\1\1\43"+
    "\1\0\1\43\1\0\1\1\1\0\1\14\1\10\1\16\1\25\1\13"+
    "\1\35\1\32\1\34\1\22\2\1\1\12\1\27\1\15\1\11\1\20"+
    "\1\1\1\31\1\17\1\24\1\21\1\26\1\33\1\23\1\36\1\1"+
    "\1\43\1\0\1\43\7\0\1\6\u1fa2\0\1\6\1\6\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\17\2"+
    "\1\1\1\6\1\7\1\6\1\7\1\10\1\0\1\4"+
    "\11\2\1\11\45\2\1\0\1\2\1\0\1\2\1\0"+
    "\1\2\1\0\1\2\1\0\1\2\1\0\1\2\1\0"+
    "\1\2\1\0\1\2\1\0\1\2\1\0\1\2\1\0"+
    "\1\11";

  private static int [] zzUnpackAction() {
    int [] result = new int[99];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\45\0\112\0\45\0\157\0\45\0\224\0\271"+
    "\0\336\0\u0103\0\u0128\0\u014d\0\u0172\0\u0197\0\u01bc\0\u01e1"+
    "\0\u0206\0\u022b\0\u0250\0\u0275\0\u029a\0\u02bf\0\u02e4\0\45"+
    "\0\u0309\0\u0309\0\45\0\u032e\0\224\0\224\0\u0353\0\u0378"+
    "\0\u039d\0\u03c2\0\u03e7\0\u040c\0\u0431\0\u0456\0\u047b\0\112"+
    "\0\u04a0\0\u04c5\0\u04ea\0\u050f\0\u0534\0\u0559\0\u057e\0\u05a3"+
    "\0\u05c8\0\u05ed\0\u0612\0\u0637\0\u065c\0\u0681\0\u06a6\0\u06cb"+
    "\0\u06f0\0\u0715\0\u073a\0\u075f\0\u0784\0\u07a9\0\u07ce\0\u07f3"+
    "\0\u0818\0\u083d\0\u0862\0\u0887\0\u08ac\0\u08d1\0\u08f6\0\u091b"+
    "\0\u0940\0\u0965\0\u098a\0\u09af\0\u09d4\0\u09f9\0\u0a1e\0\u0a43"+
    "\0\u0a68\0\u0a8d\0\u0ab2\0\u0ad7\0\u0afc\0\u0b21\0\u0b46\0\u0b6b"+
    "\0\u0b90\0\u0bb5\0\u0bda\0\u0bff\0\u0c24\0\u0c49\0\u0c6e\0\u0c93"+
    "\0\u0cb8\0\u0cdd\0\45";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[99];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\1\4\1\6\1\7"+
    "\1\10\1\3\1\11\1\12\1\3\1\13\1\14\1\15"+
    "\1\16\1\3\1\17\1\3\1\20\1\3\1\21\1\22"+
    "\1\23\1\24\1\3\1\25\1\3\1\26\1\3\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\46\0\2\3\5\0"+
    "\27\3\5\0\1\3\5\5\1\35\1\0\36\5\4\35"+
    "\1\36\1\35\1\0\1\36\35\35\1\0\2\3\5\0"+
    "\1\3\1\37\25\3\5\0\1\3\1\0\2\3\5\0"+
    "\3\3\1\40\23\3\5\0\1\3\1\0\2\3\5\0"+
    "\2\3\1\41\10\3\1\42\13\3\5\0\1\3\1\0"+
    "\2\3\5\0\3\3\1\43\23\3\5\0\1\3\1\0"+
    "\2\3\5\0\2\3\1\44\24\3\5\0\1\3\1\0"+
    "\2\3\5\0\14\3\1\45\12\3\5\0\1\3\1\0"+
    "\2\3\5\0\11\3\1\46\15\3\5\0\1\3\1\0"+
    "\2\3\5\0\5\3\1\47\17\3\1\50\1\3\5\0"+
    "\1\3\1\0\2\3\5\0\21\3\1\51\2\3\1\52"+
    "\2\3\5\0\1\3\1\0\2\3\5\0\1\3\1\53"+
    "\25\3\5\0\1\3\1\0\2\3\5\0\4\3\1\54"+
    "\22\3\5\0\1\3\1\0\2\3\5\0\14\3\1\55"+
    "\11\3\1\56\5\0\1\3\1\0\2\3\5\0\3\3"+
    "\1\57\23\3\5\0\1\3\1\0\2\3\5\0\24\3"+
    "\1\60\2\3\5\0\1\3\1\0\2\3\5\0\4\3"+
    "\1\61\22\3\5\0\1\3\37\0\1\30\46\0\1\30"+
    "\5\0\1\34\41\0\1\34\1\0\2\3\5\0\1\3"+
    "\1\62\25\3\5\0\1\3\1\0\2\3\5\0\5\3"+
    "\1\63\21\3\5\0\1\3\1\0\2\3\5\0\7\3"+
    "\1\64\17\3\5\0\1\3\1\0\2\3\5\0\14\3"+
    "\1\65\12\3\5\0\1\3\1\0\2\3\5\0\23\3"+
    "\1\50\3\3\5\0\1\3\1\0\2\3\5\0\4\3"+
    "\1\66\22\3\5\0\1\3\1\0\2\3\5\0\4\3"+
    "\1\67\22\3\5\0\1\3\1\0\2\3\5\0\1\70"+
    "\26\3\5\0\1\3\1\0\2\3\5\0\14\3\1\50"+
    "\12\3\5\0\1\3\1\0\2\3\5\0\11\3\1\64"+
    "\15\3\5\0\1\3\1\0\2\3\5\0\12\3\1\71"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\12\3\1\72"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\12\3\1\73"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\21\3\1\74"+
    "\5\3\5\0\1\3\1\0\2\3\5\0\7\3\1\75"+
    "\17\3\5\0\1\3\1\0\2\3\5\0\14\3\1\76"+
    "\12\3\5\0\1\3\1\0\2\3\5\0\12\3\1\77"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\2\3\1\41"+
    "\24\3\5\0\1\3\1\0\2\3\5\0\2\3\1\100"+
    "\24\3\5\0\1\3\1\0\2\3\5\0\22\3\1\101"+
    "\4\3\5\0\1\3\1\0\2\3\5\0\3\3\1\50"+
    "\23\3\5\0\1\3\1\0\2\3\5\0\3\3\1\102"+
    "\23\3\5\0\1\3\1\0\2\3\5\0\7\3\1\71"+
    "\17\3\5\0\1\3\1\0\2\3\5\0\14\3\1\103"+
    "\12\3\5\0\1\3\1\0\2\3\5\0\2\3\1\103"+
    "\24\3\5\0\1\3\1\0\2\3\5\0\7\3\1\50"+
    "\17\3\5\0\1\3\1\0\2\3\5\0\15\3\1\50"+
    "\11\3\5\0\1\3\1\0\2\3\5\0\5\3\1\50"+
    "\21\3\5\0\1\3\1\0\2\3\5\0\12\3\1\104"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\14\3\1\105"+
    "\12\3\5\0\1\3\1\0\2\3\5\0\11\3\1\106"+
    "\15\3\5\0\1\3\1\0\2\3\5\0\2\3\1\64"+
    "\24\3\5\0\1\3\1\0\2\3\5\0\3\3\1\107"+
    "\23\3\5\0\1\3\1\0\2\3\5\0\14\3\1\110"+
    "\12\3\5\0\1\3\1\0\2\3\5\0\5\3\1\111"+
    "\21\3\5\0\1\3\1\0\2\3\5\0\12\3\1\112"+
    "\14\3\5\0\1\3\1\0\2\3\5\0\5\3\1\113"+
    "\21\3\5\0\1\3\1\0\2\3\5\0\3\3\1\114"+
    "\23\3\5\0\1\3\1\0\2\3\5\0\21\3\1\73"+
    "\5\3\5\0\1\3\1\0\2\3\5\0\4\3\1\73"+
    "\22\3\5\0\1\3\1\0\2\3\5\0\24\3\1\50"+
    "\2\3\5\0\1\3\1\0\2\3\5\0\15\3\1\71"+
    "\11\3\5\0\1\3\1\0\2\3\5\0\6\3\1\50"+
    "\20\3\5\0\1\3\1\0\2\3\5\0\22\3\1\50"+
    "\4\3\5\0\1\3\1\0\2\3\5\0\17\3\1\115"+
    "\7\3\5\0\1\3\1\116\2\117\2\116\2\0\1\116"+
    "\27\117\5\116\1\117\11\0\1\120\34\0\2\3\5\0"+
    "\1\3\1\121\25\3\5\0\1\3\21\0\1\122\24\0"+
    "\2\3\5\0\11\3\1\123\15\3\5\0\1\3\24\0"+
    "\1\124\21\0\2\3\5\0\14\3\1\125\12\3\5\0"+
    "\1\3\5\126\2\0\37\126\2\127\2\126\2\0\1\126"+
    "\27\127\5\126\1\127\20\0\1\130\25\0\2\3\5\0"+
    "\10\3\1\131\16\3\5\0\1\3\31\0\1\132\14\0"+
    "\2\3\5\0\21\3\1\133\5\3\5\0\1\3\22\0"+
    "\1\134\23\0\2\3\5\0\12\3\1\135\14\3\5\0"+
    "\1\3\15\0\1\136\30\0\2\3\5\0\5\3\1\137"+
    "\21\3\5\0\1\3\24\0\1\140\21\0\2\3\5\0"+
    "\14\3\1\141\12\3\5\0\1\3\12\0\1\142\33\0"+
    "\2\3\5\0\2\3\1\73\24\3\5\0\1\3\15\0"+
    "\1\143\27\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3330];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\21\1\1\11"+
    "\2\1\1\11\1\1\1\0\60\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[99];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public MiniJava(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 170) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return YYEOF;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new RuntimeException("Caractere ilegal! '" + yytext() + "' na linha: " + yyline + ", coluna: " + yycolumn);
            }
          case 10: break;
          case 2: 
            { System.out.println("Token � do tipo 'identifier': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);
            }
          case 11: break;
          case 3: 
            { /* Ignorar whitespace. */
            }
          case 12: break;
          case 4: 
            { /* Ignorar comments. */
            }
          case 13: break;
          case 5: 
            { System.out.print(yytext());
            }
          case 14: break;
          case 6: 
            { System.out.println("Token � do tipo 'operator': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);
            }
          case 15: break;
          case 7: 
            { System.out.println("Token � do tipo 'delimiter': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);
            }
          case 16: break;
          case 8: 
            { System.out.println("Token � do tipo 'integer': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);
            }
          case 17: break;
          case 9: 
            { System.out.println("Token � do tipo 'reserved': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);
            }
          case 18: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java MiniJava [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        MiniJava scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new MiniJava(reader);
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}