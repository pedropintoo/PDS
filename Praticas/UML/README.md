## Dependencies
| **⚠️ REQUIRED**|
|---------------|
```
sudo apt install graphviz
```

## Automatic
Generate **../lab06/Pastelaria** UML diagram
```
./generateUML.sh ../lab06/Pastelaria
```

## Manual
Generate **../lab06/Pastelaria** java code to PlantUML code
```
java -jar java2plantuml.jar ../lab06/Pastelaria
```

Run PlantUML code **output.puml**
```
java -jar plantuml-mit-1.2024.4.jar output.puml
```

It will generate a **output.png** file in the script directory
