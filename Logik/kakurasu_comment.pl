%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                                                              %
% < Namen, Matrikelnummern und Mail-Adressen ALLER Gruppenmitglieder >         %
%                                                                              %
% (Pro Gruppe sind MAXIMAL ZwEI Mitglieder erlaubt!)                           %
%                                                                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Ihre Loesung                                                                 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% kakurasu(+Columns,+Rows,-Solution)
% berechnet (in verschiedenen erfolgreichen Ableitungen) alle Lösungen für
% das vorgegebene Kakurasu-Rätsel, wobei die Listen "Columns" und "Rows"
% die Summen der Spalten und Reihen als Liste vorgeben.

kakurasu(Rows,Cols,Solution) :-
 once(initSol(Cols,Rows, SolTemplate)),
 killer(Cols, ColsNew),
 killer(Rows, RowsNew),
 once(do(ColsNew,RowsNew,SolTemplate, Solution)).

do(Cols,Rows,SolTemplate, Solution) :-
%printB(Rows,Cols,SolTemplate),
 do(Cols,SolTemplate, SolTemp),writeln(Cols),
printB(Cols,Rows,SolTemp),
 do(Rows,SolTemp, Sol),writeln(Rows),
printB(Rows,Cols,Sol),
 (SolTemplate\=Sol,do(Cols,Rows,Sol, Solution),!;
1=1,Solution=Sol).
% getSol(Cols,Rows,Sol, Solution)).

do([],[], []).
do([Sum|Sums],[Sol|Sols], Solution) :-
 getSum(Sum,Sol, SolNew),
 do(Sums,Sols, SolsNew),
 connect(SolNew,SolsNew, Solution).

getSol(Cols,Rows,Sol, Solution) :-
 getSol(Cols,Sol, Sol2),
 do(Cols,Rows,Sol2, Solutions).
getSol([Col|Cols],[Sol|Sols], [Solution|Sols]) :-
 member(' ',Sol),
 guessSol(Col,Sol,0, Solution).
getSol([Col|Cols],[Sol|Sols], [Solution|Solutions]) :-
 getSol(Cols,Sols, Solution).

guessSol(0,[],_, []).
guessSol(Sum,[0|Sols],I, [0|Solutions]) :-
 INew is I+1, guessSol(Sum,Sols,INew, Solutions).
guessSol(Sum,[1|Sols],I, [1|Solutions]) :-
 INew is I+1, SumNew is Sum-INew,
 SumNew>=0,guessSol(SumNew,Sols,INew, Solutions).
guessSol(Sum,[' '|Sols],I, [Solution|Solutions]) :-
 INew is I+1, SumNew is Sum-INew, Solution=1,
 SumNew>=0, guessSol(SumNew,Sols,INew, Solutions).
guessSol(Sum,[' '|Sols],I, [Solution|Solutions]) :-
 INew is I+1, Solution=0,
 guessSol(Sum,Sols,INew, Solutions).

getSum(' ',Sol, Sol) :-!.
getSum(Sum,Sol, SolNew) :- getSum(Sum,Sol,0,0,0, _,_,SolNew).
getSum(Sum,[],_,_,_, 0,0,[]).
getSum(Sum,[1|Sols],I,Min,Max, NimNew,XamNew,[1|SolsNew]) :-
 INew is I+1, MinNew is Min+INew, MaxNew is Max+INew,
 getSum(Sum,Sols,INew,MinNew,MaxNew, Nim,Xam,SolsNew),
 NimNew is Nim+INew, XamNew is Xam+INew.
getSum(Sum,[0|Sols],I,Min,Max, Nim,Xam,[0|SolsNew]) :-
 INew is I+1,
 getSum(Sum,Sols,INew,Min,Max, Nim,Xam,SolsNew).
getSum(Sum,[' '|Sols],I,Min,Max, NimNew,XamNew,[SolNew|SolsNew]) :-
 INew is I+1, MaxNew is Max+INew,
 getSum(Sum,Sols,INew,Min,MaxNew, Nim,Xam,SolsNew),
 getValue(Sum,INew,Min,Max,Nim,Xam, NimNew,XamNew,SolNew).

getValue(Sum,I,Min,Max,Nim,Xam, NimNew,XamNew,Sol) :-
 (Max+Xam<Sum,Sol=1,writeln(Xam),writeln(Max),NimNew is Nim+I,XamNew is Xam+I,!;
  I+Min+Nim>Sum,Sol=0,NimNew=Nim,XamNew=Xam,!;
  Sol=' ',NimNew=Nim,XamNew is Xam+I).
%getValue(Sum,I,Min,Max,Nim,Xam, NimNew,XamNew,Sol) :- Sum>=Min+Nim+I,Sol=1,NimNew=Nim+I,XamNew=Xam+I.
%getValue(Sum,I,Min,Max,Nim,Xam, Nim,Xam,Sol) :- Sol=0.
 
initSol(Cols,Rows, Sol) :-
 length(Rows,X),length(Cols,Y),
 fill(X,' ', Tmp), fill(Y,Tmp, Sol).
fill(0,X, []).
fill(I,X, [X|Sol]) :- INew is I-1,fill(INew,X, Sol).

testSol(Sum,[],I) :- Sum=0.
testSol(Sum,[Col|Cols],I) :-
 Sum>=0,SumNew is Sum-I*Col,INew is I+1,
 testSol(SumNew,Cols,INew).

testSols([],[]).
testSols([Col|Cols],[Sol|Sols]) :- member(x,Sol), !, fail.
testSols([Col|Cols],[Sol|Sols]) :- testSol(Col,Sol,1),
 testSols(Cols,Sols).

%connect([a,b,c],[La,Lb,Lc], [[a|La],[b|Lb],[c|Lc]])
connect([],[], []).
connect([SolH|SolT],[], [[SolH]|Sol]) :-
 connect(SolT,[], Sol).
connect([SolH|SolT],[SolsH|SolsT], [[SolH|SolsH]|Sol]) :-
 connect(SolT,SolsT, Sol).

killer([], []).
killer([' '|T], [' '|TNew]) :-
 killer(T, TNew),!.
killer([H|T], [H|TNew]) :-
 killer(T, TNew). 

printB(S,Z,B) :-
 write('\t'),writeln(S),printBh(B,Z),writeln('').
printBh([],[]).
printBh([B|BR],[Z|ZR]) :-
 write(Z),write('\t'),writeln(B),printBh(BR,ZR).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Einige Testeingaben                                                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

test(1,[2,1],[2,1]).

test(2,[5,6,1,2],[3,7,1,2]).

test(3,[3,4,7,4],[_,_,1,9]).

test(4,[3,5,6,4,7],[8,4,12,5,2]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Loesungen fuer die Testeingaben                                              %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


sols(1,[ [[0,1],[1,0]] ]).

sols(2,[ [[0,0,1,0],[1,1,0,1],[1,0,0,0],[0,1,0,0]] ]).

sols(3,[ [[0,0,1,0],[0,0,1,0],[1,0,0,0],[0,1,1,1]] ]).

sols(4,[ [[1,0,1,1,0],[1,0,1,0,0],[0,0,1,1,1],[0,0,0,0,1],[0,1,0,0,0]] ]).

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
  findall(Path,kakurasu(Start,Graph,Path),AllPath),
  ((ground(AllPath), sort(AllPath,Solutions)) ->
    write(success)
  ;
    write(failure)
  ).