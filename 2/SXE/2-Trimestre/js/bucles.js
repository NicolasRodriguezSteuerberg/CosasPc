// parecidos a java
let animales= ["gato", "perro", "pez"];

// nos saca los indices
for (animal in animales){
    document.write(animal + "<br>")
}

// saca la propiedad
for (animal of animales){
    document.write(animal + "<br>")
}