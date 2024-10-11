grammar cc;

start   : cs+=line* EOF ;

line :  'hardware:' x=IDENT                                     #Hardware
	|'inputs:' l=args                                      #Input
	|'outputs:' l=args                                      #Output
	|'latches:' l=args                                      #Latch   
	|'def:' (i=IDENT '(' l=args ')' '=' e=exp)*             #Def
	|'updates:' (i=IDENT '=' e=exp)+                        #Update
	|'siminputs:' (i=IDENT '=' b=BOOLEAN)+                  #SimInput
	;

exp : x=IDENT                            #Signal
    | '/' e=exp                          #Not
    | e1=exp '*'? e2=exp                 #Conjunction
    | e1=exp '+' e2=exp                  #Disjunction
    | i=IDENT '(' ex=exps ')'            #Function_call
    | '(' e=exp ')'                      #Expression
    ;

args: x1=IDENT (s+= ' ' x2+=IDENT)*;
exps: e1=exp (c+=',' e2+=exp)*;

BOOLEAN: '0'|'1';
IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
