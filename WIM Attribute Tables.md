**ATTRIBUTE TABLES**

**Sewer Service Area**

* System\_Name \- System Name  
  * Wastewater system name  
*  System\_Owner \- System Owner  
  * Wastewater system owner  
* TownID \- TownID  
  * Town identifier  
* Treatment\_Facility \- Treatment Facility  
  * Treatment Facility name  
* GIS\_Notes \- GIS Notes  
  * Notes about data  
* GIS\_Date \- GIS Date  
  * When the GIS data was originally created  
* GIS\_Update \- GIS Update  
  * When the data was last updated  
* Creator \- Creator  
  * Default to VTANR  
  * Change to VERSO if we create new data

**Wastewater Infrastructure (Linear Features)**

* Type \- Type  
  * Stormline, sanitary, combined sewer, etc  
* Status \- Status  
  * Existing, Proposed, Abandoned   
* Comment \- Comment  
  * Comment on the data  
* Source \- Source  
  * where data was obtained from  
* MapDate \- Map Date  
  * Date of map where data originates  
* Audience \- Audience  
  * Public, private  
* System Type \- System Type  
  * Type of water system   
* Creator \- Creator  
  * Default to VTANR  
  * Change to VERSO if we create new data

**Wastewater Infrastructure (Point Features)**

* Type \- Type  
  * Sanitary Manhole, Stormwater Manhole, Combined Sewer Manhole, CSO Outflow, etc  
* Status \- Status  
  * Existing, Proposed, Abandoned  
* Comment \- Comment  
  * Comment on the data  
* Source \- Source  
  * where data was obtained from  
* MapDate \- Map Date  
  * Date of map where data originates  
* SystemType \- System Type  
  * Type of water system  
* Creator \- Creator  
  * Default to VTANR  
  * Change to VERSO if we create new data

**Wastewater Facilities** 

* FacilityName \- Facility Name  
  * Name of facility  
* DesignHydraulicCapacityInMGD \- Design Hydraulic Capacity In MGD  
  * Amount of water the facility can process in a year  
* SeptageReceivedAtThisFacility \- Septage Received At This Facility  
  * Does this facility receive septage?  
    * Yes or no  
* PermitID \- PermitID  
* PermitRecordID \- Permit Record ID  
* PermitteeName \- Permittee Name  
  * Name of town served  
* ProgramCategory \- Program Category  
  * Municipal, industrial, or pretreatment  
* NPDESPermitNumber \- NPDES Permit Number  
* PermitLink \- Permit Link \-   
  * Link to permit  
    * If municipal or industrial, can be found [here](https://anrweb.vt.gov/DEC/IWIS/ReportViewer2.aspx?Report=WWActiveNPDESPermits&ViewParms=False)  
    * If pretreatment, can be found [here](https://anrweb.vt.gov/DEC/IWIS/ReportViewer2.aspx?Report=WWActivePretreatmentPermits&ViewParms=False)

**Town Boundary**

* GEOID \- GEOID  
* NAME \- Name  
  * Name of town  
* NAMELSAD \- Name LSAD  
* LSAD \- LSAD  
* MunicipalWastewater \- Municipal Wastewater   
  * Does the town have a municipal wastewater system?  
    * Yes, No, or In Progress (in progress means there is no current system, but they are in the process of implementing one)

**Onsite Sewage Disposal Soil Ratings**

* Rating \- Rating  
  * Well Suited  
  * Moderately Suited  
  * Marginally Suited  
  * Not Suited   
  * Not Rated

