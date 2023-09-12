<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/libros">
    <html>

      <head>
        <link rel="stylesheet" type="text/css" href="Boletin34.css"/>
      </head>
      
      
      <body>
        <h1>Mis Libros (1)</h1>
        <xsl:for-each select="//libro">
          <b>Titulo: </b><xsl:value-of select="titulo"/>
          <br></br>
          <b>Autor: </b><xsl:value-of select="autor"/>
          <br></br><br/>
        </xsl:for-each>      
      
        <h1>Mis Libros (2)</h1>
        <p>El numero de libros es de <xsl:value-of select="count(libro)"/></p>
        <br></br>
      
        <h1>Mis libros (3)</h1>
        <ul>
         <xsl:for-each select="//libro">
           <xsl:sort select="titulo"/>
            <li><xsl:value-of select ="titulo"/></li>
          </xsl:for-each>
        </ul>
        <br></br><br></br>
        
        <h1>Mis libros (4)</h1>
        <table>
        <tr><th>TITULO</th><th>AUTOR</th><th>ISBN</th><th>PRECIO</th></tr>
          <xsl:for-each select="//libro">
            <tr><td><xsl:value-of select="titulo"/></td><td><xsl:value-of select="autor"/></td><td><xsl:value-of select="isbn"/></td><td><xsl:value-of select="precio"/></td></tr>
          </xsl:for-each>
        </table>
         <br></br><br></br>
        
        <h1>Mis libros (5)</h1>
        <ul>
        <xsl:for-each select="//libro[precio>30]">
          <li><xsl:value-of select="titulo"/></li>
        </xsl:for-each>
        </ul>
        <br></br><br></br>
        
        <h1>Mis libros (6)</h1>
        <select>
          <xsl:for-each select="//libro">
          <option><xsl:value-of select="titulo"/></option>
          </xsl:for-each>
        </select>
      </body>
    </html>
  
  </xsl:template>
</xsl:stylesheet>
