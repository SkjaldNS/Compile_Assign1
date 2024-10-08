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
    | e1=exp op='+' e2=exp½              #Disjunction
    | i=IDENT p1='(' exp=exps p2=')'     #Function call
    | p1='(' e=exp p2=')'                #Expression
    ;


exps: exp (',' exp)*                     #Exps
args: IDENT (',' IDENT)*;                #Args
hardwaredecl : IDENT;                    #Hardware
inputs: (IDENT)+;                        #Inputs
outputs: (IDENT)+;                       #Outputs
latches: (IDENT)+;                       #Latches
def: (IDENT '(' args ')' '=' exp)*;      #Def
updates : (IDENT '=' exp)+;              #Updates
siminputs : (IDENT '=' BOOLEANS)+;       #Siminputs

BOOLEANS: [01]+;

IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;
