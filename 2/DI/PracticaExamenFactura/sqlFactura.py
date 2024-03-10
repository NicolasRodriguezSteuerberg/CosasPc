import sqlite3 as dbapi

"""
print(dbapi.apilevel)
print(dbapi.threadsafety)
print(dbapi.paramstyle)
"""


bbdd = dbapi.connect("baseFactura.dat")
# print(bbdd)
c = bbdd.cursor()
# print(c)
'''
try:
    c.execute("""
        create table facturar(
            cliente text,
            domicilio text,
            codigo_postal integer,
            nif text,
            fecha text,
            n_pedido integer,
            fecha_vencimiento text,
            condiciones_pago text
       )
   """)
except dbapi.DatabaseError as e:
    print("Error creando la tabla de facturar" + str(e))

try:
    c.execute("""insert into facturar values ('Ana Perez', 'Calle de la Rosa', 27001, '3333-a', '12/12/2019', 123, '12/01/2020', '30 días')""")
    c.execute("""insert into facturar values ('Roque Diz', 'Calle de la Amapola', 27002, '2222-b', '12/12/2019', 124, '12/01/2020', '20 días')""")
    c.execute("""insert into facturar values ('Fiz Vidal', 'Calle de la Margarita', 27003, '1111-c', '13/12/2019', 125, '13/01/2020', '7 días')""")
    c.execute("""insert into facturar values ('Rosa Pino', 'Calle del Lirio', 27004, '4444-c', '15/12/2019', 126, '15/01/2020', 'Instantáneo')""")
    bbdd.commit()
except dbapi.OperationalError as e:
    print("Error insertanto en la tabla de facturar" + str(e))
'''

def consultaFactura():
    try:
        consulta = c.execute("""select * from facturar""")
        print(type(consulta))

    except dbapi.OperationalError as e:
        print("Error en la consulta de facturar: "+ str(e))

def insertarFactura(*params):
    try:
        c.execute("""insert into facturar values (?,?,?,?,?,?,?,?)""", params)
        bbdd.commit()
    except dbapi.OperationalError as e:
        print("Error insertanto en la tabla de facturar" + str(e))