<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0" 
				xmlns:hmis="http://www.hudhdx.info/Resources/Vendors/4_0/HUD_HMIS.xsd" 
				xmlns:vc="http://www.w3.org/2007/XMLSchema-versioning">
  
<xsl:output method="xml" version="2.0" encoding="UTF-8" indent="yes"/>
<!--<xsl:strip-space elements="*"/>-->
<xsl:variable name='newline'><xsl:text>
</xsl:text></xsl:variable>

 <xsl:template match="/hmis:Sources/hmis:Source/hmis:Export/hmis:Client">
 	<xsl:value-of select="concat('Personal ID ',': ',hmis:PersonalID,$newline )"/>
 	<xsl:value-of select="concat('Name Data Quality ',': ',hmis:NameDataQuality,$newline  )"/>
 	<xsl:value-of select="concat('SSN Data Quality ',': ',hmis:SSNDataQuality,$newline )"/>
 	<xsl:value-of select="concat('DOB ',': ',hmis:DOB,$newline )"/>
 	<xsl:value-of select="concat('DOB Data Quality ',': ',hmis:DOBDataQuality,$newline )"/>
 	<xsl:value-of select="concat('Gender ',': ',hmis:Gender,$newline )"/>
 	<xsl:value-of select="concat('Ethnicity ',': ',hmis:Ethnicity,$newline )"/>
 	<xsl:value-of select="concat('Race ',': ',hmis:Race,$newline )"/>
 	<xsl:value-of select="concat('Veteran Status ',': ',hmis:VeteranStatus,$newline )"/>
 </xsl:template>
 
 <xsl:template match="/hmis:Sources/hmis:Source/hmis:Export[not(hmis:Enrollment)]">
 	<xsl:value-of select="."/>
 	
 </xsl:template>
 
	
</xsl:stylesheet>