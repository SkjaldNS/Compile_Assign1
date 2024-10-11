grammar cc;

start   : cs+=line* EOF ;

line :  'hardware:' x=IDENT                                     #Hardware
	|'inputs:' l=LIST                                       #Input
	|'outputs:' l=LIST                                      #Output
	|'latches:' l=LIST                                      #Latch   
	|'def:' (i=IDENT '(' l=LIST ')' '=' e=exp)*             #Def
	|'updates:' (i=IDENT '=' e=exp)+                        #Update
	|'siminputs:' (i=IDENT '=' b=BOOLEAN)+                  #SimInput
	;

exp : x=IDENT                            #Signal
    | '/' e=exp                          #Not
    | e1=exp '*'? e2=exp                 #Conjunction
    | e1=exp '+' e2=exp                  #Disjunction
    | i=IDENT '(' ex=EXPS ')'            #Function_call
    | '(' e=exp ')'                      #Expression
    ;

LIST: IDENT (',' IDENT)*;
EXPS: exp (',' exp)*;
BOOLEAN: [01]+;
IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
