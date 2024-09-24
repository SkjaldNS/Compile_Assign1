grammar cc;

start   : 'hardware:' h = hardwaredecl
          'inputs:' i = inputs
          'outputs:' o = outputs
          'latches:' l = latches
          'def:'* d = def
          'updates:' u = updates
          'siminputs:' s = siminputs
          EOF ;

exp : IDENT
    | '/' exp
    | exp '*' exp
    | exp exp
    | exp '+' exp
    | IDENT '(' exps ')'
    | '(' exp ')'
    ;


exps: exp (',' exp)*;
hardwaredecl : IDENT;
inputs: (IDENT)+;
outputs: (IDENT)+;
latches: (IDENT)+;
def: (IDENT '(' exps ')' '=' exp)*;
updates : (IDENT '=' exp)+;
siminputs : (IDENT '=' BOOLEANS)+;

BOOLEANS: [01]+;

IDENT : [a-zA-Z][a-zA-Z0-9_]*[']?;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~[\n]* -> skip;
LONG_COMMENT : '/*' (~[*] | '*'~[/])* '*/' -> skip;