def func1(cadea):
    c = ""
    for i in range(len(cadea)):
        if (i+1) == len(cadea):
            c += cadea[i]
        else:
            c += cadea[i] + ","
    print(c)

def func2(cadea, caracter):
    print(cadea.replace(" ", caracter))

def func3(cadea, caracter):
    for element in cadea:
        if element.isdigit():
            cadea = cadea.replace(element,caracter)
    print(cadea)

def func4(cadea,caracter):
    aux = ""
    for i in range(len(cadea)):
        if (i+1) % 3 == 0:
            aux += cadea[i] + caracter
        else:
            aux += cadea[i]
    print(aux)

func1("separar")
func2("meu arquivo de texto.txt", "\_")
func3("Sua clave é: 1540", "X")
func4("2552552550",".")