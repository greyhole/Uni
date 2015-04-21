#include <stdio.h> 
#include <math.h> //Standard Mathe Library 
#define START 0   //definieren des SART-Punktes für das Integral 

float func(float start, float step, int intervalCount){     //Funktionsdefinition mit Startstützstelle und Intervallweite, sowie Intervalanzahl als Parameter
  float ende = start + step;                                //berechnen des Intervalendes
  float value = (ende - start)*((sin(start)+sin(ende))/2);  //berechnen von T(f) im ausgewählten Intervall
  printf("%0.20f\n", value);                                //ausgabe der Zwischenrechnung
  
  if(intervalCount == 1)                                    //wenn Elementarfall intervalCount == 1 beende rekursion und gebe berechnete Werte zurück
      return value;
    else
      return value + func(ende, step, intervalCount - 1);   //Rekursionschritt mit Parameterübergabe und verminderung der rekursionvariablen intervalCount
}

int main (int argc, char *argv[]) { 
  int intervalCount;                       //Variable für Anzahl der Intervalle und Rekursionsvariable
  char BUF[10];                            //Buffer zum lesen von stdin

  printf("Intervalanzahl: ");
  fgets(BUF, 10, stdin);
  sscanf(BUF, "%d", &intervalCount);
  printf("Ergenis: %0.20f", func(START, M_PI / intervalCount, intervalCount)); //Ausgabe des berechneten Endergebnisses auf Stdout und Funktionsaufruf mit berechnung der Teilintervallweite als Parameter

  return 0;
}
