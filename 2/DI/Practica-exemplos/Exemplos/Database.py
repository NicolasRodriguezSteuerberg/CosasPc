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
'''already executed
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
except dbapi.DatabaseError as e:
    print("Error in user insert")
'''

try:
    consultation = cursor.execute("""select dni, name from user""")
    print(consultation)
except dbapi.OperationalError as e:
    print("Error in select from user: " + str(e))

for resultado in cursor:
    print (resultado)