# -*- coding: utf-8 -*-
# from odoo import http


# class Prueba2(http.Controller):
#     @http.route('/prueba2/prueba2', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/prueba2/prueba2/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('prueba2.listing', {
#             'root': '/prueba2/prueba2',
#             'objects': http.request.env['prueba2.prueba2'].search([]),
#         })

#     @http.route('/prueba2/prueba2/objects/<model("prueba2.prueba2"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('prueba2.object', {
#             'object': obj
#         })
