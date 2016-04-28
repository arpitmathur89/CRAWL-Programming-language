grammar MyGrammar;

start :  begin (program) end
	  ;
  
program: 
		 statement*
		 function+
	   ;

	
variable
	: t=type id=IDENT ('=' E=expr)?
	;
	

statement 
	: assignment
	| variable	
	| ifStat
	| funcCallStat
	| whileStat
	| displayStat
	| rtrnStat
	| stacktype
	| stackoper
	;
	
ifStat	:
	ifstatement elsestat? 'endif'
	;
	
ifstatement: 'if' '(' exp=expr ')' st=statement+	
	;
	
elsestat: 'else' eS = statement+
    	;

whileStat	
	: 'while' '(' exp = expr ')'
	  st = statement+
	'endwhile'
	;

displayStat
	: 'display' '(' id= ( IDENT | STRING ) ')'
	;
	
funcCallStat
	: IDENT '(' actualParams? ')'
	;	
	
actualParams
	: pL=expr (',' pR=expr)*
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
	: L = expr ('/'|'*') R = expr   #MUL
	| L=expr ('+'|'-') R=expr  		#ADD
	| L=expr ROP = RELOP R=expr			#OP
	| funcCallStat 				#FCALL
	| NUMBER					#NUM
	| IDENT  					#IDEN
	| BOOLEAN					#BOOL
	;

assignment
	:		ID = IDENT '=' aE = expr 
	;	
	
type
	: 'int'
	| bl = 'bool'
	;
stacktype
    : 'stack' ID=IDENT
    ;

stackoper
	: PUSH=IDENT '.push' ('('StackNumber=NUMBER')')
	| POP=IDENT '.pop()'
	| PEEK=IDENT '.peek()'
	| EMPTY=IDENT '.isEmpty()' 
	;
	
NUMBER : DIGIT+;
	
fragment DIGIT 	:	 ('0'..'9')+ ;	

fragment LETTER  :	 ( 'a'..'z' | 'A'..'Z' );


begin : 'BEGIN'
	  ;
  	
end   : 'END'
	  ;
	  
RELOP :  EQ
	| 	NEQ	
	|   LE
	|  LEQ
	|  GE
	| GEQ
;
EQ: '==' ;
NEQ: '!=';
LE: '<';
LEQ: '<=';
GE: '>';
GEQ: '>=';


BOOLEAN	:	('true'|'false');

IDENT 	:	 LETTER LETTER* NUMBER*;

STRING  :	'"' .*? '"' ; 

WS	:	 ((' ' | '\n' | '\r' | '\t' )+)-> skip;		

COMMENT :	 ('/*' .*?  '*/') -> skip;


