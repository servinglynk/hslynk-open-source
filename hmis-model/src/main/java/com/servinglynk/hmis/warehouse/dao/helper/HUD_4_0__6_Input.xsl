<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0" 
				xmlns:hmis="http://www.hudhdx.info/Resources/Vendors/4_0/HUD_HMIS.xsd" 
				xmlns:vc="http://www.w3.org/2007/XMLSchema-versioning">

<xsl:output method="xml" indent="yes" omit-xml-declaration="no" />

<xsl:variable name='newline'><xsl:text>
</xsl:text></xsl:variable>
<xsl:strip-space elements="*"/>
 <xsl:template match="node()|@*">
     <xsl:copy>
       <xsl:apply-templates select="node()|@*"/>
     </xsl:copy>
 </xsl:template>

  <xsl:template match="node()|@*" mode="mPass2">
     <xsl:copy>
       <xsl:apply-templates select="node()|@*" mode="mPass2"/>
     </xsl:copy>
 </xsl:template>
   <xsl:template match="/*" mode="mPass2">
  <xsl:copy>
    <xsl:copy-of select="@*"/>
    <xsl:apply-templates mode="mPass2"/>
  </xsl:copy>
 </xsl:template>
 
   <xsl:template match="//hmis:DOB" mode="mPass2">
       <!--  <xsl:value-of select="concat(substring(., 1, 4), '-', substring(., 6, 2), '-','01')"/> -->
       <xsl:value-of select="2"/>
    </xsl:template>
    
  <xsl:template match="Column[@SourceColumn='hmis:FirstName']|hmis:FirstName" />
  <xsl:template match="Column[@SourceColumn='hmis:MiddleName']|hmis:MiddleName" />
  <xsl:template match="Column[@SourceColumn='hmis:LastName']|hmis:LastName" />
  <xsl:template match="Column[@SourceColumn='hmis:SSN']|hmis:SSN" />
  

 
</xsl:stylesheet>