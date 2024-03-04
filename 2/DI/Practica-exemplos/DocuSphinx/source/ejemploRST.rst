Cabeceira
=========
Para escribir párrafos simplemente escibimos.
Si queremos remarcar con **negritas** necesitamos ponerlo entre ** dobles. Si queremos ponerlas entre *cursivas* lo hacemos entre * simples.

Os distintos niveles de de sección se escriben de la siguiente forma:

.. _nivelSecciones:

Niveles secciones
-----------------
- = para secciones(cabeceras, necesitas mas de 1)
- - para subsecciones
- ^ para subsubsecciones
- " para parrafos

Para poner en negrita en una palabra, Ho\ **la**\ aaa ("Ho'\' '**'la'**'\'a") (pero sin '')

Hola
====

Haa
---
Hello meu

Fodor
^^^^^

Listas
------

Listas desordenadas
^^^^^^^^^^^^^^^^^^^

* Elemento1

 * Otro subelemento

* Elemento2

 * Subelemento


Listas ordenadas
^^^^^^^^^^^^^^^^
1. Primer elemento
2. Segundo elemento

 2.1. Con subnivel
 2.2 Con otro

Listas de definiciones
^^^^^^^^^^^^^^^^^^^^^^
Término 1
 Definicion 1

 Definicion 2
Siguiente termino
 Definicion 1

Bloques literales
^^^^^^^^^^^^^^^^^
Despues de un texto::

 def hola():
    print("Hola mundo")


Hipervinculos
^^^^^^^^^^^^^

Enlaces externos
````````````````

Podemos consultar la documentacion de uso de `restructuredtext <http://www.sphinx-doc.org/en/master/usage/restructuredtext/basics.html>`_ para consultar la ayuda.

El parrafo tiene un enlace a la pagina principal de `Daniel Castelao`_.

.. _Daniel Castelao: https://www.danielcastelao.org

Enlaces internos
````````````````
Puedo hacer referencias con una etiqueta colocada arriba con :ref:`nivelSecciones`.

Taboas
^^^^^^

+------------+------------+------------+
| Cabecera   | Cabecera2  | Cabecera3  |
+============+============+============+
| Contido    | Contido2   | Contido3   |
+------------+------------+------------+
| Contido1.1 | Contido2.1 | Contido3.1 |
+------------+------------+------------+

Otra forma más facil

========== =======
Lunes      Martes
========== =======
Di         Di
Di         Di
Di         Libre
Di         Libre
Descanso   Descanso
Sxe        Libre
Sxe        Libre
Sxe        Libre
========== =======

Imaxes
^^^^^^

.. image:: _static/images/tom_baker.jpg
   :height: 200px
   :width: 200 px
   :scale: 100%
   :alt: tom baker
   :align: center

Notas de pie:
`````````````
Este texto está realizado con Spinhx [#n1]_ para realizar la documentación.

Directivas
``````````

..
    Las posibilidades de las directivas son:
    Attention, cuation, danger, error, hint, important, note, tip, warning

.. rubric::Notas

.. [#n1] Podes encontrar más información en `Sphinx`_.

.. _Sphinx: http://www.sphinx-doc.org

.. Danger::
   Este es un mensaje de peligro

.. Attention::
   Este es un mensaje de atención

.. Caution::
   Este es un mensaje de precaución

.. Important::
   Este es un mensaje importante

.. Tip::
    Este es un mensaje de consejo

