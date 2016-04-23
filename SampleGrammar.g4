/* 
 * My Grammar for SER502
 *  
 */
grammar MyGrammar;

start : begin (program) end
	  ;

begin : 'BEGIN'
	  ;
	  	
end   : 'END'
	  ;
	  
program:  IDENT* 
		  variable*
		  statement*
		  function*
	   ;

	
variable
	: type IDENT (EQL expr)?
	;

statement 
	: assignment	
	| ifStat
	| funcCallStat
	| whileStat
	| displayStat
	| rtrnStat
	| stacktype
	| stackoper
	;
	
ifStat	
	: 'if' '(' expr ')' statement+
	('elseif' expr statement+)*
	('else' statement+ )*
	'endif'	
	;

whileStat	
	: 'while'  expr 
	statement+
	'endwhile'
	;

displayStat
	: 'display' '(' (STRING|IDENT)  ')'
	;
	
funcCallStat
	: IDENT '(' actualParams? ')'
	;	
	
actualParams
	: expr (',' expr)*
	;
	
function
	: 'function' type IDENT* '(' parameters? ')'
	 '{'
	 variable*
	 statement*
	 rtrnStat
	 '}'
	;
	
rtrnStat
	: 'return' expr
	;
	
parameters
	: parameter (',' parameter)*
	;	

parameter	
	: type IDENT
	;
				
expr
	: expr (DIV|MUL|MOD) expr
	| expr (ADD|SUB) expr
	| expr RELOP expr
	| funcCallStat 
	| NUMBER
	| IDENT
	| BOOLEAN
	;

assignment
	:		IDENT EQL expr 
	;	
	
type
	: 'int'
	| 'bool'
	;
stacktype
    : 'stack' IDENT
    ;

stackoper
	: IDENT '.push' ('('NUMBER')')
	| IDENT '.pop()'
	| IDENT '.peek()'
	| IDENT '.isEmpty()'
	;

OPR : ADD|SUB|MUL|DIV|EQL|MOD
	;

ADD : '+'
	;
	
SUB : '-'
	;
	
MUL : '*'
	;
	
DIV : '/'
	;
	
MOD : '%'
	;
		
EQL : '='
	;
					
NUMBER : DIGIT+;
	
fragment DIGIT 	:	 ('0'..'9')+ ;	

fragment LETTER  :	 ( 'a'..'z' | 'A'..'Z' );

RELOP : ( '==' | '!=' | '<' | '<=' | '>' | '>=' );

BOOLEAN	:	('true'|'false');

IDENT 	:	 LETTER LETTER* NUMBER*;

STRING  :	'"' .*? '"' ; 

WS	:	 ((' ' | '\n' | '\r' | '\t' )+)-> skip;		

COMMENT :	 ('/*' .*?  '/*') -> skip;


