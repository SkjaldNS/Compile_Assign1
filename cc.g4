grammar cc;

start   : 'hardware:' h = hardwaredecl
          'inputs:' i = inputs
          'outputs:' o = outputs
          'latches:' l = latches
          ('def:' d = def)*
          'updates:' u = updates
          'siminputs:' s = siminputs
          EOF ;

exp : IDENT                              #Signal
    | op='/' e=exp                       #Not
    | e1=exp op='*'? e2=exp              #Conjunction
    | e1=exp op='+' e2=exp               #Disjunction
    | i=IDENT p1='(' ex=exps p2=')'      #Function_call
    | p1='(' e=exp p2=')'                #Expression
    ;


exps: exp (',' exp)*;
args: IDENT (',' IDENT)*;
hardwaredecl : IDENT;
inputs: (IDENT)+;
outputs: (IDENT)+;
latches: (IDENT)+;
def: (IDENT '(' args ')' '=' exp)*;
updates : (IDENT '=' exp)+;
siminputs : (IDENT '=' BOOLEANS)+;

BOOLEANS: [01]+;

IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
