grammar cc;

start   : cs+=line* EOF ;

line :  'hardware:' x=IDENT                                        #Hardware
	|'inputs:' l=LIST                                            #Input
	|'outputs:' l=LIST                                           #Output
	|'latches:' l=LIST                                           #Latch   
	|'def:' (i=IDENT c1='(' l=LIST c2=')' eq='=' e=exp)*       #Def
	|'updates:' (i=IDENT eq='=' e=exp)+                        #Update
	|'siminputs:' (i=IDENT eq='=' b=BOOLEAN)+                  #SimInput
	;

exp : x=IDENT                            #Signal
    | op='/' e=exp                       #Not
    | e1=exp op='*'? e2=exp              #Conjunction
    | e1=exp op='+' e2=exp               #Disjunction
    | i=IDENT p1='(' ex=EXPS p2=')'      #Function_call
    | p1='(' e=exp p2=')'                #Expression
    ;

LIST: IDENT (',' IDENT)*;
EXPS: exp (',' exp)*;
BOOLEAN: [01]+;
IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
