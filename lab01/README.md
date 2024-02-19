# Aula01 - Notes

to do

VALIDACAO EM RUNTIME!

ler contar
ver minuscula

targets em minusculas e com regex " " ";" "," "."

7.- apenas podem estar 1 vez! ... 
lookup
nao podemos parar a pesquisa


Hash Map

k   |   v
Ola     [((0,1), up), ... ] -> SE TIVER MAIS DE 1 ELEMENTO ENCONTRAMOS MAIS DE UMA PALAVRA (ATENCAO AO 8.-)
Bola    [...]


Right      (1,0)
Left       (-1,0)
Up         (0,1)
Down       (0,-1)
Right-Up   (1,1)
Right-Down (1,-1)
Left-Up    (-1,1)
Left-Down  (-1,-1)


Algoritmo Recursivo

-Posicao
-Vetor direcao
-Palavra

O x x
x L x
x x A

-Posicao        (0,0)               (0,0)               (0,0)
-Vetor direcao  (0,1)               (1,-1)              (1,-1)
-Palavra        "LA"                "LA" (ENCONTREI)    "A" (ECONTREI e acabou! "")
                  X (NAO ENCONTREI)                         RETORNAR TRUE!!!
                  testar outra direcao

Depois de retornar o True preenchemos o Mapa:
Ola     [((0,0), right-down)]
