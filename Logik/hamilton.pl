%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                                                              %
% < Namen, Matrikelnummern und Mail-Adressen ALLER Gruppenmitglieder >         %
%  Norman Vetter, 749229, nvetter@uni-potsdam.de
%  Julia Icken, 736256, icken@uni-potsdam.de                                                                          %
% (Pro Gruppe sind MAXIMAL ZwEI Mitglieder erlaubt!)                           %
%                                                                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Ihre Loesung                                                                 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% hamilton(+Start,+Graph,-Path)
% berechnet (in verschiedenen erfolgreichen Ableitungen) alle von dem Knoten
% "Start" ausgehenden Hamiltonkreise, wobei die Liste "Graph" von
% Termen der Form "r(N,R)" ueber die Adjazenzlisten "R" der Knoten "N" den
% zugrunde liegenden Graphen beschreibt.

hamilton(StartNode,Graph,[StartNode|Path]) :-
  select(r(StartNode,NList),Graph,Graphnew),member(NNext,NList),help(StartNode,NNext,Graphnew,Path).

help(StartNode,StartNode,[],[StartNode]).
help(StartNode,NNext,Graph,[NNext|Path]) :-       
              select(r(NNext,NList),Graph,Graphnew),member(N2Next,NList),help(StartNode,N2Next,Graphnew,Path).










%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Einige Testeingaben                                                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test(1,a,[r(a,[b]),r(b,[a,c]),r(c,[a])]).

test(2,a,[r(a,[b,e]),r(b,[c,d]),r(c,[f]),r(d,[a]),r(e,[c,d]),r(f,[b,e])]).

test(3,h,[r(a,[b]),r(b,[c,e]),r(c,[d,f]),r(d,[a,e]),r(e,[d,f,h]),r(f,[g]),r(g,[h]),r(h,[a,c,e])]).

test(4,h,[r(a,[b]),r(b,[c,e]),r(c,[d,f]),r(d,[a,e]),r(e,[d,f,h]),r(f,[g]),r(g,[f]),r(h,[a,c,e])]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Loesungen fuer die Testeingaben                                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

sols(1,[ [a,b,c,a] ]).

sols(2,[ [a,b,c,f,e,d,a], [a,e,c,f,b,d,a] ]).

sols(3,[ [h,a,b,c,d,e,f,g,h], [h,c,d,a,b,e,f,g,h], [h,e,d,a,b,c,f,g,h] ]).

sols(4,[ ]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Testpraedikate                                                               %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all/0: Testet alle vordefinierten Eingaben                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all :- test_all([1,2,3,4]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test_all(+TestCases): Testet alle Eingaben in TestCases                      %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test_all([]).
test_all([TestCase | TestCases]) :-
  write('Testcase '), write(TestCase), write(': '),
  test(TestCase), !, nl, test_all(TestCases).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% test(+TestCase): Testet eine einzelne Eingabe                                %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test(TestCase) :-
  test(TestCase,Start,Graph),
  sols(TestCase,Solutions),
  findall(Path,hamilton(Start,Graph,Path),AllPath),
  ((ground(AllPath), sort(AllPath,Solutions)) ->
    write(success)
  ;
    write(failure)
  ).
