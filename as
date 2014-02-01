.data
data1 : .word 164, 5
data7 : .byte 2,9
data2 : .word 256
data3 : .word -4
data4 : .word 128
data5 : .space 5
data10: .word 6
data6 : .float 3.6 ,7.77
data8 : .half 11
data9 : .double 23.234
.text 0x400000
main : 
la $2 ,data1
li $3 , 4
lw $5 , ($2)
lw $6 , 4($2)
lw $7 , data3
lw $8 , data2 + 4
lw $9 , data1 + 8( $3 )
# Adressen
la $s0 , data1
la $s6 , data2
la $s7 , data3
la $s1 , data4
la $t7 , data5
la $s2 , data6
la $s3 , data7
la $s4 , data8
la $s5 , data9

li $v0 , 10
syscall