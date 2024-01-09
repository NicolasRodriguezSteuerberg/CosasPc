import random

from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def hello_world():  # put application's code here
    return render_template('index.html', lugar="Cangas")

@app.route('/hola')
def hola():
    minumero = random.randint(1, 100)
    return 'Hola Mundo! '+ str(minumero)

@app.route('/<int:numero>')
def numero(numero):
    multiplicado = numero * 10
    return str(multiplicado)

if __name__ == '__main__':
    app.run()
