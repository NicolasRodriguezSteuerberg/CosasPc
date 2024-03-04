from odoo import fields, models

class SecondTable(models.Model):
    _name = "puntos"
    _description = "Tabla que guarda usuarios y sus puntos"

    Nombre = fields.Char(string="Usuario")
    Puntos = fields.Integer(string="Puntos")