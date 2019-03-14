package br.ufpe.cin.if688.jflex;

%%

/* Nï¿½o altere as configuraï¿½ï¿½es a seguir */

%line
%column
%unicode
//%debug
%public
%standalone
%class MiniJava
%eofclose

/* Insira as regras lï¿½xicas abaixo */

letter       = [A-Za-z]
digits       = [0-9]
alphanumeric = {letter} | {digits}
ws           = [\n\t\r\f]
com          = ([//].*) | ([/*](.*\n*\t*\r*\f*)*[*/])
res          = (boolean | class | public | extends | static | void | main | String | int | while | if | else | return | length | true | false | this | new | System.out.println)
op           = ("&&" | "<" | "==" | "!=" | "+" | "-" | "*" | "!")
del          = (";" | "." | "," | "=" | "(" | ")" | "{" | "}" | "[" | "]")
id           = ({letter} | [_])({alphanumeric} | [_])*
int          = [1-9]{digits}*

%%

{ws}  {/* Ignorar whitespace. */}
{com} {/* Ignorar comments. */}
{res} {System.out.println("Token é do tipo 'reserved': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);}
{op}  {System.out.println("Token é do tipo 'operator': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);}
{del} {System.out.println("Token é do tipo 'delimiter': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);}
{id}  {System.out.println("Token é do tipo 'identifier': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);}
{int} {System.out.println("Token é do tipo 'integer': '"+yytext()+"' na linha: "+yyline+" e coluna: "+yycolumn);}

/* Insira as regras lï¿½xicas no espaï¿½o acima */     
     
. { throw new RuntimeException("Caractere ilegal! '" + yytext() + "' na linha: " + yyline + ", coluna: " + yycolumn); }
