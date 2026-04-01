==================================================
ORACLE PROVIDERS FOR ASP.NET 11.2.0.1.0 Production
==================================================

 Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved. 

This document provides information that supplements the Oracle Providers 
for ASP.NET Production documentation.


===============
IMPORTANT NOTES
===============

Oracle providers for ASP.NET support .NET Framework 2.0 and higher.


============================
INSTALLATION AND SETUP NOTES
============================

1. Product Dependencies

Oracle Providers for ASP.NET requires Oracle Client 11.2.0.1.0 or Oracle 
Instant Client 11.2.0.1.0.  When installing a new Oracle Providers for ASP.NET 
11.2.0.1.0 instance, Oracle Universal Installer (OUI) will automatically 
install Oracle Instant Client 11.2.0.1.0.


2. Policy DLLs

Note that the installation of this product places policy DLLS into the GAC so 
that existing applications can start using newly installed version of this 
product immediately after installation.  However, if this is not desired, be 
sure to remove the policy DLLs from the GAC.

3. Oracle Providers for ASP.NET 11.2.0.1.0 - Database Set Up

Before using Oracle Providers for ASP.NET 11.2.0.1.0, execute the database
SQL scripts that were part of the installation.  Note that Oracle Providers for 
ASP.NET ships with InstallAllOracleASPNETProviders.sql which will create all 
the database objects for all the providers.  If you already have an older version 
of Oracle Providers for ASP.NET installed, the execution of 
InstallAllOracleASPNETProviders.sql will update the stored procedures and column 
definitions, but tables will not be dropped nor re-created.


==================================
TIPS, LIMITATIONS AND KNOWN ISSUES
==================================

1. If the HKEY_LOCAL_MACHINE\Software\Oracle\NLS_LANG registry entry is 
   set to "NA", ORA-12705 errors will be encountered when using Oracle 
   Providers for ASP.NET.  To eliminate this problem, remove the 
   HKEY_LOCAL_MACHINE\Software\Oracle\NLS_LANG registry entry.

================================
AUTOMATIC MACHINE.CONFIG CHANGES
================================

After the installation of Oracle Providers for ASP.NET, 
%windir%\Microsoft.NET\Framework\v2.0.50727\CONFIG\machine.config
file will be updated to make the system aware of the ASP.NET providers
that were installed.  In addition, a connection string alias of 
"OraAspNetConString" is added, which is referenced by each of the Oracle 
Providers for ASP.NET.  Below are typical entries that will be made in the 
machine.config after the install.

(NOTE: You do not need to make these entries in the machine.config.  
 This is for your information only.)

(NOTE: "..." are place holders for existing entries in the machine.config.)

<configuration>
  ...
  <connectionStrings>
    ...
    <add name="OraAspNetConString" providerName="Oracle.DataAccess.Client" connectionString=" " />
  </connectionStrings>
  ...
  <system.web>
    ...
    <membership>
      <providers>
        <add name="OracleMembershipProvider" type="Oracle.Web.Security.OracleMembershipProvider, Oracle.Web, Version=2.112.1.0, Culture=neutral, PublicKeyToken=89b483f429c47342" connectionStringName="OraAspNetConString" applicationName="" enablePasswordRetrieval="false" enablePasswordReset="true" requiresQuestionAndAnswer="true" requiresUniqueEmail="false" passwordFormat="Hashed" maxInvalidPasswordAttempts="5" minRequiredPasswordLength="7" minRequiredNonalphanumericCharacters="1" passwordAttemptWindow="10" passwordStrengthRegularExpression="" />
        ...
      </providers>
    </membership>
    ...
  </system.web>
  ...
</configuration>

The above example shows just an entry for the Oracle Membership Provider.  
There will be similar entries for other providers.


=====================
QUICK SETUP REFERENCE
=====================

Please refer to the instructions at

http://download.oracle.com/docs/cd/E11882_01/appdev.112/e10767/installation.htm

for details.
