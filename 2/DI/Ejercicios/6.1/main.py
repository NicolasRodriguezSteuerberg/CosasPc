# This is a sample Python script.
def func1(cadea):
    print(cadea[0:2])

def func2(cadea):
    aux = len(cadea)
    print(cadea[aux-3:aux])

def func3(cadea):
    # print(cadea[0:len(cadea):2])
    print(cadea[::2])

def func4(cadea):
    txt = cadea[::-1]
    print(txt)

def func5(cadea):
    txt = cadea[::-1]
    print(cadea + txt)

func1("hola")
func2("hola")
func3("holamiamigo")
func4("Hola mundo!")
func5("reflexo")