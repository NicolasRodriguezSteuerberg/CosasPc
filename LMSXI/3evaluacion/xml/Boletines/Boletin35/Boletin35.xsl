<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/horario">
    <html>
    <body>
    
    <h3>1ºEjercicio</h3>
    <xsl:for-each select="//dia">
      <p>El numero de día es<xsl:value-of select="numdia"/><br/></p>
    </xsl:for-each>
    <br></br><br></br>
    
    <h3>2ºEjercicio</h3>
    <b>Tareas a partir del miércoles:</b><br/>
    <xsl:for-each select="//dia[numdia>2]">
      <xsl:for-each select="tarea">
        <xsl:value-of select="nombre"/><br/>
      </xsl:for-each>
    </xsl:for-each>
    <br></br><br></br>
    
    <h3>3ºEjercicio</h3>
    <xsl:for-each select="//dia">
      <p>Numero de día: <xsl:value-of select="numdia"/>
      <br></br><blockquote>
        <xsl:for-each select="tarea">
        Nombre: <xsl:value-of select="nombre"/>
        <br></br>
        <blockquote>Prioridad de tarea: 
          <xsl:value-of select="@prioridad"/><br></br>
            <blockquote>Inicio: <xsl:value-of select="hora-ini"/><br></br>
              Fin: <xsl:value-of select="hora-fin"/>
            </blockquote>
          </blockquote>
        </xsl:for-each>
      </blockquote>
      </p>
    </xsl:for-each>
    <br></br><br></br>
    
    <h3>4ºEjercicio</h3>
    <b>Horario ordenado</b><br/>
    <xsl:for-each select="/horario">
      <xsl:for-each select="dia">
      <xsl:sort select="numdia"/>
        <p><xsl:value-of select="numdia"/><br></br>
        <xsl:for-each select="tarea">
          <blockquote><xsl:value-of select="hora-ini"/> -
            <xsl:value-of select="hora-fin"/> : 
            <strong><xsl:value-of select="nombre"/></strong> -> prioridad: 
           <xsl:value-of select="@prioridad"/>
          </blockquote>
        </xsl:for-each>
        </p>
      </xsl:for-each>
    </xsl:for-each>
    <br></br><br></br>
    
    
    <h3>5ºEjercicio</h3>
    <b>No sacar prioridad</b><br/>
    <xsl:for-each select="/horario">
      <xsl:for-each select="dia">
      <xsl:sort select="numdia"/>
        <p><xsl:value-of select="numdia"/><br></br>
        <xsl:for-each select="tarea">
          <blockquote><xsl:value-of select="hora-ini"/> -
            <xsl:value-of select="hora-fin"/> : 
            <strong><xsl:value-of select="nombre"/></strong>
            
            <xsl:choose>
              <xsl:when test="@prioridad">
                -> prioridad <xsl:value-of select="@prioridad"/>
              </xsl:when>
            </xsl:choose>
            
          </blockquote>
        </xsl:for-each>
        </p>
      </xsl:for-each>
    </xsl:for-each>
    <br></br><br></br>
    
    <h3>6ºEjercicio</h3>
    <b>Lista tareas si son mañana, mediodia o tarde</b>
    <xsl:for-each select="//tarea">
      <p>
        <strong><xsl:value-of select="nombre"/></strong>
         <xsl:choose>
          <xsl:when test="hora-fin &lt;12">
            -> Por la mañana
          </xsl:when>
          <xsl:when test="hora-fin = 14">
            -> Por el mediodia
          </xsl:when>
          <xsl:otherwise>
            -> Por la tarde
          </xsl:otherwise>
         </xsl:choose>
      </p>
    </xsl:for-each>
    
    
    </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
