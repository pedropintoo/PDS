# Aula01 - Notes

```
Pedro Pinto (pmap@ua.pt)
Guilherme Santos (gui.santos91@ua.pt)
```

## Objective 1 - Word Search Solver 

Read a word search puzzle from a file and solve it.

This was a recursive approach to solve the puzzle.

```
$ java src.WSSolver data/sdl_00.txt 
 
programming     11     5,11      Up             
java            4      0,8       Down           
words           5      10,10     UpLeft         
lines           5      4,4       Left           
civil           5      10,5      Down           
test            4      7,1       Right          
stack           5      0,0       Right          

S T A C K . . . . . . . 
. . . . . G . T E S T . 
. . . . . N . . . . . . 
. . . . . I . . . . . . 
S E N I L M . . . . . . 
. . . . . M . . . . C . 
. . . . . A S . . . I . 
. . . . . R . D . . V . 
J . . . . G . . R . I . 
A . . . . O . . . O L . 
V . . . . R . . . . W . 
A . . . . P . . . . . . 
```

Files with examples of word search puzzles solved are in the `data` directory.
```
sdl_00.txt > out0.txt
sdl_01.txt > out1.txt
sdl_02.txt > out2.txt
sdl_03.txt > out3.txt
```


## Objective 2 - Word Search Generator

Generate a word search puzzle.

This was a brute force approach to generate the puzzle. (solving the puzzle to check if it is valid)

```
$ java src.WSGenerator -i data/wlist0.txt -s 12 

STACKJCPAXLF 
YLKWUGGTESTL 
LNJSUNCUXZPD 
ETOFQIKICFNG 
SENILMJFUMRK 
ZBUUOMSBSKCY 
SUMTRASARZIX 
RBMWWRJDAXVF 
JEJHQGSDRAIB 
ACWEZOLMZOCT 
VIUQVRAMDGWH 
AGFTWPJZWUMH 
programming;java;words lines civic 
test;stack;
```

Files with examples of puzzles are in the `data` directory.
```
wlist0.txt > sopa0.txt
wlist1.txt > sopa1.txt
wlist2.txt > sopa2.txt
wlist3.txt > sopa3.txt
```
