# Aula03 - Notes

```
Pedro Pinto (pmap@ua.pt)
Guilherme Santos (gui.santos91@ua.pt)
```

Compile .java code: `javac */*.java`

## III.1 Jogo do Galo

Enter de `galo` folder

```
$ cd galo
```

Run the game and enjoy it!

```
$ java JGalo
```

### III.2 Voos

Enter de `flight` folder

```
$ cd flight
```

* Interative Option

```
$ java Main
Opções do menu:
[H] - Ajuda
[I] <filename> - adiciona um voo definido num ficheiro de texto
[M] <flightCode> - exibe o mapa das reservas de um voo
[F] <flightCode> [seats_executive] <seats_touristic> - acrescenta um novo voo
[R] <flightCode> <T|E> <number_seats> - acrescenta uma nova reserva a um voo
[C] <flightCode>:<reservationID> - cancela uma reserva
[Q] - termina o programa

Escolha uma opção: (H para ajuda)
```
* Command File Option
```
$ java Main ./data/commands.txt 
```

Inside the `flight/data` folder are some flight's config examples to use for option `I`
```
flights1.txt
flights2.txt
flights3.txt
```

Clean .class files: `rm */*.class`
