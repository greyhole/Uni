%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                                                        %
% < Namen, Matrikelnummern und Mail-Adressen ALLER Gruppenmitglieder >   %
%                                                                        %
% Verwendetes Prolog-System: < "SWI" oder "ECLiPSe" >                    %
%                                                                        %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

euler([]).
euler([node(V,N) | Graph]) :- empty([V],[node(V,N) | Graph]).

empty(_,[]) :- !.
empty([V | L],G) :-
  takeout(V,G,H,N),
  length(N,X), 0 is X mod 2,
  append(N,L,M),
  empty(M,H).

takeout(_,[],[],[]).
takeout(V,[node(V,N) | G],G,N) :- !.
takeout(V,[node(U,M) | G],[node(U,M) | H],N) :- takeout(V,G,H,N).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Einige ungerichtete Graphen und die dazugehoerigen Antworten           %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

graphs(1,[node(a,[b,c]),node(b,[a,c,d,e]),node(c,[a,b]),
          node(d,[b,e]),node(e,[b,d])]).
graphs(2,[node(a,[b,d]),node(b,[a,d]),node(c,[d,e]),
          node(d,[a,b,c]),node(e,[c])]).
graphs(3,[node(a,[b,c]),node(b,[a,c]),node(c,[a,b]),
          node(d,[e,f]),node(e,[d,f]),node(f,[d,e])]).
graphs(4,[node(a,[b,f]),node(b,[a,c]),node(c,[b,d]),
          node(d,[c,e]),node(e,[d,f]),node(f,[a,e])]).
graphs(5,[node(a,[b,c]),node(b,[a,c,d,e,f,g]),node(c,[a,b]),node(d,[b,e]),
          node(e,[b,d,f,g]),node(f,[b,e]),node(g,[b,e])]).

real_euler(1).    % Graph 1 hat einen Eulerkreis.
                  % Graph 2 hat keinen Eulerkreis.
                  % Graph 3 hat keinen Eulerkreis.
real_euler(4).    % Graph 4 hat einen Eulerkreis.
real_euler(5).    % Graph 5 hat einen Eulerkreis.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Testpraedikate                                                         %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all/0: Testet alle vordefinierten Eingaben                        %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all :- test_all([1,2,3,4,5]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all(+TestCases): Testet alle Eingaben in TestCases                %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all([]).
test_all([TestCase | TestCases]) :-
  write('Testcase '), write(TestCase), write(': '),
  test(TestCase), nl, test_all(TestCases).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test(+TestCase): Testet eine einzelne Eingabe                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test(TestCase) :-
  graphs(TestCase,Graph),
  (euler(Graph) ->
    (real_euler(TestCase) ->
      write(success)
    ;
      write(failure)
    )
  ;
    (not(real_euler(TestCase)) ->
      write(success)
    ;
      write(failure)
    )
  ).
