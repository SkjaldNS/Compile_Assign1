grammar cc;

start   : 'hardware:' h = hardwaredecl
          'inputs:' ip = inputs
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


exps: e1=exp (c=',' e2=exp)*;
args: i1=IDENT (c=',' i2=IDENT)*;
hardwaredecl : i=IDENT;
inputs: i=(IDENT)+;
outputs: i=(IDENT)+;
latches: i=(IDENT)+;
def: (i=IDENT c1='(' a=args c2=')' eq='=' e=exp)*;
updates : (i=IDENT eq='=' e=exp)+;
siminputs : (i=IDENT eq='=' b=BOOLEANS)+;

BOOLEANS: [01]+;

IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
