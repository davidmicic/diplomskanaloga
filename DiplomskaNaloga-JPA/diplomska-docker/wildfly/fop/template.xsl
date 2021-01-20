<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
<xsl:template match="diplomskaDela">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" font-family="Roboto">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
          <fo:block font-size="10pt">
     <fo:table table-layout="fixed" width="100%" border="1px solid black"> 
            <fo:table-header border-collapse="collapse">
              <fo:table-cell border="1px solid black">
                <fo:block>
                  #
                </fo:block>
            </fo:table-cell>  
             <fo:table-cell border="1px solid black">
                <fo:block>
                  ime
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell border="1px solid black">
                <fo:block>
                  profesor
                </fo:block>
            </fo:table-cell>  
             <fo:table-cell border="1px solid black">
                <fo:block>
                  zavod
                </fo:block>
            </fo:table-cell> 
            <fo:table-cell border="1px solid black">
                <fo:block>
                  vrsta studija
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell border="1px solid black" width="120px">
                <fo:block>
                  naslov
                </fo:block>
            </fo:table-cell>  
            <fo:table-cell border="1px solid black">
                <fo:block>
                  datum
                </fo:block>
            </fo:table-cell> 
            <fo:table-cell border="1px solid black">
                <fo:block>
                  program
                </fo:block>
            </fo:table-cell>  
            </fo:table-header>
            <fo:table-body>
                <xsl:apply-templates select="diplomskoDelo"/>
            </fo:table-body>
            </fo:table>
          </fo:block>
        </fo:flow>
      </fo:page-sequence>
     </fo:root>
</xsl:template>

   <xsl:template match="diplomskoDelo">
    <fo:table-row border="1px solid black">   
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="id"/>
        </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="dijak"/>
        </fo:block>
      </fo:table-cell>   
       <fo:table-cell>
        <fo:block>
          <xsl:value-of select="profesor"/>
        </fo:block>
      </fo:table-cell>   
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="zavod"/>
        </fo:block>
      </fo:table-cell>
       <fo:table-cell>
        <fo:block>
          <xsl:value-of select="vrstaStudija"/>
        </fo:block>
      </fo:table-cell>  
       <fo:table-cell width="120px">
        <fo:block>
          <xsl:value-of select="naslov"/>
        </fo:block>
      </fo:table-cell>    
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="datum"/>
        </fo:block>
      </fo:table-cell>    
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="program"/>
        </fo:block>
      </fo:table-cell> 
    </fo:table-row>
  </xsl:template>
</xsl:stylesheet>