"use sctrict";

const definirCompra = (n)=>{
    let dinero = prompt(`Dinero de ${n}`);
    if(dinero >= 0.6 && dinero < 1) return (`${n}: helado de agua`); // con este ejemplo me llega
    else return (`jaja`)
}

console.log(definirCompra("Cofla"))
console.log(definirCompra("Pedro"))