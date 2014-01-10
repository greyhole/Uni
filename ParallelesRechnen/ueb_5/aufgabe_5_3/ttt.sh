for i in 1 2 6 8 16
do
    for ((c=0;c<5;c++))
    do
        openmp[$c]=$(./pi_openmp $i $1 | tail -n 1)
        pthread[$c]=$(./pi_pthread $i $1 | tail -n 1)

    done
    mittel=$(echo "(${openmp[0]} + ${openmp[1]} + ${openmp[2]} + ${openmp[3]} + ${openmp[4]})/5" | bc -l)
    echo "Mittelwert_openMP($i): $mittel"
    mf=$(echo "sqrt(((${openmp[0]} - $mittel)^2 + (${openmp[1]} - $mittel)^2 + (${openmp[2]} - $mittel)^2 + (${openmp[3]} - $mittel)^2 + (${openmp[4]} - $mittel)^2)/5)"| bc -l)
    echo "Standardabweichung_openMP($i): $mf"
    echo
    echo
    mittel=$(echo "(${pthread[0]} + ${pthread[1]} + ${pthread[2]} + ${pthread[3]} + ${pthread[4]})/5" | bc -l)
    echo "Mittelwert_pthread($i): $mittel"
    mf=$(echo "sqrt(((${pthread[0]} - $mittel)^2 + (${pthread[1]} - $mittel)^2 + (${pthread[2]} - $mittel)^2 + (${pthread[3]} - $mittel)^2 + (${pthread[4]} - $mittel)^2)/5)"| bc -l)
    echo "Standardabweichung_pthread($i): $mf"
    echo
    echo
done
