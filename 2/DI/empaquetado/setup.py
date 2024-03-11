from setuptools import setup, find_packages

setup(
    name = "ejemplo setup",
    versuin = "0.0.1",
    description = "Ejemplo de setuptools",
    long_description = "esta es una explicación larga sobre el proyecyo",
    author = "Nico",
    author_email = "nrodriguezsteuerberg@danielcastelao.org",
    license = "glp",
    url = "http://danielcastelao.org",
    scripts = ["otro_modulo.py"],
    py_modules = ["moduloUno"],
    # packages=["paqueteProyecto", "paqueteProyecto.paqueteDelPaqueteProyecto"],
    packages=find_packages(),
)