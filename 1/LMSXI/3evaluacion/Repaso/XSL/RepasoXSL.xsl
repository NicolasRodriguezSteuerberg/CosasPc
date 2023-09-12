<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
    <head>
      <meta charset="UTF-8"/>
      <link rel="stylesheet" type="text/css" href="RepasoXSL.css"/>
    </head>
    <body>
    <h2>Ejer1</h2>
    <h4>Creadores de los lenguajes</h4>
      <xsl:for-each select="//lenguaje">
        <p><ins>Creador:</ins><xsl:value-of select="creador"/></p>
      </xsl:for-each>
      <br/><br/>
      
      <h2>Ejer2</h2>
    <h4>Tabla nombres de los lenguajes</h4>
      <table>
        <tr><th>Nombre</th> <th>Creador</th></tr>
        <xsl:for-each select="//lenguaje">
          <tr><td><xsl:value-of select="nombre"/></td> <td><xsl:value-of select="creador"/></td></tr>
        </xsl:for-each>
      </table>
      <br/><br/>
      
      <h2>Ejer3</h2>
    <h4>Tabla lenguajes posteriores 1991</h4>
    <table>
      <xsl:for-each select="//lenguaje[fecha>1991]">
          <tr><td><xsl:value-of select="nombre"/></td> <td><xsl:value-of select="creador"/></td></tr>
        </xsl:for-each>
    </table>
    <p>Número de lenguajes posteriores a 1991: <xsl:value-of select="count(//lenguaje[fecha>1991])"/></p>
    <br/><br/>
    
    <h2>Ejer4</h2>
    <h4>Lista</h4>
    <ol>
      <xsl:for-each select="//lenguaje">
       <li>
        <strong><xsl:value-of select="nombre"/></strong>
         <ul>
          <li><xsl:value-of select="creador"></xsl:value-of>-<xsl:value-of select="fecha"/></li>
         </ul>
       </li>
      </xsl:for-each>
    </ol>
    <br/><br/>
    
      <h2>Ejer5</h2>
      <h4>Tabla lenguajes interpretados o compilados</h4>
      <table class="ultimo">
        <xsl:for-each select="//lenguaje">
          <tr class="ultimo"><td class="ultimo"><xsl:value-of select="nombre"/></td>
          <td class="ultimo"><xsl:choose>
          <xsl:when  test="name(compilado)">compilado</xsl:when>
          <xsl:otherwise>interpretado</xsl:otherwise>
          </xsl:choose></td></tr>
        </xsl:for-each>
      </table>
      <p>El nº de lenguajes interpretados es: <xsl:value-of select="count(//lenguaje[name(interpretado)])"/></p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
