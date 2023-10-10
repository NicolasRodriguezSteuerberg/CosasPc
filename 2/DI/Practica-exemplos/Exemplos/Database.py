import sqlite3 as dbapi
"""
print(dbapi.apilevel)
print(dbapi.threadsafety)
print(dbapi.paramstyle)
"""

# sqlitle si no existe la base de datos la crea
database = dbapi.connect("baseDatos.dat")
# print(database)
cursor = database.cursor()
# print(cursor)
''' already created
try:
    database.execute("""
        create table user(dni text,
                      name text,
                      age integer
        )"""
    )


except dbapi.DatabaseError as e:
    print("Error creating user table:" + e)
'''
'''
try:
    database.execute("""
        insert into user values('3333-a',"Ana Perez", 19)
    """)
    database.execute("""
        insert into user values('2222-b',"Roque Diaz", 56)
    """)
    database.execute("""
        insert into user values('1111-c',"Fiz Vidal", 37)
    """)
    database.commit() # si no haces el commit no se guardan los inserts
except dbapi.DatabaseError as e:
    print("Error in user insert")
'''

'''
try:
    database.execute("""
        create table password(name text,
                      pswd text
        )"""
    )


except dbapi.DatabaseError as e:
    print("Error creating user table:" + e)
'''
'''
try:
    database.execute("""
        insert into password values("Nico", "papasito")
    """)
    database.execute("""
        insert into password values("Lidier", "Chaqueta azul")
    """)
    database.execute("""
        insert into password values("Soulnes","FURROOOOS")
    """)
    database.commit() # si no haces el commit no se guardan los inserts
except dbapi.DatabaseError as e:
    print("Error in user insert")
'''
dni = "3333-a' or 'z'='z" # "';select *from password where 't'=t" # de esta manera metes mas condiciones y otro select :) -> NO FUNCIONA
name = "Nico"
try:
    consultation = database.execute("""select dni, name from user""")
    '''
    consulta = database.execute("""
        select * from user where dni = '""" + dni + "'"
    )
    '''
    consulta = database.execute("""select name, pswd from password where name = ?""",(name,)) # tiene que recibir una TUPLA O LISTA
    print(consulta)

    consulta2 = database.execute("""\d""")
except dbapi.OperationalError as e:
    print("Error in select from user: " + str(e))


for resultado in consulta:
    print (resultado)

print()
for resultado in consultation:
    print (resultado)

print()
for resultado in consulta2:
    print (resultado)