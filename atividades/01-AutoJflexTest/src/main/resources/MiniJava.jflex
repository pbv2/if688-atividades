package br.ufpe.cin.if688.jflex;

%%

/* N�o altere as configura��es a seguir */

%line
%column
%unicode
//%debug
%public
%standalone
%class MiniJava
%eofclose

/* Insira as regras l�xicas abaixo */

letter       = [A-Za-z]
digits       = [0-9]
alphanumeric = {letter} | {digits}
ws           = [\n\t\r\f" "]
com          = (\/\/.*) | (\/*(.*\n*\t*\r*\f*)*\*\/)
res          = (boolean | class | public | extends | static | void | main | String | int | while | if | else | return | length | true | false | this | new | System.out.println)
op           = ("&&" | "<" | "==" | "!=" | "+" | "-" | "*" | "!")
del          = (";" | "." | "," | "=" | "(" | ")" | "{" | "}" | "[" | "]")
id           = ({letter} | [_])({alphanumeric} | [_])*
int          = ([1-9]{digits}* | "0")

%%

{ws}  {/* Ignorar whitespace. */}
{com} {/* Ignorar comments. */}
{res} {System.out.println("token gerado foi um reservado: '"+yytext()+"' na linha: "+yyline+", coluna: "+yycolumn);}
{op}  {System.out.println("token gerado foi um operador: '"+yytext()+"' na linha: "+yyline+", coluna: "+yycolumn);}
{del} {System.out.println("token gerado foi um delimitador: '"+yytext()+"' na linha: "+yyline+", coluna: "+yycolumn);}
{id}  {System.out.println("token gerado foi um id: '"+yytext()+"' na linha: "+yyline+", coluna: "+yycolumn);}
{int} {System.out.println("token gerado foi um integer: '"+yytext()+"' na linha: "+yyline+", coluna: "+yycolumn);}

/* Insira as regras l�xicas no espa�o acima */     
     
. { throw new RuntimeException("Caractere ilegal! '" + yytext() + "' na linha: " + yyline + ", coluna: " + yycolumn); }
