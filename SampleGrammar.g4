/**
 * Define a grammar called Hello
 
grammar Hello;
r  : 'hello' ID ;         // match keyword hello followed by an identifier

ID : [a-z]+ ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
*/
grammar MyGrammar;

program	
	:	 'BEGIN' 
		  IDENT* 
		  variable*
		  statement*
		  function* 
//		  declareType*
		  'END'
	;
	
variable
	: 	  type IDENT (',' IDENT )* ('=' expression | '=' STRING | CH)?
	| 	  type IDENT '[' INT+ ']' ('=' expression)? | type IDENT ('=' BOOLEAN)?
	;
	
type    
         : 'int'
	 | 'bool' 
	 | 'ch'
	 | 'string'
	 
	;

//declareType 
//	:	arrayType
//	;
	
//arrayType
//	: 'array' '[' INT* ']' type IDENT
//	;	
	
statement 
	: assignment	
	| ifStat
	| dowhileStat
	| funcCallStat
	| whileStat
	| displayStat
	//| forallStat
	//| exitStat
	;

ifStat	
	: 'if' expression statement+
	('elseif' expression statement+)*
	('else' statement+ )*
	'endif'	
	;

whileStat	
	: 'while'  expression 
	statement+
	'endwhile'
	;

displayStat
	: 'display' '(' (STRING|IDENT)  ')'
	;
	
forallStat 
	:	
	;
	
exitStat
	:
	;
	
funcCallStat
	: IDENT '(' actualParams? ')'
	;	
	
actualParams
	: expression (',' expression)*
	;	
	
function
	: 'function' type IDENT* '(' parameters? ')'
	 'BEGIN'
	 variable*
	 statement*
	 rtrnStat*
	 'END'
	;
	
rtrnStat
	: 'return' expression
	;
	
parameters
	: parameter (',' parameter)*
	;	

parameter	
	: type IDENT ('=' expression)?
	;
	
dowhileStat 
 	: 'do' statement*
 	 'while' expression
 	;
 			
assignment
	:		IDENT '=' expression
	;	
	
mathops 
	: IDENT
	| '(' expression ')'
	| INT
	;
notop
	: '!'* mathops
	;
unary 
	: ('+' | '-')* notop
	;
prod
	: unary (('*' | '/' | '%' ) unary)* 
	;

add 
	: prod (('+' | '-') prod)* 
	;
	
relop
	: add (( '=' | '!=' | '<' | '<=' | '>' | '>=' ) add)*
	;
	
expression 
	: relop (('AND' | 'OR' )relop)* 
	;	
	
fragment DIGIT 	:	 ('0'..'9') ;

INT	:  	 DIGIT+ ;

BOOLEAN	:	('true'|'false'); 

fragment LETTER  :	 ( 'a'..'z' | 'A'..'Z' );

IDENT 	:	 LETTER LETTER* DIGIT*;

STRING  :	'"' .*? '"' ; 

CH	:	'\'' . '\'' {setText(getText().substring(1,2));}; 

WS	:	 ((' ' | '\n' | '\r' )+)-> skip;

COMMENT :	 ('/*' .*?  '/*') -> skip;
 


