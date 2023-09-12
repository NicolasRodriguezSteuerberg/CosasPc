<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
      <meta charset="UTF-8"/>
      <link rel="stylesheet" type="text/css" href="examen.css"/>
    </head>
  <body>
  
    <h1>Ejercicio 1</h1>
      <xsl:for-each select="//empresa">
      <p>
        <strong>Nombre: </strong> <xsl:value-of select="nombre"/><br/>
        <strong>Índice: </strong><xsl:value-of select="@indice"/>
      </p>
      </xsl:for-each>
      
      
      <h1>Ejercicio 2</h1>
      <xsl:for-each select="//empresa">
      <xsl:sort select="precio"/>
      <p>
        <strong>Nombre: </strong> <xsl:value-of select="nombre"/><br/>
        <strong>Precio: </strong><xsl:value-of select="precio"/>
      </p>
      </xsl:for-each>
      
      
      <h1>Ejercicio 3</h1>
      <div>
      <xsl:for-each select="//empresa">
        <strong>Simbolo: </strong> <xsl:value-of select="simbolo"/><br/>
        <strong>Precio: </strong>
        <xsl:choose>
          <xsl:when test="precio&gt;75">
            <small class="rojo"><xsl:value-of select="precio"/></small>
          </xsl:when>
          <xsl:when test="precio&lt;25">
            <small class="azul"><xsl:value-of select="precio"/></small>
          </xsl:when>
          <xsl:otherwise>
            <small><xsl:value-of select="precio"/></small>
          </xsl:otherwise>
        </xsl:choose>
        <br/><br/>
      </xsl:for-each>
      </div>
      <br></br>
      
      
      <h1>Ejercicio 4</h1>
      <table>
      <th>Nombre</th><th>Símbolo</th>
        <xsl:for-each select="//empresa">
          <tr>
            <xsl:choose>
              <xsl:when test="@indice='general'">
              <td>**<xsl:value-of select="nombre"/></td>
              </xsl:when>
              <xsl:otherwise>
                <td><xsl:value-of select="nombre"/></td>
              </xsl:otherwise>
           </xsl:choose>
           <td><xsl:value-of select="simbolo"/></td>
          </tr>
        </xsl:for-each>
      </table>
      <br></br>
      <b><i>**Empresa perteneciente al indice general</i></b>
      
      
      
      
      
      <br/><br/>
  </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
