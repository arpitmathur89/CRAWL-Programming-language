/* NEW GRAMMAR */
grammar MyGrammar;

// My New Grammar

start :  begin (program) end
	  ;
  
program: 
		 statement*
		 function+
	   ;

	
variable
	: t=type id=IDENT ('=' E=expr)?
	;
	
	// int a = b + c;
	//visit(ctx.E)
	
	
	//ctx.t.gettEXT().EQUALS("int") / (BOOL)
	//String a = ctx.varName.getText()
	//push ..
	//mov a 
	//ctx.E.getText() a+b+v
	
	
	//visit(ID)
	//LOAD CTX.i.GETTEXT

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
	: 'display' '(' (id= IDENT)  ')'
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
	
NUMBER : DIGIT+;
	
fragment DIGIT 	:	 ('0'..'9')+ ;	

fragment LETTER  :	 ( 'a'..'z' | 'A'..'Z' );


begin : 'BEGIN'
	  ;
  	
end   : 'END'
	  ;
	  
RELOP : ( '==' | '!=' | '<' | '<=' | '>' | '>=' );

BOOLEAN	:	('true'|'false');

IDENT 	:	 LETTER LETTER* NUMBER*;

STRING  :	'"' .*? '"' ; 

WS	:	 ((' ' | '\n' | '\r' | '\t' )+)-> skip;		

COMMENT :	 ('/*' .*?  '*/') -> skip;












/* OLD ONE
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
 
*/

