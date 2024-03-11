# -*- coding: utf-8 -*-

from odoo import fields, models

class TestEdad(models.Model):
    _name = "test_edad_model"
    _description = "Test Model"

    name = fields.Char(string="Nombre")
    edad = fields.Integer(string="Edad")