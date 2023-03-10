# Patrón factory con tipos de transportes de mensajeria

---
### Prodecimiento
Para el caso de esta 'aplicacion', queremos saber el coste de envió y el tipo de embalaje. Para calcular esto se precisa saber que tipo de transporte se va a usar. A parte, necesitamos saber el codigo postal a donde hay que llevar el envió, las dimensiones y el peso del paquete. 

---
### Coste de envió
	En el caso de camión para calcular el coste de envió, necesitamos sacar la diferencia de los codigos postales y multiplicar esta diferencia por 0,04, si la diferencia es 0, el precio será 0.4€. En cambio para el de la bicicleta sacamos la diferencia y la multiplicamos por 0.02, si la diferencia es 0, el precio será 0.2€.
	
---
### Tipo de embalaje
	En este método, van a ser lo mismo en los dos métodos de envió. Si la suma de las dimensiones es menor o igual que 150 y el peso es menor o igual de 40 es caja de madera. Si la suma de las dimensiones es menor o igual que 3000 y el peso menor o igual que 100 es caja de carton. Si no es ninguna de estas 2 es de tipo palet
