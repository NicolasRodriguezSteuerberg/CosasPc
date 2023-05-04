<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/libros">
    <html>
    
    <head>
      <meta charset="UTF-8"/>
      <link rel="stylesheet" type="text/css" href="Boletin36.css"/>
    </head>
    
    <body>
      
      <h3>Mi Blibioteca a)</h3>
      <xsl:for-each select="//libro">
        <p>
          <strong>Titulo: </strong>
          <xsl:value-of select="titulo"/><br/>
          <strong>Autor: </strong>
          <xsl:value-of select="autor"/>
        </p>
      </xsl:for-each><br/><br/>
      
      
      <h3>Mi Blibioteca b)</h3>
      <xsl:for-each select="//libro">
      <xsl:sort select="titulo"/>
        <p>
          <strong>Titulo: </strong>
          <xsl:value-of select="titulo"/><br/>
          <strong>Autor: </strong>
          <xsl:value-of select="autor"/>
        </p>
      </xsl:for-each><br/><br/>
      
      
      <h3>Mi Blibioteca c)</h3>
      <xsl:for-each select="//libro[precio>30]">
        <p>
          <strong>Titulo: </strong>
          <xsl:value-of select="titulo"/><br/>
          <strong>Autor: </strong>
          <xsl:value-of select="autor"/><br/>
          <strong>Precio: </strong>
          <xsl:value-of select="precio"/>
        </p>
      </xsl:for-each><br/><br/>
      
      
      <h3>Mi Blibioteca d)</h3>
      <select>
        <xsl:for-each select="//libro">
          <option><xsl:value-of select="titulo"/></option> 
        </xsl:for-each>
      </select>
      <br/><br/>
      
      
      <h3>Mi Blibioteca e)</h3>
      <xsl:for-each select="//libro">
        <ul>
          <li><xsl:value-of select="titulo"/></li>
          <li><xsl:value-of select="autor"/></li>
        </ul>
      </xsl:for-each><br/><br/>
      
      
      <h3>Mi Blibioteca f)</h3>
      <table>
        <tr><th>Título</th> <th>Isbn</th></tr>
        <xsl:for-each select="//libro">
          <tr><td><xsl:value-of select="titulo"/></td> <td><xsl:value-of select="isbn"/></td></tr>
        </xsl:for-each>
      </table><br/><br/>
      
      
      <h3>Mi Blibioteca g)</h3>
      <table>
        <tr><th>Título</th> <th>Autor</th> <th>Isbn</th> <th>Precio</th> </tr>
        <xsl:for-each select="//libro">
          <tr><td><xsl:value-of select="titulo"/></td> <td><xsl:value-of select ="autor"/></td> <td><xsl:value-of select="isbn"/></td> <td><xsl:value-of select ="precio"/></td></tr>
        </xsl:for-each>
      </table>
      <p><strong>El número de libros es= </strong><xsl:value-of select="count (//libro)"/></p><br/><br/>
      
      
      <h3>Mi Blibioteca h)</h3>
      <table>
        <xsl:for-each select="//libro">
          <xsl:choose>
            <xsl:when test="precio &gt;30">
                          <tr><td><xsl:value-of select="titulo"/></td> <td><xsl:value-of select ="autor"/></td> <td><xsl:value-of select="isbn"/></td> <td id="rojo"><xsl:value-of select ="precio"/></td></tr>
            </xsl:when>
            <xsl:otherwise>
                        <tr><td><xsl:value-of select="titulo"/></td> <td><xsl:value-of select ="autor"/></td> <td><xsl:value-of select="isbn"/></td> <td><xsl:value-of select ="precio"/></td></tr>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:for-each>
      </table>
      <p><strong>La media de los precios = </strong><xsl:value-of select="sum (//precio) div count(//libro)"/></p><br/><br/>
      
      
      
      
      
      
      
      
      
      
      
    </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
