%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                                                              %
% < Namen, Matrikelnummern und Mail-Adressen ALLER Gruppenmitglieder >         %
%                                                                              %
% (Pro Gruppe sind MAXIMAL DREI Mitglieder erlaubt!)                           %
%                                                                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Deklaration von Junktoren als Prolog-Operatoren                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

:- op(410, fy, ~ ).  % Negation
:- op(420,xfy, & ).  % Konjunktion
:- op(430,xfy, ? ).  % Disjunktion
:- op(440,xfy,==>).  % Implikation
:- op(450,xfy,<=>).  % Aequivalenz

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Ihre Loesung                                                                 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% minModel(+ListOfFormulas,-MinimalModel)
% berechnet (in verschiedenen erfolgreichen Ableitungen) alle minimalen Modelle
% "MinimalModel" der durch "ListOfFormulas" gegebenen Liste aussagenlogischer
% Formeln, wobei die Liste "MinimalModel" wahrer Atome genau dann minimal ist,
% wenn keine echte Teilmenge der Atome ein Modell fuer "ListOfFormulas" bildet.

MinModel(ListOfFormulas,MinimalModel) :-findall(ListOfFormulas,true,MinimalModel).
p(~G) :- p\+ G.
p(F & G) :- p(F , G).
p(F ? G) :- p(F ; G).
p(F ==> G) :- p(F -> G).
p(F <=> G) :- p(F == G).
foo(a;b,c).
foo(a,b).
foo(a).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Einige Eingaben mit ihren jeweiligen minimalen Modellen                      %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

formulas(1 ,[]).
formulas(2 ,[p, ~p]).
formulas(3 ,[p, ~p ? q]).
formulas(4 ,[~p ==> q]).
formulas(5 ,[p <=> q ==> p]).
formulas(6 ,[~p & q ==> r, q ? r]).
formulas(7 ,[~p ==> q & r, ~p ? q ? r]).
formulas(8 ,[~p ==> q ? r, ~q ? ~r ==> p]).
formulas(9 ,[~p ? ~q & r, p ==> q, q ? r]).
formulas(10,[~p ? ~q & r, p ==> q, ~(q & r)]).
formulas(11,[~p ? ~q & r, p <=> ~q, ~(q & r)]).
formulas(12,[~p ? ~q & r, p <=> ~r, ~(~p & r)]).

minimals(1 ,[[]]).
minimals(2 ,[]).
minimals(3 ,[[p,q]]).
minimals(4 ,[[p], [q]]).
minimals(5 ,[[p], [q]]).
minimals(6 ,[[p,q], [r]]).
minimals(7 ,[[p,q], [p,r], [q,r]]).
minimals(8 ,[[p], [q,r]]).
minimals(9 ,[[q], [r]]).
minimals(10,[[]]).
minimals(11,[[p,r], [q]]).
minimals(12,[]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Testpraedikate                                                               %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all/0: Testet alle vordefinierten Eingaben                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all :- test_all([1,2,3,4,5,6,7,8,9,10,11,12]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all(+TestCases): Testet alle Eingaben in TestCases                      %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all([]).
test_all([TestCase | TestCases]) :-
  write('Testcase '), write(TestCase), write(': '),
  test(TestCase), nl, test_all(TestCases).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test(+TestCase): Testet eine einzelne Eingabe                                %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test(TestCase) :-
  formulas(TestCase,ListOfFormulas),
  minimals(TestCase,SortedModels),
  findall(SortedModel,testMinModel(ListOfFormulas,SortedModel),MinimalModels),
  (sort(MinimalModels,SortedModels) ->
    write(success)
  ;
    write(failure)
  ).

testMinModel(ListOfFormulas,SortedModel) :-
  minModel(ListOfFormulas,MinimalModel),
  ground(MinimalModel),
  sort(MinimalModel,SortedModel).
