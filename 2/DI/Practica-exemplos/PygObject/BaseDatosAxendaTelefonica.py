import sqlite3 as dbapi

agendaTelefonica = (("Pepe", "Pérez", "986 444 555"),
                    ("Ana", "Yañéz", "985 333 777"),
                    ("Roque", "Díz", "987 222 889"),
                    )

# sqlitle si no existe la base de datos la crea
database = dbapi.connect("baseDatosListaTelefonos.dat")
# print(database)
cursor = database.cursor()
# print(cursor)

try:
    database.execute("""
        create table if not exists listaTelefonos (
            nome text,
            apelido text,
            telefono text
        )"""
    )
except dbapi.DatabaseError as e:
    print("Error creating listaTelefonos table:" + e.__str__())

try:
    for datos in agendaTelefonica:
        database.execute("""
            insert into listaTelefonos values(?,?,?)
        """, datos)
    database.commit() # si no haces el commit no se guardan los inserts
except dbapi.DatabaseError as e:
    print("Error in listaTelefonos insert")

try:
    cursor.execute("select * from listaTelefonos")
    for fila in cursor.fetchall():
        print(fila)
except dbapi.DatabaseError as e:
    print("Error in select")