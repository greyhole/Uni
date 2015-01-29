grammar MGPL;

options {
	backtrack=false;
	output=AST;
	k=1;
}

// token rules
tokens {
        RECTANGLE   	= 'rectangle';
        TRIANGLE    	= 'triangle';
        CIRCLE      	= 'circle';
        ANIMATION   	= 'animation';
        ON          	= 'on';
        SPACE       	= 'space';
        LEFTARROW   	= 'leftarrow';
        RIGHTARROW  	= 'rightarrow';
        UPARROW     	= 'uparrow';
        DOWNARROW   	= 'downarrow';
        TOUCHES     	= 'touches';
}

// java header
@header {
package antlr.projekt1;
}

@lexer::header {
package antlr.projekt2;
}

// parser rules
prog        	: 'game' IDF '(' attrAssList? ')' decl* stmtBlock block*;
decl        	: varDecl ';' | objDecl ';';
varDecl     	: 'int' IDF (init? | '[' NUMBER ']') ;
init        	: '=' expr ;
objDecl     	: objType IDF ('(' attrAssList? ')' | '[' NUMBER ']') ;
objType     	: RECTANGLE | TRIANGLE | CIRCLE;
attrAssList	: attrAss (',' attrAss)* ;
attrAss	: IDF '=' expr ;
block       	: animBlock | eventBlock;
animBlock   	: ANIMATION IDF '(' objType IDF ')' stmtBlock ;
eventBlock  	: ON keyStroke stmtBlock ;
keyStroke   	: SPACE 
	| LEFTARROW 
	| RIGHTARROW 
	| UPARROW 
	| DOWNARROW ;
stmtBlock   	: '{' stmt* '}' ;
stmt        	: ifStmt | forStmt | assStmt;
ifStmt      	: 'if' '(' expr ')' stmtBlock ( 'else' stmtBlock )?;
forStmt    	 : 'for' '(' assStmt ';' expr ';' assStmt ')' stmtBlock;
assStmt 	: var '=' expr ;
var         	:	 
	IDF ( '[' expr ']' ( '.' IDF)? 
	|  '.' IDF)?
	;

// expressions with paran '&&' precedence
expr 	:  '(' expr ')' 
	| (op ('(' expr ')')? )* ;
op 	: konjunkt ('||' konjunkt)* ;
konjunkt	: relat ('&&' relat)* ;
relat	: add (('==' | '<' | '<=') add)* ;
add	: mult (('+' | '-') mult)* ;
mult	: unary (( '*' | '/') unary)* ;
unary	: ('!' | '-')? atom ;
atom 	: NUMBER 
	| var  (TOUCHES var)? ;

// lexer rules 
IDF                 	:   (LOWCASE | UPCASE ) ( '_' | DIGIT | LOWCASE | UPCASE )* ;
NUMBER              	:   (DIGIT)+ ;
fragment LOWCASE    	:   'a' .. 'z' ;
fragment UPCASE     	:   'A' ..  'Z' ;
fragment DIGIT      	:   '0' .. '9' ;
WS		: ( ' ' | '\r' | '\t' | '\u000C' | '\n' ) {skip();} ;

// comments
SINGLE_COMMENT	: '//' ~( '\r' | '\n' )* 	{ skip();};
