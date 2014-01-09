erg1=$(./pi_pthread 1 10000000 | tail -n 1)
erg2=$(./pi_pthread 1 10000000 | tail -n 1)
erg3=$(./pi_pthread 1 10000000 | tail -n 1)
erg4=$(./pi_pthread 1 10000000 | tail -n 1)
erg5=$(./pi_pthread 1 10000000 | tail -n 1)
echo "Mittelwert_pthread(Threads=1)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_pthread 2 10000000 | tail -n 1)
erg2=$(./pi_pthread 2 10000000 | tail -n 1)
erg3=$(./pi_pthread 2 10000000 | tail -n 1)
erg4=$(./pi_pthread 2 10000000 | tail -n 1)
erg5=$(./pi_pthread 2 10000000 | tail -n 1)
echo "Mittelwert_pthread(Threads=2)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_pthread 6 10000000 | tail -n 1)
erg2=$(./pi_pthread 6 10000000 | tail -n 1)
erg3=$(./pi_pthread 6 10000000 | tail -n 1)
erg4=$(./pi_pthread 6 10000000 | tail -n 1)
erg5=$(./pi_pthread 6 10000000 | tail -n 1)
echo "Mittelwert_pthread(Threads=4)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_pthread 8 10000000 | tail -n 1)
erg2=$(./pi_pthread 8 10000000 | tail -n 1)
erg3=$(./pi_pthread 8 10000000 | tail -n 1)
erg4=$(./pi_pthread 8 10000000 | tail -n 1)
erg5=$(./pi_pthread 8 10000000 | tail -n 1)
echo "Mittelwert_pthread(Threads=8)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_pthread 16 10000000 | tail -n 1)
erg2=$(./pi_pthread 16 10000000 | tail -n 1)
erg3=$(./pi_pthread 16 10000000 | tail -n 1)
erg4=$(./pi_pthread 16 10000000 | tail -n 1)
erg5=$(./pi_pthread 16 10000000 | tail -n 1)
echo "Mittelwert_pthread(Threads=16)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_openmp 1 10000000 | tail -n 1)
erg2=$(./pi_openmp 1 10000000 | tail -n 1)
erg3=$(./pi_openmp 1 10000000 | tail -n 1)
erg4=$(./pi_openmp 1 10000000 | tail -n 1)
erg5=$(./pi_openmp 1 10000000 | tail -n 1)
echo "Mittelwert_openMP(Threads=1)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_openmp 2 10000000 | tail -n 1)
erg2=$(./pi_openmp 2 10000000 | tail -n 1)
erg3=$(./pi_openmp 2 10000000 | tail -n 1)
erg4=$(./pi_openmp 2 10000000 | tail -n 1)
erg5=$(./pi_openmp 2 10000000 | tail -n 1)
echo "Mittelwert_openMP(Threads=2)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_openmp 6 10000000 | tail -n 1)
erg2=$(./pi_openmp 6 10000000 | tail -n 1)
erg3=$(./pi_openmp 6 10000000 | tail -n 1)
erg4=$(./pi_openmp 6 10000000 | tail -n 1)
erg5=$(./pi_openmp 6 10000000 | tail -n 1)
echo "Mittelwert_openMP(Threads=4)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_openmp 8 10000000 | tail -n 1)
erg2=$(./pi_openmp 8 10000000 | tail -n 1)
erg3=$(./pi_openmp 8 10000000 | tail -n 1)
erg4=$(./pi_openmp 8 10000000 | tail -n 1)
erg5=$(./pi_openmp 8 10000000 | tail -n 1)
echo "Mittelwert_openMP(Threads=8)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc
erg1=$(./pi_openmp 16 10000000 | tail -n 1)
erg2=$(./pi_openmp 16 10000000 | tail -n 1)
erg3=$(./pi_openmp 16 10000000 | tail -n 1)
erg4=$(./pi_openmp 16 10000000 | tail -n 1)
erg5=$(./pi_openmp 16 10000000 | tail -n 1)
echo "Mittelwert_openMP(Threads=16)"
echo "scale=3;($erg1 + $erg2 + $erg3 + $erg4 + $erg5)/5" | bc

for i in 1 2 6 8 16
do
    tmp=0
    for ((c=0;c<5;c++))
    do
        tmp=$(  echo "scale=3;$(./pi_openmp $i 10000000 | tail -n 1) + $tmp" | bc)
    done
    echo "Mittelwert_openMP($i):"
    echo "scale=3;$tmp/5" | bc
done
